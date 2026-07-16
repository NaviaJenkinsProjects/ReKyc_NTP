package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GL_Negative_POM {

	public WebDriver driver;

	@FindBy(xpath = "//div[@id='bouncer-error_username']")
	private WebElement name;

	@FindBy(xpath = "//div[@id='bouncer-error_useremail']")
	private WebElement eMail;

	@FindBy(xpath = "//div[@id='bouncer-error_userphone']")
	private WebElement number;

	@FindBy(xpath = "//div[@id='bouncer-error_gu_t_cond_on']")
	private WebElement agree;

	
	
	
	
	
	
	public GL_Negative_POM(WebDriver driver2) {

		this.driver = driver2;
		PageFactory.initElements(driver2, this);
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

	public WebElement getNumber() {
		return number;
	}

	public void setNumber(WebElement number) {
		this.number = number;
	}

	public WebElement getAgree() {
		return agree;
	}

	public void setAgree(WebElement agree) {
		this.agree = agree;
	}

}
