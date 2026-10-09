package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
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

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DownTime extends BaseClass {

	@When("User Enter Client Code {string}")
	public void user_enter_client_code(String string) throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		 driver.get("https://backoffice.navia.co.in/Internal/DOwnTimeUI/DTULogin.aspx");
		 driver.manage().window().maximize();
	     Thread.sleep(3000);
		
	     WebElement clientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.name("txtUcc")));
		 clientCode.sendKeys(string);
	     
		
		Thread.sleep(1000);
	
	}

	@When("User Enter valid DOB {string}")
	public void user_enter_valid_dob(String string) throws InterruptedException, AWTException {
	    
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

	@When("User Click Agree CheckBoxs")
	public void user_click_agree_check_boxs() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement clientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("LoginCheckBox")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("arguments[0].click();", clientCode);
		
		
		
		Thread.sleep(1000);
	
	}

	@When("User Enter valid OTP")
	public void user_enter_valid_otp() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement clientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("btnsubmit")));
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

	@Then("User should see Home Dashboard")
	public void user_should_see_home_dashboard() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			
			WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("(//button[@class='btn-close'])[2]")));
			loginButton.click();
			
		} catch (Exception e) {
			
			WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("(//button[@class='btn-close'])[1]")));
			loginButton.click();
			
		}
		
		
		 try {
	            new WebDriverWait(driver, Duration.ofSeconds(90)).until(
	                ExpectedConditions.or(
	                    ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//div[@class='navscl']//descendant::a)[1]")),
	                    ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//div[@class='navscl']//descendant::a)[2]")),
	                    ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//div[@class='navscl']//descendant::a)[3]")),
	                    ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("(//div[@class='navscl']//descendant::a)[4]"))
	                ));
	            
	            String blue = "\u001B[34m";
	            System.out.println(blue+"[INFO] Buyback successful - home page loaded.");
	            
	        } catch (Exception e) {
	            throw new AssertionError("Login did not reach the home page after OTP submission.", e);
	        }
		
		Thread.sleep(1000);
	
	}

	@Then("User should see Downtime message on Dashboard")
	public void user_should_see_downtime_message_on_dashboard() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='navscl']//descendant::a"));
		Thread.sleep(1000);
		elements.forEach(element -> {
			
			//Thread.sleep(1000);
		    String text = element.getText();
		   
		    if (element.isDisplayed()) {
		    	element.click();
		    
		    	String blue = "\u001B[34m";
		        System.out.println(blue+"Downtime testing for the "+text+" page was completed successfully,");
		    } else {
		    	
		    	 String red = "\u001B[31m";
		        System.out.println(red+"No Downtime message found in this element for "+text+".");
		    }
		});
		
		
		
		Thread.sleep(1000);
	
	}
	
	
	
}
