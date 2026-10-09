package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;
import com.config.TestConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyBack extends BaseClass{
	
	@Given("User is on the Buyback Login Page")
	public void user_is_on_the_buyback_login_page() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		 driver.get("https://backoffice.navia.co.in/Internal/BBLogin.aspx");
		 driver.manage().window().maximize();
	        Thread.sleep(3000);
		
		//Thread.sleep(1000);
		
	}

	@When("User enters valid UCC Number {string}")
	public void user_enters_valid_ucc_number(String string) throws InterruptedException {

		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		 WebElement clientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.name("txtUcc")));
		 clientCode.sendKeys(string);
		
		Thread.sleep(1000);
		
	}

	@When("User enters valid DOB {string}")
	public void user_enters_valid_dob(String string) throws InterruptedException, AWTException {

		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		 WebElement clientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.name("txtDOB")));
		 clientCode.sendKeys(string);
		 
		 Thread.sleep(1000);
			
		 Robot robot1 = new Robot();
		 robot1.keyPress(KeyEvent.VK_ENTER);
         robot1.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
	}

	@When("User clicks the Login button")
	public void user_clicks_the_login_button() throws InterruptedException {

		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		WebElement clientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("btnsubmit")));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("arguments[0].click();", clientCode);
		
		Thread.sleep(1000);
		
	}

	@Then("User should be successfully logged in")
	public void user_should_be_successfully_logged_in() throws InterruptedException {

		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement clientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[text()='OK']")));
		clientCode.click();
		
		String naviaWindow = driver.getWindowHandle();

        Thread.sleep(20000);

      
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(TestConfig.OTP_PROVIDER_URL);

        WebElement inbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Enter your inbox here']")));
        inbox.clear();
        inbox.sendKeys(TestConfig.OTP_MAILBOX);

        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
        Thread.sleep(5000);

        String otp = null;

        for (int i = 0; i < 8; i++) {
            try {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifmail"));

                WebElement mailBody = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='mail']//pre")));

                String text = mailBody.getText();
                Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
                Matcher matcher = pattern.matcher(text);

                if (matcher.find()) {
                    otp = matcher.group();
                    System.out.println("OTP Found: " + otp);
                    break;
                }

            } catch (Exception e) {
                System.out.println("Retrying OTP fetch... attempt " + (i + 1));
            }

            driver.switchTo().defaultContent();
            try {
                WebElement refresh = driver.findElement(By.id("refresh"));
                refresh.click();
            } catch (Exception e) {
                driver.navigate().refresh();
            }
            Thread.sleep(5000);
        }

        if (otp == null) {
            throw new RuntimeException("OTP not found after retries");
        }

        driver.switchTo().defaultContent();
        driver.close();
        driver.switchTo().window(naviaWindow);

        WebElement otpBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("txtACOTP")));
        otpBox.click();
        otpBox.sendKeys(otp);

        // STEP 10: Click login
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='btnSubmitOTP']")));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
      

		Thread.sleep(1000);
		
	}

	@Then("User should see the Buyback Dashboard")
	public void user_should_see_the_buyback_dashboard() throws InterruptedException {

		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		  

	        // STEP 11: Wait for home page — increased to 90s for headless slow render
	        // Added more fallback XPaths in case primary ones aren't present on web.navia.co.in
	        try {
	            new WebDriverWait(driver, Duration.ofSeconds(90)).until(
	                ExpectedConditions.or(
	                    ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//button[@id='current-bbo-tab']")),
	                    ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//button[@id='past-bbo-tab']")),
	                    ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//div[@class='nav-cnt mt-3 mb-3']")),
	                    ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//div[@class='tab-content table-container']"))
	                ));
	            
	            String blue = "\u001B[34m";
	            System.out.println(blue+"[INFO] Buyback successful - home page loaded.");
	            
	        } catch (Exception e) {
	        	 String red = "\u001B[31m";
	            throw new AssertionError(red+"Login did not reach the home page after OTP submission.", e);
	        }
		
		Thread.sleep(1000);
		
	}
	
	
	
	
	

}
