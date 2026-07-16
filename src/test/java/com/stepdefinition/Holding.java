package com.stepdefinition;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Holding extends BaseClass {
	
	 public static String cb = "\u001B[0m";
	 public static String cr = "\u001B[31m";
	 
	@When("Verify Adding All Stock Investment Value is Equal to Investment Value")
	public void verify_adding_all_stock_investment_value_is_equal_to_investment_value() throws InterruptedException {
		List<WebElement> allInvestmentValue = driver.findElements(By.xpath(
				"//div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='investmentvalue']//child::div"));

		// Create a List to store the text values
		List<String> investmentValues = new ArrayList<>();

		// Iterate through each WebElement and extract text values
		for (WebElement invValue : allInvestmentValue) {
			String nm = invValue.getText();
			String text = nm.replaceAll("[^0-9.-]", "");
			investmentValues.add(text);
			System.out.println("Investment Stock Value is : " + text);
		}

		// Print all text values stored in the list
		System.out.println("All Investment Values: " + investmentValues);

		// Calculate the sum of investment values without using stream API
		double sum = 0.0;
		for (String value : investmentValues) {
			sum += Double.parseDouble(value);
		}
		
		String roundedStr = String.format("%.2f", sum);
		String y = "\u001B[33m";
		// Print the total investment value
		System.out.println(y+"Total Investment Value: " + roundedStr);
		
		//String str = String.valueOf(sum);

		// Find the total investment value element
		WebElement totalInvestmentValue = driver
				.findElement(By.xpath("//input[@data-dhx-id='inv_val']"));
		String text1 = totalInvestmentValue.getAttribute("value");
		

		// Remove currency symbol from text1
		String text = text1.replaceAll("[^0-9.-]", "");
		
		System.out.println(y+"Today Investment Value: "+text);
		String d = "\u001B[35m";
		// Verify if the values before the decimal point are equal
		if (text.equals(roundedStr)) {
			System.out.println(d+"Its Working Fine");
		} else {
			String r = "\u001B[31m";
			System.err.println(r+"Inv Value is Not Equals to Total Investment Amount");
		}

		Thread.sleep(2000);
	}

	@When("Verify Adding All Stock Curr Value is Equal to Current Value")
	public void verify_adding_all_stock_curr_value_is_equal_to_current_value() throws InterruptedException {
		//System.err.println(">>>>>>>>>>>>>>>> Current Values<<<<<<<<<<<<<<<<<");

		List<WebElement> allCurrentValue = driver.findElements(
				By.xpath("//div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='Currvalue']//child::div"));
		List<String> Currvalue = new ArrayList<>();

		for (WebElement cValue : allCurrentValue) {
			String nm = cValue.getText();
			String text = nm.replaceAll("[^0-9.-]", "");
			Currvalue.add(text);
			System.out.println("Current Stock Value is : " + text);
		}

		// Print all text values stored in the list
		System.out.println("All Current Values: " + Currvalue);

		double sum1 = 0;
		for (String value1 : Currvalue) {
			sum1 += Double.parseDouble(value1);
		}
		String roundedStr = String.format("%.2f", sum1);
		String y = "\u001B[33m";
		System.out.println(y+"Total Current Value: " + roundedStr);
		
		String str = String.valueOf(roundedStr);

		WebElement currentValue = driver.findElement(By.xpath("//input[@data-dhx-id='cur_val']"));
		String text2 = currentValue.getAttribute("value");
		String text = text2.replaceAll("[^0-9.-]", "");

	System.out.println(y+"Today Current Value is : "+text);
		Thread.sleep(2000);
		String p = "\u001B[35m";
		if (text.equals(str)) {
			System.out.println(p+"Its Working Fine");
		} else {
			String r = "\u001B[31m";
			System.err.println(r+"Curr Value is Not Equals to Total Current Values");
		}
		Thread.sleep(2000);
	}

	@When("Verify Adding All Stock P\\/L Value is Equal to P\\/L")
	public void verify_adding_all_stock_p_l_value_is_equal_to_p_l() throws InterruptedException {
		
		Thread.sleep(4000);
		

		
		
		
		
		List<WebElement> allElements = driver.findElements(
			    By.xpath("//div[@role='row']//descendant::div[@aria-colindex='11']//child::div")
			);

			// regex: capture optional sign and integer/decimal number
			Pattern pattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?)");

			// use BigDecimal to accumulate precisely
			BigDecimal total = BigDecimal.ZERO;

			// formatter to always print two decimals
			DecimalFormat df = new DecimalFormat("0.00");

			//int idx = 0;
			for (WebElement element : allElements) {
			    //idx++;
			    String rawText = element.getText().trim();
			    Matcher matcher = pattern.matcher(rawText);

			    if (matcher.find()) {
			        // raw matched number (e.g. "-9.94" or "9" or "123.456")
			        String numberStr = matcher.group(1).replaceAll(",", ""); // remove commas if any
			        // remove leading plus if present
			        if (numberStr.startsWith("+")) numberStr = numberStr.substring(1);

			        // parse to BigDecimal and round to 2 decimal places
			        BigDecimal value = new BigDecimal(numberStr).setScale(2, RoundingMode.HALF_UP);

			        // print the individual value
			        System.out.println("Stock Holding Value is: " + df.format(value));

			        // add to total
			         total = total.add(value);
			    } 
			}
			String y = "\u001B[33m";
			// final total print
			System.out.println(y+"Final Total Stock Holding Value is: " + df.format(total));
		
			String valueStr = total.toPlainString();
			Thread.sleep(2000);
			

			WebElement element2 = driver.findElement(By.xpath("//input[@data-dhx-id='pl_val']"));
			String text = element2.getAttribute("value");
			String replaceAll = text.replaceAll("[^0-9.-]", "");
			
			System.out.println(y+"Today Over All Profit Value :"+replaceAll);
			
			Thread.sleep(2000);
			
			String p = "\u001B[35m";
			if (replaceAll.equals(valueStr)) {
				
				System.out.println(p+"Its Working Fine");
				
			}
			
			else {
				String r = "\u001B[31m";
				System.err.println(r+"Today Profit / Loss Value MisMatch");
			}
		
	
		Thread.sleep(2000);
	}


	@When("Verify Adding All Stock Today P\\/L Value is Equal to Today P\\/L Value")
	public void verify_adding_all_stock_today_p_l_value_is_equal_to_today_p_l_value() throws InterruptedException {
		List<WebElement> allPandL = driver.findElements(
				By.xpath("//div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='TPL']//child::div"));
		List<String> pAndL = new ArrayList<>();

		for (WebElement PandL : allPandL) {
			String nm = PandL.getText();
			String text23 = nm.replaceAll("[^0-9.-]", "");
			pAndL.add(text23);
			System.out.println("Today P/L Value is : " + text23);
		}
		Thread.sleep(2000);

		System.out.println("All today p/l  Values: " + pAndL);

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
			String r = "\u001B[31m";
			System.err.println(r+"Today P/L Value is Not Equals to Today Total P/L Values");
		}
		Thread.sleep(2000);

	}

	@When("Verify Calculate Current Value Subtract Investment Value Its Equal to P\\/L Value")
	public void verify_calculate_current_value_subtract_investment_value_its_equal_to_p_l_value()
			throws InterruptedException {
		
		Thread.sleep(4000);
		
		List<WebElement> allPandL = driver.findElements(
				By.xpath("//div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='Currvalue']//child::div"));
		List<String> pAndL = new ArrayList<>();

		for (WebElement PandL : allPandL) {
			String nm = PandL.getText();
			String text23 = nm.replaceAll("[^0-9.-]", "");
			pAndL.add(text23);
			System.out.println("Today Current Value is : " + text23);
		}
		Thread.sleep(2000);

		System.out.println("All today Current Values: " + pAndL);

		double sum3 = 0;
		for (String value3 : pAndL) {
			sum3 += Double.parseDouble(value3);
		}
		
		String roundedStr = String.format("%.2f", sum3);
		//System.out.println("Rounded String: " + roundedStr);
		String y = "\u001B[33m";
		System.out.println(y+"Total Today Current Value: " + roundedStr);

		WebElement pAndVValueTotal = driver
				.findElement(By.xpath("//input[@data-dhx-id='cur_val']"));
	
		String attribute = pAndVValueTotal.getAttribute("value");
		Thread.sleep(2000);

	  String replaceAll = attribute.replaceAll("[^0-9.-]", "");

		System.out.println(y+"Total Value is : "+replaceAll);
		

		if (replaceAll.equals(roundedStr)) {
			String purple = "\u001B[35m";
			System.out.println(purple+"Its Working Fine");
		} 
		
		else {
			String r = "\u001B[31m";
			System.err.println(r+"Today P/L Value is Not Equals to Today Total Current Values");
		}
		Thread.sleep(2000);

	}
	
	@Given("User Buy The {string} Stock For {string} to Option")
	public void user_buy_the_stock_for_to_option(String string, String string2) throws InterruptedException {
	    
		Thread.sleep(1000);
		
		
		try {
			
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement element = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
			element.click();
			Thread.sleep(1000);
			element.sendKeys(string);
			Thread.sleep(1000);
			
			WebElement element2 = driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string2+"']"));
			Thread.sleep(1000);
			
				Actions f=new Actions(driver);
				f.moveToElement(element2).perform();
				Thread.sleep(1000);
				
				f.click(element2).perform();
				
				WebElement element3 = driver.findElement(By.xpath("//button[contains(@class,'buy buyorder')]"));
				element3.click();
				Thread.sleep(1000);
			
				
			
		} catch (Exception e) {
			
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
			
			WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string2+"']"));
			Thread.sleep(1000);
			element.click();
			
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//			       js.executeScript("arguments[0].scrollIntoView();", element2);
			       
			       driver.findElement(By.xpath("//button[contains(@class,'buy buyorder')]")).click();
					Thread.sleep(1000);
			
		}
		
		
		
		Thread.sleep(1000);
		
	}
	@Given("User Select the The {string} Order")
	public void user_select_the_the_order(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//label[text()='"+string+"']//parent::div")).click();

		Thread.sleep(1000);
		
	}
	@Given("User Click the {string} Options for Stock")
	public void user_click_the_options_for_stock(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[contains(text(),'"+string+"')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[contains(text(),'yes')]")).click();
		Thread.sleep(1000);
		
		
		
		try {
			
			WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='dhx_message__text'])[1]")));
			
			if (element2.isDisplayed()) {
				String purple = "\u001B[35m";
				System.out.println(purple+"verify the pop up is displayed");
				
			}else {
				
				System.err.println("verify the pop up is not displayed");
				
			}
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//span[@class='dhx_button__icon dxi dxi dxi-close']//parent::button")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			
			driver.findElement(By.xpath("//span[@class='dhx_button__icon dxi dxi dxi-close']//parent::button")).click();
			Thread.sleep(1000);
		}
		
		
		
		
		Thread.sleep(1000);
		
	}
	
	
	@When("User Covert The {string} Stock")
	public void user_covert_the_stock(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//ancestor::div[@class='dhx_grid-row ']//child::div[@role='button'])[2]"));
		Thread.sleep(1000);
		String text = element.getText();
		System.out.println(text);
		Thread.sleep(1000);
		
		WebElement element1 = driver.findElement(By.xpath("//span[text()='"+string+"']//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='NetQty']"));
		Thread.sleep(1000);
		String text1 = element1.getText();
		String purple = "\u001B[35m";
		System.out.println(purple+string+" Stock is NetQty : "+text1);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//following-sibling::span[contains(@class,'cntx')]")).click();
		Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Convert']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element2);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[contains(@name,'form_input')]")).sendKeys(text1);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//span[contains(text(),'Submit')]//parent::button)[1]")).click();
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		
	}
	
	@When("User Click The {string} Stock to {string} Options")
	public void user_click_the_stock_to_options(String string, String string2) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//following-sibling::span[contains(@class,'cntx')]")).click();
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Sq.off']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//label[text()='Market']//parent::div")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//button[contains(text(),'SELL')])[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[contains(text(),'yes')]")).click();
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		
	}
	
	@When("User Seleck The Chart {string} Stock")
	public void user_seleck_the_chart_stock(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//following-sibling::span[contains(@class,'cntx')]")).click();
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Chart')]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		
		Thread.sleep(1000);
		
	}

	@When("User Slect the {string} Stock in Chart")
	public void user_slect_the_stock_in_chart(String string) throws InterruptedException {


		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text()='Dashboard']//parent::a//parent::li[@role='presentation']")).click();
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("(//div[@class='m_bg_color']//descendant::span[@class='symbolsseries'])["+string+"]"));
		Actions g=new Actions(driver);
		g.moveToElement(element).perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//span[@class='s_b2 chart'])["+string+"]")).click();
		Thread.sleep(1000);
		
		switch (string) {
		case "2":
			
			Thread.sleep(7000);
			driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
			Thread.sleep(1000);
			
			break;

		default:
			break;
		}
		
		
		
		Thread.sleep(1000);
		
		
	}
	@When("User Add The Indicators in {string} Stocks")
	public void user_add_the_indicators_in_stocks(String string) throws InterruptedException {
	   
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
		
//		WebElement element3 = driver.findElement(By.xpath("(//div[text()='"+string+"'])[1]"));
//		Actions s=new Actions(driver);
//		s.moveToElement(element3).perform();
//		Thread.sleep(1000);
//		
//		driver.findElement(By.xpath("(//div[@data-name='legend-delete-action'])[2]")).click();
//        Thread.sleep(1000);

		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
		Thread.sleep(1000);
		
		
		Thread.sleep(1000);
		
		
	}

	@When("User Remove The Indicators in {string} Stocks")
	public void user_remove_the_indicators_in_stocks(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			
			WebElement element = driver.findElement(By.xpath("//div[@class='dhx_layout-cell-inner_html']//child::iframe"));
			driver.switchTo().frame(element);
			
			WebElement element1 = driver.findElement(By.xpath("//div[@class='chart_window']//child::iframe"));
			driver.switchTo().frame(element1);
			
			WebElement element3 = driver.findElement(By.xpath("(//div[contains(text(),'"+string+"')])[1]"));
			Actions s=new Actions(driver);
			s.moveToElement(element3).perform();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//div[@data-name='legend-delete-action'])[2]")).click();
	        Thread.sleep(1000);

			driver.switchTo().defaultContent();
			
			driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
			Thread.sleep(1000);
			
		} catch (Exception e) {
			
			
			WebElement element = driver.findElement(By.xpath("//div[@class='dhx_layout-cell-inner_html']//child::iframe"));
			driver.switchTo().frame(element);
			
			
			WebElement element3 = driver.findElement(By.xpath("(//div[contains(text(),'"+string+"')])[1]"));
			Actions s=new Actions(driver);
			s.moveToElement(element3).perform();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//div[@data-name='legend-delete-action'])[2]")).click();
	        Thread.sleep(1000);

			driver.switchTo().defaultContent();
			
			driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
			Thread.sleep(1000);
			
			
		}
		
		
		
		Thread.sleep(1000);
		
	}
	
	@When("User Slect The {string} Stock and {string} Order")
	public void user_slect_the_stock_and_order(String string, String string2) throws InterruptedException {
	   
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='Qty']"));
		String text = element.getText();
		String purple = "\u001B[35m";
		System.out.println(purple+string+" Stock is Qty : "+text);
		String d=text+1;
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//following-sibling::span[contains(@class,'cntx')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[contains(text(),'"+string2+"')]")).click();
		Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//input[@class='qty_val']"));
		element2.click();
		Thread.sleep(1000);
		element2.clear();
		Thread.sleep(1000);
		element2.sendKeys(d);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//label[text()='Market']//parent::div")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[contains(text(),'SELL')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[contains(text(),'yes')]")).click();
		Thread.sleep(1000);
		
		try {
			
			WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement t = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dhx_message__text']")));

			String text2 = t.getText();
			System.out.println(text2);

			
		} catch (Exception e) {
			
			System.err.println("Trade Pop-Up Not Visiable");
		}
		
		
		Thread.sleep(1000);
		
	}

	
	
	@Given("User Select The {string} in {string} For {string} Option")
	public void user_select_the_in_for_option(String string, String string2, String string3) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		switch (string2) {
		
		case "Stocks":
			
			driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys(string);
			
			Thread.sleep(1000);
			
			//driver.findElement(By.xpath("(//span[contains(text(),'"+string2+"')])[2]")).click();
			Thread.sleep(5000);
			
			Actions a=new Actions(driver);
			WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement stocks = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='"+string+"']//following-sibling::span[text()='"+string3+"'])[1]")));
		//WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string3+"']"));
			a.moveToElement(stocks).perform();
			Thread.sleep(1000);
			a.click(stocks).perform();
			
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string3+"']")).click();
		
			Thread.sleep(1000);
			
			break;
			
      case "Futures":
			
			driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys(string);
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[contains(text(),'Futures')]")).click();
			Thread.sleep(3000);
			
			//Actions s1=new Actions(driver);
			WebElement element1 = driver.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//parent::div[@class='s-box']//child::span[text()='"+string3+"'])[1]"));
			Thread.sleep(3000);
			//WebDriverWait wait11 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			//WebElement element1 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'"+string+"')]//following-sibling::span[text()='"+string3+"'])[1]")));
		//WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string3+"']"));
//			s1.moveToElement(element1).perform();
//			Thread.sleep(1000);
//			s1.click(element1).perform();
			element1.click();
			Thread.sleep(1000);
			
			break;
			
      case "Options":
			
    	  driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys(string);
			
			Thread.sleep(1000);
			
			//driver.findElement(By.xpath("(//span[contains(text(),'"+string2+"')])[2]")).click();
			Thread.sleep(3000);
			
			Actions s11=new Actions(driver);
			WebDriverWait wait111 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element11 = wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='"+string+"']//following-sibling::span[text()='"+string3+"'])[1]")));
		//WebElement element = driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string3+"']"));
			Thread.sleep(1000);
			s11.moveToElement(element11).perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='"+string+"']//following-sibling::span[text()='"+string3+"']")).click();
		
			Thread.sleep(1000);
			
			
			Thread.sleep(1000);
			
			WebElement fund = driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//ancestor::div[contains(@class,'dhx_widget')]//descendant::a[contains(text(),'"+string3+"')]//child::span"));
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
			
			
			
//			Thread.sleep(1000);
		//	
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ready_mode_close']")));
//			element1.click();
			
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
				
			}catch (Exception e){
				
				
			}
				
			
			
			try {
				
				Actions a1 = new Actions(driver);
				
				WebElement stocks1 = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue+"')]//preceding-sibling::span[text()='NFO']"));
				Thread.sleep(2000);
				a1.moveToElement(stocks1).perform();
				Thread.sleep(1000);
				stocks1.click();
				
				
			} catch (Exception e) {
				Actions a1 = new Actions(driver);
				WebElement stocks1 = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue+"')]//preceding-sibling::span[text()='BFO']"));
				Thread.sleep(2000);
				a1.moveToElement(stocks1).perform();
				Thread.sleep(1000);
				stocks1.click();
				
				
			}
			
			
			
			
			
			
			break;

		default:
			
			System.err.println("Invalid Your Condition");
			
			break;
		}
		
		
		
		
	}
	@Given("User Select The {string} To {string} Order")
	public void user_select_the_to_order(String string, String string2) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		switch (string2) {
		case "Stocks":
			
			driver.findElement(By.xpath("//button[contains(@class,'"+string+"')]")).click();
			Thread.sleep(1000);
			
		
			
			driver.findElement(By.xpath("//button[contains(text(),'BUY')]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[contains(text(),'yes')]")).click();
			Thread.sleep(1000);
			
			WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dhx_message__text']")));

			 if (element2.isDisplayed()) {
				 String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed");
					
				} 
				
				else {
					System.err.println("verify the pop up is not displayed");

				}

			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath("//span[text()='Clear']")).click();
			 Thread.sleep(1000);
			 
			
			Thread.sleep(1000);
			
			break;
			
          case "Futures":
			
			driver.findElement(By.xpath("//button[contains(@class,'"+string+"')]")).click();
			Thread.sleep(1000);
			
//			driver.findElement(By.xpath("//label[text()='"+string2+"']//parent::div")).click();
//			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[contains(text(),'BUY')]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[contains(text(),'yes')]")).click();
			Thread.sleep(1000);
			
			WebDriverWait wait11 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element21 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dhx_message__text']")));

			 if (element21.isDisplayed()) {
				 String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed");
					
				} 
				
				else {
					System.err.println("verify the pop up is not displayed");

				}

			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath("//span[text()='Clear']")).click();
			 Thread.sleep(1000);
			 
			
			Thread.sleep(1000);
			
			break;
			
          case "Options":
  			
			driver.findElement(By.xpath("//button[contains(@class,'"+string+"')]")).click();
			Thread.sleep(1000);
			
//			driver.findElement(By.xpath("//label[text()='"+string2+"']//parent::div")).click();
//			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[contains(text(),'BUY')]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[contains(text(),'yes')]")).click();
			Thread.sleep(1000);
			
			WebDriverWait wait111 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			WebElement element211 = wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dhx_message__text']")));

			 if (element211.isDisplayed()) {
				 String purple = "\u001B[35m";
					System.out.println(purple+"verify the pop up is displayed");
					
				} 
				
				else {
					System.err.println("verify the pop up is not displayed");

				}
			 
			 driver.findElement(By.xpath("//lable[contains(text(),'Delete')]//parent::button")).click();
			 Thread.sleep(1000);
			 
			 
			 
			
			Thread.sleep(1000);
			
			break;

		default:
			break;
		}
		
		
		
	}
	

	@Given("User Select The Current {string} Options")
	public void user_select_the_current_options(String string) throws InterruptedException {
	    
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
	Actions a = new Actions(driver);
	Thread.sleep(4000);
	WebElement element6 = driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span)[1]"));
	a.moveToElement(element6).perform();
	Thread.sleep(2000);
	a.click(element6).perform();
	Thread.sleep(2000);
	
	driver.switchTo().defaultContent();
	
	driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//span[text()='Clear']")).click();
	Thread.sleep(1000);
	
	//Actions a = new Actions(driver);
	
		WebElement stocks = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue+"')]//preceding-sibling::span[text()='NSE']"));
		
		a.moveToElement(stocks).perform();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("arguments[0].click();", stocks);

	
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@class='buy buyorder']"))
//				.click();
			
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
      			JavascriptExecutor js1 = (JavascriptExecutor) driver;
      	       js1.executeScript("arguments[0].click();", stoc);

      		
      			Thread.sleep(2000);
//      			driver.findElement(By.xpath("//button[@class='buy buyorder']"))
//      					.click();
    		  
			
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
    		
    			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BFO']"));
    			
    			a3.moveToElement(stoc).perform();
    			Thread.sleep(1000);
    			JavascriptExecutor js1 = (JavascriptExecutor) driver;
    		       js1.executeScript("arguments[0].click();", stoc);

    		
    			Thread.sleep(2000);
//    			driver.findElement(By.xpath("//button[@class='buy buyorder']"))
//    					.click();
		}
			break;

		default:
			System.err.println("Invalid Your Condition");
			
			break;
		}

		
		
//		WebElement fund1 = driver.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::div//child::span)[1]"));
//		String text31 = fund1.getText();
//
//		Thread.sleep(1000);
//		System.out.println(text31);
		
		Thread.sleep(2000);
	}
	
	@When("User Select The Current {string} Feature")
	public void user_select_the_current_feature(String string) throws InterruptedException {
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='project-id']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Futures']")).click();
		Thread.sleep(2000);
		
		switch (string) {

		case "Sensex":

			Thread.sleep(4000);
			Actions a = new Actions(driver);
			WebElement stock = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='BSE'])[1]"));
			Thread.sleep(3000);
			a.moveToElement(stock).perform();

			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("arguments[0].click();", stock);

			break;

		case "Nifty 50":

			try {
				
				Thread.sleep(2000);
				Actions a1 = new Actions(driver);
				WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
				Thread.sleep(2000);
				a1.moveToElement(stock1).perform();

				Thread.sleep(2000);
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
			       js1.executeScript("arguments[0].click();", stock1);
				
			} catch (Exception e) {
				
				driver.findElement(By.xpath("//span[text()='Futures']")).click();
				Thread.sleep(2000);
				Actions a1 = new Actions(driver);
				WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NFO'])[1]"));
				Thread.sleep(2000);
				a1.moveToElement(stock1).perform();

				Thread.sleep(2000);
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
			       js1.executeScript("arguments[0].click();", stock1);
			}
			

			break;

		default:

			System.err.println("Invalid Condition");
			break;
		}

		Thread.sleep(2000);
		
		
		
		Thread.sleep(1000);
		
		
	}
	
	@When("Verify The All Stock Average Price Value Check")
	public void verify_the_all_stock_average_price_value_check() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='dhx_grid-row ']//descendant::span[@class='order_fil']"));
		
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			
			String a = "\u001B[33m";
			WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='investmentvalue']//child::div[@class='dhx_grid-cell__content'])[1]"));
			String nm = element.getText();
			String text2 = nm.replaceAll("[^0-9.-]", "");
			double value = Double.parseDouble(text2); 
			String inv = String.format("%.2f", value);
			System.out.println(a+"Stock Name : Investment value of "+text+" : "+inv);
			Thread.sleep(1000);
			double d1 = Double.parseDouble(inv);
			
			
			WebElement element1 = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='Qty'])[1]"));
			String nmr = element1.getText();
			
			String text3 = nmr.replaceAll("[^0-9.-]", "");
			double value1 = Double.parseDouble(text3);
			String qut = String.format("%.2f", value1);
			System.out.println(a+"Stock Name : Quantity of "+text+" : "+qut);
			Thread.sleep(1000);
			double d2 = Double.parseDouble(qut);
			
			WebElement element11 = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='Avgprice']//child::div[@class='dhx_grid-cell__content'])[1]"));
			String nmf = element11.getText();
			String text4 = nmf.replaceAll("[^0-9.-]", "");
			double value3 = Double.parseDouble(text4); 
			String aver = String.format("%.2f", value3);
			Thread.sleep(1000);
			
			double num=d1/d2;
			String s = String.valueOf(num);
			double value5 = Double.parseDouble(s);
			String total = String.format("%.2f", value5);
			
			if (aver.equals(total)) {
				
				String purple = "\u001B[35m";
				System.out.println(purple+"The calculated Average value matches the value shown in the frontend : "+total);
				
			}
			
			else {
				
				 String blue = "\u001B[34m";
				System.out.println(blue+"Navia Average Value is : "+aver);
				 String red = "\u001B[31m"; 
				System.err.println(red+"The Calculated Average value doesn't matches the value shown in the frontend : "+total);
				
			}
			
		}
		
	}
	
	@When("Verify The All Stock Current Value Check")
	public void verify_the_all_stock_current_value_check() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='dhx_grid-row ']//descendant::span[@class='order_fil']"));
		
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			
			String a = "\u001B[33m";
			WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='LTP']//child::div[@class='dhx_grid-cell__content'])[1]"));
			String nmr = element.getText();
			String text2 = nmr.replaceAll("[^0-9.-]", "");
			double value = Double.parseDouble(text2); 
			String ltp = String.format("%.2f", value);
			System.out.println(a+"Stock Name : LTP value of "+text+" : "+ltp);
			Thread.sleep(1000);
			double d1 = Double.parseDouble(ltp);
			
			
			WebElement element1 = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='Qty'])[1]"));
			String text3 = element1.getText();
			double value1 = Double.parseDouble(text3); 
			String qut = String.format("%.2f", value1);
			System.out.println(a+"Stock Name : Quantity of "+text+" : "+qut);
			Thread.sleep(1000);
			double d2 = Double.parseDouble(qut);
			
			WebElement element11 = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='Currvalue']//child::div[@class='dhx_grid-cell__content'])[1]"));
			String nm = element11.getText();
			String text4 = nm.replaceAll("[^0-9.-]", "");
			
			double value3 = Double.parseDouble(text4); 
			String aver = String.format("%.2f", value3);
			Thread.sleep(1000);
			
			double num=d1*d2;
			String s = String.valueOf(num);
			double value5 = Double.parseDouble(s);
			String total = String.format("%.2f", value5);
			
			if (aver.equals(total)) {
				
				String purple = "\u001B[35m";
				System.out.println(purple+"The Calculated Current value matches the value shown in the frontend : "+total);
				
			}
			
			else {
				
				 String blue = "\u001B[34m";
				System.out.println(blue+"Navia Average Value is : "+aver);
				 String red = "\u001B[31m"; 
				System.err.println(red+"The Calculated Current value doesn't matches the value shown in the frontend : "+total);
				
			}
			
		}
	}
	
	@When("Verify The All Stock P\\/L Value Check")
	public void verify_the_all_stock_p_l_value_check() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='dhx_grid-row ']//descendant::span[@class='order_fil']"));
		
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			
			String a = "\u001B[33m";
			WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='Currvalue']//child::div[@class='dhx_grid-cell__content'])[1]"));
			String c = element.getText();
			String text2 = c.replaceAll("[^0-9.-]", "");
			double value = Double.parseDouble(text2); 
			String cur = String.format("%.2f", value);
			System.out.println(a+"Stock Name : Current value of "+text+" : "+cur);
			Thread.sleep(1000);
			double d1 = Double.parseDouble(cur);
			
			
			WebElement element1 = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='investmentvalue']//child::div[@class='dhx_grid-cell__content'])[1]"));
			String cw = element1.getText();
			String text3 = cw.replaceAll("[^0-9.-]", "");
			double value1 = Double.parseDouble(text3); 
			String qut = String.format("%.2f", value1);
			System.out.println(a+"Stock Name : Investment value of "+text+" : "+qut);
			Thread.sleep(1000);
			double d2 = Double.parseDouble(qut);
			
			WebElement element11 = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='PL']//child::div[@class='dhx_grid-cell__content'])[1]"));
			String c2 = element11.getText();
			String text4 = c2.replaceAll("[^0-9.-]", "");
			double value3 = Double.parseDouble(text4); 
			String aver = String.format("%.2f", value3);
			Thread.sleep(1000);
			
			double num=d1-d2;
			String s = String.valueOf(num);
			double value5 = Double.parseDouble(s);
			String total = String.format("%.2f", value5);
			
			if (aver.equals(total)) {
				
				String purple = "\u001B[35m";
				System.out.println(purple+"The Calculated P/L value matches the value shown in the frontend : "+total);
				
			}
			
			else {
				
				 String blue = "\u001B[34m";
				System.out.println(blue+"Navia Average Value is : "+aver);
				 String red = "\u001B[31m"; 
				System.err.println(red+"The Calculated P/L value doesn't matches the value shown in the frontend : "+total);
				
			}
			
		}
		
	}
	
	
	@When("Verify The All Stock Todays P\\/L Value Check")
	public void verify_the_all_stock_todays_p_l_value_check() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='dhx_grid-row ']//descendant::span[@class='order_fil']"));
		
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			
			String a = "\u001B[33m";
			WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='LTP']//child::div[@class='dhx_grid-cell__content'])[1]"));
			String c = element.getText();
			String text2 = c.replaceAll("[^0-9.-]", "");
			double value = Double.parseDouble(text2); 
			String ltp = String.format("%.2f", value);
			System.out.println(a+"Stock Name : Current LTP value of "+text+" : "+ltp);
			Thread.sleep(1000);
			double d1 = Double.parseDouble(ltp);
			
			WebElement info = driver.findElement(By.xpath("//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[contains(@class,'dhx_grid-cell')]//child::span[@class='cntx_menu hold_context']"));
			info.click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Depth']")).click();
			Thread.sleep(1000);
			
			
			WebElement element1 = driver.findElement(By.xpath("//div[@class='close_price']"));
			String cg = element1.getText();
			
			Thread.sleep(1000);
			if (cg.equalsIgnoreCase("Nan")) {
				
				WebElement el = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
				el.click();
				
				WebElement infod = driver.findElement(By.xpath("//span[text()='"+text+"']//ancestor::div[@class='dhx_grid-row ']//descendant::div[contains(@class,'dhx_grid-cell')]//child::span[@class='cntx_menu hold_context']"));
				infod.click();
				
				
				driver.findElement(By.xpath("//span[text()='Depth']")).click();
				Thread.sleep(1000);
				
				
				
			}
			Thread.sleep(1000);
		//	else {
				
				String text3 = cg.replaceAll("[^0-9.-]", "");
				
				double value1 = Double.parseDouble(text3); 
				String ydc = String.format("%.2f", value1);
				System.out.println(a+"Stock Name : Yesterday close value of "+text+" : "+ydc);
				Thread.sleep(1000);
				double d2 = Double.parseDouble(ydc);
				
				WebElement element2 = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
				element2.click();
				
		//	}
			
			
			
			
			
			Thread.sleep(1000);
			WebElement element2e = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[contains(@class,'dhx_grid-cell')])[3]"));
			String cx = element2e.getText();
			String text31 = cx.replaceAll("[^0-9.-]", "");
			double value11 = Double.parseDouble(text31); 
			String qut = String.format("%.2f", value11);
			System.out.println(a+"Stock Name : QTY value of "+text+" : "+qut);
			Thread.sleep(1000);
			double q = Double.parseDouble(qut);
			
			
			WebElement element111 = driver.findElement(By.xpath("(//span[contains(text(),'"+text+"')]//ancestor::div[@class='dhx_grid-row ']//descendant::div[@data-dhx-col-id='TPL']//child::div[@class='dhx_grid-cell__content'])[1]"));
			String cd = element111.getText();
			String text4 = cd.replaceAll("[^0-9.-]", "");
			double value3 = Double.parseDouble(text4); 
			String aver = String.format("%.2f", value3);
			Thread.sleep(1000);
			
			double y=d1-d2;
			double num=y*q;
			
			String s = String.valueOf(num);
			double value5 = Double.parseDouble(s);
			String total = String.format("%.2f", value5);
			
			
			if (aver.equals(total)) {
				
				String purple = "\u001B[35m";
				System.out.println(purple+"The Calculated Todays P/L value matches the value shown in the frontend : "+total);
				
			}
			
			else {
				
				 String blue = "\u001B[34m";
				System.out.println(blue+"Navia Todays P/L Value is : "+aver);
				 String red = "\u001B[31m"; 
				System.err.println(red+"The Calculated Todays P/L value doesn't matches the value shown in the frontend : "+total);
				
			}
			
		}
		
		
	}
	
	
	@When("Verify The All Stock Info Percentage Value Check")
	public void verify_the_all_stock_info_percentage_value_check() throws InterruptedException {
	 
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='dhx_grid-row ']//descendant::span[@class='order_fil']"));
		
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			
			WebElement info = driver.findElement(By.xpath("//span[text()='"+text+"']//ancestor::div[@class='dhx_grid-row ']//descendant::div[contains(@class,'dhx_grid-cell')]//child::span[@class='cntx_menu hold_context']"));
			info.click();
			
			driver.findElement(By.xpath("//span[text()='Depth']")).click();
			Thread.sleep(1000);
			
			String a = "\u001B[33m";
			WebElement element = driver.findElement(By.xpath("(//span[text()='"+text+" ']//ancestor::div//descendant::span[@class='sys_vl'])[1]"));
			String c = element.getText();
			String text2 = c.replaceAll("[^0-9.-]", "");
			double value = Double.parseDouble(text2); 
			String ltp = String.format("%.2f", value);
			System.out.println(a+"Stock Name : Current LTP value of "+text+" : "+ltp);
			Thread.sleep(1000);
			double d1 = Double.parseDouble(ltp);
			
			
			WebElement element1 = driver.findElement(By.xpath("//div[@class='close_price']"));
			String cg = element1.getText();
			if (cg.equalsIgnoreCase("Nan")) {
				
				WebElement el = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
				el.click();
				
				WebElement infod = driver.findElement(By.xpath("//span[text()='"+text+"']//ancestor::div[@class='dhx_grid-row ']//descendant::div[contains(@class,'dhx_grid-cell')]//child::span[@class='cntx_menu hold_context']"));
				infod.click();
				
				
			
				
			}
			
			
			String text3 = cg.replaceAll("[^0-9.-]", "");
			double value1 = Double.parseDouble(text3); 
			String ydc = String.format("%.2f", value1);
			System.out.println(a+"Stock Name : Yesterday close value of "+text+" : "+ydc);
			Thread.sleep(1000);
			double d2 = Double.parseDouble(ydc);
			
//			Thread.sleep(1000);
//			WebElement element2e = driver.findElement(By.xpath("//span[text()='"+text+" ']//ancestor::ul//descendant::span[@class='dh_source symtdet']"));
//			String text31 = element2e.getText();
//			String l = "\u001B[35m";
//			System.out.println(l+"Stock Name : "+text+" To Segments : "+text31);
			Thread.sleep(1000);
			
			WebElement element111 = driver.findElement(By.xpath("(//span[text()='"+text+" ']//ancestor::div//descendant::span[@class='sys_ptg'])[1]"));
			String zz = element111.getText();
			 String text4 = zz.replaceAll("[^0-9.-]", "");
			double value3 = Double.parseDouble(text4); 
			String per = String.format("%.2f", value3);
			
			WebElement element1111 = driver.findElement(By.xpath("(//span[text()='"+text+" ']//ancestor::div//descendant::span[@class='sys_ptg'])[2]"));
			String zz1 = element1111.getText();
			 String text41 = zz1.replaceAll("[^0-9.-]", "");
			double value31 = Double.parseDouble(text41); 
			String per1 = String.format("%.2f", value31);
			Thread.sleep(1000);
			
			double y=d1-d2;
			double r=y/d2;
			double num=r*100;
			
			String s = String.valueOf(num);
			double value5 = Double.parseDouble(s);
			String total = String.format("%.2f", value5);
			
			
			if (per.equals(total)  || per1.equals(total) ) {
				
				String purple = "\u001B[35m";
				System.out.println(purple+"The Calculated Info Percentage value matches the value shown in the frontend : "+total);
				
				WebElement elem = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
				elem.click();
			}
			
			else {
				
				 String blue = "\u001B[34m";
				System.out.println(blue+"Navia Todays P/L Value is : "+per1);
				 String red = "\u001B[31m"; 
				System.err.println(red+"The Calculated Info Percentage doesn't matches the value shown in the frontend : "+total);
				
				WebElement el = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
				el.click();
			}
			
		}
		
		
		
	}

	@When("Verify The All Stock Add The Basket")
	public void verify_the_all_stock_add_the_basket() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='dhx_grid-row ']//descendant::span[@class='order_fil']"));
		
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			
			WebElement info = driver.findElement(By.xpath("//span[text()='"+text+"']//ancestor::div[@class='dhx_grid-row ']//descendant::div[contains(@class,'dhx_grid-cell')]//child::span[@class='cntx_menu hold_context']"));
			info.click();
			
			driver.findElement(By.xpath("//span[text()='Add']")).click();
			Thread.sleep(1000);
			
			
			WebElement element2 = driver.findElement(By.xpath("//button[@class='btn-bskt add_basket']"));
			element2.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='basket_box']//child::span)[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='yes']")).click();
			Thread.sleep(1000);
			
			WebElement element = driver.findElement(By.xpath("//button[text()='Close']"));
			element.click();
			Thread.sleep(1000);
			
			WebElement el = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
			el.click();
			Thread.sleep(1000);
			
		
			
		}
		
	}

	
	@When("Verify The All Stock {string} Value Check in Holding Page")
	public void verify_the_all_stock_value_check_in_holding_page(String string) throws InterruptedException {
	    
		
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='dhx_grid-row ']//descendant::span[@class='order_fil']"));
		
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			
			Thread.sleep(1000);
			WebElement info = driver.findElement(By.xpath("//span[text()='"+text+"']//ancestor::div[@class='dhx_grid-row ']//descendant::div[contains(@class,'dhx_grid-cell')]//child::span[@class='cntx_menu hold_context']"));
			info.click();
			Thread.sleep(1000);
			
			switch (string) {

			case "BUY":
				
				driver.findElement(By.xpath("//span[text()='Add']")).click();
				Thread.sleep(1000);

				WebElement margin = driver.findElement(By.xpath("//span[text()='Margin ']//following-sibling::a"));
				String text1 = margin.getText();
			

				System.out.println(cb+"Margin Value is: " + text1);
				String numericValue = text1.replaceAll("[^0-9]", "");

				int price1 = Integer.parseInt(numericValue);
			
				// Check if within tolerance
				if (price1 == 0) {

					System.err.println(cr+"Stock which displays a Margin value as 0, which is a failed validation case.");

				} else {
					String blue = "\u001B[34m";
					System.out.println(blue + "Margin value is correctly displayed on the screen");

				}

				WebElement charges = driver.findElement(By.xpath("//div[text()='Charges ']//child::a"));
				String text2 = charges.getText();

				Thread.sleep(1000);
				System.out.println(cb+"Charges Value is: " + text2);

				String s = text2.replaceAll("[^0-9.-]", "");  // Now s = "148.78"

				// Step 2: Convert to double
				double priceDoubl = Double.parseDouble(s);

				if (priceDoubl == 0) {

					System.err.println(cr+"Stock which displays a Charges value as 0, which is a failed validation case.");

				} else {
					String blue = "\u001B[34m";
					System.out.println(blue + "Charges value is correctly displayed on the screen");

				}
				
				WebElement fund = driver.findElement(By.xpath("//div[text()='Available Margin ']//child::span"));
				String text3 = fund.getText();

				Thread.sleep(1000);
				System.out.println(cb+"Available Margin Value is: " + text3);
				
				String s7 = text3.replaceAll("[^0-9.-]", "");
				
				double priceDoubl1 = Double.parseDouble(s7);

				
				if (priceDoubl1 == 0) {

					System.err.println(cr+"Stock which displays a Available Margin value as 0, which is a failed validation case.");

				} else {
					String blue = "\u001B[34m";
					System.out.println(blue + "Available Margin value is correctly displayed on the screen");

				}
				Thread.sleep(2000);
				
				WebElement el = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
				el.click();
				Thread.sleep(1000);

				break;

			case "SELL":

				driver.findElement(By.xpath("//span[text()='Sell']")).click();
				Thread.sleep(1000);
				
				WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Intraday')]"));
				element.click();

				Thread.sleep(1000);
				WebElement margin1 = driver.findElement(By.xpath("//span[contains(text(),'Margin')]//following-sibling::a"));
				String text11 = margin1.getText();
				Thread.sleep(1000);

				System.out.println(cb+"Margin Value is: " + text11);
				String numericValue1 = text11.replaceAll("[^0-9]", "");
				int price11 = Integer.parseInt(numericValue1);
				
				// Check if within tolerance
				if (price11 == 0) {

					System.err.println(cr+"Stock which displays a Margin value as 0, which is a failed validation case.");

				} else {
					String blue1 = "\u001B[34m";
					System.out.println(blue1 + "Margin value is correctly displayed on the screen");

				}

				WebElement charges1 = driver.findElement(By.xpath("//div[text()='Charges ']//child::a"));
				String text21 = charges1.getText();

				
				System.out.println(cb+"Charges Value is: " + text21);

				String s1 = text21.replaceAll("[^0-9.-]", "");  // Now s = "148.78"

				// Step 2: Convert to double
				double priceDouble = Double.parseDouble(s1);

			

				Thread.sleep(1000);
				if (priceDouble == 0) {

					System.err.println(cr+"Stock which displays a Charges value as 0, which is a failed validation case.");

				} else {
					String blue1 = "\u001B[34m";
					System.out.println(blue1 + "Charges value is correctly displayed on the screen");

				}
				Thread.sleep(1000);

				WebElement fund1 = driver.findElement(By.xpath("//div[text()='Available Margin ']//child::span"));
				String text31 = fund1.getText();

				Thread.sleep(1000);
				System.out.println(cb+"Available Margin Value is: " + text31);
				
				String a1 = text31.replaceAll("[^0-9.-]", "");  // Now s = "148.78"

				// Step 2: Convert to double
				double priceDouble1 = Double.parseDouble(a1);

				
				if (priceDouble1 == 0) {

					System.err.println(cr+"Stock which displays a Available Margin value as 0, which is a failed validation case.");

				} else {
					String blue1 = "\u001B[34m";
					System.out.println(blue1 + "Available Margin value is correctly displayed on the screen");

				}
				Thread.sleep(1000);
				WebElement el1 = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
				el1.click();
				Thread.sleep(1000);

				break;

			default:

				System.err.println("Invalid Condition");

				break;
			}

			
		
			
		}
		
	}
	
	@When("Verify The All Stock Filter Options and Top Options")
	public void verify_the_all_stock_filter_options_and_top_options() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement el1 = driver.findElement(By.xpath("//div[@class='dhx_combobox-input__icon']"));
		el1.click();
		Thread.sleep(1000);
		
		WebElement el = driver.findElement(By.xpath("(//li[@role='option'])[1]"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("arguments[0].click();", el);
		Thread.sleep(1000);
		
		WebElement el2 = driver.findElement(By.xpath("//button[@data-dhx-id='clear_filter']"));
		el2.click();
		Thread.sleep(1000);
		
		WebElement el3 = driver.findElement(By.xpath("//button[@data-dhx-id='pledge']"));
		el3.click();
		Thread.sleep(1000);
		
		try {
			
			WebElement el4 = driver.findElement(By.xpath("//button[@data-dhx-id='close']"));
			el4.click();
			Thread.sleep(1000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		WebElement el5 = driver.findElement(By.xpath("//button[@data-dhx-id='holdings_refresh']"));
		el5.click();
		Thread.sleep(1000);
		
		WebElement el6 = driver.findElement(By.xpath("//button[@data-dhx-id='form_button_3']"));
		el6.click();
		Thread.sleep(1000);
		
		WebElement el7 = driver.findElement(By.xpath("//button[@data-dhx-id='form_button_4']"));
		el7.click();
		Thread.sleep(1000);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
