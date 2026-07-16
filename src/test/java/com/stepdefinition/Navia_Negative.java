package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class Navia_Negative extends BaseClass {
	

	

	@When("User Enter The Quantity Value {string} text Box {int}")
	public void user_enter_the_quantity_value_text_box(String string, Integer int1) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		//Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//span[@class='min_qty']"));
		String text = element2.getText();
		int a = Integer.parseInt(text);
		
		switch (int1) {
		
		    case 1:
		    	
		    	WebElement element = driver.findElement(By.xpath("(//span[@class='ops'])[1]//following-sibling::p//child::input[@class='quantity']"));
				element.click();
				Thread.sleep(1000);
				int value1=a-2;
			    String	stringValue = String.valueOf(value1);
				element.sendKeys(stringValue);
				
				Thread.sleep(2000);
		    	WebElement element02 = driver.findElement(By.xpath("(//span[@class='ops'])[2]//following-sibling::p//child::input[@class='quantity']"));
				element02.click();
				Thread.sleep(1000);
				element.sendKeys(string);
				
				Thread.sleep(2000);
		    	WebElement element03 = driver.findElement(By.xpath("(//span[@class='ops'])[3]//following-sibling::p//child::input[@class='quantity']"));
				element03.click();
				Thread.sleep(1000);
				element.sendKeys(string);
				
				
			
			break;

		default:
			break;
		}
		
		Thread.sleep(3000);
		
		
		switchToMainFrame();
		Thread.sleep(2000);
		
		
	}	
	
	@When("User Enter The Quantity Value Box1 {string} ,Box2 {string} ,Box3 {string}")
	public void user_enter_the_quantity_value_box1_box2_box3(String string, String string2, String string3) throws InterruptedException {
	    
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		//Thread.sleep(1000);
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("(//span[@class='ops'])[1]//following-sibling::p//child::input[@class='quantity']"));
		element.click();
		Thread.sleep(1000);
		element.sendKeys(string);
		
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("(//span[@class='ops'])[1]//following-sibling::p//child::input[@class='quantity']"));
		element2.click();
		Thread.sleep(1000);
		element2.sendKeys(string2);
		
		Thread.sleep(2000);
		WebElement element3 = driver.findElement(By.xpath("(//span[@class='ops'])[1]//following-sibling::p//child::input[@class='quantity']"));
		element3.click();
		Thread.sleep(1000);
		element3.sendKeys(string3);
		
		switchToMainFrame();
		Thread.sleep(2000);
			
		
	}
	
	@When("User Enter The {int} Quantity Value {string}")
	public void user_enter_the_quantity_value(Integer int1, String string) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		//Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//span[@class='min_qty']"));
		String text = element2.getText();
		int a = Integer.parseInt(text);
		int value1=a-5;
		int value2=a+5;
	    String	stringValue = String.valueOf(value1);
	    String	stringValue2 = String.valueOf(value2);
	    
	    switch (string) {
	    
		case "Less than":
			
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("(//span[@class='ops'])["+int1+"]//following-sibling::p//child::input[@class='quantity']"));
			element.click();
			Thread.sleep(1000);
			element.sendKeys(stringValue);
			break;
			
        case "Greater than":
			
			Thread.sleep(2000);
			WebElement element1 = driver.findElement(By.xpath("(//span[@class='ops'])["+int1+"]//following-sibling::p//child::input[@class='quantity']"));
			element1.click();
			Thread.sleep(1000);
			element1.sendKeys(stringValue2);

			 break;
			
         case "Equal to":
			
			Thread.sleep(2000);
			WebElement element3 = driver.findElement(By.xpath("(//span[@class='ops'])["+int1+"]//following-sibling::p//child::input[@class='quantity']"));
			element3.click();
			Thread.sleep(1000);
			WebElement element11 = driver.findElement(By.xpath("//span[@class='min_qty']"));
			String text1 = element11.getText();
			Thread.sleep(1000);
			element3.sendKeys(text1);
			break;
			

		default:
			System.out.println("Invalid");
			
			break;
		}
		
		switchToMainFrame();
		Thread.sleep(2000);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
