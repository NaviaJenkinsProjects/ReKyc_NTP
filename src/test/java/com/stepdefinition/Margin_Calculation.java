package com.stepdefinition;


import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Margin_Calculation extends BaseClass {

	@When("User Select The {string} Option button")
	public void user_select_the_option_button(String string) throws InterruptedException {

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement downArrow = driver.findElement(By.xpath("//button[@data-toggle='open_mm']"));

		Actions a = new Actions(driver);
		Thread.sleep(2000);
		a.moveToElement(downArrow).build().perform();
		Thread.sleep(2000);
		
		try {
			
			WebElement option = driver.findElement(By.xpath("(//span[text()='"+string+"'])[2]"));
			Thread.sleep(2000);
			a.moveToElement(option).perform();
			
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", option);
			
		} catch (Exception e) {
			WebElement option = driver.findElement(By.xpath("(//span[text()='"+string+"'])[3]"));
			Thread.sleep(2000);
			a.moveToElement(option).perform();
			
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", option);
		}

		//driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::a)[2]")).click();
	    Thread.sleep(2000);
		WebElement any = driver.findElement(By.xpath("(//div[@mode='right'])[3]"));
		Thread.sleep(2000);
		a.moveToElement(any).perform();

		Thread.sleep(2000);

	}

	@When("User Select The Any Stock {string} For NSE")
	public void user_select_the_any_stock_for_nse(String string) throws InterruptedException {

		Thread.sleep(3000);

		Actions a = new Actions(driver);
		WebElement stock = driver
				.findElement(By.xpath("//span[text()='" + string + "']//following-sibling::span[text()='NSE']"));
		Thread.sleep(2000);
		a.moveToElement(stock).perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//span[text()='" + string + "']//ancestor::div[@class='m_bg_color']//descendant::span[text()='B']"))
				.click();
		Thread.sleep(2000);

	}

	@When("User Verify The {string} Stock Buy Values")
	public void user_verify_the_stock_buy_values(String string) throws InterruptedException {

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));
		driver.get("https://upstox.com/calculator/span-calculator/");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='c a cn']//child::input")).sendKeys(string);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='NSE EQ']//parent::div")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Add Position']")).click();
		Thread.sleep(2000);

		WebElement margin1 = driver
				.findElement(By.xpath("(//span[text()='Req. margin']//parent::div//child::span)[2]"));
		String text1 = margin1.getText();
		Thread.sleep(2000);
		System.out.println("Upstok Stock " + string + " Margin Value is: " + text1);

		driver.switchTo().window(tabs.get(0));

		WebElement margin = driver.findElement(By.xpath("//span[text()='Margin ']//following-sibling::a"));
		String text = margin.getText();
		Thread.sleep(2000);

		System.out.println("Navia Stock " + string + " Margin Value is: " + text);

		String cleaned = text1.replace("₹", "").replace(",", "");

		double price = Double.parseDouble(cleaned);
		// Optional: Convert to int if decimal part is not needed
		int priceInt = (int) price;

		int price1 = Integer.parseInt(text.replace("₹", "").trim());
		Thread.sleep(2000);
		// Set tolerance range
		int tolerance = 2;

		Thread.sleep(1000);
		// Calculate the difference
		int difference = Math.abs(priceInt - price1);

		String blue = "\u001B[34m";
		Thread.sleep(2000);
		// Check if within tolerance
		if (difference <= tolerance) {

			System.out.println(blue + "" + string + " is Margin Value Pass");

		} else {

			System.err.println("Equity NSE is Stock Margin Faild");
		}

		Thread.sleep(2000);
		WebElement charges = driver.findElement(By.xpath("//div[text()='Charges ']//child::a"));
		String text2 = charges.getText();

		Thread.sleep(1000);
		System.out.println("Navia Stock " + string + " Charges Value is: " + text2);

		int a = Integer.parseInt(text.replace("₹", "").trim());
		Thread.sleep(2000);

		Thread.sleep(1000);
		if (a == 0) {

			System.err.println("Equity NSE is Stock Charges Faild");

		} else {

			System.out.println(blue + "" + string + " is Charges Value Pass");

		}
		Thread.sleep(1000);

		Thread.sleep(2000);
		WebElement fund = driver.findElement(By.xpath("//div[text()='Available Margin ']//child::span"));
		String text3 = fund.getText();

		Thread.sleep(1000);
		System.out.println("Navia to Available Margin is: " + text3);
//				double b = Double.parseDouble(text3.replace("₹", ""));
//				Thread.sleep(1000);
//				
//				WebElement amount = driver.findElement(By.xpath("//input[@data-dhx-id='available_invest']"));
//				String text4 = amount.getText();
//				System.out.println(text4);
//				double d = Double.parseDouble(text4.replace("₹", ""));
//				Thread.sleep(1000);
//				
//				 if (b == d ) {
//					 
//					 System.out.println(blue +"Navia Available Margin Value Pass");
//			        	
//			        } else {
//			        	
//			        	 System.err.println("Navia to Available Margin Value is Faild");
//			        	 
//			        }
		Thread.sleep(2000);

	}

	@When("User Verify The {string} Stock Sell Values")
	public void user_verify_the_stock_sell_values(String string) throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[@class='switchery switchery-small']")).click();
		Thread.sleep(2000);

		WebElement margin = driver.findElement(By.xpath("//span[text()='Margin ']//following-sibling::a"));
		String text = margin.getText();
		Thread.sleep(2000);
		System.out.println("Navia Stock " + string + " Margin Value is: " + text);

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);

		driver.navigate().refresh();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='c a cn']//child::input")).sendKeys(string);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='NSE EQ']//parent::div")).click();
		Thread.sleep(2000);

		Actions a = new Actions(driver);
		WebElement sell = driver.findElement(By.xpath("//span[text()='Sell']"));
		a.moveToElement(sell).perform();
		a.click(sell).perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Add Position']")).click();
		Thread.sleep(2000);

		WebElement margin1 = driver
				.findElement(By.xpath("(//span[text()='Req. margin']//parent::div//child::span)[2]"));
		String text1 = margin1.getText();
		Thread.sleep(2000);
		System.out.println("Upstok Stock " + string + " Margin Value is: " + text1);

		Thread.sleep(2000);
		String cleaned = text1.replace("₹", "").replace(",", "");

		double price = Double.parseDouble(cleaned);
		// Optional: Convert to int if decimal part is not needed
		int priceInt = (int) price;

		int price1 = Integer.parseInt(text.replace("₹", "").trim());
		Thread.sleep(2000);
		// Set tolerance range

		String blue = "\u001B[34m";
		Thread.sleep(2000);
		// Check if within tolerance
		if (priceInt == price1) {

			System.out.println(blue + "" + string + " is Margin Value Pass");

		} else {

			System.err.println("Equity NSE is Stock Margin Faild");
		}

		Thread.sleep(2000);
		WebElement charges = driver.findElement(By.xpath("//div[text()='Charges ']//child::a"));
		String text2 = charges.getText();

		Thread.sleep(1000);
		System.out.println("Navia Stock " + string + " Charges Value is: " + text2);

		Thread.sleep(1000);

		int b = Integer.parseInt(text.replace("₹", "").trim());
		Thread.sleep(2000);

		Thread.sleep(1000);
		if (b == 0) {

			System.err.println("Equity NSE is Stock Charges Faild");

		} else {

			System.out.println(blue + "" + string + " is Charges Value Pass");

		}
		Thread.sleep(1000);

		Thread.sleep(2000);
		WebElement fund = driver.findElement(By.xpath("//div[text()='Available Margin ']//child::span"));
		String text3 = fund.getText();

		Thread.sleep(1000);
		System.out.println("Navia to Available Margin is: " + text3);

		Thread.sleep(2000);

		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000); // Perform actions if needed

		driver.close();

		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);

	}

	@Then("User Verify The Value Details")
	public void user_verify_the_value_details() {

		System.out.println("======================================================================================");

	}

	@When("User Select The Any Stock {string} For BSE")
	public void user_select_the_any_stock_for_bse(String string) throws InterruptedException {

		Thread.sleep(3000);
		
		try {
			
			Actions a = new Actions(driver);
			WebElement stock = driver
					.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::span[text()='BSE'])[1]"));
			Thread.sleep(2000);
			a.moveToElement(stock).perform();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[text()='"+string+"']//ancestor::div[@class='m_bg_color']//descendant::span[text()='B'])[1]")).click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			
			Actions a = new Actions(driver);
			WebElement stock = driver
					.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::span[text()='BSE'])[2]"));
			Thread.sleep(2000);
			a.moveToElement(stock).perform();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[text()='"+string+"']//ancestor::div[@class='m_bg_color']//descendant::span[text()='B'])[1]")).click();
			Thread.sleep(2000);
		}

		

	}

	@When("User Click The Current {string} Future Option")
	public void user_click_the_current_future_option(String string) throws InterruptedException {

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='project-id']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
		Thread.sleep(2000);

		try {
			
			driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
			
		} catch (Exception e) {
			
			driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
		}
		Thread.sleep(2000);

	}

	@When("User Select The Current {string} Future Option")
	public void user_select_the_current_future_option(String string) throws InterruptedException {

		switch (string) {

		case "BSE":

			Thread.sleep(4000);
			Actions a = new Actions(driver);
		//WebElement stock = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='BSE'])[1]"));
			WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
			WebElement stock = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='s-box']//child::span[text()='BSE'])[1]")));
			Thread.sleep(2000);
			Thread.sleep(2000);
			a.moveToElement(stock).perform();

			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("(//div[@class='s-box']//following-sibling::div//child::span[text()='B'])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("arguments[0].click();", element);
		       
			break;

		case "NSE":

			Thread.sleep(2000);
			Actions a1 = new Actions(driver);
			//WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
			WebDriverWait wait11 = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
			WebElement stock1 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]")));
			Thread.sleep(2000);
			a1.moveToElement(stock1).perform();

			Thread.sleep(2000);
			WebElement element2 = driver.findElement(By.xpath("(//div[@class='s-box']//following-sibling::div//child::span[text()='B'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
		       js1.executeScript("arguments[0].click();", element2);
		       
			break;

		default:

			System.err.println("Invalid Condition");
			break;
		}

		Thread.sleep(2000);
	}

	@When("User Verify The Margin,Charges and Available Margin Futute {string} Values")
	public void user_verify_the_margin_charges_and_available_margin_futute_values(String string)
			throws InterruptedException {

		Thread.sleep(3000);

		switch (string) {

		case "BUY":

			WebElement margin = driver.findElement(By.xpath("//span[text()='Margin ']//following-sibling::a"));
			String text = margin.getText();
			Thread.sleep(2000);

			System.out.println("Margin Value is: " + text);
			String numericValue = text.replaceAll("[^0-9]", "");
			int price1 = Integer.parseInt(numericValue);
			Thread.sleep(2000);

			Thread.sleep(2000);
			// Check if within tolerance
			if (price1 == 0) {

				System.err.println("Stock which displays a Margin value as 0, which is a failed validation case");

			} else {
				String blue = "\u001B[34m";
				System.out.println(blue + "Margin value is correctly displayed on the screen");

			}

			Thread.sleep(2000);
			WebElement charges = driver.findElement(By.xpath("//div[text()='Charges ']//child::a"));
			String text2 = charges.getText();

			Thread.sleep(1000);
			System.out.println("Charges Value is: " + text2);
			String numericValue1 = text2.replaceAll("[^0-9]", "");
			int a = Integer.parseInt(numericValue1);
			Thread.sleep(2000);

			Thread.sleep(1000);
			if (a == 0) {

				System.err.println("Stock which displays a Charges value as 0, which is a failed validation case");

			} else {
				String blue = "\u001B[34m";
				System.out.println(blue + "Charges value is correctly displayed on the screen");

			}
			Thread.sleep(1000);

			Thread.sleep(2000);
			WebElement fund = driver.findElement(By.xpath("//div[text()='Available Margin ']//child::span"));
			String text3 = fund.getText();

			Thread.sleep(1000);
			System.out.println("Available Margin Value is: " + text3);
			
			String s = text3.replaceAll("[^0-9.-]", "");  // Now s = "148.78"

			// Step 2: Convert to double
			double priceDouble = Double.parseDouble(s);

			// Step 3: Convert to int
			int a1 = (int) priceDouble;
			

			Thread.sleep(1000);
			if (a1 == 0) {

				System.err.println("Stock which displays a Available Margin value as 0, which is a failed validation case.");

			} else {
				String blue = "\u001B[34m";
				System.out.println(blue + "Available Margin value is correctly displayed on the screen");

			}
			Thread.sleep(1000);


			break;

		case "SELL":

			driver.findElement(By.xpath("//span[@class='switchery switchery-small']")).click();
			Thread.sleep(2000);

			WebElement margin1 = driver.findElement(By.xpath("//span[text()='Margin ']//following-sibling::a"));
			String text1 = margin1.getText();
			Thread.sleep(2000);

			System.out.println("Margin Value is: " + text1);
			String numericValue11 = text1.replaceAll("[^0-9]", "");
			int price11 = Integer.parseInt(numericValue11);
			Thread.sleep(2000);

			Thread.sleep(2000);
			// Check if within tolerance
			if (price11 == 0) {

				System.err.println("Stock which displays a Margin value as 0, which is a failed validation case.");

			} else {
				String blue1 = "\u001B[34m";
				System.out.println(blue1 + "Margin value is correctly displayed on the screen");

			}

			Thread.sleep(2000);
			WebElement charges1 = driver.findElement(By.xpath("//div[text()='Charges ']//child::a"));
			String text21 = charges1.getText();

			Thread.sleep(1000);
			System.out.println("Charges Value is: " + text21);

			Thread.sleep(1000);
			String s1 = text21.replaceAll("[^0-9.-]", "");  // Now s = "148.78"

			// Step 2: Convert to double
			double priceDouble1 = Double.parseDouble(s1);

			// Step 3: Convert to int
			int a11 = (int) priceDouble1;
			Thread.sleep(2000);

			Thread.sleep(1000);
			if (a11 == 0) {

				System.err.println("Stock which displays a Charges value as 0, which is a failed validation case.");

			} else {
				String blue1 = "\u001B[34m";
				System.out.println(blue1 + "Charges value is correctly displayed on the screen");

			}
			Thread.sleep(1000);

			Thread.sleep(2000);
			WebElement fund1 = driver.findElement(By.xpath("//div[text()='Available Margin ']//child::span"));
			String text31 = fund1.getText();

			Thread.sleep(1000);
			System.out.println("Available Margin Value is: " + text31);
			
			Thread.sleep(1000);
			String s11 = text31.replaceAll("[^0-9.-]", "");  // Now s = "148.78"

			// Step 2: Convert to double
			double priceDouble11 = Double.parseDouble(s11);

			// Step 3: Convert to int
			int a2 = (int) priceDouble11;
			Thread.sleep(2000);

			Thread.sleep(1000);
			if (a2 == 0) {

				System.err.println("Stock which displays a Available Margin value as 0, which is a failed validation case.");

			} else {
				String blue1 = "\u001B[34m";
				System.out.println(blue1 + "Available Margin value is correctly displayed on the screen");

			}
			Thread.sleep(1000);

			break;

		default:

			System.err.println("Invalid Condition");

			break;
		}

		Thread.sleep(2000);

	}
	
	@When("User Click The Current {string} Options")
	public void user_click_the_current_options(String string) throws InterruptedException {
	   
		Thread.sleep(5000);
		
		switch (string) {
		
		case "Nifty 50":
			
			WebElement element = driver
			.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
	element.click();
	
	Thread.sleep(1000);
	
	//Actions a = new Actions(driver);
	
	WebElement stock = driver
			.findElement(By.xpath("//span[text()='NIFTY 50']"));
	
	stock.click();
	
//	a.moveToElement(stock).perform();
//	Thread.sleep(1000);
//	a.click(stock).perform();
	
	Thread.sleep(1000);
	
	WebElement fund = driver.findElement(By.xpath("(//span[text()='NIFTY 50']//following-sibling::div//child::span)[1]"));
	String text = fund.getText();

	Thread.sleep(1000);
	
	double doubleValue = Double.parseDouble(text);

	// Convert to integer for rounding
	int intValue = (int) doubleValue;

	// Round to nearest 50, adjusting based on the fractional part
	int roundedValue;
	if (doubleValue % 50 > 0) {
	    roundedValue = ((intValue / 50) + 1) * 50; // Round up
	} else {
	    roundedValue = (intValue / 50) * 50; // Round down or stay as is
	}
	
	String purple = "\u001B[35m";

	System.out.println(purple+"Nifty Current Strike Value: " + roundedValue);
	
	Thread.sleep(2000);

	driver.findElement(By.xpath("//input[@id='project-id']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys("Nifty");
	Thread.sleep(2000);

	try {
		
		driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
		
	} catch (Exception e) {
		
		driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
	}
	Thread.sleep(2000);
	
	Actions a1 = new Actions(driver);
	WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
	Thread.sleep(1000);
	a1.moveToElement(stock1).perform();
	Thread.sleep(1000);
	a1.click(stock1).perform();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='s_more md_btn1']")).click();
	Thread.sleep(3000);
	
	WebElement element2 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
	driver.switchTo().frame(element2);
	
	Thread.sleep(3000);
	WebElement element4 = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
	String text2 = element4.getText();
	
	
	Thread.sleep(1000);
	if (text2.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
		
	} else {
		
		System.err.println("Ready-made strategy builder Close Button Not Working");

	}
	
	
	
//	Thread.sleep(1000);
//	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ready_mode_close']")));
//	element1.click();
	
try {
		
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span)[1]")).click();
		
		
	} catch (Exception e) {
		
		Thread.sleep(1000);
		WebElement element3 = driver.findElement(By.xpath("//select[@id='symbols_list']"));
		Select d=new Select(element3);
		d.selectByVisibleText("NIFTY - NFO");
		
		Thread.sleep(1000);
		WebElement element5 = driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span)[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("arguments[0].scrollIntoView();", element5);
	       
	       Thread.sleep(1000);
	       element5.click();
		
	}
	
	
	Thread.sleep(1000);
	
	driver.switchTo().defaultContent();
	
	
	driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[1]")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//span[text()='Clear']")).click();
	Thread.sleep(1000);
	
	Actions a = new Actions(driver);
	
		WebElement stocks = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue+"')]//parent::div//child::span[text()='NFO']"));
		
		a.moveToElement(stocks).perform();
		Thread.sleep(1000);
		a.click(stocks).perform();
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='buy buyorder']"))
				.click();
			
			break;
			
      case "Sensex":
    	  Thread.sleep(1000);
    	  
    	  WebElement nifty = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX'])[1]"));
    	  String text3 = nifty.getText();
    	  System.out.println(text3);
    	  
    	  Thread.sleep(1000);
    	  if (text3.equalsIgnoreCase("S&P BSE SENSEX")) {
    		  
    		  Thread.sleep(1000);
    		  
    		  WebElement fund1 = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX']//following-sibling::div//child::span)[1]"));
      		String text1 = fund1.getText();

      		Thread.sleep(1000);
      		
      		double doubleValue1 = Double.parseDouble(text1);

      		// Convert to integer for rounding
      		int intValue1 = (int) doubleValue1;

      		// Round to nearest 50, adjusting based on the fractional part
      		int roundedValue1;
      		if (doubleValue1 % 100 > 0) {
      		    roundedValue1 = ((intValue1 / 100) + 1) * 100; // Round up
      		} else {
      		    roundedValue1 = (intValue1 / 100) * 100; // Round down or stay as is
      		}
      		
      		
      		String purple1 = "\u001B[35m";
      		

      		System.out.println(purple1+"Sensex Current Strike Value: " + roundedValue1);
      		
      		Thread.sleep(2000);

      		driver.findElement(By.xpath("//input[@id='project-id']")).click();
      		Thread.sleep(1000);
      		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys("Sensex");
      		Thread.sleep(3000);

      		try {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
				
			} catch (Exception e) {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
			}
      		Thread.sleep(2000);
      		
      		Actions a2 = new Actions(driver);
      		WebElement stock2 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='BSE'])[1]"));
      		Thread.sleep(1000);
      		a2.moveToElement(stock2).perform();
      		Thread.sleep(1000);
      		a2.click(stock2).perform();
      		
      		Thread.sleep(2000);
      		driver.findElement(By.xpath("//button[@class='s_more md_btn1']")).click();
      		Thread.sleep(3000);
      		
      		WebElement element3 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
      		driver.switchTo().frame(element3);
      		
      		Thread.sleep(3000);
      		WebElement element41 = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
      		String text12 = element41.getText();
      		
      		
      		
      		Thread.sleep(1000);
      		if (text12.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
      			
      			Thread.sleep(1000);
      			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
      			
      		} else {
      			
      			System.err.println("Ready-made strategy builder Close Button Not Working");

      		}
      		
      		Thread.sleep(1000);
      		Actions s = new Actions(driver);
      		
      		WebElement d = driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"'])[1]"));
      		
      		Thread.sleep(1000);
      		s.moveToElement(d).perform();
      		Thread.sleep(1000);
      		
      		driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"']//parent::div//child::span)[1]")).click();
      		
      		Thread.sleep(2000);
      		
      		driver.switchTo().defaultContent();
      		
      		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[1]")).click();
      		Thread.sleep(1000);
      		
      		driver.findElement(By.xpath("//span[text()='Clear']")).click();
      		Thread.sleep(1000);
      		
      		Actions a3 = new Actions(driver);
      		
      			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//parent::div//child::span[text()='BFO']"));
      			
      			a3.moveToElement(stoc).perform();
      			Thread.sleep(1000);
      			a3.click(stoc).perform();
      		
      			Thread.sleep(2000);
      			driver.findElement(By.xpath("//button[@class='buy buyorder']"))
      					.click();
    		  
			
		} else {


			WebElement element8 = driver
					.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
			element8.click();
			
			Thread.sleep(1000);
			
			//Actions a = new Actions(driver);
			
			WebElement stock111 = driver
					.findElement(By.xpath("//span[text()='S&P BSE SENSEX']"));
			
			stock111.click();
			
//			a.moveToElement(stock).perform();
//			Thread.sleep(1000);
//			a.click(stock).perform();
			
			Thread.sleep(1000);
    		
    		WebElement fund1 = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX']//following-sibling::div//child::span)[1]"));
    		String text1 = fund1.getText();

    		Thread.sleep(1000);
    		
    		double doubleValue1 = Double.parseDouble(text1);

    		// Convert to integer for rounding
    		int intValue1 = (int) doubleValue1;

    		// Round to nearest 50, adjusting based on the fractional part
    		int roundedValue1;
    		if (doubleValue1 % 100 > 0) {
    		    roundedValue1 = ((intValue1 / 100) + 1) * 100; // Round up
    		} else {
    		    roundedValue1 = (intValue1 / 100) * 100; // Round down or stay as is
    		}
    		
    		
    		String purple1 = "\u001B[35m";
    		

    		System.out.println(purple1+"Sensex Current Strike Value: " + roundedValue1);
    		
    		Thread.sleep(2000);

    		driver.findElement(By.xpath("//input[@id='project-id']")).click();
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys("Sensex");
    		Thread.sleep(3000);

    		
    		try {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
				
			} catch (Exception e) {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
			}
    		Thread.sleep(2000);
    		
    		Actions a2 = new Actions(driver);
    		WebElement stock2 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='BSE'])[1]"));
    		Thread.sleep(1000);
    		a2.moveToElement(stock2).perform();
    		Thread.sleep(1000);
    		a2.click(stock2).perform();
    		
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//button[@class='s_more md_btn1']")).click();
    		Thread.sleep(3000);
    		
    		WebElement element3 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
    		driver.switchTo().frame(element3);
    		
    		Thread.sleep(3000);
    		WebElement element41 = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
    		String text12 = element41.getText();
    		
    		
    		
    		Thread.sleep(1000);
    		if (text12.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
    			
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
    			
    		} else {
    			
    			System.err.println("Ready-made strategy builder Close Button Not Working");

    		}
    		
    		Thread.sleep(1000);
    		Actions s = new Actions(driver);
    		
    		WebElement d = driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"'])[1]"));
    		
    		Thread.sleep(1000);
    		s.moveToElement(d).perform();
    		Thread.sleep(1000);
    		
    		driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"']//parent::div//child::span)[1]")).click();
    		
    		Thread.sleep(2000);
    		
    		driver.switchTo().defaultContent();
    		
    		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[1]")).click();
    		Thread.sleep(1000);
    		
    		driver.findElement(By.xpath("//span[text()='Clear']")).click();
    		Thread.sleep(1000);
    		
    		Actions a3 = new Actions(driver);
    		
    			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//parent::div//child::span[text()='BFO']"));
    			
    			a3.moveToElement(stoc).perform();
    			Thread.sleep(1000);
    			a3.click(stoc).perform();
    		
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//button[@class='buy buyorder']")).click();
		}
			break;

		default:
			
			System.err.println("Invalid Condition");
			break;
		}

		
		
//		WebElement fund1 = driver.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::div//child::span)[1]"));
//		String text31 = fund1.getText();
//
//		Thread.sleep(1000);
//		System.out.println(text31);
		
		Thread.sleep(2000);
		
		
	}
	
	
	@When("User Verify The Margin,Charges and Available Margin Optins {string} Values")
	public void user_verify_the_margin_charges_and_available_margin_optins_values(String string) throws InterruptedException {
	   
		Thread.sleep(3000);

		switch (string) {

		case "BUY":

			WebElement margin = driver.findElement(By.xpath("//span[text()='Margin ']//following-sibling::a"));
			String text = margin.getText();
			Thread.sleep(2000);

			System.out.println("Margin Value is: " + text);
			String numericValue = text.replaceAll("[^0-9]", "");

			int price1 = Integer.parseInt(numericValue);
			Thread.sleep(2000);

			Thread.sleep(2000);
			// Check if within tolerance
			if (price1 == 0) {

				System.err.println("Stock which displays a Margin value as 0, which is a failed validation case.");

			} else {
				String blue = "\u001B[34m";
				System.out.println(blue + "Margin value is correctly displayed on the screen");

			}

			Thread.sleep(2000);
			WebElement charges = driver.findElement(By.xpath("//div[text()='Charges ']//child::a"));
			String text2 = charges.getText();

			Thread.sleep(1000);
			System.out.println("Charges Value is: " + text2);

			String s = text2.replaceAll("[^0-9.-]", "");  // Now s = "148.78"

			// Step 2: Convert to double
			double priceDoubl = Double.parseDouble(s);

			// Step 3: Convert to int
			//int a1 = (int) priceDouble;
			Thread.sleep(2000);

			Thread.sleep(1000);
			if (priceDoubl == 0) {

				System.err.println("Stock which displays a Charges value as 0, which is a failed validation case.");

			} else {
				String blue = "\u001B[34m";
				System.out.println(blue + "Charges value is correctly displayed on the screen");

			}
			Thread.sleep(1000);

			Thread.sleep(2000);
			WebElement fund = driver.findElement(By.xpath("//div[text()='Available Margin ']//child::span"));
			String text3 = fund.getText();

			Thread.sleep(1000);
			System.out.println("Available Margin Value is: " + text3);
			
			String s7 = text3.replaceAll("[^0-9.-]", "");
			
			double priceDoubl1 = Double.parseDouble(s7);

			// Step 3: Convert to int
			//int a1 = (int) priceDouble;
			Thread.sleep(2000);

			Thread.sleep(1000);
			if (priceDoubl1 == 0) {

				System.err.println("Stock which displays a Available Margin value as 0, which is a failed validation case.");

			} else {
				String blue = "\u001B[34m";
				System.out.println(blue + "Available Margin value is correctly displayed on the screen");

			}
			Thread.sleep(1000);

			break;

		case "SELL":

			driver.findElement(By.xpath("//span[@class='switchery switchery-small']")).click();
			Thread.sleep(2000);

			WebElement margin1 = driver.findElement(By.xpath("//span[text()='Margin ']//following-sibling::a"));
			String text1 = margin1.getText();
			Thread.sleep(2000);

			System.out.println("Margin Value is: " + text1);
			String numericValue1 = text1.replaceAll("[^0-9]", "");
			int price11 = Integer.parseInt(numericValue1);
			Thread.sleep(2000);

			Thread.sleep(2000);
			// Check if within tolerance
			if (price11 == 0) {

				System.err.println("Stock which displays a Margin value as 0, which is a failed validation case.");

			} else {
				String blue1 = "\u001B[34m";
				System.out.println(blue1 + "Margin value is correctly displayed on the screen");

			}

			Thread.sleep(2000);
			WebElement charges1 = driver.findElement(By.xpath("//div[text()='Charges ']//child::a"));
			String text21 = charges1.getText();

			Thread.sleep(1000);
			System.out.println("Charges Value is: " + text21);

			Thread.sleep(1000);
			String s1 = text21.replaceAll("[^0-9.-]", "");  // Now s = "148.78"

			// Step 2: Convert to double
			double priceDouble = Double.parseDouble(s1);

			// Step 3: Convert to int
			//int a1 = (int) priceDouble;
			Thread.sleep(2000);

			Thread.sleep(1000);
			if (priceDouble == 0) {

				System.err.println("Stock which displays a Charges value as 0, which is a failed validation case.");

			} else {
				String blue1 = "\u001B[34m";
				System.out.println(blue1 + "Charges value is correctly displayed on the screen");

			}
			Thread.sleep(1000);

			WebElement fund1 = driver.findElement(By.xpath("//div[text()='Available Margin ']//child::span"));
			String text31 = fund1.getText();

			Thread.sleep(1000);
			System.out.println("Available Margin Value is: " + text31);
			
			String a1 = text31.replaceAll("[^0-9.-]", "");  // Now s = "148.78"

			// Step 2: Convert to double
			double priceDouble1 = Double.parseDouble(a1);

			// Step 3: Convert to int
			//int a1 = (int) priceDouble;
			Thread.sleep(2000);

			Thread.sleep(1000);
			if (priceDouble1 == 0) {

				System.err.println("Stock which displays a Available Margin value as 0, which is a failed validation case.");

			} else {
				String blue1 = "\u001B[34m";
				System.out.println(blue1 + "Available Margin value is correctly displayed on the screen");

			}
			Thread.sleep(1000);

			break;

		default:

			System.err.println("Invalid Condition");

			break;
		}

		Thread.sleep(2000);
		
	}
	
	@When("User Delete The Stock In Watchlist")
	public void user_delete_the_stock_in_watchlist() throws InterruptedException {
	    
		Thread.sleep(2000);
		
		 driver.findElement(By.xpath("(//button[@data-dhx-id='close'])[2]")).click();
		 Thread.sleep(1000);
		 
		 try {
			 
			 driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
			 Thread.sleep(1000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
