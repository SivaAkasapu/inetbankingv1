package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement lnkNewCustomer;

	@FindBy(xpath = "//input[@name='name']")
	WebElement customerName;

	@FindBy(xpath = "//input[@name='rad1']")
	WebElement genderRadiobtn;

	@FindBy(xpath = "//input[@name='dob']")
	WebElement dob;

	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement addressTextBox;

	@FindBy(xpath = "//input[@name='city']")
	WebElement city;

	@FindBy(xpath = "//input[@name='state']")
	WebElement state;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pin;

	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement mNumber;

	@FindBy(xpath = "//input[@name='emailid']")
	WebElement emailId;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pswd;

	@FindBy(xpath = "//input[@name='sub']")
	WebElement submitBtn;

	public void clickAddNewCustomerLink() {
		lnkNewCustomer.click();
	}

	public void cusname(String cname) {
		customerName.sendKeys(cname);
	}

	public void genderSelect() // parameter are used by pavan sir
	{
		genderRadiobtn.click();
	}

	public void cusDOB(String mm, String dd, String yy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
	}

	public void addText(String text) {
		addressTextBox.sendKeys(text);

	}

	public void city(String cityname) {
		city.sendKeys(cityname);
	}

	public void statename(String sname) {
		state.sendKeys(sname);
	}

	public void pinNum(int pnum) {
		pin.sendKeys(String.valueOf(pnum));
	}

	public void mbnumber(String mnum) {
		mNumber.sendKeys(mnum);
	}

	public void email_Id(String e) {
		emailId.sendKeys(e);
	}

	public void password(String p) {
		pswd.sendKeys(p);
	}

	public void submit_Btn() {
		submitBtn.click();
	}

}
