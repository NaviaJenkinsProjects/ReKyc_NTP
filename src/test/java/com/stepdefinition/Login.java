package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;
import com.google.common.io.Files;
import com.pom.Login_Navia_POM;

import atu.testrecorder.ATUTestRecorder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseClass {

	public static ATUTestRecorder recorder;

	Login_Navia_POM l = new Login_Navia_POM(driver);
	Actions ac = new Actions(driver);
	static Set<String> windowHandles = driver.getWindowHandles();
	static ArrayList<String> li = new ArrayList<String>(windowHandles);

	
	
	@When("User Click the Watch List")
	public void user_click_the_watch_list() throws InterruptedException {
		Thread.sleep(4000);
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		 try {
			
			 WebElement element = driver
						.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
				Thread.sleep(1000);
				Actions f=new Actions(driver);
				f.moveToElement(element).perform();
				Thread.sleep(1000);
				f.click(element).perform();
				
		} catch (Exception e) {
			
			driver.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"))
			.click();
		}
		
		Thread.sleep(1000);
		
	}

	@When("User Select scrip {string}")
	public void user_select_scrip(String string) throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='select-box active']//descendant::li//span[text()='"+string+"']"))
				.click();
		System.out.println(string);
		Thread.sleep(4000);
	}

	@When("User Click Watch List Again")
	public void user_click_watch_list_again() throws InterruptedException {
		WebElement element1 = driver
				.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
		element1.click();

		Thread.sleep(2000);
	}

	@When("User mouse over the scrip {string}")
	public void user_mouse_over_the_scrip(String string) throws InterruptedException {
		
		Thread.sleep(2000);Thread.sleep(2000);
		WebElement contractSelectAgain = driver.findElement(
				By.xpath("//div[@class='select-box active']//descendant::li//span[text()='" + string + "']"));

		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		ac.moveToElement(contractSelectAgain).perform();
		
		driver.findElement(By.xpath("(//span[@data-symbol='"+string+"'])[2]")).click();

		Thread.sleep(2000);
		
	}

	@When("User Click the Charts")
	public void user_click_the_charts() throws InterruptedException {
		Thread.sleep(2000);
		WebElement charts = driver.findElement(By.xpath(
				"//div[@class='select-box active']//descendant::span[text()='NIFTY 50']//ancestor::li//descendant::img"));
		charts.click();

		Thread.sleep(3000);
	}
	
	@When("User Click the {string} Charts")
	public void user_click_the_charts(String string) throws InterruptedException {
	    
		Thread.sleep(2000);
		WebElement charts = driver.findElement(By.xpath(
				"//div[@class='select-box active']//descendant::span[text()='Nifty 50']//ancestor::li//descendant::span[@class='ind_chart_btn']"));
		charts.click();

		Thread.sleep(3000);
		
	}

	@When("User Click the Candles Icon")
	public void user_click_the_candles_icon() throws InterruptedException {
		WebElement firstiFrame = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));

		driver.switchTo().frame(iframe);

		Thread.sleep(3000);

		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@title='Financial Chart']"));

		driver.switchTo().frame(iframe1);

		driver.findElement(By.xpath("//div[@id='header-toolbar-chart-styles']")).click();
		Thread.sleep(3000);
	}

	@When("User Choose Candle {string}")
	public void user_choose_candle(String string) throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-value='" + string + "']")).click();
		Thread.sleep(2000);
	}

	@When("User Click the Mintues")
	public void user_click_the_mintues() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();
		Thread.sleep(2000);

	}

	@When("User Choose One Minute")
	public void user_choose_one_minute() {
		driver.findElement(By.xpath("//div[text()='1 minute']//ancestor::div[@data-value='1']")).click();

	}

	@When("Verify One Minute Feed Connection Value and Wait One Minute Very Feed Connection Changes")
	public void verify_one_minute_feed_connection_value_and_wait_one_minute_very_feed_connection_changes()
			throws InterruptedException {
		WebElement element3 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		Thread.sleep(4000);
		String text2 = element3.getText();
		System.err.println("Feed Connection Value of One Minute : " + text2);

		Thread.sleep(60000);

		System.out.println("Feed Connection Value of After One Minute : " + text2);

	}

	@When("User Click the Five Minute")
	public void user_click_the_five_minute() {
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='5 minutes']//ancestor::div[@data-value='5']")).click();

	}

	@When("Verify Five Minute Feed Connection Valuebb")
	public void verify_five_minute_feed_connection_value() throws InterruptedException {
		WebElement element2 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		Thread.sleep(4000);
		String text = element2.getText();
		System.err.println("Feed Connection Value of Five Minutes : " + text);

	}

	@When("User Click One Day")
	public void user_click_one_day() {
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 day']//ancestor::div[@data-value='1D']")).click();

	}

	@When("Verify One Day Feed Connection Value and Wait One Minute Very Feed Connection Changes")
	public void verify_one_day_feed_connection_value_and_wait_one_minute_very_feed_connection_changes()
			throws InterruptedException {

		WebElement element4 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		Thread.sleep(4000);
		String text3 = element4.getText();
		System.err.println("Feed Connection Value of 1 hour : " + text3);
		Thread.sleep(60000);

		System.err.println("Feed Connection Value of 1 hour and 1 mins: " + text3);

	}

	@When("User click the search box")
	public void user_click_the_search_box() throws InterruptedException {
		Thread.sleep(4000);

		 driver.findElement(By.xpath("//input[@id='project-id']")).click();
		Thread.sleep(3000);
	}

	@When("User Search any {string} Script")
	public void user_search_any_script(String string) throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
	}

	@When("User Mouse Over and Add a Script {string}")
	public void user_mouse_over_and_add_a_script(String string) throws InterruptedException {
		Thread.sleep(3000);

		// //tagname[contains(text(), 'value')]
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//ancestor::li"));

		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(7000);

		driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]//ancestor::li//descendant::span[@class='s_add_sym']")).click();
	}

	
	@When("User POP Up Message Appear Verify POP UP")
	public void user_pop_up_message_appear_verify_pop_up() throws InterruptedException {

//		WebElement popUp = driver.findElement(By.xpath("//span[text()='Symbol Has been Added Successfully']"));
//
//		if (popUp.isDisplayed()) {
//
//			System.out.println("Verify Pop is Displayed Successfully");
//		} else {
//			System.out.println("Verify Pop is Not Displayed ");
//
//		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Clear']")).click();

	}

	@When("User Mouse over the {string} Script and Click")
	public void user_mouse_over_the_first_script_and_click(String string) throws InterruptedException {
		Thread.sleep(3000);

		WebElement script = driver.findElement(By.xpath("(//ul[@class='list ui-sortable'])[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(script).perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//ul[@class='list ui-sortable']//descendant::span)[15]")).click();

	}

	@When("User Delete the Script")
	public void user_delete_the_script() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//lable[text()='Delete']//parent::button")).click();
	}

	@When("User Verify Script Deleted SuccesFully")
	public void user_verify_script_deleted_succes_fully() {

		WebElement recordDelete = driver.findElement(By.xpath("//span[text()='Record Deleted Successfully']"));

		if (recordDelete.isDisplayed()) {
			System.out.println("Verify Pop is Displayed Script Deleted");

		} else {

		}
		System.out.println("Verify Script is Not Deleted");

	}

	@When("User mouse the scrip Selected {string}")
	public void user_mouse_the_scrip_selected(String string) throws InterruptedException {
		
		Thread.sleep(4000);

		WebElement element2 = driver.findElement(By.xpath("(//span[text()='" + string + "'])[1]"));
		ac.moveToElement(element2).perform();
		Thread.sleep(2000);
	}

	@When("User Click the Buy scrip for Selected {string} Scrip")
	public void user_click_the_buy_scrip_for_selected_scrip(String string) throws InterruptedException {
		WebElement buyScript = driver.findElement(By.xpath(
				"//span[text()='" + string + "']//ancestor::div[@class='m_bg_color']//descendant::span[text()='B']"));
		buyScript.click();
		Thread.sleep(2000);
	}

	@When("User Click Market then Limit")
	public void user_click_market_then_limit() throws InterruptedException {

		WebElement chooseMarket = driver.findElement(By.xpath("//label[text()='Market']"));
		chooseMarket.click();
		Thread.sleep(2000);

	}

	@When("User Enter Amount in Price Text Box {string}")
	public void user_enter_amount_in_price_text_box(String string) throws InterruptedException {

//		WebElement value = driver.findElement(By.xpath(
//				"//span[contains(text(),'Margin')]//child::a"));
//		String text21 = value.getText();
//		System.out.println(text21);
//		String text2 = text21.replaceAll("[^0-9.]", "");
//		// Convert the string to a floating-point number
//		//double value1 = Double.parseDouble(text2);
//		String roundedStr = String.format("%.2f", text2);
//		System.out.println("Rounded String: " + roundedStr);
//		// Subtract 5 from the value
//		//value1 -= 5;
//		//double valuue2=value1-2;
//		// Convert the result back to a string
//		//String result = Double.toString(valuue2);
//		Thread.sleep(2000);
//		WebElement clearPrice = driver.findElement(
//				By.xpath("//label[text()='Price']//parent::div[@class='tag-box']//descendant::input[@type='number']"));
//		clearPrice.clear();
//		Thread.sleep(2000);
//		clearPrice.sendKeys("238");
//		Thread.sleep(2000);
	}

	@When("User Click Buy")
	public void user_click_buy() throws InterruptedException {
		Thread.sleep(2000);

		WebElement clickBuy = driver.findElement(By.xpath("//button[text()='BUY']"));
		clickBuy.click();
	}

	@When("User Click Yes Popup")
	public void user_click_yes_popup() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'yes')]"));
		element.click();

		Thread.sleep(2000);

	}

	@When("Verify the Buy Scrip Notification Pop up")
	public void verify_the_buy_scrip_notification_pop_up() {
		try {
			
			WebElement buyPopup = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));
			if (buyPopup.isDisplayed()) {
				System.err.println("Verify the buyPop is Displayed SuccessFully");
			} else {
				System.err.println("Verify the buyPop is Not Displayed ");

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@When("User Click Pending Orders")
	public void user_click_pending_orders() throws InterruptedException {
		Thread.sleep(4000);

		driver.findElement(By.xpath("//span[text()='Pending Orders']//parent::a")).click();
		Thread.sleep(2000);
	}

	@When("User Click Edit Icon for Selected Scrip {string}")
	public void user_click_edit_icon_for_selected_scrip(String string) throws InterruptedException {
		WebElement editScript = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//parent::div[@role='button']//descendant::span[@class='cntx_menu order_context']"));
		editScript.click();
		Thread.sleep(2000);
	}

	@When("User Click Modify")
	public void user_click_modify() {
		driver.findElement(By.xpath("//span[text()='Modify']//ancestor::button")).click();

	}

	@When("User Modify Quality")
	public void user_modify_quality() throws InterruptedException {
		WebElement qty = driver.findElement(By.xpath("//label[text()='Qty']//following-sibling::input"));
		Actions ac = new Actions(driver);
		ac.moveToElement(qty).perform();
		Thread.sleep(2000);

		qty.clear();
		Thread.sleep(2000);

		qty.sendKeys("2");
	}

	@When("User Modify Price")
	public void user_modify_price() throws InterruptedException {
		WebElement price = driver.findElement(By.xpath("//label[text()='Price']//following-sibling::input"));
		price.clear();
		price.sendKeys("513.20");

		Thread.sleep(2000);

	}

	@When("User Click Update")
	public void user_click_update() {
		WebElement update = driver.findElement(By.xpath("//button[text()='Update']"));
		update.click();
	}

	@When("User Click Yes in Pop up")
	public void user_click_yes_in_pop_up() throws InterruptedException {
		Thread.sleep(2000);

		WebElement updateYes = driver.findElement(By.xpath("//button[text()='yes']"));
		updateYes.click();
	}

	@When("Verify the Modify Notification popup")
	public void verify_the_modify_notification_popup() {
		WebElement updatePopup = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));

		if (updatePopup.isDisplayed()) {
			System.out.println("Verify the Updated SuccessFully");
		} else {
			System.out.println("Verify the is not updated");

		}
	}

	@When("User Click Pending Order")
	public void user_click_pending_order() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Pending Orders']//parent::a")).click();
		Thread.sleep(2000);
	}

	@When("User Click Selected Scrip {string} Edit")
	public void user_click_selected_scrip_edit(String string) throws InterruptedException {
		WebElement editScript = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//parent::div[@role='button']//descendant::span[@class='cntx_menu order_context']"));
		editScript.click();
		Thread.sleep(2000);
	}

	@When("User Click Cancel")
	public void user_click_cancel() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Cancel']//ancestor::button[@type='button']")).click();
		Thread.sleep(2000);
	}

	@When("User Click Yes for Confirmation")
	public void user_click_yes_for_confirmation() {
		driver.findElement(By.xpath("//button[text()='yes']")).click();

	}

	@When("User Verify the Cancellation Notification Popup")
	public void user_verify_the_cancellation_notification_popup() throws Exception {
		WebElement deletedScriptPopup = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));

		if (deletedScriptPopup.isDisplayed()) {
			System.out.println("Verify Script Deleted Successfully");
		} else {
			System.out.println("Verify Script is Not Deleted");

		}

	}

	@When("User Click Holdings")
	public void user_click_holdings() throws InterruptedException {

		Thread.sleep(4000);

		driver.findElement(By.xpath("(//span[text()='Holdings']//parent::a)[1]")).click();
		Thread.sleep(2000);
	}


	

	@When("User Search {string} in Searchbox")
	public void user_search_in_searchbox(String string) throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='project-id']")).click();
		
		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
		Thread.sleep(3000);
	}

	@When("User Click Futures")
	public void user_click_futures() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		
		Robot robot=new Robot();
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		try {
			
			driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
			
		} catch (Exception e) {
			
			driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
			
		}

		
		Thread.sleep(3000);

	}

	@When("User mouse over {string} and click add icon")
	public void user_mouse_over_and_click_add_icon(String string) throws InterruptedException {
		Thread.sleep(3000);

		WebElement element = driver
				.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//parent::div//child::span[@class='symbolsseries'])[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("(//span[contains(text(),'"+string+"')]//ancestor::li//descendant::span[@class='s_add_sym'])[1]"))
				.click();

	}

	@When("Symbol Has been Added Successfully Notification Shown")
	public void symbol_has_been_added_successfully_notification_shown() {

//		WebElement notification = driver.findElement(By.xpath("//span[text()='Symbol Has been Added Successfully']"));
//	
//		WebElement alreadyAdded = driver.findElement(By.xpath("//span[text()='Token already exist']"));
//		if (notification.isDisplayed()) {
//			System.out.println("Verify Scrip Added Successfully");
//		} 
//
//		else {
//			System.out.println("error");
//		}

		System.out.println("hello");
	}

	@When("User Click Clear in search box")
	public void user_click_clear_in_search_box() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Clear']")).click();
	}

	@When("User Click {string}")
	public void user_click(String string) throws InterruptedException {

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//following-sibling::span[contains(text(),'NFO')])[1]"))
				.click();

	}

	@When("User Click F&O")
	public void user_click_f_o() throws InterruptedException {
		Thread.sleep(2000);
		
		
		try {
			
			driver.findElement(By.xpath("//button[@class='s_more md_btn1']")).click();
			
		} catch (Exception e) {
			WebElement element = driver.findElement(By.xpath("//button[@class='s_more md_btn1']"));
			element.click();
		}

		
	}

	@When("User Click Cancel button in Ready Made Pop up")
	public void user_click_cancel_button_in_ready_made_pop_up() throws InterruptedException {

		Thread.sleep(5000);

		
//		WebElement element = driver.findElement(By.xpath("(//span[text()='x'])[1]"));
//		driver.switchTo().frame(0);
//		
//		if (condition) {
//			
//		} else {
//
//		}

		
	}

	@When("User Click LTP")
	public void user_click_ltp() throws InterruptedException {
		Thread.sleep(2000);
		
		WebElement element2 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		
		driver.switchTo().frame(element2);
		Actions d=new Actions(driver);

		WebElement element = driver.findElement(By.xpath("(//button[text()='LTP'])[1]"));
		Thread.sleep(2000);
		d.moveToElement(element).perform();
		d.click(element).perform();
		Thread.sleep(2000);
	}

	@When("User Verify the Fluctuating")
	public void user_verify_the_fluctuating() throws InterruptedException {

		WebElement callLTP = driver.findElement(
				By.xpath("(//div[@class='ops_ltp_item get_attr_data act_left act_right']//descendant::span)[1]"));
		String text = callLTP.getText();
		System.out.println("Call LTP Value :" + text);

		Thread.sleep(5000);

		WebElement callLTP1 = driver.findElement(
				By.xpath("(//div[@class='ops_ltp_item get_attr_data act_left act_right']//descendant::span)[1]"));
		String text1 = callLTP1.getText();
		System.out.println("Call LTP Value After 5 Second:" + text1);

		if (text.equalsIgnoreCase(text1)) {
			System.out.println("Verified Lpt Call LTP Values is not fluctuating");
		} else {
			System.out.println("Verified Lpt Call LTP Values is fluctuating");

		}
		///////////////////////////////

		WebElement putLTP = driver.findElement(
				By.xpath("(//div[@class='ops_ltp_item get_attr_data act_left act_right']//descendant::span)[12]"));
		String text2 = putLTP.getText();
		System.out.println("Call LTP Value :" + text2);

		Thread.sleep(5000);

		WebElement putLTP1 = driver.findElement(
				By.xpath("(//div[@class='ops_ltp_item get_attr_data act_left act_right']//descendant::span)[12]"));
		String text3 = putLTP1.getText();
		System.out.println("Put LTP Value After 5 Second:" + text3);

		if (text2.equalsIgnoreCase(text3)) {
			System.out.println("Put Lpt LTP Values is not fluctuating");
		} else {
			System.out.println("Put Lpt LTP Values is fluctuating");

		}

	}

	@When("User Click Add Money")
	public void user_click_add_money() throws InterruptedException {
		Thread.sleep(2000);

		try {
			
			Actions d=new Actions(driver);
			WebElement element = driver.findElement(By.xpath("//button[@data-dhx-id='btn_addmoney']"));
			Thread.sleep(1000);
			d.moveToElement(element).perform();
			Thread.sleep(1000);
			d.doubleClick(element).perform();

			
		} catch (Exception e) {
			Thread.sleep(1000);
			WebElement element = driver.findElement(By.xpath("//button[@data-dhx-id='btn_addmoney']//child::span"));
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("arguments[0].click();", element);

		}
		
		

		Thread.sleep(2000);
		
	}

	@When("User enter money in amount to add")
	public void user_enter_money_in_amount_to_add() throws InterruptedException {
		Thread.sleep(2000);

//		driver.switchTo().defaultContent();
//		
		WebElement addMoneyFrame = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(addMoneyFrame);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).click();
		Thread.sleep(1000);
		WebElement enterAmount = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		enterAmount.clear();
		Thread.sleep(1000);

		enterAmount.sendKeys("10");

		Thread.sleep(1000);
		
		try {
			
			WebElement element = driver.findElement(By.xpath("//span[@class='form-error erspan is-visible']"));
			
			if (element.isDisplayed()) {
				
				
				
				System.out.println("Add Funds Is Working");
				Thread.sleep(1000);
				//WebElement enterAmount = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
				enterAmount.clear();
				Thread.sleep(1000);

				enterAmount.sendKeys("50");
				
			}
			
			else {
				
				
				System.err.println("Not Showing The Amount should be greater than 50 rupees");
				
			}
			
		} catch (Exception e) {
			
			WebElement element = driver.findElement(By.xpath("//span[@class='form-error erspan is-visible']"));
			String text = element.getText();
			System.out.println(text);
		}
		

		driver.findElement(By.xpath("//input[@id='deposit_amount']")).click();
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
	}

	@When("User Choose Pay Using UPI")
	public void user_choose_pay_using_upi() throws InterruptedException {
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		driver.switchTo().window(li1.get(1));

		driver.navigate().refresh();

		driver.navigate().refresh();

		driver.navigate().refresh();

		driver.navigate().refresh();

		driver.navigate().refresh();

		Thread.sleep(5000);

	}

	@When("User Enter UPI\\/ID\\/Mobile Number and click pay now")
	public void user_enter_upi_id_mobile_number_and_click_pay_now() throws InterruptedException, AWTException {
		

		//Robot robot = new Robot();

		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, -500)");

//		WebElement netBanking = driver.findElement(By.xpath("//p[text()='Enter Any UPI ID']"));
//
//		netBanking.click();
//		Thread.sleep(1000);
//
//		WebElement UPI = driver.findElement(By.xpath("//input[@placeholder='Enter UPI ID']"));
//		UPI.click();
//		UPI.sendKeys("6374837965@ptsbi");
//		Thread.sleep(1000);
//
//		WebElement clickPayUsingUPI = driver.findElement(By.xpath("//button[text()='Apply']"));
//		clickPayUsingUPI.click();
//
//		Thread.sleep(3000);
//
//		
//		WebElement clickPayUsingUPI1 = driver.findElement(By.xpath("//span[text()='PROCEED']//parent::button"));
//		clickPayUsingUPI1.click();
//		
//		Thread.sleep(7000);
//		
//		
//		WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofMinutes(30));
//		WebElement rejectedMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='CHECK PAYMENT STATUS']")));
//	//	WebElement rejectedMessage = driver.findElement(By.xpath("//div[text()='Payment could not be completed']"));
//
//		if (rejectedMessage.isDisplayed()) {
//			js.executeScript("arguments[0].style.border='2px solid yellow'", rejectedMessage);
//			System.err.println("Payment Declined");
//
//		}
//
//		else {
//			js.executeScript("arguments[0].style.border='2px solid red'", rejectedMessage);
//			System.err.println("Payment SuccessFul");
//		}
		
		driver.switchTo().frame(0);
	
		Thread.sleep(1000);

		WebElement UPI = driver.findElement(By.xpath("//input[@placeholder='example@okhdfcbank']"));

		UPI.sendKeys("6374837965");
		Thread.sleep(1000);

		WebElement clickPayUsingUPI = driver.findElement(By.xpath("//button[text()='Verify and Pay']"));
		clickPayUsingUPI.click();

		Thread.sleep(3000);

		
		WebElement clickPayUsingUPI1 = driver.findElement(By.xpath("//button[text()='Cancel Payment']"));
		clickPayUsingUPI1.click();
		
		WebElement clickPayUsingUPI11 = driver.findElement(By.xpath("//button[@data-testid='confirm-positive']"));
		clickPayUsingUPI11.click();
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofMinutes(1));
		WebElement rejectedMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Payment could not be completed']")));
	//	WebElement rejectedMessage = driver.findElement(By.xpath("//div[text()='Payment could not be completed']"));

		if (rejectedMessage.isDisplayed()) {
			js.executeScript("arguments[0].style.border='2px solid yellow'", rejectedMessage);
			System.err.println("Payment Declined");

		}

		else {
			js.executeScript("arguments[0].style.border='2px solid red'", rejectedMessage);
			System.err.println("Payment SuccessFul");
		}

		driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();
		
		
		

		
		driver.close();
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);

		driver.switchTo().window(li1.get(0));
		//driver.switchTo().parentFrame();

		//driver.switchTo().defaultContent();

	}

	@When("User Click Position")
	public void user_click_position() throws InterruptedException {
		WebElement position = driver.findElement(By.xpath("//span[text()='Position']//parent::a"));
		position.click();

		Thread.sleep(2000);
	}

	@When("Verify Product {string} Inv.Value {double} LTP Multiply into Net Qty is Equal to M2M Value")
	public void verify_product_inv_value_ltp_multiply_into_net_qty_is_equal_to_m2m_value(String string, Double double1)
			throws InterruptedException {

		WebElement ltpElement = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@role='row']//descendant::div[@data-dhx-col-id='LTP']//descendant::span"));
		String LTP = ltpElement.getText();

		System.out.println(LTP);

		WebElement invElement = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@role='row']//descendant::div[@data-dhx-col-id='InvValue']//descendant::span"));
		String invPrice = invElement.getText();

		System.out.println(invPrice);

		WebElement qtyElement = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@role='row']//descendant::div[@data-dhx-col-id='NetQty']"));
		String qty = qtyElement.getText();

		System.out.println(qty);

		WebElement m2mElement = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@role='row']//descendant::div[@data-dhx-col-id='M2M']//descendant::span"));
		String m2m = m2mElement.getText();

		System.out.println(m2m);

		Thread.sleep(2000);

		LTP = LTP.replace(",", "");
		invPrice = invPrice.replace(",", "");

		// Remove the currency symbol from m2m and convert it to a numeric value
		double m2mValue = Double.parseDouble(m2m.replace("₹", "").trim());

		// Convert string values to numerical values
		double ltpValue = Double.parseDouble(LTP);
		double invPriceValue = Double.parseDouble(invPrice);
		int qtyValue = Integer.parseInt(qty);

		// Calculate M2M using the formula: LTP - Cost Price * Quantity
		double calculatedM2M = invPriceValue - ltpValue * (qtyValue);

		System.out.println(m2mValue);
		System.out.println(calculatedM2M);

		String strM2mValue = String.valueOf(m2mValue);
		String strCalculatedM2M = String.valueOf(calculatedM2M);

		if (strM2mValue.equals(strCalculatedM2M)) {
			System.err.println("Verify Inv Value :" + invPrice + " - " + "LTP Value :" + LTP + " * "
					+ "Net Qty Value : " + qty + " = :" + strCalculatedM2M + " Equal to = M2M " + strM2mValue);
		} else {

			System.err.println("Verify Inv Value :" + invPrice + " - " + "LTP Value :" + LTP + " * "
					+ "Net Qty Value : " + qty + " = :" + strCalculatedM2M + " Equal to = M2M " + strM2mValue);

		}
	}

	@When("Verify Product {string} Cost Price Value {double} LTP Multiply into Net Qty is Equal to M2M Value")
	public void verify_product_cost_price_value_ltp_multiply_into_net_qty_is_equal_to_m2m_value(String string,
			Double double1) throws InterruptedException {
		WebElement ltpElement = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@role='row']//descendant::div[@data-dhx-col-id='LTP']//descendant::span"));
		String LTP = ltpElement.getText();

		System.out.println(LTP);

		WebElement costPriceElement = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@role='row']//descendant::div[@data-dhx-col-id='Costprice']//descendant::span"));
		String costPrice = costPriceElement.getText();

		System.out.println(costPrice);

		WebElement qtyElement = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@role='row']//descendant::div[@data-dhx-col-id='NetQty']"));
		String qty = qtyElement.getText();

		System.out.println(qty);

		WebElement m2mElement = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@role='row']//descendant::div[@data-dhx-col-id='M2M']//descendant::span"));
		String m2m = m2mElement.getText();

		System.out.println(m2m);

		Thread.sleep(2000);

		LTP = LTP.replace(",", "");
		costPrice = costPrice.replace(",", "");

		// Remove the currency symbol from m2m and convert it to a numeric value
		double m2mValue = Double.parseDouble(m2m.replace("₹", "").trim());

		// Convert string values to numerical values
		double ltpValue = Double.parseDouble(LTP);
		double costPriceValue = Double.parseDouble(costPrice);
		int qtyValue = Integer.parseInt(qty);

		// Calculate M2M using the formula: LTP - Cost Price * Quantity
		double calculatedM2M = costPriceValue - ltpValue * (qtyValue);

		System.out.println(m2mValue);
		System.out.println(calculatedM2M);

		String strM2mValue = String.valueOf(m2mValue);
		String strCalculatedM2M = String.valueOf(calculatedM2M);

		if (strM2mValue.equals(strCalculatedM2M)) {
			System.err.println("Verify Costprice Value :" + costPrice + " - " + "LTP Value :" + LTP + " * "
					+ "Net Qty Value : " + qty + " = :" + strCalculatedM2M + " Equal to = M2M " + strM2mValue);
		} else {

			System.err.println("Verify Costprice Value :" + costPrice + " - " + "LTP Value :" + LTP + " * "
					+ "Net Qty Value : " + qty + " = :" + strCalculatedM2M + " Equal to = M2M " + strM2mValue);

		}
	}

	@When("Click Plus Symbol")
	public void click_plus_symbol() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@id='add_mw_btn']")).click();

	}

	@When("User Enter new MarketWatch Name {string}")
	public void user_enter_new_market_watch_name(String string) throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='new_mw_name']")).sendKeys(string);
	}

	@When("Click Create Button")
	public void click_create_button() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='Create']//parent::button")).click();
	}

	@When("Right Click {string} Particular MarketWatch")
	public void right_click_particular_market_watch(String string) throws InterruptedException {
		Thread.sleep(1000);

		WebElement particularElement = driver.findElement(By.xpath("//span[text()='" + string + "']//parent::button"));
		ac.contextClick(particularElement).perform();

		Thread.sleep(1000);

	}

	@When("Click Rename")
	public void click_rename() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Rename']//ancestor::button")).click();
		Thread.sleep(1000);

	}

	@When("User Enter Marketwatch rename {string}")
	public void user_enter_marketwatch_rename(String string) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='new_mw_name']")).sendKeys(string);
		Thread.sleep(1000);

	}

	@When("Click Click Save")
	public void click_click_save() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Save']//ancestor::button")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='yes']")).click();
	}

	@When("User Right Click {string} Particular MarketWatch")
	public void user_right_click_particular_market_watch(String string) throws InterruptedException {
		Thread.sleep(1000);

		WebElement particularElement = driver.findElement(By.xpath("//span[text()='" + string + "']//parent::button"));
		ac.contextClick(particularElement).perform();

		Thread.sleep(1000);

	}

	@When("User Click Delete")
	public void user_click_delete() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Delete']//ancestor::button")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='yes']")).click();
	}

	@When("User MouseOver Dashboard and Click Tools")
	public void user_mouse_over_dashboard_and_click_tools() throws InterruptedException {

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);
		
		try {
			
			driver.findElement(By.xpath("//label[text()='Tools']//ancestor::li")).click();
			
		} catch (Exception e) {
			
			WebElement element = driver.findElement(By.xpath("//label[text()='Tools']//ancestor::li"));
			element.click();
			
		}

		Thread.sleep(2000);

	}

	@When("User Click Basket")
	public void user_click_basket() throws InterruptedException {

		Thread.sleep(2000);
		driver.switchTo().frame("analysis");
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@class='menu_item']//descendant::h4[text()='Buy Back']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		
		Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[@class='menu_item']//descendant::h4[text()='Basket'])[2]")).click();
				
				framesHandlingNaviaLogin();
				Thread.sleep(1000);

				WebElement add = driver.findElement(By.xpath("//button[text()=' Add Basket']"));

				Thread.sleep(1000);
				// ac.moveToElement(add).perform();
				ac.click(add).perform();

				outOfFrames();
				Thread.sleep(2000);
		
	}

	@When("User Select Basket {string} Place Order")
	public void user_select_basket_place_order(String string) throws AWTException, InterruptedException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);

		driver.switchTo().frame(0);
		Thread.sleep(2000);

		Thread.sleep(2000);

		WebElement everGreenPlaceOrder = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_items']//descendant::button[@class='place_order']"));
		everGreenPlaceOrder.click();
	}

	@When("User Choose {string} Qty for {string} and {string} amount for {string}")
	public void user_choose_qty_for_and_amount_for(String string, String string2, String string3, String string4)
			throws InterruptedException {
		Thread.sleep(1000);

		WebElement gOLDBEES = driver.findElement(By.xpath("(//span[text()='" + string2
				+ "']//ancestor::div[@class='b_top_flex']//descendant::input[@class='qty'])[2]"));
		gOLDBEES.clear();
		gOLDBEES.sendKeys(string);
		Thread.sleep(1000);

		WebElement gOLDBEESValue = driver.findElement(By.xpath("(//span[text()='" + string4
				+ "']//ancestor::div[@class='b_top_flex']//descendant::input[@class='qty'])[2]"));
		gOLDBEESValue.clear();
		gOLDBEESValue.sendKeys(string3);
		Thread.sleep(1000);
	}

	@When("Again User Choose {string} Qty for {string} and {string} amount for {string}")
	public void again_user_choose_qty_for_and_amount_for(String string, String string2, String string3, String string4)
			throws InterruptedException {
		WebElement nIFTYBEES = driver.findElement(By.xpath("(//span[text()='" + string2
				+ "']//ancestor::div[@class='b_top_flex']//descendant::input[@class='qty'])[2]"));
		nIFTYBEES.clear();
		nIFTYBEES.sendKeys(string);
		Thread.sleep(1000);

		WebElement nIFTYBEESValue = driver.findElement(By.xpath("(//span[text()='" + string4
				+ "']//ancestor::div[@class='b_top_flex']//descendant::input[@type='number'])[4]"));
		nIFTYBEESValue.clear();
		nIFTYBEESValue.sendKeys(string3);
	}

	@When("Place Order")
	public void place_order() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@value='Place Orders']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='yes']")).click();

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		WebElement insufficientFund = driver.findElement(By.xpath("//div[@id='nofund_popup']//descendant::h5"));

		if (insufficientFund.isDisplayed()) {
			System.out.println("InsufficientFund is Displayed");
		} else {
			System.out.println("Successful added");
		}
	}

	@When("User add basket")
	public void user_add_basket() throws InterruptedException {
		Thread.sleep(2000);

		driver.switchTo().frame(0);

		WebElement myBasket = driver.findElement(By.xpath("//button[text()='My Baskets']"));
		myBasket.click();
	}

	@When("Enter Basketname {string}, description {string} and click add")
	public void enter_basketname_description_and_click_add(String string, String string2) throws InterruptedException {
		WebElement addBasket = driver.findElement(By.xpath("//button[text()=' Add Basket']"));
		addBasket.click();
		Thread.sleep(1000);

		WebElement basketName = driver.findElement(By.xpath("//input[@placeholder='Enter basket name']"));
		basketName.sendKeys(string);

		WebElement basketDescription = driver.findElement(By.xpath("(//textarea[@placeholder='Description'])[1]"));
		basketDescription.sendKeys(string2);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='add_b_name']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[text()='Close']")).click();

		driver.switchTo().defaultContent();

	}

	@When("User Navigate to Dashboard")
	public void user_navigate_to_dashboard() throws InterruptedException {
		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		ac.moveToElement(dashBoard).perform();

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]")).click();

		WebElement close = driver.findElement(By.xpath("//span[text()='Clear']"));

		ac.moveToElement(close).perform();

		close.click();

		Thread.sleep(1000);

	}

	@When("User Select Qty {string}")
	public void user_select_qty(String string) {
		driver.findElement(By.xpath("//input[@id='order_qty']")).sendKeys(string);

	}

	@When("User Click Basket Icon")
	public void user_click_basket_icon() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='btn-bskt add_basket']")).click();
	}

	@When("User Choose Basket {string}")
	public void user_choose_basket(String string) throws InterruptedException {

		Thread.sleep(5000);
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,500);");
	       
	       js.executeScript("window.scrollBy(0,500);");

		Actions d=new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//span[@class='basket_name']//ancestor::div[@class='basket_box'])[1]"));
        d.moveToElement(element).perform();
		Thread.sleep(1000);

		d.click(element).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='yes']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[text()='Close']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

	}

	@When("User Navigate to Basket and Click My Baskets")
	public void user_navigate_to_basket_and_click_my_baskets() throws InterruptedException {
		
		
		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		ac.moveToElement(dashBoard).perform();

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]")).click();

		driver.findElement(By.xpath("//label[text()='Basket']//parent::a")).click();

		driver.switchTo().frame(0);

		WebElement addBasket = driver.findElement(By.xpath("//button[contains(text(),'Add Basket')]"));
		ac.moveToElement(addBasket).perform();
		WebElement myBasket = driver.findElement(By.xpath("//button[text()='My Baskets']"));
		myBasket.click();
		

	}

	@When("User Click Place Order for Particular {string} Baskets")
	public void user_click_place_order_for_particular_baskets(String string) throws InterruptedException {

		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		WebElement element = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		
		driver.switchTo().frame(element);

		WebElement placeOrderParticularBaskets = driver.findElement(By.xpath("//div[@data-basketname='"+string+"']//descendant::button[text()='Place Order']"));
		placeOrderParticularBaskets.click();

	}

	@When("User Click Sip Order for Particular {string} Baskets")
	public void user_click_sip_order_for_particular_baskets(String string) throws InterruptedException {
		Thread.sleep(1000);

		WebElement sipOrder = driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_items']//descendant::button[@class='place_order sip_place_button']"));
		sipOrder.click();
	}

	@When("User Select Frequency {string} , Enter SIP Installment {string} and Select Sip Day {string}")
	public void user_select_frequency_enter_sip_installment_and_select_sip_day(String string, String string2,
			String string3) throws InterruptedException {

		WebElement frequency = driver
				.findElement(By.xpath("//p[text()='Frequency']//following-sibling::select[@class='sip_err_amount']"));

		Select s = new Select(frequency);
		s.selectByValue(string);
		Thread.sleep(2000);

		WebElement sipInstallment = driver
				.findElement(By.xpath("//p[text()='SIP Installment']//following-sibling::input"));
		sipInstallment.clear();
		sipInstallment.sendKeys(string2);
		Thread.sleep(2000);

		WebElement weeklySIPDay = driver
				.findElement(By.xpath("//p[text()='" + string3 + "']//following-sibling::select"));
		Select s1 = new Select(weeklySIPDay);

		s1.selectByValue("friday");
		Thread.sleep(2000);

		WebElement firstSelectedOption = s1.getFirstSelectedOption();

		String text3 = firstSelectedOption.getText();

		System.out.println("Selected day : " + text3);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Place SIP Orders']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Close']")).click();

		DayOfWeek desiredDay = DayOfWeek.valueOf(text3.toUpperCase());

		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Calculate the number of days to add to reach the desired day of the week
		int daysToAdd = desiredDay.getValue() - currentDate.getDayOfWeek().getValue();
		if (daysToAdd <= 0) {
			daysToAdd += 7; // If the desired day is earlier in the week, add 7 days to find the next
							// occurrence
		}

		// Calculate the next occurrence of the desired day
		LocalDate nextInstallmentDate = currentDate.plusDays(daysToAdd);

		// Output the next installment date
		System.out.println("Next Installment Date (coming " + text3 + "): " + nextInstallmentDate);

		WebElement nextInstallment = driver.findElement(By.xpath("(//div[@class='sip_act']//child::span)[2]"));
		String text2 = nextInstallment.getText();

		// Split the string by ": " to separate the date
		String[] parts = text2.split(": ");

		// Extract the date portion from the second part
		String datePart = parts[1];

		// Output the extracted date
		System.out.println("Next Installment Date: " + datePart);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate extractedDate = LocalDate.parse(datePart, formatter);

		// Output the extracted date
		System.out.println("Next Installment Date from webpage: " + extractedDate);

		// Compare the two dates
		if (nextInstallmentDate.equals(extractedDate)) {
			System.out.println("Both dates match.");
		} else {
			System.out.println("Dates do not match.");
		}
	}

	@When("User Execute following orders")
	public void user_execute_following_orders() throws InterruptedException {

		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		WebElement element = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(element);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@onclick='placeBasketOrder()']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='proceed_basket']")).click();
	}

	@When("User Click Delete sip for Particular {string} Baskets")
	public void user_click_delete_sip_for_particular_baskets(String string) throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='" + string
				+ "']//ancestor::div[@class='basket_items']//descendant::span[@class='rmv_basket']")).click();
	}

	@When("User Click Yes for confirmation sip delete")
	public void user_click_yes_for_confirmation_sip_delete() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='yes']")).click();
	}

	@When("User Click close After Deleted Successfully")
	public void user_click_close_after_deleted_successfully() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='Close']")).click();
		System.out.println("hi");
	}

	

	@When("User Select any Call LTP Buy")
	public void user_select_any_call_ltp_buy() throws InterruptedException {

		Thread.sleep(2000);
		
		try {
			
			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
			
		} catch (Exception e) {
			
			System.out.println("Not Visiable Ready Mode Popup Showing");
		}
		
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(element);
		Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//button[text()='Buy/Sell']"));
		element2.click();
		Thread.sleep(1000);
		
		WebElement buy = driver.findElement(By.xpath(
				"(//div[@class='ops_bs_item get_attr_data act_left act_right']//descendant::span[@data-trade='B'])[1]"));
		buy.click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

	}

	@When("User Select any Put LTP Sell")
	public void user_select_any_put_ltp_sell() throws InterruptedException {
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//iframe[@id='strategy_builder']"));
		driver.switchTo().frame(element);
		Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//span[@class='ready_mode_close']"));
		
		if (element2.isDisplayed()) {
			
			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
			
		} else {

			System.err.println("Ready Mode Button Not Visiable");
		}
		
		Thread.sleep(1000);

		WebElement sell = driver.findElement(By.xpath(
				"(//div[@class='ops_bs_item get_attr_data act_left act_right']//descendant::span[@data-trade='S'])[2]"));
		sell.click();
		Thread.sleep(1000);

	}

	@When("User Click Save Strategy")
	public void user_click_save_strategy() throws InterruptedException {

		WebElement save = driver.findElement(By.xpath("//div[text()='Save Strategy']"));
		save.click();
		Thread.sleep(1000);

	}

	@When("User enter Strategy Name {string}")
	public void user_enter_strategy_name(String string) throws InterruptedException {
		Random random = new Random();

		// Generate a random long value representing milliseconds since epoch
		long randomEpochMilli = random.nextLong();

		// Convert the long value to a LocalDateTime object (Java 8 or later)
		LocalDateTime randomDateTime = Instant.ofEpochMilli(randomEpochMilli).atZone(ZoneId.systemDefault())
				.toLocalDateTime();

		// Format the LocalDateTime object
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = randomDateTime.format(formatter);

		// Print the formatted date time
		System.out.println("Random Date Time: " + formattedDateTime);
		WebElement strategyName = driver.findElement(By.xpath("//input[@id='stratagy_name']"));
		strategyName.sendKeys(string + formattedDateTime);
		Thread.sleep(1000);
	}

	@When("User Click Save")
	public void user_click_save() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//input[@value='Save']"));
		element.click();
		Thread.sleep(1000);

	}

	@When("User Click Strategy Message ok")
	public void user_click_strategy_message_ok() throws InterruptedException {

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='jconfirm-buttons']")).click();
		Thread.sleep(1000);

		// driver.findElement(By.xpath("//span[@class='str_save_close']")).click();
		Thread.sleep(3000);
	}

	@When("User Click Place Order")
	public void user_click_place_order() throws InterruptedException {

		WebElement placeOrder = driver.findElement(By.xpath("//span[text()=' Place Order']"));
		//js.executeScript("arguments[0].click();", placeOrder);
		placeOrder.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='yes']")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@class='jconfirm-buttons']//child::button[text()='ok']")).click();

	}

	@When("User click read made")
	public void user_click_read_made() throws InterruptedException {

		driver.findElement(By.xpath("//div[text()='Ready made']")).click();
		Thread.sleep(1000);

	}

	@When("User Choose Ready made Strategy categories {string}")
	public void user_choose_ready_made_strategy_categories(String string) throws InterruptedException {

		driver.findElement(By.xpath("//a[text()='" + string + "']")).click();
		Thread.sleep(1000);

	}

	@When("User Select Strategy under categories {string}")
	public void user_select_strategy_under_categories(String string) {

		driver.findElement(By.xpath("(//div[text()='" + string + "']//parent::div)[1]")).click();
	}

	@When("User Mouse Over and Add a Script")
	public void user_mouse_over_and_add_a_script() throws InterruptedException {
		Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//div[@class='srh_results act']/descendant::li[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='srh_results act']/descendant::span[@class='s_add_sym'])[1]"))
				.click();
	}

	@When("User Click Tools {string}")
	public void user_click_tools(String string) throws InterruptedException {
		Thread.sleep(2000);

		driver.switchTo().frame("analysis");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//div[@class='menu_item']//descendant::h4[text()='Buy Back']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();

		Thread.sleep(2000);
		
		try {
			
			driver.findElement(By.xpath("//div[@class='menu_item']//descendant::h4[text()='"+string+"']")).click();
			
		} catch (Exception e) {
			
			
			driver.findElement(By.xpath("(//div[@class='menu_item']//descendant::h4[text()='"+string+"'])[2]")).click();
		}
		

	}

	@When("User Verify Buy Back Page")
	public void user_verify_buy_back_page() throws InterruptedException {

		Thread.sleep(6000);

		String title = driver.getTitle();
		System.out.println(title);

		Thread.sleep(2000);
		Set<String> windowHandles1 = driver.getWindowHandles();
		Thread.sleep(2000);
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		Thread.sleep(2000);
		driver.switchTo().window(li1.get(1));

		List<WebElement> elements = driver.findElements(By.xpath(
				"//table[@class='table footable trade-plus-table footable-loaded custome breakpoint']/tbody/tr/td"));

		Thread.sleep(2000);
		for (WebElement webElement : elements) {
			String text = webElement.getText();
			System.out.println("BBO DashBoard Current Buybacks Script" + text);
		}
		Thread.sleep(2000);
		driver.close();

		Thread.sleep(2000);
		driver.switchTo().window(li1.get(0));

	}

	@When("User MouseOver Dashboard and Click Mutual Funds")
	public void user_mouse_over_dashboard_and_click_mutual_funds() throws InterruptedException {

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Mutual Fund']//ancestor::li")).click();
		Thread.sleep(3000);
	}

	@When("User click Explore and Search {string}")
	public void user_click_explore_and_search(String string) throws InterruptedException, AWTException {
		Thread.sleep(2000);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));

		driver.switchTo().frame(iframe);

		Thread.sleep(2000);

		WebElement mandateList = driver.findElement(By.xpath("//a[@id='mandatelist-label']"));

		Actions ac = new Actions(driver);
		ac.moveToElement(mandateList).perform();
		Thread.sleep(15000);

		driver.findElement(By.xpath("//a[@id='dashboard-label']//descendant::i")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='Search_Input']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='Search_Input']")).sendKeys(string);
		Thread.sleep(2000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	@When("User Add to WatchList")
	public void user_add_to_watch_list() throws InterruptedException {
		Thread.sleep(8000);

		driver.findElement(By
				.xpath("//table[@id='default_results_table']/tbody/tr/td[6]/child::button[text()='Add to watchlist']"))
				.click();

	}

	@When("Verify in Watchlist")
	public void verify_in_watchlist() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Watch List']")).click();

	}

	@When("Select the {string} Mutual Fund")
	public void select_the_mutual_fund(String string) throws InterruptedException {
		Thread.sleep(7000);

		driver.findElement(By.xpath("(//a[text()='" + string + "'])[1]")).click();
		Thread.sleep(3000);

		WebElement element = driver.findElement(By.xpath("//iframe[@name='iframe1']"));

		driver.switchTo().frame(element);

		driver.findElement(By.xpath("//a[text()='One-Time']//parent::li[@class='tabs-title']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='buy_invest_amount']")).sendKeys("10");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Pay Now']")).click();
	}

	@When("User Select UPI Payment")
	public void user_select_upi_payment() {

		driver.findElement(By.xpath("//div[@onclick='open_upifrm()']")).click();
	}

	@When("User enter UPI ID {string} and Click Pay Via UPI")
	public void user_enter_upi_id_and_click_pay_via_upi(String string) {

		driver.findElement(By.xpath("//input[@id='payment_sec_UPI_value']")).sendKeys(string);

		driver.findElement(By.xpath("//input[@id='payment_sec_UPI1']")).click();

	}

	@When("User Pay or Decline the Payment")
	public void user_pay_or_decline_the_payment() throws InterruptedException, AWTException {

		Thread.sleep(1000);

		Robot robot = new Robot();

		// Simulate CTRL + - key press to zoom out
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		// Additional zoom out (repeat as needed)
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(45000);

		// driver.findElement(By.xpath("//h5[text()=' Cancel Payment ']")).click();

	}

	@When("Again User Click Pay Now")
	public void again_user_click_pay_now() throws InterruptedException {
		Thread.sleep(2000);

//      WebElement element = driver.findElement(By.xpath("//iframe[@name='iframe1']"));
//	    
//	    driver.switchTo().frame(element);
		driver.findElement(By.xpath("//button[text()='Pay Now']")).click();

	}

	
	
	@When("User Select Net Banking and click Pay Via Net Banking")
	public void user_select_net_banking_and_click_pay_via_net_banking() throws InterruptedException, AWTException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@onclick='open_net_bnk()']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='payment_sec_NETBANK']")).click();

		Thread.sleep(15000);

		Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<>(windowHandles2);
		Thread.sleep(2000);

		int size = windowHandles2.size();
		System.out.println(size);

		driver.switchTo().window(li.get(1));
		Thread.sleep(2000);

		driver.manage().window().maximize();
		Thread.sleep(10000);

		driver.close();

		driver.switchTo().window(li.get(0));

		Thread.sleep(5000);

	}

	@When("User go to Watchlist and Delete {string}")
	public void user_go_to_watchlist_and_delete(String string) throws InterruptedException {

		driver.switchTo().parentFrame();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Watch List']")).click();
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("(//a[text()='" + string + "']//ancestor::tr//descendant::td[6]//child::button)[1]")).click();
	}

	@When("User Again go to Watchlist and Delete {string}")
	public void user_again_go_to_watchlist_and_delete(String string) throws InterruptedException {

		driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.switchTo().frame(0);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Watch List']")).click();
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("(//a[text()='" + string + "']//ancestor::tr//descendant::td[6]//child::button)[1]")).click();

	}

	@When("User MouseOver Dashboard and click IPO\\/NFO and Click")
	public void user_mouse_over_dashboard_and_click_ipo_nfo_and_click() throws InterruptedException {
		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);

		try {
			
			driver.findElement(By.xpath("//label[text()='IPO']//ancestor::li")).click();
			
		} catch (Exception e) {
			
			WebElement element = driver.findElement(By.xpath("(//label[text()='IPO']//ancestor::li)[1]"));
			element.click();
		}

	}

	@When("User Select Current IPO and Click Apply {string}")
	public void user_select_current_ipo_and_click_apply(String string) throws InterruptedException {

		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("//div[@class='funds_show']"));
		
		Actions f=new Actions(driver);
		f.moveToElement(element2).perform();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));

		driver.switchTo().frame(element);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,500);");
	       Thread.sleep(1000);
	       js.executeScript("window.scrollBy(0,500);");
	       Thread.sleep(1000);
	       js.executeScript("window.scrollBy(0,500);");
	       Thread.sleep(1000);
	       

		driver.findElement(By.xpath("(//a[text()='Apply'])[1]")).click();

	}

	@When("User enter UPI ID , Category , Quantity \\(Lots) , BID Options and Price Cut")
	public void user_enter_upi_id_category_quantity_lots_bid_options_and_price_cut() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='upiId']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='upiId']")).sendKeys("kanniappanb7@oksbi");
		Thread.sleep(1000);

		WebElement element = driver
				.findElement(By.xpath("//span[text()='Min Quantity']//parent::h3"));
		String text = element.getText();

		System.out.println(text);

		driver.findElement(By.xpath("(//div[@class='cutoff']//child::span[@class='checkmark'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='cutoff']//child::label[contains(text(),'Cut off')])[1]")).click();

		Thread.sleep(3000);

	}

	@When("User Click Agree and Click Submit")
	public void user_click_agree_and_click_submit() throws InterruptedException {

//		driver.findElement(By.xpath("//div[@class='terms']//child::span[@class='checkmark']")).click();
//		Thread.sleep(3000);

	}

	@When("User Clik Yes For IPO Amount Payable")
	public void user_clik_yes_for_ipo_amount_payable() throws InterruptedException {

		driver.findElement(By.xpath("//button[text()='Apply IPO']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='option-detils-btn']//child::a[@id='ApplyIPOBtn']")).click();

		Thread.sleep(10000);

//		driver.findElement(By.xpath("(//span[@class='pop_close2'])[2]")).click();
//
//		driver.findElement(By.xpath("(//span[@class='pop_close1'])[1]")).click();
//
//		driver.findElement(By.xpath("//span[@class='pop_close']")).click();

		driver.switchTo().defaultContent();

	}

	@When("User Click Profit and Click Support")
	public void user_click_profit_and_click_support() {

		WebElement element = driver.findElement(By.xpath("//div[@class='user-profile dpd ']"));
		element.click();

		driver.findElement(By.xpath("//li[text()='Support']")).click();

	}

	@Then("User Verify All the Options in Chatbot")
	public void user_verify_all_the_options_in_chatbot() throws InterruptedException {

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);
		int size = li.size();
		System.out.println(size);

		driver.switchTo().window(li.get(0));

		Thread.sleep(2000);
		driver.switchTo().window(li.get(1));

		String text = driver.findElement(By.xpath("//button[text()='Trading Queries']")).getText();
		System.out.println(text);

		WebElement element = driver.findElement(By.xpath("//button[text()='Trading Queries']"));
		element.click();

		System.out.println("End");

	}

	@When("User Click Funds and Click Ledger Deposite Amount")
	public void user_click_funds_and_click_ledger_deposite_amount() throws InterruptedException {

		driver.findElement(By.xpath("//div[@onclick='FundsAndMargin()']")).click();
		driver.findElement(By.xpath("//p[@onclick='backoffice_report()']")).click();
		Thread.sleep(30000);
		driver.manage().window().maximize();

	}

	@When("User Click and Select latest Obligation")
	public void user_click_and_select_latest_obligation() throws InterruptedException {

		Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles2);

		driver.switchTo().window(li.get(1));

		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//table[@id='ReportTable']/tbody/tr/td/a[1]")).click();
		Thread.sleep(12000);

		driver.switchTo().window(li.get(1));

		Thread.sleep(5000);

		int size = li.size();
		System.out.println(size);

		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//table[@id='ReportTable']/tbody/tr[2]/td[3]"));
		String text = element.getText();
		System.err.println(text);
	}

	@When("User Click Explore")
	public void user_click_explore() throws InterruptedException {

		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(element2);

		WebElement element = driver.findElement(By.xpath("//button[@id='tab-content-tab_explore']"));
		Actions ac = new Actions(driver);

		ac.moveToElement(element).perform();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

	}

	@When("User Search {string} in Serach Box and enter")
	public void user_search_in_serach_box_and_enter(String string) throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(string);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='" + string + "']//parent::div")).click();
		Thread.sleep(1000);

	}

	@When("User Click One Time , enter amount {string} and click pay now")
	public void user_click_one_time_enter_amount_and_click_pay_now(String string) throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='One-Time']")).click();
		Thread.sleep(1000);
		WebElement amt = driver.findElement(By.xpath("//input[@data-dhx-id='ot_amt']"));
		Thread.sleep(1000);
		amt.click();
		Thread.sleep(1000);
		amt.sendKeys(string);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Pay Now']//parent::button")).click();

		Thread.sleep(1000);

	}

	@When("User Click enter UPI ID {string} and Click Pay Via UPI")
	public void user_click_enter_upi_id_and_click_pay_via_upi(String string) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter UPI ID']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter UPI ID']")).sendKeys(string);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Pay Via UPI']//parent::button")).click();

		Thread.sleep(13000);

		WebElement cancel = driver.findElement(By.xpath("//span[text()='Cancel Payment']//parent::button"));
		ac.moveToElement(cancel).perform();

		ac.click(cancel).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='py_back']")).click();
		
		driver.switchTo().defaultContent();

		Actions s=new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//div[@class='funds_show']"));
		Thread.sleep(2000);
		s.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		driver.switchTo().frame(0);
		//driver.findElement(By.xpath("///div[@class='go_home']//child::img")).click();
		
		Thread.sleep(2000);

	}

	@When("User Again Click One time enter amount {string} and click pay now")
	public void user_again_click_one_time_enter_amount_and_click_pay_now(String string) throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='py_back']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='One-Time']")).click();
		Thread.sleep(1000);

		WebElement amt = driver.findElement(By.xpath("//input[@data-dhx-id='ot_amt']"));
		amt.click();
		amt.sendKeys(string);

		driver.findElement(By.xpath("//span[text()='Pay Now']//parent::button")).click();

		Thread.sleep(1000);

	}

	@When("User Click Pay via Netbanking and verify")
	public void user_click_pay_via_netbanking_and_verify() throws InterruptedException {
		Thread.sleep(1000);

//		driver.findElement(By.xpath("//span[text()='Net Banking']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[text()='Pay Via Netbanking']//parent::button")).click();
//		Thread.sleep(1000);

		try {
			WebElement element = driver.findElement(By.xpath("//div[@class='fail_txt']"));
			String text = element.getText();
			System.out.println("Element found! Text: " + text);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found.");
		}
	}

	@When("User Search {string},{string} Scrip add in MarketWatch")
	public void user_search_scrip_add_in_market_watch(String string, String string2) throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);

		Thread.sleep(5000);
		
		try {
			
			driver.findElement(By.xpath("(//span[text()='Stocks'])[3]")).click();
			
		} catch (Exception e) {
			
			driver.findElement(By.xpath("(//span[text()='Stocks'])[2]")).click();
		}

		
		Thread.sleep(2000);

		//driver.findElement(By.xpath("(//span[text()='All'])[2]")).click();

		//Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//parent::div//parent::li//child::span[text()='"+string2+"']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//parent::div//following-sibling::div//child::span[@class='s_add_sym']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]//following-sibling::span")).click();
		Thread.sleep(2000);

		//driver.navigate().refresh();

	}

	@When("User mouseover {string},{string} Scrip and click buy button")
	public void user_mouseover_scrip_and_click_buy_button(String string, String string2) throws InterruptedException {
		Thread.sleep(8000);

		try {
			
			WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//parent::div//parent::div//child::span[text()='"+string2+"'])[1]"));
			Actions ac1 = new Actions(driver);
			
			ac1.moveToElement(element).perform();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='buy buyorder']")).click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			
			WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//parent::div//parent::div//child::span[text()='"+string2+"'])[1]"));
			Actions ac1 = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("arguments[0].scrollIntoView();", element);


			ac1.moveToElement(element).perform();
			Thread.sleep(2000);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='buy buyorder']")).click();
			Thread.sleep(2000);
			
			
		}
		

	}

	@When("User Select {string} and Choose {string} and click Buy Order")
	public void user_select_and_choose_and_click_buy_order(String string, String string2) throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Market']//parent::div")).click();
		Thread.sleep(1000);

//		driver.findElement(By.xpath("//label[text()='" + string2 + "']//parent::div[@class='radio']")).click();
//
//		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='BUY']")).click();
		Thread.sleep(2000);

	}

	@When("User Click Order Confirmation and Check Order Placed or Insufficient fund")
	public void user_click_order_confirmation_and_check_order_placed_or_insufficient_fund()
			throws InterruptedException {

		driver.findElement(By.xpath("//button[text()='yes']")).click();

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//h5[text()='Insufficient Fund']"));

		if (element.isDisplayed()) {
			System.out.println("Insufficient Fund is Displayed");

			driver.findElement(By.xpath("(//button[@class='close-button'])[6]")).click();

			Thread.sleep(2000);

		}

	}
	


	@When("User Enter Trigger Price {string} and Click Buy")
	public void user_enter_trigger_price_and_click_buy(String string) throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Trigger price']//following-sibling::input")).clear();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Trigger price']//following-sibling::input")).sendKeys(string);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='BUY']")).click();
		Thread.sleep(2000);

		String text = driver.findElement(By.xpath("(//div[@class='errdiv'])[4]")).getText();

		System.out.println(text);

		/////

		Pattern pattern = Pattern.compile("\\d+\\.\\d+");
		Matcher matcher = pattern.matcher(text);

		String secondValue = null;
		int count = 0;

		while (matcher.find()) {
			count++;
			if (count == 2) {
				secondValue = matcher.group();
				break;
			}
		}

		if (secondValue != null) {
			String integerPart = secondValue.split("\\.")[0];
			System.out.println("The integer part of the second value is: " + integerPart);

			// Send the integer part to the input field
			driver.findElement(By.xpath("//label[text()='Trigger price']//following-sibling::input"))
					.sendKeys(integerPart);

		} else {
			System.out.println("No second value found.");
		}
		/////

		driver.findElement(By.xpath("//button[text()='BUY']")).click();

		driver.findElement(By.xpath("//button[text()='yes']")).click();

	}

	@When("User Search {string},{string} ,{string} Scrip and click Futures add in MarketWatch")
	public void user_search_scrip_and_click_futures_add_in_market_watch(String string, String string2, String string3)
			throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string2);

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[text()='Stocks'])[2]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[text()='All'])[2]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Futures']")).click();

		Thread.sleep(5000);

		WebElement element = driver
				.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='"
						+ string3 + "']//following-sibling::span[text()='" + string + "']//ancestor::li"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='"
				+ string3 + "']//following-sibling::span[text()='" + string
				+ "']//ancestor::li//descendant::span[@class='s_add_sym']")).click();
		Thread.sleep(2000);

		driver.navigate().refresh();

	}

	@When("User click plus symbol enter a marketwatch name {string} and click create")
	public void user_click_plus_symbol_enter_a_marketwatch_name_and_click_create(String string)
			throws InterruptedException {

		driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='new_mw_name']")).sendKeys(string);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='Create']//parent::button")).click();

		Thread.sleep(4000);
	}

	@When("User Verify Marketwatch is Limit")
	public void user_verify_marketwatch_is_limit() {

		WebElement element = driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]"));

		if (element.isDisplayed()) {
			System.out.println("User can Able to add another Market watch");

		}

		else {
			System.out.println("Market watch Reach the limit");

		}
	}

	@When("User right click marketwatch name {string} and click Delete")
	public void user_right_click_marketwatch_name_and_click_delete(String string) throws InterruptedException {
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//span[text()='" + string + "']//parent::button"));

		Actions ac = new Actions(driver);
		ac.contextClick(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Delete']//ancestor::button")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='yes']")).click();

		Thread.sleep(1000);

	}

	@When("User right click marketwatch name {string} and click Rename {string}")
	public void user_right_click_marketwatch_name_and_click_rename(String string, String string2)
			throws InterruptedException {
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//span[text()='" + string + "']//parent::button"));

		Actions ac = new Actions(driver);
		ac.contextClick(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Rename']//ancestor::button")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='new_mw_name']")).sendKeys(string);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='Save']//parent::button")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='yes']")).click();

		Thread.sleep(1000);
	}
	
	
	
	

	@When("User Check the Exchange , Symbol , Series , Qty , Price , B\\/S , Trig Price , Produt and LUT")
	public void user_check_the_exchange_symbol_series_qty_price_b_s_trig_price_produt_and_lut()
			throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='Activity']//parent::a")).click();

		Thread.sleep(1000);

		WebElement exchange = driver.findElement(By.xpath("(//div[@data-dhx-col-id='Exch'])[1]"));
		String text = exchange.getText();

		System.err.println("The Exhange is : " + text);

		WebElement symbol = driver.findElement(By.xpath("(//div[@data-dhx-col-id='Symbol'])[1]"));

		String text1 = symbol.getText();

		System.err.println("The symbol is : " + text1);
		Thread.sleep(1000);

		WebElement Series = driver.findElement(By.xpath("(//div[@data-dhx-col-id='Series'])[1]"));

		String text2 = Series.getText();

		System.err.println("The Series is : " + text2);

		WebElement qty = driver.findElement(By.xpath("(//div[@data-dhx-col-id='Qty'])[1]"));

		String text3 = qty.getText();

		System.err.println("The qty is : " + text3);

		Thread.sleep(1000);

		WebElement Price = driver.findElement(By.xpath("(//div[@data-dhx-col-id='Price'])[1]"));

		String text4 = Price.getText();

		System.err.println("The Price is : " + text4);
		Thread.sleep(1000);

		WebElement BS = driver.findElement(By.xpath("(//div[@data-dhx-col-id='BS'])[1]"));

		String text5 = BS.getText();

		System.err.println("The BS is : " + text5);

		WebElement trigPrice = driver.findElement(By.xpath("(//div[@data-dhx-col-id='TrigPrice'])[1]"));
		Thread.sleep(1000);

		String text6 = trigPrice.getText();

		System.err.println("The trigPrice is : " + text6);
		Thread.sleep(1000);

		WebElement Product = driver.findElement(By.xpath("(//div[@data-dhx-col-id='Product'])[1]"));

		String text7 = Product.getText();

		System.err.println("The Product is : " + text7);

		WebElement LUT = driver.findElement(By.xpath("(//div[@data-dhx-col-id='LUT'])[1]"));

		String text8 = LUT.getText();

		System.err.println("The LUT is : " + text8);
		Thread.sleep(1000);

	}

	@When("User Check the Order Number , DQty , Book Type , Duration")
	public void user_check_the_order_number_d_qty_book_type_duration() throws InterruptedException {

		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("(//div[@class='activity_note'])[1]"));
		String text = element.getText();

		System.out.println("Value is : " + text);
		Thread.sleep(1000);

		String formattedString = text.replace("Book Type :", ", Book Type :").replace("Duration :", ", Duration :")
				.replace("\n", "").replace("Remarks :", ", Remarks :").replace("[", ", ").replace("]", "")
				.replace("  ", " ").replace(", ,", ",").trim();

// Splitting the string by commas and printing each part on a new line
		String[] parts = formattedString.split(", ");
		for (String part : parts) {
			System.err.println(part);
		}

	}

	@When("User Check Remarks , Set Deposit , Used Deposit , Prev Used, UR_PL and R_PL")
	public void user_check_remarks_set_deposit_used_deposit_prev_used_ur_pl_and_r_pl() {

		System.out.println("");

	}

	@When("User Click Exchange Filter {string} , Symbol Filter {string} , Series {string} , , B\\/S {string} Product {string}")
	public void user_click_exchange_filter_symbol_filter_series_b_s_product(String string, String string2,
			String string3, String string4, String string5) throws InterruptedException {

	}

	@When("User Click Exchange and Filter {string}")
	public void user_click_exchange_and_filter(String string) throws InterruptedException {
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("(//select[contains(@class,'dxi dxi-menu-down')])[1]"));
		Select s=new Select(element);
		
		s.selectByVisibleText(string);

//		driver.findElement(By.xpath(
//				"//div[@data-dhx-id='Exch']//parent::div//following-sibling::div//descendant::div[@data-dhx-id='Exch']"))
//				.click();
//
//		driver.findElement(By.xpath("//li[text()='" + string + "']")).click();
	}

	@When("User Click Symbol and Filter {string}")
	public void user_click_symbol_and_filter(String string) throws InterruptedException {
		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("(//select[contains(@class,'dxi dxi-menu-down')])[2]"));
		Select s=new Select(element);
		
		s.selectByVisibleText(string);
//		driver.findElement(By.xpath(
//				"//div[@data-dhx-id='Symbol']//parent::div//following-sibling::div//descendant::div[@data-dhx-id='Symbol']"))
//				.click();
//
//		driver.findElement(By.xpath("//li[text()='" + string + "']")).click();
	}

	@When("User Click Series and Filter {string}")
	public void user_click_series_and_filter(String string) throws InterruptedException {
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("(//select[contains(@class,'dxi dxi-menu-down')])[3]"));
		Select s=new Select(element);
		
		s.selectByVisibleText(string);

//		driver.findElement(By.xpath(
//				"//div[@data-dhx-id='Series']//parent::div//following-sibling::div//descendant::div[@data-dhx-id='Series']"))
//				.click();
//
//		driver.findElement(By.xpath("//li[text()='" + string + "']")).click();
	}

	@When("User Click B\\/S and Filter {string}")
	public void user_click_b_s_and_filter(String string) throws InterruptedException {
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("(//select[contains(@class,'dxi dxi-menu-down')])[4]"));
		Select s=new Select(element);
		
		s.selectByVisibleText(string);

//		driver.findElement(By.xpath(
//				"//div[@data-dhx-id='BS']//parent::div//following-sibling::div//descendant::div[@data-dhx-id='BS']"))
//				.click();
//
//		driver.findElement(By.xpath("//li[text()='" + string + "']")).click();
	}

	@When("User Click Product and Filter {string}")
	public void user_click_product_and_filter(String string) throws InterruptedException {
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("(//select[contains(@class,'dxi dxi-menu-down')])[5]"));
		Select s=new Select(element);
		
		s.selectByVisibleText(string);

//		driver.findElement(By.xpath(
//				"//div[@data-dhx-id='Product']//parent::div//following-sibling::div//descendant::div[@data-dhx-id='Product']"))
//				.click();
//
//		driver.findElement(By.xpath("//li[text()='" + string + "']")).click();

		Thread.sleep(1000);

	}

	@When("User Click Account page")
	public void user_click_account_page() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='user-profile dpd ']")).click();
		Thread.sleep(1000);
	}

	@When("User Click {string} and Change the Theme Automatically")
	public void user_click_and_change_the_theme_automatically(String string) throws InterruptedException {

		driver.findElement(By.xpath("//ul[@class='theme_color']//child::li[@class='" + string + "']")).click();
		Thread.sleep(1000);

	}

	@When("User Click My Profile")
	public void user_click_my_profile() throws InterruptedException {
		driver.findElement(By.xpath("//li[@onclick='showProfile();']")).click();
		Thread.sleep(1000);

	}

	@When("User Click Email ,Phone Eye icon check button working or not")
	public void user_click_email_phone_eye_icon_check_button_working_or_not() throws InterruptedException {

		driver.findElement(By.xpath("(//i[@class='fa fa-eye hide_mask'])[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//i[@class='fa fa-eye hide_mask'])[2]")).click();

		Thread.sleep(1000);

	}

	@When("User Click Email edit and navigate to Rekyc page get the Name ,UCC,Father\\/spouse name , Cilent ID and Pan")
	public void user_click_email_edit_and_navigate_to_rekyc_page_get_the_name_ucc_father_spouse_name_cilent_id_and_pan()
			throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[@data-title='email_profile']")).click();
		Thread.sleep(1000);

	}

	@When("User Scroll Down and Click Account Eye Icon")
	public void user_scroll_down_and_click_account_eye_icon() throws InterruptedException {

		Thread.sleep(1000);

		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		driver.switchTo().window(li1.get(1));

		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[1]")).click();

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Mobile No']//parent::li")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[2]")).click();

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Change of address']//parent::li")).click();
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Nominee']//parent::li")).click();
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Bank']//parent::li")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[2]")).click();

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Segment']//parent::li")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Agree']")).click();

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Income Declaration']//parent::li")).click();

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		driver.findElement(By.xpath("//a[text()='Dis Slip Req']//parent::li")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[3]")).click();

		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[4]")).click();
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		driver.findElement(By.xpath("//a[text()='Service Status ']//parent::li")).click();
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		Thread.sleep(1000);

		//driver.findElement(By.xpath("//a[text()='Next »']")).click();

//		js.executeScript("window.scrollBy(0, 500)");
//		js.executeScript("window.scrollBy(0, 500)");
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//a[text()='DDPI']//parent::li")).click();
//
//		js.executeScript("window.scrollBy(0, 500)");
//		js.executeScript("window.scrollBy(0, 500)");
//		Thread.sleep(1000);

		driver.navigate().back();

		Thread.sleep(4000);

		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(li1.get(0));

	}

	@When("User Click Phone Edit Icon and Check")
	public void user_click_phone_edit_icon_and_check() throws InterruptedException {
		
		//driver.findElement(By.xpath("//div[@class='user-profile dpd']")).click();
		driver.findElement(By.xpath("(//div[@class='user-img']//parent::div)[1]")).click();
		
		
		driver.findElement(By.xpath("//li[@onclick='showProfile();']")).click();
		Thread.sleep(1000);
		
		
		
		driver.findElement(By.xpath("//span[@data-title='phone_profile']")).click();
		Thread.sleep(1000);

		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		driver.switchTo().window(li1.get(1));

		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[1]")).click();

		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[2]")).click();

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(li1.get(0));

	}

	@When("User Click Account Edit Icon")
	public void user_click_account_edit_icon() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//span[@data-title='segment']")).click();
		Thread.sleep(5000);
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);
		Thread.sleep(5000);

		driver.switchTo().window(li1.get(1));

		// WebElement element =
		// driver.findElement(By.xpath("//div[@class='risk_dis_cunt']"));

//			WebElement sebi = driver.findElement(By.xpath("//a[contains(text(),'SEBI')]"));
//
//			// Scroll down to the WebElement 'sebi'
//			js.executeScript("arguments[0].scrollIntoView(true);", sebi);			
//			
//		
//			
//	
		
		//driver.findElement(By.xpath("//a[text()='Agree']")).click();
		Thread.sleep(1000);

		driver.close();

		Thread.sleep(1000);
		driver.switchTo().window(li1.get(0));

	}

	@When("User Click Bank Details Edit Icon")
	public void user_click_bank_details_edit_icon() throws InterruptedException {
		driver.findElement(By.xpath("//span[@data-title='bank']")).click();
		Thread.sleep(1000);
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		Thread.sleep(3000);
		driver.switchTo().window(li1.get(1));

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[1]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@class='icon show_icon'])[2]")).click();

		Thread.sleep(1000);
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(li1.get(0));

		driver.findElement(By.xpath("(//span[@class='funds_back'])[3]")).click();

	}

	@When("User Click N Coins")
	public void user_click_n_coins() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[@class='refer_frd']//descendant::img")).click();
		Thread.sleep(5000);
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		driver.switchTo().window(li1.get(1));

	}

	@When("Scroll Down Check the Brokerage & Charges")
	public void scroll_down_check_the_brokerage_charges() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		driver.close();

		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		driver.switchTo().window(li1.get(0));
		Thread.sleep(2000);
	}

	@When("User Click Support and Check")
	public void user_click_support_and_check() throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[text()='Support']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);
		int size = li.size();
		System.out.println(size);

		driver.switchTo().window(li.get(0));

		Thread.sleep(2000);
		driver.switchTo().window(li.get(1));

		String text = driver.findElement(By.xpath("//button[text()='Trading Queries']")).getText();
		System.out.println(text);

		WebElement element = driver.findElement(By.xpath("//button[text()='Trading Queries']"));
		element.click();

		System.out.println("End");

		driver.close();
		Thread.sleep(2000);

		driver.switchTo().window(li.get(0));

	}

	@When("User Click Keyboard Shortcut")
	public void user_click_keyboard_shortcut() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@onclick='s_key_fun();']//child::img")).click();

	}

	@When("User getting all Navigation and MarketWatch Data")
	public void user_getting_all_navigation_and_market_watch_data() {

		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@aria-label='SHORT CUT KEYS']//descendant::li"));
		for (WebElement webElement : elements) {
			String text = webElement.getText();
			System.err.println(text);
		}

		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
	}

	@When("User Press Alt + O navigate to Pending Orders")
	public void user_press_alt_o_navigate_to_pending_orders() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Pending Orders']//parent::a"));
		Actions d=new Actions(driver);
		
		d.moveToElement(element).perform();
		Thread.sleep(2000);
		d.click(element).perform();
		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ALT);

		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);

	}

	@When("User Press Alt + A navigate to Dashboard")
	public void user_press_alt_a_navigate_to_dashboard() throws InterruptedException, AWTException {

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);

	}

	@When("User Press Alt + P navigate to Position")
	public void user_press_alt_p_navigate_to_position() throws InterruptedException, AWTException {

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ALT);

		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);

	}

	@When("User Press Alt + T navigate to Trades")
	public void user_press_alt_t_navigate_to_trades() throws InterruptedException, AWTException {
		Robot r = new Robot();

		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
	}

	@When("User Press Alt + H navigate to Holdings")
	public void user_press_alt_h_navigate_to_holdings() throws InterruptedException, AWTException {
		Robot r = new Robot();

		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_H);
		r.keyRelease(KeyEvent.VK_H);

	}

	@When("User Press Alt + F navigate to Funds")
	public void user_press_alt_f_navigate_to_funds() throws InterruptedException, AWTException {
		Robot r = new Robot();

		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_F);
	}

	@When("User Press Alt + J navigate to Profile")
	public void user_press_alt_j_navigate_to_profile() throws InterruptedException, AWTException {
		Robot r = new Robot();

		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_J);
		r.keyRelease(KeyEvent.VK_J);

		driver.findElement(By.xpath("(//a[@aria-label='Close modal'])[2]")).click();

	}

	@When("User Press Alt + Down or Up Arrow its navigate to marketwatch select a scrip")
	public void user_press_alt_down_or_up_arrow_its_navigate_to_marketwatch_select_a_scrip()
			throws AWTException, InterruptedException {
		Robot r = new Robot();

		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	@When("User Press Alt + B buy a scrip")
	public void user_press_alt_b_buy_a_scrip() throws AWTException, InterruptedException {
		Robot r = new Robot();

		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ALT);

		r.keyPress(KeyEvent.VK_B);
		r.keyRelease(KeyEvent.VK_B);

	}

	@When("User Press Alt + S Sell a scrip")
	public void user_press_alt_s_sell_a_scrip() throws AWTException, InterruptedException {
		Robot r = new Robot();

		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ALT);

		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);

	}

	@When("User Press Alt + C Open a chart")
	public void user_press_alt_c_open_a_chart() throws AWTException, InterruptedException {
		Robot r = new Robot();

		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ALT);

		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);

		driver.findElement(By.xpath("//span[@class='dhx_button__icon dxi dxi dxi-close']")).click();

	}

	@When("User Click Tour App and check")
	public void user_click_tour_app_and_check() throws InterruptedException {

		Thread.sleep(2000);

		driver.findElement(By.xpath("//li[text()='Tour APP']")).click();

		driver.findElement(By.xpath("//a[text()='Next →']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Next →']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Next →']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		Thread.sleep(1000);

	}

	@When("User Click terms and Conditions and Check")
	public void user_click_terms_and_conditions_and_check() throws AWTException, InterruptedException {

		driver.findElement(By.xpath("//a[text()='Terms and Conditions']")).click();

		Robot r = new Robot();

		Thread.sleep(2000);

		for (int i = 0; i <= 30; i++) {
			Thread.sleep(200);

			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);

		}

	}

	@When("User mouse over Dashboard")
	public void user_mouse_over_dashboard() throws InterruptedException {

		Thread.sleep(3000);

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		Actions ac = new Actions(driver);
		ac.moveToElement(dashBoard).perform();

		Thread.sleep(1000);

	}

	@When("User click IPO and Get the Current IPOs and Upcoming IPOs")
	public void user_click_ipo_and_get_the_current_ip_os_and_upcoming_ip_os() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='IPO/NFO/BOND']//ancestor::li")).click();
		Thread.sleep(3000);

		WebElement element1 = driver.findElement(By.xpath("(//span[text()='Dashboard'])[3]"));

		Actions ac = new Actions(driver);
		ac.moveToElement(element1).perform();
		Thread.sleep(1000);

		driver.switchTo().frame(0);

		Thread.sleep(2000);
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class='ipo_list_item']//descendant::div[@class='item_2 ipo_symbol']"));

		// Iterate through each WebElement and print the text
		for (WebElement element : elements) {
			System.out.println(element.getText());
		}

	}

	@When("User click MY IPO Get the Data")
	public void user_click_my_ipo_get_the_data() throws InterruptedException {

		driver.findElement(By.xpath("//a[text()='MY IPO']//parent::li")).click();
		Thread.sleep(1000);

		Thread.sleep(1000);

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='my_ipo_items']"));

		for (WebElement webElement : elements) {
			String text = webElement.getText();
			System.err.println(text);
		}

	}

	@When("User click IPO again")
	public void user_click_ipo_again() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='MY IPO']//parent::li")).click();

	}

	@When("User Select {string} IPO and click Apply")
	public void user_select_ipo_and_click_apply(String string) throws InterruptedException {

		driver.findElement(By.xpath("//a[text()='IPO']//parent::li")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[text()='" + string + "']//parent::div//descendant::input[@value='Apply']"))
				.click();
		Thread.sleep(2000);

	}

	@When("User Click Equities")
	public void user_click_equities() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//h4[text()='Equities']//ancestor::li")).click();
		Thread.sleep(1000);

	}

	@When("User mouse over stock name and change to ascending order")
	public void user_mouse_over_stock_name_and_change_to_ascending_order() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[text()='Stock Name']")).click();

	}

	@When("User Take a first stock name and LPT Value in equities")

	public void user_take_a_first_stock_name_and_lpt_value_in_equities() throws InterruptedException {
		Thread.sleep(1000);
		

		WebElement element2 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='name'])[1]"));
		String text = element2.getText();
		System.out.println(text);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='ltp'])[1]"));
		String text2 = element3.getText();
		System.out.println(text2);
		Thread.sleep(1000);

		String result = text.substring(0, text.indexOf("-"));
		System.out.println(result);
		Thread.sleep(1000);

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(result);

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[text()='Stocks'])[2]")).click();
		Thread.sleep(4000);

		WebElement element = driver
				.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='"
						+ result + "']//following-sibling::span[text()='NSE']//ancestor::li"));
		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='" + result
				+ "']//following-sibling::span[text()='NSE']//ancestor::li//descendant::span[@class='s_add_sym']"))
				.click();
		Thread.sleep(1000);

		driver.navigate().refresh();
		WebElement element1 = driver.findElement(By.xpath("(//span[text()='NSE']//following-sibling::span[text()='"
				+ result + "']//ancestor::li//descendant::span[@class='sys_vl'])[1]"));
		Thread.sleep(5000);

		String text3 = element1.getText();

		System.err.println(text3);
		System.err.println(text2);

		if (text3 == text2) {
			System.out.println("Verified the Equities Stock Values is equals to Marketwatch Stock Value");
		}

		else {
			System.out.println("Verified the Equities Stock Values is Not equals to Marketwatch Stock Value");
		}

	}

	@When("User Take a first stock name and LPT Value in options")
	public void user_take_a_first_stock_name_and_lpt_value_in_options() throws InterruptedException {

		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='name'])[1]"));
		String text = element2.getText();
		System.out.println(text);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='ltp'])[1]"));
		String text2 = element3.getText();
		System.out.println(text2);
		Thread.sleep(1000);

		String result = text.replaceAll("([A-Z]+)(\\d{2})([A-Z]{3})(\\d+)([A-Z]{2})", "$1 $3 $4 $5");
		result = result.replaceAll("(\\w{5})(\\w+)", "$1 $2");
		System.out.println(result);

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(result);

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[text()='Options'])[1]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[text()='Options'])[1]")).click();

		Thread.sleep(1000);

		WebElement element = driver
				.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='" + text
						+ "']//following-sibling::span[text()='NSE']//ancestor::li"));
		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='" + text
				+ "']//following-sibling::span[text()='NSE']//ancestor::li//descendant::span[@class='s_add_sym']"))
				.click();
		Thread.sleep(1000);

		driver.navigate().refresh();
		WebElement element1 = driver.findElement(By.xpath("(//span[text()='NSE']//following-sibling::span[text()='"
				+ text + "']//ancestor::li//descendant::span[@class='sys_vl'])[1]"));
		Thread.sleep(5000);

		String text3 = element1.getText();

		System.err.println(text3);
		System.err.println(text2);
		Thread.sleep(2000);

		if (text3.equalsIgnoreCase(text2)) {
			System.out.println("Verified the Equities Stock Values is equals to Marketwatch Stock Value");
		}

		else {
			System.out.println("Verified the Equities Stock Values is Not equals to Marketwatch Stock Value");
		}

	}

	@When("User Click Losers")
	public void user_click_losers() throws InterruptedException {
		Thread.sleep(1000);

		clickAnElement("//span[text()='Losers']");
	}

	@When("User Click By Value")
	public void user_click_by_value() throws InterruptedException {
		Thread.sleep(1000);

		clickAnElement("//span[text()='By Value']");

	}

	@When("User Click By Volume")
	public void user_click_by_volume() throws InterruptedException {
		Thread.sleep(1000);

		clickAnElement("//span[text()='By Volume']");

	}

	@When("User Click Only Buyers")
	public void user_click_only_buyers() throws InterruptedException {
		Thread.sleep(1000);

		clickAnElement("//span[text()='Only Buyers']");

	}

	@When("User Click Only Sellers")
	public void user_click_only_sellers() throws InterruptedException {
		Thread.sleep(1000);

		clickAnElement("//span[text()='Only Sellers']");

	}

	@When("User Click Options")
	public void user_click_options() throws InterruptedException {
		driver.findElement(By.xpath("//h4[text()='Options']//ancestor::li")).click();
		Thread.sleep(5000);

	}

	@When("User Click OI Gainers")
	public void user_click_oi_gainers() {

		clickAnElement("//span[text()='OI Gainers']");

	}

	@When("User Click OI Losers")
	public void user_click_oi_losers() {
		clickAnElement("//span[text()='OI Losers']");

	}

	@When("User Take a first stock name and LPT Value in Futures")
	public void user_take_a_first_stock_name_and_lpt_value_in_futures() throws InterruptedException {
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='name'])[1]"));
		String text = element2.getText();
		System.out.println(text);
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='ltp'])[1]"));
		String text2 = element3.getText();
		System.out.println(text2);
		Thread.sleep(1000);

		String result = text.replaceAll("(.*)\\d{2}.*", "$1");
		System.out.println(result);

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(result);

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//span[text()='Options'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();

		Thread.sleep(2000);

		WebElement element = driver
				.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='" + text
						+ "']//following-sibling::span[text()='NSE']//ancestor::li"));
		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='" + text
				+ "']//following-sibling::span[text()='NSE']//ancestor::li//descendant::span[@class='s_add_sym']"))
				.click();
		Thread.sleep(1000);

		driver.navigate().refresh();
		WebElement element1 = driver.findElement(By.xpath("(//span[text()='NSE']//following-sibling::span[text()='"
				+ text + "']//ancestor::li//descendant::span[@class='sys_vl'])[1]"));
		Thread.sleep(5000);

		String text3 = element1.getText();

		System.err.println(text3);
		System.err.println(text2);
		Thread.sleep(2000);

		if (text3.equalsIgnoreCase(text2)) {
			System.out.println("Verified the Equities Stock Values is equals to Marketwatch Stock Value");
		}

		else {
			System.out.println("Verified the Equities Stock Values is Not equals to Marketwatch Stock Value");
		}

	}

	@When("User Click Futures in dashboard")
	public void user_click_futures_in_dashboard() throws InterruptedException {

		driver.findElement(By.xpath("//h4[text()='Futures']//ancestor::li")).click();
		Thread.sleep(5000);

	}

	@When("User Click Commodities in dashboard")
	public void user_click_commodities_in_dashboard() throws InterruptedException {
		driver.findElement(By.xpath("//h4[text()='Commodities']//ancestor::li")).click();
		Thread.sleep(5000);
	}

	@When("User Take a first stock name and LPT Value in Commodities")
	public void user_take_a_first_stock_name_and_lpt_value_in_commodities() throws InterruptedException {

		Thread.sleep(1000);

		driver.switchTo().frame(0);

		WebElement element2 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='name'])[1]"));
		String text = element2.getText();
		System.out.println(text);
		Thread.sleep(1000);

		WebElement element4 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='expriy_date'])[1]"));
		String text4 = element4.getText();
		System.out.println(text4);
		Thread.sleep(1000);

		String[] parts = text4.split(" ");
		String day = parts[0]; // "29"
		String month = parts[1]; // "Nov"
		System.out.println("Day: " + day);
		System.out.println("Month: " + month);

		WebElement element3 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='ltp'])[1]"));
		String text2 = element3.getText();
		System.out.println(text2);
		Thread.sleep(1000);

		String result = text.replaceAll("(.*)\\d{2}.*", "$1");
		System.out.println(result);

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(result, " ", month);

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//span[text()='Options'])[1]")).click();
		Thread.sleep(2000);

		try {
			
			driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
			
		} catch (Exception e) {
			
			driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
			
		}
		

		Thread.sleep(2000);

		String fut = "FUT";

		String xpath = text + day + month + fut;
		String upperCase = xpath.toUpperCase();
		System.out.println(upperCase);

		WebElement element = driver
				.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='"
						+ upperCase + "']//following-sibling::span[text()='MCX']//ancestor::li"));
		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[text()='"
				+ upperCase
				+ "']//following-sibling::span[text()='MCX']//ancestor::li//descendant::span[@class='s_add_sym']"))
				.click();
		Thread.sleep(1000);

		driver.navigate().refresh();
		WebElement element1 = driver.findElement(By.xpath("(//span[text()='MCX']//following-sibling::span[text()='"
				+ upperCase + "']//ancestor::li//descendant::span[@class='sys_vl'])[1]"));
		Thread.sleep(5000);

		String text3 = element1.getText();

		System.err.println(text3);
		System.err.println(text2);
		Thread.sleep(2000);

		if (text3.equalsIgnoreCase(text2)) {
			System.out.println("Verified the Equities Stock Values is equals to Marketwatch Stock Value");
		}

		else {
			System.out.println("Verified the Equities Stock Values is Not equals to Marketwatch Stock Value");
		}

	}

	@When("User Take a first stock name and LPT Value in Commodities Options")
	public void user_take_a_first_stock_name_and_lpt_value_in_commodities_options() throws InterruptedException {

		Thread.sleep(1000);

		driver.switchTo().frame(0);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Options']//parent::label")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//div[@data-dhx-col-id='name'])[1]")).click();

		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		WebElement element5 = driver.findElement(By.xpath("//span[@class='dh_sym']"));
		String text5 = element5.getText();
		System.out.println(text5);
		Thread.sleep(3000);

		String lastTwoLetters = text5.replaceAll(".*(\\w{2})\\s*\\(EQ\\)", "$1");

		// Extract the number using regex
		String number = text5.replaceAll("[^0-9]", ""); // This will give "840"

		System.out.println("Last two letters: " + lastTwoLetters);
		System.out.println("Number: " + number);

		WebElement element6 = driver.findElement(By.xpath("(//ul[@class='sys_ul m_depth_swt']//descendant::span)[3]"));
		String text6 = element6.getText();
		System.out.println(text6);
		Thread.sleep(2000);

		WebElement element7 = driver
				.findElement(By.xpath("//span[@class='dhx_button__icon dxi dxi dxi-close']//parent::button"));
		element7.click();

		Thread.sleep(1000);

		driver.switchTo().frame(0);

		WebElement element2 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='name'])[1]"));
		String text = element2.getText();
		System.out.println(text);
		Thread.sleep(1000);

		WebElement element4 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='expriy_date'])[1]"));
		String text4 = element4.getText();
		System.out.println(text4);
		Thread.sleep(1000);

		String[] parts = text4.split(" ");
		String day = parts[0]; // "29"
		String month = parts[1]; // "Nov"
		System.out.println("Day: " + day);
		System.out.println("Month: " + month);

		WebElement element3 = driver.findElement(By.xpath("(//div[@data-dhx-col-id='ltp'])[1]"));
		String text2 = element3.getText();
		System.out.println(text2);
		Thread.sleep(1000);

		String result = text.replaceAll("(.*)\\d{2}.*", "$1");
		System.out.println(result);

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(result, " ", month, " ", number, " ",
				lastTwoLetters);

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[text()='Options'])[1]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[text()='Options'])[1]")).click();

		Thread.sleep(2000);

		WebElement element = driver.findElement(
				By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[contains(text(),'" + number
						+ "')]//following-sibling::span[text()='MCX']//ancestor::li"));
		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='srh_results act']/descendant::li//descendant::span[contains(text(),'"
				+ number
				+ "')]//following-sibling::span[text()='MCX']//ancestor::li//descendant::span[@class='s_add_sym']"))
				.click();
		Thread.sleep(1000);

		driver.navigate().refresh();
		WebElement element1 = driver
				.findElement(By.xpath("(//span[text()='MCX']//following-sibling::span[contains(text(),'" + number
						+ "')]//ancestor::li//descendant::span[@class='sys_vl'])[1]"));
		Thread.sleep(5000);

		String text3 = element1.getText();

		System.err.println(text3);
		System.err.println(text2);
		Thread.sleep(2000);

		if (text3.equalsIgnoreCase(text6)) {
			System.out.println("Verified the Equities Stock Values is equals to Marketwatch Stock Value");
		}

		else {
			System.out.println("Verified the Equities Stock Values is Not equals to Marketwatch Stock Value");
		}

	}

	

	@When("User Navigate to Backoffice and Click Activity")
	public void user_navigate_to_backoffice_and_click_activity() throws InterruptedException {

		Thread.sleep(5000);

		Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<>(windowHandles2);

		driver.switchTo().window(li.get(1));
		Thread.sleep(1000);
		
		String title = driver.getTitle();
		
		System.out.println(title);
		Thread.sleep(1000);

		try {
			
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			
			WebElement element = driver.findElement(By.xpath("(//span[text()='×'])[1]"));
			element.click();
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		clickAnElement("//span[text()='Activity']//ancestor::span//following-sibling::b//child::em[@class='fa fa-plus-square-o']");

		Thread.sleep(1000);

	}

	

	

	@When("User click View and Verify the data")
	public void user_click_view_and_verify_the_data() throws InterruptedException, IOException, AWTException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@value=' View']")).click();

		Thread.sleep(2000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(
				"D:\\Projects\\Post_Markets_NTP\\ScreenShort\\Backoffice.png");
		Files.copy(screenshotAs, des);

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//table[@id='ReportTable']"));
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);

		Thread.sleep(2000);
		if (displayed == false) {

			driver.switchTo().defaultContent();

			driver.close();

			Robot robot = new Robot();

			// Press and hold the CTRL key
			robot.keyPress(KeyEvent.VK_CONTROL);
			// Press the N key
			robot.keyPress(KeyEvent.VK_N);

			// Release the N key
			robot.keyRelease(KeyEvent.VK_N);
			// Release the CTRL key
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Switch to the new tab (last opened tab)
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}

			// Navigate to a new URL in the new tab
			driver.get(
					"https://accounts.google.com/InteractiveLogin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=ARZ0qKI-OlL97AHzrSW5jo-HTJUGbvX92-F9JL5tkG0YOoAc--tSk-Ov-Sx3LjsiF09roaEhm4JvDg&theme=mn&ddm=0&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ekycautomationtesting@gmail.com");

			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(6000);

			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("NaviaAutomationTesting@24");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(30000);

			driver.findElement(By.xpath("//div[text()='Compose']")).click();
			Thread.sleep(5000);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys("technology@navia.co.in");
			Thread.sleep(5000);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys(Keys.ENTER);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys("kiruthika@navia.co.in");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//div[@data-tooltip='Attach files']")).click();

			Thread.sleep(3000);

			Thread.sleep(5000);

			StringSelection s1 = new StringSelection(
					"C:\\Users\\Venkateshwaran\\git\\repository\\EightFourthFive_Testing\\screenshotbackoffice");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(2000);

			StringSelection s2 = new StringSelection("Backoffice");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s2, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			driver.findElement(By.xpath("//input[@name='subjectbox']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Back Office Error");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@aria-label='Message Body']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@aria-label='Message Body']"))
					.sendKeys("Error in Backoffice Kindly Check and update");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[contains(@data-tooltip,'Send')]")).click();

			Thread.sleep(1000);
			driver.close();
			Thread.sleep(1000);

			driver.switchTo().defaultContent();
			driver.close();

			for (String handle2 : driver.getWindowHandles()) {
				driver.switchTo().window(handle2);
			}

		}

		else {
			List<WebElement> elements = driver.findElements(By.xpath("//table[@id='ReportTable']"));

			for (WebElement webElement : elements) {
				System.err.println(webElement.getText());
			}

			driver.switchTo().defaultContent();
			driver.close();

			for (String handle1 : driver.getWindowHandles()) {
				driver.switchTo().window(handle1);
			}

		}

	}

	
	

	

	@When("User Click Price Alert")
	public void user_click_price_alert() throws InterruptedException {

		driver.findElement(By.xpath("//button[@class='price_alert_dot md_btn1']")).click();

		Thread.sleep(3000);

	}

	@When("User Enter {string} Value")
	public void user_enter_value(String string) throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).clear();

		Thread.sleep(1000);

	}

	@When("User Click {string} script in marketwatch")
	public void user_click_script_in_marketwatch(String string) throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[text()='" + string + "']//preceding-sibling::span[@class='symbolsseries']"))
				.click();
		Thread.sleep(1000);

	}

	@When("User Click {string} in Price Alert")
	public void user_click_in_price_alert(String string) throws InterruptedException {
		Thread.sleep(1000);

		driver.switchTo().frame(0);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//label[text()='" + string + "']")).click();
		Thread.sleep(1000);

	}

	@When("User Enter {string} Value in Price Alert")
	public void user_enter_value_in_price_alert(String string) throws InterruptedException {

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Enter Price']"));

		// Retrieve the value of the 'value' attribute and trim any whitespace
		String attribute = element.getAttribute("value").trim();

		System.out.println(attribute);

		String beforeDecimal = attribute.substring(0, attribute.indexOf('.'));
		System.out.println(beforeDecimal);

		Thread.sleep(2000);

		try {
			// Parse the attribute value to an integer after removing non-numeric characters
			// (if any)
			int modifiedValue = Integer.parseInt(beforeDecimal.replaceAll("[^0-9]", "")) + 5;

			// Convert the modified value back to a string
			String valueOf = String.valueOf(modifiedValue);

			// Clear the existing input and enter the modified value
			driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).sendKeys(valueOf);

			Thread.sleep(1000);

		} catch (NumberFormatException e) {
			System.out.println("Unable to parse the attribute value to an integer: " + attribute);
		}

	}

	@When("User Click Save button")
	public void user_click_save_button() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@value='Save']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(4000);

	}

	@When("User Click lesser than {string} in Price Alert")
	public void user_click_lesser_than_in_price_alert(String string) throws InterruptedException {
		Thread.sleep(2000);

		driver.switchTo().frame(0);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//label[text()='" + string + "']")).click();
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Enter Price']"));

		// Retrieve the value of the 'value' attribute and trim any whitespace
		String attribute = element.getAttribute("value").trim();

		System.out.println(attribute);

		String beforeDecimal = attribute.substring(0, attribute.indexOf('.'));
		System.out.println(beforeDecimal);

		Thread.sleep(2000);

		try {
			// Parse the attribute value to an integer after removing non-numeric characters
			// (if any)
			int modifiedValue = Integer.parseInt(beforeDecimal.replaceAll("[^0-9]", "")) - 5;

			// Convert the modified value back to a string
			String valueOf = String.valueOf(modifiedValue);

			// Clear the existing input and enter the modified value
			driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Enter Price']")).sendKeys(valueOf);

			Thread.sleep(1000);

		} catch (NumberFormatException e) {
			System.out.println("Unable to parse the attribute value to an integer: " + attribute);
		}

	}

	

	@When("User click View and Verify the Margin Stock Data")
	public void user_click_view_and_verify_the_margin_stock_data() throws InterruptedException {

		Thread.sleep(2000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
	}

	

	@When("User click View and Verify the New Position")
	public void user_click_view_and_verify_the_new_position() throws InterruptedException {
		Thread.sleep(3000);
		
		WebElement element2 = driver.findElement(By.xpath("//table[@id='ReportTable']"));
		boolean displayed = element2.isDisplayed();

		System.out.println("Verified the Net Position is Dispalyed : " + displayed);
		driver.switchTo().defaultContent();
		driver.close();
		Thread.sleep(6000);

		Thread.sleep(2000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
	}

	

	@When("User click View and Verify the DP Holdings")
	public void user_click_view_and_verify_the_dp_holdings() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("//table[@id='ReportTable']"));
		boolean displayed = element2.isDisplayed();
		Thread.sleep(2000);

		System.out.println("Verified the DP Holdings is Dispalyed : " + displayed);
		driver.switchTo().defaultContent();
		driver.close();
		Thread.sleep(6000);

		Thread.sleep(2000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
	}



	@When("User click View and Verify the New DP Trans")
	public void user_click_view_and_verify_the_new_dp_trans() throws InterruptedException {
		
		Thread.sleep(4000);
		WebElement element2 = driver.findElement(By.xpath("//table[@id='ReportTable']"));
		Thread.sleep(2000);
		boolean displayed = element2.isDisplayed();
		Thread.sleep(2000);

		System.out.println("Verified the DP Holdings is Dispalyed : " + displayed);
		driver.switchTo().defaultContent();
		driver.close();
		Thread.sleep(6000);

		Thread.sleep(2000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		
	}
	@When("User click the Analysis")
	public void user_click_the_analysis() throws InterruptedException {
		Thread.sleep(2000);
		clickAnElement("//label[text()='Analysis']//parent::a");
		Thread.sleep(2000);
	
	}

	@When("User click filter")
	public void user_click_filter() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
	   
		driver.findElement(By.xpath("//div[@class='filter']")).click();
		Thread.sleep(2000);
	}

	@When("User Filter Dividend {string}")
	public void user_filter_dividend(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebElement slider = driver.findElement(By.xpath("//input[@id='range1']"));

        // Create an Actions instance
        Actions action = new Actions(driver);

        // Drag the slider by a specified offset (for example, 50 pixels to the right)
        action.clickAndHold(slider).moveByOffset(20, 0).release().perform();
		Thread.sleep(2000);

        action.clickAndHold(slider).moveByOffset(-10, 0).release().perform();
		Thread.sleep(2000);

        action.clickAndHold(slider).moveByOffset(10, 0).release().perform();
		Thread.sleep(2000);

	}

	@When("User Filter Value {string}")
	public void user_filter_value(String string) throws InterruptedException {
		Thread.sleep(2000);
		
		WebElement slider = driver.findElement(By.xpath("//input[@id='range2']"));

        // Create an Actions instance
        Actions action = new Actions(driver);

        action.clickAndHold(slider).moveByOffset(20, 0).release().perform();
		Thread.sleep(2000);

        action.clickAndHold(slider).moveByOffset(-10, 0).release().perform();
		Thread.sleep(2000);

        action.clickAndHold(slider).moveByOffset(10, 0).release().perform();
		Thread.sleep(2000);
	}

	@When("User Filter Future {string}")
	public void user_filter_future(String string) throws InterruptedException {
		WebElement slider = driver.findElement(By.xpath("//input[@id='range3']"));

        // Create an Actions instance
        Actions action = new Actions(driver);

        action.clickAndHold(slider).moveByOffset(30, 0).release().perform();
		Thread.sleep(2000);

        action.clickAndHold(slider).moveByOffset(-10, 0).release().perform();
		Thread.sleep(2000);

        action.clickAndHold(slider).moveByOffset(10, 0).release().perform();
		Thread.sleep(2000);
	}

	@When("User Filter Past {string}")
	public void user_filter_past(String string) throws InterruptedException {
		WebElement slider = driver.findElement(By.xpath("//input[@id='range4']"));

        // Create an Actions instance
        Actions action = new Actions(driver);

        // Drag the slider by a specified offset (for example, 50 pixels to the right)
        action.clickAndHold(slider).moveByOffset(20, 0).release().perform();
		Thread.sleep(2000);

        action.clickAndHold(slider).moveByOffset(-10, 0).release().perform();
		Thread.sleep(2000);

        action.clickAndHold(slider).moveByOffset(10, 0).release().perform();
		Thread.sleep(2000);

	}

	@When("User Filter Health {string}")
	public void user_filter_health(String string) throws InterruptedException {
	 
		WebElement slider = driver.findElement(By.xpath("//input[@id='range1']"));

        // Create an Actions instance
        Actions action = new Actions(driver);

        // Drag the slider by a specified offset (for example, 50 pixels to the right)
        action.clickAndHold(slider).moveByOffset(20, 0).release().perform();
		Thread.sleep(3000);

        action.clickAndHold(slider).moveByOffset(-10, 0).release().perform();
		Thread.sleep(2000);

        action.clickAndHold(slider).moveByOffset(10, 0).release().perform();
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//div[@class='filter']")).click();
		Thread.sleep(2000);

	}
	
	@When("User Remove The {string} Stock")
	public void user_remove_the_stock(String string) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]//parent::div"));

		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]//following-sibling::span")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()=' Delete']")).click();
		Thread.sleep(2000);

	}
	
	@When("User Click View More")
	public void user_click_view_more() throws InterruptedException {
	 
	driver.findElement(By.xpath("(//a[@onclick='OpenAnalys(this)'])[1]")).click();
	Thread.sleep(2000);

	driver.switchTo().defaultContent();
	
	WebElement element = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
	
	driver.switchTo().frame(element);
	
	
   WebElement element1 = driver.findElement(By.xpath("//iframe[@id='iframe_any']"));
	
	driver.switchTo().frame(element1);
	
   WebElement element2 = driver.findElement(By.xpath("//iframe[@id='analysis_pro']"));
	
	driver.switchTo().frame(element2);
	
	
	}

	@When("User Scroll Down to the End")
	public void user_scroll_down_to_the_end() throws AWTException, InterruptedException {
		Thread.sleep(2000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_END);
		r.keyRelease(KeyEvent.VK_END);
		Thread.sleep(2000);

	}

	@When("User Click Stock Overview")
	public void user_click_stock_overview() throws InterruptedException {
	    
	
	Thread.sleep(2000);

		
		driver.findElement(By.xpath("//li[text()=' Stock Overview']")).click();
		
	}

	@When("User Click Recent News & Updates")
	public void user_click_recent_news_updates() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	   WebElement element1 = driver.findElement(By.xpath("//iframe[@id='analysis']"));
		
		driver.switchTo().frame(element1);
		
	   WebElement element2 = driver.findElement(By.xpath("//iframe[@id='analysis_pro']"));
	   Thread.sleep(2000);
		driver.switchTo().frame(element2);
	 
		WebElement element = driver.findElement(By.xpath("//li[text()=' Recent News & Updates']"));
		element.click();
		Thread.sleep(2000);
	}

	@When("User Click About the Company")
	public void user_click_about_the_company() {
		driver.findElement(By.xpath("//li[text()=' About the Company']")).click();

	}

	@When("User Click Fundamental Summary")
	public void user_click_fundamental_summary() {
		driver.findElement(By.xpath("//li[text()=' Fundamentals Summary']")).click();;

	}

	@When("User Click Key valuation Music")
	public void user_click_key_valuation_music() {
		driver.findElement(By.xpath("//li[text()=' Key Valuation Metric']")).click();

	}

	@When("User Click Price to earnings ratio vs peers")
	public void user_click_price_to_earnings_ratio_vs_peers() {
		driver.findElement(By.xpath("//li[text()=' Price to Earnings Ratio vs Peers']")).click();

	}

	@When("User Click Price to earnings ratio vs industry")
	public void user_click_price_to_earnings_ratio_vs_industry() {
		driver.findElement(By.xpath("//li[text()=' Price to Earnings Ratio vs Industry']")).click();

	
	}

	@When("User Click Earnings and Revenue History")
	public void user_click_earnings_and_revenue_history() {
		driver.findElement(By.xpath("//li[text()=' Earnings and Revenue History']")).click();

	}

	@When("User Click Past Earnings Growth Earnings")
	public void user_click_past_earnings_growth_earnings() {
		driver.findElement(By.xpath("//li[text()=' Past Earnings Growth Analysis']")).click();

	}

	@When("User Click Return on Equity")
	public void user_click_return_on_equity() {
		driver.findElement(By.xpath("//li[text()=' Return on Equity']")).click();

	}
	
	@When("User Click Ownership")
	public void user_click_ownership() {
	  
		driver.findElement(By.xpath("//li[text()=' Ownership']")).click();

	}

	@When("User Click Leadership Team")
	public void user_click_leadership_team() {
		driver.findElement(By.xpath("//li[text()=' Leadership Team']")).click();

	}

	@When("User Click Management")
	public void user_click_management() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()=' Management']")).click();

	}

	@When("User Click Dividend")
	public void user_click_dividend() {
		driver.findElement(By.xpath("//li[text()=' Dividend']")).click();

	}

	@When("User Click Balance Sheet")
	public void user_click_balance_sheet() {
		driver.findElement(By.xpath("//li[text()=' Balance Sheet']")).click();

	}

	@When("User Click Financial Health")
	public void user_click_financial_health() {
		driver.findElement(By.xpath("//li[text()=' Financial Health']")).click();

	}

	@When("User Click Return on Assets")
	public void user_click_return_on_assets() {
		driver.findElement(By.xpath("//li[text()=' Return on Assets']")).click();

	}
	
	@When("User click Trading View")
	public void user_click_trading_view() throws InterruptedException, AWTException {
		Thread.sleep(2000);

		driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//li[text()='Trading view']")).click();
		
		Thread.sleep(2000);
		
		Thread.sleep(2000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_END);
		r.keyRelease(KeyEvent.VK_END);
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		

	}

	@When("User click the Re-EKyc")
	public void user_click_the_re_e_kyc() {
		clickAnElement("//label[text()='Re-Ekyc']//parent::a");

	}

	@When("Navigate To Home Page to Navia")
	public void navigate_to_home_page_to_navia() throws InterruptedException {
		Thread.sleep(2000);
//		driver.navigate().to("https://rocket.tradeplusonline.com/index.php");
//		Thread.sleep(2000);
		
		driver.navigate().to("https://web.navia.co.in/login.php");
		Thread.sleep(2000);
		
	}


	@Then("Next Page Shown")
	public void next_page_shown() {
	    
		String title = driver.getTitle();
		System.out.println(title);
		
	}

	@When("User Click World Market")
	public void user_click_world_market() {
	   
		driver.findElement(By.xpath("//div[@id='world_market']")).click();
	}
	
	@When("User Select Exchange {string}")
	public void user_select_exchange(String string) throws InterruptedException, AWTException {
		Thread.sleep(1000);

		Thread.sleep(5000);

		String title = driver.getTitle();
		System.out.println(title);

		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		driver.switchTo().window(li1.get(1));

		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");

		WebElement element = driver.findElement(By.xpath("(//div[@class='md-dd-searchbox'])[1]"));
		ac.moveToElement(element).perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//ul[@id='spanSearchList']//descendant::div[contains(text(),'" + string + "')]"))
				.click();
		Thread.sleep(1000);

	}
	
	@When("User Scroll Down and Up")
	public void user_scroll_down_and_up() throws InterruptedException, AWTException {
		Thread.sleep(10000);

		String title = driver.getTitle();
		System.out.println(title);

		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		driver.switchTo().window(li1.get(1));

		Thread.sleep(1000);

	}
	
	@When("User Scroll Down to FAQs")
	public void user_scroll_down_to_fa_qs() throws InterruptedException {
		Thread.sleep(30000);

		String title = driver.getTitle();
		System.out.println(title);

		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		driver.switchTo().window(li1.get(1));

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i <= 5; i++) {
			js.executeScript("window.scrollBy(0, 500)");
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0, 500)");
		}
	}
	
	@When("User Verify Blog Page Loading")
	public void user_verify_blog_page_loading() throws InterruptedException, AWTException {
	   
		  
				Thread.sleep(5000);
				
				driver.switchTo().frame(0);
				
			            // Navigate to the web page

			            // Find all images with the title 'Navia'
			            List<WebElement> images = driver.findElements(By.xpath("//img[@title='Navia']"));

			            // Check if there are at least 3 such images
			            if (images.size() >= 3) {
			                System.out.println("Verify Blog Page is present.");
			            } else {
			                System.out.println("Verify Blog Page is Not Present.");
			            }
			      
				
				Robot robot = new Robot();

				for (int i = 0; i <= 15; i++) {

					robot.keyPress(KeyEvent.VK_DOWN);
					robot.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(1000);

				}
				driver.switchTo().defaultContent();
		
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@When("User getting Securities in Ban Data")
	public void user_getting_securities_in_ban_data() throws InterruptedException {
		Thread.sleep(7000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'ban')]"));

		driver.switchTo().frame(element2);

		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr"));

		for (WebElement webElement : elements) {
			String text = webElement.getText();
			System.err.println("All Securities in Ban Data : " + text);
		}

	}

	@When("User Click Possible Entrance")
	public void user_click_possible_entrance() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Possible Entrance ']//parent::li")).click();

	}

	@When("User Click Possible Exits")
	public void user_click_possible_exits() {

		driver.findElement(By.xpath("//a[text()='Possible Exits']//parent::li")).click();
	}
	
	@When("User Search Symbols {string}")
	public void user_search_symbols(String string) throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='All']//parent::li")).click();

		driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys(string);
		Thread.sleep(2000);

	}

	@When("User Click Clear in Search Symbols")
	public void user_click_clear_in_search_symbols() {
		WebElement textBox = driver.findElement(By.xpath("(//input[@type='search'])[4]"));
		textBox.sendKeys(Keys.BACK_SPACE);
		textBox.sendKeys(Keys.BACK_SPACE);
		textBox.sendKeys(Keys.BACK_SPACE);
		textBox.sendKeys(Keys.BACK_SPACE);
	}

	@When("User Click All and getting data of stock , Previous and Current")
	public void user_click_all_and_getting_data_of_stock_previous_and_current() {

		WebElement lastDate = driver.findElement(By.xpath("//p[contains(text(),'Last')]"));
		String text2 = lastDate.getText();
		System.out.println(text2);

		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='DataTables_Table_3']"));

		for (WebElement webElement : elements) {
			String text = webElement.getText();
			System.err.println("All Ban List Data : " + text);

			driver.switchTo().defaultContent();
		}
	}
	
	@When("User Getting Currency Values for {string}")
	public void user_getting_currency_values_for(String string) throws InterruptedException {

		Thread.sleep(7000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'cross')]"));

		driver.switchTo().frame(element2);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@style='--widget-bg-color: #fff;']/tbody/tr"));

		for (WebElement row : rows) {
			// Fetch th element in the current row
			WebElement thElement = row.findElement(By.tagName("th"));
			String thText = thElement.getText();
			// System.err.println("The Currency Country is : " + thText);

			// Fetch td element at index 5 in the current row
			List<WebElement> tdElements = row.findElements(By.tagName("td"));
			if (tdElements.size() >= 5) {
				WebElement td5Element = tdElements.get(5); // Index is 4 since it's 0-based
				String td5Text = td5Element.getText();
				// System.out.println("TD[5] element text: " + td5Text);
				System.out.println(string + " Currency of " + thText + " is : " + td5Text);
			} else {
				System.out.println("Row does not contain enough TD elements.");
			}

		}
		driver.switchTo().defaultContent();
	}
	
	@When("User Getting forex heat map Values for {string}")
	public void user_getting_forex_heat_map_values_for(String string) throws InterruptedException {
		Thread.sleep(7000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'heat')]"));

		driver.switchTo().frame(element2);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='cross-table__table']/tbody/tr"));

		for (WebElement row : rows) {
			// Fetch th element in the current row
			WebElement thElement = row.findElement(By.tagName("th"));
			String thText = thElement.getText();
			// System.err.println("The Currency Country is : " + thText);

			// Fetch td element at index 5 in the current row
			List<WebElement> tdElements = row.findElements(By.tagName("td"));
			if (tdElements.size() >= 5) {
				WebElement td5Element = tdElements.get(5); // Index is 4 since it's 0-based
				String td5Text = td5Element.getText();
				// System.out.println("TD[5] element text: " + td5Text);
				System.out.println(string + " Forex Heat Map value of " + thText + " is : " + td5Text);
			} else {
				System.out.println("Row does not contain enough TD elements.");
			}

		}
		driver.switchTo().defaultContent();
	}
	
	@When("User Verify Global Page")
	public void user_verify_global_page() throws InterruptedException {
		Thread.sleep(10000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'global')]"));

		driver.switchTo().frame(element2);
		WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'nCoins')])[1]"));
		String text = element.getText();

		if (text.equalsIgnoreCase("nCoins")) {
			System.out.println("Verify the global page loaded Successfully");
		} else {
			System.out.println("Verify the global page is Not loaded");

		}
		driver.switchTo().defaultContent();
		
		
	}
	@When("User Select {string}")
	public void user_select(String string) throws InterruptedException {
		Thread.sleep(4000);

//		WebElement element2 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
//	  
//		driver.switchTo().frame(element2);

		WebElement element3 = driver.findElement(By.xpath("//iframe[contains(@src,'univ.html?theme=Light')]"));

		driver.switchTo().frame(element3);
		Thread.sleep(4000);

		WebElement element = driver
				.findElement(By.xpath("//div[@class='menu_name']//child::h4[text()='" + string + "']"));
		element.click();

	}
	
	@When("Scroll Down and up take Investment Basics Image")
	public void scroll_down_and_up_take_investment_basics_image()
			throws AWTException, InterruptedException, IOException {

		Thread.sleep(17000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'basic')]"));

		driver.switchTo().frame(element2);

		//////////

		//////////

		WebElement element = driver.findElement(By.xpath("//h4[text()='Chapters']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//h3[text()=' No Comments']"));

		jsExecutor.executeScript("arguments[0].scrollIntoView();", element1);
		Thread.sleep(1000);

		WebElement element4 = driver.findElement(By.xpath("//a[text()='Modules']"));

		jsExecutor.executeScript("arguments[0].scrollIntoView();", element4);

		Thread.sleep(5000);

		WebElement topOver = driver.findElement(By.xpath("//span[@id='toTopHover']"));
		topOver.click();

		Thread.sleep(5000);

		WebElement imageElement = driver.findElement(By.xpath("//img[contains(@src,'Banners.png')]"));
		String folderPath = "INVESTMENT BASICS/";

		// Check if the image element is found
		if (imageElement != null) {
			String imageUrl = imageElement.getAttribute("src");

			// Download the image
			URL url = new URL(imageUrl);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();

			// Save the image to a file
			String fileName = folderPath + "image.png";
			FileOutputStream outputStream = new FileOutputStream(fileName);

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.close();
			inputStream.close();

			System.out.println("Image downloaded successfully as " + fileName);
			System.out.println("Verify the size of the INVESTMENT BASICS is Correct");
		} else {
			System.out.println("No INVESTMENT BASICS image found.");
		}

		driver.findElement(By.xpath("//ul[@id='menu-footer']//descendant::a[text()='Modules']")).click();
		Thread.sleep(8000);

		WebElement element5 = driver.findElement(By.xpath("//h2[text()='Customer Support']"));

		jsExecutor.executeScript("arguments[0].scrollIntoView();", element5);

		Thread.sleep(1000);

		WebElement topOver1 = driver.findElement(By.xpath("//span[@id='toTopHover']"));
		topOver1.click();

		/////////////////////
		WebElement element3 = driver.findElement(By.xpath("//ul[@id='menu-footer']//descendant::a[text()='Contact']"));
		element3.click();

		WebElement element8 = driver.findElement(By.xpath("//h2[text()='Customer Support']"));

		jsExecutor.executeScript("arguments[0].scrollIntoView();", element8);

		Thread.sleep(1000);

		WebElement email = driver.findElement(By.xpath("//input[@value='Send Email']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView();", email);
		Thread.sleep(15000);

		WebElement topOver4 = driver.findElement(By.xpath("//span[@id='toTopHover']"));
		topOver4.click();


		////////////////////

		driver.findElement(By.xpath("//ul[@id='menu-footer']//descendant::a[text()='Chapters']")).click();
		Thread.sleep(15000);

		WebElement element6 = driver.findElement(By.xpath("//h2[text()='Customer Support']"));

		jsExecutor.executeScript("arguments[0].scrollIntoView();", element6);

		Thread.sleep(1000);

		WebElement topOver2 = driver.findElement(By.xpath("//span[@id='toTopHover']"));
		topOver2.click();

		Thread.sleep(4000);

		/////////////////

//		driver.findElement(By.xpath("//ul[@id='menu-footer']//descendant::a[text()='Blog']")).click();
//		Thread.sleep(8000);
//		
//		driver.navigate().back();
//		
//		Thread.sleep(12000);
//		
//		WebElement element34 = driver.findElement(By.xpath("//iframe[contains(@src,'basic')]"));
//		  
//		driver.switchTo().frame(element34);

		//////////////////////////
		driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();
		///////////////////////
		Thread.sleep(2000);

		


	}
	
	@When("User Scroll Down and up take Asset Classes Image")
	public void user_scroll_down_and_up_take_asset_classes_image() throws InterruptedException, IOException {

		Thread.sleep(2000);

		driver.switchTo().frame(0);
		
		WebElement element1 = driver.findElement(By.xpath("//div[@class='menu_name']//child::h4[text()='ASSET CLASSES']"));
		element1.click();
		
		
		Thread.sleep(10000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'asset')]"));

		driver.switchTo().frame(element2);

		WebElement imageElement = driver.findElement(By.xpath("//img[contains(@src,'Banners-1.png')]"));
		String folderPath = "ASSET CLASSES/";

		// Check if the image element is found
		if (imageElement != null) {
			String imageUrl = imageElement.getAttribute("src");

			// Download the image
			URL url = new URL(imageUrl);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();

			// Save the image to a file
			String fileName = folderPath + "image.png";
			FileOutputStream outputStream = new FileOutputStream(fileName);

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.close();
			inputStream.close();

			System.out.println("Image downloaded successfully as " + fileName);
			System.out.println("Verify the size of the ASSET CLASSES is Correct");
		} else {
			System.out.println("No ASSET CLASSES image found.");
		}
		
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
	}
	@When("User Scroll Down and up take Investment vehicles Image")
	public void user_scroll_down_and_up_take_investment_vehicles_image() throws InterruptedException, IOException {
		Thread.sleep(2000);

		driver.switchTo().frame(0);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='menu_name']//child::h4[text()='INVESTMENT VEHICLES']"));
		element.click();
		Thread.sleep(7000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'vehicles')]"));

		driver.switchTo().frame(element2);

		WebElement imageElement = driver.findElement(By.xpath("//img[contains(@src,'Banners-2.png')]"));
		String folderPath = "INVESTMENT VEHICLES/";

		// Check if the image element is found
		if (imageElement != null) {
			String imageUrl = imageElement.getAttribute("src");

			// Download the image
			URL url = new URL(imageUrl);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();

			// Save the image to a file
			String fileName = folderPath + "image.png";
			FileOutputStream outputStream = new FileOutputStream(fileName);

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.close();
			inputStream.close();

			System.out.println("Image downloaded successfully as " + fileName);
			System.out.println("Verify the size of the INVESTMENT VEHICLES is Correct");
		} else {
			System.out.println("No INVESTMENT VEHICLES image found.");
		}
		
		driver.switchTo().defaultContent();
	}
	
	@When("User navigate to fundamental analysis page and take  fudamental analysis Image")
	public void user_navigate_to_fundamental_analysis_page_and_take_fudamental_analysis_image()
			throws InterruptedException, IOException {
		
		Thread.sleep(2000);

		driver.switchTo().frame(0);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='menu_name']//child::h4[text()='FUNDAMENTAL ANALYSIS']"));
		element.click();
		
		Thread.sleep(7000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'fundamental')]"));

		driver.switchTo().frame(element2);

		WebElement imageElement = driver.findElement(By.xpath("//img[contains(@src,'Banners-7.png')]"));
		String folderPath = "FUNDAMENTAL ANALYSIS/";

		// Check if the image element is found
		if (imageElement != null) {
			String imageUrl = imageElement.getAttribute("src");

			// Download the image
			URL url = new URL(imageUrl);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();

			// Save the image to a file
			String fileName = folderPath + "image.png";
			FileOutputStream outputStream = new FileOutputStream(fileName);

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.close();
			inputStream.close();

			System.out.println("Image downloaded successfully as " + fileName);
			System.out.println("Verify the size of the FUNDAMENTAL ANALYSIS is Correct");
		} else {
			System.out.println("No FUNDAMENTAL ANALYSIS image found.");
		}
		
		driver.switchTo().defaultContent();
	}
	
	@When("User navigate to technical analysis page and take  Technical analysis Image")
	public void user_navigate_to_technical_analysis_page_and_take_technical_analysis_image()
			throws InterruptedException, IOException {
		
		Thread.sleep(2000);

		driver.switchTo().frame(0);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='menu_name']//child::h4[text()='TECHNICAL ANALYSIS']"));
		element.click();
		
		Thread.sleep(7000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'technical')]"));

		driver.switchTo().frame(element2);

		WebElement imageElement = driver.findElement(By.xpath("//img[contains(@src,'Banners-8.png')]"));
		String folderPath = "TECHNICAL ANALYSIS/";

		// Check if the image element is found
		if (imageElement != null) {
			String imageUrl = imageElement.getAttribute("src");

			// Download the image
			URL url = new URL(imageUrl);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();

			// Save the image to a file
			String fileName = folderPath + "image.png";
			FileOutputStream outputStream = new FileOutputStream(fileName);

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.close();
			inputStream.close();

			System.out.println("Image downloaded successfully as " + fileName);
			System.out.println("Verify the size of the TECHNICAL ANALYSIS is Correct");
		} else {
			System.out.println("No TECHNICAL ANALYSIS image found.");
		}
		
		driver.switchTo().defaultContent();
	}
	
	@When("User navigate to all about option analysis page and take  All About Option Image")
	public void user_navigate_to_all_about_option_analysis_page_and_take_all_about_option_image()
			throws InterruptedException, IOException {
		
		
		Thread.sleep(2000);

		driver.switchTo().frame(0);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='menu_name']//child::h4[text()='ALL ABOUT OPTION']"));
		element.click();
		
		Thread.sleep(7000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'options')]"));

		driver.switchTo().frame(element2);

		WebElement imageElement = driver.findElement(By.xpath("//img[contains(@src,'Banners-6.png')]"));
		String folderPath = "ALL ABOUT OPTION/";

		// Check if the image element is found
		if (imageElement != null) {
			String imageUrl = imageElement.getAttribute("src");

			// Download the image
			URL url = new URL(imageUrl);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();

			// Save the image to a file
			String fileName = folderPath + "image.png";
			FileOutputStream outputStream = new FileOutputStream(fileName);

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.close();
			inputStream.close();

			System.out.println("Image downloaded successfully as " + fileName);
			System.out.println("Verify the size of the ALL ABOUT OPTION is Correct");
		} else {
			System.out.println("No ALL ABOUT OPTION image found.");
		}
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
	}
	
	@When("User navigate to portfolio and strategies page and take  Protfolio and Strategies Image")
	public void user_navigate_to_portfolio_and_strategies_page_and_take_protfolio_and_strategies_image()
			throws InterruptedException, IOException {
		
		Thread.sleep(2000);

		driver.switchTo().frame(0);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='menu_name']//child::h4[text()='PORTFOLIO & STRATEGIES']"));
		element.click();
		
		
		Thread.sleep(10000);

		WebElement element2 = driver.findElement(By.xpath("//iframe[contains(@src,'portfolio')]"));

		driver.switchTo().frame(element2);

		WebElement imageElement = driver.findElement(By.xpath("//img[contains(@src,'Banners-9.png')]"));
		String folderPath = "PORTFOLIO & STRATEGIES/";

		// Check if the image element is found
		if (imageElement != null) {
			String imageUrl = imageElement.getAttribute("src");

			// Download the image
			URL url = new URL(imageUrl);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();

			// Save the image to a file
			String fileName = folderPath + "image.png";
			FileOutputStream outputStream = new FileOutputStream(fileName);

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.close();
			inputStream.close();

			System.out.println("Image downloaded successfully as " + fileName);
			System.out.println("Verify the size of the PORTFOLIO & STRATEGIES is Correct");
		} else {
			System.out.println("No PORTFOLIO & STRATEGIES image found.");
		}

		driver.switchTo().parentFrame();

		driver.findElement(By.xpath("//span[@class='backoption']")).click();

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='menu_list']//descendant::h4"));

		for (WebElement webElement : elements) {
			String text = webElement.getText();
			System.out.println(text);
			System.out.println("Print all the Univ Modules :" + text);
			int size = elements.size();

			if (size == 7) {
				System.out.println("The UNVI Modules Size is equals to Seven");
			} else {
				System.out.println("The UNVI Modules Size is Not equals to Seven");

			}

		}

		driver.switchTo().defaultContent();

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Tools']//ancestor::li")).click();
		driver.switchTo().frame(0);
		WebElement priceAlert = driver
				.findElement(By.xpath("//h4[text()='Price Alert']//ancestor::div[@class='menu_item']"));
		ac.moveToElement(priceAlert).perform();

	}
	
	@When("User Scroll Down and Up Verify Navia App Demo Videos Logo")
	public void user_scroll_down_and_up_verify_navia_app_demo_videos_logo() throws InterruptedException, AWTException {
		Thread.sleep(10000);

		String title = driver.getTitle();
		System.out.println(title);

		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		driver.switchTo().window(li1.get(1));
		Robot robot = new Robot();

		Thread.sleep(1000);
		for (int i = 0; i <= 9; i++) {

			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);

		}

		for (int i = 0; i <= 9; i++) {

			robot.keyPress(KeyEvent.VK_UP);
			robot.keyRelease(KeyEvent.VK_UP);
			Thread.sleep(1000);

		}

		
		driver.close();

		driver.switchTo().window(li1.get(0));

	}

	@When("User get the available for investing , margin used and utilization value")
	public void user_get_the_available_for_investing_margin_used_and_utilization_value() {
	  
	WebElement element = driver.findElement(By.xpath("//input[@aria-label='Available for investing']"));
	String text = element.getAttribute("value");
	System.out.println(text);
	
	WebElement element1 = driver.findElement(By.xpath("//div[@data-cell-id='margin_used']//descendant::input[@type='text']"));
	String text1 = element1.getAttribute("value");
	System.out.println(text1);
	
	
	WebElement element2 = driver.findElement(By.xpath("//div[@data-cell-id='utilization']//descendant::input[@type='text']"));
	String text11 = element2.getAttribute("value");
	System.out.println(text11);
	
	 // Remove the currency symbol and convert to double
    double value1 = Double.parseDouble(text.replace("₹", "").trim());
    double value2 = Double.parseDouble(text1.replace("₹", "").trim());

    // Add the values
    double result = value1 + value2;

    System.out.println("Sum: ₹ " + result); // Output: ₹ 264.0
    

    if (result != 0) {
        double divisionResult1 = value2 / result;
        double percentage = divisionResult1 * 100;

        System.out.println("Value2 divided by Result: " + divisionResult1);
        System.out.println("Percentage (Value2 / Result * 100): " + percentage + "%");
    } else {
        System.out.println("Division by zero is not allowed.");
    }
	
	}


@When("User Check the Stock Market Investment , Current and Overall profits Calculation")
public void user_check_the_stock_market_investment_current_and_overall_profits_calculation() throws InterruptedException {
	
	System.err.println(">>>>>>>>>>>>>>>>>>>>>>>Stock Market<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

	Thread.sleep(5000);

	WebElement element = driver.findElement(By.xpath("//div[@data-dhx-id='Stock_Market']//descendant::div[@data-dhx-col-id='invest']//child::div"));
	String text = element.getText();
	double investmentValue = Double.parseDouble(text); // Removing non-numeric characters if necessary
	System.out.println("The Stock Market Investment Value: " + investmentValue);

	Thread.sleep(5000);
	
	WebElement element1 = driver.findElement(By.xpath("//div[@data-dhx-id='Stock_Market']//descendant::div[@data-dhx-col-id='current']//child::div"));
	String text1 = element1.getText();
	double currentValue = Double.parseDouble(text1); // Removing non-numeric characters if necessary
	System.out.println("The Stock Market Current Value: " + currentValue);
	Thread.sleep(1000);

	// Perform subtraction
	double difference = currentValue - investmentValue;
	System.out.println("The Difference Between Current Value and Investment Value: " + difference);
	Thread.sleep(1000);

	WebElement element2 = driver.findElement(By.xpath("//div[@data-dhx-id='Stock_Market']//descendant::div[@data-dhx-col-id='opl']//child::div"));
	String text2= element2.getText();
	System.out.println("The Stock Market Overall Profits/Loss Value : "+text2);
	Thread.sleep(1000);

	



    // Split the string by space and get the first part
    String valueBeforeSpace = text2.split(" ")[0];

    System.out.println("Extracted Value: " + valueBeforeSpace);
    
    
    String result = valueBeforeSpace.replace("₹", "");

	double overallProfitLoss = Double.parseDouble(result); // Handles negative and decimal numbers
	System.out.println("The Stock Market Overall Profits/Loss Value (Parsed): " + overallProfitLoss);

	
	if ((int) difference == (int) overallProfitLoss) {
	    System.out.println("Verified Overall Profits/Loss: " + overallProfitLoss + " is equal to: currentValue (" + currentValue + ") - investmentValue (" + investmentValue + ") ("+overallProfitLoss+")");
	} else {
	    System.out.println("Verified Overall Profits/Loss: " + overallProfitLoss + " is NOT equal to: currentValue (" + currentValue + ") - investmentValue (" + investmentValue + ") ("+overallProfitLoss+")");
	}
	
	System.err.println(">>>>>>>>>>>>>>>>>>>>>>>Mutual Funds<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

}


@When("User Check the Mutual Funds Investment , Current and Overall profits Calculation")
public void user_check_the_mutual_funds_investment_current_and_overall_profits_calculation() throws InterruptedException {
	Thread.sleep(5000);

	WebElement element = driver.findElement(By.xpath("//div[@data-dhx-id='Mutual_Funds']//descendant::div[@data-dhx-col-id='invest']//child::div"));
	String text = element.getText();
	double investmentValue = Double.parseDouble(text); // Removing non-numeric characters if necessary
	System.out.println("The  Investment Value: " + investmentValue);

	Thread.sleep(5000);
	
	WebElement element1 = driver.findElement(By.xpath("//div[@data-dhx-id='Mutual_Funds']//descendant::div[@data-dhx-col-id='current']//child::div"));
	String text1 = element1.getText();
	double currentValue = Double.parseDouble(text1); // Removing non-numeric characters if necessary
	System.out.println("The Mutual Funds Current Value: " + currentValue);
	Thread.sleep(1000);

	// Perform subtraction
	double difference = currentValue - investmentValue;
	System.out.println("The Difference Between Current Value and Investment Value: " + difference);
	Thread.sleep(1000);

	WebElement element2 = driver.findElement(By.xpath("//div[@data-dhx-id='Mutual_Funds']//descendant::div[@data-dhx-col-id='opl']//child::div"));
	String text2= element2.getText();
	System.out.println("The Mutual Funds Overall Profits/Loss Value : "+text2);
	Thread.sleep(1000);

    // Split the string by space and get the first part
    String valueBeforeSpace = text2.split(" ")[0];

    System.out.println("Extracted Value: " + valueBeforeSpace);
    String result = valueBeforeSpace.replace("₹", "");

	double overallProfitLoss = Double.parseDouble(result); // Handles negative and decimal numbers
	System.out.println("The Mutual Funds Overall Profits/Loss Value (Parsed): " + overallProfitLoss);

	
	if ((int) difference == (int) overallProfitLoss) {
	    System.out.println("Verified Overall Profits/Loss: " + overallProfitLoss + " is equal to: currentValue (" + currentValue + ") - investmentValue (" + investmentValue + ") == ("+overallProfitLoss+")");
	} else {
	    System.out.println("Verified Overall Profits/Loss: " + overallProfitLoss + " is NOT equal to: currentValue (" + currentValue + ") - investmentValue (" + investmentValue + ") ==("+overallProfitLoss+")");
	}
	
	System.err.println(">>>>>>>>>>>>>>>>>>>>Funds<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

}

@Given("User Count and Print The {string} All Stock")
public void user_count_and_print_the_all_stock(String string) throws InterruptedException {
	Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[text()='"+string+"']//parent::button")).click();
	

		List<WebElement> l = driver.findElements(By.xpath("//div[@class='tabs-panel is-active']//descendant::span[@class='symbols']"));
		int size = l.size();
		System.out.println(size);
		Thread.sleep(2000);

		
		int count = 1;
		Set<String> uniqueStocks = new HashSet<>();

		for (WebElement nifty : l) {
		    String text = nifty.getText();
		    
		    // Print with numbering
		    System.out.println(count + ". " + text);
		    // Increment the counter
		    count++;
		    
		   
		}
		

	 
	 
}	 

@When("User Navigate to Backoffice and Click Activity and Verify")
public void user_navigate_to_backoffice_and_click_activity_and_verify() throws InterruptedException, IOException, AWTException {
	Thread.sleep(2000);

	Set<String> windowHandles2 = driver.getWindowHandles();
	ArrayList<String> li = new ArrayList<>(windowHandles2);

	 driver.switchTo().window(li.get(1)).getTitle();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
	try {
	    Boolean titleIsVisible = wait.until(webDriver -> !webDriver.getTitle().isEmpty());
	    if (titleIsVisible) {
	        String title = driver.getTitle();
	        System.out.println(title);
	    } else {
	        System.out.println("Title not visible within timeout.");
	    }
	} catch (WebDriverException e) {
	    System.out.println("An error occurred while waiting for the title: " + e.getMessage());
	}
    String title1 = driver.getTitle();

	if (title1.isEmpty()) {
		Thread.sleep(2000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(
				"C:\\Users\\Venkateshwaran\\git\\repository\\EightFourthFive_Testing\\screenshotbackoffice\\Backoffice.png");
		Files.copy(screenshotAs, des);



			driver.switchTo().defaultContent();

			driver.close();

			Robot robot = new Robot();

			// Press and hold the CTRL key
			robot.keyPress(KeyEvent.VK_CONTROL);
			// Press the N key
			robot.keyPress(KeyEvent.VK_N);

			// Release the N key
			robot.keyRelease(KeyEvent.VK_N);
			// Release the CTRL key
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Switch to the new tab (last opened tab)
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}

			// Navigate to a new URL in the new tab
			driver.get(
					"https://accounts.google.com/InteractiveLogin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=ARZ0qKI-OlL97AHzrSW5jo-HTJUGbvX92-F9JL5tkG0YOoAc--tSk-Ov-Sx3LjsiF09roaEhm4JvDg&theme=mn&ddm=0&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ekycautomationtesting@gmail.com");

			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(6000);

			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("NaviaAutomationTesting@24");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(30000);

			driver.findElement(By.xpath("//div[text()='Compose']")).click();
			Thread.sleep(5000);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys("thangarasu@navia.co.in");
			Thread.sleep(5000);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys(Keys.ENTER);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys("kiruthika@navia.co.in");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//div[@data-tooltip='Attach files']")).click();

			Thread.sleep(3000);

			Thread.sleep(5000);

			StringSelection s1 = new StringSelection(
					"C:\\Users\\Venkateshwaran\\git\\repository\\EightFourthFive_Testing\\screenshotbackoffice");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(2000);

			StringSelection s2 = new StringSelection("Backoffice");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s2, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			driver.findElement(By.xpath("//input[@name='subjectbox']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Back Office Error");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@aria-label='Message Body']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@aria-label='Message Body']"))
					.sendKeys("Error in Backoffice Kindly Check and update");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[contains(@data-tooltip,'Send')]")).click();

			Thread.sleep(1000);
			driver.close();
			Thread.sleep(1000);

			driver.switchTo().defaultContent();
			driver.close();

			for (String handle2 : driver.getWindowHandles()) {
				driver.switchTo().window(handle2);
			}
	
          }

}

@When("User Select world indices , commodities ,  forex or crypto {string}")
public void user_select_world_indices_commodities_forex_or_crypto(String string) throws InterruptedException {

	driver.switchTo().frame(0);
	Thread.sleep(2000);

	driver.findElement(By.xpath("//span[text()='" + string + "']//ancestor::button")).click();
	Thread.sleep(2000);
	
	
}

@When("User Choose 1day , 1month , 3month , 1year , 5year or All {string}")
public void user_choose_1day_1month_3month_1year_5year_or_all(String string) throws InterruptedException {
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	framesHandlingNaviaLogin();

	WebElement element = driver.findElement(By.xpath("(//button[contains(@class,'apply-common-tooltip')]//child::span[contains(@class,'ellipsisContainer')])[5]"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);

	driver.switchTo().defaultContent();
	Thread.sleep(2000);

	driver.findElement(By.xpath("//label[text()='Tools']//parent::a")).click();

}



@When("User enter net quantity {string}")
public void user_enter_net_quantity(String string) throws InterruptedException {
	Thread.sleep(1000);

	WebElement quantity = driver
			.findElement(By.xpath("//div[text()='Net quantity']//parent::div[@class='col']//descendant::input"));
	quantity.sendKeys(string);

}

@When("User Select Buy or Sell {string}")
public void user_select_buy_or_sell(String string) throws InterruptedException {
	Thread.sleep(2000);

	WebElement buyOrSell = driver.findElement(By.xpath("//label[text()='" + string + "']"));
	buyOrSell.click();
}

@When("User Click Add")
public void user_click_add() throws InterruptedException {
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='ADD']")).click();
}

@When("Again User Select Exchange {string}")
public void again_user_select_exchange(String string) throws InterruptedException {
	Thread.sleep(1000);
	WebElement element = driver.findElement(By.xpath("(//div[@class='md-dd-searchbox'])[1]"));
	ac.moveToElement(element).perform();

	driver.findElement(By.xpath("//ul[@id='spanSearchList']//descendant::div[contains(text(),'" + string + "')]"))
			.click();

}

@When("Again User enter net quantity {string}")
public void again_user_enter_net_quantity(String string) throws InterruptedException {
	Thread.sleep(1000);

	WebElement quantity = driver
			.findElement(By.xpath("//div[text()='Net quantity']//parent::div[@class='col']//descendant::input"));
	quantity.sendKeys(string);

}

@When("Again User Select Buy or Sell {string}")
public void again_user_select_buy_or_sell(String string) throws InterruptedException {
	Thread.sleep(1000);

	WebElement buyOrSell = driver.findElement(By.xpath("//label[text()='" + string + "']"));
	buyOrSell.click();

}

@When("Again User Click Add")
public void again_user_click_add() throws InterruptedException {
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='ADD']")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 500)");
	js.executeScript("window.scrollBy(0, 500)");
}

@When("Verify Initial Margin , Exposure margin and Net Premium is equal to total Amount Required")
public void verify_initial_margin_exposure_margin_and_net_premium_is_equal_to_total_amount_required() {

	WebElement initMargin = driver.findElement(By.xpath("//table[@class='table margin-table']/tbody/tr[1]/td"));

	String text = initMargin.getText();
	System.out.println(text);

	text = text.replace(",", "");

	WebElement expoMargin = driver.findElement(By.xpath("//table[@class='table margin-table']/tbody/tr[2]/td"));
	String text1 = expoMargin.getText();
	System.out.println(text1);

	text1 = text1.replace(",", "");

	WebElement netPremimum = driver.findElement(By.xpath("//table[@class='table margin-table']/tbody/tr[3]/td"));
	String text2 = netPremimum.getText();
	System.out.println(text2);

	text2 = text2.replace(",", "");

	WebElement totalAmountRequired = driver
			.findElement(By.xpath("//table[@class='table margin-table']/tbody/tr[4]/td"));
	String text3 = totalAmountRequired.getText();

	System.out.println(text3);
	text3 = text3.replace(",", "");

	double value = Double.parseDouble(text);
	double value1 = Double.parseDouble(text1);
	double value2 = Double.parseDouble(text2);
	double value3 = Double.parseDouble(text3);

	double sum = value + value1 + value2;

	String sumString = Double.toString(sum);

	// Verify if the sum is equal to text3
	if (sumString.equalsIgnoreCase(text3)) {
		System.out.println(
				"Sum of initial margin, exposure margin, and net premium is equal to total amount required.");
	} else {
		System.out.println(
				"Sum of initial margin, exposure margin, and net premium is NOT equal to total amount required.");
	}

	Set<String> windowHandles1 = driver.getWindowHandles();
	ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
	int size = li1.size();
	System.out.println(size);

	driver.close();
	driver.switchTo().window(li1.get(0));

	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//label[text()='Tools']//parent::a")).click();
}

@When("User Verify Shown All API Partners")
public void user_verify_shown_all_api_partners() throws IOException {

	List<WebElement> imageElements = driver.findElements(By
			.xpath("//div[@id='partners']//descendant::img[contains(@src,'https://tradeplusonline.com/images/')]"));
	String folderPath = "Trusted_Partner/";

	// Iterate through each image element
	for (int i = 0; i < imageElements.size(); i++) {
		WebElement imageElement = imageElements.get(i);
		String imageUrl = imageElement.getAttribute("src");

		// Download the image
		URL url = new URL(imageUrl);
		URLConnection connection = url.openConnection();
		InputStream inputStream = connection.getInputStream();

		// Save the image to a file
		String fileName = folderPath + "image_" + i + ".png";
		FileOutputStream outputStream = new FileOutputStream(fileName);

		byte[] buffer = new byte[1024];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		outputStream.close();
		inputStream.close();

		System.out.println("Image downloaded successfully as " + fileName);

	}

	int size = imageElements.size();
	System.out.println("Show all size is :" + size);
	if (size == 9) {
		System.out.println("Verify the size of the Trusted Partner is Correct");
	} else {
		System.out.println("Verify the size of the Trusted Partner is In Correct");

	}
}

@When("User Click Algo-Bridge Verify")
public void user_click_algo_bridge_verify() throws IOException, InterruptedException {

	Thread.sleep(2000);

	driver.findElement(By.xpath("//button[@id='algo-bridge']")).click();

}

@When("User Click BackTesting and Verify")
public void user_click_back_testing_and_verify() {
	
	driver.findElement(By.xpath("//button[@id='backtesting']")).click();

}

@When("User Click Community and Verify")
public void user_click_community_and_verify() {
	
	driver.findElement(By.xpath("//button[@id='community']")).click();

}

@When("User Click Low Code and No Code and Verify")
public void user_click_low_code_and_no_code_and_verify() {
	driver.findElement(By.xpath("//button[@id='low-code-no-code']")).click();

}

@When("User Click Paper Trading and Verify")
public void user_click_paper_trading_and_verify() {
	driver.findElement(By.xpath("//button[@id='paper-trading']")).click();

}

@When("User Click Trading and Verify")
public void user_click_trading_and_verify() {
	driver.findElement(By.xpath("//button[@id='trading']")).click();

}

@When("User Click Other and Verify")
public void user_click_other_and_verify() throws AWTException {
	driver.findElement(By.xpath("//button[@id='other']")).click();

	Robot robot = new Robot();

	robot.keyPress(KeyEvent.VK_UP);
	robot.keyRelease(KeyEvent.VK_UP);

	for (int i = 0; i <= 10; i++) {
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	for (int j = 0; j <= 10; j++) {
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	Set<String> windowHandles1 = driver.getWindowHandles();
	ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
	int size = li1.size();
	System.out.println(size);

	driver.close();

	driver.switchTo().window(li1.get(0));

}

@When("User Select White or Black Theme {string}")
public void user_select_white_or_black_theme(String string) throws InterruptedException {

	Thread.sleep(2000);

	driver.findElement(By.xpath("//label[@class='mode-switch']")).click();
}

@When("User click Plus One by One")
public void user_click_plus_one_by_one() throws InterruptedException, AWTException {

	Thread.sleep(2000);

//	WebElement element = driver.findElement(By.xpath("//iframe[@id='preview-notification-frame']"));
//    driver.switchTo().frame(element);
//	
//	Thread.sleep(2000);
//
//	driver.findElement(By.xpath("(//a[@id='NC_CLOSE_ICON'])[1]")).click();
//
//	driver.switchTo().defaultContent();
//	
	Robot robot = new Robot();

	robot.keyPress(KeyEvent.VK_UP);
	robot.keyRelease(KeyEvent.VK_UP);
	robot.keyPress(KeyEvent.VK_UP);
	robot.keyRelease(KeyEvent.VK_UP);
	robot.keyPress(KeyEvent.VK_UP);
	robot.keyRelease(KeyEvent.VK_UP);
	robot.keyPress(KeyEvent.VK_UP);
	robot.keyRelease(KeyEvent.VK_UP);
	Thread.sleep(2000);

	List<WebElement> plus = driver
			.findElements(By.xpath("//button[@class='accordion wow fadeInUp animated animated']"));

	for (WebElement webElement : plus) {
		webElement.click();
	}
	Thread.sleep(2000);

	robot.keyPress(KeyEvent.VK_UP);
	robot.keyRelease(KeyEvent.VK_UP);
	robot.keyPress(KeyEvent.VK_UP);
	robot.keyRelease(KeyEvent.VK_UP);
	robot.keyPress(KeyEvent.VK_UP);
	robot.keyRelease(KeyEvent.VK_UP);

	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);

	Set<String> windowHandles1 = driver.getWindowHandles();
	ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
	int size = li1.size();
	System.out.println(size);

	driver.close();

	driver.switchTo().window(li1.get(0));

	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//label[text()='Tools']//parent::a")).click();
}

@When("User Select The Email Option")
public void user_select_the_email_option() throws InterruptedException {
    
	Thread.sleep(2000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	clickAnElement("//label[text()='Re-Ekyc']//parent::a");
	
	Thread.sleep(2000);
	Set<String> windowHandles1 = driver.getWindowHandles();
	ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
	int size = li1.size();
	System.out.println(size);

	//Thread.sleep(3000);
	driver.switchTo().window(li1.get(1));
	driver.findElement(By.xpath("//a[text()='Email']//parent::li")).click();
	
	Thread.sleep(2000);
	WebElement element = driver.findElement(By.xpath("//a[text()='Service Status ']//parent::li"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
	
    Thread.sleep(2000);
	
}

@When("User Click The Income Declaration Option")
public void user_click_the_income_declaration_option() throws InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//clickAnElement("//label[text()='Re-Ekyc']//parent::a");
	
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Income Declaration']//parent::li")).click();
	
	Thread.sleep(2000);
	WebElement element = driver.findElement(By.xpath("//a[text()='Service Status ']//parent::li"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
	
    Thread.sleep(2000);
}
@When("User Click The DDPI")
public void user_click_the_ddpi() throws InterruptedException {
   
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//clickAnElement("//label[text()='Re-Ekyc']//parent::a");
	
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='DDPI']//parent::li")).click();
	
	Thread.sleep(3000);
	
	//driver.close();
	
	
	
}

@Given("User Navigate to Navia Live")
public void user_navigate_to_navia_live() throws InterruptedException, AWTException {
	Thread.sleep(2000);
	driver.get("https://yopmail.com/");

	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);

	WebElement yopMail = driver.findElement(By.xpath("//input[@placeholder='Enter your inbox here']"));
	yopMail.sendKeys("naviatesting@yopmail.com");
	

	Thread.sleep(3000);
	driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();

	WebElement createAccount = driver.findElement(By.xpath("//a[@title='YOPmail - Temporary email']"));
	Actions ac = new Actions(driver);
	Thread.sleep(2000);
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
	// getUrl("https://rocket.tradeplusonline.com/beta-v2/login.php");

	sleep(7000);

	// clickOnElement(l.getLoginWithClientCode());
	// driver.navigate().refresh();
	WebElement element6= driver.findElement(By.xpath("(//button[@id='login_fsmt1'])[2]"));
	element6.click();
	sleep(5000);
	//
	driver.findElement(By.xpath("//input[@name='clientCode']")).click();

	sleep(1000);

	sendValues(l.getClientCode(), "63748379");

	clickOnElement(l.getPassWord());
	sleep(1000);

	sendValues(l.getPassWord(), "Testing@321");
	

	clickOnElement(l.getCheckBox());

	clickOnElement(l.getLogin());

	driver.switchTo().window(li.get(0));

	Thread.sleep(32000);

	WebElement refresh = driver.findElement(By.xpath("//button[@id='refresh']"));
	refresh.click();

	WebElement iframe = driver.findElement(By.xpath("//iframe[@id='ifmail']"));

	driver.switchTo().frame(iframe);

	Thread.sleep(5000);

	WebElement otp = driver.findElement(
			By.xpath("//font[text()='Your One Time Password (OTP) for BOLTPlus On Web login is ']//child::strong"));
	String text = otp.getText();
	System.err.println(text);

	driver.switchTo().defaultContent();

	Thread.sleep(4000);

	driver.switchTo().window(li.get(1));
	clickOnElement(l.getOtpClick());
	Thread.sleep(3000);

	driver.findElement(By.xpath("//input[@id='userotp']")).sendKeys(text);

	driver.switchTo().window(li.get(0));

	driver.close();

	driver.switchTo().window(li.get(1));

}


@When("Navigate to home page in Live")
public void navigate_to_home_page_in_live() throws InterruptedException {
    
//	Thread.sleep(2000);
//	driver.navigate().to("https://rocket.tradeplusonline.com/index.php");
//	Thread.sleep(2000);
	
}



















}