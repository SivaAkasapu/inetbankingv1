package com.inetBanking.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass{
	
	@Test
	public void loginTest() {
		driver.get(baseUrl);
		
		LoginPage lp = new LoginPage(driver);
	
	lp.setUserName(username);
	lp.setPassword(password);
	lp.clickLoginBtn();
	
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
	
	
	}
	
}
