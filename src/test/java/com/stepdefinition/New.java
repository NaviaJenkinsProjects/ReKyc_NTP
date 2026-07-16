package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.google.common.io.Files;

public class New extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		//launchBroswer("Chrome");
		
		getUrl("https://bo.tradeplusonline.com/RocketPlusBackOffice/LogFiles/NCLPayinErrorLog08apr2024.txt");
		
		
		Thread.sleep(5000);
		
		
		WebElement first5Sec = driver.findElement(By.xpath("//pre[@style='word-wrap: break-word; white-space: pre-wrap;']"));
		String text = first5Sec.getText();
		
		Thread.sleep(5000);

		driver.navigate().refresh();
		
		WebElement next5Sec = driver.findElement(By.xpath("//pre[@style='word-wrap: break-word; white-space: pre-wrap;']"));
		String text1 = next5Sec.getText();
		
		
		
		if (text.equals(text1)) {
			System.out.println("No Changes");
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File("C:\\Users\\Venkateshwaran\\git\\repository\\EightFourthFive_Testing\\NCLPayinErrorLogPicture\\LogPicture.png");
			Files.copy(src, des);
			
driver.navigate().to("https://accounts.google.com/InteractiveLogin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=ARZ0qKI-OlL97AHzrSW5jo-HTJUGbvX92-F9JL5tkG0YOoAc--tSk-Ov-Sx3LjsiF09roaEhm4JvDg&theme=mn&ddm=0&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("automationtestingnavia@gmail.com");
			
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(6000);

			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("NaviaAutomationTesting@24");
			Thread.sleep(2000);

		
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(10000);
			
			
			driver.findElement(By.xpath("//div[text()='Compose']")).click();
			Thread.sleep(2000);

			//driver.findElement(By.xpath("//div[text()='Recipients']")).click();
			
			driver.findElement(By.xpath("(//span[text()='Cc'])[1]")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys("venkateshwaran01096@gmail.com");
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys("Kiruthika1515@gmail.com");
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			
//			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys("sandeep@navia.co.in");
//			r.keyPress(KeyEvent.VK_ENTER);
//			r.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
			
//			driver.findElement(By.xpath("//div[@aria-label='Cc']")).click();
//			Thread.sleep(5000);
	//
	//
//			WebElement element = driver.findElement(By.xpath("//input[@id=':co']"));
//			element.sendKeys("venketsmart4848@gmail.com");
//			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Error Log");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("NCL Payin Error Log Picture ");
			
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[@id=':aj']")).click();
			
			Thread.sleep(5000);
			StringSelection s = new StringSelection("C:\\Users\\Venkateshwaran\\git\\repository\\EightFourthFive_Testing\\NCLPayinErrorLogPicture");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
			 Robot robot = new Robot();
				
	         robot.keyPress(KeyEvent.VK_CONTROL);
	         robot.keyPress(KeyEvent.VK_V);
	         robot.keyRelease(KeyEvent.VK_V);
	         robot.keyRelease(KeyEvent.VK_CONTROL);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
	         
	         Thread.sleep(2000);

	      // Press "End" key to scroll to the bottom (if needed)
	      robot.keyPress(KeyEvent.VK_END);
	      robot.keyRelease(KeyEvent.VK_END);
	      Thread.sleep(1000);

	      // Press "Shift" + "Tab" to select the last file
	      robot.keyPress(KeyEvent.VK_SHIFT);
	      robot.keyPress(KeyEvent.VK_TAB);
	      Thread.sleep(100);
	      robot.keyRelease(KeyEvent.VK_SHIFT);
	      robot.keyRelease(KeyEvent.VK_TAB);
	      Thread.sleep(1000);

	      robot.keyPress(KeyEvent.VK_END);
	      robot.keyRelease(KeyEvent.VK_END);
	      Thread.sleep(1000);
	      
	 
	      // Press "Enter" to attach the file
	      robot.keyPress(KeyEvent.VK_ENTER);
	      robot.keyRelease(KeyEvent.VK_ENTER);
	      Thread.sleep(8000);
//	      
	      robot.keyPress(KeyEvent.VK_TAB);
	      robot.keyRelease(KeyEvent.VK_TAB);
	      
	      robot.keyPress(KeyEvent.VK_ENTER);
	      robot.keyRelease(KeyEvent.VK_ENTER);
	      
	      //////////////////////
	      	
	      
	      Thread.sleep(10000);
	      

	      
	    //  driver.findElement(By.xpath("(//div[text()='Send'])[2]")).click();
		
			driver.findElement(By.xpath("//a[contains(@aria-label,'Automation')]")).click();
			Thread.sleep(15000);

			
			
			WebElement frame = driver.findElement(By.xpath("//iframe[@name='account']"));
			
			driver.switchTo().frame(frame);
			
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[text()='Sign out']")).click();
			
			
			driver.quit();

		} else {

			
			System.out.println("Changes");
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File("C:\\Users\\Venkateshwaran\\git\\repository\\EightFourthFive_Testing\\NCLPayinErrorLogPictureChanges\\LogPicture.png");
			Files.copy(src, des);
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
