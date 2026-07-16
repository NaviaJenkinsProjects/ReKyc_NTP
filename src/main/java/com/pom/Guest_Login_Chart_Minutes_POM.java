package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guest_Login_Chart_Minutes_POM {
	
	public WebDriver driver;
	
	@FindBy (xpath = "//iframe[@class='iframe_window']")
	private WebElement firstFrame;
	
	@FindBy (xpath = "//div[@id='header-toolbar-intervals']")
	private WebElement minutesButton;  
	
	@FindBy (xpath = "//div[text()='5 minutes']")
	private WebElement fiveMinutes;
	
	@FindBy (xpath = "//div[text()='15 minutes']")
	private WebElement fifteenMinutes;

	@FindBy (xpath = "//div[text()='1 hour']")
	private WebElement oneHour;
	
	@FindBy (xpath = "//div[text()='1 day']")
	private WebElement oneDay;
	
	
	@FindBy (xpath = "//div[@id='header-toolbar-save-load']")
	private WebElement saveButton;
	
	@FindBy (xpath = "//span[@tabindex='0']")
	private WebElement chartLayoutButton;
	
	@FindBy (xpath = "//button[@name='save']")
	private WebElement saveButtonClick;
	
	@FindBy (xpath = "(//div[@class='arrow-1SoiPS-f'])[2]")
	private WebElement manageChartLayout;
	
	@FindBy (xpath = "//div[text()='Rename…']")
	private WebElement renameButton;
	
	@FindBy (xpath = "//span[@tabindex='0']")
	private WebElement renameButtonValue;
	
	
	@FindBy (xpath = "//span[text()='Save']")
	private WebElement renameButtonValueSave;
	
	@FindBy (xpath = "(//div[@class='arrow-1SoiPS-f'])[2]")
	private WebElement againManageChartLayout;
	
	@FindBy (xpath = "//div[text()='Make a Copy…']")
	private WebElement copyChartLayout;
	
	@FindBy (xpath = "//span[text()='Save']")
	private WebElement copyChartLayoutSave;
	
	@FindBy (xpath = "(//div[@class='arrow-1SoiPS-f'])[2]")
	private WebElement againManageChartLayoutButton;
	
	@FindBy (xpath = "//div[text()='Load Chart Layout…']")
	private WebElement loadLayoutButton;
	
	@FindBy (xpath = "//input[@class='input-3n5_2-hI']")
	private WebElement loadLayoutButtonValue;
	
	@FindBy (xpath = "//span[@data-name='close']")
	private WebElement loadLayoutButtonValueClose;
	
	
	
	
	
	
	
	
	
	
	

	public Guest_Login_Chart_Minutes_POM(WebDriver driver2) {
		
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
		
	}

	public WebElement getMinutesButton() {
		return minutesButton;
	}

	public void setMinutesButton(WebElement minutesButton) {
		this.minutesButton = minutesButton;
	}

	public WebElement getFiveMinutes() {
		return fiveMinutes;
	}

	public void setFiveMinutes(WebElement fiveMinutes) {
		this.fiveMinutes = fiveMinutes;
	}

	public WebElement getFifteenMinutes() {
		return fifteenMinutes;
	}

	public void setFifteenMinutes(WebElement fifteenMinutes) {
		this.fifteenMinutes = fifteenMinutes;
	}

	public WebElement getOneHour() {
		return oneHour;
	}

	public void setOneHour(WebElement oneHour) {
		this.oneHour = oneHour;
	}

	public WebElement getOneDay() {
		return oneDay;
	}

	public void setOneDay(WebElement oneDay) {
		this.oneDay = oneDay;
	}

	public WebElement getFirstFrame() {
		return firstFrame;
	}

	public void setFirstFrame(WebElement firstFrame) {
		this.firstFrame = firstFrame;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(WebElement saveButton) {
		this.saveButton = saveButton;
	}

	public WebElement getChartLayoutButton() {
		return chartLayoutButton;
	}

	public void setChartLayoutButton(WebElement chartLayoutButton) {
		this.chartLayoutButton = chartLayoutButton;
	}

	public WebElement getSaveButtonClick() {
		return saveButtonClick;
	}

	public void setSaveButtonClick(WebElement saveButtonClick) {
		this.saveButtonClick = saveButtonClick;
	}

	public WebElement getManageChartLayout() {
		return manageChartLayout;
	}

	public void setManageChartLayout(WebElement manageChartLayout) {
		this.manageChartLayout = manageChartLayout;
	}

	public WebElement getRenameButton() {
		return renameButton;
	}

	public void setRenameButton(WebElement renameButton) {
		this.renameButton = renameButton;
	}

	public WebElement getRenameButtonValue() {
		return renameButtonValue;
	}

	public void setRenameButtonValue(WebElement renameButtonValue) {
		this.renameButtonValue = renameButtonValue;
	}

	public WebElement getRenameButtonValueSave() {
		return renameButtonValueSave;
	}

	public void setRenameButtonValueSave(WebElement renameButtonValueSave) {
		this.renameButtonValueSave = renameButtonValueSave;
	}

	public WebElement getAgainManageChartLayout() {
		return againManageChartLayout;
	}

	public void setAgainManageChartLayout(WebElement againManageChartLayout) {
		this.againManageChartLayout = againManageChartLayout;
	}

	public WebElement getCopyChartLayout() {
		return copyChartLayout;
	}

	public void setCopyChartLayout(WebElement copyChartLayout) {
		this.copyChartLayout = copyChartLayout;
	}

	public WebElement getCopyChartLayoutSave() {
		return copyChartLayoutSave;
	}

	public void setCopyChartLayoutSave(WebElement copyChartLayoutSave) {
		this.copyChartLayoutSave = copyChartLayoutSave;
	}

	public WebElement getAgainManageChartLayoutButton() {
		return againManageChartLayoutButton;
	}

	public void setAgainManageChartLayoutButton(WebElement againManageChartLayoutButton) {
		this.againManageChartLayoutButton = againManageChartLayoutButton;
	}

	public WebElement getLoadLayoutButton() {
		return loadLayoutButton;
	}

	public void setLoadLayoutButton(WebElement loadLayoutButton) {
		this.loadLayoutButton = loadLayoutButton;
	}

	public WebElement getLoadLayoutButtonValue() {
		return loadLayoutButtonValue;
	}

	public void setLoadLayoutButtonValue(WebElement loadLayoutButtonValue) {
		this.loadLayoutButtonValue = loadLayoutButtonValue;
	}

	public WebElement getLoadLayoutButtonValueClose() {
		return loadLayoutButtonValueClose;
	}

	public void setLoadLayoutButtonValueClose(WebElement loadLayoutButtonValueClose) {
		this.loadLayoutButtonValueClose = loadLayoutButtonValueClose;
	}

	
	
	
	

}
