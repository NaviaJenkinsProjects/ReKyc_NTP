package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guest_Login_Chart_POM {
	
	public WebDriver driver;
	
	@FindBy (xpath = "//div[@class='user-profile dpd ']")
	private WebElement profile;
	
	@FindBy (xpath = "//li[@class='Light']")
	private WebElement theme;

	@FindBy (xpath = "(//div[@data-id='2'])[1]")
	private WebElement niftyfifty;
	
	@FindBy (xpath = "(//div[@data-id='2'])[2]")
	private WebElement chart;
	
	
	
	@FindBy (xpath = "//div[@id='header-toolbar-chart-styles']")
	private WebElement chartIconButton;
	
	@FindBy (xpath = "//div[text()='Candles']")
	private WebElement candlesIconbutton;

	@FindBy (xpath = "//div[@id='header-toolbar-indicators']")
	private WebElement indicatorButton;
	
	@FindBy (xpath = "//input[@data-role='search']")
	private WebElement indicatorSearchButton;
	
	@FindBy (xpath = "//div[@data-id='Mass Index@tv-basicstudies']")
	private WebElement indicatorValueClickButton;
	
	@FindBy (xpath = "//span[@data-role='button']")
	private WebElement  indicatorValueCloseButton;
	
	@FindBy (xpath="//button[text()='ok']")
	private WebElement massIndexButtonPop;
	
	@FindBy (xpath = "//button[@data-dhx-id='columngrid']")
	private WebElement windowSizeOne;

	@FindBy (xpath = "//button[@data-dhx-id='rowgrid']")
	private WebElement windowSizeTwo;
	
	@FindBy (xpath = "//button[@data-dhx-id='grid']")
	private WebElement windowSizeThree;
	
	@FindBy (xpath = "(//div[@class='group-3uonVBsm'])[10]")
	private WebElement windowMaximumSize;
	
	
	
	@FindBy (xpath = "(//div[@class='group-3uonVBsm'])[9]")
	private WebElement settingButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[1]")
	private WebElement colorBars;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[2]")
	private WebElement bodyButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[3]")
	private WebElement bordersButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[4]")
	private WebElement wickButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[5]")
	private WebElement lastPriceLine;
	
	@FindBy (xpath = "//span[@id='id_mainSeriesSymbolAreaPriceSource_options-dropdown']")
	private WebElement priceButton;

	@FindBy (xpath = "//div[@id='price-source-high']")
	private WebElement priceButtonValue;
	
	@FindBy (xpath = "(//div[@data-name='color-with-thickness-select'])[1]")
	private WebElement lineButton;
	
	@FindBy (xpath = "//div[@class='swatch-vBKBthtD white-vBKBthtD']")
	private WebElement lineButtonValue;
	
	@FindBy (xpath = "(//div[@data-name='color-select'])[2]")
	private WebElement fillButton;
	
	@FindBy (xpath = "//div[@class='swatch-vBKBthtD selected-vBKBthtD']")
	private WebElement fillButtonValue;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[1]")
	private WebElement lastLineButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[6]")
	private WebElement highAndLowPriceButton;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_candleSymbolMinTick_options-dropdown']")
	private WebElement precisionButton;
	
	@FindBy (xpath = "//span[text()='Precision']")
	private WebElement precision;
	
	@FindBy (xpath = "//div[text()='1/1000000']")
	private WebElement precisionButtonValue;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_candleSymbolTimezone_options-dropdown']")
	private WebElement timeZoneButton;
	
	@FindBy (xpath = "//div[text()='(UTC+7) Bangkok']")
	private WebElement timeZoneButtonValue;   //
	
	@FindBy (xpath = "//button[@name='submit']")
	private WebElement symbolOkey;
	
	@FindBy (xpath = "//span[text()='Status line']")
	private WebElement statusLineButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[1]")
	private WebElement Symbol;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_symbolTextSource_options-dropdown']")
	private WebElement symbolButton;
	
	@FindBy (xpath = "//div[text()='Ticker and description']")
	private WebElement symbolButtonValue;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[2]")
	private WebElement openMarketStatus;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[3]")
	private WebElement OHLCValueButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[4]")
	private WebElement barValueChange;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[5]")
	private WebElement volumeButtonDisable;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[6]")
	private WebElement indicatorTitles;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[7]")
	private WebElement indicatorArguments;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[8]")
	private WebElement indicatorValue;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[9]")
	private WebElement statusBackground ;
	
	@FindBy (xpath = "//button[@name='submit']")
	private WebElement StatusOkey ;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_symbolLastValueLabel_options-dropdown']")
	private WebElement symbolLastPrice ;
	
	@FindBy (xpath = "//div[text()='Price and percentage value']")
	private WebElement symbolLastPriceValue ;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[5]")
	private WebElement volumeButton;
	
	@FindBy (xpath = "//span[text()='Scales']")
	private WebElement scalesButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[1]")
	private WebElement  symbolLabelButton;
	
	@FindBy (xpath="(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[3]")
	private WebElement highAndLowButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[4]")
	private WebElement indicatorNameButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[5]")
	private WebElement indicatorValueLabel;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[6]")
	private WebElement noOverlappingLabel;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[7]")
	private WebElement barCloseButton;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[8]")
	private WebElement lockPriceBarRatio;
	
	@FindBy (xpath = "(//span[@tabindex='0'])[2]")
	private WebElement lockPriceBarRatioTextButton;
	
	@FindBy (xpath = "//span[text()='Appearance']")
	private WebElement lockPriceBarRatioTextValueButton;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_scalesPlacement_options-dropdown']")
	private WebElement scalesPlacementButton;
	
	@FindBy (xpath = "(//div[@class='label-2IihgTnv'])[1]")
	private WebElement scalesPlacementButtonValue;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_dateFormat_options-dropdown']")
	private WebElement dateFormatButton;
	
	@FindBy (xpath = "//div[text()='29-09-1997']")
	private WebElement dateFormatButtonValue;
	
	@FindBy (xpath = "//span[text()='Ok']")
	private WebElement scalesOkey;
	
	@FindBy (xpath = "//span[text()='Appearance']")
	private WebElement apperanceButton;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_chartBackground_background-type-options-dropdown']")
	private WebElement backgroundButton;
	
	@FindBy (xpath = "//div[@aria-selected='false']")
	private WebElement backgroundValueButton;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_vertGridLine_line-style-select']")
	private WebElement veryGridLines;
	
	@FindBy (xpath = "//div[text()='Dotted line']")
	private WebElement veryGridLinesValue;
	
	@FindBy (xpath = "(//div[@data-name='color-select'])[4]")
	private WebElement horzGridLines;
	
	@FindBy (xpath = "(//div[@class='swatch-vBKBthtD'])[9]")
	private WebElement horzGridLinesValue;
	
	@FindBy (xpath = "(//input[@name='toggle-enabled'])[1]")
	private WebElement sessionBreaks;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_scalesText_font-size-select']")
	private WebElement scalesTextButton;
	
	@FindBy (xpath = "//div[text()='16']")
	private WebElement scalesTextButtonValue;
	
	@FindBy (xpath = "(//div[@class='colorPickerWrap-3gSLMlhu intent-default-3gSLMlhu border-thin-3gSLMlhu size-medium-3gSLMlhu'])[6]")
	private WebElement scalesLinesButton;
	
	@FindBy (xpath = "(//div[@class='swatch-vBKBthtD'])[11]")
	private WebElement scalesLinesButtonValue;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_crossHair_line-style-select']")
	private WebElement crosshairButton;
	
	@FindBy (xpath = "//div[text()='Dotted line']")
	private WebElement crosshairButtonValue;
	
	@FindBy (xpath = "(//label[@class='checkbox-FNjK79Y1 checkbox-2jiVkfto baseline-2jiVkfto'])[2]")
	private WebElement watermarkButton;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_navButtons_options-dropdown']")
	private WebElement navigationButton;
	
	@FindBy (xpath = "//div[text()='Always visible']")
	private WebElement navigationButtonvalue;
	
	@FindBy (xpath = "//span[@aria-labelledby='id_paneButtons_options-dropdown']")
	private WebElement paneButton;
	
	@FindBy (xpath = "//div[text()='Always invisible']")
	private WebElement paneButtonValue;
	
	@FindBy (xpath = "(//span[@tabindex='0'])[8]")
	private WebElement topMargin;
	
	@FindBy (xpath = "(//span[@tabindex='0'])[9]")
	private WebElement bottomMargin;
	
	@FindBy (xpath = "(//span[@tabindex='0'])[10]")
	private WebElement rightMargin;
	
	@FindBy (xpath = "//span[text()='Ok']")
	private WebElement apperanceOkey;
	
	
	
	@FindBy (xpath = "//span[@id='series-theme-manager']")
	private WebElement templateButton;
	
	@FindBy (xpath = "//div[text()='Apply defaults']")
	private WebElement templateValueButton;
	
	@FindBy (xpath = "//span[text()='Ok']")
	private WebElement okButton; 
	
	@FindBy (xpath = "//span[@data-name='theme-select']")
	private WebElement Template;
	
	
	
	
	
	
	@FindBy (xpath = "(//div[@data-id='2'])[2]")
	private WebElement chartWindowClose;
	

	public Guest_Login_Chart_POM(WebDriver driver2) {
		
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
		
	}

	public WebElement getProfile() {
		return profile;
	}

	public void setProfile(WebElement profile) {
		this.profile = profile;
	}

	public WebElement getTheme() {
		return theme;
	}

	public void setTheme(WebElement theme) {
		this.theme = theme;
	}

	public WebElement getNiftyfifty() {
		return niftyfifty;
	}

	public void setNiftyfifty(WebElement niftyfifty) {
		this.niftyfifty = niftyfifty;
	}

	public WebElement getChart() {
		return chart;
	}

	public void setChart(WebElement chart) {
		this.chart = chart;
	}

	public WebElement getChartIconButton() {
		return chartIconButton;
	}

	public void setChartIconButton(WebElement chartIconButton) {
		this.chartIconButton = chartIconButton;
	}

	public WebElement getCandlesIconbutton() {
		return candlesIconbutton;
	}

	public void setCandlesIconbutton(WebElement candlesIconbutton) {
		this.candlesIconbutton = candlesIconbutton;
	}

	public WebElement getIndicatorButton() {
		return indicatorButton;
	}

	public void setIndicatorButton(WebElement indicatorButton) {
		this.indicatorButton = indicatorButton;
	}

	public WebElement getIndicatorSearchButton() {
		return indicatorSearchButton;
	}

	public void setIndicatorSearchButton(WebElement indicatorSearchButton) {
		this.indicatorSearchButton = indicatorSearchButton;
	}

	public WebElement getIndicatorValueSendButton() {
		return indicatorValueClickButton;
	}

	public void setIndicatorValueSendButton(WebElement indicatorValueSendButton) {
		this.indicatorValueClickButton = indicatorValueSendButton;
	}

	public WebElement getIndicatorValueClickButton() {
		return indicatorValueClickButton;
	}

	public void setIndicatorValueClickButton(WebElement indicatorValueClickButton) {
		this.indicatorValueClickButton = indicatorValueClickButton;
	}

	public WebElement getMassIndexButtonPop() {
		return massIndexButtonPop;
	}

	public void setMassIndexButtonPop(WebElement massIndexButtonPop) {
		this.massIndexButtonPop = massIndexButtonPop;
	}

	public WebElement getWindowSizeOne() {
		return windowSizeOne;
	}

	public void setWindowSizeOne(WebElement windowSizeOne) {
		this.windowSizeOne = windowSizeOne;
	}

	public WebElement getWindowSizeTwo() {
		return windowSizeTwo;
	}

	public void setWindowSizeTwo(WebElement windowSizeTwo) {
		this.windowSizeTwo = windowSizeTwo;
	}

	public WebElement getWindowSizeThree() {
		return windowSizeThree;
	}

	public void setWindowSizeThree(WebElement windowSizeThree) {
		this.windowSizeThree = windowSizeThree;
	}

	public WebElement getWindowMaximumSize() {
		return windowMaximumSize;
	}

	public void setWindowMaximumSize(WebElement windowMaximumSize) {
		this.windowMaximumSize = windowMaximumSize;
	}

	public WebElement getChartWindowClose() {
		return chartWindowClose;
	}

	public void setChartWindowClose(WebElement chartWindowClose) {
		this.chartWindowClose = chartWindowClose;
	}

	public WebElement getIndicatorValueCloseButton() {
		return indicatorValueCloseButton;
	}

	public void setIndicatorValueCloseButton(WebElement indicatorValueCloseButton) {
		this.indicatorValueCloseButton = indicatorValueCloseButton;
	}

	public WebElement getSettingButton() {
		return settingButton;
	}

	public void setSettingButton(WebElement settingButton) {
		this.settingButton = settingButton;
	}

	public WebElement getPrecisionButton() {
		return precisionButton;
	}

	public void setPrecisionButton(WebElement precisionButton) {
		this.precisionButton = precisionButton;
	}

	public WebElement getPrecisionButtonValue() {
		return precisionButtonValue;
	}

	public void setPrecisionButtonValue(WebElement precisionButtonValue) {
		this.precisionButtonValue = precisionButtonValue;
	}

	public WebElement getStatusLineButton() {
		return statusLineButton;
	}

	public void setStatusLineButton(WebElement statusLineButton) {
		this.statusLineButton = statusLineButton;
	}

	public WebElement getSymbolButton() {
		return symbolButton;
	}

	public void setSymbolButton(WebElement symbolButton) {
		this.symbolButton = symbolButton;
	}

	public WebElement getScalesButton() {
		return scalesButton;
	}

	public void setScalesButton(WebElement scalesButton) {
		this.scalesButton = scalesButton;
	}

	public WebElement getSymbolLabelButton() {
		return symbolLabelButton;
	}

	public void setSymbolLabelButton(WebElement symbolLabelButton) {
		this.symbolLabelButton = symbolLabelButton;
	}

	public WebElement getHighAndLowButton() {
		return highAndLowButton;
	}

	public void setHighAndLowButton(WebElement highAndLowButton) {
		this.highAndLowButton = highAndLowButton;
	}

	public WebElement getIndicatorNameButton() {
		return indicatorNameButton;
	}

	public void setIndicatorNameButton(WebElement indicatorNameButton) {
		this.indicatorNameButton = indicatorNameButton;
	}

	public WebElement getApperanceButton() {
		return apperanceButton;
	}

	public void setApperanceButton(WebElement apperanceButton) {
		this.apperanceButton = apperanceButton;
	}

	public WebElement getBackgroundButton() {
		return backgroundButton;
	}

	public void setBackgroundButton(WebElement backgroundButton) {
		this.backgroundButton = backgroundButton;
	}

	public WebElement getBackgroundValueButton() {
		return backgroundValueButton;
	}

	public void setBackgroundValueButton(WebElement backgroundValueButton) {
		this.backgroundValueButton = backgroundValueButton;
	}

	public WebElement getTemplateButton() {
		return templateButton;
	}

	public void setTemplateButton(WebElement templateButton) {
		this.templateButton = templateButton;
	}

	public WebElement getTemplateValueButton() {
		return templateValueButton;
	}

	public void setTemplateValueButton(WebElement templateValueButton) {
		this.templateValueButton = templateValueButton;
	}

	public WebElement getOkButton() {
		return okButton;
	}

	public void setOkButton(WebElement okButton) {
		this.okButton = okButton;
	}

	

	public WebElement getPrecision() {
		return precision;
	}

	public void setPrecision(WebElement precision) {
		this.precision = precision;
	}

	public WebElement getVolumeButton() {
		return volumeButton;
	}

	public void setVolumeButton(WebElement volumeButton) {
		this.volumeButton = volumeButton;
	}

	public WebElement getPriceButton() {
		return priceButton;
	}

	public void setPriceButton(WebElement priceButton) {
		this.priceButton = priceButton;
	}

	public WebElement getPriceButtonValue() {
		return priceButtonValue;
	}

	public void setPriceButtonValue(WebElement priceButtonValue) {
		this.priceButtonValue = priceButtonValue;
	}

	public WebElement getLineButton() {
		return lineButton;
	}

	public void setLineButton(WebElement lineButton) {
		this.lineButton = lineButton;
	}

	public WebElement getLineButtonValue() {
		return lineButtonValue;
	}

	public void setLineButtonValue(WebElement lineButtonValue) {
		this.lineButtonValue = lineButtonValue;
	}

	public WebElement getFillButton() {
		return fillButton;
	}

	public void setFillButton(WebElement fillButton) {
		this.fillButton = fillButton;
	}

	public WebElement getFillButtonValue() {
		return fillButtonValue;
	}

	public void setFillButtonValue(WebElement fillButtonValue) {
		this.fillButtonValue = fillButtonValue;
	}

	public WebElement getLastLineButton() {
		return lastLineButton;
	}

	public void setLastLineButton(WebElement lastLineButton) {
		this.lastLineButton = lastLineButton;
	}

	public WebElement getHighAndLowPriceButton() {
		return highAndLowPriceButton;
	}

	public void setHighAndLowPriceButton(WebElement highAndLowPriceButton) {
		this.highAndLowPriceButton = highAndLowPriceButton;
	}

	public WebElement getTimeZoneButton() {
		return timeZoneButton;
	}

	public void setTimeZoneButton(WebElement timeZoneButton) {
		this.timeZoneButton = timeZoneButton;
	}

	public WebElement getTimeZoneButtonValue() {
		return timeZoneButtonValue;
	}

	public void setTimeZoneButtonValue(WebElement timeZoneButtonValue) {
		this.timeZoneButtonValue = timeZoneButtonValue;
	}

	public WebElement getSymbolOkey() {
		return symbolOkey;
	}

	public void setSymbolOkey(WebElement symbolOkey) {
		this.symbolOkey = symbolOkey;
	}

	public WebElement getSymbolButtonValue() {
		return symbolButtonValue;
	}

	public void setSymbolButtonValue(WebElement symbolButtonValue) {
		this.symbolButtonValue = symbolButtonValue;
	}

	public WebElement getOpenMarketStatus() {
		return openMarketStatus;
	}

	public void setOpenMarketStatus(WebElement openMarketStatus) {
		this.openMarketStatus = openMarketStatus;
	}

	public WebElement getOHLCValueButton() {
		return OHLCValueButton;
	}

	public void setOHLCValueButton(WebElement oHLCValueButton) {
		OHLCValueButton = oHLCValueButton;
	}

	public WebElement getBarValueChange() {
		return barValueChange;
	}

	public void setBarValueChange(WebElement barValueChange) {
		this.barValueChange = barValueChange;
	}

	public WebElement getVolumeButtonDisable() {
		return volumeButtonDisable;
	}

	public void setVolumeButtonDisable(WebElement volumeButtonDisable) {
		this.volumeButtonDisable = volumeButtonDisable;
	}

	public WebElement getIndicatorTitles() {
		return indicatorTitles;
	}

	public void setIndicatorTitles(WebElement indicatorTitles) {
		this.indicatorTitles = indicatorTitles;
	}

	public WebElement getIndicatorArguments() {
		return indicatorArguments;
	}

	public void setIndicatorArguments(WebElement indicatorArguments) {
		this.indicatorArguments = indicatorArguments;
	}

	public WebElement getIndicatorValue() {
		return indicatorValue;
	}

	public void setIndicatorValue(WebElement indicatorValue) {
		this.indicatorValue = indicatorValue;
	}

	public WebElement getStatusBackground() {
		return statusBackground;
	}

	public void setStatusBackground(WebElement statusBackground) {
		this.statusBackground = statusBackground;
	}

	public WebElement getStatusOkey() {
		return StatusOkey;
	}

	public void setStatusOkey(WebElement statusOkey) {
		StatusOkey = statusOkey;
	}

	public WebElement getColorBars() {
		return colorBars;
	}

	public void setColorBars(WebElement colorBars) {
		this.colorBars = colorBars;
	}

	public WebElement getBodyButton() {
		return bodyButton;
	}

	public void setBodyButton(WebElement bodyButton) {
		this.bodyButton = bodyButton;
	}

	public WebElement getBordersButton() {
		return bordersButton;
	}

	public void setBordersButton(WebElement bordersButton) {
		this.bordersButton = bordersButton;
	}

	public WebElement getWickButton() {
		return wickButton;
	}

	public void setWickButton(WebElement wickButton) {
		this.wickButton = wickButton;
	}

	public WebElement getLastPriceLine() {
		return lastPriceLine;
	}

	public void setLastPriceLine(WebElement lastPriceLine) {
		this.lastPriceLine = lastPriceLine;
	}

	public WebElement getSymbol() {
		return Symbol;
	}

	public void setSymbol(WebElement symbol) {
		Symbol = symbol;
	}

	public WebElement getSymbolLastPrice() {
		return symbolLastPrice;
	}

	public void setSymbolLastPrice(WebElement symbolLastPrice) {
		this.symbolLastPrice = symbolLastPrice;
	}

	public WebElement getSymbolLastPriceValue() {
		return symbolLastPriceValue;
	}

	public void setSymbolLastPriceValue(WebElement symbolLastPriceValue) {
		this.symbolLastPriceValue = symbolLastPriceValue;
	}



	public WebElement getIndicatorValueLabel() {
		return indicatorValueLabel;
	}

	public void setIndicatorValueLabel(WebElement indicatorValueLabel) {
		this.indicatorValueLabel = indicatorValueLabel;
	}

	public WebElement getNoOverlappingLabel() {
		return noOverlappingLabel;
	}

	public void setNoOverlappingLabel(WebElement noOverlappingLabel) {
		this.noOverlappingLabel = noOverlappingLabel;
	}

	public WebElement getBarCloseButton() {
		return barCloseButton;
	}

	public void setBarCloseButton(WebElement barCloseButton) {
		this.barCloseButton = barCloseButton;
	}

	public WebElement getLockPriceBarRatio() {
		return lockPriceBarRatio;
	}

	public void setLockPriceBarRatio(WebElement lockPriceBarRatio) {
		this.lockPriceBarRatio = lockPriceBarRatio;
	}

	public WebElement getLockPriceBarRatioTextButton() {
		return lockPriceBarRatioTextButton;
	}

	public void setLockPriceBarRatioTextButton(WebElement lockPriceBarRatioTextButton) {
		this.lockPriceBarRatioTextButton = lockPriceBarRatioTextButton;
	}

	public WebElement getLockPriceBarRatioTextValueButton() {
		return lockPriceBarRatioTextValueButton;
	}

	public void setLockPriceBarRatioTextValueButton(WebElement lockPriceBarRatioTextValueButton) {
		this.lockPriceBarRatioTextValueButton = lockPriceBarRatioTextValueButton;
	}

	public WebElement getScalesPlacementButton() {
		return scalesPlacementButton;
	}

	public void setScalesPlacementButton(WebElement scalesPlacementButton) {
		this.scalesPlacementButton = scalesPlacementButton;
	}

	public WebElement getScalesPlacementButtonValue() {
		return scalesPlacementButtonValue;
	}

	public void setScalesPlacementButtonValue(WebElement scalesPlacementButtonValue) {
		this.scalesPlacementButtonValue = scalesPlacementButtonValue;
	}

	public WebElement getDateFormatButton() {
		return dateFormatButton;
	}

	public void setDateFormatButton(WebElement dateFormatButton) {
		this.dateFormatButton = dateFormatButton;
	}

	public WebElement getDateFormatButtonValue() {
		return dateFormatButtonValue;
	}

	public void setDateFormatButtonValue(WebElement dateFormatButtonValue) {
		this.dateFormatButtonValue = dateFormatButtonValue;
	}

	public WebElement getScalesOkey() {
		return scalesOkey;
	}

	public void setScalesOkey(WebElement scalesOkey) {
		this.scalesOkey = scalesOkey;
	}

	public WebElement getVeryGridLines() {
		return veryGridLines;
	}

	public void setVeryGridLines(WebElement veryGridLines) {
		this.veryGridLines = veryGridLines;
	}

	public WebElement getVeryGridLinesValue() {
		return veryGridLinesValue;
	}

	public void setVeryGridLinesValue(WebElement veryGridLinesValue) {
		this.veryGridLinesValue = veryGridLinesValue;
	}

	public WebElement getHorzGridLines() {
		return horzGridLines;
	}

	public void setHorzGridLines(WebElement horzGridLines) {
		this.horzGridLines = horzGridLines;
	}

	public WebElement getHorzGridLinesValue() {
		return horzGridLinesValue;
	}

	public void setHorzGridLinesValue(WebElement horzGridLinesValue) {
		this.horzGridLinesValue = horzGridLinesValue;
	}

	public WebElement getSessionBreaks() {
		return sessionBreaks;
	}

	public void setSessionBreaks(WebElement sessionBreaks) {
		this.sessionBreaks = sessionBreaks;
	}

	public WebElement getScalesTextButton() {
		return scalesTextButton;
	}

	public void setScalesTextButton(WebElement scalesTextButton) {
		this.scalesTextButton = scalesTextButton;
	}

	public WebElement getScalesTextButtonValue() {
		return scalesTextButtonValue;
	}

	public void setScalesTextButtonValue(WebElement scalesTextButtonValue) {
		this.scalesTextButtonValue = scalesTextButtonValue;
	}

	public WebElement getScalesLinesButton() {
		return scalesLinesButton;
	}

	public void setScalesLinesButton(WebElement scalesLinesButton) {
		this.scalesLinesButton = scalesLinesButton;
	}

	public WebElement getScalesLinesButtonValue() {
		return scalesLinesButtonValue;
	}

	public void setScalesLinesButtonValue(WebElement scalesLinesButtonValue) {
		this.scalesLinesButtonValue = scalesLinesButtonValue;
	}

	public WebElement getCrosshairButton() {
		return crosshairButton;
	}

	public void setCrosshairButton(WebElement crosshairButton) {
		this.crosshairButton = crosshairButton;
	}

	public WebElement getCrosshairButtonValue() {
		return crosshairButtonValue;
	}

	public void setCrosshairButtonValue(WebElement crosshairButtonValue) {
		this.crosshairButtonValue = crosshairButtonValue;
	}

	public WebElement getWatermarkButton() {
		return watermarkButton;
	}

	public void setWatermarkButton(WebElement watermarkButton) {
		this.watermarkButton = watermarkButton;
	}

	public WebElement getNavigationButton() {
		return navigationButton;
	}

	public void setNavigationButton(WebElement navigationButton) {
		this.navigationButton = navigationButton;
	}

	public WebElement getNavigationButtonvalue() {
		return navigationButtonvalue;
	}

	public void setNavigationButtonvalue(WebElement navigationButtonvalue) {
		this.navigationButtonvalue = navigationButtonvalue;
	}

	public WebElement getPaneButton() {
		return paneButton;
	}

	public void setPaneButton(WebElement paneButton) {
		this.paneButton = paneButton;
	}

	public WebElement getPaneButtonValue() {
		return paneButtonValue;
	}

	public void setPaneButtonValue(WebElement paneButtonValue) {
		this.paneButtonValue = paneButtonValue;
	}

	public WebElement getTopMargin() {
		return topMargin;
	}

	public void setTopMargin(WebElement topMargin) {
		this.topMargin = topMargin;
	}

	public WebElement getBottomMargin() {
		return bottomMargin;
	}

	public void setBottomMargin(WebElement bottomMargin) {
		this.bottomMargin = bottomMargin;
	}

	public WebElement getRightMargin() {
		return rightMargin;
	}

	public void setRightMargin(WebElement rightMargin) {
		this.rightMargin = rightMargin;
	}

	public WebElement getApperanceOkey() {
		return apperanceOkey;
	}

	public void setApperanceOkey(WebElement apperanceOkey) {
		this.apperanceOkey = apperanceOkey;
	}

	public WebElement getTemplate() {
		return Template;
	}

	public void setTemplate(WebElement template) {
		Template = template;
	}
	
	
	
	
	

}
