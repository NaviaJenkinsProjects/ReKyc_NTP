package com.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class Watchlist extends BaseClass {
	
	public String text2;

	@When("User Click The {string} Market watchlist")
	public void user_click_the_market_watchlist(String string) throws InterruptedException {
	    
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions a =new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']//parent::button"));
		a.moveToElement(element).perform();
		element.click();
		
		Thread.sleep(2000);
	}

	@When("User Search Any {string} Stock and {string} Option")
	public void user_search_any_stock_and_option(String string, String string2) throws InterruptedException {
	   
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		switch (string2) {
		
		case "BSE":
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Thread.sleep(1000);
			WebElement element2 = driver.findElement(By.xpath("//input[@id='project-id']"));
//			element2.click();
//			Thread.sleep(1000);
			element2.sendKeys(string);
			
			Thread.sleep(1000);
			
			//WebElement element3 = driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string2+"']//parent::div"));
			//String text = element3.getText();
			Thread.sleep(2000);
			
			try {
				
				WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']//parent::div[@class='s-box']//child::span[text()='"+string2+"']"));
				
				Actions f=new Actions(driver);
				f.moveToElement(element).perform();
				Thread.sleep(2000);
				
				WebElement element3 = driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::div//following-sibling::div//child::span[@class='s_add_sym'])[1]"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("arguments[0].click();", element3);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	        
			
			

			
			Thread.sleep(1000);
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Add");
					
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Clear']")).click();
			Thread.sleep(1000);
			
			WebElement webElement = driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::div//child::span[text()='"+string2+"'])[1]"));
			
			//for (WebElement webElement : elements) {
				
				if (webElement.isDisplayed()) {
					
//					String text2 = webElement.getText();
//					Thread.sleep(1000);
//					if (text.contentEquals(text2)) {
//						
						webElement.click();
						
						driver.findElement(By.xpath("//button[@class='s_close md_btn1']")).click();
						Thread.sleep(1000);
						
						try {
							
							WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
							
							if (element5.isDisplayed()) {
								
								String purple = "\u001B[35m";
								System.out.println(purple+"verify the pop up is displayed in Delete");
								
							}
							
						} catch (Exception e) {
							
							System.err.println("verify the pop up is not displayed");

						}
				}
			
			
			
			break;
			
      case "NSE":
			
			Thread.sleep(1000);
			WebElement element21 = driver.findElement(By.xpath("//input[@id='project-id']"));
			element21.click();
			Thread.sleep(1000);
			element21.sendKeys(string);
			
			Thread.sleep(1000);
			
			//WebElement element3 = driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string2+"']//parent::div"));
			//String text = element3.getText();
			Thread.sleep(2000);
			
	        //WebElement element1 = driver.findElement(By.xpath("//span[text()='"+string+"']//parent::div[@class='s-box']//child::span[text()='"+string2+"']"));
	        WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='"+string+"']//parent::div[@class='s-box']//child::span[text()='"+string2+"'])[1]")));
			Actions f1=new Actions(driver);
			f1.moveToElement(element1).perform();
			
			Thread.sleep(2000);
			
			WebElement element41 = driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::div//following-sibling::div//child::span[@class='s_add_sym'])[1]"));
			element41.click();
			
			Thread.sleep(1000);
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Add");
					
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Clear']")).click();
			Thread.sleep(1000);
			
			WebElement webElement1 = driver.findElement(By.xpath("//span[text()='"+string+"']//parent::div//child::span[text()='"+string2+"']"));
			
			//for (WebElement webElement : elements1) {
				
				if (webElement1.isDisplayed()) {
					
//					String text2 = webElement.getText();
//					Thread.sleep(1000);
//					if (text.contentEquals(text2)) {
//						
						webElement1.click();
						
						driver.findElement(By.xpath("//button[@class='s_close md_btn1']")).click();
						Thread.sleep(1000);
						
						try {
							
							WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
							
							if (element5.isDisplayed()) {
								
								String purple = "\u001B[35m";
								System.out.println(purple+"verify the pop up is displayed in Delete");
								
							}
							
						} catch (Exception e) {
							
							System.err.println("verify the pop up is not displayed");

						}
				}
			
			
			
			break;

		default:
			
			System.err.println("Invalid Your Condision");
			break;
		}
		

		
		
	}

	@When("User Click The Add and Remove The Stock")
	public void user_click_the_add_and_remove_the_stock() throws InterruptedException {
	    
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Its Working Fine");
		
		
	}

	@When("User Click The Current {string} Futures Option")
	public void user_click_the_current_futures_option(String string) throws InterruptedException {

		Thread.sleep(2000);

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
	
	@When("User Select The Current {string} Futures Option")
	public void user_select_the_current_futures_option(String string) throws InterruptedException {

		switch (string) {

		case "BSE":

			Thread.sleep(4000);
			Actions a = new Actions(driver);
			WebElement stock = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[@class='symbols'])[1]"));
			String fg = stock.getText();
			String text = fg.replaceAll("\\d+$", "");
			Thread.sleep(2000);
			System.out.println(text);
			
			Thread.sleep(1000);
			WebElement element = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[@class='symbolsseries'])[1]"));
			a.moveToElement(element).perform();
			

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='s-box']//following-sibling::div//child::span[@class='s_add_sym'])[1]"))
					.click();
			
			Thread.sleep(1000);
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Add");
					
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Clear']")).click();
			Thread.sleep(1000);
			
			try {
				
				WebElement element2 = driver.findElement(By.xpath("//span[text()='"+text+"']//following-sibling::span[text()='BFO']"));
				element2.click();
				Thread.sleep(1000);
				
				WebElement element3 = driver.findElement(By.xpath("//button[@class='s_close md_btn1']"));
				element3.click();
				Thread.sleep(1000);
				
			} catch (Exception e) {
				
			WebElement df = driver.findElement(By.xpath("(//span[text()='"+text+"']//following-sibling::span[text()='BFO'])[2]"));
				//for (WebElement webElement : elements) {
					
					df.click();
					Thread.sleep(1000);
					
					WebElement element3 = driver.findElement(By.xpath("//button[@class='s_close md_btn1']"));
					element3.click();
				//}
				
				
				Thread.sleep(1000);
			}
			
			
			
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Delete");
					
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}

			break;

		case "NSE":

			Thread.sleep(4000);
			Actions a1 = new Actions(driver);
			
			driver.findElement(By.xpath("//div[@class='search_filter_outer']//descendant::span[contains(text(),'Stocks')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='search_filter_outer']//descendant::span[contains(text(),'Futures')]")).click();
			
			Thread.sleep(2000);
			
			WebElement element1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[@class='symbols'])[1]"));
			String hg = element1.getText();
			String text1 = hg.replaceAll("\\d+$", "");
			Thread.sleep(2000);
			
			
			WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
			a1.moveToElement(stock1).perform();
			System.out.println(text1);

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='s-box']//following-sibling::div//child::span[@class='s_add_sym'])[1]"))
					.click();
			
			Thread.sleep(1000);
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Add");
					
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}
			
			
			
			
            try {
				
            	Thread.sleep(1000);
    			driver.findElement(By.xpath("//span[text()='Clear']")).click();
    			Thread.sleep(1000);
            	
            	driver.findElement(By.xpath("//span[text()='"+text1+"']//following-sibling::span[text()='NFO']")).click();
            	Thread.sleep(1000);
    			driver.findElement(By.xpath("//button[@class='s_close md_btn1']")).click();
    			Thread.sleep(1000);
				
			} catch (Exception e) {
				
				Thread.sleep(1000);
				//driver.findElement(By.xpath("//span[text()='Clear']")).click();
				Thread.sleep(1000);
				
				List<WebElement> elements = driver.findElements(By.xpath("//span[text()='"+text1+"']//following-sibling::span[text()='BFO']"));
            	
				for (WebElement webElement : elements) {
					
					webElement.click();
					
					Thread.sleep(1000);
	    			driver.findElement(By.xpath("//button[@class='s_close md_btn1']")).click();
	    			Thread.sleep(1000);
					
				}
				
			
				Thread.sleep(1000);
				
				
			}
			
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Delete");
					
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}

			break;

		default:

			System.err.println("Invalid Condition");
			break;
	}

		Thread.sleep(2000);
	}


	
	@When("User Select The Current {string} Futures Options")
	public void user_select_the_current_futures_options(String string) throws InterruptedException {

		switch (string) {

		case "MCX":

			Thread.sleep(4000);
			Actions a = new Actions(driver);
			WebElement stock = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='MCX'])[1]"));
			Thread.sleep(2000);
			
			WebElement element = driver.findElement(By.xpath("(//span[text()='MCX']//parent::div[@class='s-box']//child::span[@class='symbols'])[1]"));
			String ss = element.getText();
			Thread.sleep(1000);
			String text = ss.replaceAll("\\d+$", "");
			
			
			Thread.sleep(1000);
			a.moveToElement(stock).perform();
			System.out.println(text);

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[text()='MCX']//parent::div//following-sibling::div//following-sibling::span[@class='s_add_sym'])[1]"))
					.click();
			
			Thread.sleep(1000);
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Add");
					
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Clear']")).click();
			Thread.sleep(1000);
			
			try {
				
				driver.findElement(By.xpath("//span[text()='"+text+"']//following-sibling::span[text()='MCX']")).click();
				
				driver.findElement(By.xpath("//button[@class='s_close md_btn1']")).click();
				Thread.sleep(1000);
				
				
			} catch (Exception e) {
				
		        String g = text.replaceAll("\\d+$", "");
		        System.out.println(g);
		        
               driver.findElement(By.xpath("//span[text()='"+g+"']//following-sibling::span[text()='MCX']")).click();
				
            
                
				driver.findElement(By.xpath("//button[@class='s_close md_btn1']")).click();
				Thread.sleep(1000);
				
				
			}
			
//			driver.findElement(By.xpath("//span[text()='"+text+"']//preceding-sibling::span[text()='MCX']")).click();
//			
//			driver.findElement(By.xpath("//button[@class='s_close md_btn1']")).click();
//			Thread.sleep(1000);
			
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Delete");
					
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}

			break;

		case "NSE":

			Thread.sleep(4000);
			Actions a1 = new Actions(driver);
			WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
			Thread.sleep(2000);
			
			WebElement element1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[@class='symbols'])[1]"));
			String text3s = element1.getText();
			Thread.sleep(2000);
			String text1 = text3s.replaceAll("\\d+$", "");
			
			Thread.sleep(2000);
			a1.moveToElement(stock1).perform();
			System.out.println(text1);

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='s-box']//following-sibling::div//child::span[@class='s_add_sym'])[1]"))
					.click();
			
			Thread.sleep(1000);
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Add");
					
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Clear']")).click();
			Thread.sleep(1000);
			
			try {
				
				WebElement element2 = driver.findElement(By.xpath("//span[text()='"+text1+"']//following-sibling::span[text()='NFO']"));
				element2.click();
				Thread.sleep(1000);
				
				WebElement element3 = driver.findElement(By.xpath("//button[@class='s_close md_btn1']"));
				element3.click();
				
			} catch (Exception e) {

				WebElement hj = driver.findElement(By.xpath("(//span[text()='"+text1+"']//following-sibling::span[text()='NFO'])[2]"));
				
				//for (WebElement webElement : elements) {
					
					hj.click();
					Thread.sleep(1000);
					
					WebElement element3 = driver.findElement(By.xpath("//button[@class='s_close md_btn1']"));
					element3.click();
					
				//}
				
			
				
			}
			
			
			Thread.sleep(1000);
			
			try {
				
				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
				
				if (element5.isDisplayed()) {
					
					String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed in Delete");
					
				}
				
				else {
					
					System.out.println("Not Showing the pop up in Delete");
				}
				
			} catch (Exception e) {
				
				System.err.println("verify the pop up is not displayed");

			}

			break;

		default:

			System.err.println("Invalid Condition");
			break;
		}

		Thread.sleep(2000);
	}
	
	
	
	@When("User Click The Current {string} Option")
	public void user_click_the_current_options(String string) throws InterruptedException {
	   
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

	driver.findElement(By.xpath("//span[text()='Futures']")).click();
	Thread.sleep(2000);
	
	Actions a1 = new Actions(driver);
	WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
	Thread.sleep(1000);
	a1.moveToElement(stock1).perform();
	Thread.sleep(1000);
	a1.click(stock1).perform();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//lable[text()='F&O']//parent::button")).click();
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
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		try {
			
			WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
			
			if (element5.isDisplayed()) {
				
				String purple1 = "\u001B[35m";
				System.out.println(purple1+"verify the pop up is displayed in Add");
				
			}
			
		} catch (Exception e) {
			
			System.err.println("verify the pop up is not displayed");

		}
		
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Clear']")).click();
		Thread.sleep(1000);
		
	} catch (Exception e) {
		
		Thread.sleep(1000);
		WebElement table = driver.findElement(By.xpath("//select[@id='symbols_list']"));
		Select dropdown = new Select(table);
		dropdown.selectByVisibleText("NIFTY - NFO");
		
		Thread.sleep(5000);
		WebElement element3 = driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span)[1]"));
		Thread.sleep(2000);
		
		element3.click();
		
		//Thread.sleep(1000);
		//try {
			
//			WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
//			
//			if (element5.isDisplayed()) {
//				
//				//String purple1 = "\u001B[35m";
//				System.out.println(purple+"verify the pop up is displayed in Add");
//				
//			}
//			
//		//} catch (Exception e1) {
//			else {
//			System.err.println("verify the pop up is not displayed");
//			}
		//}
		
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Clear']")).click();
		Thread.sleep(1000);
		
		
	}
	
	Actions a = new Actions(driver);
	
		WebElement stocks = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue+"')]//preceding-sibling::span[text()='NFO']"));
		
		a.moveToElement(stocks).perform();
		Thread.sleep(1000);
		stocks.click();
		
		driver.findElement(By.xpath("//button[@class='s_close md_btn1']")).click();
		Thread.sleep(1000);
		
		try {
			
			WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
			
			if (element5.isDisplayed()) {
				
				String purple1 = "\u001B[35m";
				System.out.println(purple1+"verify the pop up is displayed in Delete");
				
			}
			
		} catch (Exception e) {
			
			System.err.println("verify the pop up is not displayed");

		}
		
			
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

      		WebElement element5 = driver.findElement(By.xpath("//span[text()='Futures']"));
      		element5.click();
      		Thread.sleep(2000);
      		
      		Actions a2 = new Actions(driver);
      		WebElement stock2 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='BSE'])[1]"));
      		Thread.sleep(1000);
      		a2.moveToElement(stock2).perform();
      		Thread.sleep(1000);
      		a2.click(stock2).perform();
      		
      		Thread.sleep(2000);
      		driver.findElement(By.xpath("//lable[text()='F&O']//parent::button")).click();
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
      		
      		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
      		Thread.sleep(1000);
      		
      		driver.findElement(By.xpath("//span[text()='Clear']")).click();
      		Thread.sleep(1000);
      		
      		Actions a3 = new Actions(driver);
      		
      			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BSE']"));
      			
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

    		WebElement element5 = driver.findElement(By.xpath("//span[text()='Futures']"));
    		element5.click();
    		Thread.sleep(2000);
    		
    		Actions a2 = new Actions(driver);
    		WebElement stock2 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='BSE'])[1]"));
    		Thread.sleep(1000);
    		a2.moveToElement(stock2).perform();
    		Thread.sleep(1000);
    		a2.click(stock2).perform();
    		
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//lable[text()='F&O']//parent::button")).click();
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
//    		Actions s = new Actions(driver);
//    		
//    		WebElement d = driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"'])[1]"));
//    		
//    		Thread.sleep(1000);
//    		s.moveToElement(d).perform();
//    		Thread.sleep(1000);
//    		
//    		driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"']//parent::div//child::span)[1]")).click();
//    		
//    		Thread.sleep(2000);
//    		
//    		driver.switchTo().defaultContent();
//    		
//    		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
//    		Thread.sleep(1000);
//    		
//    		driver.findElement(By.xpath("//span[text()='Clear']")).click();
//    		Thread.sleep(1000);
//    		
//    		Actions a3 = new Actions(driver);
//    		
//    			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BSE']"));
//    			
//    			a3.moveToElement(stoc).perform();
//    			Thread.sleep(1000);
//    			a3.click(stoc).perform();
//    		
//    			Thread.sleep(2000);
//    			driver.findElement(By.xpath("//button[@class='buy buyorder']"))
//    					.click();
//		}
    		
    		try {
    			
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"']//parent::div//descendant::span)[1]")).click();
    			Thread.sleep(2000);
    			
    			Thread.sleep(1000);
    			try {
    				
    				WebElement element51 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
    				
    				if (element51.isDisplayed()) {
    					
    					String purple11 = "\u001B[35m";
    					System.out.println(purple11+"verify the pop up is displayed in Add");
    					
    				}
    				
    			} catch (Exception e) {
    				
    				System.err.println("verify the pop up is not displayed");

    			}
    			
    			Thread.sleep(1000);
    			
    			driver.switchTo().defaultContent();
    			
    			driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
    			Thread.sleep(1000);
    			
    			driver.findElement(By.xpath("//span[text()='Clear']")).click();
    			Thread.sleep(1000);
    			
    		} catch (Exception e) {
    			
    			Thread.sleep(1000);
    			WebElement table = driver.findElement(By.xpath("//select[@id='symbols_list']"));
    			Select dropdown = new Select(table);
    			dropdown.selectByVisibleText("NIFTY - NFO");
    			
    			Thread.sleep(5000);
    			WebElement element31 = driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"']//parent::div//descendant::span)[1]"));
    			Thread.sleep(2000);
    			
    			element31.click();
    			
    			//Thread.sleep(1000);
    			//try {
    				
//    				WebElement element5 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
//    				
//    				if (element5.isDisplayed()) {
//    					
//    					//String purple1 = "\u001B[35m";
//    					System.out.println(purple+"verify the pop up is displayed in Add");
//    					
//    				}
//    				
//    			//} catch (Exception e1) {
//    				else {
//    				System.err.println("verify the pop up is not displayed");
//    				}
    			//}
    			
    			Thread.sleep(1000);
    			driver.switchTo().defaultContent();
    			
    			driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
    			Thread.sleep(1000);
    			
    			driver.findElement(By.xpath("//span[text()='Clear']")).click();
    			Thread.sleep(1000);
    			
    			
    		}
    		
    		Actions a11 = new Actions(driver);
    		
    			WebElement stocks1 = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BFO']"));
    			
    			a11.moveToElement(stocks1).perform();
    			Thread.sleep(1000);
    			stocks1.click();
    			
    			driver.findElement(By.xpath("//button[@class='s_close md_btn1']")).click();
    			Thread.sleep(1000);
    			
    			try {
    				
    				WebElement element51 = driver.findElement(By.xpath("//div[@role='alert']//child::span"));
    				
    				if (element51.isDisplayed()) {
    					
    					String purple11 = "\u001B[35m";
    					System.out.println(purple11+"verify the pop up is displayed in Delete");
    					
    				}
    				
    			} catch (Exception e) {
    				
    				System.err.println("verify the pop up is not displayed");

    			}
    			
		}
    		
    		
    		
    		
			break;

		default:
			
			System.out.println("Invalid Condition");
			
			break;
		}

	}

	

}
