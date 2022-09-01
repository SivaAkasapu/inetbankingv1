package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements( rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name= "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logoutbtn;
	
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pswd) {
		txtPassword.sendKeys(pswd);
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}
	
	public void clickLogoutBtn() {
		logoutbtn.click();
	}
	
	
	
	
	
}