package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Navia_Login extends BaseClass {

	
	

	@When("User Click The Collections Options {string} button")
	public void user_click_the_collections_options_button(String string) throws InterruptedException {

		Thread.sleep(3000);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(2000);
		WebElement element = driver
				.findElement(By.xpath("//div[@class='cl_card_list']//descendant::p[text()='" + string + "']"));
		Actions s = new Actions(driver);
		s.moveToElement(element).perform();
		Thread.sleep(1000);
		s.click(element).perform();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Check The Scroll Down")
	public void user_check_the_scroll_down() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		js.executeScript("window.scrollBy(0,500);");
		js.executeScript("window.scrollBy(0,500);");

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Check The Scroll Up")
	public void user_check_the_scroll_up() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);");
		js.executeScript("window.scrollBy(0,-500);");
		js.executeScript("window.scrollBy(0,-500);");

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Explore Options {string} button")
	public void user_click_the_explore_options_button(String string) throws InterruptedException {

		Thread.sleep(2000);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='dhx_header-row']//ancestor::span[text()='" + string + "']")).click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Page Options {string} button")
	public void user_click_the_page_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//nav[@class='dhx_widget dhx_toolbar ']//descendant::button[@aria-label='" + string + "']"))
				.click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

//	@When("User select the {string} price adjustment option")
//	public void user_select_the_price_adjustment_option(String string) {
//	    
//		WebElement radioButton = driver.findElement(By.xpath("//div[@style='left: 9.32933%; width: "+string+"%;']"));
//
//        // Click the radio button
//        if (!radioButton.isSelected()) {
//            radioButton.click();
//        }
//		
//	}

	@When("User select the {int} price adjustment {string} option")
	public void user_select_the_price_adjustment_option(int string, int string2) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//div[@style='left: 0%; width: 100%;']"));

//		WebElement element1 = driver.findElement(By.xpath("//div[@class='dhx_widget dhx_slider__track-holder']//descendant::div[@style='left: "+string+";']"));
//		WebElement element2 = driver.findElement(By.xpath("//div[@class='dhx_widget dhx_slider__track-holder']//descendant::div[@style='left: "+string2+";']"));

//		if (!radioButton.isSelected()) {
//            radioButton.click();
//        }
//		
//		assert radioButton.isSelected() : string + " radio button is not selected!";

		Actions a = new Actions(driver);

		// a.dragAndDrop(element1, element2).perform();
		a.dragAndDropBy(element, string, string2).perform();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Filters Options {string} button")
	public void user_click_the_filters_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='dhx_widget dhx_layout dhx_layout-rows dhx_layout-line']//descendant::h3[text()='"+string+"']//parent::div")).click();
				
		
		//driver.findElement(By.xpath("//div[@class='dhx_widget dhx_layout dhx_layout-rows dhx_layout-line']//descendant::h3[text()='"+string+"']//following-sibling::div"));
		
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The All Options Types {string} button")
	public void user_click_the_all_options_types_button(String string) throws InterruptedException, AWTException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='dhx_layout-cell dhx_layout-cell-content']//descendant::span[text()='"
				+ string + "']//parent::div")).click();

		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyRelease(KeyEvent.VK_DOWN);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Options Types {string} button")
	public void user_click_the_options_types_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//div[@class='dhx_layout-cell dhx_layout-cell-content']//descendant::label[text()='"+string+"']//parent::label[@class='dhx_label ']")).click();
		
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("user Mouse Over The Element")
	public void user_mouse_over_the_element() throws InterruptedException {

//		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
//		driver.switchTo().frame(iframe);

		WebElement element = driver.findElement(By.xpath("//span[text()='Funds']//parent::div"));

		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
		Thread.sleep(2000);

	}

	@When("User select the price adjustment {int} and {int}")
	public void user_select_the_price_adjustment_and(Integer int1, Integer int2) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//div[@style='left: 0%; width: 100%;']"));

		Actions a = new Actions(driver);

		// a.dragAndDrop(element1, element2).perform();
		a.dragAndDropBy(element, int1, int2).perform();

		switchToMainFrame();
		Thread.sleep(2000);

	}
	
	@When("User select the price adjustment {string}")
	public void user_select_the_price_adjustment(String string) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//div[@style='left: 4.9049%;']"));

		Actions a = new Actions(driver);

		a.clickAndHold(element).perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@style='left: "+string+".000%;']")).click();
		Thread.sleep(1000);

		switchToMainFrame();
		Thread.sleep(2000);
		
		
	}




	@When("User Click The Top Tabbar Header Options {string} button")
	public void user_click_the_top_tabbar_header_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath(
				"//ul[@class='top dhx_tabbar-header ']//descendant::span[text()='" + string + "']//parent::button"));

		Actions a = new Actions(driver);

		a.moveToElement(element).perform();
		Thread.sleep(1000);
		element.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User The Enters {string} In The Search Box")
	public void user_the_enters_in_the_search_box(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} The button")
	public void user_click_the_the_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string) {

		case "Add":

			driver.findElement(By.xpath("//span[text()='Add ']//parent::button")).click();

			WebElement add = driver.findElement(By.xpath("//span[text()='Added the scheme to the watchlist']"));
			String text = add.getText();

			if (text.contains("Added the scheme to the watchlist")) {

				System.err.println("The pop up display successfully");

			} else {

				System.err.println("The pop up is not display");

			}

			break;

		case "Remove":

			driver.findElement(By.xpath("//span[text()=' Remove ']//parent::button")).click();

			WebElement remove = driver.findElement(By.xpath("//span[text()='Removed the scheme from the watchlist']"));
			String text1 = remove.getText();

			if (text1.contains("Removed the scheme from the watchlist")) {

				System.err.println("The pop up display successfully");

			} else {

				System.err.println("The pop up is not display");

			}

			break;

		default:

			System.out.println("Invalid Your Condition");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Holding Fund {string}")
	public void user_click_the_holding_fund(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[text()='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Slider Ranges Options {string}")
	public void user_click_the_slider_ranges_options(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='sliderranges']//child::label[text()='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Adjustment Amount Value {int}")
	public void user_click_the_adjustment_amount_value(Integer int1) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='returnsliderOutput']")).click();
		driver.findElement(By.xpath("//input[@id='returnsliderOutput']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='returnsliderOutput']")).sendKeys("" + int1 + "");

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click Over The Past Duration {string}")
	public void user_click_over_the_past_duration(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='overpost']//child::label[text()='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Mutual Fund schemes {string}")
	public void user_click_the_mutual_fund_schemes(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[@for='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The SIP Amount {int}")
	public void user_click_the_sip_amount(Integer int1) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@aria-label='SIP Amount (₹)']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='SIP Amount (₹)']")).sendKeys("" + int1 + "");

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Frequency Options {string} button")
	public void user_click_the_frequency_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='dhx_input__icon dxi dxi-menu-down']//parent::div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@data-dhx-id='p_type']//child::option[text()='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The {int} SIP Installment")
	public void user_click_the_sip_installment(Integer int1) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@aria-label='SIP Installment']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='SIP Installment']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='SIP Installment']")).sendKeys("" + int1 + "");

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Monthly SIP Date {int}")
	public void user_click_the_monthly_sip_date(Integer int1) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='date_button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='" + int1 + "']//parent::label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click {string} The button")
	public void user_click_the_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//parent::button")).click();

		WebElement element = driver.findElement(By.xpath("//div[@class='crt_popup']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Close The Create Mandate")
	public void user_close_the_create_mandate() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Mutual Fund Scheme {string}")
	public void user_click_the_mutual_fund_scheme(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//parent::label")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Amount {int}")
	public void user_click_the_amount(Integer int1) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@data-dhx-id='ot_amt']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-dhx-id='ot_amt']")).sendKeys("" + int1 + "");

		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Pay Now button")
	public void user_click_the_pay_now_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='start_ot']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The UPI {string} and Pay button")
	public void user_click_the_upi_and_pay_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@data-dhx-id='upi_val']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-dhx-id='upi_val']")).sendKeys("" + string + "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-dhx-id='pay_upi']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Filter Options {string} Radio button")
	public void user_click_the_filter_options_radio_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//ancestor::div[@class='dhx_layout-cell']"))
				.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {int} Day and {string} Month Start Time")
	public void user_click_the_day_and_month_start_time(Integer int1, String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Start time']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-live='polite']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='" + string + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='" + int1 + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {int} Day and {string} Month End Time")
	public void user_click_the_day_and_month_end_time(Integer int1, String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='End time']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-live='polite']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='" + string + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='" + int1 + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Filter Options {string} button")
	public void user_click_the_filter_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//parent::div")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The New Fund Offerings button")
	public void user_click_the_new_fund_offerings_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='quick_acc']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The FAQ button")
	public void user_click_the_faq_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='FAQ']")).click();

		switchToMainFrame();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> a = new ArrayList<>(windowHandles);
		Thread.sleep(2000);
		driver.switchTo().window(a.get(0));

		Thread.sleep(2000);

	}

	@When("User Print The Investments Values")
	public void user_print_the_investments_values() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='invest_card']"));

		for (WebElement webElement : elements) {

			System.err.println(webElement.getText());

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Cross Check The Invesment Value")
	public void user_cross_check_the_invesment_value() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_CurrentValue']"));
		String value1 = element1.getText();
		String current = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Current Value : " + current);
		float a = Float.parseFloat(current); // Convert string to float

		WebElement element2 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_InvestedValue']"));
		String value2 = element2.getText();
		String invested = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Invested Value : " + invested);
		float b = Float.parseFloat(invested);

		WebElement element3 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_TotalReturns']"));
		String value3 = element3.getText();
		String total = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(total); // Convert string to float

		float value4 = a - b;
		String e = String.format("%.2f", value4);
		System.err.println("Total Returns(P/L) : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.err.println("Total Returns is Correct");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User verify MutualFund Holdings Calculations in {string} P\\/L")
	public void user_verify_mutual_fund_holdings_calculations_in_p_l(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='market_value']"));
		String value2 = element2.getText();
		String market = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Market_value : " + market);
		float b = Float.parseFloat(market);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//div[text()='" + string
				+ "']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='invest_amount']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Invest_Amount : " + invest);
		float a = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='pl']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = b - a;
		String e = String.format("%.3f", value4);
		System.err.println("Total Returns(P/L) : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("MarketValue(" + b + ")-InvestAmount(" + a + ")=P/L(" + d + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User verify MutualFund Holdings Calculations in {string} Average Price")
	public void user_verify_mutual_fund_holdings_calculations_in_average_price(String string)
			throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//div[text()='" + string
				+ "']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='invest_amount']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Invest_Amount : " + invest);
		float a = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='avail_units']"));
		String value2 = element2.getText();
		String avail = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Avail_Units : " + avail);
		float b = Float.parseFloat(avail);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='average_price']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = a / b;
		String e = String.format("%.3f", value4);
		System.err.println("Average_Price : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("InvestAmount(" + a + ")-AvailUnits(" + b + ")=AveragePrice(" + d + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User verify MutualFund Holdings Calculations in {string} Available Units")
	public void user_verify_mutual_fund_holdings_calculations_in_available_units(String string)
			throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//div[text()='" + string
				+ "']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='invest_amount']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Invest_Amount : " + invest);
		float a = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='average_price']"));
		String value2 = element2.getText();
		String average = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Average_price : " + average);
		float b = Float.parseFloat(average);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='avail_units']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = a / b;
		String e = String.format("%.3f", value4);
		System.err.println("Avail_Units : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("InvestAmount(" + a + ")-Averageprice(" + b + ")=AvailUnits(" + e + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

//	@When("User Verify {string} MutualFund Holdings Calculations in {string} Mathematics {string} and {string} Equal {string}")
//	public void user_verify_mutual_fund_holdings_calculations_in_mathematics_and_equal(String fund, String value1, String operator, String value2, String value3) throws InterruptedException {
//	   
//		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
//		driver.switchTo().frame(iframe);
//		Thread.sleep(1000);
//		
//		WebElement element1 = driver.findElement(By.xpath("//div[text()='"+fund+"']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='"+value1+"']"));
//		String text1 = element1.getText();
//		String invest = text1.replaceAll("[^0-9.,-]", "");
//		System.err.println(value1+" : "+invest);
//		float a = Float.parseFloat(invest); 
//		Thread.sleep(1000);
//		      
//		WebElement element2 = driver.findElement(By.xpath("//div[text()='"+fund+"']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='"+value2+"']"));
//		String text2 = element2.getText();
//		String market = text2.replaceAll("[^0-9.,-]", "");
//		System.err.println(value2+" : "+market);
//		float b = Float.parseFloat(market);
//		Thread.sleep(1000);
//	
//		WebElement element3 = driver.findElement(By.xpath("//div[text()='"+fund+"']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='"+value3+"']"));
//		String text3 = element3.getText();
//		String total = text3.replaceAll("[^0-9.,-]", "");
//		System.err.println(value3+" : "+total);
//		float c = Float.parseFloat(total); 
//
//		switch (operator) {
//		
//		case "Add":
//			
//			float value4= a+b;
//			String e = String.format("%.3f", value4);
//			float d = Float.parseFloat(e);
//			
//			 int PartA = (int) c;
//			 int PartB = (int) d;
//			 
//			 boolean equal = PartA == PartB;
//			 
//			 if (equal) {
//					
//				 System.err.println(value1+"("+a+")"+"+"+value2+"("+b+")"+"="+value3+"("+c+")"+" its Varify");
//					
//				} else {
//					
//					System.out.println("Not Varify");
//
//				}
//			
//			break;
//			
//        case "Sub":
//			
//			float value5= a-b;
//			String element5 = String.format("%.3f", value5);
//			float data5 = Float.parseFloat(element5);
//			
//			 int PartA1 = (int) c;
//			 int PartB1 = (int) data5;
//			 
//			 boolean equal1 = PartA1 == PartB1;
//			 
//			 if (equal1) {
//					
//				 System.err.println(value1+"("+a+")"+"-"+value2+"("+b+")"+"="+value3+"("+c+")"+" its Varify");
//					
//				} else {
//					
//					System.out.println("Not Varify");
//
//				}
//			
//			break;
//			
//         case "Mul":
//			
//			float value6= a*b;
//			String element6 = String.format("%.3f", value6);
//			float data6 = Float.parseFloat(element6);
//			
//			 int PartA2 = (int) c;
//			 int PartB2 = (int) data6;
//			 
//			 boolean equal2 = PartA2 == PartB2;
//			 
//			 if (equal2) {
//					
//					System.err.println(value1+"("+a+")"+"*"+value2+"("+b+")"+"="+value3+"("+c+")"+" its Varify");
//					
//				} else {
//					
//					System.out.println("Not Varify");
//
//				}
//			
//			break;
//			
//         case "Div":
// 			
// 			float value7= a/b;
// 			String element7 = String.format("%.3f", value7);
// 			float data7 = Float.parseFloat(element7);
// 			
// 			 int PartA3 = (int) c;
// 			 int PartB3 = (int) data7;
// 			 
// 			 boolean equal3 = PartA3 == PartB3;
// 			 
// 			 if (equal3) {
// 					
// 				System.err.println(value1+"("+a+")"+"/"+value2+"("+b+")"+"="+value3+"("+c+")"+" its Varify");
// 					
// 				} else {
// 					
// 					System.out.println("Not Varify");
//
// 				}
// 			
// 			break;
//			
//			
//
//		default:
//			
//			System.out.println("Invalid Your condition");
//			
//			break;
//		}
//		
//		
//		
//		switchToMainFrame();
//		Thread.sleep(2000);

//		
//	}

	@When("User Click The {string} Download button")
	public void user_click_the_download_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//a[text()='" + string + " ']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Menu Options {string}")
	public void user_click_the_menu_options(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//div[@class='invt_menu']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//ancestor::button")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Back To Holding button")
	public void user_click_the_back_to_holding_button() throws InterruptedException {

		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//div[text()=' BACK TO HOLDING']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Verify The Popup")
	public void user_verify_the_popup() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		WebElement popup = driver.findElement(By.xpath("//div[@class='cntreedem']"));

		if (popup.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Panel button")
	public void user_click_the_panel_button() throws InterruptedException {

		Thread.sleep(3000);
		
		try {
			
			WebElement element = driver.findElement(By.xpath("//span[@class='mws_btn']"));
			element.click();
			
		} catch (Exception e) {


			WebElement element = driver.findElement(By.xpath("//span[@class='mws_btn']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("arguments[0].click();", element);
		}

		

		Thread.sleep(2000);

	}

	@When("User Select The {string} button")
	public void user_select_the_button(String string) throws InterruptedException {

		WebElement element2 = driver.findElement(By.xpath("//label[text()=' " + string + "']"));
		element2.click();
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//span[@class='mws_btn act']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element1);

		List<WebElement> elements = driver.findElements(
				By.xpath("(//ul[@class='list ui-sortable'])[1]//descendant::span[text()='" + string + "']"));
		for (WebElement nse : elements) {

			String text = nse.getText();

			switch (string) {

			case "NSE":

				if (text != "BSE" || text != "MCX") {

					String purple = "\u001B[35m";
					System.err.println(purple+"The NSE Stock is display successfully");

				} else {

					System.err.println("The Stock is not display");
				}

				break;

			case "BSE":

				if (text != "NSE" || text != "MCX") {
					
					String purple = "\u001B[35m";
					System.err.println(purple+"The BSE Stock is display successfully");

				} else {

					System.err.println("The Stock is not display");
				}

				break;

			case "MCX":

				if (text != "BSE" || text != "NSE") {

					System.err.println("The MCX Stock is display successfully");

				} else {

					System.err.println("The Stock is not display");
				}

				break;

			default:

				System.out.println("Invalid");

				break;
			}

		}

		Thread.sleep(5000);
		WebElement element3 = driver.findElement(By.xpath("//span[@class='mws_btn act']"));
		js.executeScript("arguments[0].click();", element3);

		Thread.sleep(1000);
		WebElement element4 = driver.findElement(By.xpath("//span[@class='clear_filter']"));
		element4.click();

	}

	@When("User Click {string} Sort By The button")
	public void user_click_sort_by_the_button(String string) throws InterruptedException {

		WebElement element2 = driver.findElement(By.xpath("//button[text()='" + string + "']"));
		element2.click();
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//span[@class='mws_btn']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element1);

		Thread.sleep(5000);
		WebElement element3 = driver.findElement(By.xpath("//span[@class='mws_btn']"));
		js.executeScript("arguments[0].click();", element3);

		Thread.sleep(1000);
		WebElement element4 = driver.findElement(By.xpath("//span[@class='clear_filter']"));
		element4.click();

	}

	@When("User Click The Show direction button")
	public void user_click_the_show_direction_button() throws InterruptedException {

		WebElement element2 = driver.findElement(By.xpath("//span[text()='Show direction']"));
		element2.click();
		Thread.sleep(2000);

	}

	@When("User Click The Show holdings button")
	public void user_click_the_show_holdings_button() throws InterruptedException {

		WebElement element2 = driver.findElement(By.xpath("//span[text()='Show holdings']"));
		element2.click();
		Thread.sleep(2000);

	}

	@When("User Click The Change in {string} button")
	public void user_click_the_change_in_button(String string) throws InterruptedException {

		WebElement element2 = driver.findElement(
				By.xpath("//input[@class='switch show_sort']//following-sibling::label[text()='" + string + "']"));
		element2.click();
		Thread.sleep(2000);

	}

	@When("User Click The Show Price In {string} button")
	public void user_click_the_show_price_in_button(String string) throws InterruptedException {

		WebElement element2 = driver.findElement(By.xpath(
				"//input[@class='switch show_ltp show_sort']//following-sibling::label[text()='" + string + "']"));
		element2.click();
		Thread.sleep(2000);

	}

	@When("User Click The Flicker {string} button")
	public void user_click_the_flicker_button(String string) throws InterruptedException {

		WebElement element2 = driver.findElement(By.xpath(
				"//input[@class='switch show_flicker show_sort']//following-sibling::label[text()='" + string + "']"));
		element2.click();
		Thread.sleep(2000);

	}

	@When("User Click The {string} View button")
	public void user_click_the_view_button(String string) throws InterruptedException {

		WebElement element2 = driver.findElement(By.xpath("//li[text()=' " + string + "']"));
		element2.click();
		Thread.sleep(2000);

		WebElement element1 = driver.findElement(By.xpath("//span[@class='mws_btn']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element1);

		Thread.sleep(5000);
		WebElement element3 = driver.findElement(By.xpath("//span[@class='mws_btn']"));
		js.executeScript("arguments[0].click();", element3);

	}

	@When("User Validate the Total Investments")
	public void user_validate_the_total_investments() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_CurrentValue']"));
		String value2 = element2.getText();
		String current = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("CurrentValue : " + current);
		float a = Float.parseFloat(current);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_InvestedValue']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("InvestedValue : " + invest);
		float b = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_TotalReturns']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = a - b;
		String e = String.format("%.2f", value4);
		System.err.println("TotalReturns : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("CurrentValue(" + a + ") - InvestedValue(" + b + ")=Total Returns(" + d + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Validate The My Total Investments")
	public void user_validate_the_my_total_investments() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//span[@id='invt_grid_currentValue']"));
		String value2 = element2.getText();
		String current = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("CurrentValue : " + current);
		float a = Float.parseFloat(current);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//span[@id='invt_grid_InvestedValue']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("InvestedValue : " + invest);
		float b = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//span[@id='invt_grid_totalReturns']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = a - b;
		String e = String.format("%.2f", value4);
		System.err.println("TotalReturns : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("CurrentValue(" + a + ") - InvestedValue(" + b + ")=Total Returns(" + e + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Validate the Funds")
	public void user_validate_the_funds() throws InterruptedException {

		WebElement element1 = driver.findElement(By.xpath("//input[@data-dhx-id='available_invest']"));
		String value1 = element1.getAttribute("Value");

		String available = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Available_Invest : " + available);
		double a = Double.parseDouble(available);
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//input[@data-dhx-id='margin_used']"));
		String value2 = element2.getAttribute("Value");
		String margin = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Margin_Used : " + margin);
		double b = Double.parseDouble(margin);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//input[@data-dhx-id='utilization']"));
		String value3 = element3.getAttribute("Value");
		String pl = value3.replaceAll("[^0-9.,-]", "");
		double c = Double.parseDouble(pl);

		double value4 = a + b;
		String e = String.format("%.2f", value4);
		// System.err.println("Utilization : "+e);
		double d = Double.parseDouble(e);
		double k = c / d;
		double v = k * 100;

		System.err.println("Utilization : " + k);

		int integerPartA = (int) c;
		int integerPartB = (int) k;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("Available_Invest(" + a + ") + Margin_Used(" + b + ")=Total Value(" + d + ")");
			System.out.println(
					"Margin_Used(" + c + ") / Total Value(" + d + ")= (" + k + ") * 100 = Utilization(" + v + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

	}

	@When("User Validate {string} The Portfolio Value")
	public void user_validate_the_portfolio_value(String string) throws InterruptedException {
		Thread.sleep(3000);

		WebElement element1 = driver.findElement(By.xpath(
				"//div[@data-dhx-id='" + string + "']//descendant::div[@data-dhx-col-id='current']//child::div"));
		String value1 = element1.getText();
		String available = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Current : " + available);
		double a = Double.parseDouble(available);
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By
				.xpath("//div[@data-dhx-id='" + string + "']//descendant::div[@data-dhx-col-id='invest']//child::div"));
		String value2 = element2.getText();
		String margin = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Invest : " + margin);
		double b = Double.parseDouble(margin);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(
				By.xpath("//div[@data-dhx-id='" + string + "']//descendant::div[@data-dhx-col-id='opl']//child::div"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		double c = Double.parseDouble(pl);

		double value4 = a - b;
		String e = String.format("%.2f", value4);
		// System.err.println("Utilization : "+e);
		double d = Double.parseDouble(e);

		System.err.println("Overall Profits / Loss : " + d);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("Current(" + a + ") - Invest(" + b + ")=Overall Profits / Loss(" + d + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

	}

	@When("User Click The Withdraw button")
	public void user_click_the_withdraw_button() throws InterruptedException {

		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='funds_show']")).click();
		
		Thread.sleep(1000);
		
		try {
			
			driver.findElement(By.xpath("(//div[@class='nav_btns']//child::button[text()='Withdraw'])[1]")).click();
			
		} catch (Exception e) {
			
			try {
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//span[text()='Orders'])[1]")).click();
				
			} catch (Exception e2) {
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//span[text()='Orders'])[2]")).click();
				
			}
			
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[@class='funds_show']")).click();
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//div[@class='nav_btns']//child::button[text()='Withdraw'])[1]")).click();
		}

		
		Thread.sleep(4000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		Thread.sleep(2000);
		driver.switchTo().frame(frame);

		driver.findElement(By.xpath("//input[@placeholder='Enter amount']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter amount']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter amount']")).sendKeys("1");
		Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='bank_radio']"));
		Thread.sleep(2000);
		
        if (element.isDisplayed()) {
        	
        	String blue = "\u001B[34m";
        	
        	System.out.println(blue + "Bank Deatails is displayed");
			
			
		} 
		
		else {
			System.err.println("Bank Details is not displayed");

		}
        Thread.sleep(2000);
        
        driver.switchTo().defaultContent();
		
        Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title1='Dashboard']/parent::li")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//span[@class='funds_back'])[2]")).click();

	}

	@When("User Enter The {string} Amount")
	public void user_enter_the_amount(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Enter amount']"));
		element.click();
		element.sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Enter The Withdraw button")
	public void user_enter_the_withdraw_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//button[@onclick='withdraw()']"));
		element.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Back button")
	public void user_click_the_back_button() throws InterruptedException {

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@class='withdraw_founds']"));
		element.click();
		Thread.sleep(2000);

	}

	@When("User Click The Funds button")
	public void user_click_the_funds_button() throws InterruptedException {

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Funds ']"));
		element.click();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Icon button")
	public void user_click_the_icon_button(String string) throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//button[text()='" + string + "']"));
		element.click();
		Thread.sleep(2000);

	}

	@When("User MouseOver Dashboard and Click IPO\\/NFO\\/BOND")
	public void user_mouse_over_dashboard_and_click_ipo_nfo_bond() throws InterruptedException {

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='IPO/NFO/BOND']//ancestor::li")).click();
		Thread.sleep(3000);

	}

	@When("User MouseOver Dashboard and Click Tools button")
	public void user_mouse_over_dashboard_and_click_tools_button() throws InterruptedException {

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(dashBoard).perform();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//label[text()='Tools']//ancestor::li")).click();
		Thread.sleep(3000);

	}

	@When("User Verify The Current IPOs Details")
	public void user_verify_the_current_ip_os_details() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ipo_list']"));
		for (WebElement webElement : elements) {

			String text = webElement.getText();
			System.out.println(text);

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Verify The Upcoming IPOs Details")
	public void user_verify_the_upcoming_ip_os_details() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='pre_ipo']"));
		for (WebElement webElement : elements) {

			String text = webElement.getText();
			System.out.println(text);

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The MY IPO button")
	public void user_click_the_my_ipo_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//a[text()='MY IPO']//parent::li"));
		element.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Apply button")
	public void user_click_the_apply_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//input[@value='Apply']"));
		element.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Enter The UPI Id {string}")
	public void user_enter_the_upi_id(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//input[@type='test']"));
		element.click();
		Thread.sleep(1000);
		element.sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Category button")
	public void user_click_the_category_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//select[@class='ipo_cat']"));
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		a.click(element).perform();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Icon Option2 button")
	public void user_click_the_icon_option2_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("(//span[@class='ops']//child::input[@type='checkbox'])[2]"));
		element.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Icon Option3 button")
	public void user_click_the_icon_option3_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("(//span[@class='ops']//child::input[@type='checkbox'])[3]"));
		element.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Enter The Quantity Value {int} text Box")
	public void user_enter_the_quantity_value_text_box(Integer int1) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		// Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//span[@class='min_qty']"));
		String text = element2.getText();

		Thread.sleep(3000);
		WebElement element = driver.findElement(By
				.xpath("(//span[@class='ops'])[" + int1 + "]//following-sibling::p//child::input[@class='quantity']"));
		element.click();
		Thread.sleep(1000);
		element.sendKeys(text);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {int} Cut Off button")
	public void user_click_the_cut_off_button(Integer int1) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(
				By.xpath("(//div[@class='bid_field'])[" + int1 + "]//following-sibling::p//child::input[@class='mc']"));
		Thread.sleep(1000);
		element.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Agree Icon button")
	public void user_click_the_agree_icon_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//input[@id='terms']"));
		element.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The SUBMIT button")
	public void user_click_the_submit_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//input[@class='pop_smt mc33']"));
		element.click();

		switchToMainFrame();

	}

	@When("User Verify The Popup For IPO")
	public void user_verify_the_popup_for_ipo() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//div[@class='errorrand undefined']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Enter The {string} button")
	public void user_enter_the_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//input[@value='" + string + "']"));
		element.click();

		switchToMainFrame();
		Thread.sleep(1000);

	}

	@When("User Click IPO button")
	public void user_click_ipo_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("(//h4[text()='IPO'])[2]//ancestor::div[@class='menu_item']"));
		element.click();

		switchToMainFrame();
		Thread.sleep(1000);

	}

	// ========================================================Support=====================================================

	@When("User MouseOver Dashboard and Click Support")
	public void user_mouse_over_dashboard_and_click_support() throws InterruptedException {

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Support']//ancestor::li")).click();
		Thread.sleep(3000);

	}

	@When("User Select The Language {string}")
	public void user_select_the_language(String string) throws InterruptedException {

		Thread.sleep(2000);
		switch (string) {

		case "English":

			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//a[@data-value='en']//parent::li"));
			element.click();
			break;

		case "Hindi":

			Thread.sleep(2000);
			WebElement element1 = driver.findElement(By.xpath("//a[@data-value='hi']//parent::li"));
			element1.click();
			break;

		default:

			System.err.println("Invalid Your Language");
			break;
		}

		Thread.sleep(2000);
	}

	@When("User Click The {string} button and Verify")
	public void user_click_the_button_and_verify(String string) throws InterruptedException {

		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//a[text()='" + string + " ']//parent::li"));
		element1.click();

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//h3[text()='" + string + "']"));

		if (element.isDisplayed()) {

			System.err.println("To Navigate " + string + " Page");

		}

		else {
			System.out.println("Not Navigate to Page");

		}

		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Home']"));
		element3.click();

	}

	@When("User Navigate To Support Page")
	public void user_navigate_to_support_page() throws InterruptedException {

		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> a = new ArrayList<String>(windowHandles);
		driver.switchTo().window(a.get(1));
		driver.manage().window().maximize();
		Thread.sleep(2000);

	}

	@When("User Click The {string} and Verify")
	public void user_click_the_and_verify(String string) throws InterruptedException {

		Thread.sleep(1000);
		switch (string) {

		case "Modify Email ID Mobile number":

			WebElement element = driver
					.findElement(By.xpath("//a[text()=' Modify Email ID Mobile number']//parent::li"));
			element.click();
			Thread.sleep(1000);
			WebElement element1 = driver.findElement(By.xpath("//h3[text()='Modify Email ID / Mobile number']"));

			if (element1.isDisplayed()) {

				System.err.println("To Navigate " + string + " Page");
			}

			else {
				System.out.println("Not Navigate to Page");

			}

			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()=' Home']")).click();
			break;

		case "Understanding Margin Report":

			WebElement element2 = driver
					.findElement(By.xpath("//a[text()=' Understanding Margin Report']//parent::li"));
			element2.click();
			Thread.sleep(1000);
			WebElement element3 = driver.findElement(By.xpath("//h3[text()='Understanding Margin Report']"));

			if (element3.isDisplayed()) {

				System.err.println("To Navigate " + string + " Page");
			}

			else {
				System.out.println("Not Navigate to Page");

			}

			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()=' Home']")).click();
			break;

		case "Fund Payin - Payout button":

			WebElement element5 = driver.findElement(By.xpath("//a[text()='Fund Payin - Payout']//parent::li"));
			element5.click();
			Thread.sleep(1000);
			WebElement element6 = driver.findElement(By.xpath("//h3[text()='UPI - Payin']"));

			if (element6.isDisplayed()) {

				System.err.println("To Navigate " + string + " Page");
			}

			else {
				System.out.println("Not Navigate to Page");

			}

			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()=' Home']")).click();
			break;

		case "Order Rejections & Reasons":

			WebElement element7 = driver.findElement(By.xpath("//a[text()='Order Rejections & Reasons']//parent::li"));
			element7.click();
			Thread.sleep(1000);
			WebElement element8 = driver.findElement(By.xpath("//div[@class='wrapper']"));

			if (element8.isDisplayed()) {

				System.err.println("To Navigate " + string + " Page");
			}

			else {
				System.out.println("Not Navigate to Page");

			}

			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='back to home']")).click();
			break;

		default:

			System.err.println("Invalid Your Language");
			break;
		}

	}

	@When("User Click The Articles button")
	public void user_click_the_articles_button() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-tab='solutions']")).click();
		Thread.sleep(1000);
	}

	@When("User Click The Popular Articles {string} Options")
	public void user_click_the_popular_articles_options(String string) throws InterruptedException {

		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//input[@class='form-control']"));
		element1.click();

		Thread.sleep(1000);
		WebElement element2 = driver.findElement(By.xpath("//a[text()='" + string + "']"));
		element2.click();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//h3[text()='" + string + "']"));

		if (element.isDisplayed()) {

			System.err.println("To Navigate " + string + " Page");

		}

		else {
			System.out.println("Not Navigate to Page");

		}

		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Home']"));
		element3.click();

	}

	@When("User Click The Search Box and Value {string}")
	public void user_click_the_search_box_and_value(String string) throws InterruptedException {

		WebElement element1 = driver.findElement(By.xpath("//input[@class='form-control']"));
		element1.click();
		element1.sendKeys(string);

		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//button[@type='submit']"));
		element2.click();

		Thread.sleep(1000);

	}

	@When("User Click The Clear All button")
	public void user_click_the_clear_all_button() throws InterruptedException {

		WebElement element3 = driver.findElement(By.xpath("//input[@class='form-control']"));
		element3.click();

		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("//button[text()='Clear all']"));
		element2.click();

		Thread.sleep(1000);

	}

	@When("User Click The Track tickets button")
	public void user_click_the_track_tickets_button() throws InterruptedException {

		WebElement element2 = driver.findElement(By.xpath("//a[text()=' Track tickets']"));
		element2.click();

		Thread.sleep(2000);

	}

	@When("User Click The Back to website button")
	public void user_click_the_back_to_website_button() throws InterruptedException {

		WebElement element2 = driver.findElement(By.xpath("//a[@title='Back to website']//parent::li"));
		element2.click();

		Thread.sleep(2000);
	}

	@When("User Click Account Opening {string} Options")
	public void user_click_account_opening_options(String string) throws InterruptedException {

		Thread.sleep(2000);

		WebElement element2 = driver.findElement(By.xpath("//a[text()='" + string + "']"));
		element2.click();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//h3[text()='" + string + "']"));

		if (element.isDisplayed()) {

			System.err.println("To Navigate " + string + " Page");

		}

		else {
			System.out.println("Not Navigate to Page");

		}

		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Home ']"));
		element3.click();

	}

	@When("User Click Trading, Margins & Policies {string} Options")
	public void user_click_trading_margins_policies_options(String string) throws InterruptedException {

		Thread.sleep(2000);

		WebElement element2 = driver.findElement(By.xpath("//a[text()='" + string + "']"));
		element2.click();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//h3[text()='" + string + "']"));

		if (element.isDisplayed()) {

			System.err.println("To Navigate " + string + " Page");

		}

		else {
			System.out.println("Not Navigate to Page");

		}

		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Home ']"));
		element3.click();
	}

	@When("User Click Account Login and Reports {string} Options")
	public void user_click_account_login_and_reports_options(String string) throws InterruptedException {

		Thread.sleep(2000);

		WebElement element2 = driver.findElement(By.xpath("//a[text()='" + string + "']"));
		element2.click();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//h3[text()='" + string + "']"));

		if (element.isDisplayed()) {

			System.err.println("To Navigate " + string + " Page");

		}

		else {
			System.out.println("Not Navigate to Page");

		}

		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Home ']"));
		element3.click();
	}

	@When("User Account Login and Reports {string} Options")
	public void user_account_login_and_reports_options(String string) throws InterruptedException {

		Thread.sleep(2000);

		WebElement element2 = driver.findElement(By.xpath("//a[text()='" + string + "']"));
		element2.click();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//h3[text()='" + string + "']"));

		if (element.isDisplayed()) {

			System.err.println("To Navigate " + string + " Page");

		}

		else {
			System.out.println("Not Navigate to Page");

		}

		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Home ']"));
		element3.click();
	}

	@When("User Click Funds Deposit & Withdrawal {string} Options")
	public void user_click_funds_deposit_withdrawal_options(String string) throws InterruptedException {

		Thread.sleep(2000);

		WebElement element2 = driver.findElement(By.xpath("//a[text()='" + string + "']"));
		Actions a = new Actions(driver);
		a.moveToElement(element2).perform();
		Thread.sleep(1000);
		a.click(element2).perform();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//h3[text()='" + string + "']"));

		if (element.isDisplayed()) {

			System.err.println("To Navigate " + string + " Page");

		}

		else {
			System.out.println("Not Navigate to Page");

		}

		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Home ']"));
		element3.click();
	}

	@When("User Click NRI Trading {string} Options")
	public void user_click_nri_trading_options(String string) throws InterruptedException {

		Thread.sleep(2000);

		WebElement element2 = driver.findElement(By.xpath("//a[text()='" + string + "']"));
		Actions a = new Actions(driver);
		a.moveToElement(element2).perform();
		Thread.sleep(1000);
		a.click(element2).perform();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//h3[text()='" + string + "']"));

		if (element.isDisplayed()) {

			System.err.println("To Navigate " + string + " Page");

		}

		else {
			System.out.println("Not Navigate to Page");

		}

		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Home ']"));
		element3.click();
	}

	@When("User Click Miscellaneous {string} Options")
	public void user_click_miscellaneous_options(String string) throws InterruptedException {

		Thread.sleep(2000);

		WebElement element2 = driver.findElement(By.xpath("//a[text()='" + string + "']"));
		Actions a = new Actions(driver);
		a.moveToElement(element2).perform();
		Thread.sleep(1000);
		a.click(element2).perform();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//h3[text()='" + string + "']"));

		if (element.isDisplayed()) {

			System.err.println("To Navigate " + string + " Page");

		}

		else {
			System.out.println("Not Navigate to Page");

		}

		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Home ']"));
		element3.click();
	}

	// =========================================Tools======================================================

	@When("User Click The Mutual Fund button")
	public void user_click_the_mutual_fund_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		WebElement element = driver
				.findElement(By.xpath("(//h4[text()='Mutual Funds'])[1]//ancestor::div[@class='menu_item']"));
		element.click();

		switchToMainFrame();
		Thread.sleep(1000);

	}

	@When("User Click The Collections Tools Options {string} button")
	public void user_click_the_collections_tools_options_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='cl_card_list']//descendant::p[text()='" + string + "']")));
		element.click();

//		Thread.sleep(2000);
//		WebElement element = driver.findElement(By.xpath("//div[@class='cl_card_list']//descendant::p[text()='"+string+"']"));
//		WebElement element1 = driver.findElement(By.xpath("//button[@aria-controls='tab_holding']"));
//
//		Actions s= new Actions(driver);
//		s.moveToElement(element1).perform();
//		Thread.sleep(1000);
//		s.moveToElement(element).perform();
//		s.click(element).perform();

		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User Click The Explore Tools Options {string} button")
	public void user_click_the_explore_tools_options_button(String string) throws InterruptedException {

		Thread.sleep(2000);
		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='dhx_header-row']//ancestor::span[text()='" + string + "']")).click();
		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Page Tools Options {string} button")
	public void user_click_the_page_tools_options_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//nav[@class='dhx_widget dhx_toolbar ']//descendant::button[@aria-label='" + string + "']"))
				.click();
		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Filters Tools Options {string} button")
	public void user_click_the_filters_tools_options_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By
				.xpath("//div[@class='dhx_widget dhx_layout dhx_layout-rows dhx_layout-line']//descendant::h3[text()='"
						+ string + "']//parent::div"))
				.click();
		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User Click The All Tools Options Types {string} button")
	public void user_click_the_all_tools_options_types_button(String string) throws InterruptedException, AWTException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='dhx_layout-cell dhx_layout-cell-content']//descendant::span[text()='"
				+ string + "']//parent::div")).click();

		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyRelease(KeyEvent.VK_DOWN);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Options Tools Types {string} button")
	public void user_click_the_options_tools_types_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//div[@class='dhx_layout-cell dhx_layout-cell-content']//descendant::label[text()='" + string
						+ "']//parent::label[@class='dhx_label ']"))
				.click();
		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The All Options Tools Types {string} button")
	public void user_click_the_all_options_tools_types_button(String string) throws InterruptedException, AWTException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='dhx_layout-cell dhx_layout-cell-content']//descendant::span[text()='"
				+ string + "']//parent::div")).click();

		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyRelease(KeyEvent.VK_DOWN);

		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User select the price Tools adjustment {int} and {int}")
	public void user_select_the_price_tools_adjustment_and(Integer int1, Integer int2) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//div[@style='left: 0%; width: 100%;']"));

		Actions a = new Actions(driver);

		a.dragAndDropBy(element, int1, int2).perform();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Top Tabbar Header Tools Options {string} button")
	public void user_click_the_top_tabbar_header_tools_options_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='top dhx_tabbar-header ']//descendant::span[text()='"+string+"']//parent::button")));
//        element.click();

		WebElement element = driver.findElement(By.xpath(
				"//ul[@class='top dhx_tabbar-header ']//descendant::span[text()='" + string + "']//parent::button"));

		Actions a = new Actions(driver);

		a.moveToElement(element).perform();
		Thread.sleep(1000);
		element.click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools FAQ button")
	public void user_click_the_tools_faq_button() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='FAQ']")).click();

		outOfFrames();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> a = new ArrayList<>(windowHandles);
		Thread.sleep(2000);
		driver.switchTo().window(a.get(0));

		Thread.sleep(2000);
	}

	@When("User The Enters Tools {string} In The Search Box")
	public void user_the_enters_tools_in_the_search_box(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User Click The Tools {string} The button")
	public void user_click_the_tools_the_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		switch (string) {

		case "Add":

			driver.findElement(By.xpath("//span[text()='Add ']//parent::button")).click();

			WebElement add = driver.findElement(By.xpath("//span[text()='Added the scheme to the watchlist']"));
			String text = add.getText();

			if (text.contains("Added the scheme to the watchlist")) {

				System.err.println("The pop up display successfully");

			} else {

				System.err.println("The pop up is not display");

			}

			break;

		case "Remove":

			driver.findElement(By.xpath("//span[text()=' Remove ']//parent::button")).click();

			WebElement remove = driver.findElement(By.xpath("//span[text()='Removed the scheme from the watchlist']"));
			String text1 = remove.getText();

			if (text1.contains("Removed the scheme from the watchlist")) {

				System.err.println("The pop up display successfully");

			} else {

				System.err.println("The pop up is not display");

			}

			break;

		default:

			System.out.println("Invalid Your Condition");
			break;
		}

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Print The Tools Investments Values")
	public void user_print_the_tools_investments_values() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='invest_card']"));

		for (WebElement webElement : elements) {

			System.err.println(webElement.getText());

		}

		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User Cross Check The Tools Invesment Value")
	public void user_cross_check_the_tools_invesment_value() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_CurrentValue']"));
		String value1 = element1.getText();
		String current = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Current Value : " + current);
		float a = Float.parseFloat(current); // Convert string to float

		WebElement element2 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_InvestedValue']"));
		String value2 = element2.getText();
		String invested = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Invested Value : " + invested);
		float b = Float.parseFloat(invested);

		WebElement element3 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_TotalReturns']"));
		String value3 = element3.getText();
		String total = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(total); // Convert string to float

		float value4 = a - b;
		String e = String.format("%.2f", value4);
		System.err.println("Total Returns(P/L) : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.err.println("Total Returns is Correct");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Validate the Tools Total Investments")
	public void user_validate_the_tools_total_investments() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_CurrentValue']"));
		String value2 = element2.getText();
		String current = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("CurrentValue : " + current);
		float a = Float.parseFloat(current);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_InvestedValue']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("InvestedValue : " + invest);
		float b = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//span[@id='invest_card_bottom_TotalReturns']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = a - b;
		String e = String.format("%.2f", value4);
		System.err.println("TotalReturns : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("CurrentValue(" + a + ") - InvestedValue(" + b + ")=Total Returns(" + d + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User verify MutualFund Holdings Calculations Tools in {string} P\\/L")
	public void user_verify_mutual_fund_holdings_calculations_tools_in_p_l(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='market_value']"));
		String value2 = element2.getText();
		String market = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Market_value : " + market);
		float b = Float.parseFloat(market);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//div[text()='" + string
				+ "']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='invest_amount']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Invest_Amount : " + invest);
		float a = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='pl']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = b - a;
		String e = String.format("%.3f", value4);
		System.err.println("Total Returns(P/L) : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("MarketValue(" + b + ")-InvestAmount(" + a + ")=P/L(" + d + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User verify MutualFund Holdings Calculations Tools in {string} Average Price")
	public void user_verify_mutual_fund_holdings_calculations_tools_in_average_price(String string)
			throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//div[text()='" + string
				+ "']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='invest_amount']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Invest_Amount : " + invest);
		float a = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='avail_units']"));
		String value2 = element2.getText();
		String avail = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Avail_Units : " + avail);
		float b = Float.parseFloat(avail);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='average_price']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = a / b;
		String e = String.format("%.3f", value4);
		System.err.println("Average_Price : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("InvestAmount(" + a + ")-AvailUnits(" + b + ")=AveragePrice(" + d + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User verify MutualFund Holdings Calculations Tools in {string} Available Units")
	public void user_verify_mutual_fund_holdings_calculations_tools_in_available_units(String string)
			throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//div[text()='" + string
				+ "']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='invest_amount']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("Invest_Amount : " + invest);
		float a = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='average_price']"));
		String value2 = element2.getText();
		String average = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Average_price : " + average);
		float b = Float.parseFloat(average);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath(
				"//div[text()='Navi Flexi Cap Fund Direct Plan Growth']//ancestor::div[@data-dhx-col-id='symbol']//following-sibling::div[@data-dhx-col-id='avail_units']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = a / b;
		String e = String.format("%.3f", value4);
		System.err.println("Avail_Units : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("InvestAmount(" + a + ")-Averageprice(" + b + ")=AvailUnits(" + e + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools {string} Download button")
	public void user_click_the_tools_download_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();

		driver.findElement(By.xpath("//a[text()='" + string + " ']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Menu Tools Options {string}")
	public void user_click_the_menu_tools_options(String string) throws InterruptedException {

		framesHandlingNaviaLogin();

		driver.findElement(By.xpath("//div[@class='invt_menu']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//ancestor::button")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Back To Holding Tools button")
	public void user_click_the_back_to_holding_tools_button() throws InterruptedException {

		framesHandlingNaviaLogin();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=' BACK TO HOLDING']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Verify The Tools Popup")
	public void user_verify_the_tools_popup() throws InterruptedException {

		framesHandlingNaviaLogin();

		WebElement popup = driver.findElement(By.xpath("//div[@class='cntreedem']"));

		if (popup.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User Click The Holding Tools Fund {string}")
	public void user_click_the_holding_tools_fund(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[text()='" + string + "']")).click();

		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User Click The Slider Ranges Tools Options {string}")
	public void user_click_the_slider_ranges_tools_options(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='sliderranges']//child::label[text()='" + string + "']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click Over The Tools Past Duration {string}")
	public void user_click_over_the_tools_past_duration(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='overpost']//child::label[text()='" + string + "']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Mutual Fund schemes {string}")
	public void user_click_the_tools_mutual_fund_schemes(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[@for='" + string + "']")).click();

		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User Click The Tools Adjustment Amount Value {int}")
	public void user_click_the_tools_adjustment_amount_value(Integer int1) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='returnsliderOutput']")).click();
		driver.findElement(By.xpath("//input[@id='returnsliderOutput']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='returnsliderOutput']")).sendKeys("" + int1 + "");

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools SIP Amount {int}")
	public void user_click_the_tools_sip_amount(Integer int1) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@aria-label='SIP Amount (₹)']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='SIP Amount (₹)']")).sendKeys("" + int1 + "");

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Frequency Tools Options {string} button")
	public void user_click_the_frequency_tools_options_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='dhx_input__icon dxi dxi-menu-down']//parent::div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@data-dhx-id='p_type']//child::option[text()='" + string + "']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools {int} SIP Installment")
	public void user_click_the_tools_sip_installment(Integer int1) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@aria-label='SIP Installment']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='SIP Installment']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='SIP Installment']")).sendKeys("" + int1 + "");

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Monthly SIP Date {int}")
	public void user_click_the_tools_monthly_sip_date(Integer int1) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='date_button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='" + int1 + "']//parent::label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click {string} The Tools button")
	public void user_click_the_tools_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//parent::button")).click();

		WebElement element = driver.findElement(By.xpath("//div[@class='crt_popup']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}

		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User Close The Tools Create Mandate")
	public void user_close_the_tools_create_mandate() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Mutual Fund Scheme {string}")
	public void user_click_the_tools_mutual_fund_scheme(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//parent::label")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Amount {int}")
	public void user_click_the_tools_amount(Integer int1) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@data-dhx-id='ot_amt']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-dhx-id='ot_amt']")).sendKeys("" + int1 + "");

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Pay Now button")
	public void user_click_the_tools_pay_now_button() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='start_ot']")).click();

		outOfFrames();
		Thread.sleep(2000);
	}

	@When("User Click The Tools UPI {string} and Pay button")
	public void user_click_the_tools_upi_and_pay_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@data-dhx-id='upi_val']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-dhx-id='upi_val']")).sendKeys("" + string + "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-dhx-id='pay_upi']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Validate The Tools My Total Investments")
	public void user_validate_the_tools_my_total_investments() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//span[@id='invt_grid_currentValue']"));
		String value2 = element2.getText();
		String current = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("CurrentValue : " + current);
		float a = Float.parseFloat(current);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//span[@id='invt_grid_InvestedValue']"));
		String value1 = element1.getText();
		String invest = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("InvestedValue : " + invest);
		float b = Float.parseFloat(invest);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//span[@id='invt_grid_totalReturns']"));
		String value3 = element3.getText();
		String pl = value3.replaceAll("[^0-9.,-]", "");
		float c = Float.parseFloat(pl);

		float value4 = a - b;
		String e = String.format("%.2f", value4);
		System.err.println("TotalReturns : " + e);
		float d = Float.parseFloat(e);

		int integerPartA = (int) c;
		int integerPartB = (int) d;

		boolean areEqual = integerPartA == integerPartB;

		if (areEqual) {

			System.out.println("CurrentValue(" + a + ") - InvestedValue(" + b + ")=Total Returns(" + e + ")");
			System.err.println("verify the Value is displayed");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools {int} Day and {string} Month Start Time")
	public void user_click_the_tools_day_and_month_start_time(Integer int1, String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Start time']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-live='polite']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='" + string + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='" + int1 + "']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools {int} Day and {string} Month End Time")
	public void user_click_the_tools_day_and_month_end_time(Integer int1, String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='End time']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-live='polite']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='" + string + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='" + int1 + "']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Filter Tools Options {string} button")
	public void user_click_the_filter_tools_options_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//parent::div")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Filter Tools Options {string} Radio button")
	public void user_click_the_filter_tools_options_radio_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//ancestor::div[@class='dhx_layout-cell']"))
				.click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User The Tools Enters {string} In The Search Box")
	public void user_the_tools_enters_in_the_search_box(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Basket button")
	public void user_click_the_basket_button() throws InterruptedException {

		Thread.sleep(2000);
		WebElement add1 = driver.findElement(By.xpath("//span[text()='Funds']//parent::div"));

		Actions a = new Actions(driver);
		a.moveToElement(add1).perform();
		Thread.sleep(1000);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		WebElement element = driver.findElement(By.xpath("//h4[text()='Basket']//ancestor::div[@id='basket']"));
		element.click();

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Add Bseket button")
	public void user_click_the_tools_add_bseket_button() throws InterruptedException {

		Thread.sleep(1000);
		framesHandlingNaviaLogin();
		
		WebElement add = driver.findElement(By.xpath("//button[contains(text(),'Add Basket')]"));

		Thread.sleep(1000);
		Actions ac = new Actions(driver);
		 ac.moveToElement(add).perform();
		 add.click();

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

	}

	@When("User Enter The Tools Basket {string} Name")
	public void user_enter_the_tools_basket_name(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);
		String timestamp = new SimpleDateFormat("dd_MM_yyyy_HHmm").format(new Date());
		driver.findElement(By.xpath("//input[@placeholder='Enter basket name']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter basket name']")).sendKeys(string+"-"+timestamp);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Enter The Tools {string} Description")
	public void user_enter_the_tools_description(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[contains(@placeholder,'Enter basket name')])[1]")).click();
		driver.findElement(By.xpath("(//input[contains(@placeholder,'Enter basket name')])[1]")).sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools {string} button and close")
	public void user_click_the_tools_button_and_close(String string) throws InterruptedException {

		

		try {
			
			framesHandlingNaviaLogin();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@value='" + string + "']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'Processed to Add Items')]")).click();
			
			Thread.sleep(2000);

			driver.findElement(By.xpath("(//div[@class='close-pop bg-blue btns-radious'])[2]")).click();

			outOfFrames();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	

	}

	@When("User Click The Tools Tab Options {string} button")
	public void user_click_the_tools_tab_options_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Tab Options Import button")
	public void user_click_the_tools_tab_options_import_button() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='uploadbasket_btn']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Basket Name {string} and Add button")
	public void user_click_the_tools_basket_name_and_add_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//span[text()='" + string + "']//ancestor::div[@class='basket_list']//descendant::span[text()='Add']"))
				.click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Search and Stock {string} Name")
	public void user_click_the_tools_search_and_stock_name(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='search_stocks']//descendant::input[@id='project-id']")).click();
		driver.findElement(By.xpath("//div[@class='search_stocks']//descendant::input[@id='project-id']"))
				.sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Filter Outer {string} Options")
	public void user_click_the_tools_filter_outer_options(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='srh_results act']//descendant::span[text()='" + string + "']"))
				.click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools {string} and {string} Stock")
	public void user_click_the_tools_and_stock(String string, String string2) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		switch (string) {

		case "BSE":
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath(
					"//li[@class='search_item up srh_result srh_results_all srh_results_stocks srh_results_bse']"));

			Actions ac = new Actions(driver);
			ac.moveToElement(element).perform();

			driver.findElement(By.xpath(
					"//li[@class='search_item up srh_result srh_results_all srh_results_stocks srh_results_bse']//descendant::span[@class='s_"
							+ string2 + "']"))
					.click();

			break;

		case "NSE":
			Thread.sleep(2000);
			WebElement element1 = driver.findElement(By.xpath(
					"(//li[@class='search_item up srh_result srh_results_all srh_results_stocks srh_results_nse'])[1]"));

			Actions a = new Actions(driver);
			a.moveToElement(element1).perform();

			driver.findElement(By.xpath(
					"(//li[@class='search_item up srh_result srh_results_all srh_results_stocks srh_results_nse']//descendant::span[@class='s_"
							+ string2 + "'])[1]"))
					.click();

			break;

		default:
			System.err.println("Invalid Your Choice");
			break;
		}

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Top Buy and Sell Options")
	public void user_click_the_tools_top_buy_and_sell_options() throws InterruptedException {

		driver.findElement(By.xpath("//span[@class='switchery switchery-small']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='switchery switchery-small']")).click();
		Thread.sleep(2000);

	}

	@When("User Click The Tools IOC and DAY button")
	public void user_click_the_tools_ioc_and_day_button() throws InterruptedException {

		driver.findElement(By.xpath("//label[text()='IOC']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='DAY']")).click();
		Thread.sleep(2000);

	}

	@When("User Click The Tools {string} button and Verify the Text")
	public void user_click_the_tools_button_and_verify_the_text(String string) throws InterruptedException {

		driver.findElement(By.xpath("//label[text()='" + string + " ']")).click();
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath(
				"//div[text()='Intraday orders would be automatically squared off at any time within 30 minutes of market closing and charges would apply']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("pop up is not displayed");

		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[text()='Delivery / Carry forward ']")).click();
		Thread.sleep(2000);

	}

	@Then("User Click The Tools {string} Value {string} Change")
	public void user_click_the_tools_value_change(String string, String string2)
			throws InterruptedException, AWTException {

		switch (string) {

		case "QTy":

			driver.findElement(By.xpath("(//input[@name='qty'])[1]")).click();
			Thread.sleep(1000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='qty'])[1]")).sendKeys(string2);
			break;

		case "Price":

			driver.findElement(By.xpath("(//input[@name='price'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='price'])[1]")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='price'])[1]")).sendKeys(string2);
			break;

		case "Trigger price":

			driver.findElement(By.xpath("(//input[@name='trigerprice'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='trigerprice'])[1]")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='trigerprice'])[1]")).sendKeys(string2);
			break;

		case "Disclosed qty":

			driver.findElement(By.xpath("(//input[@name='dqty'])[1]")).click();
			Thread.sleep(1000);
			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_BACK_SPACE);
			r1.keyRelease(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='dqty'])[1]")).sendKeys(string2);
			break;

		default:
			System.out.println("Invalid Your Choice");
			break;
		}
	}

	@Then("User Select The Tools {string} Icon")
	public void user_select_the_tools_icon(String string) throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.xpath("//label[text()='" + string + "']")).click();

		Thread.sleep(2000);

	}

	@When("User Click The Tools Charges button")
	public void user_click_the_tools_charges_button() throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div//child::a[@class='margin_click']")).click();
		Thread.sleep(2000);

		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='br_label']"));

		for (WebElement webElement : elements) {

			String text = webElement.getText();
			System.out.println("<<<<<<<<<<<<Charges Details>>>>>>>>>>>>>");
			System.err.println(text);

		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		Thread.sleep(4000);

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);
		int size = li.size();
		System.out.println(size);

		driver.switchTo().window(li.get(0));

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@data-dhx-id='close'])[2]")).click();

	}

	@When("User Click The Tools Market Depth button")
	public void user_click_the_tools_market_depth_button() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Market Depth ']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[text()='Market Depth ']")).click();
		Thread.sleep(2000);
	}

	@When("User Click The Tools ADD Besket button")
	public void user_click_the_tools_add_besket_button() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='form-btns']//descendant::button)[2]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()=' Basket orders ']")).click();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Basket Name {string} and Place Order button")
	public void user_click_the_tools_basket_name_and_place_order_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::button[text()='Place Order']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Place Order Option {string} Price")
	public void user_click_the_tools_place_order_option_price(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[@type='number'])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[5]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[5]")).sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Place Order Option {string} Qty")
	public void user_click_the_tools_place_order_option_qty(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//button[@onclick='plusFunctions(this)'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@onclick='plusFunctions(this)'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@onclick='minusFunctions(this)'])[2]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//input[@type='number'])[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[4]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[4]")).sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Place Order Option {string} button")
	public void user_click_the_tools_place_order_option_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[@name='sl_orders'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='sl_orders'])[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@value='" + string + "']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Select The Tools {string} Option")
	public void user_select_the_tools_option(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		WebElement element = driver
				.findElement(By.xpath("//div[@class='jconfirm-content']//descendant::table/tbody/tr[3]"));
		String text = element.getText();
		System.err.println(text);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();
		Thread.sleep(2000);

		outOfFrames();

		WebElement element2 = driver.findElement(By.xpath("//button[text()=' Add Fund ']"));
		Thread.sleep(2000);
		if (element2.isDisplayed()) {

			driver.findElement(By.xpath("//button[text()=' Add Fund ']")).click();
			Thread.sleep(2000);
			framesHandlingNaviaLogin();
			Thread.sleep(2000);
			WebElement element1 = driver
					.findElement(By.xpath("//div[@class='place_order_popup_in_list']//descendant::li"));
			String text1 = element1.getText();
			System.err.println(text1);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//a[@class='close_btn']")).click();

			outOfFrames();

		} else {

			System.err.println("Fund Is Not Visible Page");

		}

		Thread.sleep(2000);

	}

	@When("User Click The Tools Basket Name {string} and Sip Order button")
	public void user_click_the_tools_basket_name_and_sip_order_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::button[text()='Sip Order']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Select The Tools Frequency Options {string} button")
	public void user_select_the_tools_frequency_options_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//select[@name='frequency']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='" + string + "']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools SIP Installment Options {string} button")
	public void user_click_the_tools_sip_installment_options_button(String string)
			throws InterruptedException, AWTException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@class='installment']")).click();
		Thread.sleep(1000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_BACK_SPACE);
		r1.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='installment']")).sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Weekly SIP Day Options {string} button")
	public void user_click_the_tools_weekly_sip_day_options_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//select[@name='sipday']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='" + string + "']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Select The Tools SIP Date {string} button")
	public void user_select_the_tools_sip_date_button(String string) throws AWTException, InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//select[@name='sipdate']")).click();
		Thread.sleep(1000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_BACK_SPACE);
		r1.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@name='sipdate']")).sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools agree to the SIP button")
	public void user_click_the_tools_agree_to_the_sip_button() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='terms and conditions']")).click();
		Thread.sleep(2000);

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);

		driver.switchTo().window(li.get(0));

		framesHandlingNaviaLogin();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//label[@for='bskt_terms']//child::input[@id='bskt_terms']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Activate SIP button")
	public void user_click_the_tools_activate_sip_button() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@value='Activate SIP']")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[text()='Monthly SIP Order Updated']"));
		String text = element.getText();
		System.err.println(text);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Close']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Basket Name {string} Pause SIP button")
	public void user_click_the_tools_basket_name_pause_sip_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@class='sip_act']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::button[text()='Pause SIP']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools {string} Pause SIP button")
	public void user_click_the_tools_pause_sip_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();

		Thread.sleep(2000);
		if (string == "yes") {

			driver.findElement(By.xpath("//button[text()='Close']")).click();
		}
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[@class='sip_act']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}

		driver.findElement(By.xpath("//button[text()='Close']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Basket Name {string} and Edit button")
	public void user_click_the_tools_basket_name_and_edit_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::span[@class='edit_btn']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Modify The Tools {string} Basket Name")
	public void user_modify_the_tools_basket_name(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='ed_baskt_name']//child::input[@value='AUTO COMPANIES']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ed_baskt_name']//child::input[@value='AUTO COMPANIES']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ed_baskt_name']//child::input[@value='AUTO COMPANIES']"))
				.sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Modify The Tools {string} Basket Description")
	public void user_modify_the_tools_basket_description(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='basket_description']//child::textarea")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='basket_description']//child::textarea")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='basket_description']//child::textarea")).sendKeys(string);

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Apply button in Edit")
	public void user_click_the_tools_apply_button_in_edit() throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@value='Apply']")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[text()='Sucessfully Updated']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");
			System.err.println("Besket Option Edit Mode Sucessfully Updated ");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Close']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Cancel']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Basket Name {string} and Download button")
	public void user_click_the_tools_basket_name_and_download_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::button[@class='bs_download']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools Basket Name {string} and Delete button")
	public void user_click_the_tools_basket_name_and_delete_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::span[@class='rmv_basket']")).click();

		outOfFrames();
		Thread.sleep(2000);

	}

	@When("User Click The Tools {string} Delete button")
	public void user_click_the_tools_delete_button(String string) throws InterruptedException {

		framesHandlingNaviaLogin();
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();

		Thread.sleep(2000);
		if (string == "yes") {

			driver.findElement(By.xpath("//button[text()='Close']")).click();

		}

		outOfFrames();
		Thread.sleep(2000);

	}

	
	
	// =======================================BasKet=========================================

	@When("User MouseOver Dashboard and Click Basket")
	public void user_mouse_over_dashboard_and_click_basket() throws InterruptedException {

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		Actions ac = new Actions(driver);
		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Basket']//ancestor::li")).click();

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		WebElement add = driver.findElement(By.xpath("//button[text()=' Add Basket']"));

		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.moveToElement(add).perform();

		switchToMainFrame();
	}

	@When("User Click The Add Basket button")
	public void user_click_the_add_basket_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		WebElement add = driver.findElement(By.xpath("//button[text()=' Add Basket']"));

		Thread.sleep(1000);
		Actions ac = new Actions(driver);
		// ac.moveToElement(add).perform();
		ac.click(add).perform();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Enter The Basket {string} Name")
	public void user_enter_the_basket_name(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//input[@placeholder='Enter basket name']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter basket name']")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Enter The {string} Description")
	public void user_enter_the_description(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//textarea[@id='t_b_desc']")).click();
		driver.findElement(By.xpath("//textarea[@id='t_b_desc']")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} button and close")
	public void user_click_the_button_and_close(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//input[@value='" + string + "']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Tab Options {string} button")
	public void user_click_the_tab_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Tab Options Import button")
	public void user_click_the_tab_options_import_button() throws InterruptedException, AWTException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//button[@class='uploadbasket_btn']")).click();

		Thread.sleep(5000);
//
//		driver.findElement(By.xpath("(//label[contains(@class,'btn_upload')])[3]")).click();
//		Thread.sleep(2000);
		StringSelection s1 = new StringSelection("C:\\Users\\Kanniappan\\Desktop\\Basket File");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);

		StringSelection s2 = new StringSelection("TESTING-basket.bsk");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s2, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='yes']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='ok']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Basket Name {string} and Add button")
	public void user_click_the_basket_name_and_add_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath(
				"//span[text()='" + string + "']//ancestor::div[@class='basket_list']//descendant::span[text()='Add']"))
				.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Search and Stock {string} Name")
	public void user_click_the_search_and_stock_name(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//div[@class='search_stocks']//descendant::input[@id='project-id']")).click();
		driver.findElement(By.xpath("//div[@class='search_stocks']//descendant::input[@id='project-id']"))
				.sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Filter Outer {string} Options")
	public void user_click_the_filter_outer_options(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//div[@class='srh_results act']//descendant::span[text()='" + string + "']"))
				.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} and {string} Stock")
	public void user_click_the_and_stock(String string, String string2) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		switch (string) {

		case "BSE":
			Thread.sleep(1000);
			WebElement element = driver.findElement(By.xpath(
					"//li[@class='search_item up srh_result srh_results_all srh_results_stocks srh_results_bse']"));

			Actions ac = new Actions(driver);
			ac.moveToElement(element).perform();

			driver.findElement(By.xpath(
					"//li[@class='search_item up srh_result srh_results_all srh_results_stocks srh_results_bse']//descendant::span[@class='s_"
							+ string2 + "']"))
					.click();

			break;

		case "NSE":
			Thread.sleep(1000);
			WebElement element1 = driver.findElement(By.xpath(
					"(//li[@class='search_item up srh_result srh_results_all srh_results_stocks srh_results_nse'])[1]"));

			Actions a = new Actions(driver);
			a.moveToElement(element1).perform();

			driver.findElement(By.xpath(
					"(//li[@class='search_item up srh_result srh_results_all srh_results_stocks srh_results_nse']//descendant::span[@class='s_"
							+ string2 + "'])[1]"))
					.click();

			break;

		default:
			System.err.println("Invalid Your Choice");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Top Buy and Sell Options")
	public void user_click_the_top_buy_and_sell_options() throws InterruptedException {

		driver.findElement(By.xpath("//span[@class='switchery switchery-small']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='switchery switchery-small']")).click();
		Thread.sleep(2000);

	}

	@When("User Click The IOC and DAY button")
	public void user_click_the_ioc_and_day_button() throws InterruptedException {

		driver.findElement(By.xpath("//label[text()='IOC']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='DAY']")).click();
		Thread.sleep(2000);

	}

	@When("User Click The {string} button and Verify the Text")
	public void user_click_the_button_and_verify_the_text(String string) throws InterruptedException {

		driver.findElement(By.xpath("//label[text()='" + string + " ']")).click();
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath(
				"//div[text()='Intraday orders would be automatically squared off at any time within 30 minutes of market closing and charges would apply']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("pop up is not displayed");

		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[text()='Delivery / Carry forward ']")).click();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Value {string} Change")
	public void user_click_the_value_change(String string, String string2) throws InterruptedException, AWTException {

		switch (string) {

		case "QTy":

			driver.findElement(By.xpath("(//input[@name='qty'])[1]")).click();
			Thread.sleep(1000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='qty'])[1]")).sendKeys(string2);
			break;

		case "Price":

			driver.findElement(By.xpath("(//input[@name='price'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='price'])[1]")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='price'])[1]")).sendKeys(string2);
			break;

		case "Trigger price":

			driver.findElement(By.xpath("(//input[@name='trigerprice'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='trigerprice'])[1]")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='trigerprice'])[1]")).sendKeys(string2);
			break;

		case "Disclosed qty":

			driver.findElement(By.xpath("(//input[@name='dqty'])[1]")).click();
			Thread.sleep(1000);
			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_BACK_SPACE);
			r1.keyRelease(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@name='dqty'])[1]")).sendKeys(string2);
			break;

		default:
			System.out.println("Invalid Your Choice");
			break;
		}

	}

	@When("User Select The {string} Icon")
	public void user_select_the_icon(String string) throws InterruptedException {

		driver.findElement(By.xpath("//label[text()='" + string + "']")).click();
		Thread.sleep(2000);

	}

	@When("User Cross Check The Market Depth Value")
	public void user_cross_check_the_market_depth_value() throws InterruptedException {

		WebElement element1 = driver.findElement(By.xpath("(//input[@name='qty'])[1]"));
		@SuppressWarnings("deprecation")
		String value1 = element1.getAttribute("value");
		String current = value1.replaceAll("[^0-9.,-]", "");
		System.err.println("QTY : " + current);
		int a = Integer.parseInt(current); // Convert string to float

		WebElement element2 = driver.findElement(By.xpath("(//input[@name='price'])[1]"));
		@SuppressWarnings("deprecation")
		String value2 = element2.getAttribute("value");
		String invested = value2.replaceAll("[^0-9.,-]", "");
		System.err.println("Price : " + invested);
		float b = Float.parseFloat(invested);

		WebElement element3 = driver.findElement(By.xpath("//span[@id='margin_result']//child::a"));
		String value3 = element3.getText();
		String total = value3.replaceAll("[^0-9.,-]", "");
		int c = Integer.parseInt(total); // Convert string to float

		float d = a * b;
		int roundedValue = Math.round(d);

		System.err.println("Margin : " + roundedValue);

		if (c == roundedValue) {

			System.err.println("Total Returns is Correct");

		} else {

			System.out.println("Total Returns is Not Correct");

		}

		Thread.sleep(2000);

	}

	@When("User Click The Charges button")
	public void user_click_the_charges_button() throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div//child::a[@class='margin_click']")).click();
		Thread.sleep(2000);

		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='br_label']"));

		for (WebElement webElement : elements) {

			String text = webElement.getText();
			System.out.println("<<<<<<<<<<<<Charges Details>>>>>>>>>>>>>");
			System.err.println(text);

		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		Thread.sleep(4000);

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);
		int size = li.size();
		System.out.println(size);

		driver.switchTo().window(li.get(0));

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@data-dhx-id='close'])[2]")).click();

	}

	@When("User Click The ADD Besket button")
	public void user_click_the_add_besket_button() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='form-btns']//descendant::button)[2]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()=' Basket orders ']")).click();
		Thread.sleep(2000);
	}

	@When("User Click The Market Depth button")
	public void user_click_the_market_depth_button() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Market Depth ']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[text()='Market Depth ']")).click();
		Thread.sleep(2000);

	}

	@When("User Click The Basket Name {string} and Place Order button")
	public void user_click_the_basket_name_and_place_order_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::button[text()='Place Order']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Basket Name {string} and Sip Order button")
	public void user_click_the_basket_name_and_sip_order_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::button[text()='Sip Order']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Basket Name {string} and Download button")
	public void user_click_the_basket_name_and_download_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::button[@class='bs_download']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Basket Name {string} and Delete button")
	public void user_click_the_basket_name_and_delete_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::span[@class='rmv_basket']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Place Order Option {string} Price")
	public void user_click_the_place_order_option_price(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("(//input[@type='number'])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[5]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[5]")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Place Order Option {string} Qty")
	public void user_click_the_place_order_option_qty(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("(//button[@onclick='plusFunctions(this)'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@onclick='plusFunctions(this)'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@onclick='minusFunctions(this)'])[2]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//input[@type='number'])[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[4]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[4]")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Edit Option {string} Qty")
	public void user_click_the_edit_option_qty(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("(//button[@onclick='plusFunctions(this)'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@onclick='plusFunctions(this)'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@onclick='minusFunctions(this)'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='strike_in']//child::input[@type='number'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='strike_in']//child::input[@type='number'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='strike_in']//child::input[@type='number'])[1]")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Edit Option {string} Price")
	public void user_click_the_edit_option_price(String string) throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("(//input[@type='number'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[2]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Place Order Option {string} button")
	public void user_click_the_place_order_option_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("(//input[@name='sl_orders'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='sl_orders'])[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@value='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Select The {string} Option")
	public void user_select_the_option(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[@class='place_order_popup_in']//descendant::li"));
		String text = element.getText();
		System.err.println(text);
		
		switchToMainFrame();
		Thread.sleep(2000);
		

		WebElement element2 = driver.findElement(By.xpath("//button[text()=' Add Fund ']"));
		String text2 = element2.getText();

		Thread.sleep(2000);
		if (text2.contains("Add")) {

			driver.findElement(By.xpath("//button[text()=' Add Fund ']")).click();
			Thread.sleep(2000);

		}

		else {


			System.err.println("Not Show in FUND page");
		}
		
//		Thread.sleep(2000);
//		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
//		driver.switchTo().frame(iframe1);
//
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@class='close_btn']")).click();
//		
//		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Select The Frequency Options {string} button")
	public void user_select_the_frequency_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//select[@name='frequency']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The SIP Installment Options {string} button")
	public void user_click_the_sip_installment_options_button(String string) throws InterruptedException, AWTException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//input[@class='installment']")).click();
		Thread.sleep(1000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_BACK_SPACE);
		r1.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='installment']")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Weekly SIP Day Options {string} button")
	public void user_click_the_weekly_sip_day_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//select[@name='sipday']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The agree to the SIP button")
	public void user_click_the_agree_to_the_sip_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//a[text()='terms and conditions']")).click();
		Thread.sleep(2000);

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);

		driver.switchTo().window(li.get(0));

		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe1);
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//label[@for='bskt_terms']//child::input[@id='bskt_terms']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Activate SIP button")
	public void user_click_the_activate_sip_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//input[@value='Activate SIP']")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[text()='Monthly SIP Order Updated']"));
		String text = element.getText();
		System.err.println(text);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Close']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Basket Name {string} Pause SIP button")
	public void user_click_the_basket_name_pause_sip_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@class='sip_act']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::button[text()='Pause SIP']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Pause SIP button")
	public void user_click_the_pause_sip_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();

		switch (string) {
		case "yes":

			driver.findElement(By.xpath("//button[text()='Close']")).click();

			 List<WebElement> elements = driver.findElements(By.xpath("//span[text()='TEST']//ancestor::div[@class='basket_list']//descendant::div[@class='sip_act']"));

			 for (WebElement webElement : elements) {
				 
				 String text = webElement.getText();
				 System.err.println(text);
				
			}
			Thread.sleep(2000);
			break;
			
		case "No":
			
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			break;
			
		default:

			System.out.println("Invalid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Place Order Option delete")
	public void user_click_the_place_order_option_delete() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//span[@class='rmv_items']//child::img")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Place Order")
	public void user_click_the_place_order(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//select[@class='cnc_mis']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Select The SIP Date {string} button")
	public void user_select_the_sip_date_button(String string) throws InterruptedException, AWTException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//select[@name='sipdate']")).click();
		Thread.sleep(1000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_BACK_SPACE);
		r1.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@name='sipdate']")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Delete button")
	public void user_click_the_delete_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();

		Thread.sleep(2000);
		switch (string) {
		case "yes":

			driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

			break;

		default:

			System.out.println("Invalid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Basket Name {string} and Edit button")
	public void user_click_the_basket_name_and_edit_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::span[@class='edit_btn']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Modify The {string} Basket Name")
	public void user_modify_the_basket_name(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//div[@class='ed_baskt_name']//child::input[@value='AUTO COMPANIES']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ed_baskt_name']//child::input[@value='AUTO COMPANIES']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ed_baskt_name']//child::input[@value='AUTO COMPANIES']"))
				.sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Modify The {string} Basket Description")
	public void user_modify_the_basket_description(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//div[@class='basket_description']//child::textarea")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='basket_description']//child::textarea")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='basket_description']//child::textarea")).sendKeys(string);

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Apply button in Edit")
	public void user_click_the_apply_button_in_edit() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//input[@value='Apply']")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[text()='Sucessfully Updated']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");
			System.err.println("Besket Option Edit Mode Sucessfully Updated ");

			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[text()='Close']")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@value='Cancel']")).click();

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Options To Place Order button")
	public void user_click_the_options_to_place_order_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_items']//descendant::button[text()='Place Order']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Options To Sip Order button")
	public void user_click_the_options_to_sip_order_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_items']//descendant::button[text()='Sip Order']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Options To Download button")
	public void user_click_the_options_to_download_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath(
				"//span[text()='Top100-500']//ancestor::div[@class='basket_items']//descendant::button[@class='bs_download']"))
				.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Place Order {string} Stock All Options")
	public void user_click_the_place_order_stock_all_options(String string) throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='" + string
				+ "']//ancestor::li[@class='d_flex']//descendant::button[@class='plus_btn'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='" + string
				+ "']//ancestor::li[@class='d_flex']//descendant::button[@class='plus_btn'])[2]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='" + string
				+ "']//ancestor::li[@class='d_flex']//descendant::button[@class='minus_btn'])[2]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"(//span[text()='" + string + "']//ancestor::li[@class='d_flex']//descendant::input[@class='qty'])[2]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"(//span[text()='" + string + "']//ancestor::li[@class='d_flex']//descendant::input[@class='qty'])[2]"))
				.clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"(//span[text()='" + string + "']//ancestor::li[@class='d_flex']//descendant::input[@class='qty'])[2]"))
				.sendKeys("17");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[text()='" + string
				+ "']//ancestor::li[@class='d_flex']//descendant::input[@type='number'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='" + string
				+ "']//ancestor::li[@class='d_flex']//descendant::input[@type='number'])[4]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='" + string
				+ "']//ancestor::li[@class='d_flex']//descendant::input[@type='number'])[4]")).sendKeys("100");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[text()='" + string
				+ "']//ancestor::li[@class='d_flex']//descendant::input[@name='sl_orders'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='" + string
				+ "']//ancestor::li[@class='d_flex']//descendant::input[@name='sl_orders'])[2]")).click();

		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Select The Place Orde button")
	public void user_select_the_place_orde_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//input[@value='Place Orders']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Select The {string} Place Order button")
	public void user_select_the_place_order_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		WebElement element = driver.findElement(By.xpath("//table[@class='edit_order_window']"));

		if (element.isDisplayed()) {

			List<WebElement> elements = driver
					.findElements(By.xpath("//div[@class='jconfirm-content']//descendant::table/tbody/tr"));
			for (WebElement row : elements) {

				String text = row.getText();
				System.err.println(text);

			}

		}

		else {
			System.out.println("Not Visiable In Stocks Page");

		}

		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();
		Thread.sleep(2000);

		if (string == "yes") {

			WebElement element1 = driver.findElement(By.xpath("//div[@class='place_order_popup_in']//descendant::ul"));
			String text = element1.getText();
			System.err.println(text);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()=' Close']")).click();

		} else {

			System.out.println("User Not Selected In Yes Options");

		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Default Basket Name {string} Pause SIP button")
	public void user_click_the_default_basket_name_pause_sip_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@class='sip_act']"));

		if (element.isDisplayed()) {

			System.err.println("verify the pop up is displayed");

		}

		else {
			System.out.println("verify the pop up is not displayed");

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_list']//descendant::button[text()='Pause SIP']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	// =========================================Strategy
	// Builder==============================================

	@When("User MouseOver Dashboard and Click Strategy Builder")
	public void user_mouse_over_dashboard_and_click_strategy_builder() throws InterruptedException {

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		Actions ac = new Actions(driver);
		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Strategy Builder']//ancestor::li")).click();

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		WebElement add = driver.findElement(By.xpath("//span[@class='ready_mode_close']"));

		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.moveToElement(add).perform();

		switchToMainFrame();

	}

	@When("User Select Ready-made strategy Options {string} button")
	public void user_select_ready_made_strategy_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='" + string + "']//parent::li")).click();

		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Select Bullish Options {string} button")
	public void user_select_bullish_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='bPnzRP']//descendant::div[text()='" + string + "']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}
	
	@When("User Select Others Options {string} button")
	public void user_select_others_options_button(String string) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class, 'jyZMZN')]//descendant::div[contains(text(), '"+string+"')]")).click();

		switchToMainFrame();
		Thread.sleep(2000);

		
	}

	@When("User Select Bearish Options {string} button")
	public void user_select_bearish_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//div[@class='style__PresetStrategyCardsWrap-sc-1f57s5d-7 bPnzRP'])[1]//div[text()='"
						+ string + "']"))
				.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Select Neutral Options {string} button")
	public void user_select_neutral_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"(//div[@class='style__PresetStrategyCardsWrap-sc-1f57s5d-7 bPnzRP'])[2]//descendant::div[text()='"
						+ string + "']"))
				.click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Select the Chart adjustment {int} and {int}")
	public void user_select_the_chart_adjustment_and(Integer int1, Integer int2) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='chart_parameters_left']//descendant::button[@class='plus_btn1']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='chart_parameters_left']//descendant::button[@class='plus_btn1']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='chart_parameters_left']//descendant::button[@class='minus_btn1']"))
				.click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(
				By.xpath("//div[@class='chart_parameters_left']//descendant::input[@class='slider border-0']"));

		Actions a = new Actions(driver);

		// a.dragAndDrop(element1, element2).perform();
		a.dragAndDropBy(element, int1, int2).perform();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Select the Date adjustment {int} and {int}")
	public void user_select_the_date_adjustment_and(Integer int1, Integer int2) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		driver.findElement(By
				.xpath("//div[@class='chart_parameters_right']//descendant::button[@class='btn btn-default increase']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By
				.xpath("//div[@class='chart_parameters_right']//descendant::button[@class='btn btn-default increase']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By
				.xpath("//div[@class='chart_parameters_right']//descendant::button[@class='btn btn-default decrease']"))
				.click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(
				By.xpath("//div[@class='chart_parameters_right']//descendant::input[@class='slider border-0']"));

		Actions a = new Actions(driver);

		// a.dragAndDrop(element1, element2).perform();
		a.dragAndDropBy(element, int1, int2).perform();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The New Strategy Options intra\\/delivery")
	public void user_click_the_new_strategy_options_intra_delivery() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='trade_switch']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='trade_switch']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The New Strategy Options {string} Save Strategy")
	public void user_click_the_new_strategy_options_save_strategy(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Random random = new Random();

		long randomEpochMilli = random.nextLong();

		LocalDateTime randomDateTime = Instant.ofEpochMilli(randomEpochMilli).atZone(ZoneId.systemDefault())
				.toLocalDateTime();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = randomDateTime.format(formatter);

		System.err.println("Random Date Time: " + string + formattedDateTime);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Save Strategy']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='stratagy_name']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='stratagy_name']")).clear();
		Thread.sleep(1000);
		WebElement strategyName = driver.findElement(By.xpath("//input[@id='stratagy_name']"));
		strategyName.sendKeys(string + formattedDateTime);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Save']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='ok']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Ready-made button")
	public void user_click_the_ready_made_button() throws InterruptedException, AWTException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Ready made']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();

//		driver.findElement(By.xpath("//a[text()='User Strategy']//parent::li")).click();
//		
//		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='l_items']//descendant::span[@class='SVGInline jss2001']//following-sibling::div"));
//		
//		for (WebElement webElement : elements) {
//			
//			String text = webElement.getText();
//			System.err.println("User Strategy Name :" +text);
//			
//			if(text.isEmpty()) {
//			
//				Thread.sleep(5000);
//				driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
//			
//			}
//		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Buy\\/Sell Options {string} button")
	public void user_click_the_buy_sell_options_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);

		switch (string) {

		case "All":

			driver.findElement(By.xpath("//input[@class='check_all']//parent::th")).click();
			break;

		case "Buy":

			driver.findElement(
					By.xpath("//tr[contains(@class, 'BUY ')]//descendant::input[@type='checkbox']//parent::td"))
					.click();
			break;

		case "Buy_first":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::input[@type='checkbox']//parent::td)[1]"))
					.click();

			break;

		case "Buy_second":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::input[@type='checkbox']//parent::td)[2]"))
					.click();

			break;

		case "Sell":

			driver.findElement(
					By.xpath("//tr[contains(@class, 'SELL ')]//descendant::input[@type='checkbox']//parent::td"))
					.click();
			break;

		case "Sell_first":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::input[@type='checkbox']//parent::td)[1]"))
					.click();
			break;

		case "Sell_second":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::input[@type='checkbox']//parent::td)[2]"))
					.click();
			break;

		default:
			System.out.println("Inavlid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Strike Option {string} button")
	public void user_click_the_strike_option_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string) {

		case "Buy":

			driver.findElement(By.xpath("//tr[contains(@class, 'BUY ')]//descendant::button[@class='plus_btn']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tr[contains(@class, 'BUY ')]//descendant::button[@class='plus_btn']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tr[contains(@class, 'BUY ')]//descendant::button[@class='minus_btn']"))
					.click();
			break;

		case "Buy_first":

			driver.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button[@class='plus_btn'])[1]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button[@class='plus_btn'])[1]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button[@class='minus_btn'])[1]"))
					.click();
			break;

		case "Buy_second":

			driver.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button[@class='plus_btn'])[2]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button[@class='plus_btn'])[2]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button[@class='minus_btn'])[2]"))
					.click();
			break;

		case "Sell":

			driver.findElement(By.xpath("//tr[contains(@class, 'SELL ')]//descendant::button[@class='plus_btn']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tr[contains(@class, 'SELL ')]//descendant::button[@class='plus_btn']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tr[contains(@class, 'SELL ')]//descendant::button[@class='minus_btn']"))
					.click();
			break;

		case "Sell_first":

			driver.findElement(By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button[@class='plus_btn'])[1]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button[@class='plus_btn'])[1]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button[@class='plus_btn'])[1]"))
					.click();
			break;

		case "Sell_second":

			driver.findElement(By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button[@class='plus_btn'])[2]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button[@class='plus_btn'])[2]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button[@class='plus_btn'])[2]"))
					.click();
			break;

		default:
			System.out.println("Inavlid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Select The {string} Lots Size Option {string}")
	public void user_select_the_lots_size_option(String string, String string2) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string) {


		case "Buy":

			Thread.sleep(2000);
			WebElement table = driver
					.findElement(By.xpath("//tr[contains(@class, 'BUY ')]//descendant::select[@class='str_lot']"));
			table.click();
			Thread.sleep(2000);

			Select s = new Select(table);
			s.selectByVisibleText(string2);

			break;

		case "Buy_first":

			Thread.sleep(2000);
			WebElement table1 = driver
					.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::select[@class='str_lot'])[1]"));
			table1.click();
			Thread.sleep(2000);

			Select s1 = new Select(table1);
			s1.selectByVisibleText(string2);

			break;

		case "Buy_second":

			Thread.sleep(2000);
			WebElement table2 = driver
					.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::select[@class='str_lot'])[2]"));
			table2.click();
			Thread.sleep(2000);

			Select s2 = new Select(table2);
			s2.selectByVisibleText(string2);

			break;
			
		case "Sell":

			Thread.sleep(2000);
			WebElement element = driver
					.findElement(By.xpath("//tr[contains(@class, 'SELL ')]//descendant::select[@class='str_lot']"));
			element.click();
			Thread.sleep(2000);

			Select a = new Select(element);
			a.selectByVisibleText(string2);
			break;

		case "Sell_first":

			Thread.sleep(2000);
			WebElement element3 = driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::select[@class='str_lot'])[1]"));
			element3.click();
			Thread.sleep(2000);

			Select a3 = new Select(element3);
			a3.selectByVisibleText(string2);
			break;

		case "Sell_second":

			Thread.sleep(2000);
			WebElement element4 = driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::select[@class='str_lot'])[2]"));
			element4.click();
			Thread.sleep(2000);

			Select a4 = new Select(element4);
			a4.selectByVisibleText(string2);
			break;

		default:
			System.out.println("Inavlid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Select The {string} Price Value Option {string}")
	public void user_select_the_price_value_option(String string, String string2) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string) {

		case "Buy":

			driver.findElement(By.xpath("//tr[contains(@class, 'BUY ')]//descendant::input[@class='t_strpremium']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tr[contains(@class, 'BUY ')]//descendant::input[@class='t_strpremium']"))
					.clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tr[contains(@class, 'BUY ')]//descendant::input[@class='t_strpremium']"))
					.sendKeys(string2);
			break;

		case "Buy_first":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::input[@class='t_strpremium'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::input[@class='t_strpremium'])[1]")).clear();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::input[@class='t_strpremium'])[1]"))
					.sendKeys(string2);
			break;

		case "Buy_second":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::input[@class='t_strpremium'])[2]")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::input[@class='t_strpremium'])[2]")).clear();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::input[@class='t_strpremium'])[2]"))
					.sendKeys(string2);
			break;

		case "Sell":

			driver.findElement(By.xpath("//tr[contains(@class, 'SELL ')]//descendant::input[@class='t_strpremium']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tr[contains(@class, 'SELL ')]//descendant::input[@class='t_strpremium']"))
					.clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tr[contains(@class, 'SELL ')]//descendant::input[@class='t_strpremium']"))
					.sendKeys(string2);
			break;

		case "Sell_first":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::input[@class='t_strpremium'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::input[@class='t_strpremium'])[1]")).clear();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::input[@class='t_strpremium'])[1]"))
					.sendKeys(string2);
			break;

		case "Sell_second":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::input[@class='t_strpremium'])[2]")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::input[@class='t_strpremium'])[2]")).clear();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::input[@class='t_strpremium'])[2]"))
					.sendKeys(string2);
			break;

		default:
			System.out.println("Inavlid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} New Basket Create {string} and Adding")
	public void user_click_the_new_basket_create_and_adding(String string, String string2) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string) {

		case "Buy":

			driver.findElement(By.xpath("//tr[contains(@class, 'BUY ')]//descendant::button[@class='add_basket_btn']"))
					.click();
			Thread.sleep(1000);

			break;

		case "Buy_first":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button[@class='add_basket_btn'])[1]"))
					.click();
			Thread.sleep(1000);

			break;

		case "Buy_second":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button[@class='add_basket_btn'])[2]"))
					.click();
			Thread.sleep(1000);

			break;

		case "Sell":

			driver.findElement(By.xpath("//tr[contains(@class, 'SELL ')]//descendant::button[@class='add_basket_btn']"))
					.click();
			Thread.sleep(1000);

			break;

		case "Sell_first":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button[@class='add_basket_btn'])[1]"))
					.click();
			Thread.sleep(1000);

			break;

		case "Sell_second":

			driver.findElement(
					By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button[@class='add_basket_btn'])[2]"))
					.click();
			Thread.sleep(1000);

			break;

		default:
			System.out.println("Inavlid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@data-dhx-id='form_button_bst_create']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@data-dhx-id='new_basket']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-dhx-id='new_basket']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-dhx-id='new_basket']")).sendKeys(string2);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='form_button_bst_addlist']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Thread.sleep(1000);

	}

	@When("User Select The {string} Basket Name and Delete {string} Basket")
	public void user_select_the_basket_name_and_delete_basket(String string, String string2)
			throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='" + string + "']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='yes']")).click();
		Thread.sleep(1000);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		Actions ac = new Actions(driver);
		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Basket']//ancestor::li")).click();

		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe1);

		WebElement add = driver.findElement(By.xpath("//button[text()=' Add Basket']"));

		Thread.sleep(4000);
		Actions a = new Actions(driver);
		a.moveToElement(add).perform();
		switchToMainFrame();

		WebElement iframe2 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe2);

		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='" + string2
				+ "']//ancestor::div[@class='basket_list']//descendant::span[@class='rmv_basket']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='yes']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Delete Option button")
	public void user_click_the_delete_option_button(String string) throws InterruptedException, AWTException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string) {

		case "Buy":

			WebElement table = driver.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button)[5]"));
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", table);
			driver.findElement(By.xpath("(//tr[contains(@class, 'BUY ')]//descendant::button)[5]")).click();

			break;

		case "Buy_first":

			WebElement table1 = driver.findElement(By.xpath("((//tr[contains(@class, 'BUY ')])[1]//descendant::button)[5]"));
			Thread.sleep(1000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();", table1);
			driver.findElement(By.xpath("((//tr[contains(@class, 'BUY ')])[1]//descendant::button)[5]")).click();

			break;

		case "Buy_second":

			WebElement table2 = driver.findElement(By.xpath("((//tr[contains(@class, 'BUY ')])[1]//descendant::button)[5]"));
			Thread.sleep(1000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].scrollIntoView();", table2);
			driver.findElement(By.xpath("((//tr[contains(@class, 'BUY ')])[1]//descendant::button)[5]")).click();

			break;

		case "Sell":

			WebElement element = driver
					.findElement(By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button)[5]"));
			Thread.sleep(1000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView();", element);
			driver.findElement(By.xpath("(//tr[contains(@class, 'SELL ')]//descendant::button)[5]")).click();

			break;

		case "Sell_first":

			WebElement table3 = driver.findElement(By.xpath("((//tr[contains(@class, 'SELL ')])[1]//descendant::button)[5]"));
			Thread.sleep(1000);
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].scrollIntoView();", table3);
			driver.findElement(By.xpath("((//tr[contains(@class, 'SELL ')])[1]//descendant::button)[5]")).click();

			break;
		case "Sell_second":

			WebElement table4 = driver.findElement(By.xpath("((//tr[contains(@class, 'SELL ')])[1]//descendant::button)[5]"));
			Thread.sleep(1000);
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("arguments[0].scrollIntoView();", table4);
			driver.findElement(By.xpath("((//tr[contains(@class, 'SELL ')])[1]//descendant::button)[5]")).click();

			break;

		default:
			System.out.println("Inavlid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Place Order Icon button")
	public void user_click_the_place_order_icon_button() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Place Order']")).click();

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Place Order Option {string} Icon button")
	public void user_click_the_place_order_option_icon_button(String string) throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string) {

		case "Yes":

			List<WebElement> elements = driver
					.findElements(By.xpath("//div[@class='jconfirm-content']//descendant::li"));

			for (WebElement t : elements) {

				String text = t.getText();
				System.err.println(text);
			}

			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[text()='yes']")).click();
			Thread.sleep(1000);

			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='ok']")).click();
			Thread.sleep(1000);
			break;

		case "No":

			driver.findElement(By.xpath("//button[text()='no']")).click();
			Thread.sleep(1000);

			break;

		default:
			System.out.println("Invalid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Save Strategy All Datas To Print")
	public void user_click_the_save_strategy_all_datas_to_print() throws InterruptedException, AWTException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[@aria-labelledby='ui-id-5']//descendant::div[@class='l_items'])[1]")).click();
		Thread.sleep(1000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@aria-labelledby='ui-id-5']//descendant::span[@class='SVGInline jss2001']//following-sibling::div"));
		
		for (WebElement data : elements) {
			
			
			String text = data.getText();
			System.out.println(text);
			Thread.sleep(1000);

			
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			
			js.executeScript("arguments[0].scrollIntoView(true);", data);
			
		}
		
		Thread.sleep(3000);
		
		
		switchToMainFrame();
		Thread.sleep(2000);
		
	}
	
	@When("User Click The User Strategy Option {string} To Delete")
	public void user_click_the_user_strategy_option_to_delete(String string) throws InterruptedException {
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[text()='"+string+"']//ancestor::div[@class='l_items']//child::span[@class='us_rmv']"));
		
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The User Strategy Option {string} To Select and Close")
	public void user_click_the_user_strategy_option_to_select_and_close(String string) throws InterruptedException {
	   
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='l_items']//descendant::div[text()='"+string+"']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
		Thread.sleep(1000);
		
		switchToMainFrame();
		Thread.sleep(2000);
		
	}
	
	@When("User Select The Strike Filters {string} Options")
	public void user_select_the_strike_filters_options(String string) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//select[@id='opt_fur']"));
		element.click();
		Thread.sleep(1000);
		
		Select s=new Select(element);
		s.selectByVisibleText(string);
		
		Thread.sleep(1000);
		
		switchToMainFrame();
		Thread.sleep(2000);
		
	}
	
	@When("User Select The Strike Filters Expiry Option {string}")
	public void user_select_the_strike_filters_expiry_option(String string) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//select[@id='selexp']"));
		//element.click();
		Thread.sleep(1000);
		
		Select s=new Select(element);
		s.selectByValue(string);
		
		Thread.sleep(1000);
		
		switchToMainFrame();
		Thread.sleep(2000);
		
	}
	
	
	@When("User Click The Buy\\/Sell {string} Options {string} To Put")
	public void user_click_the_buy_sell_options_to_put(String string, String string2) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string2) {

		case "Buy":

			WebElement table = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='B'])[1]"));
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", table);
			WebElement buy = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='B'])[1]"));

			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", buy);
			break;

		case "Depth":

			WebElement table1 = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//following-sibling::span[@class='str_depth put_depth'])[1]"));
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();", table1);
			WebElement depth = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//following-sibling::span[@class='str_depth put_depth'])[1]"));

			Thread.sleep(1000);
			js1.executeScript("arguments[0].click();", depth);
			
			
			break;

		case "Chart":

			WebElement table2 = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//following-sibling::span[@class='str_chart put_chart'])[1]"));
			Thread.sleep(1000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].scrollIntoView();", table2);
			WebElement chart = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//following-sibling::span[@class='str_chart put_chart'])[1]"));

			Thread.sleep(1000);
			js2.executeScript("arguments[0].click();", chart);
			
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
			break;

		case "Sell":

			WebElement element = driver
					.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='S'])[1]"));
			Thread.sleep(1000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView();", element);
			WebElement sell = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='S'])[1]"));

			Thread.sleep(1000);
			j.executeScript("arguments[0].click();", sell);
			
			break;

		case "Add":

			WebElement table3 = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//following-sibling::span[@class='str_more put_more'])[1]"));
			Thread.sleep(1000);
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].scrollIntoView();", table3);
			WebElement add = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//following-sibling::span[@class='str_more put_more'])[1]"));

			Thread.sleep(1000);
			js3.executeScript("arguments[0].click();", add);
			Thread.sleep(1000);
			
			break;
		

		default:
			System.out.println("Inavlid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);
		
	}

	@When("User To Add The Script and Verify The Popup")
	public void user_to_add_the_script_and_verify_the_popup() throws InterruptedException {
	  
		WebElement element2 = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));
		Thread.sleep(1000);
		String text = element2.getText();
		Thread.sleep(1000);
		System.err.println(text);
		
	}
	@When("User Click The Buy\\/Sell {string} Options {string} To Call")
	public void user_click_the_buy_sell_options_to_call(String string, String string2) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string2) {

		case "Buy":

			WebElement table = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='B'])[1]"));
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", table);
			WebElement buy = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='B'])[1]"));

			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", buy);
			break;

		case "Depth":

			WebElement table1 = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//following-sibling::span[@class='str_depth call_depth'])[1]"));
			Thread.sleep(1000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();", table1);
			WebElement depth =driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//following-sibling::span[@class='str_depth call_depth'])[1]"));

			Thread.sleep(1000);
			js1.executeScript("arguments[0].click();", depth);
			
			
			break;

		case "Chart":

			WebElement table2 = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//following-sibling::span[@class='str_chart call_chart'])[1]"));
			Thread.sleep(1000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].scrollIntoView();", table2);
			WebElement chart = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//following-sibling::span[@class='str_chart call_chart'])[1]"));

			Thread.sleep(1000);
			js2.executeScript("arguments[0].click();", chart);
			
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
			break;

		case "Sell":

			WebElement element = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='S'])[1]"));
			Thread.sleep(1000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView();", element);
			WebElement sell = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='S'])[1]"));

			Thread.sleep(1000);
			j.executeScript("arguments[0].click();", sell);
			
			break;

		case "Add":

			WebElement table3 = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@class='str_more call_more'])[1]"));
			Thread.sleep(1000);
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].scrollIntoView();", table3);
			WebElement add = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@class='str_more call_more'])[1]"));

			Thread.sleep(1000);
			js3.executeScript("arguments[0].click();", add);
			Thread.sleep(1000);
			
			break;
		

		default:
			System.out.println("Inavlid");
			break;
		}

		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Select The Close button")
	public void user_select_the_close_button() throws InterruptedException {
	   
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
		
		Thread.sleep(2000);

	}

	@When("User Select The Tab In Options {string} button")
	public void user_select_the_tab_in_options_button(String string) throws InterruptedException {
	   
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//button[text()='"+string+"']")).click();
		
		switchToMainFrame();
		Thread.sleep(2000);
		
	}

	@When("User Click The LTP {string} Options {string} To Call")
	public void user_click_the_ltp_options_to_call(String string, String string2) throws InterruptedException {
	   
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string2) {

		case "Buy":

			WebElement table = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='B'])[2]"));
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", table);
			WebElement buy = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='B'])[2]"));

			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", buy);
			break;

		case "Sell":

			WebElement element = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='S'])[2]"));
			Thread.sleep(1000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView();", element);
			WebElement sell = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='S'])[2]"));

			Thread.sleep(1000);
			j.executeScript("arguments[0].click();", sell);
			
			break;

		default:
			System.out.println("Inavlid");
			break;
		}
		
		Thread.sleep(2000);
		
		WebElement element2 = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span)[8]"));
		Thread.sleep(1000);
		String text = element2.getText();
		Thread.sleep(1000);
		System.err.println("LTP Value Is: "+text);

		switchToMainFrame();
		Thread.sleep(2000);
		
		
	}
	@When("User Click The LTP {string} Options {string} To Put")
	public void user_click_the_ltp_options_to_put(String string, String string2) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string2) {

		case "Buy":

			WebElement table = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='B'])[2]"));
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", table);
			WebElement buy = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='B'])[2]"));

			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", buy);
			
			
			break;

		case "Sell":

			WebElement element = driver
					.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='S'])[2]"));
			Thread.sleep(1000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView();", element);
			WebElement sell = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='S'])[2]"));

			Thread.sleep(1000);
			j.executeScript("arguments[0].click();", sell);
			
			break;

		default:
			System.out.println("Inavlid");
			break;
		}
		
        Thread.sleep(2000);
		
		WebElement element2 = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span)[12]"));
		Thread.sleep(1000);
		String text = element2.getText();
		Thread.sleep(1000);
		System.err.println("LTP Value Is: "+text);

		switchToMainFrame();
		Thread.sleep(2000);
		
	}

	@When("User Click The OI {string} Options {string} To Call")
	public void user_click_the_oi_options_to_call(String string, String string2) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string2) {

		case "Buy":

			WebElement table = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='B'])[3]"));
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", table);
			WebElement buy = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='B'])[3]"));

			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", buy);
			break;

		case "Sell":

			WebElement element = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='S'])[3]"));
			Thread.sleep(1000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView();", element);
			WebElement sell = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span[@data-trade='S'])[3]"));

			Thread.sleep(1000);
			j.executeScript("arguments[0].click();", sell);
			
			break;

		default:
			System.out.println("Inavlid");
			break;
		}
		
        Thread.sleep(2000);
		
		WebElement element2 = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div[contains(@class,'CALL')]//child::span)[15]"));
		Thread.sleep(1000);
		String text = element2.getText();
		Thread.sleep(1000);
		System.err.println("LTP Value Is: "+text);

		switchToMainFrame();
		Thread.sleep(2000);
		
	}
	@When("User Click The OI {string} Options {string} To Put")
	public void user_click_the_oi_options_to_put(String string, String string2) throws InterruptedException {
	    
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string2) {

		case "Buy":

			WebElement table = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='B'])[3]"));
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", table);
			WebElement buy = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='B'])[3]"));

			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", buy);
			break;

		case "Sell":

			WebElement element = driver
					.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='S'])[3]"));
			Thread.sleep(1000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView();", element);
			WebElement sell = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span[@data-trade='S'])[3]"));

			Thread.sleep(1000);
			j.executeScript("arguments[0].click();", sell);
			
			break;

		default:
			System.out.println("Inavlid");
			break;
		}

        Thread.sleep(2000);
		
		WebElement element2 = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div[contains(@class,'PUT')]//child::span)[19]"));
		Thread.sleep(1000);
		String text = element2.getText();
		Thread.sleep(1000);
		System.err.println("LTP Value Is: "+text);
		
		switchToMainFrame();
		Thread.sleep(2000);
		
	}

	@Then("User Select The {string} Option Chain")
	public void user_select_the_option_chain(String string) throws InterruptedException {
	   
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//select[@id='symbols_list']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//option[@data-value='"+string+"']")).click();
		
		driver.findElement(By.xpath("//select[@id='symbols_list']")).click();
		Thread.sleep(1000);
		
		switchToMainFrame();
		Thread.sleep(2000);
		
	}

	@When("User Click The Greeks {string} Options {string} To Value Print")
	public void user_click_the_greeks_options_to_value_print(String string, String string2) throws InterruptedException {
	   
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);

		switch (string2) {

		case "Call delta":

			WebElement table = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div)[4]"));
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", table);
			Thread.sleep(1000);
			WebElement buy = driver.findElement(By.xpath("(//div[text()='"+string+"']//preceding-sibling::div)[4]"));

			Thread.sleep(1000);
			String text = buy.getText();
			Thread.sleep(1000);
			System.err.println("Call Delta Value Is: "+text);
			break;

		case "Strike":

			WebElement element = driver
					.findElement(By.xpath("(//div[text()='"+string+"'])[4]"));
			Thread.sleep(1000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(1000);
			WebElement sell = driver.findElement(By.xpath("(//div[text()='"+string+"'])[4]"));

			Thread.sleep(1000);
			String text1 = sell.getText();
			Thread.sleep(1000);
			System.err.println("Strike Value Is: "+text1);
			break;
			
		case "IV":

			WebElement element1 = driver
					.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[6]"));
			Thread.sleep(1000);
			JavascriptExecutor j1 = (JavascriptExecutor) driver;
			j1.executeScript("arguments[0].scrollIntoView();", element1);
			Thread.sleep(1000);
			WebElement IV = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[6]"));

			Thread.sleep(1000);
			String test1 = IV.getText();
			Thread.sleep(1000);
			System.err.println("IV Value Is: "+test1);
			break;	
			
		case "Put Delta":

			WebElement element2 = driver
					.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[7]"));
			Thread.sleep(1000);
			JavascriptExecutor j2 = (JavascriptExecutor) driver;
			j2.executeScript("arguments[0].scrollIntoView();", element2);
			Thread.sleep(1000);
			WebElement putDelta = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[7]"));

			Thread.sleep(1000);
			String test2 = putDelta.getText();
			Thread.sleep(1000);
			System.err.println("Put Delta Value Is: "+test2);
			break;	
			
		case "Vega":

			WebElement element3 = driver
					.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[8]"));
			Thread.sleep(1000);
			JavascriptExecutor j3 = (JavascriptExecutor) driver;
			j3.executeScript("arguments[0].scrollIntoView();", element3);
			Thread.sleep(1000);
			WebElement vega = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[8]"));

			Thread.sleep(1000);
			String test3 = vega.getText();
			Thread.sleep(1000);
			System.err.println("Vega Value Is: "+test3);
			break;	
			
		case "Theta":

			WebElement element4 = driver
					.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[9]"));
			Thread.sleep(1000);
			JavascriptExecutor j4 = (JavascriptExecutor) driver;
			j4.executeScript("arguments[0].scrollIntoView();", element4);
			Thread.sleep(1000);
			WebElement theta = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[9]"));

			Thread.sleep(1000);
			String test4 = theta.getText();
			Thread.sleep(1000);
			System.err.println("Theta Value Is: "+test4);
			break;	
			
		case "Gamma":

			WebElement element5 = driver
					.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[10]"));
			Thread.sleep(1000);
			JavascriptExecutor j5 = (JavascriptExecutor) driver;
			j5.executeScript("arguments[0].scrollIntoView();", element5);
			Thread.sleep(1000);
			WebElement gamma = driver.findElement(By.xpath("(//div[text()='"+string+"']//following-sibling::div)[10]"));

			Thread.sleep(1000);
			String test5 = gamma.getText();
			Thread.sleep(1000);
			System.err.println("Gamma Value Is: "+test5);
			break;	

		default:
			System.out.println("Inavlid");
			break;
		}
		
		switchToMainFrame();
		Thread.sleep(2000);
		
		
	}


	@When("User Select The {string} Stock and Naviagate to Analysis page")
	public void user_select_the_stock_and_naviagate_to_analysis_page(String string) throws InterruptedException {
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement analysis = driver.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::span[text()='NSE'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", analysis);
		
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::span[text()='NSE'])[1]")).click();
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("(//button[@class='analysis_btn md_btn1'])[1]")).click();
	    
		Thread.sleep(1000);
	}









	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
