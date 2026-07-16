
package com.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class Chart extends BaseClass {
	
	@When("User Choose {string} the Market WatchList")
	public void user_choose_the_market_watch_list(String string) throws InterruptedException {
	    
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement downArrow = driver.findElement(By.xpath("//button[@data-toggle='open_mm']"));

		Actions a = new Actions(driver);
		a.moveToElement(downArrow).perform();

		WebElement option = driver.findElement(By.xpath("(//span[text()='" + string + "']//parent::a)[2]"));
		a.moveToElement(option).perform();

		driver.findElement(By.xpath("(//span[text()='" + string + "']//parent::a)[2]")).click();

		WebElement any = driver.findElement(By.xpath("(//div[@mode='right'])[3]"));
		a.moveToElement(any).perform();

		Thread.sleep(2000);
		
		
		
	}

	@When("User Select The {string} Stock or F&O to Chart")
	public void user_select_the_stock_or_f_o_to_chart(String string) throws InterruptedException {
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
//		
//		List<WebElement> elements = driver.findElements(By.xpath("//span[text()='"+string+"']"));
//		
//		for (WebElement webElement : elements) {
//			
//			String text = webElement.getText();
//			//System.out.println(text);
//			
//			if (text.equals(string)) {
//				
				Actions a = new Actions(driver);
//				a.moveToElement(webElement).perform();
//				
//				List<WebElement> elements2 = driver.findElements(By.xpath("//span[text()='"+string+"']//parent::div//following-sibling::div//child::span[@class='s_b2 chart']"));
//				
//				for (WebElement webElement2 : elements2) {
//					
//					if(webElement2.isDisplayed()) {
//						
//						a.moveToElement(webElement2).perform();
//						Thread.sleep(2000);
//						a.click(webElement2).perform();
//						
//					}
//					
//					
//				}
				
				
				WebElement option = driver.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::span[@class='symbolsseries'])[1]"));
				a.moveToElement(option).perform();

				driver.findElement(By.xpath("(//span[text()='"+string+"']//ancestor::div[@class='mw_list']//following-sibling::div[@class='s_btns']//child::span[@class='s_b2 chart'])[1]")).click();

				
				
			//}		
			
		//}
		
		Thread.sleep(2000);
		framesHandling();
		

		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 minute']//ancestor::div[@data-value='1']")).click();
		
		Thread.sleep(2000);
		
		WebElement element3 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text2 = element3.getText();
		
		
		System.out.println("Feed Connection Value of One Minute : " + text2);
		
		Thread.sleep(2000);
		
		WebElement element2 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text1 = element2.getText();
		System.out.println("Feed Connection Value of One Minute : " + text1);
		
		if (text2.equals(text1)) {
			
			String blue = "\u001B[34m";
			System.err.println(blue+"One Minute Chart Value to Pass : " + text1);
		}
		
		else {
			
			System.err.println("Feed Connection Faild");
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 day']//ancestor::div[@data-value='1D']")).click();
		
		Thread.sleep(2000);
		
		WebElement element31 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text212 = element31.getText();
		System.out.println("Feed Connection Value of One Minute : " + text212);
		
		Thread.sleep(2000);
		
		WebElement element21 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text112 = element21.getText();
		System.out.println("Feed Connection Value of One Minute : " + text112);
		
		if (text212.equals(text112)) {
			
			String blue = "\u001B[34m";
			System.err.println(blue+"One Minute Chart Value to Pass : " + text112);
		}
		
		else {
			
			System.err.println("Feed Connection Faild");
		}
		
		outOfFrames();
		
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

		
		Thread.sleep(2000);
	}
	
	@When("User Check the one Minute and one Day Chart")
	public void user_check_the_one_minute_and_one_day_chart() throws InterruptedException {
	   
		Thread.sleep(2000);
	//	framesHandling();
		

		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 minute']//ancestor::div[@data-value='1']")).click();
		
		Thread.sleep(2000);
		
		WebElement element3 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text2 = element3.getText();
		
		
		System.out.println("Feed Connection Value of One Minute : " + text2);
		
		Thread.sleep(2000);
		
		WebElement element2 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text1 = element2.getText();
		System.out.println("Feed Connection Value of One Minute : " + text1);
		
		if (text2.equals(text1)) {
			
			String blue = "\u001B[34m";
			System.err.println(blue+"One Minute Chart Value to Pass : " + text1);
		}
		
		else {
			
			System.err.println("Feed Connection Faild");
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 day']//ancestor::div[@data-value='1D']")).click();
		
		Thread.sleep(2000);
		
		WebElement element31 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text211 = element31.getText();
		System.out.println("Feed Connection Value of One Day : " + text211);
		
		Thread.sleep(2000);
		
		WebElement element21 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text111 = element21.getText();
		System.out.println("Feed Connection Value of One Day : " + text111);
		
		if (text211.equals(text111)) {
			
			String blue = "\u001B[34m";
			System.err.println(blue+"One Minute Chart Value to Pass : " + text111);
		}
		
		else {
			
			System.err.println("Feed Connection Faild");
		}
		
		outOfFrames();
		
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

		
		Thread.sleep(2000);
		
	}

	@When("User Naviagate to Market WatchList")
	public void user_naviagate_to_market_watch_list() {
	    
	    
	    
		
	}

	
	@When("User Select The {string} Stock To Chart Click")
	public void user_select_the_stock_to_chart_click(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(1000);
		WebElement stock = driver.findElement(By.xpath("(//span[text()='"+string+"']//preceding-sibling::span[@class='symbolsseries'])[1]"));
		Actions s=new Actions(driver);
		s.moveToElement(stock).perform();
		Thread.sleep(1000);
	
		WebElement element = driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::div//following-sibling::div//child::span[@class='s_b2 chart'])[1]"));
		element.click();
		
		
		
		Thread.sleep(1000);
		
	}

	@When("User Verify The Buy\\/Sell , Depth and F&O")
	public void user_verify_the_buy_sell_depth_and_f_o() throws InterruptedException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String purple = "\u001B[35m";
		String red = "\u001B[31m";
		
		
		framesHandling();
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[text()='BUY']"));
		element.click();
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		WebElement buy = driver.findElement(By.xpath("//button[contains(@class,'btn-buy')]"));
		String text = buy.getText();
		
		Thread.sleep(1000);
		if (text.equals("BUY")) {
			
			System.out.println(purple+"Chart Buy button working");
			
			WebElement element2 = driver.findElement(By.xpath("(//button[@data-dhx-id='close'])[2]"));
			element2.click();
			
		}else {
			
			System.err.println(red+"Chart Buy button not working");
			WebElement element2 = driver.findElement(By.xpath("(//button[@data-dhx-id='close'])[2]"));
			element2.click();
		}
		
	
       framesHandling();
		
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.xpath("//div[text()='SELL']"));
		element1.click();
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		WebElement sell = driver.findElement(By.xpath("//button[contains(@class,'btn-buy')]"));
		String text1 = sell.getText();
		
		Thread.sleep(1000);
		if (text1.equals("SELL")) {
			
			System.out.println(purple+"Chart Sell button working");
			
			WebElement element2 = driver.findElement(By.xpath("(//button[@data-dhx-id='close'])[2]"));
			element2.click();
			
		}else {
			
			System.err.println(red+"Chart Sell button not working");
			WebElement element2 = driver.findElement(By.xpath("(//button[@data-dhx-id='close'])[2]"));
			element2.click();
		}
		
		 framesHandling();
			
			Thread.sleep(1000);
			WebElement element11 = driver.findElement(By.xpath("//div[text()='DEPTH']"));
			element11.click();
			Thread.sleep(1000);
			
			driver.switchTo().defaultContent();
			
			Thread.sleep(1000);
			WebElement depth = driver.findElement(By.xpath("//span[@class='dh_source symtdet']"));
			String text11 = depth.getText();
			
			Thread.sleep(1000);
			
			if (text11.equals("NSE")  || text11.equals("BSE")  || text11.equals("MCX") || text11.equals("NFO") || text11.equals("BFO")) {
				
				System.out.println(purple+"Chart Depth button working");
				
				WebElement element2 = driver.findElement(By.xpath("(//button[@data-dhx-id='close'])[2]"));
				element2.click();
				
			}else {
				
				System.err.println(red+"Chart Depth button not working");
				WebElement element2 = driver.findElement(By.xpath("(//button[@data-dhx-id='close'])[2]"));
				element2.click();
			}
			
			 framesHandling();
				
				Thread.sleep(1000);
				WebElement element111 = driver.findElement(By.xpath("//div[text()='F&O']"));
				element111.click();
				Thread.sleep(1000);
				
				driver.switchTo().defaultContent();
				
				WebElement element3 = driver.findElement(By.xpath("(//iframe[@class='iframe_window'])[1]"));
				driver.switchTo().frame(element3);
				
				Thread.sleep(1000);
				WebElement fo = driver.findElement(By.xpath("//div[@class='strategy_act act']"));
				
				Thread.sleep(1000);
				
				if (fo.isDisplayed()) {
					
					System.out.println(purple+"Chart F&O button working");
					
					driver.switchTo().defaultContent();
					WebElement element2 = driver.findElement(By.xpath("(//span[@class='icon icon1'])[1]"));
					element2.click();
					
					Thread.sleep(1000);
					
					WebElement element4 = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
					element4.click();
					
					
					
				}else {
					
					System.err.println(red+"Chart F&O button not working");
					
					driver.switchTo().defaultContent();
					WebElement element2 = driver.findElement(By.xpath("(//span[@class='icon icon1'])[1]"));
					element2.click();
					
                    Thread.sleep(1000);
					
					WebElement element4 = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
					element4.click();
				}
		
		
		Thread.sleep(1000);
		
	}

	@When("User Search The {string} Stock To Chart Click")
	public void user_search_the_stock_to_chart_click(String string) throws InterruptedException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element3 = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
		Thread.sleep(1000);
		element3.click();
		Thread.sleep(1000);
		element3.clear();
		Thread.sleep(1000);
		element3.sendKeys(string);
		
		Thread.sleep(1000);
		WebElement stock = driver.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::span[@class='symbolsseries'])[1]"));
		Actions s=new Actions(driver);
		s.moveToElement(stock).perform();
		Thread.sleep(1000);
	
		WebElement element = driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::div//following-sibling::div//child::span[@class='s_b2 '])[1]"));
		element.click();
		
		Thread.sleep(1000);
		
	}
	
	@When("User Search The {string} Current Featute To Chart Click")
	public void user_search_the_current_featute_to_chart_click(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element3 = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
		Thread.sleep(1000);
		element3.click();
		Thread.sleep(1000);
		element3.clear();
		Thread.sleep(1000);
		element3.sendKeys(string);
		
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Futures']"));
		element.click();
		
		Thread.sleep(1000);
		
		try {
			
			
			WebElement stock = driver.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//following-sibling::span[@class='symbolsseries'])[1]"));
			Actions s=new Actions(driver);
			s.moveToElement(stock).perform();
			Thread.sleep(1000);
			
			WebElement element1 = driver.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//parent::div//following-sibling::div//child::span[@class='s_b2 '])[1]"));
			element1.click();
			
		} catch (Exception e) {
			
			WebElement element1 = driver.findElement(By.xpath("//span[text()='Futures']"));
			element1.click();
			
			Thread.sleep(1000);
			
			WebElement stock = driver.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//following-sibling::span[@class='symbolsseries'])[1]"));
			Actions s=new Actions(driver);
			s.moveToElement(stock).perform();
			Thread.sleep(1000);
			
			WebElement element11 = driver.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//parent::div//following-sibling::div//child::span[@class='s_b2 '])[1]"));
			element11.click();
		}
		
	}

}
