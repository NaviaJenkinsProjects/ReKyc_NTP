package com.stepdefinition;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class PriceAlert extends BaseClass {
	
	
	@When("User Click The Search Options {string} button")
	public void user_click_the_search_options_button(String string) throws InterruptedException {
		
//		try {
			
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//input[@id='project-id']"));
			element.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
			Thread.sleep(3000);
			
//		} catch (Exception e) {
//			
//			System.out.println(e);
//		}

	}

	@When("User Click The Stock {string} and {string} button")
	public void user_click_the_stock_and_button(String string, String string2) throws InterruptedException {

//		try {
			
			
			WebElement element = driver.findElement(By.xpath("//div[@class='s-box']//child::span[text()='" + string
					+ "']//following-sibling::span[text()='" + string2 + "']"));
			
			   JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("window.scrollBy(0,500);");

		       js.executeScript("arguments[0].scrollIntoView(true);", element);


			
			Actions a=new Actions(driver);
			a.moveToElement(element).perform();
			Thread.sleep(2000);
			a.click(element).perform();
			Thread.sleep(2000);
			
//		} catch (Exception e) {
//			
//			System.out.println(e);
//		}
//		Thread.sleep(3000);
		
	}

	@When("User Select The {string} Icon button")
	public void user_select_the_icon_button(String string) throws InterruptedException {

//		try {
		
			
//		} catch (Exception e) {
//			
//			System.out.println(e);
//		}
		
	}

	@When("User Close The Ready_mode Page")
	public void user_close_the_ready_mode_page() throws InterruptedException {

//		try {
		Thread.sleep(1000);
			singleFrame();

			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();

			switchToMainFrame();
			
//		} catch (Exception e) {
//			
//			System.out.println(e);
//		}
			Thread.sleep(1000);

	}

	@When("User Select The LTP button and Verify {string}")
	public void user_select_the_ltp_button_and_verify(String string) throws InterruptedException {
		
//		try {
			Thread.sleep(1000);
			singleFrame();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement element2 = driver
					.findElement(By.xpath("//div[@class='update_strike_cont fo_ops']//descendant::button[text()='LTP']"));
			element2.click();

			WebElement element = driver.findElement(By
					.xpath("(//div[@class='ops_ltp_cont']//child::div[@data-chartsym='undefined']//descendant::span)[1]"));
			Thread.sleep(3000);
			String value1 = element.getText();
			System.err.println("CALL Value : " + value1);

			WebElement element1 = driver.findElement(By
					.xpath("(//div[@class='ops_ltp_cont']//child::div[@data-chartsym='undefined']//descendant::span)[12]"));
			Thread.sleep(3000);
			String value2 = element1.getText();
			System.err.println("PUT Value : " + value2);

			Thread.sleep(1000);
			
			if (value1.equals(value2)) {

				System.out.println("LTP is Not Working");

			} else {

				System.err.println("LTP is Working");

			}
			switchToMainFrame();
			
			Thread.sleep(1000);

	}

	@When("User Select The {string} button and Verify {string}")
	public void user_select_the_button_and_verify(String string, String string2) throws InterruptedException {
		
		
			
			singleFrame();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement element2 = driver.findElement(
					By.xpath("//div[@class='update_strike_cont fo_ops']//descendant::button[text()='" + string + "']"));
			element2.click();

			WebElement element = driver.findElement(By.xpath("(//div[@class='ops_ltp_cont']//child::div[@data-chartsym='"
					+ string2 + "']//descendant::span)[1499]"));
			Thread.sleep(3000);
			String value1 = element.getText();
			System.err.println("CALL Value : " + value1);

			WebElement element1 = driver.findElement(By.xpath("(//div[@class='ops_ltp_cont']//child::div[@data-chartsym='"
					+ string2 + "']//descendant::span)[1510]"));
			Thread.sleep(3000);
			String value2 = element1.getText();
			System.err.println("PUT Value : " + value2);

			Thread.sleep(1000);
			if (value1.equals(value2)) {

				System.out.println("LTP is Not Working");

			} else {

				System.err.println("LTP is Working");

			}

			switchToMainFrame();
			
			Thread.sleep(1000);

	}

	@When("User Verify The Popup To Options Chain")
	public void user_verify_the_popup_to_options_chain() throws InterruptedException {

		
			
			WebElement element = driver
					.findElement(By.xpath("//div[text()='This Security does not have Options and Future ']"));
			Thread.sleep(1000);
			if (element.isDisplayed()) {

				System.err.println("verify the pop up is not have Options and Future");

			}

			else {
				System.out.println("verify the pop up is not displayed");

			}
			
			Thread.sleep(1000);
		
	}

	@When("User Click The Stock {string} button")
	public void user_click_the_stock_button(String string) throws InterruptedException {

		
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='project-id']")).click();
			driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
			Thread.sleep(3000);
			
			Thread.sleep(1000);
		
	}

	@When("User Click The Search MCX Options {string} button")
	public void user_click_the_search_mcx_options_button(String string) throws InterruptedException {

		
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='project-id']")).click();
			driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
		
			Thread.sleep(2000);
			
	
	
	}
	
	
	@When("User Select The {string} Stock Option")
	public void user_select_the_stock_option(String string) throws InterruptedException {
	    
       
		Thread.sleep(2000);
		
		try {
			
			driver.findElement(By.xpath("(//span[text()='"+string+"'])[3]")).click();
			
		} catch (Exception e) {
			
			driver.findElement(By.xpath("(//span[text()='"+string+"'])[2]")).click();
			
		}
			
			Thread.sleep(2000);
			
		

	}
	
	@When("User Selcth The {string} Option and Send The {string} Value")
	public void user_selcth_the_option_and_send_the_value(String string, String string2) throws InterruptedException {
	    
			
		WebElement element = driver.findElement(By.xpath("(//div[@class='r_flex']//descendant::span[@class='sys_vl'])[1]"));
		String text = element.getText();
		
		System.out.println("Stock Is Current Value : "+text);
		String value = text.replaceAll("[^0-9.,-]", "");
		double numDouble = Double.parseDouble(value);
		int a = (int) numDouble;
		int b = (int) numDouble;
		
		double num = Double.parseDouble(string2);
		int v = (int) num; 
		
		
		
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.xpath("//button[text()=' Price Alert']"));
		element1.click();
		Thread.sleep(1000);
		
				
				singleFrame();
				
				
				
				
				switch (string) {
				
				case "Lesser then":
					
					driver.findElement(By.xpath("//input[@id='condition1']")).click();
					int c=a-v;
					System.err.println("Stock Is Lesser then Value : "+c);
					String str = String.valueOf(c);
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).clear();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).sendKeys(str);
					break;
					
		        case "Greater then":
					
					driver.findElement(By.xpath("//input[@id='condition2']")).click();
					int d=b+v;
					System.err.println("Stock Is Greater then Value : "+d);
					String str1 = String.valueOf(d);
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).clear();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).sendKeys(str1);
					break;	

				default:
					System.out.println("Invalid");
					break;
				}
				
				switchToMainFrame();
				Thread.sleep(1000);
			
	}

	@When("User Click The Save button")
	public void user_click_the_save_button() throws InterruptedException {
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				singleFrame();
				
				driver.findElement(By.xpath("//input[@value='Save']")).click();
				Thread.sleep(2000);
				
				
				try {
					
					switchToMainFrame();
					Thread.sleep(2000);
					WebElement element = driver.findElement(By.xpath("//div[@data-position='bottom-right']//descendant::span"));
					
					if (element.isDisplayed()) {
						
						String text = element.getText();
						System.out.println(text);
						
					} else {

						System.err.println("Not Showing in Alert Popup");
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				Thread.sleep(2000);
				
				//driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
				
			
		
	}

	@When("User MouseOver Dashboard and Click Price Alert")
	public void user_mouse_over_dashboard_and_click_price_alert() throws InterruptedException {
		Thread.sleep(2000);
		
			WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

			Actions ac = new Actions(driver);
			ac.moveToElement(dashBoard).perform();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//label[text()='Alert']//ancestor::li")).click();

			WebElement add = driver.findElement(By.xpath("//div[@class='notify dpd ']"));

			Thread.sleep(1000);
			Actions a = new Actions(driver);
			a.moveToElement(add).perform();
			
			Thread.sleep(1000);
		
	}
	
	@When("User Select The {string} Option All Datas To Print")
	public void user_select_the_option_all_datas_to_print(String string) throws InterruptedException {
	   
		Thread.sleep(2000);
			
			singleFrame();
			
			List<WebElement> elements = driver.findElements(By.xpath("//b[text()='"+string+"']//ancestor::li"));
			
			for (WebElement webElement : elements) {
				
				String text = webElement.getText();
				System.err.println(text);
			}
			
			switchToMainFrame();
			
		
		
	}

	@When("User Click The {string} Option To Remove button")
	public void user_click_the_option_to_remove_button(String string) throws InterruptedException {
	    
		Thread.sleep(2000);
        LocalDateTime now = LocalDateTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        String today = now.format(formatter);
        
        System.out.println(today);
			
			singleFrame();
			
			driver.findElement(By.xpath("(//b[text()='"+string+"']//following-sibling::small[contains(text(), '"+today+"')]//parent::span//following-sibling::span[@class='a_remove'])[1]")).click();
		
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Yes']")).click();
			switchToMainFrame();
			Thread.sleep(1000);
		
        
	}
	
	@When("User Select The Alert Tab {string} Options")
	public void user_select_the_alert_tab_options(String string) throws InterruptedException {
	   
		Thread.sleep(1000);
			
			singleFrame();
			
			driver.findElement(By.xpath("//button[text()='"+string+"']")).click();
			
			switchToMainFrame();
			Thread.sleep(1000);
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
