package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dashboard extends BaseClass {

    // Define a generic wait duration
    private WebDriverWait wait;

    @When("User Navigate The {string} and {string} Stock")
    public void user_navigate_the_and_stock(String string, String string2) throws InterruptedException, AWTException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        switch (string) {

        case "BSE":

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open()");

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get("https://www.bseindia.com/");

            Thread.sleep(2000);
            try {
                // Replaced Thread.sleep with Wait for popup close button
                WebElement closePopUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn-close'])[1]")));
                closePopUp.click();
            } catch (TimeoutException e) {
                System.out.println("Not visiable Close PopUp");
            }

            Thread.sleep(1000);
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Security Name / Code / ID / ISIN']")));
            searchBox.click();
            searchBox.sendKeys(string2);

            Actions d=new Actions(driver);
            Thread.sleep(1000);
            WebElement element = driver.findElement(By.xpath("(//a[text()='Reliance Industries Ltd'])[1]"));

            d.doubleClick(element).perform();
            
            
            try {
                // Wait for popup again if it appears after search
                WebElement closePopUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn-close'])[1]")));
                closePopUp.click();
            } catch (TimeoutException e) {
                System.out.println("Not visiable Close PopUp");
            }

            break;

        case "NSE":

            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.open()");

            ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            driver.get("https://www.nseindia.com/get-quotes/equity?symbol=" + string2 + "");

            break;

        case "MCX":

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            JavascriptExecutor js11 = (JavascriptExecutor) driver;
            js11.executeScript("window.open()");

            ArrayList<String> tabs11 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs11.get(1));
            driver.get("https://www.mcxindia.com/");

            try {
                // Wait for ad close button
                WebElement closeAd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='close_apply_now']//child::img)[2]")));
                closeAd.click();
            } catch (TimeoutException e) {
                System.out.println("Not Visiable Adds Page");
            }

            WebElement marketData = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='market data']//parent::li)[1]")));
            marketData.click();

            WebElement firstLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='min200 rel noindex']//descendant::a)[1]")));
            firstLink.click();

            WebElement instrumentDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='ddlInstrumentName']")));
            Select d1 = new Select(instrumentDropdown);
            d1.selectByVisibleText("FUTCOM");

            WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='rcbInput radPreventDecorate'])[2]")));
            element1.click();

            WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='" + string2 + "'])[1]")));
            element2.click();

            WebElement showBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Show']")));
            showBtn.click();

            break;

        default:
            System.out.println("Invalid Your Condition");
            break;
        }
    }

    @When("User Search any {string} Script by {string}")
    public void user_search_any_script_by(String string, String string2) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement inputId = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='project-id']")));
        inputId.sendKeys(string);

        if (string2.equals("MCX")) {
        	
        	try {
				
        		 WebElement futuresTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Futures'])[2]")));
                 futuresTab.click();
			} catch (Exception e) {
				
				 WebElement futuresTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Futures'])[1]")));
		            futuresTab.click();
			}
           
        }

        Thread.sleep(2000);
        WebElement scriptElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'" + string + "')]//following-sibling::span[text()='" + string2 + "'])[1]")));
        scriptElement.click();

        WebElement element2 = driver.findElement(By.xpath("(//div[@class='g_item']//child::div)[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element2);
    }

    @When("User Verify The {string} Market Depth Options {string} Value")
    public void user_verify_the_market_depth_options_value(String string, String string2) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        switch (string) {
        case "BSE":

           

            if (string2.equals("Today Open")) {
            	
            	 ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window.get(0));

                 // Wait for the element to be visible
                 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='open_price']")));
                 String text = element.getText();
                 double a = Double.parseDouble(text);
                 System.out.println("Navia Value :-" + string2 + " : " + text);

                 ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window1.get(1));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card-conatiner']//tbody/tr[2]/td[2])[1]")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.-]", "");
                System.out.println("BSE Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (a == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equals("Yesterday close")) {
            	
            	 ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window.get(0));

                 // Wait for the element to be visible
                 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='close_price']")));
                 String text = element.getText();
                 double a = Double.parseDouble(text);
                 System.out.println("Navia Value :-" + string2 + " : " + text);

                 ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window1.get(1));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card-conatiner']//tbody/tr[1]/td[2])[1]")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.-]", "");
                System.out.println("BSE Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (a == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        case "NSE":

            
            if (string2.equals("Today Open")) {
            	
            	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                ArrayList<String> window2 = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(window2.get(0));

                WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='open_price']")));
                String text1 = element1.getText();
                double a1 = Double.parseDouble(text1);
                System.out.println("Navia Value :-" + string2 + " : " + text1);

                ArrayList<String> window3 = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(window3.get(1));


                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Open']//following-sibling::div")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.-]", "");
                System.out.println("NSE Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (a1 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equals("Yesterday close")) {
            	
            	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                ArrayList<String> window2 = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(window2.get(0));

                WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='close_price']")));
                String text1 = element1.getText();
                double a1 = Double.parseDouble(text1);
                System.out.println("Navia Value :-" + string2 + " : " + text1);

                ArrayList<String> window3 = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(window3.get(1));


                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Prev. Close']//following-sibling::div")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.,-]", "");
                System.out.println("NSE Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (a1 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        case "MCX":

           

            if (string2.equals("Today Open")) {
            	
            	 ArrayList<String> window21 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window21.get(0));

                 WebElement element11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='open_price']")));
                 String text11 = element11.getText();

                 WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dh_sym']")));
                 String text3 = element2.getText();
                 System.out.println(text3);
                
                 String fg = text3.substring(10, 13);
                 String substring = fg.toUpperCase();
                 
                 double a11 = Double.parseDouble(text11);
                 System.out.println("Navia Value :-" + string2 + " : " + text11);

                 ArrayList<String> window31 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window31.get(1));

                System.out.println("Current Feature Month : " + substring);

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='markt marketwatch-table']//tbody//td[contains(text(),'" + substring + "')]//following-sibling::td[4])[1]")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.,-]", "");
                System.out.println("MCX Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (a11 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equals("Yesterday close")) {
            	
            	 ArrayList<String> window21 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window21.get(0));

                 WebElement element11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='close_price']")));
                 String text11 = element11.getText();

                 WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dh_sym']")));
                 String text3 = element2.getText();
                // System.out.println(text3);
                 String fg = text3.substring(10, 13);
                 String substring = fg.toUpperCase();
                 
                 double a11 = Double.parseDouble(text11);
                 System.out.println("Navia Value :-" + string2 + " : " + text11);

                 ArrayList<String> window31 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window31.get(1));

                System.out.println("Current Feature Month : " + substring);

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='markt marketwatch-table']//tbody//td[contains(text(),'" + substring + "')]//following-sibling::td[8])[1]")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.,-]", "");
                System.out.println("MCX Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (a11 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        case "NFO":

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            ArrayList<String> window5 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(window5.get(0));

            WebElement element7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + string2 + "']//following-sibling::div")));
            String text5 = element7.getText();
            double g = Double.parseDouble(text5);
            System.out.println("Navia Value :-" + string2 + " : " + text5);

            ArrayList<String> windowy = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windowy.get(2));

            Actions f = new Actions(driver);
            WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='data-table']/tbody/tr[1]/td[5]")));
            f.moveToElement(element3).perform();

            if (string2.equals("Today Open")) {

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='data-table']/tbody/tr[1]/td[6]")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.,-]", "");
                System.out.println("NSE Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (g == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equals("Yesterday close")) {

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='data-table']/tbody/tr[1]/td[10]")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.,-]", "");
                System.out.println("NSE Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (g == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        default:
            System.err.println("Invalid Your Condition");
            break;
        }
    }

    @When("User Verify The {string} Market Depth Options Days Range {string} Value")
    public void user_verify_the_market_depth_options_days_range_value(String string, String string2) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        switch (string) {
        case "BSE":

           
            if (string2.equalsIgnoreCase("Low")) {
            	
            	 ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window.get(0));

                 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='low_price']")));
                 String dd = element.getText();
                 String text = dd.replaceAll("[^0-9.-]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + text);
                 double a = Double.parseDouble(text);

                 ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window1.get(1));


                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card-conatiner']//tbody/tr[4]/td[2])[1]")));
                String we = table.getText();
                String text2 = we.replaceAll("[^0-9.-]", "");
                System.out.println("BSE Value :-" + string2 + " : " + text2);
                double b = Double.parseDouble(text2);

                if (a == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + text2);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equalsIgnoreCase("High")) {
            	
            	 ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window.get(0));

                 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='high_price']")));
                 String df = element.getText();
                 String text = df.replaceAll("[^0-9.-]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + text);
                 double a = Double.parseDouble(text);

                 ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window1.get(1));


                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card-conatiner']//tbody/tr[3]/td[2])[1]")));
                String df1 = table.getText();
                String text2 = df1.replaceAll("[^0-9.-]", "");
                System.out.println("BSE Value :-" + string2 + " : " + text2);
                double b = Double.parseDouble(text2);

                if (a == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + text2);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        case "NSE":

           
            if (string2.equalsIgnoreCase("Low")) {
            	
            	 ArrayList<String> window2 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window2.get(0));

                 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='low_price']")));
                 String df = element1.getText();
                 String text1 = df.replaceAll("[^0-9.-]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + text1);
                 double a1 = Double.parseDouble(text1);

                 ArrayList<String> window3 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window3.get(1));


                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Low ']//following-sibling::div")));
                String dff = table.getText();
                String text2 = dff.replaceAll("[^0-9.-]", "");
                System.out.println("NSE Value :-" + string2 + " : " + text2);
                double b = Double.parseDouble(text2);

                if (a1 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + text2);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equalsIgnoreCase("High")) {
            	
            	 ArrayList<String> window2 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window2.get(0));

                 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='high_price']")));
                 String df = element1.getText();
                 String text1 = df.replaceAll("[^0-9.-]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + text1);
                 double a1 = Double.parseDouble(text1);

                 ArrayList<String> window3 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window3.get(1));


                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='High ']//following-sibling::div")));
                String gh = table.getText();
                String text2 = gh.replaceAll("[^0-9.-]", "");
                System.out.println("NSE Value :-" + string2 + " : " + text2);
                double b = Double.parseDouble(text2);

                if (a1 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + text2);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        case "MCX":

          

            if (string2.equalsIgnoreCase("Low")) {
            	
            	  ArrayList<String> window21 = new ArrayList<>(driver.getWindowHandles());
                  driver.switchTo().window(window21.get(0));

                  WebElement element11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='low_price']")));
                  String df = element11.getText();
                  String text11 = df.replaceAll("[^0-9.-]", "");
                  System.out.println("Navia Value :-" + string2 + " : " + text11);
                  double a11 = Double.parseDouble(text11);

                  WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dh_sym']")));
                  String text3 = element2.getText();
                  String fg = text3.substring(10, 13);
                  String substring = fg.toUpperCase();

                  ArrayList<String> window31 = new ArrayList<>(driver.getWindowHandles());
                  driver.switchTo().window(window31.get(1));

                System.out.println("Current Feature Month : " + substring);

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='markt marketwatch-table']//tbody//td[contains(text(),'" + substring + "')]//following-sibling::td[5]//child::div[contains(@class,'low')])[1]")));
                String dfs = table.getText();
                String text2 = dfs.replaceAll("[^0-9.-]", "");
                System.out.println("MCX Value :-" + string2 + " : " + text2);
                double b = Double.parseDouble(text2);

                if (a11 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + text2);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equalsIgnoreCase("High")) {
            	
            	  ArrayList<String> window21 = new ArrayList<>(driver.getWindowHandles());
                  driver.switchTo().window(window21.get(0));

                  WebElement element11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='high_price']")));
                  String df = element11.getText();
                  String text11 = df.replaceAll("[^0-9.-]", "");
                  System.out.println("Navia Value :-" + string2 + " : " + text11);
                  double a11 = Double.parseDouble(text11);

                  WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dh_sym']")));
                  String text3 = element2.getText();
                  String fg = text3.substring(10, 13);
                  String substring = fg.toUpperCase();

                  ArrayList<String> window31 = new ArrayList<>(driver.getWindowHandles());
                  driver.switchTo().window(window31.get(1));

                System.out.println("Current Feature Month : " + substring);

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='markt marketwatch-table']//tbody//td[contains(text(),'" + substring + "')]//following-sibling::td[7]//child::div[contains(@class,'high')])[1]")));
                String dfs = table.getText();
                String text2 = dfs.replaceAll("[^0-9.-]", "");
                System.out.println("MCX Value :-" + string2 + " : " + text2);
                double b = Double.parseDouble(text2);

                if (a11 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + text2);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        case "NFO":

           

            if (string2.equalsIgnoreCase("Low")) {
            	
            	 ArrayList<String> window5 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window5.get(0));

                 WebElement element8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='low_price']")));
                 String df = element8.getText();
                 String h = df.replaceAll("[^0-9.-]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + h);
                 double j = Double.parseDouble(h);

                 ArrayList<String> window0 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window0.get(2));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='data-table']/tbody/tr[1]/td[8]")));
                String text2 = table.getText();
                System.out.println("NSE Value :-" + string2 + " : " + text2);
                double b = Double.parseDouble(text2);

                if (j == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + text2);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equalsIgnoreCase("High")) {
            	
            	 ArrayList<String> window5 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window5.get(0));

                 WebElement element8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='high_price']")));
                 String df = element8.getText();
                 String h = df.replaceAll("[^0-9.-]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + h);
                 double j = Double.parseDouble(h);

                 ArrayList<String> window0 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window0.get(2));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='data-table']/tbody/tr[1]/td[7]")));
                String text2 = table.getText();
                System.out.println("NSE Value :-" + string2 + " : " + text2);
                double b = Double.parseDouble(text2);

                if (j == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + text2);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        default:
            System.err.println("Invalid Your Condition");
            break;
        }
    }

    @When("User Verify The {string} Market Depth Options year Range {string} Value")
    public void user_verify_the_market_depth_options_year_range_value(String string, String string2) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        switch (string) {
        case "BSE":


            if (string2.equalsIgnoreCase("Low")) {
            	

                ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(window.get(0));

                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='52_low']")));
                String df = element.getText();
                String text = df.replaceAll("[^0-9.-]", "");
                System.out.println("Navia Value :-" + string2 + " : " + text);
                double a = Double.parseDouble(text);

                ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(window1.get(1));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card-conatiner']//tbody/tr[2]/td[2])[2]")));
                String text2 = table.getText();
                String total = text2.replaceAll("[^0-9.]", "");
                System.out.println("BSE Value :-" + string2 + " : " + total);
                double b = Double.parseDouble(total);

                if (a == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equalsIgnoreCase("High")) {
            	

                ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(window.get(0));

                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='52_high']")));
                String df = element.getText();
                String text = df.replaceAll("[^0-9.-]", "");
                System.out.println("Navia Value :-" + string2 + " : " + text);
                double a = Double.parseDouble(text);

                ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(window1.get(1));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card-conatiner']//tbody/tr[1]/td[2])[2]")));
                String text2 = table.getText();
                String total = text2.replaceAll("[^0-9.]", "");
                System.out.println("BSE Value :-" + string2 + " : " + total);
                double b = Double.parseDouble(total);

                if (a == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        case "NSE":

           

            if (string2.equalsIgnoreCase("Low")) {
            	
            	 ArrayList<String> window2 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window2.get(0));

                 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='52_low']")));
                 String df = element1.getText();
                 String text1 = df.replaceAll("[^0-9.-]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + text1);
                 double a1 = Double.parseDouble(text1);

                 ArrayList<String> window4 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window4.get(1));

                 WebElement data = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Price Information')]")));

                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("window.scrollBy(0,500);");
                 js.executeScript("arguments[0].scrollIntoView(true);", data);

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='52 Week Low ']//following-sibling::div")));
                String text2 = table.getText();
                String total = text2.replaceAll("[^0-9.]", "");
                System.out.println("NSE Value :-" + string2 + " : " + total);
                double b = Double.parseDouble(total);

                if (a1 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equalsIgnoreCase("High")) {
            	
            	 ArrayList<String> window2 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window2.get(0));

                 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='52_high']")));
                 String df = element1.getText();
                 String text1 = df.replaceAll("[^0-9.-]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + text1);
                 double a1 = Double.parseDouble(text1);

                 ArrayList<String> window4 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window4.get(1));

                 WebElement data = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Price Information')]")));

                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("window.scrollBy(0,500);");
                 js.executeScript("arguments[0].scrollIntoView(true);", data);

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='52 Week High ']//following-sibling::div")));
                String text2 = table.getText();
                String total = text2.replaceAll("[^0-9.]", "");
                System.out.println("NSE Value :-" + string2 + " : " + total);
                double b = Double.parseDouble(total);

                if (a1 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        default:
            System.err.println("Invalid Your Condition");
            break;
        }
    }

    @When("User Verify The {string} Market Depth Options Daily price range {string} Value")
    public void user_verify_the_market_depth_options_daily_price_range_value(String string, String string2) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        switch (string) {
        case "BSE":

          

            if (string2.equalsIgnoreCase("Min")) {
            	
            	  ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
                  driver.switchTo().window(window.get(0));

                  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='drp_min']")));
                  String text = element.getText();
                  String tota2 = text.replaceAll("[^0-9.]", "");
                  System.out.println("Navia Value :-" + string2 + " : " + tota2);
                  double a = Double.parseDouble(tota2);

                  ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
                  driver.switchTo().window(window1.get(1));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card-conatiner']//tbody/tr[4]/td[2])[2]")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.]", "");
                System.out.println("BSE Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (a == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equalsIgnoreCase("Max")) {
            	
            	  ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
                  driver.switchTo().window(window.get(0));

                  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='drp_max']")));
                  String text = element.getText();
                  String tota2 = text.replaceAll("[^0-9.]", "");
                  System.out.println("Navia Value :-" + string2 + " : " + tota2);
                  double a = Double.parseDouble(tota2);

                  ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
                  driver.switchTo().window(window1.get(1));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card-conatiner']//tbody/tr[3]/td[2])[2]")));
                String text2 = table.getText();
                String total = text2.replaceAll("[^0-9.]", "");
                System.out.println("BSE Value :-" + string2 + " : " + total);
                double b = Double.parseDouble(total);

                if (a == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total);
                } else {
                    System.err.println("Values are Not equal");
                }
            } else {
                System.err.println("Invalid");
            }

            break;

        case "NSE":

           

            if (string2.equalsIgnoreCase("Min")) {
            	
            	 ArrayList<String> window2 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window2.get(0));

                 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='drp_min']")));
                 String text1 = element1.getText();
                 String tota21 = text1.replaceAll("[^0-9.]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + tota21);
                 double a1 = Double.parseDouble(tota21);

                 ArrayList<String> window11 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window11.get(1));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Lower Band']//following-sibling::div")));
                String text2 = table.getText();
                String total1 = text2.replaceAll("[^0-9.]", "");
                System.out.println("NSE Value :-" + string2 + " : " + total1);
                double b = Double.parseDouble(total1);

                if (a1 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total1);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else if (string2.equalsIgnoreCase("Max")) {
            	
            	 ArrayList<String> window2 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window2.get(0));

                 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='drp_max']")));
                 String text1 = element1.getText();
                 String tota21 = text1.replaceAll("[^0-9.]", "");
                 System.out.println("Navia Value :-" + string2 + " : " + tota21);
                 double a1 = Double.parseDouble(tota21);

                 ArrayList<String> window11 = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(window11.get(1));

                WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Upper Band']//following-sibling::div")));
                String text2 = table.getText();
                String total = text2.replaceAll("[^0-9.]", "");
                System.out.println("NSE Value :-" + string2 + " : " + total);
                double b = Double.parseDouble(total);

                if (a1 == b) {
                    String yellow = "\u001B[33m";
                    System.out.println(yellow + "Values are equal : " + total);
                } else {
                    System.err.println("Values are Not equal");
                }

            } else {
                System.err.println("Invalid");
            }

            break;

        default:
            System.err.println("Invalid Your Condition");
            break;
        }
    }

    @Then("User Close The Current Window")
    public void user_close_the_current_window() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
}