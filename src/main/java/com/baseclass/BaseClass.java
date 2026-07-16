package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver launchBrowser(String browser) {

        if (browser.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);

//            System.out.println("Running in Headless Mode");
//
//            options.addArguments("--headless=new");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//     
//            options.addArguments("--window-size=1920,1080");

            options.addArguments("--disable-extensions");
            
            options.addArguments("--disable-notifications");
        

            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        }

        if (driver == null) {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void getUrl(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    public static void clickOnElement(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void sendValues(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void quitBrowser() {
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                driver = null;
                wait = null;
            }
        }
    }

    public static void takeScreenshot(String name) {
        try {
            if (driver == null) {
                System.out.println("[SCREENSHOT] Skipped, WebDriver is not available: " + name);
                return;
            }
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
            String safeName = name.replaceAll("[^a-zA-Z0-9_\\-]", "_");
            File dest = new File("target/screenshots/" + safeName + "_" + timestamp + ".png");

            Files.createDirectories(dest.getParentFile().toPath());
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("[SCREENSHOT] Saved: " + dest.getPath());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WebDriverException e) {
            System.out.println("[SCREENSHOT] Skipped, browser was not available: " + e.getMessage());
        }
    }

    public static void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    // FIX: Replaced deprecated implicitlyWait(long, TimeUnit) — removed this method
    // Use driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(n)) directly
    public static void setImplicitWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    
    public void clickAnElement(String xpath) {

        try {

            // Normal Selenium Click
            driver.findElement(By.xpath(xpath)).click();
            System.out.println("Normal Click Success");

        } catch (Exception e) {

            try {

                // JavaScript Click
                WebElement element = driver.findElement(By.xpath(xpath));

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);

                System.out.println("JavaScript Click Success");

            } catch (Exception e2) {

                System.out.println("Unable to click element : " + xpath);
                e2.printStackTrace();

            }
        }
    }
	
    
	public static void switchToFrame(WebElement webElement) {
		driver.switchTo().frame(webElement);
	}
	
	public static void singleFrame() throws InterruptedException {
		
		Thread.sleep(2000);
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);
		
	}
	
	public static void framesHandling() {
		
		WebElement firstiFrame = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(firstiFrame);
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Financial Chart']"));
		driver.switchTo().frame(iframe);
		
	}
	
    public static void framesHandlingNaviaLogin() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    
			
			WebElement firstiFrame = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
			driver.switchTo().frame(firstiFrame);
			
			WebElement iframe = driver.findElement(By.xpath("//iframe[@id='ifr']"));
			driver.switchTo().frame(iframe);
			
		
		
	}
    
    public static void outOfFrames() {
    	
    	driver.switchTo().parentFrame();
    	driver.switchTo().defaultContent();

	}

	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void switchToMainFrame() throws InterruptedException {
		
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
	}

    
    
    
    
    
}
