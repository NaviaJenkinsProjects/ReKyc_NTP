package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guest_Login_POM {
	
	
	public WebDriver driver;
	
	
	@FindBy (xpath = "(//a[text()='Login as Guest'])[4]")
	private WebElement gustLogin;
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement name;
	
	@FindBy (xpath = "//input[@type='email']")
	private WebElement eMail;
	
	@FindBy (xpath = "//input[@placeholder='Mobile number']")
	private WebElement mobileNumber;
	
	@FindBy (xpath = "//input[@id='gu_t_cond']")
	private WebElement agree;
	
	@FindBy (xpath = "(//button[@value='Login'])[2]")
	private WebElement login;

	public Guest_Login_POM(WebDriver driver2) {
		
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getGustLogin() {
		return gustLogin;
	}

	public void setGustLogin(WebElement gustLogin) {
		this.gustLogin = gustLogin;
	}

	public WebElement getName() {
		return name;
	}

	public void setName(WebElement name) {
		this.name = name;
	}

	public WebElement geteMail() {
		return eMail;
	}

	public void seteMail(WebElement eMail) {
		this.eMail = eMail;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(WebElement mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public WebElement getAgree() {
		return agree;
	}

	public void setAgree(WebElement agree) {
		this.agree = agree;
	}

	public WebElement getLogin() {
		return login;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}
	
	
	
	
	
	

}
