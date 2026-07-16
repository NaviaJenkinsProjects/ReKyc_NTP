package com.stepdefinition;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class BackOffice extends BaseClass {

	@When("User Open Arrow Dropdown")
	public void user_open_arrow_dropdown() throws InterruptedException {
		Thread.sleep(3000);
		clickAnElement("//i[@class='fa fa-bg fa-briefcase']//parent::a");

		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@When("User Open Dropdown and Click Trade Register enter Scrips {string} , Select From date {string} , To date {string} and Select all Dropdown")
	public void user_open_dropdown_and_click_trade_register_enter_scrips_select_from_date_to_date_and_select_all_dropdown(
			String string, String string2, String string3) throws InterruptedException, AWTException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//b[@class='collapse-sign'])[2]")).click();
		Thread.sleep(1000);

		// clickAnElement("//span[text()='TradeReg']//ancestor::button");
		driver.findElement(By.xpath("(//span[text()='Trade Register']//parent::span)[1]")).click();
		Thread.sleep(10000);
		// clickAnElement("//span[text()='TradeReg']//ancestor::button");
		// Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='tab-pane active']"));
		driver.switchTo().frame(element);
		Thread.sleep(6000);

		// clickAnElement("//input[@role='textbox']");

		// sendKeys("//input[@role='textbox']", string);
		Thread.sleep(2000);

		clickAnElement("//input[@id='DateFrom']");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		for (int i = 0; i <= 100; i++) {
			// Wait for the "Prev" button to be clickable
			WebElement element2 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@id='ui-datepicker-div']//descendant::span[text()='Prev']")));

			// Wait for the month element to be visible (it could be any month, not just
			// "September")
			WebElement monthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@id='ui-datepicker-div']//descendant::div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")));

			String currentMonth = monthElement.getText(); // Get the current month text dynamically

			// If the current month is "January", select the 1st date and break the loop
			if (currentMonth.equals("January")) {
				driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td//a[text()='1']"))
						.click();
				break; // Exit the loop once January is found
			} else {
				element2.click(); // Click "Prev" to go to the previous month
			}
		}

		Thread.sleep(2000);

		// driver.findElement(By.xpath("//input[@id='DateFrom']")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);

	}

	@When("User Click Statements and Reports")
	public void user_click_statements_and_reports() throws InterruptedException {
		Thread.sleep(2000);

		clickAnElement("//label[text()='Statement and Reports']//parent::a");

	}

	@When("User Open Dropdown and Click DP Holdings")
	public void user_open_dropdown_and_click_dp_holdings() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement element2 = driver.findElement(By.xpath("(//span[text()='Depository']//parent::span)[2]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");

		js.executeScript("arguments[0].scrollIntoView(true);", element2);

		js.executeScript("arguments[0].click();", element2);

		Thread.sleep(2000);
		clickAnElement("(//span[text()='Holding Statement']//parent::span)[2]");
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='tab-pane active']"));
		driver.switchTo().frame(element);
		Thread.sleep(6000);

		driver.findElement(By.xpath("//input[@value=' View']")).click();
		Thread.sleep(2000);

	}

	@When("User Open Dropdown and Click DP Trans")
	public void user_open_dropdown_and_click_dp_trans() throws InterruptedException {

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement element2 = driver.findElement(By.xpath("//span[text()='Demat']"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");

		js.executeScript("arguments[0].scrollIntoView(true);", element2);

		js.executeScript("arguments[0].click();", element2);

		Thread.sleep(2000);
		clickAnElement("//span[text()='Transfer Ledger']");
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='tab-pane active']"));
		driver.switchTo().frame(element);
		Thread.sleep(6000);

		driver.findElement(By.xpath("//input[@id='cmdok']")).click();

		Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		for (int i = 0; i <= 100; i++) {
			// Wait for the "Prev" button to be clickable
			WebElement element3 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@id='ui-datepicker-div']//descendant::span[text()='Prev']")));

			// Wait for the month element to be visible (it could be any month, not just
			// "September")
			WebElement monthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@id='ui-datepicker-div']//descendant::div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")));
			Thread.sleep(2000);

			String currentMonth = monthElement.getText(); // Get the current month text dynamically

			// If the current month is "January", select the 1st date and break the loop
			if (currentMonth.equals("January")) {
				Thread.sleep(2000);

				driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td//a[text()='1']"))
						.click();
				break; // Exit the loop once January is found
			} else {
				Thread.sleep(2000);

				element3.click(); // Click "Prev" to go to the previous month
			}
		}

		driver.findElement(By.xpath("//input[@value=' View']")).click();
		Thread.sleep(2000);

	}

	@When("User Open Dropdown and Click Colletaral")
	public void user_open_dropdown_and_click_colletaral() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement element3 = driver.findElement(By.xpath("//span[text()='MTF Reports']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");

		js.executeScript("arguments[0].scrollIntoView(true);", element3);

		js.executeScript("arguments[0].click();", element3);
		Thread.sleep(10000);
		
		clickAnElement("//span[text()='MTF Client Collateral/Funded Stocks']");
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='tab-pane active']"));
		driver.switchTo().frame(element);
		Thread.sleep(6000);

		driver.findElement(By.xpath("//input[@value=' View']")).click();
		Thread.sleep(2000);

		WebElement element2 = driver.findElement(By.xpath("//table[@id='ReportTable']"));
		boolean displayed = element2.isDisplayed();

		System.out.println("Verified the Share Margin Report is Dispalyed : " + displayed);
		driver.switchTo().defaultContent();
		driver.close();

	}

	@When("User Open Dropdown and Click Positions")
	public void user_open_dropdown_and_click_positions() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebElement element3 = driver.findElement(By.xpath("//span[text()='Trading']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");

		js.executeScript("arguments[0].scrollIntoView(true);", element3);

		js.executeScript("arguments[0].click();", element3);

		Thread.sleep(2000);
		clickAnElement("//span[text()='Net Positions']");
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='tab-pane active']"));
		driver.switchTo().frame(element);
		Thread.sleep(6000);

		driver.findElement(By.xpath("//select[@id='DateType']")).click();

		WebElement element2 = driver.findElement(By.xpath("//select[@id='DateType']"));
		Select s = new Select(element2);
		s.selectByVisibleText("Date Range ");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='Date1']")).click();

		Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		for (int i = 0; i <= 100; i++) {
			// Wait for the "Prev" button to be clickable
			WebElement element4 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@id='ui-datepicker-div']//descendant::span[text()='Prev']")));

			// Wait for the month element to be visible (it could be any month, not just
			// "September")
			WebElement monthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@id='ui-datepicker-div']//descendant::div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")));
			Thread.sleep(2000);

			String currentMonth = monthElement.getText(); // Get the current month text dynamically

			// If the current month is "January", select the 1st date and break the loop
			if (currentMonth.equals("January")) {
				Thread.sleep(2000);

				driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td//a[text()='1']"))
						.click();
				break; // Exit the loop once January is found
			} else {
				Thread.sleep(2000);

				element4.click(); // Click "Prev" to go to the previous month
			}
		}

		driver.findElement(By.xpath("//input[@value=' View']")).click();
		Thread.sleep(2000);

	}

	@When("User click ledger and View Data")
	public void user_click_ledger_and_view_data() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebElement element31 = driver.findElement(By.xpath("//span[text()='Finance']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");

		js.executeScript("arguments[0].scrollIntoView(true);", element31);

		js.executeScript("arguments[0].click();", element31);
		Thread.sleep(2000);
		clickAnElement("(//span[text()='Ledger'])[1]");
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='tab-pane active']"));
		driver.switchTo().frame(element);
		Thread.sleep(6000);
//
//		clickAnElement("//input[@id='startDate']");
//		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//		for (int i = 0; i <= 100; i++) {
//			// Wait for the "Prev" button to be clickable
//			WebElement element2 = wait.until(ExpectedConditions
//					.elementToBeClickable(By.xpath("//div[@id='ui-datepicker-div']//descendant::span[text()='Prev']")));
//
//			// Wait for the month element to be visible (it could be any month, not just
//			// "September")
//			WebElement monthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//					"//div[@id='ui-datepicker-div']//descendant::div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")));
//
//			String currentMonth = monthElement.getText(); // Get the current month text dynamically
//
//			// If the current month is "January", select the 1st date and break the loop
//			if (currentMonth.equals("May")) {   //May
//				driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td//a[text()='1']"))
//						.click();
//				break; // Exit the loop once January is found
//			} else {
//				element2.click(); // Click "Prev" to go to the previous month
//			}
//		}
//
//		Thread.sleep(3000);

		Actions a = new Actions(driver);

		WebElement element3 = driver.findElement(By.xpath("//input[@value=' View']"));

		a.moveToElement(element3).perform();
		Thread.sleep(2000);
		a.click(element3).perform();
		
		try {
			
			Thread.sleep(2000);
			a.click(element3).perform();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(6000);

		WebElement element2 = driver.findElement(By.xpath("//div[@id='Report']"));
		boolean displayed = element2.isDisplayed();

		System.out.println("Verified the Ledger is Dispalyed : " + displayed);
		driver.switchTo().defaultContent();
		driver.close();
		Thread.sleep(2000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}

	}

	@When("User click Portfolio and View Data")
	public void user_click_portfolio_and_view_data() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebElement element31 = driver.findElement(By.xpath("//span[text()='Finance']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");

		js.executeScript("arguments[0].scrollIntoView(true);", element31);

		js.executeScript("arguments[0].click();", element31);
		Thread.sleep(2000);
		clickAnElement("//span[text()='Client Portfolio Report']");
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='tab-pane active']"));
		driver.switchTo().frame(element);
		Thread.sleep(6000);

		driver.findElement(By.xpath("//input[@value=' View']")).click();
		Thread.sleep(2000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500);");

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500);");
		WebElement element2 = driver.findElement(By.xpath("//div[@id='Report']"));
		boolean displayed = element2.isDisplayed();

		System.out.println("Verified the Ledger is Dispalyed : " + displayed);

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.close();
		Thread.sleep(2000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
	}

	@When("User click Myinfo and View Data")
	public void user_click_myinfo_and_view_data() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebElement element31 = driver.findElement(By.xpath("//strong[text()='My Info']//parent::span"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");

		js.executeScript("arguments[0].scrollIntoView(true);", element31);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", element31);

		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='tab-pane active']"));
		driver.switchTo().frame(element);
		Thread.sleep(6000);

		WebElement element2 = driver.findElement(By.xpath("//input[@id='txtClient']"));
		String attribute = element2.getAttribute("value");
		System.out.println(attribute);

		boolean displayed = element2.isDisplayed();

		System.out.println("The My info Page is Displayed : " + displayed);

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.close();
		Thread.sleep(2000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
	}

}


