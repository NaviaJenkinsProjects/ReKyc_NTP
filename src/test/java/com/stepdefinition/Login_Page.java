package com.stepdefinition;

import java.awt.AWTException;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;
import com.config.TestConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Login_Page extends BaseClass {

    @Given("User Navigate to Navia")
    public void user_navigate_to_navia() throws InterruptedException {
    	Thread.sleep(3000);
        // Use longer wait for headless — elements render slower without GPU
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // STEP 1: Open Navia login page
        driver.get(TestConfig.LOGIN_URL);
        Thread.sleep(3000);

        // STEP 2: Click login with client code
        try {
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Login with client code')]")));
            loginBtn.click();
        } catch (Exception e) {
            try {
                WebElement loginBtnAlt = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("(//button[@id='login_fsmt1'])[1]")));
                loginBtnAlt.click();
            } catch (Exception e2) {
                // Try JS click as last resort
                WebElement btn = driver.findElement(By.xpath("//button[@id='login_fsmt1']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            }
        }
        Thread.sleep(2000);

        // STEP 3: Enter credentials
        WebElement clientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("clientCode")));
        clientCode.clear();
        clientCode.sendKeys(TestConfig.CLIENT_CODE);
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.name("lPassword"));
        password.clear();
        password.sendKeys(TestConfig.PASSWORD);

        // STEP 4: Request OTP — triggers email to YopMail
        try {
            driver.findElement(By.xpath("//input[@onclick='GetTOTP()']")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//button[contains(text(),'Get OTP')]")).click();
        }

        String naviaWindow = driver.getWindowHandle();

        // STEP 5: Wait for OTP email to arrive
        Thread.sleep(20000);

        // STEP 6: Open YopMail in a new tab so the requested OTP stays bound
        // to the current Navia login page.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(TestConfig.OTP_PROVIDER_URL);

        WebElement inbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Enter your inbox here']")));
        inbox.clear();
        inbox.sendKeys(TestConfig.OTP_MAILBOX);

        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
        Thread.sleep(5000);

        // STEP 7: Switch to mail iframe and fetch OTP with retries
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

        // STEP 8: Enter the OTP on the same Navia login page that requested it.

        try {
            WebElement agree = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
            if (!agree.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agree);
            }
        } catch (Exception e) {
            System.out.println("[INFO] Login agreement checkbox was not available.");
        }

        // STEP 9: Enter OTP
        WebElement otpBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='userotp' or @name='usertotp' or @name='userotp']")));
        otpBox.clear();
        otpBox.sendKeys(otp);

        // STEP 10: Click login
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@id='login_fsmt' or @value='Login' or normalize-space()='Login']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

        // STEP 11: Wait for home page — increased to 90s for headless slow render
        // Added more fallback XPaths in case primary ones aren't present on web.navia.co.in
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='Dashboard']")),
                    ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='user-name']")),
                    ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[@data-title='MF']")),
                    ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//li[@class='widgets_mf']")),
                    ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[@data-dhx-id='btn_addmoney']"))
                ));
            System.out.println("[INFO] Login successful - home page loaded.");
        } catch (Exception e) {
            throw new AssertionError("Login did not reach the home page after OTP submission.", e);
        }

        // STEP 12: Handle optional risk disclosure
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[text()='Agree']//parent::button")))
                .click();
            System.out.println("Risk disclosure accepted");
        } catch (Exception e) {
            System.out.println("Risk disclosure not displayed");
        }
    }
    
    
    @When("User Click login with client code")
	public void user_click_login_with_client_code() throws InterruptedException {
		System.out.println("User Click login with client code");
	}

	@When("User Enter Client Code")
	public void user_enter_client_code() throws InterruptedException {
		System.out.println("User Enter Client Code");

	}

	@When("User  Enter Password")
	public void user_enter_password() throws InterruptedException {

		System.out.println("User Enter Password");

	}

	@When("User Click Agree CheckBox")
	public void user_click_agree_check_box() {
		System.out.println("User Click Agree CheckBox");

	}

	@When("User Click Login button")
	public void user_click_login_button() throws InterruptedException, AWTException {

		System.out.println("User Click Login button");

	}

	@When("User Click Otp Verification and enter manualy")
	public void user_click_otp_verification_and_enter_manualy() throws InterruptedException {

		System.out.println("User Handle Otp Verification for Automation");

	}
	
	@When("User Click Login Again")
	public void user_click_login_again() throws InterruptedException {

		driver.manage().window().maximize();
	Thread.sleep(2000);
		//clickOnElement(l.getLoginAfterOTP());
//		setImplicitWait(24);
//	driver.findElement(By.xpath("//button[@data-dhx-id='form_button_1']")).click();
	
	try {
		
		WebElement textBox = driver.findElement(By.xpath("//h2[contains(text()='RISK DISCLOSURES ON')]"));

		Thread.sleep(2000);

		if (textBox.isDisplayed()) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Agree']//parent::button")).click();
			
			System.out.println("Login Page");


		}

		else {
			
			driver.findElement(By.xpath("//span[text()='Agree']//parent::button")).click();
			System.out.println("Not Preset in Agree Page");

		}
		
		
	} catch (Exception e) {
		
		System.err.println("Not Visiable in Agree page");
		
	}


	
	Thread.sleep(2000);
	
	try {
		
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
	} catch (Exception e) {
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
	}
		
	
	try {
		
		Actions s=new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//div[@class='user-name']"));
		
		s.moveToElement(element).perform();
		Thread.sleep(1000);
		s.click(element).perform();
		Thread.sleep(1000);
		
		
		WebElement element1 = driver.findElement(By.xpath("//li[@class='Light']"));
		s.moveToElement(element1).perform();
		Thread.sleep(1000);
		s.click(element1).perform();
		Thread.sleep(1000);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	
	//driver.manage().window().maximize();
	

	}
	
}
