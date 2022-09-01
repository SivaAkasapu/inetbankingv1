package com.inetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);// driver comes from the base class
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLoginBtn();

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomerLink();
		Thread.sleep(3000);
		
		
		try {
		driver.switchTo().alert().dismiss();
		}catch(Exception e) {
			System.out.println(" not found alertbox");
		}
		
		addcust.cusname("Siva");
		addcust.genderSelect();
		addcust.cusDOB("07", "07", "1997");
		addcust.addText("Hi this is Siva dingdong");
		addcust.city("Rajahmundry");
		addcust.statename("AP");
		addcust.pinNum(533102);
		addcust.mbnumber("7674833944");
		String email = randomestring()+"@gmail.com";
		addcust.email_Id(email);
		addcust.password("selenium");
		Thread.sleep(2000);
		addcust.submit_Btn();

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

}
