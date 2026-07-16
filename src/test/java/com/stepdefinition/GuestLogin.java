package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.baseclass.BaseClass;
import com.pom.Guest_Login_Chart_Minutes_POM;
import com.pom.Guest_Login_Chart_POM;
import com.pom.Guest_Login_POM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuestLogin extends BaseClass {

	Guest_Login_POM p = new Guest_Login_POM(driver);
	Guest_Login_Chart_POM s = new Guest_Login_Chart_POM(driver);
	Guest_Login_Chart_Minutes_POM m = new Guest_Login_Chart_Minutes_POM(driver);

	@Given("User Launch The Url")
	public void user_launch_the_url() throws InterruptedException, AWTException {

		driver.get("https://yopmail.com/");

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		WebElement yopMail = driver.findElement(By.xpath("//input[@placeholder='Enter your inbox here']"));
		yopMail.sendKeys("naviatestingntp@yopmail.com");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='txtlien'])[1]")).click();
		
		try {
		
			driver.findElement(By.xpath("//div[@aria-label='Close ad']")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();

		WebElement createAccount = driver.findElement(By.xpath("//a[@title='YOPmail - Temporary email']"));
		Actions ac = new Actions(driver);
		Thread.sleep(2000);
		ac.contextClick(createAccount).perform();

		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(8000);

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);
		int size = li.size();
		System.out.println(size);

		driver.switchTo().window(li.get(1));

		driver.navigate().refresh();

		//getUrl("https://rocket.tradeplusonline.com/login.php");
		
		getUrl("https://web.navia.co.in/login.php");

		driver.navigate().refresh();

		driver.switchTo().window(li.get(0));

		driver.switchTo().window(li.get(1));

		Thread.sleep(5000);

	}

	@When("User Click The Login As Guest button")
	public void user_click_the_login_as_guest_button() throws InterruptedException {

		//p.getGustLogin().click();
		driver.findElement(By.xpath("(//a[text()='Login as Guest'])[5]")).click();
		Thread.sleep(3000);

	}
	

	@When("User Click The Name")
	public void user_click_the_name() throws InterruptedException {

		p.getName().sendKeys("Kanniappan");
		Thread.sleep(1000);

	}

	@When("User Click The Email")
	public void user_click_the_email() throws InterruptedException {

		p.geteMail().sendKeys("kanniappanbca@gmail.com");
		Thread.sleep(1000);

	}

	@When("User Click The MobileNumber")
	public void user_click_the_mobile_number() throws InterruptedException {

		p.getMobileNumber().sendKeys("6374837965");
		Thread.sleep(1000);

	}

	@When("User Click The Agree Icon")
	public void user_click_the_agree_icon() throws InterruptedException {

		//p.getAgree().click();
		Thread.sleep(1000);

	}

	@When("User Click The Login button in Guest login button")
	public void user_click_the_login_button_in_guest_login_button() throws InterruptedException {

		p.getLogin().click();

		Thread.sleep(12000);

	}

//	@Then("Next Page Shown")
//	public void next_page_shown() {
//
//		toGetTitle();
//
//	}

	@When("User Send The Mobile Otp and Verification")
	public void user_send_the_mobile_otp_and_verification() throws InterruptedException, AWTException {

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);
		int size = li.size();
		System.out.println(size);

		driver.switchTo().window(li.get(0));

		Thread.sleep(14000);
		driver.navigate().refresh();

		driver.switchTo().frame("ifmail");

		WebElement text2 = driver.findElement(By.xpath("//div[@id='mail']"));
		String text3 = text2.getText();

		String otpPattern = "\\b\\d{6}\\b"; // Matches exactly 6 consecutive digits

		// Compile the pattern and create a matcher
		Pattern pattern = Pattern.compile(otpPattern);
		Matcher matcher = pattern.matcher(text3);

		// Check if the OTP is found
		if (matcher.find()) {
			// Extract the OTP
			String otp = matcher.group();
			System.out.println("Extracted OTP: " + otp);

			driver.switchTo().defaultContent();

			driver.switchTo().window(li.get(1));

			driver.findElement(By.xpath("//input[@placeholder='Enter OTP']")).sendKeys(otp);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='login_otp_submit'] ")).click();

			driver.switchTo().window(li.get(0));

			driver.close();

			driver.switchTo().window(li.get(1));
		} else {
			System.out.println("OTP not found in the text.");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(6000);

	}

	@When("User Click The Login button")
	public void user_click_the_login_button() {

	}

	@When("User Click The Profile")
	public void user_click_the_profile() throws InterruptedException {

		s.getProfile().click();
		Thread.sleep(3000);

	}

	@When("User Click The Theme button")
	public void user_click_the_theme_button() throws InterruptedException {

		s.getTheme().click();
		Thread.sleep(2000);

	}

	@When("User Click The Niftyfifty Icon")
	public void user_click_the_niftyfifty_icon() throws InterruptedException {

		s.getNiftyfifty().click();
		Thread.sleep(2000);

	}

	@When("User Click The Chart button")
	public void user_click_the_chart_button() throws InterruptedException {

		s.getChart().click();
		Thread.sleep(8000);

	}

	@When("User Click The Chart Minutes button")
	public void user_click_the_chart_minutes_button() throws InterruptedException {

		framesHandling();
		Thread.sleep(2000);
		m.getMinutesButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Change The Five Minutes Chart Icon")
	public void user_change_the_five_minutes_chart_icon() throws InterruptedException {

		framesHandling();
		Thread.sleep(2000);
		m.getFiveMinutes().click();
		switchToMainFrame();
		Thread.sleep(6000);

	}

	@When("User Change The Fifteen Minutes Chart Icon")
	public void user_change_the_fifteen_minutes_chart_icon() throws InterruptedException {

		framesHandling();
		Thread.sleep(2000);
		m.getMinutesButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		m.getFifteenMinutes().click();
		switchToMainFrame();
		Thread.sleep(6000);

	}

	@When("User Change The One Hour Chart Icon")
	public void user_change_the_one_hour_chart_icon() throws InterruptedException {

		framesHandling();
		Thread.sleep(2000);
		m.getMinutesButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		m.getOneHour().click();
		switchToMainFrame();
		Thread.sleep(6000);

	}

	@When("User Change The One Day Chart Icon")
	public void user_change_the_one_day_chart_icon() throws InterruptedException {

		framesHandling();
		Thread.sleep(2000);
		m.getMinutesButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		m.getOneDay().click();
		switchToMainFrame();
		Thread.sleep(6000);

	}

	@When("User Click The Chart Icon button   #Candles")
	public void user_click_the_chart_icon_button_candles() throws InterruptedException {

		framesHandling();
		s.getChartIconButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Candles Icon button")
	public void user_click_the_candles_icon_button() throws InterruptedException {

		framesHandling();
		s.getCandlesIconbutton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Indicator button")
	public void user_click_the_indicator_button() throws InterruptedException {

		framesHandling();
		s.getIndicatorButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Indicator To Value Send  #Mass Index")
	public void user_click_the_indicator_to_value_send_mass_index() throws InterruptedException {

		framesHandling();
		s.getIndicatorSearchButton().sendKeys("Mass Index");
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getIndicatorValueClickButton().click();
		switchToMainFrame();
		Thread.sleep(4000);

		// framesHandling();
		s.getMassIndexButtonPop().click();
		// switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getIndicatorValueCloseButton().click();
		switchToMainFrame();

		Thread.sleep(2000);

	}

	@When("User Click The Setting button")
	public void user_click_the_setting_button() throws InterruptedException {

		framesHandling();
		s.getSettingButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Color Bars button")
	public void user_click_the_color_bars_button() throws InterruptedException {

		framesHandling();
		s.getColorBars().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Body button")
	public void user_click_the_body_button() throws InterruptedException {

		framesHandling();
		s.getBodyButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Borders button")
	public void user_click_the_borders_button() throws InterruptedException {

		framesHandling();
		s.getBordersButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Wick button")
	public void user_click_the_wick_button() throws InterruptedException {

		framesHandling();
		s.getWickButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Last Price Line button")
	public void user_click_the_last_price_line_button() throws InterruptedException {

		framesHandling();
		s.getLastPriceLine().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

//	@When("User Click The Price button")
//	public void user_click_the_price_button() throws InterruptedException {
//	  
//		framesHandling();
//		s.getPriceButton().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//		
//		framesHandling();
//		s.getPriceButtonValue().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//		
//	}
//
//	@When("User Click The Line button")
//	public void user_click_the_line_button() throws InterruptedException {
//		
//		framesHandling();
//		s.getLineButton().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//		
//		framesHandling();
//		s.getPriceButtonValue().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//
//	}
//
//	@When("User Click The Fill button")
//	public void user_click_the_fill_button() throws InterruptedException {
//		
//		framesHandling();
//		s.getFillButton().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//		
//		framesHandling();
//		s.getFillButtonValue().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//	    
//	}
//
//	@When("User Click The LastLine button")
//	public void user_click_the_last_line_button() throws InterruptedException {
//	   
//		framesHandling();
//		s.getLastLineButton().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//	}

	@When("User Click The HighAndLowPrice button")
	public void user_click_the_high_and_low_price_button() throws InterruptedException {

		framesHandling();
		s.getHighAndLowPriceButton().click();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Precision button")
	public void user_click_the_precision_button() throws InterruptedException {

		framesHandling();

		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,500)");
		pageUpandDown.executeScript("window.scrollBy(0,500)");

//		WebElement element = driver.findElement(By.xpath("//span[text()='Precision']"));
//		js.executeAsyncScript("arguments[0].scrollIntoView();", element);
//		

//		js.executeScript("window.scrollBy(0, 500)");
//		js.executeScript("window.scrollBy(0, 500)");

//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
		switchToMainFrame();

		framesHandling();
		s.getPrecisionButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getPrecisionButtonValue().click();

		pageUpandDown.executeScript("window.scrollBy(0,500)");
		pageUpandDown.executeScript("window.scrollBy(0,500)");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The TimeZone button")
	public void user_click_the_time_zone_button() throws InterruptedException {

		framesHandling();
		s.getTimeZoneButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getTimeZoneButtonValue().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@Then("User Click The SymbolOkey button")
	public void user_click_the_symbol_okey_button() throws InterruptedException {

		framesHandling();
		s.getSymbolOkey().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@Then("User Again Check Setting button")
	public void user_again_check_setting_button() throws InterruptedException {

		framesHandling();
		s.getSettingButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Status Line button")
	public void user_click_the_status_line_button() throws InterruptedException {

		framesHandling();
		s.getStatusLineButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Symbol button")
	public void user_click_the_symbol_button() throws InterruptedException {

		framesHandling();
		s.getSymbol().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getSymbolButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getSymbolButtonValue().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Open Market Status button")
	public void user_click_the_open_market_status_button() throws InterruptedException {

		framesHandling();
		s.getOpenMarketStatus().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The OHLC Value button")
	public void user_click_the_ohlc_value_button() throws InterruptedException {

		framesHandling();
		s.getOHLCValueButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Bar Value Change button")
	public void user_click_the_bar_value_change_button() throws InterruptedException {

		framesHandling();
		s.getBarValueChange().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Volume button Disable")
	public void user_click_the_volume_button_disable() throws InterruptedException {

		framesHandling();
		s.getVolumeButtonDisable().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Indicator Titles button")
	public void user_click_the_indicator_titles_button() throws InterruptedException {

		framesHandling();
		s.getIndicatorTitles().click();
		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Indicator Arguments button")
	public void user_click_the_indicator_arguments_button() throws InterruptedException {

		framesHandling();
		s.getIndicatorArguments().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Indicator Value button")
	public void user_click_the_indicator_value_button() throws InterruptedException {

		framesHandling();
		s.getIndicatorValue().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Status Background button")
	public void user_click_the_status_background_button() throws InterruptedException {

		framesHandling();
		s.getStatusBackground().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@Then("User Click The StatusOkey button")
	public void user_click_the_status_okey_button() throws InterruptedException {

		framesHandling();
		s.getStatusOkey().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Again Check Setting button In Scales")
	public void user_again_check_setting_button_in_scales() throws InterruptedException {

		framesHandling();
		s.getSettingButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Scales button")
	public void user_click_the_scales_button() throws InterruptedException {

		framesHandling();
		s.getScalesButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Symbol Label button")
	public void user_click_the_symbol_label_button() throws InterruptedException {

		framesHandling();
		s.getSymbolLabelButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Symbol Last Price  button")
	public void user_click_the_symbol_last_price_button() throws InterruptedException {

		framesHandling();
		s.getSymbolLastPrice().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getSymbolLastPriceValue().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The High and Low button")
	public void user_click_the_high_and_low_button() throws InterruptedException {

		framesHandling();
		s.getHighAndLowButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click the Indicator Name button")
	public void user_click_the_indicator_name_button() throws InterruptedException {

		framesHandling();
		s.getIndicatorNameButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Indicator Value Label button")
	public void user_click_the_indicator_value_label_button() throws InterruptedException {

		framesHandling();
		s.getIndicatorValueLabel().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The No Overlapping Label button")
	public void user_click_the_no_overlapping_label_button() throws InterruptedException {

		framesHandling();
		s.getNoOverlappingLabel().click();
		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Countdown Bar Close button")
	public void user_click_the_countdown_bar_close_button() throws InterruptedException {

		framesHandling();
		s.getBarCloseButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click the Indicator Lock Price To Bar Ratio button")
	public void user_click_the_indicator_lock_price_to_bar_ratio_button() throws InterruptedException, AWTException {

		framesHandling();
		s.getLockPriceBarRatio().click();
		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getLockPriceBarRatioTextButton().click();

		for (int i = 1; i <= 10; i++) {

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);

		}
		// s.getLockPriceBarRatioTextButton().clear();
		s.getLockPriceBarRatioTextButton().sendKeys("72.0");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click the Indicator Scales Placement button")
	public void user_click_the_indicator_scales_placement_button() throws InterruptedException {

		framesHandling();
		s.getScalesPlacementButton().click();
		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getScalesPlacementButtonValue().click();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click the Indicator Date Format button")
	public void user_click_the_indicator_date_format_button() throws InterruptedException {

		framesHandling();
		s.getDateFormatButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getDateFormatButtonValue().click();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@Then("User Click The ScalesOkey button")
	public void user_click_the_scales_okey_button() throws InterruptedException {

		framesHandling();
		s.getScalesOkey().click();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Again Click The Setting button")
	public void user_again_click_the_setting_button() throws InterruptedException {

		framesHandling();
		s.getSettingButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Apperance button")
	public void user_click_the_apperance_button() throws InterruptedException {

		framesHandling();
		s.getApperanceButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Background button")
	public void user_click_the_background_button() throws InterruptedException {

		framesHandling();
		s.getBackgroundButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getBackgroundValueButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Very Grid Lines button")
	public void user_click_the_very_grid_lines_button() throws InterruptedException {

		framesHandling();
		s.getVeryGridLines().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getVeryGridLinesValue().click();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Horz Grid lines button")
	public void user_click_the_horz_grid_lines_button() throws InterruptedException {

		framesHandling();
		s.getHorzGridLines().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getHorzGridLinesValue().click();
		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getTemplate().click();
		switchToMainFrame();
		Thread.sleep(2000);
	}

//	@When("User Click The Session Breaks button")
//	public void user_click_the_session_breaks_button() throws InterruptedException {
//	   
//		framesHandling();
//		s.getSessionBreaks().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//		
//	}

	@When("User Click The Scales Text button")
	public void user_click_the_scales_text_button() throws InterruptedException {

		framesHandling();

//		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
//		pageUpandDown.executeAsyncScript("arguments[0].click();", s.getScalesTextButton());

		s.getScalesTextButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();

		// pageUpandDown.executeAsyncScript("arguments[0].click();",
		// s.getScalesTextButtonValue());
		s.getScalesTextButtonValue().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Scales Lines button")
	public void user_click_the_scales_lines_button() throws InterruptedException {

		framesHandling();
		s.getScalesLinesButton().click();
		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getScalesLinesButtonValue().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getTemplate().click();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Crosshair button")
	public void user_click_the_crosshair_button() throws InterruptedException {

		framesHandling();
		s.getCrosshairButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getCrosshairButtonValue().click();
		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Watermark button")
	public void user_click_the_watermark_button() throws InterruptedException {

		framesHandling();
		s.getWatermarkButton().click();
		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Navigation button")
	public void user_click_the_navigation_button() throws InterruptedException {

		framesHandling();
		s.getNavigationButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getNavigationButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The pane button")
	public void user_click_the_pane_button() throws InterruptedException {

		framesHandling();
		s.getPaneButton().click();
		switchToMainFrame();
		Thread.sleep(2000);

		framesHandling();
		s.getPaneButtonValue().click();
		JavascriptExecutor pageUpandDown = (JavascriptExecutor) driver;
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		pageUpandDown.executeScript("window.scrollBy(0,1000)");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Top Margin button")
	public void user_click_the_top_margin_button() throws InterruptedException, AWTException {

		framesHandling();
		s.getTopMargin().click();

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		// s.getTopMargin().clear();
		s.getTopMargin().sendKeys("5");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Bottom Margin button")
	public void user_click_the_bottom_margin_button() throws InterruptedException, AWTException {

		framesHandling();
		s.getBottomMargin().click();

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		// s.getBottomMargin().clear();
		s.getBottomMargin().sendKeys("5");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Right Margin button")
	public void user_click_the_right_margin_button() throws InterruptedException, AWTException {

		framesHandling();
		s.getRightMargin().click();
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		// s.getRightMargin().clear();
		s.getRightMargin().sendKeys("5");
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The ApperanceOkey  button")
	public void user_click_the_apperance_okey_button() throws InterruptedException {

		framesHandling();
		s.getApperanceOkey().click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

//	@When("User Click The Template button")
//	public void user_click_the_template_button() throws InterruptedException {
//
//		framesHandling();
//		s.getTemplateButton().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//
//		framesHandling();
//		s.getTemplateValueButton().click();
//		switchToMainFrame();
//		Thread.sleep(2000);
//
//	}

//	@When("User Click The Save button")
//	public void user_click_the_save_button() throws InterruptedException {
//
//		m.getSaveButton().click();
//		switchToParentFrame();
//		switchToMainFrame();
//		Thread.sleep(2000);
//
//	}

	@When("User Click The New Chart Layout button")
	public void user_click_the_new_chart_layout_button() throws InterruptedException, AWTException {

		// m.getChartLayoutButton().sendKeys("Test");
		// driver.findElement(By.xpath("//div[@data-name='rename-dialog']//descendant::span[@tabindex='0']")).click();

		Robot v = new Robot();

		v.keyPress(KeyEvent.VK_T);
		v.keyRelease(KeyEvent.VK_T);

		v.keyPress(KeyEvent.VK_E);
		v.keyRelease(KeyEvent.VK_E);

		v.keyPress(KeyEvent.VK_S);
		v.keyRelease(KeyEvent.VK_S);

		v.keyPress(KeyEvent.VK_T);
		v.keyRelease(KeyEvent.VK_T);

		m.getSaveButtonClick().click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Manage Chart Layout button")
	public void user_click_the_manage_chart_layout_button() throws InterruptedException {

		m.getManageChartLayout().click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Rename button")
	public void user_click_the_rename_button() throws InterruptedException, AWTException {

		m.getRenameButton().click();

		Thread.sleep(2000);

		// m.getRenameButtonValue().sendKeys("Navia");
		Robot v = new Robot();

		v.keyPress(KeyEvent.VK_N);
		v.keyRelease(KeyEvent.VK_N);

		v.keyPress(KeyEvent.VK_A);
		v.keyRelease(KeyEvent.VK_A);

		v.keyPress(KeyEvent.VK_V);
		v.keyRelease(KeyEvent.VK_V);

		v.keyPress(KeyEvent.VK_I);
		v.keyRelease(KeyEvent.VK_I);

		v.keyPress(KeyEvent.VK_A);
		v.keyRelease(KeyEvent.VK_A);

		m.getRenameButtonValueSave().click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Again Click The Manage Chart Layout button")
	public void user_again_click_the_manage_chart_layout_button() throws InterruptedException {

		m.getRenameButton().click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Copy Chart Layout button")
	public void user_click_the_copy_chart_layout_button() throws InterruptedException {

		m.getCopyChartLayout().click();

		Thread.sleep(2000);

		m.getCopyChartLayoutSave().click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Again Manage Chart Layout button")
	public void user_click_the_again_manage_chart_layout_button() throws InterruptedException {

		m.getAgainManageChartLayoutButton().click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Load Layout button")
	public void user_click_the_load_layout_button() throws InterruptedException {

		m.getLoadLayoutButton().click();

		Thread.sleep(2000);

		m.getLoadLayoutButtonValue().sendKeys("Navia");
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@Then("User Click The Load Layout Close button")
	public void user_click_the_load_layout_close_button() throws InterruptedException {

		m.getLoadLayoutButtonValueClose().click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Chart Size Window One button")
	public void user_click_the_chart_size_window_one_button() throws InterruptedException {

		s.getWindowSizeOne().click();
		Thread.sleep(2000);

	}

	@When("User Click The Chart Size Window Two button")
	public void user_click_the_chart_size_window_two_button() throws InterruptedException {

		s.getWindowSizeTwo().click();
		Thread.sleep(2000);

	}

	@When("User Click The Chart Size Window Three button")
	public void user_click_the_chart_size_window_three_button() throws InterruptedException {

		s.getWindowSizeThree().click();
		Thread.sleep(2000);

	}

	@When("User Click The Chart Size Window Maximum button")
	public void user_click_the_chart_size_window_maximum_button() throws InterruptedException {

		framesHandling();
		s.getWindowMaximumSize().click();
		switchToMainFrame();
		Thread.sleep(7000);

	}

	@When("User Click The Chart Close button")
	public void user_click_the_chart_close_button() throws InterruptedException, AWTException {

		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);

	}

	@When("Navigate To Home Page Guest Login")
	public void navigate_to_home_page_guest_login() throws InterruptedException {

		//driver.navigate().to("https://rocket.tradeplusonline.com/index.php");
		driver.navigate().to("https://web.navia.co.in/index.php");
		Thread.sleep(2000);

	}

	@When("Navigate To Frames For Chart")
	public void navigate_to_frames_for_chart() throws InterruptedException {

		framesHandling();
		Thread.sleep(2000);

	}

	@When("User Click Camera Icon")
	public void user_click_camera_icon() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='button-1SoiPS-f apply-common-tooltip'])[2]")).click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Save Chart Image")
	public void user_click_the_save_chart_image() throws InterruptedException {

		driver.findElement(By.xpath("//div[text()='Save chart image']")).click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Copy Chart Image")
	public void user_click_the_copy_chart_image() throws InterruptedException {

		driver.findElement(By.xpath("//div[text()='Copy chart image']")).click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The Copy Link To Chart Image")
	public void user_click_the_copy_link_to_chart_image() throws InterruptedException {

		driver.findElement(By.xpath("//div[@data-name='copy-chart-image']")).click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The Open Image In New Tab")
	public void user_click_the_open_image_in_new_tab() throws InterruptedException {

		driver.findElement(By.xpath("//div[@data-name='open-image-in-new-tab']")).click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(3000);
	}

	@When("User Click The Current Window Tab")
	public void user_click_the_current_window_tab() throws InterruptedException {

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(windowHandles);
		int size = li.size();
		System.out.println(size);

		driver.switchTo().window(li.get(0));
		Thread.sleep(3000);

	}

	@When("User Click The Tweet Chart Image")
	public void user_click_the_tweet_chart_image() throws InterruptedException {

		driver.findElement(By.xpath("//div[@data-name='tweet-chart-image']")).click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@Then("User Close The Tweet Chart")
	public void user_close_the_tweet_chart() {

		WebElement tweeter = driver.findElement(By.xpath("//div[@data-testid='mask']"));

		if (tweeter.isDisplayed()) {

			System.out.println("Working");

		}

		else {

			System.out.println("Not Working");
		}

		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

	}

	@When("User Click Dropdown")
	public void user_click_dropdown() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='nifty_st indices_2 down'])[1]")).click();
		Thread.sleep(2000);

	}

	@When("User Mouseover {string} Click The Chart")
	public void user_mouseover_click_the_chart(String string) throws InterruptedException {

		driver.findElement(
				By.xpath("//div[@class='select-box active']//descendant::span[@data-symbol='" + string + "']")).click();
		Thread.sleep(2000);

	}

	@When("User Click The Data Range {string}")
	public void user_click_the_data_range(String string) throws InterruptedException {

		driver.findElement(By.xpath("//div[@data-name='date-ranges-tabs']//descendant::div[text()='" + string + "']"))
				.click();
		switchToParentFrame();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@Then("User Close The Data Ranges Tab")
	public void user_close_the_data_ranges_tab() {

		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

	}

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Guest Login<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	@When("User Click The {string} button")
	public void user_click_the_button(String string) throws InterruptedException {

		driver.findElement(
				By.xpath("//div[@class='dhx_layout-cell-content']//descendant::div/h4[text()='" + string + "']"))
				.click();
		Thread.sleep(2000);

	}

	@When("User Click The Back To Deshboard")
	public void user_click_the_back_to_deshboard() throws InterruptedException {

		driver.findElement(
				By.xpath("//div[@class='dhx_layout-cell-inner_html']//descendant::span/img[@src='images/back.svg']"))
				.click();
		Thread.sleep(2000);

	}

	@When("User Click The Popup {string}")
	public void user_click_the_popup(String string) throws InterruptedException {
		
		WebElement popup = driver.findElement(By.xpath("//div[@class='jconfirm-content']"));
		
		if (popup.isDisplayed()) {

			System.err.println("Verify");

		}

		else {

			System.err.println("Not Verify");
		}


		driver.findElement(By.xpath("//button[text()='" + string + "']")).click();
		Thread.sleep(2000);
	}

	@When("User Click The {string} Options")
	public void user_click_the_options(String string) throws InterruptedException {

		driver.findElement(By.xpath("//ul[@id='example-tabs']//descendant::span[text()='" + string + "']")).click();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Options                #Dashboard,Pending Orders,Trades,Position,Holdings,Activity")
	public void user_click_the_options_dashboard_pending_orders_trades_position_holdings_activity(String string)
			throws InterruptedException {
		driver.findElement(By.xpath("//ul[@id='example-tabs']//descendant::span[text()='" + string + "']")).click();
		Thread.sleep(2000);
	}

	@When("User Click The {string} Equities Options")
	public void user_click_the_equities_options(String string) throws InterruptedException {

		driver.switchTo().frame("stocks_iframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[@class='dhx_widget dhx_layout dhx_layout-columns']//descendant::span[text()='" + string + "']"))
				.click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Topbar Header")
	public void user_click_the_topbar_header(String string) throws InterruptedException {

		driver.switchTo().frame("stocks_iframe");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//ul[@class='top dhx_tabbar-header ']//descendant::button[@aria-controls='"+string+"']"))
				.click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} ETFs Options")
	public void user_click_the_et_fs_options(String string) throws InterruptedException {

		driver.switchTo().frame("stocks_iframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[@class='dhx_widget dhx_layout dhx_layout-columns']//descendant::span[text()='" + string + "']"))
				.click();
		switchToMainFrame();
		Thread.sleep(2000);

	}

	@When("User Click The {string} Futures Options")
	public void user_click_the_futures_options(String string) throws InterruptedException {
		
		driver.switchTo().frame("stocks_iframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[@class='dhx_widget dhx_layout dhx_layout-columns']//descendant::span[text()='" + string + "']"))
				.click();
		switchToMainFrame();
		Thread.sleep(2000);
		
	}
	
	@When("User Click The {string} Currency Options")
	public void user_click_the_currency_options(String string) throws InterruptedException {
	    
		driver.switchTo().frame("stocks_iframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[@class='dhx_widget dhx_layout dhx_layout-columns']//descendant::span[text()='" + string + "']"))
				.click();
		switchToMainFrame();
		Thread.sleep(2000);
	}

	@When("User Click The {string} Options Value")
	public void user_click_the_options_value(String string) throws InterruptedException {
	    
		driver.switchTo().frame("stocks_iframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[@class='dhx_widget dhx_layout dhx_layout-columns']//descendant::span[text()='" + string + "']"))
				.click();
		switchToMainFrame();
		Thread.sleep(2000);
	}
	
	@When("User Click The {string} Commodities Options")
	public void user_click_the_commodities_options(String string) throws InterruptedException {
	    
		driver.switchTo().frame("stocks_iframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[@class='dhx_widget dhx_layout dhx_layout-columns']//descendant::span[text()='" + string + "']"))
				.click();
		switchToMainFrame();
		Thread.sleep(2000);
		
	}

	@When("User Click {string} The Stock")
	public void user_click_the_stock(String string) throws InterruptedException {
	    
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[text()='"+string+"']//preceding-sibling::span[text()='NSE']")).click();

//	    WebElement element = driver.findElement(By.xpath("//div[@class='m_bg_color']//ancestor::ul[@class='list ui-sortable']//descendant::span[text()='"+string+"']"));
//	    element.click();
	    
	    Thread.sleep(2000);
	}

	@When("I should see an Popup message")
	public void i_should_see_an_popup_message() throws InterruptedException {
	    
 WebElement element = driver.findElement(By.xpath("//div[text()='You need to open account to activate this feature. ']"));
		
		if (element.isDisplayed()) {
			
			System.err.println("verify the pop up is displayed");
			
		} else {

			System.err.println("verify the not pop up is displayed");
		}
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@role='dialog']//descendant::button[text()='ok']")).click();
		
		Thread.sleep(2000);
		
		
	}
	
	@When("I should see an Popup messageAnd User Click {string} The Stock")
	public void i_should_see_an_popup_message_and_user_click_the_stock(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User Click the Sell scrip for Selected {string} Scrip")
	public void user_click_the_sell_scrip_for_selected_scrip(String string) throws InterruptedException {
	    
		WebElement buyScript = driver.findElement(By.xpath(
				"//span[text()='" + string + "']//ancestor::div[@class='m_bg_color']//descendant::span[text()='S']"));
		buyScript.click();
		
		Thread.sleep(2000);
		
	}

	@When("I should see an Popup message to Stock")
	public void i_should_see_an_popup_message_to_stock() throws InterruptedException {
	   
      WebElement element = driver.findElement(By.xpath("//div[@aria-labelledby='jconfirm-box57864']"));
 
        String text = element.getText();
		
		if (text.contains(text)) {
			
			System.err.println("verify the pop up is displayed");
			
		} else {

			System.err.println("verify the not pop up is displayed");
		}
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("///button[text()='ok']")).click();
		
		Thread.sleep(2000);
	}

	@When("User Click The Stock")
	public void user_click_the_stock() throws AWTException, InterruptedException {
	   
		Robot r =new Robot();
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
	}
	
	@When("User Click The Dashboard Options {string} button")
	public void user_click_the_dashboard_options_button(String string) throws InterruptedException {
	    
		
		driver.findElement(By.xpath("//aside[@class='left_nav']//descendant::label[text()='"+string+"']")).click();
		Thread.sleep(2000);
	   
	}
	
	@When("User Click The Topbar Header Options {string} button")
	public void user_click_the_topbar_header_options_button(String string) throws InterruptedException {
	    
		Thread.sleep(4000);
//		WebElement element = driver.findElement(By.xpath("(//span[text()='"+string+"'])[1]"));
//		js.executeScript("arguments[0].click();", element);
		
		WebElement name=driver.findElement(By.xpath("//ul[@class='top dhx_tabbar-header ']//descendant::span[text()='"+string+"']//parent::button"));
		name.click();
		Thread.sleep(2000);
		
	}
	
	@When("User Click the Chart scrip for Selected {string} Scrip")
	public void user_click_the_chart_scrip_for_selected_scrip(String string) throws InterruptedException {
	   
		Thread.sleep(5000);
		
		WebElement buyScript = driver.findElement(By.xpath(
				//"//span[text()='"+string+"']//ancestor::div[@class='m_bg_color']//descendant::lable[text()='Chart(C)']"));
				"//span[text()='"+string+"']//ancestor::div[@class='m_bg_color']//descendant::lable[text()='Chart(C)']//parent::span"));
		buyScript.click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();
		
		Thread.sleep(2000);
		
	}
	
	@When("User Click The Topbar Header Options {string} Arrow")
	public void user_click_the_topbar_header_options_arrow(String string) throws InterruptedException {
	   
		
		WebElement name=driver.findElement(By.xpath("//div[@class='mw_tab_box']//descendant::div[@mode='"+string+"']"));
		name.click();
		Thread.sleep(2000);
		
		
	}


	@When("Navigate to Guest Login home page")
	public void navigate_to_guest_login_home_page() {
	    
		driver.navigate().to("https://rocket.tradeplusonline.com/login.php");
		
	}

	
	@When("User mouses over the scrip {string}")
	public void user_mouses_over_the_scrip(String string) throws InterruptedException {
		
		Thread.sleep(2000);Thread.sleep(2000);
		WebElement contractSelectAgain = driver.findElement(
				By.xpath("//div[@class='select-box active']//descendant::li//span[text()='" + string + "']"));

		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		ac.moveToElement(contractSelectAgain).perform();
		
		driver.findElement(By.xpath("(//span[@data-symbol='Nifty 50']//child::img)[2]")).click();

		Thread.sleep(2000);
		
	}
	
	
	
	
	
	
	
	

}
