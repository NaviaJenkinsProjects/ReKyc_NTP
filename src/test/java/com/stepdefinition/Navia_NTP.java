package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Navia_NTP extends BaseClass{
	
	@When("User Click The Position Page and Take the ScreenSort")
	public void user_click_the_position_page_and_take_the_screen_sort() throws InterruptedException, IOException {
	  
		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text()='Position']//parent::a")).click();
		
		Thread.sleep(2000);
		
		String timestamp = new SimpleDateFormat("dd_MM_yyyy_HHmm").format(new Date());
		//System.out.println(timestamp);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("D:\\Projects\\Post_Markets_NTP\\ScreenShort\\Trade\\Buy"+timestamp+".png");
        FileUtils.copyFile(srcFile, destFile);
        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
		
		
		
		
		Thread.sleep(1000);
		
		
	}

	@When("User Select The Stock to Chart Open")
	public void user_select_the_stock_to_chart_open() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[@class='cntx_menu netposition_context ']")).click();
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Chart']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
	}

	@When("User Add\\/Remove The Indicators in {string} Stock")
	public void user_add_remove_the_indicators_in_stock(String string) throws InterruptedException {


		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element = driver.findElement(By.xpath("//div[@class='dhx_layout-cell-inner_html']//child::iframe"));
		driver.switchTo().frame(element);
		
		WebElement element1 = driver.findElement(By.xpath("//div[@class='chart_window']//child::iframe"));
		driver.switchTo().frame(element1);
		Thread.sleep(1000);
		
		try {
			
			driver.findElement(By.xpath("(//div[text()='Indicators'])[1]")).click();
			
		} catch (Exception e) {
			
			driver.findElement(By.xpath("(//div[@data-name='open-indicators-dialog'])[1]")).click();

		}
		
		
		
		
		Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		element2.click();
		element2.sendKeys(string);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[@class='title-1gYObTuJ']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[@data-name='close']")).click();
		Thread.sleep(1000);
		
		WebElement element3 = driver.findElement(By.xpath("(//div[text()='"+string+"'])[1]"));
		Actions s=new Actions(driver);
		s.moveToElement(element3).perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[@data-name='legend-delete-action'])[2]")).click();
        Thread.sleep(1000);

		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
		Thread.sleep(1000);
		
		
	}

	@When("User Create The {string} MarketList")
	public void user_create_the_market_list(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//button[@class='btnss'])[1]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter MW Name']")).sendKeys(string);
		
		driver.findElement(By.xpath("//button[@data-dhx-id='form_button_bst_addlist']")).click();
		
		
		
		Thread.sleep(2000);

	}

	@When("User Select The {string} MarketWatch List")
	public void user_select_the_market_watch_list(String string) throws InterruptedException {
	   
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement downArrow = driver.findElement(By.xpath("//button[@data-toggle='open_mm']"));

		Actions a = new Actions(driver);
		Thread.sleep(2000);
		a.moveToElement(downArrow).perform();

		WebElement option = driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::a)[2]"));
		Thread.sleep(2000);
		a.moveToElement(option).perform();

		driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::a)[2]")).click();

		WebElement any = driver.findElement(By.xpath("(//div[@mode='right'])[3]"));
		Thread.sleep(2000);
		a.moveToElement(any).perform();

		Thread.sleep(2000);

		
	}

	@When("User Modify The {string} MarketList")
	public void user_modify_the_market_list(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element = driver.findElement(By.xpath("//li[@class='dhx_tabbar-tab usertabs']//descendant::span[text()='"+string+"']"));
		
		Actions s=new Actions(driver);
		s.moveToElement(element).perform();
		s.contextClick(element).perform();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Rename']")).click();
		
	    Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("(//input[@placeholder='Enter MW Name'])[1]"));
		element2.click();
		element2.sendKeys("Testing");
		
		Thread.sleep(1000);
		
	    driver.findElement(By.xpath("//span[text()='Save']//parent::button")).click();
		
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//button[text()='yes']")).click();
		
	    Thread.sleep(1000);
		
	}

	@When("User Delete The {string} MarketList")
	public void user_delete_the_market_list(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	WebElement element = driver.findElement(By.xpath("//li[@class='dhx_tabbar-tab usertabs']//descendant::span[text()='"+string+"']"));
		
		Actions s=new Actions(driver);
		s.moveToElement(element).perform();
		s.contextClick(element).perform();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//button[text()='yes']")).click();
		
		Thread.sleep(1000);
		
	}

	
	@When("User Navigate The {string} Top option")
	public void user_navigate_the_top_option(String string) throws InterruptedException {
	
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		try {
			
			WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']//parent::a"));
			element.click();
			
		} catch (Exception e) {
			
			WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']"));
			element.click();
		}
		
		
		
		Thread.sleep(1000);
		
	}

	@When("User Verify The Today P\\/L Value Check")
	public void user_verify_the_today_p_l_value_check() throws InterruptedException {
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> allPandL = driver.findElements(
				By.xpath("//div[@data-dhx-col-id='CPPL']/div[@role='button']/span"));
		List<String> pAndL = new ArrayList<>();

		for (WebElement PandL : allPandL) {
			String text23 = PandL.getText();
			String g = text23.replaceAll("[^0-9.]", "");
			pAndL.add(g);
			System.out.println("Today P/L Value is : " + g);
		}
		Thread.sleep(2000);

		System.out.println("All today P/L  Values: " + pAndL);

		double sum3 = 0;
		for (String value3 : pAndL) {
			sum3 += Double.parseDouble(value3);
		}
		
		String roundedStr = String.format("%.2f", sum3);
		//System.out.println("Rounded String: " + roundedStr);
		String y = "\u001B[33m";
		System.out.println(y+"Total Today P/L Value: " + roundedStr);

		WebElement pAndVValueTotal = driver
				.findElement(By.xpath("//input[@data-dhx-id='tpl_val']"));
	
		String attribute = pAndVValueTotal.getAttribute("value");
		Thread.sleep(2000);

	  String replaceAll = attribute.replaceAll("[^0-9.-]", "");

		System.out.println(y+"Total Value is : "+replaceAll);
		
//		String sumBeforeDecimal3 = String.valueOf(roundedStr).split("\\.")[0];
//		String text1BeforeDecimal3 = replaceAll.split("\\.")[0];

		if (replaceAll.equals(roundedStr)) {
			String purple = "\u001B[35m";
			System.out.println(purple+"Its Working Fine");
		} else {
			System.err.println("Today P/L Value is Not Equals to Today Total P/L Values");
		}
		Thread.sleep(2000);
		
		
		Thread.sleep(1000);
		
	}

	//==============================================================IPO============================================================
	
	
	
	@When("User Click The {string} Page in Tools Options")
	public void user_click_the_page_in_tools_options(String string) throws InterruptedException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		switch (string) {
		
		case "IPO":
			
			WebElement element = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
			driver.switchTo().frame(element);
			Thread.sleep(1000);
			WebElement element2 = driver.findElement(By.xpath("//h4[text()='IPO']//ancestor::div[@id='ipo']"));
			Actions g=new Actions(driver);
			g.moveToElement(element2).perform();
			Thread.sleep(1000);
			g.click(element2).perform();
			
			driver.switchTo().defaultContent();
			break;
			
       case "Basket":
			
			WebElement element1 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
			driver.switchTo().frame(element1);
			
			WebElement element21 = driver.findElement(By.xpath("//h4[text()='Basket']//ancestor::div[@id='basket']"));
			Actions g1=new Actions(driver);
			g1.moveToElement(element21).perform();
			Thread.sleep(1000);
			g1.click(element21).perform();
			
			driver.switchTo().defaultContent();
			break;

		default:
			
			System.err.println("Invalid Your Condition");
			
			break;
		}
		
		Thread.sleep(1000);
		
	}

	@When("User Navigate The IPO Official Site and Verify")
	public void user_navigate_the_ipo_official_site_and_verify() throws InterruptedException, AWTException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
		Thread.sleep(1000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.chittorgarh.com/");
		Thread.sleep(1000);
		
		Actions h=new Actions(driver);
		
		
		try {
			
			WebElement element1 = driver.findElement(By.xpath("//button[@aria-label='Close']"));
			element1.click();
			Thread.sleep(1000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'IPO')])[1]"));
		
		h.moveToElement(element).perform();
		Thread.sleep(1000);
	
		WebElement element1 = driver.findElement(By.xpath("(//a[text()='Current IPOs'])[1]"));
		element1.click();
		Thread.sleep(1000);
		
		WebElement element11 = driver.findElement(By.xpath("//table[@id='report_table']//thead//tr//th//child::span[contains(text(),'Listing Date')]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("arguments[0].scrollIntoView();", element11);
	    Thread.sleep(1000);
	    
	    DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy", Locale.ENGLISH);

        // format today’s date
        String date = LocalDate.now().format(formatter);

        System.out.println("Today’s date: " + date);
	    
	    List<WebElement> elements = driver.findElements(By.xpath("//table[@id='report_table']/tbody/tr/td[4]//child::div"));
	    Thread.sleep(1000);
	    	
	    	for (int i = 1; i < elements.size(); i++) {
	    		
	    		Thread.sleep(1000);
	    		
	    	    String text5 = elements.get(i).getText();
	    	    
	    	    Thread.sleep(1000);
	    	if (text5.equals(date)) {
	    		//System.out.println(text);
	    		//System.out.println(i);
	    		int s=i+1;
	    		
	    		WebElement element2 = driver.findElement(By.xpath("//table[@id='report_table']/tbody/tr["+s+"]/td[4]//preceding-sibling::td[3]//child::a"));
	    		
	    		String st = element2.getText();
	    		String purple = "\u001B[35m";
	    		System.out.println(purple+"IPO Stock List Name : "+st);
	    		String[] words = st.split(" ");

	    		// Get only the first two words safely
	    		String result = "";
	    		if (words.length >= 2) {
	    		    result = words[0] + " " + words[1];
	    		} else {
	    		    result = words[0]; // if only one word exists
	    		}

	    		Thread.sleep(1000);
	    		
	    		
	    		String upperCase = result.toUpperCase();
	    		
	    		driver.switchTo().window(tabs.get(0));
	    		Thread.sleep(1000);
	    		
	    		driver.navigate().refresh();
	    		Thread.sleep(5000);
	    		
	    		WebElement element3 = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
	    		Thread.sleep(1000);
	    		element3.click();
	    		Thread.sleep(1000);
	    		element3.sendKeys(upperCase);
	    		Thread.sleep(4000);
	    		driver.findElement(By.xpath("(//span[text()='Stocks'])[2]")).click();
	    		Thread.sleep(4000);
	    		driver.findElement(By.xpath("(//span[text()='All'])[2]")).click();
	    		Thread.sleep(7000);
	    		
	    		
	    		List<WebElement> elements2 = driver.findElements(By.xpath("//div[@class='s-box']//child::span[@class='s_details']"));
	    		
	    		for (WebElement webElement : elements2) {
	    			Thread.sleep(2000);
	    		    String text = webElement.getText();
	    		    Thread.sleep(1000);
	    		    if (text.contains(upperCase)) {
	    		    	String yellow = "\u001B[33m";
	    		    	System.out.println(yellow+"IPO Listing display successfully");
	    		    	
	    		    	WebElement ipo = driver.findElement(By.xpath("//span[contains(text(),'"+upperCase+"')]//parent::div[@class='s-box']//child::span[text()='NSE']"));
	    				
	    				Actions f=new Actions(driver);
	    				f.moveToElement(ipo).perform();
	    				Thread.sleep(2000);
	    				
	    				WebElement ipoadd = driver.findElement(By.xpath("(//span[contains(text(),'"+upperCase+"')]//parent::div//following-sibling::div//child::span[@class='s_add_sym'])[1]"));
	    				JavascriptExecutor js11 = (JavascriptExecutor) driver;
	    			    js11.executeScript("arguments[0].click();", ipoadd);
	    		    	
	    		    	
	    		    	
	    		    	
	    		    	driver.switchTo().window(tabs.get(1));
	    		        Thread.sleep(2000);  // Perform actions if needed
//	    		        
//	    		        driver.close();
//	    		        
//	    		        driver.switchTo().window(tabs.get(0));
//	    		        Thread.sleep(2000);
	    		        Thread.sleep(1000);
	    		        break;

	    		    	
					}
	    		    
	    		    Thread.sleep(1000); 
	    		 
					
				}
	    		
	    		
	    		Thread.sleep(500);
	    		
	    		
	    		
			}
	    	else {
	    		String red = "\u001B[31m";
				System.err.println(red+"Today Not Listing in IPO");
				continue;
    		}
	    	Thread.sleep(500);
	    		
	    	
	    	}
	    	
	    	
			
		       
			Thread.sleep(1000);
			
		
		
	}
	
	@When("User Check The {string} Default MarketWatch {string} List")
	public void user_check_the_default_market_watch_list(String string, String string2) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		Actions k=new Actions(driver);
		WebElement element3 = driver.findElement(By.xpath("//button[@id='open_mw_btn']"));
		k.moveToElement(element3).perform();
		Thread.sleep(2000);
		
		WebElement element31 = driver.findElement(By.xpath("//span[text()='"+string+"']//parent::a[contains(@onclick,'openMtab')]"));
		element31.click();
		Thread.sleep(1000);
		
		WebElement element1 = driver.findElement(By.xpath("//button[@id='add_mw_btn']"));
		k.moveToElement(element1).perform();
		Thread.sleep(1000);
		
		List<WebElement> elements = driver.findElements(By.xpath("(//div[contains(@id,'"+string+"')])[1]//descendant::span[text()='"+string2+"']"));
		int count = elements.size();
		String blue = "\u001B[34m";
		System.out.println(blue+"Total "+string+" Stock found: " + count);
		Thread.sleep(1000);
		
		
		switch (count) {
		
		case 50:
			
			String stock="APOLLOHOSP-EQ";
			
			String yellow = "\u001B[33m"; 
			System.out.println(yellow+"Predefined Market Watch List Loaded");
			
			WebElement element = driver.findElement(By.xpath("(//div[contains(@id,'NIFTY')])[1]//descendant::span[text()='"+stock+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_vl']"));
			String text = element.getText();
			
			double ltp = Double.parseDouble(text);
			Thread.sleep(1000);
			element.click();
			
			Thread.sleep(1000);
			WebElement text2 = driver.findElement(By.xpath("//div[@class='close_price']"));
			String value = text2.getText();
			double yesterday = Double.parseDouble(value);
			Thread.sleep(1000);
			
			double total1=ltp-yesterday;
			double total2 =total1/yesterday;
			double total4 =total2*100;
			Thread.sleep(1000);
			
			String formatted = String.format("%.2f", total4);
			Thread.sleep(1000);

			WebElement element2 = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
			element2.click();
			Thread.sleep(1000);
			WebElement element4 = driver.findElement(By.xpath("(//div[contains(@id,'NIFTY')])[1]//descendant::span[text()='"+stock+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_ptg']"));
			String text3 = element4.getText();
			String cleaned = text3.replaceAll("[^0-9.-]", "");
			System.out.println(stock+"in percentage Value : "+cleaned);
			Thread.sleep(1000);

			if (cleaned.equals(formatted)) {
				
				String purple = "\u001B[35m";
				System.out.println(purple+"The percentage value is correct.");
				
			}else {
				
				String red = "\u001B[31m";
				System.out.println(red+"The percentage value is Not correct.");
				
				
			}
			
			Thread.sleep(20000);
			WebElement element11 = driver.findElement(By.xpath("(//div[contains(@id,'NIFTY')])[1]//descendant::span[text()='"+stock+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_vl']"));
			String text1 = element11.getText();
			
			
			if (text.equals(text1)) {
				String red = "\u001B[31m";
				System.out.println(red+"LTP fluctuation is Not working");
				
			}else {
				String purple = "\u001B[35m";
				System.out.println(purple+"LTP fluctuation is working");
				
			}
			
			
			
			
			
			break;
			
          case 31:
        	  
        	  String sensex="AXISBANK-A";
		
            String yellow1 = "\u001B[33m";
			System.out.println(yellow1+"Predefined Market Watch List Loaded");
			
			WebElement stocks = driver.findElement(By.xpath("(//div[contains(@id,'SENSEX')])[1]//descendant::span[text()='"+sensex+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_vl']"));
			String text11 = stocks.getText();
			
			double ltp1 = Double.parseDouble(text11);
			Thread.sleep(1000);
			stocks.click();
			
			Thread.sleep(2000);
			WebElement text21 = driver.findElement(By.xpath("//div[@class='close_price']"));
			String value1 = text21.getText();
			double yesterday1 = Double.parseDouble(value1);
			Thread.sleep(1000);
			
			double total11=ltp1-yesterday1;
			double total21 =total11/yesterday1;
			double total41 =total21*100;
			Thread.sleep(1000);
			
			String formatted1 = String.format("%.2f", total41);
			Thread.sleep(1000);

			WebElement element21 = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
			element21.click();
			Thread.sleep(1000);
			WebElement element41 = driver.findElement(By.xpath("(//div[contains(@id,'SENSEX')])[1]//descendant::span[text()='"+sensex+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_ptg']"));
			String text31 = element41.getText();
			String cleaned1 = text31.replaceAll("[^0-9.-]", "");
			System.out.println(sensex+"in percentage Value : "+cleaned1);
			Thread.sleep(1000);

			if (cleaned1.equals(formatted1)) {
				
				String purple = "\u001B[35m";
				System.out.println(purple+"The percentage value is correct.");
				
			}else {
				
				String red = "\u001B[31m";
				System.out.println(red+"The percentage value is Not correct.");
				
				
			}
			
			Thread.sleep(20000);
			WebElement element111 = driver.findElement(By.xpath("(//div[contains(@id,'SENSEX')])[1]//descendant::span[text()='"+sensex+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_vl']"));
			String test9 = element111.getText();
			
			if (test9.equals(text11)) {
				String red = "\u001B[31m";
				System.out.println(red+"LTP fluctuation is Not working");
				
			}else {
				String purple = "\u001B[35m";
				System.out.println(purple+"LTP fluctuation is working");
				
			}
  			
  			break;
  			
          case 14:
        	  
        	  String bankNifty="ICICIBANK-EQ";
      		
              String yellow111 = "\u001B[33m";
  			System.out.println(yellow111+"Predefined Market Watch List Loaded");
  
			
			WebElement stocks1 = driver.findElement(By.xpath("(//div[contains(@id,'BANKNIFTY')])[1]//descendant::span[text()='"+bankNifty+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_vl']"));
			String text111 = stocks1.getText();
			
			double ltp11 = Double.parseDouble(text111);
			Thread.sleep(1000);
			stocks1.click();
			
			Thread.sleep(2000);
			WebElement text211 = driver.findElement(By.xpath("//div[@class='close_price']"));
			String value11 = text211.getText();
			double yesterday11 = Double.parseDouble(value11);
			Thread.sleep(1000);
			
			double total111=ltp11-yesterday11;
			double total211 =total111/yesterday11;
			double total411 =total211*100;
			Thread.sleep(1000);
			
			String formatted11 = String.format("%.2f", total411);
			Thread.sleep(1000);

			WebElement element211 = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
			element211.click();
			Thread.sleep(1000);
			WebElement element411 = driver.findElement(By.xpath("(//div[contains(@id,'BANKNIFTY')])[1]//descendant::span[text()='"+bankNifty+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_ptg']"));
			String text311 = element411.getText();
			String cleaned11 = text311.replaceAll("[^0-9.-]", "");
			System.out.println(bankNifty+"in percentage Value : "+cleaned11);
			Thread.sleep(1000);

			if (cleaned11.equals(formatted11)) {
				
				String purple = "\u001B[35m";
				System.out.println(purple+"The percentage value is correct.");
				
			}else {
				
				String red = "\u001B[31m";
				System.out.println(red+"The percentage value is Not correct.");
				
				
			}
			
			Thread.sleep(20000);
			WebElement element1111 = driver.findElement(By.xpath("(//div[contains(@id,'BANKNIFTY')])[1]//descendant::span[text()='"+bankNifty+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_vl']"));
			String test8 = element1111.getText();
			
			if (test8.equals(text111)) {
				String red = "\u001B[31m";
				System.out.println(red+"LTP fluctuation is Not working");
				
			}else {
				String purple = "\u001B[35m";
				System.out.println(purple+"LTP fluctuation is working");
				
			}
  			
  			break;
  			
          case 20:
        	  
        	  String finifty="CHOLAFIN-EQ";
        		
              String yellow1111 = "\u001B[33m";
  			System.out.println(yellow1111+"Predefined Market Watch List Loaded");
			
			WebElement stocks11 = driver.findElement(By.xpath("(//div[contains(@id,'FINNIFTY')])[1]//descendant::span[text()='"+finifty+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_vl']"));
			String text1111 = stocks11.getText();
			
			double ltp111 = Double.parseDouble(text1111);
			Thread.sleep(1000);
			stocks11.click();
			
			Thread.sleep(2000);
			WebElement text2111 = driver.findElement(By.xpath("//div[@class='close_price']"));
			String value111 = text2111.getText();
			double yesterday111 = Double.parseDouble(value111);
			Thread.sleep(1000);
			
			double total1111=ltp111-yesterday111;
			double total2111 =total1111/yesterday111;
			double total4111 =total2111*100;
			Thread.sleep(1000);
			
			String formatted111 = String.format("%.2f", total4111);
			Thread.sleep(1000);

			WebElement element2111 = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
			element2111.click();
			Thread.sleep(1000);
			WebElement element4111 = driver.findElement(By.xpath("(//div[contains(@id,'FINNIFTY')])[1]//descendant::span[text()='"+finifty+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_ptg']"));
			String text3111 = element4111.getText();
			String cleaned111 = text3111.replaceAll("[^0-9.-]", "");
			System.out.println(finifty+"in percentage Value : "+cleaned111);
			Thread.sleep(1000);

			if (cleaned111.equals(formatted111)) {
				
				String purple = "\u001B[35m";
				System.out.println(purple+"The percentage value is correct.");
				
			}else {
				
				String red = "\u001B[31m";
				System.out.println(red+"The percentage value is Not correct.");
				
				
			}
			
			Thread.sleep(20000);
			WebElement element11111 = driver.findElement(By.xpath("(//div[contains(@id,'FINNIFTY')])[1]//descendant::span[text()='"+finifty+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='sys_vl']"));
			String test6 = element11111.getText();
			
			if (test6.equals(text1111)) {
				String red = "\u001B[31m";
				System.out.println(red+"LTP fluctuation is Not working");
				
			}else {
				String purple = "\u001B[35m";
				System.out.println(purple+"LTP fluctuation is working");
				
			}
  			
  			break;

		default:
			
			String red = "\u001B[31m";
			System.err.println(red+"Predefined Market Watch List Not Loaded");
			break;
		}
		
		
		Thread.sleep(1000);
		
	}
	
  
	@When("User Check The Current Stock to Market WatchList")
	public void user_check_the_current_stock_to_market_watch_list() throws InterruptedException, AWTException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String stockNSE ="EICHERMOT";
		String stockBSE ="RELIANCE-A";
		String nifty ="NIFTY";
		String sensex ="SENSEX";
		String stockMCX ="GOLDPETAL";
		//String optinsBSE ="ICICIBANK-A";
		String optinsNSE ="TATASTEEL-EQ";
		String optinNifty ="NIFTY 50";

		
		
		LocalDate today = LocalDate.now();
        String day = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println("Today is: " + day);
		
		
		if (day.equals("Monday")) {
			//if (day.equals(true)) {	
			try {
				
				List<WebElement> elements = driver.findElements(By.xpath("//div[@class='tabs-panel is-active']/div/div/ul/li/div/div/span[@class='symbolsseries']"));
				
				for (WebElement webElement : elements) {
					
					webElement.click();
					Thread.sleep(500);
					WebElement element = driver.findElement(By.xpath("//button[@class='s_close md_btn1']"));
					element.click();
					Thread.sleep(500);
					
				}
				
				
			} 
			
			catch (Exception e) {
				
				System.out.println("All Ready Delete the Market Watch List to Stocks");
			}
			
			Thread.sleep(2000);
			
			WebElement element = driver.findElement(By.xpath("//input[@id='project-id']"));
			if (element.isDisplayed()) {
				
			
			element.click();
			Thread.sleep(1000);
			StringSelection selection2 = new StringSelection(stockBSE);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection2, null);

            Thread.sleep(1000); // Wait 1 sec to ensure clipboard is ready

            Robot  robot1=new Robot();
            robot1.keyPress(KeyEvent.VK_CONTROL);
            robot1.keyPress(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(2000); // Small delay

			
			WebElement element2 = driver.findElement(By.xpath("(//span[contains(text(),'"+stockBSE+"')]//following-sibling::span[text()='BSE'])[1]"));
			Actions s =new Actions(driver);
		     Thread.sleep(1000); 
			s.moveToElement(element2).perform();
			
			Thread.sleep(1000);
			WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='s_add_sym']")));
			element4.click();
			
			Thread.sleep(1000);
			WebElement element3 = driver.findElement(By.xpath("//span[@class='src_clear']"));
			element3.click();
	
			Thread.sleep(2000);
			
			WebElement element31 = driver.findElement(By.xpath("//input[@id='project-id']"));
			element31.click();
			Thread.sleep(1000);
			
			StringSelection selection21 = new StringSelection(stockNSE);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection21, null);

            Thread.sleep(1000); // Wait 1 sec to ensure clipboard is ready

           // Robot  robot1=new Robot();
            robot1.keyPress(KeyEvent.VK_CONTROL);
            robot1.keyPress(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(2000);
			
			
			WebElement element21 = driver.findElement(By.xpath("//span[contains(text(),'"+stockNSE+"')]//following-sibling::span[text()='NSE']"));
	
		     Thread.sleep(1000);
			s.moveToElement(element21).perform();
			
			Thread.sleep(1000);
			//WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element41 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='s_add_sym']")));
			element41.click();
			
			try {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
				
			} catch (Exception e) {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
			}

			Thread.sleep(1000);
			
			WebElement element6 = driver.findElement(By.xpath("(//span[contains(text(),'"+stockNSE+"')]//parent::div[@class='s-box']//child::span[text()='NSE'])[1]"));
			Thread.sleep(1000);
			s.moveToElement(element6).perform();
			
			WebElement stock = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='s_add_sym']")));
			stock.click();
			
			Thread.sleep(1000);
			WebElement element11 = driver.findElement(By.xpath("//span[@class='src_clear']"));
			element11.click();
			
Thread.sleep(2000);
			
			WebElement element311 = driver.findElement(By.xpath("//input[@id='project-id']"));
			element311.click();
			Thread.sleep(1000);
			
			StringSelection selection211 = new StringSelection(nifty);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection211, null);

            Thread.sleep(1000); // Wait 1 sec to ensure clipboard is ready

           // Robot  robot1=new Robot();
            robot1.keyPress(KeyEvent.VK_CONTROL);
            robot1.keyPress(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(2000);
			
            try {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
				
			} catch (Exception e) {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
			}

			Thread.sleep(1000);
			
			WebElement element61 = driver.findElement(By.xpath("(//span[contains(text(),'"+nifty+"')]//parent::div[@class='s-box']//child::span[text()='NSE'])[1]"));
			Thread.sleep(1000);
			s.moveToElement(element61).perform();
			
			Thread.sleep(1000);
			//WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element411 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='s_add_sym']")));
			element411.click();
			
			Thread.sleep(1000);
			WebElement element111 = driver.findElement(By.xpath("//span[@class='src_clear']"));
			element111.click();
			
			Thread.sleep(2000);

			
			WebElement element3111 = driver.findElement(By.xpath("//input[@id='project-id']"));
			element3111.click();
			Thread.sleep(1000);
			
			StringSelection selection2111 = new StringSelection(sensex);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection2111, null);

            Thread.sleep(1000); // Wait 1 sec to ensure clipboard is ready

           // Robot  robot1=new Robot();
            robot1.keyPress(KeyEvent.VK_CONTROL);
            robot1.keyPress(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(2000);
			
            try {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
				
			} catch (Exception e) {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
			}

			Thread.sleep(1000);
			
			WebElement element611 = driver.findElement(By.xpath("(//span[contains(text(),'"+sensex+"')]//parent::div[@class='s-box']//child::span[text()='BSE'])[1]"));
			Thread.sleep(1000);
			s.moveToElement(element611).perform();
			
			Thread.sleep(1000);
			//WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element4111 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='s_add_sym']")));
			element4111.click();
			
			Thread.sleep(1000);
			WebElement element1111 = driver.findElement(By.xpath("//span[@class='src_clear']"));
			element1111.click();
			
		
			
Thread.sleep(2000);

			
			WebElement element31111 = driver.findElement(By.xpath("//input[@id='project-id']"));
			element31111.click();
			Thread.sleep(1000);
			
			StringSelection selection21111 = new StringSelection(stockMCX);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection21111, null);

            Thread.sleep(1000); // Wait 1 sec to ensure clipboard is ready

           // Robot  robot1=new Robot();
            robot1.keyPress(KeyEvent.VK_CONTROL);
            robot1.keyPress(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(2000);
			
            try {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
				
			} catch (Exception e) {
				
				driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
			}

			Thread.sleep(1000);
			
			try {
				
				WebElement element6111 = driver.findElement(By.xpath("(//span[contains(text(),'"+stockMCX+"')]//parent::div[@class='s-box']//child::span[text()='MCX'])[1]"));
				Thread.sleep(1000);
				s.moveToElement(element6111).perform();
				
			} catch (Exception e) {
				
				WebElement element6111 = driver.findElement(By.xpath("(//span[contains(text(),'"+stockMCX+"')]//parent::div[@class='s-box']//child::span[text()='MCX'])[1]"));
				Thread.sleep(1000);
				s.moveToElement(element6111).perform();
				
			}
			
			
			
			Thread.sleep(1000);
			//WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element41111 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='s_add_sym']")));
			element41111.click();
			
			Thread.sleep(1000);
			WebElement element11111 = driver.findElement(By.xpath("//span[@class='src_clear']"));
			element11111.click();
			
			Thread.sleep(2000);
			
//============================================================
			
			WebElement element311111 = driver.findElement(By.xpath("//input[@id='project-id']"));
			element311111.click();
			Thread.sleep(1000);
			
			StringSelection selection211111 = new StringSelection(optinsNSE);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection211111, null);

            Thread.sleep(1000); // Wait 1 sec to ensure clipboard is ready

           // Robot  robot1=new Robot();
            robot1.keyPress(KeyEvent.VK_CONTROL);
            robot1.keyPress(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(2000);
			
			//driver.findElement(By.xpath("(//span[contains(text(),'"+string2+"')])[2]")).click();
			Thread.sleep(3000);
			
			Actions s11=new Actions(driver);
			WebDriverWait wait111 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement lement11 = wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='"+optinsNSE+"']//following-sibling::span[text()='NSE'])[1]")));
		//WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string3+"']"));
			Thread.sleep(1000);
			s11.moveToElement(lement11).perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='"+optinsNSE+"']//following-sibling::span[text()='NSE']")).click();
		
			Thread.sleep(1000);
			
			WebElement fund = driver.findElement(By.xpath("(//span[contains(text(),'"+optinsNSE+"')]//ancestor::div[contains(@class,'dhx_widget')]//descendant::span[@class='sys_vl'])[1]"));
			String text = fund.getText();

			Thread.sleep(1000);
			
			double doubleValue = Double.parseDouble(text);

			// Convert to integer for rounding
			int intValue = (int) doubleValue;

			// Round to nearest 50, adjusting based on the fractional part
			int roundedValue;
			if (doubleValue % 20 > 0) {
			    roundedValue = ((intValue / 20) + 1) * 20; // Round up
			} else {
			    roundedValue = (intValue / 20) * 20; // Round down or stay as is
			}
			
			String purple = "\u001B[35m";

			System.out.println(purple+"Stock Current Strike Value: " + roundedValue);
		

			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='s_more md_btn1']")).click();
			Thread.sleep(3000);
			
			WebElement lement2 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
			driver.switchTo().frame(lement2);
			
			Thread.sleep(3000);
			WebElement lement4 = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
			String text2 = lement4.getText();
			
			
			Thread.sleep(1000);
			if (text2.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
				
			} else {
				
				System.err.println("Ready-made strategy builder Close Button Not Working");

			}
			
			try {
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span)[1]")).click();
				Thread.sleep(2000);
				
				driver.switchTo().defaultContent();
				
				driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//span[text()='Clear']")).click();
				Thread.sleep(1000);
				
			}catch (Exception e){
				
				
			}

	
			
						Thread.sleep(5000);

							
							WebElement elementa = driver
							.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
					elementa.click();
					
					Thread.sleep(1000);
					
					
					WebElement stocka = driver
							.findElement(By.xpath("//span[text()='"+optinNifty+"']"));
					
					stocka.click();
	
					
					Thread.sleep(1000);
					
					WebElement funds = driver.findElement(By.xpath("(//span[text()='NIFTY 50']//following-sibling::div//child::span)[1]"));
					String texts = funds.getText();

					Thread.sleep(1000);
					
					double doubleValues = Double.parseDouble(texts);

					// Convert to integer for rounding
					int intValues = (int) doubleValues;

					// Round to nearest 50, adjusting based on the fractional part
					int roundedValue11;
					if (doubleValue % 50 > 0) {
					    roundedValue11 = ((intValues / 50) + 1) * 50; // Round up
					} else {
					    roundedValue11 = (intValues / 50) * 50; // Round down or stay as is
					}
					
					String purple11 = "\u001B[35m";

					System.out.println(purple11+"Nifty Current Strike Value: " + roundedValue11);
					
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
					
					WebElement element211 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
					driver.switchTo().frame(element211);
					
					Thread.sleep(3000);
					WebElement elementq = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
					String text211 = elementq.getText();
					
					
					Thread.sleep(1000);
					if (text211.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
						
						Thread.sleep(1000);
						driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
						
					} else {
						
						System.err.println("Ready-made strategy builder Close Button Not Working");

					}
					driver.switchTo().defaultContent();
					
					Thread.sleep(2000);
					try {
						
						WebElement km = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
						driver.switchTo().frame(km);
						Thread.sleep(2000);
						
						WebElement element7 = driver.findElement(By.xpath("//select[@id='symbols_list']"));
						Select d=new Select(element7);
						d.selectByVisibleText("NIFTY - NFO");
						
						Thread.sleep(3000);
						Actions f=new Actions(driver);
						
						WebElement d1 = driver.findElement(By.xpath("(//div[text()='"+roundedValue11+"']//parent::div//descendant::span)[1]"));
						f.moveToElement(d1).perform();
						Thread.sleep(2000);
						f.click(d1).perform();
						Thread.sleep(2000);
						
						driver.switchTo().defaultContent();
						
						driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
						Thread.sleep(1000);
						
						driver.findElement(By.xpath("//span[text()='Clear']")).click();
						Thread.sleep(1000);
						
						
						
					} catch (Exception e) {
						
						Actions a=new Actions(driver);
						WebElement km = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
						driver.switchTo().frame(km);
						Thread.sleep(2000);
						
						WebElement d = driver.findElement(By.xpath("(//div[text()='"+roundedValue11+"']//parent::div//descendant::span)[1]"));
						a.moveToElement(d).perform();
						Thread.sleep(2000);
						a.click(d).perform();
						Thread.sleep(2000);
						
						driver.switchTo().defaultContent();
						
						driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
						Thread.sleep(1000);
						
						driver.findElement(By.xpath("//span[text()='Clear']")).click();
						Thread.sleep(1000);
						
						
					}
					
					
					
					
				    	  Thread.sleep(1000);
				    	  
				    	  WebElement nifty1 = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX'])[1]"));
				    	  String text3 = nifty1.getText();
				    	  System.out.println(text3);
				    	  
				    	  Thread.sleep(1000);
				    	  if (text3.equalsIgnoreCase("S&P BSE SENSEX")) {
				    		  
				    		  Thread.sleep(1000);
				    		  
				    		  WebElement fund11 = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX']//following-sibling::div//child::span)[1]"));
				      		String text11 = fund11.getText();

				      		Thread.sleep(1000);
				      		
				      		double doubleValue11 = Double.parseDouble(text11);

				      		// Convert to integer for rounding
				      		int intValue11 = (int) doubleValue11;

				      		// Round to nearest 50, adjusting based on the fractional part
				      		int pp;
				      		if (doubleValue11 % 100 > 0) {
				      		    pp = ((intValue11 / 100) + 1) * 100; // Round up
				      		} else {
				      		    pp = (intValue11 / 100) * 100; // Round down or stay as is
				      		}
				      		
				      		
				      		String op = "\u001B[35m";
				      		

				      		System.out.println(op+"Sensex Current Strike Value: " + pp);
				      		
				      		Thread.sleep(2000);

				      		driver.findElement(By.xpath("//input[@id='project-id']")).click();
				      		Thread.sleep(1000);
				      		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys("Sensex");
				      		Thread.sleep(3000);

				      		WebElement io = driver.findElement(By.xpath("//span[text()='Futures']"));
				      		io.click();
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
				      		
				      		WebElement l = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
				      		driver.switchTo().frame(l);
				      		
				      		Thread.sleep(3000);
				      		WebElement p = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
				      		String text12 = p.getText();
				      		
				      		
				      		
				      		Thread.sleep(1000);
				      		if (text12.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
				      			
				      			Thread.sleep(1000);
				      			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
				      			
				      		} else {
				      			
				      			System.err.println("Ready-made strategy builder Close Button Not Working");

				      		}
				      		
				      		Thread.sleep(1000);
				      		Actions u = new Actions(driver);
				      		
				      		WebElement i = driver.findElement(By.xpath("(//div[text()='"+pp+"'])[1]"));
				      		
				      		Thread.sleep(1000);
				      		u.moveToElement(i).perform();
				      		Thread.sleep(1000);
				      		
				      		driver.findElement(By.xpath("(//div[text()='"+pp+"']//parent::div//child::span)[1]")).click();
				      		
				      		Thread.sleep(2000);
				      		
				      		driver.switchTo().defaultContent();
				      		
				      		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
				      		Thread.sleep(1000);
				      		
				      		driver.findElement(By.xpath("//span[text()='Clear']")).click();
				      		Thread.sleep(1000);
				      		
				      		Actions a3 = new Actions(driver);
				      		
				      			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+pp+"')]//preceding-sibling::span[text()='BSE']"));
				      			
				      			a3.moveToElement(stoc).perform();
				      			Thread.sleep(1000);
				      			JavascriptExecutor js1 = (JavascriptExecutor) driver;
				      	       js1.executeScript("arguments[0].click();", stoc);

				      		
				      			Thread.sleep(2000);
//				      			driver.findElement(By.xpath("//button[@class='buy buyorder']"))
//				      					.click();
				    		  
							
						} else {


							WebElement element8 = driver
									.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
							element8.click();
							
							Thread.sleep(1000);
							
							//Actions a = new Actions(driver);
							
							WebElement stock111 = driver
									.findElement(By.xpath("//span[text()='S&P BSE SENSEX']"));
							
							stock111.click();
							
//							a.moveToElement(stock).perform();
//							Thread.sleep(1000);
//							a.click(stock).perform();
							
							Thread.sleep(1000);
				    		
				    		WebElement fund11 = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX']//following-sibling::div//child::span)[1]"));
				    		String text11 = fund11.getText();

				    		Thread.sleep(1000);
				    		
				    		double doubleValue11 = Double.parseDouble(text11);

				    		// Convert to integer for rounding
				    		int intValue11 = (int) doubleValue11;

				    		// Round to nearest 50, adjusting based on the fractional part
				    		int roundedValue111;
				    		if (doubleValue11 % 100 > 0) {
				    		    roundedValue111 = ((intValue11 / 100) + 1) * 100; // Round up
				    		} else {
				    		    roundedValue111 = (intValue11 / 100) * 100; // Round down or stay as is
				    		}
				    		
				    		
				    		String purple111 = "\u001B[35m";
				    		

				    		System.out.println(purple111+"Sensex Current Strike Value: " + roundedValue111);
				    		
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
				    		
				    		WebElement v = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
				    		driver.switchTo().frame(v);
				    		
				    		Thread.sleep(3000);
				    		WebElement k = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
				    		String text12 = k.getText();
				    		
				    		
				    		
				    		Thread.sleep(1000);
				    		if (text12.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
				    			
				    			Thread.sleep(1000);
				    			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
				    			
				    		} else {
				    			
				    			System.err.println("Ready-made strategy builder Close Button Not Working");

				    		}
				    		
				    		Thread.sleep(1000);
				    		Actions s1 = new Actions(driver);
				    		
				    		WebElement d1 = driver.findElement(By.xpath("(//div[text()='"+roundedValue111+"'])[1]"));
				    		
				    		Thread.sleep(1000);
				    		s1.moveToElement(d1).perform();
				    		Thread.sleep(1000);
				    		
				    		driver.findElement(By.xpath("(//div[text()='"+roundedValue111+"']//parent::div//child::span)[1]")).click();
				    		
				    		Thread.sleep(2000);
				    		
				    		driver.switchTo().defaultContent();
				    		
				    		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
				    		Thread.sleep(1000);
				    		
				    		driver.findElement(By.xpath("//span[text()='Clear']")).click();
				    		Thread.sleep(1000);
				    		
				    		
						}
							

										
						
						
			
			
			}
			
			
		}
		
		else{
			
			System.out.println("Placing AMO Orders for Already Added Stocks");
		}
		
		
		
		Thread.sleep(2000);
		
		
	}
	
	
	@When("User Click The {string} Options in Market WatchList")
	public void user_click_the_options_in_market_watch_list(String string) throws InterruptedException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
			
			try {
				
				List<WebElement> elements = driver.findElements(By.xpath("//div[@class='tabs-panel is-active']//ancestor::div/span[@class='symbolsseries']"));
				Thread.sleep(1000);
				for (WebElement webElement : elements) {
					Thread.sleep(1000);
						webElement.click();
						Thread.sleep(1000);
						WebElement element = driver.findElement(By.xpath("//button[contains(@class,'"+string+"')]"));
						element.click();
						Thread.sleep(1000);
						
						
						WebElement element2 = driver.findElement(By.xpath("//button[text()='BUY']"));
						element2.click();
						
						Thread.sleep(1000);
						WebElement element21 = driver.findElement(By.xpath("//button[text()='yes']"));
						element21.click();
						
						try {		
							
						Thread.sleep(1000);
						
						WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
						WebElement gh = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-dhx-id='close']")));
						gh.click();
						
					} catch (Exception e) {
						
						try {
							
							Thread.sleep(2000);
							WebDriverWait wait11 = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
							WebElement element4 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-dhx-id='close'])[2]")));
							
							
							if (element4.isDisplayed()) {
								
								WebElement element41 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-dhx-id='close'])[2]")));
								element41.click();
								
								Thread.sleep(2000);
								WebElement l = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
								l.click();
							}
					
							
						} catch (Exception e2) {
							
							WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
							WebElement elementj2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Insufficient Fund']")));
							
							Thread.sleep(1000);
							if (elementj2.isDisplayed()) {
								
								WebElement element3 = driver.findElement(By.xpath("(//button[@class='close-button'])[6]"));
								element3.click();
								Thread.sleep(1000);
								
								WebElement h = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
								h.click();
								
							}
						}
						
						
						
						
					}
					
					
					
				}
				
				
			} 
			
			catch (Exception e) {
				
				System.out.println("Element Not Visiable the Market Watch List to Stocks");
			}
			
	}
	
	@When("User Modify The AMO Order")
	public void user_modify_the_amo_order() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element = driver.findElement(By.xpath("//span[text()='Orders']//ancestor::li[contains(@class,'left_tab_btn1')]"));
		Actions g=new Actions(driver);
		g.moveToElement(element).perform();
		
		Thread.sleep(1000);
		element.click();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,500);");
		
	      
			
			
			try {
				
				 WebElement i = driver.findElement(By.xpath("(//div[text()='Pending']//ancestor::div[contains(@class,'dhx_grid-row')]//descendant::span[@class='cntx_menu order_context'])[1]"));
					i.click();
					Thread.sleep(1000);   
					
					JavascriptExecutor j1 = (JavascriptExecutor) driver;
				
				WebElement elemet21 = driver.findElement(By.xpath("(//span[text()='Modify'])[1]"));
				elemet21.click();
				
				Thread.sleep(1000);  
				WebElement element2 = driver.findElement(By.xpath("//div[@class='pop-chart-cont']//descendant::span[@class='sys_vl']"));
				String text = element2.getText();
				double d1 = Double.parseDouble(text);
				 String blue = "\u001B[34m";
				System.out.println(blue+"Stock Value : "+text);
				double d=d1+5;
				
				Thread.sleep(1000);
				String s = String.valueOf(d);
				WebElement element3 = driver.findElement(By.xpath("//label[text()='Price']//following-sibling::input[@name='price']"));
				element3.click();
				Thread.sleep(1000);
				element3.clear();
				Thread.sleep(1000);
				element3.sendKeys(s);
				
				Thread.sleep(1000);
				
				WebElement element4 = driver.findElement(By.xpath("(//button[text()='Update'])[1]"));
				j1.executeScript("arguments[0].click();", element4);
				
	            Thread.sleep(1000);	
				WebElement element41 = driver.findElement(By.xpath("//button[text()='yes']"));
				j1.executeScript("arguments[0].click();", element41);
			
				
			} catch (Exception e) {
				
				 js.executeScript("window.scrollBy(0,500);");
				 js.executeScript("window.scrollBy(0,500);");
				 
				 
				 try {
					
					 
					 try {
						 
						 WebElement i = driver.findElement(By.xpath("(//div[text()='Pending']//ancestor::div[contains(@class,'dhx_grid-row')]//descendant::span[@class='cntx_menu order_context'])[1]"));
							g.moveToElement(i).click().perform();
							Thread.sleep(1000); 
						
					} catch (Exception e2) {
						
						 js.executeScript("window.scrollBy(0,1000);");
						 js.executeScript("window.scrollBy(0,1000);");
						 
						 WebElement i = driver.findElement(By.xpath("(//div[text()='Pending']//ancestor::div[contains(@class,'dhx_grid-row')]//descendant::span[@class='cntx_menu order_context'])[2]")); 
						 js.executeScript("arguments[0].click();", i);
						 
					}
					 
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
					
					
					JavascriptExecutor j1 = (JavascriptExecutor) driver;
					
					try {
						
						WebElement element2 = driver.findElement(By.xpath("(//span[text()='Modify'])[1]"));
						element2.click();
						
					} catch (Exception e2) {
						
						driver.switchTo().defaultContent();
						WebElement elemet21 = driver.findElement(By.xpath("(//span[text()='Modify'])[1]"));
						g.moveToElement(elemet21).click().perform();
						System.out.println("hi");
						
						
					}
				
				
			      
			      Thread.sleep(1000);  
					WebElement element2 = driver.findElement(By.xpath("//div[@class='pop-chart-cont']//descendant::span[@class='sys_vl']"));
					String text = element2.getText();
					double d1 = Double.parseDouble(text);
					 String blue = "\u001B[34m";
					System.out.println(blue+"Stock Value : "+text);
					double d=d1+5;
					
					Thread.sleep(1000);
					String s = String.valueOf(d);
					WebElement element3 = driver.findElement(By.xpath("//label[text()='Price']//following-sibling::input[@name='price']"));
					element3.click();
					Thread.sleep(1000);
					element3.clear();
					Thread.sleep(1000);
					element3.sendKeys(s);
					
					Thread.sleep(1000);
					
					WebElement element4 = driver.findElement(By.xpath("(//button[text()='Update'])[1]"));
					j1.executeScript("arguments[0].click();", element4);
					
		            Thread.sleep(1000);	
					WebElement element41 = driver.findElement(By.xpath("//button[text()='yes']"));
					j1.executeScript("arguments[0].click();", element41);
			      
			}
	       
			
			
			
			
			Thread.sleep(2000);
			
			
	}
	
	@When("User All Type to Cancel The All AMO Orders")
	public void user_all_type_to_cancel_the_all_amo_orders() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		Actions g=new Actions(driver);   
		Thread.sleep(1000);
		WebElement element2 = driver.findElement(By.xpath("(//div[text()='Pending']//ancestor::div[contains(@class,'dhx_grid-row')]//descendant::input[@class='custom_div orders_checkbox'])[2]"));
		g.moveToElement(element2).perform();
		g.click(element2).perform();
		Thread.sleep(1000);
		
		WebElement elemet2 = driver.findElement(By.xpath("//span[text()='Cancel']"));
		g.moveToElement(elemet2).perform();
		g.click(elemet2).perform();
		
		Thread.sleep(1000);
		WebElement element3 = driver.findElement(By.xpath("//button[text()='yes']"));
		element3.click();
		
		Thread.sleep(3000);
		WebElement elemen2 = driver.findElement(By.xpath("(//div[text()='Pending']//ancestor::div[contains(@class,'dhx_grid-row')]//descendant::span[@class='cntx_menu order_context'])[2]"));
		g.moveToElement(elemen2).perform();
		g.click(elemen2).perform();
		Thread.sleep(1000);
		
		WebElement elemet21 = driver.findElement(By.xpath("//span[text()='Cancel']//ancestor::span[contains(@class,'dhx_menu-button__block')]"));
		g.moveToElement(elemet21).perform();
		g.click(elemet21).perform();
		
		Thread.sleep(1000);
		WebElement elemet = driver.findElement(By.xpath("//button[text()='yes']"));
		elemet.click();
		
		Thread.sleep(3000);
		WebElement elemet1 = driver.findElement(By.xpath("//span[text()='Cancel All']"));
		g.moveToElement(elemet1).perform();
		Thread.sleep(1000);
		g.click(elemet1).perform();
		
		Thread.sleep(1000);
		WebElement elemet11 = driver.findElement(By.xpath("//button[text()='yes']"));
		elemet11.click();
		
		Thread.sleep(2000);
		
		
	}
	
	@When("User Select The Current {string} Options To Hedging Margin")
	public void user_select_the_current_options_to_hedging_margin(String string) throws InterruptedException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
      switch (string) {
		
		case "Nifty 50":
			
			WebElement element6 = driver.findElement(By.xpath("(//span[text()='NIFTY 50'])[1]"));
			
			if (element6.isDisplayed()) {
				
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
				int roundedValues =roundedValue-50;
				
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
				
				try {
					
					Actions a1 = new Actions(driver);
					WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
					Thread.sleep(1000);
					a1.moveToElement(stock1).perform();
					Thread.sleep(1000);
					a1.click(stock1).perform();
					
				} catch (Exception e) {
					
					try {
						
						driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
						
					} catch (Exception e3) {
						
						driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
					}

					Thread.sleep(2000);
					Actions a1 = new Actions(driver);
					WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
					Thread.sleep(1000);
					a1.moveToElement(stock1).perform();
					Thread.sleep(1000);
					a1.click(stock1).perform();
					
				}
				
				
				
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
				

				
			try {
					
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[text()='"+roundedValues+"']//parent::div//descendant::span[contains(@class,'strategy_call_buy')])[1]")).click();
				Thread.sleep(1000);
				
				WebElement element = driver.findElement(By.xpath("//p[text()='Margin needed']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
			       js.executeScript("arguments[0].scrollIntoView();", element);
			       
			       Thread.sleep(1000);
			       
			    WebElement element3 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
			    String text3 = element3.getText();
			    double int1 = Double.parseDouble(text3);
			    System.out.println("BUY Margin Value : "+text3);
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span[contains(@class,'strategy_call_sell')])[1]")).click();
				Thread.sleep(4000);
				
				Thread.sleep(1000);
			       
			    WebElement element31 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
			    String text31 = element31.getText();
			    double int2 = Double.parseDouble(text31);
			    Thread.sleep(1000);
			    double sell =int2-int1;
			    
			    System.out.println("SELL Margin Value : "+sell);
			    
			    System.out.println("Total Margin Value : "+text31);
			    Thread.sleep(1000);
			    
			    WebElement element5 = driver.findElement(By.xpath("//table[@class='nw_strategy']/tbody/tr[1]/td[7]/child::input"));
			    element5.click();
			    Thread.sleep(1000);
			    element5.clear();
			    Thread.sleep(1000);
			    element5.sendKeys("0");
			    //JavascriptExecutor js = (JavascriptExecutor) driver;
			       js.executeScript("window.scrollBy(0,500);");
			    WebElement element51 = driver.findElement(By.xpath("//table[@class='nw_strategy']/tbody/tr[2]/td[7]/child::input"));
			  
			    element51.click();
			    Thread.sleep(1000);
			    element51.clear();
			    Thread.sleep(1000);
			    element51.sendKeys("0");
			    
               Thread.sleep(2000);
               WebElement element7 = driver.findElement(By.xpath("//p[text()='Margin needed']"));
               element7.click();
               Thread.sleep(4000);
               
			    WebElement element311 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
			    String text311 = element311.getText();
			    String yellow = "\u001B[33m";
			    System.out.println(yellow+"Hedgin Margin Value : "+text311);
					
				} catch (Exception e) {
					
					Thread.sleep(1000);
					WebElement element3 = driver.findElement(By.xpath("//select[@id='symbols_list']"));
					Select d=new Select(element3);
					d.selectByVisibleText("NIFTY - NFO");
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("(//div[text()='"+roundedValues+"']//parent::div//descendant::span[contains(@class,'strategy_call_buy')])[1]")).click();
					Thread.sleep(1000);
					
					WebElement element = driver.findElement(By.xpath("//p[text()='Margin needed']"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
				       js.executeScript("arguments[0].scrollIntoView();", element);
				       
				       Thread.sleep(1000);
				       
				    WebElement eds = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
				    String text3 = eds.getText();
				    double int1 = Double.parseDouble(text3);
				   // int int1 = Integer.parseInt(text3);
				    System.out.println("BUY Margin Value : "+text3);
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span[contains(@class,'strategy_call_sell')])[1]")).click();
					Thread.sleep(4000);
					
					Thread.sleep(1000);
				       
				    WebElement element31 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
				    String text31 = element31.getText();
				    double int2 = Double.parseDouble(text31);
				   // int int2 = Integer.parseInt(text31);
				    Thread.sleep(1000);
				    double sell =int2-int1;
				    
				    System.out.println("SELL Margin Value : "+sell);
				    
				    System.out.println("Total Margin Value : "+text31);
				    Thread.sleep(1000);
				    
				    WebElement element5 = driver.findElement(By.xpath("//table[@class='nw_strategy']/tbody/tr[1]/td[7]/child::input"));
				    element5.click();
				    Thread.sleep(1000);
				    element5.clear();
				    Thread.sleep(1000);
				    element5.sendKeys("0");
				    //JavascriptExecutor js = (JavascriptExecutor) driver;
				       js.executeScript("window.scrollBy(0,500);");
				    WebElement element51 = driver.findElement(By.xpath("//table[@class='nw_strategy']/tbody/tr[2]/td[7]/child::input"));
				  
				    element51.click();
				    Thread.sleep(1000);
				    element51.clear();
				    Thread.sleep(1000);
				    element51.sendKeys("0");
				    
	               Thread.sleep(2000);
	               WebElement element7 = driver.findElement(By.xpath("//p[text()='Margin needed']"));
	               element7.click();
	               Thread.sleep(4000);
	               
				    WebElement element311 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
				    String text311 = element311.getText();
				    String yellow = "\u001B[33m";
				    System.out.println(yellow+"Hedgin Margin Value : "+text311);
				}
				
			}else {
				
				WebElement element = driver
						.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
				element.click();
				
				Thread.sleep(1000);
				
				//Actions a = new Actions(driver);
				
				WebElement stock = driver
						.findElement(By.xpath("//span[text()='NIFTY 50']"));
				
				stock.click();
				
//				a.moveToElement(stock).perform();
//				Thread.sleep(1000);
//				a.click(stock).perform();
				
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
				int roundedValues=roundedValue-50;
				Thread.sleep(2000);
				WebElement jkl = driver
						.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
				jkl.click();
				
				Thread.sleep(4000);

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
				

				
			try {
					
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[text()='"+roundedValues+"']//parent::div//descendant::span[contains(@class,'strategy_call_buy')])[1]")).click();
				Thread.sleep(1000);
				
				WebElement tfg = driver.findElement(By.xpath("//p[text()='Margin needed']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
			       js.executeScript("arguments[0].scrollIntoView();", tfg);
			       
			       Thread.sleep(1000);
			       
			    WebElement element3 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
			    String text3 = element3.getText();
			    double int1 = Double.parseDouble(text3);
			    System.out.println("BUY Margin Value : "+text3);
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span[contains(@class,'strategy_call_sell')])[1]")).click();
				Thread.sleep(4000);
				
				Thread.sleep(1000);
			       
			    WebElement element31 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
			    String text31 = element31.getText();
			    double int2 = Double.parseDouble(text31);
			    Thread.sleep(1000);
			    double sell =int2-int1;
			    
System.out.println("SELL Margin Value : "+sell);
			    
			    System.out.println("Total Margin Value : "+text31);
			    Thread.sleep(1000);
			    
			    WebElement element5 = driver.findElement(By.xpath("//table[@class='nw_strategy']/tbody/tr[1]/td[7]/child::input"));
			    element5.click();
			    Thread.sleep(1000);
			    element5.clear();
			    Thread.sleep(1000);
			    element5.sendKeys("0");
			    //JavascriptExecutor js = (JavascriptExecutor) driver;
			       js.executeScript("window.scrollBy(0,500);");
			    WebElement element51 = driver.findElement(By.xpath("//table[@class='nw_strategy']/tbody/tr[2]/td[7]/child::input"));
			  
			    element51.click();
			    Thread.sleep(1000);
			    element51.clear();
			    Thread.sleep(1000);
			    element51.sendKeys("0");
			    
               Thread.sleep(2000);
               WebElement element7 = driver.findElement(By.xpath("//p[text()='Margin needed']"));
               element7.click();
               Thread.sleep(4000);
               
			    WebElement element311 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
			    String text311 = element311.getText();
			    String yellow = "\u001B[33m";
			    System.out.println(yellow+"Hedgin Margin Value : "+text311);
					
				} catch (Exception e) {
					
					Thread.sleep(1000);
					WebElement element3 = driver.findElement(By.xpath("//select[@id='symbols_list']"));
					Select d=new Select(element3);
					d.selectByVisibleText("NIFTY - NFO");
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("(//div[text()='"+roundedValues+"']//parent::div//descendant::span[contains(@class,'strategy_call_buy')])[1]")).click();
					Thread.sleep(1000);
					
					WebElement dfgs = driver.findElement(By.xpath("//p[text()='Margin needed']"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
				       js.executeScript("arguments[0].scrollIntoView();", dfgs);
				       
				       Thread.sleep(1000);
				       
				    WebElement gv = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
				    String text3 = gv.getText();
				    double int1 = Double.parseDouble(text3);
				    System.out.println("BUY Margin Value : "+text3);
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span[contains(@class,'strategy_call_sell')])[1]")).click();
					Thread.sleep(4000);
					
					Thread.sleep(1000);
				       
				    WebElement element31 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
				    String text31 = element31.getText();
				    double int2 = Double.parseDouble(text31);
				    Thread.sleep(1000);
				    double sell =int2-int1;
				    
				    System.out.println("SELL Margin Value : "+sell);
				    
				    System.out.println("Total Margin Value : "+text31);
				    Thread.sleep(1000);
				    
				    WebElement element5 = driver.findElement(By.xpath("//table[@class='nw_strategy']/tbody/tr[1]/td[7]/child::input"));
				    element5.click();
				    Thread.sleep(1000);
				    element5.clear();
				    Thread.sleep(1000);
				    element5.sendKeys("0");
				    //JavascriptExecutor js = (JavascriptExecutor) driver;
				       js.executeScript("window.scrollBy(0,500);");
				    WebElement element51 = driver.findElement(By.xpath("//table[@class='nw_strategy']/tbody/tr[2]/td[7]/child::input"));
				  
				    element51.click();
				    Thread.sleep(1000);
				    element51.clear();
				    Thread.sleep(1000);
				    element51.sendKeys("0");
				    
	               Thread.sleep(2000);
	             
	               WebElement element7 = driver.findElement(By.xpath("//p[text()='Margin needed']"));
	               element7.click();
	               Thread.sleep(4000);
	               
				    WebElement element311 = driver.findElement(By.xpath("//p[text()='Margin needed']//following-sibling::span"));   
				    String text311 = element311.getText();
				    String yellow = "\u001B[33m";
				    System.out.println(yellow+"Hedgin Margin Value : "+text311);
					
				}
				
				
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
      		
      			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BFO']"));
      			
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
    		
    			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BFO']"));
    			
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
	
	@Given("User Add\\/Remove the Stocks to Market Watshlist Max Scrip")
	public void user_add_remove_the_stocks_to_market_watshlist_max_scrip() throws InterruptedException, AWTException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='ind_dropdown']/div/div/span/span//following-sibling::div/span"));
		element.click();
		Thread.sleep(1000);
		
		try {
			
			WebElement element2 = driver.findElement(By.xpath("(//span[text()='NIFTY 50'])[2]"));
			action.moveToElement(element2).perform();
			Thread.sleep(1000);
			
			WebElement element3 = driver.findElement(By.xpath("(//span[@data-symbol='NIFTY 50'])[2]"));
			element3.click();
			Thread.sleep(1000);
			
			WebElement element4 = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));
			if (element4.isDisplayed()) {
				String blue = "\u001B[34m";
				System.out.println(blue+"verify the pop up is displayed");
				
			} 
			
			else {
				System.err.println("verify the pop up is not displayed");

			}

			Thread.sleep(1000);
			WebElement element21 = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX'])[1]"));
			action.moveToElement(element21).perform();
			Thread.sleep(1000);
			
			WebElement element31 = driver.findElement(By.xpath("(//span[@data-symbol='S&P BSE SENSEX'])[1]"));
			element31.click();
			Thread.sleep(1000);
			
			WebElement element41 = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));
			if (element41.isDisplayed()) {
				String blue = "\u001B[34m";
				System.out.println(blue+"verify the pop up is displayed");
				
			} 
			
			else {
				System.err.println("verify the pop up is not displayed");

			}
			
			WebElement cl = driver.findElement(By.xpath("//div[@class='ind_dropdown']/div/div/span/span//following-sibling::div/span"));
			cl.click();
			Thread.sleep(1000);
			
			
		} catch (Exception e) {
			
			WebElement element2 = driver.findElement(By.xpath("(//span[text()='NIFTY 50'])[1]"));
			action.moveToElement(element2).perform();
			Thread.sleep(1000);
			
			WebElement element3 = driver.findElement(By.xpath("(//span[@data-symbol='NIFTY 50'])[1]"));
			element3.click();
			Thread.sleep(1000);
			
			WebElement element4 = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));
			if (element4.isDisplayed()) {
				String blue = "\u001B[34m";
				System.out.println(blue+"verify the pop up is displayed");
				
			} 
			
			else {
				System.err.println("verify the pop up is not displayed");

			}

			Thread.sleep(1000);
			WebElement element21 = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX'])[2]"));
			action.moveToElement(element21).perform();
			Thread.sleep(1000);
			
			WebElement element31 = driver.findElement(By.xpath("(//span[@data-symbol='S&P BSE SENSEX'])[3]"));
			element31.click();
			Thread.sleep(1000);
			
			
			
			WebElement element41 = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));
			if (element41.isDisplayed()) {
				String blue = "\u001B[34m";
				System.out.println(blue+"verify the pop up is displayed");
				
			} 
			
			else {
				System.err.println("verify the pop up is not displayed");

			}
			
			WebElement click = driver.findElement(By.xpath("//div[@class='ind_dropdown']/div/div/span/span//following-sibling::div/span"));
			click.click();
			Thread.sleep(1000);
			
		}
		
		
		
		WebElement element311 = driver.findElement(By.xpath("//input[@id='project-id']"));
		element311.click();
		Thread.sleep(1000);
	
		element311.sendKeys("NIFTY");
        Thread.sleep(2000);
		
//        WebElement element51 = driver.findElement(By.xpath("(//span[text()='Stocks'])[2]"));
//		element51.click();
		Thread.sleep(5000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='search_filter_outer']//following-sibling::ul/li/div/span[@class='s_details']"));
		//Actions action = new Actions(driver);

		for (WebElement webElement : elements) {
		    String text = webElement.getText().trim();

		    WebElement element2 = driver.findElement(By.xpath("//span[contains(text(),'" + text + "')]//parent::div//child::span[@class='symbolsseries']"));
		    action.moveToElement(element2).perform();
		    Thread.sleep(500);

		    WebElement ipoadd = driver.findElement(By.xpath("(//span[contains(text(),'" + text + "')]//parent::div//following-sibling::div//child::span[@class='s_add_sym'])[1]"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ipoadd);
		    Thread.sleep(500);

		    // ✅ Stop when popup appears
		    if (!driver.findElements(By.xpath("//div[@class='jconfirm-content']")).isEmpty()) {
		        driver.findElement(By.xpath("//button[text()='ok']")).click();
		        Thread.sleep(500);
		        driver.findElement(By.xpath("//span[text()='Clear']")).click();
		        break;
		    }
		}
		
		
		
		
	}

	
	@When("User Select The InstaOptions and close the window")
	public void user_select_the_insta_options_and_close_the_window() throws InterruptedException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			
			 Set<String> windowHandles = driver.getWindowHandles();
		        ArrayList<String> tabs = new ArrayList<>(windowHandles);
		        
		        driver.switchTo().window(tabs.get(1));
		        Thread.sleep(2000);  // Perform actions if needed

			
			WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Understand')]"));
			element.click();
			
			Thread.sleep(4000);
			driver.close();
			
			 driver.switchTo().window(tabs.get(0));
			
		} catch (Exception e) {
			
			 Set<String> windowHandles = driver.getWindowHandles();
		        ArrayList<String> tabs = new ArrayList<>(windowHandles);
		        
		        driver.switchTo().window(tabs.get(1));
		        Thread.sleep(4000);  // Perform actions if needed
		        
		        driver.close();
		        
		        driver.switchTo().window(tabs.get(0));
		}
		
		
		Thread.sleep(1000);
		
	}
	
	@When("User Select The Stock Advisory and close the window")
	public void user_select_the_stock_advisory_and_close_the_window() throws InterruptedException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			
			 Set<String> windowHandles = driver.getWindowHandles();
		        ArrayList<String> tabs = new ArrayList<>(windowHandles);
		        
		        driver.switchTo().window(tabs.get(1));
		        Thread.sleep(2000);  // Perform actions if needed

			
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Proceed')]//parent::button"));
			element.click();
			
			Thread.sleep(4000);
			driver.close();
			
			 driver.switchTo().window(tabs.get(0));
			
		} catch (Exception e) {
			
			 Set<String> windowHandles = driver.getWindowHandles();
		        ArrayList<String> tabs = new ArrayList<>(windowHandles);
		        
		        driver.switchTo().window(tabs.get(1));
		        Thread.sleep(4000);  // Perform actions if needed
		        
		        driver.close();
		        
		        driver.switchTo().window(tabs.get(0));
		}
		
		
		Thread.sleep(1000);
		
	}

	
	@When("User Select The Portfolio Health Check and close the window")
	public void user_select_the_portfolio_health_check_and_close_the_window() throws InterruptedException {
	    
		
		
		
		
	}
	
	@When("User Select The Corporate FDs and close the window")
	public void user_select_the_corporate_f_ds_and_close_the_window() throws InterruptedException {
	    
		  
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				try {
					
					 Set<String> windowHandles = driver.getWindowHandles();
				        ArrayList<String> tabs = new ArrayList<>(windowHandles);
				        
				        driver.switchTo().window(tabs.get(1));
				        Thread.sleep(2000);  // Perform actions if needed

				    	WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
						element.click();
				       
				        try {
				            new WebDriverWait(driver, Duration.ofSeconds(20)).until(
				                ExpectedConditions.or(
				                    ExpectedConditions.visibilityOfElementLocated(
				                        By.xpath("//button[contains(@aria-label,'home')]")),
				                    ExpectedConditions.visibilityOfElementLocated(
				                        By.xpath("//button[contains(text(),'Clear')]")),
				                    ExpectedConditions.visibilityOfElementLocated(
				                        By.xpath("//button[contains(text(),'FAQ')]"))
				                 
				                ));
				            System.out.println("Page successful - loaded.");
				        } catch (Exception e) {
				            throw new AssertionError("Page Not Loading so Kindly check Manual.", e);
				        }
					
					Thread.sleep(4000);
					driver.close();
					
					 driver.switchTo().window(tabs.get(0));
					
				} catch (Exception e) {
					
					
				}
				
				
				Thread.sleep(1000);
				
				
	}

	@When("User Select The Bonds and close the window")
	public void user_select_the_bonds_and_close_the_window() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
		
		       
		        Thread.sleep(2000);  // Perform actions if needed

		    	WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Confirm')]"));
				element.click();
		       
				 Thread.sleep(4000);
				framesHandlingNaviaLogin();
		        try {
		            new WebDriverWait(driver, Duration.ofSeconds(40)).until(
		            		
		            		
		            	
		                ExpectedConditions.or(
		                    ExpectedConditions.visibilityOfElementLocated(
		                        By.xpath("//div[@class='header-menu-wrap']")),
		                    ExpectedConditions.visibilityOfElementLocated(
		                        By.xpath("//div[@class='sidebar-widget']")),
		                    ExpectedConditions.visibilityOfElementLocated(
		                        By.xpath("//a[@class='user-icon']"))
		                 
		                ));
		            System.out.println("Page successful - loaded.");
		        } catch (Exception e) {
		            throw new AssertionError("Page Not Loading so Kindly check Manual.", e);
		        }
			
			Thread.sleep(4000);
			
			
		} catch (Exception e) {
			
			
			
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
	}

	
	
	
	@When("User Open The Current {string} Stike")
	public void user_open_the_current_stike(String string) throws InterruptedException, AWTException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		 switch (string) {
			
			case "Nifty 50":
				
				WebElement element6 = driver.findElement(By.xpath("(//span[text()='NIFTY 50'])[1]"));
				
				if (element6.isDisplayed()) {
					
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

					
					int roundedValues =roundedValue-50;
					System.out.println(purple+"Nifty Current Strike Value: " + roundedValues);
					
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
					
					try {
						
						Actions a1 = new Actions(driver);
						WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
						Thread.sleep(1000);
						a1.moveToElement(stock1).perform();
						Thread.sleep(1000);
						a1.click(stock1).perform();
						
					} catch (Exception e) {
						
						try {
							
							driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
							
						} catch (Exception g) {
							
							driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
						}

						Thread.sleep(2000);
						Actions a1 = new Actions(driver);
						WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
						Thread.sleep(1000);
						a1.moveToElement(stock1).perform();
						Thread.sleep(1000);
						a1.click(stock1).perform();
						
					}
					
					
					
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
					

					
				try {
						
					Actions c=new Actions(driver);
					Thread.sleep(1000);
					WebElement element = driver.findElement(By.xpath("(//div[text()='"+roundedValues+"']//parent::div//descendant::span[contains(@class,'str_more call_more')])[1]"));
					Thread.sleep(1000);
					c.moveToElement(element).perform();
					Thread.sleep(1000);
					c.click(element).perform();
					Thread.sleep(2000);
					
					driver.switchTo().defaultContent();
					Thread.sleep(1000);
					WebElement element3 = driver.findElement(By.xpath("//label[text()='Dashboard']"));
					element3.click();
					
					Thread.sleep(1000);
					WebElement element5 = driver.findElement(By.xpath("//div[@class='funds_show']"));
					c.moveToElement(element5).perform();
					
					Thread.sleep(1000);
					WebElement element11 = driver.findElement(By.xpath("//span[text()='Clear']"));
					element11.click();
					
					Thread.sleep(1000);
					WebElement element7 = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValues+"')]//preceding-sibling::span"));
//					JavascriptExecutor js = (JavascriptExecutor) driver;
//				       js.executeScript("arguments[0].scrollIntoView();", element7);
				       
				       Thread.sleep(1000);
				      c.moveToElement(element7).perform();
				      Thread.sleep(1000);
				      c.click(element7).perform();
				       
				      Thread.sleep(3000);
				      
				      JavascriptExecutor js1 = (JavascriptExecutor) driver;
				        js1.executeScript("window.open()"); 

				        ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());

				        driver.switchTo().window(tabs1.get(1));

				        driver.get("https://www.nseindia.com");
				        Thread.sleep(2000);
				        
				        try {
				        	
				        	WebElement element8 = driver.findElement(By.xpath("//button[@class='btn-close']"));
				        	element8.click();
				        	
						} catch (Exception e2) {
							// TODO: handle exception
						}
				        
				        
				        
				        WebElement element10 = driver.findElement(By.xpath("(//a[text()='Option Chain'])[1]"));
				        element10.click();
				       
				      
				        Thread.sleep(1000);
				      String formatted = String.format("%,d", roundedValues);
				      JavascriptExecutor js = (JavascriptExecutor) driver;
				      System.out.println(formatted);
				      WebElement element8 = driver.findElement(By.xpath("//a[contains(text(),'"+formatted+"')]"));
				      js.executeScript("arguments[0].scrollIntoView();", element8);
				      Thread.sleep(1000);
				      
				      WebElement element9 = driver.findElement(By.xpath("//a[contains(text(),'"+formatted+"')]//parent::td//preceding-sibling::td//child::a[@class='bold']"));
				      element9.click();
				      Thread.sleep(1000);
				      
				      
						
					} catch (Exception e) {
						

							

					        Thread.sleep(1000);
					     
					      
					      try {
					    	  
					    	  String formatted = String.format("%,d", roundedValues);
					    	  Actions r=new Actions(driver);
					    	  WebElement element8 = driver.findElement(By.xpath("//a[contains(text(),'"+formatted+"')]"));
						      r.moveToElement(element8).perform();
						      Thread.sleep(1000);
						      
						      WebElement element9 = driver.findElement(By.xpath("//a[contains(text(),'"+formatted+"')]//parent::td//preceding-sibling::td//child::a[@class='bold']"));
						      element9.click();
						      Thread.sleep(1000);
							
						} catch (Exception e2) {
							
//							String formatted = String.format("%,d", roundedValues);
//					    	  
//							 for (int i = 1; i <=10; i++) {
//									
//									Robot robot=new Robot();
//									
//									robot.keyPress(KeyEvent.VK_DOWN);
//									robot.keyRelease(KeyEvent.VK_DOWN);
//									
//
//								}
//						      Thread.sleep(2000);
//						      
//						      WebElement element9 = driver.findElement(By.xpath("(//a[contains(text(),'"+formatted+"')]//parent::td//preceding-sibling::td//child::a[@class='bold'])[1]"));
//						      element9.click();
//						      Thread.sleep(1000);
						}
					      
					      
							
							
							
						}
					      
					     
					      
					
					
				}else {
					
					WebElement element = driver
							.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
					element.click();
					
					Thread.sleep(1000);
					
					//Actions a = new Actions(driver);
					
					WebElement k1l = driver
							.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
					k1l.click();
					
//					a.moveToElement(stock).perform();
//					Thread.sleep(1000);
//					a.click(stock).perform();
					
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
					int roundedValues=roundedValue-50;
					
					WebElement kl = driver
							.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
					kl.click();
					
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
					

					
				try {
						
					Thread.sleep(1000);
					Actions c=new Actions(driver);
					Thread.sleep(1000);
					WebElement element1 = driver.findElement(By.xpath("(//div[text()='"+roundedValues+"']//parent::div//descendant::span[contains(@class,'str_more call_more')])[1]"));
					Thread.sleep(1000);
					c.moveToElement(element1).perform();
					Thread.sleep(1000);
					c.click(element1).perform();
					Thread.sleep(2000);
					
					driver.switchTo().defaultContent();
					Thread.sleep(1000);
					WebElement element3 = driver.findElement(By.xpath("//label[text()='Dashboard']"));
					element3.click();
					
					Thread.sleep(1000);
					WebElement element5 = driver.findElement(By.xpath("//div[@class='funds_show']"));
					c.moveToElement(element5).perform();
					
					Thread.sleep(1000);
					WebElement element11 = driver.findElement(By.xpath("//span[text()='Clear']"));
					element11.click();
					
					Thread.sleep(1000);
					WebElement element7 = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValues+"')]//preceding-sibling::span"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
				       js.executeScript("arguments[0].scrollIntoView();", element7);
				       
				       Thread.sleep(1000);
				      c.moveToElement(element7).perform();
				      Thread.sleep(1000);
				      c.click(element7).perform();
				       
				      Thread.sleep(3000);
				      
				      JavascriptExecutor js1 = (JavascriptExecutor) driver;
				        js1.executeScript("window.open()"); 

				        ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());

				        driver.switchTo().window(tabs1.get(1));

				        driver.get("https://www.nseindia.com");
				        Thread.sleep(2000);
				        
				        try {
				        	
				        	WebElement element8 = driver.findElement(By.xpath("//button[@class='btn-close']"));
				        	element8.click();
				        	
						} catch (Exception e2) {
							// TODO: handle exception
						}
				        
				        
				        
				        WebElement element10 = driver.findElement(By.xpath("(//a[text()='Option Chain'])[1]"));
				        element10.click();
				       
				      
				        Thread.sleep(1000);
				      String formatted = String.format("%,d", roundedValues);
				      
				      WebElement element8 = driver.findElement(By.xpath("//a[contains(text(),'"+formatted+"')]"));
				      js.executeScript("arguments[0].scrollIntoView();", element8);
				      Thread.sleep(1000);
				      
				      WebElement element9 = driver.findElement(By.xpath("//a[contains(text(),'"+formatted+"')]//parent::td//preceding-sibling::td//child::a[@class='bold']"));
				      element9.click();
				      Thread.sleep(1000);
						
					} catch (Exception e) {
						
						Thread.sleep(1000);
						WebElement element3 = driver.findElement(By.xpath("//select[@id='symbols_list']"));
						Select d=new Select(element3);
						d.selectByVisibleText("NIFTY - NFO");
						
						Thread.sleep(1000);
						Actions c=new Actions(driver);
						Thread.sleep(1000);
						WebElement element1 = driver.findElement(By.xpath("(//div[text()='"+roundedValues+"']//parent::div//descendant::span[contains(@class,'str_more call_more')])[1]"));
						Thread.sleep(1000);
						c.moveToElement(element1).perform();
						Thread.sleep(1000);
						c.click(element1).perform();
                        Thread.sleep(2000);
						
						driver.switchTo().defaultContent();
						Thread.sleep(1000);
						WebElement element31 = driver.findElement(By.xpath("//label[text()='Dashboard']"));
						element31.click();
						
						Thread.sleep(1000);
						WebElement element5 = driver.findElement(By.xpath("//div[@class='funds_show']"));
						c.moveToElement(element5).perform();
						
						Thread.sleep(1000);
						WebElement element11 = driver.findElement(By.xpath("//span[text()='Clear']"));
						element11.click();
						
						Thread.sleep(1000);
						WebElement element7 = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValues+"')]//preceding-sibling::span"));
						JavascriptExecutor js = (JavascriptExecutor) driver;
					       js.executeScript("arguments[0].scrollIntoView();", element7);
					       
					       Thread.sleep(1000);
					      c.moveToElement(element7).perform();
					      Thread.sleep(1000);
					      c.click(element7).perform();
					       
					      Thread.sleep(3000);
					      
					      JavascriptExecutor js1 = (JavascriptExecutor) driver;
					        js1.executeScript("window.open()"); 

					        ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());

					        driver.switchTo().window(tabs1.get(1));

					        driver.get("https://www.nseindia.com");
					        Thread.sleep(2000);
					        
					        try {
					        	
					        	WebElement element8 = driver.findElement(By.xpath("//button[@class='btn-close']"));
					        	element8.click();
					        	
							} catch (Exception e2) {
								// TODO: handle exception
							}
					        
					        
					        
					        WebElement element10 = driver.findElement(By.xpath("(//a[text()='Option Chain'])[1]"));
					        element10.click();
					       
					      
					        Thread.sleep(1000);
					      String formatted = String.format("%,d", roundedValues);
					      
					      WebElement element8 = driver.findElement(By.xpath("//a[contains(text(),'"+formatted+"')]"));
					      js.executeScript("arguments[0].scrollIntoView();", element8);
					      Thread.sleep(1000);
					      
					      WebElement element9 = driver.findElement(By.xpath("//a[contains(text(),'"+formatted+"')]//parent::td//preceding-sibling::td//child::a[@class='bold']"));
					      element9.click();
					      Thread.sleep(1000);
					
					
					
					
					}
					
					
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
	      		
	      			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BFO']"));
	      			
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
				
//				a.moveToElement(stock).perform();
//				Thread.sleep(1000);
//				a.click(stock).perform();
				
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
	    		
	    			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BFO']"));
	    			
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

			
			
//			WebElement fund1 = driver.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::div//child::span)[1]"));
//			String text31 = fund1.getText();
	//
//			Thread.sleep(1000);
//			System.out.println(text31);
			
			Thread.sleep(2000);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
