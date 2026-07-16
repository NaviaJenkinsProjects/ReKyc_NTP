package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.baseclass.BaseClass;
import com.pom.GL_Negative_POM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuestLogin_Negative extends BaseClass {
	
	GL_Negative_POM p = new GL_Negative_POM(driver);
	
	@Given("User The Launch Url")
	public void user_the_launch_url() throws InterruptedException, AWTException {
	    
		driver.get("https://yopmail.com/");

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		WebElement yopMail = driver.findElement(By.xpath("//input[@placeholder='Enter your inbox here']"));
		yopMail.sendKeys("guestloginautomation@yopmail.com");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();

		WebElement createAccount = driver.findElement(By.xpath("//a[@title='YOPmail - Temporary email']"));
		Actions ac = new Actions(driver);
		ac.contextClick(createAccount).perform();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(8000);

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);
		int size = li.size();
		System.out.println(size);

		driver.switchTo().window(li.get(1));

		driver.navigate().refresh();

		getUrl("https://rocket.tradeplusonline.com/login.php");

		driver.navigate().refresh();

		driver.switchTo().window(li.get(0));

		driver.switchTo().window(li.get(1));

		Thread.sleep(5000);

	}

	@When("User Click The {string} Account")
	public void user_click_the_account(String string) throws InterruptedException {
	   
		driver.findElement(By.xpath("(//a[text()='"+string+"'])[4]")).click();
		Thread.sleep(1000);
		
	}
	
	@When("User Click The Name button to Value {string}")
	public void user_click_the_name_button_to_value(String string) throws InterruptedException {
	    
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(string);
		Thread.sleep(2000);
		
	}

	@When("User Click The Email button to Value {string}")
	public void user_click_the_email_button_to_value(String string) throws InterruptedException {
	   
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(string);
		Thread.sleep(2000);
		
	}

	@When("User Click The Mobile Number button to Value {string}")
	public void user_click_the_mobile_number_button_to_value(String string) throws InterruptedException {
	   
		driver.findElement(By.xpath("//input[@placeholder='Mobile number']")).sendKeys(string);
		Thread.sleep(2000);
		
	}
	
	@When("User Click The Agree button {string}")
	public void user_click_the_agree_button(String string) throws InterruptedException {
		
		
		
		if (string.equalsIgnoreCase("true")) {
			
			driver.findElement(By.xpath("//input[@id='gu_t_cond']")).click();
			Thread.sleep(2000);	
		}
		
		else {
			
			System.out.println("User_Not click_the_agree_button");
			
		}
		
	}
	
	@When("User Click The {string} Page button")
	public void user_click_the_page_button(String string) throws InterruptedException {
	    
		driver.findElement(By.xpath("(//button[text()='"+string+" '])[2]")).click();
		Thread.sleep(2000);
		
	}
	
	@Then("I should see an error message {string}")
	public void i_should_see_an_error_message(String string) throws InterruptedException {
		
		WebElement name = driver.findElement(By.xpath("//div[@id='bouncer-error_username']"));
		String text = name.getText();
		
		if (text.contains("Please fill out this field")) {
			System.err.println("verify the Name pop up is displayed");
		} else {
			System.out.println("verify the Name pop up is not displayed");

		}
		
		Thread.sleep(1000);
		
		WebElement email = driver.findElement(By.xpath("//div[@id='bouncer-error_useremail']"));
		String text2 = email.getText();
		
		if (text2.contains("Please fill out this field")) {
			
			System.err.println("verify the Email pop up is displayed");
			
		} else {
			System.out.println("verify the pop up is not displayed");

		}
		
		Thread.sleep(1000);
		
		WebElement phone = driver.findElement(By.xpath("//div[@id='bouncer-error_userphone']"));
		String text3 = phone.getText();
		
		if (text3.contains("Please fill out this field")) {
			System.err.println("verify the PhoneNumber pop up is displayed");
		} else {
			System.out.println("verify the pop up is not displayed");

		}
		
		Thread.sleep(1000);
		
		WebElement agree = driver.findElement(By.xpath("//div[@id='bouncer-error_gu_t_cond_on']"));
	    String text4 = agree.getText();
				
		if (text4.contains("This field is required")) {
			
			System.err.println("verify the Agree pop up is displayed");
		} else {
			System.out.println("verify the pop up is not displayed");

		}
		
		Thread.sleep(2000);
		
		
	}
	
//	@Then("I should see an error message {string} and {string}")
//	public void i_should_see_an_error_message(String expectedText, WebElement element) throws InterruptedException {
//	
//		String acutal_Text = element.getText();
//		
//		if (acutal_Text.contains(expectedText)) {
//			System.out.println("the pop up display successfully");
//		} else {
//			System.out.println("the pop up is not display");
//
//		}
//		
//		Thread.sleep(1000);
//	}
	
	@Then("I should see an error message Name")
	public void i_should_see_an_error_message_name() throws InterruptedException {
	   
		WebElement name = driver.findElement(By.xpath("//div[@id='bouncer-error_username']"));
		String text = name.getText();
		
		if (text.equalsIgnoreCase("Please fill out this field")) {
			
			System.err.println("verify the Name pop up is displayed");
		} 
		
		else {
			
			System.out.println("verify the Name pop up is not displayed");

		}
		
		Thread.sleep(2000);
		
		
	}
	
	@Then("I should see an error message Email")
	public void i_should_see_an_error_message_email() throws InterruptedException {
	    
		WebElement email = driver.findElement(By.xpath("//div[@id='bouncer-error_useremail']"));
	
		
		if (email.isDisplayed()) {
			
			System.err.println("verify the Email pop up is displayed");
			
		} 
		
		else {
			System.out.println("verify the pop up is not displayed");

		}
		
		Thread.sleep(2000);
		
		
	}
	
	@Then("I should see an error message Number")
	public void i_should_see_an_error_message_number() throws InterruptedException {
	   
		WebElement phone = driver.findElement(By.xpath("//div[@id='bouncer-error_userphone']"));

		
		if (phone.isDisplayed()) {
			
			System.err.println("verify the PhoneNumber pop up is displayed");
		} else {
			System.out.println("verify the pop up is not displayed");

		}
		
		Thread.sleep(2000);
	}


	@Then("I should see an error message Agree")
	public void i_should_see_an_error_message_agree() throws InterruptedException {
	    
		WebElement agree = driver.findElement(By.xpath("//div[@id='bouncer-error_gu_t_cond_on']"));
	   
				
		if (agree.isDisplayed()) {
			
			System.err.println("verify the Agree pop up is displayed");
		} else {
			System.out.println("verify the pop up is not displayed");

		}
		
		Thread.sleep(2000);
		
	}
	
	@When("Navigate To Guest Login Page")
	public void navigate_to_guest_login_page() throws InterruptedException {
	    
		driver.navigate().to("https://rocket.tradeplusonline.com/index.php");
		Thread.sleep(2000);
		
	}

	@Then("I should see an error message Email and Number")
	public void i_should_see_an_error_message_email_and_number() throws InterruptedException {
	   
        WebElement email = driver.findElement(By.xpath("//div[@id='bouncer-error_useremail']"));
	
		
		if (email.isDisplayed()) {
			
			System.err.println("verify the Email pop up is displayed");
			
		} else {
			System.out.println("verify the pop up is not displayed");

		}
		
		Thread.sleep(1000);
		
        WebElement phone = driver.findElement(By.xpath("//div[@id='bouncer-error_userphone']"));

		
		if (phone.isDisplayed()) {
			
			System.err.println("verify the PhoneNumber pop up is displayed");
		} else {
			System.out.println("verify the pop up is not displayed");

		}
		
		Thread.sleep(2000);
		
	}
	
	@Then("I should see an error message {string} and {string}")
	public void i_should_see_an_error_message1(String expectedText ,WebElement element) throws InterruptedException {
	  
		

		String acutal_Text = element.getText();
		
		if (acutal_Text.contains(expectedText)) {
			System.err.println("the pop up display successfully");
		} else {
			System.out.println("the pop up is not display");

		}
		
		Thread.sleep(1000);
		
		
	}
	
	
	
	
	
	
	
	

}
