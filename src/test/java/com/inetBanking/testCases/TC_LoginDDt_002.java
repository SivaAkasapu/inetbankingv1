package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDt_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) {
		//driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		System.out.println(" username is provided");
		lp.setPassword(pwd);
		System.out.println("password is provided");
		lp.clickLoginBtn();
		
		
		
		if (isAlertPresent() == true) {
			driver.switchTo().alert();
			String alert_text = driver.switchTo().alert().getText();
			System.out.println(alert_text);
			System.out.println(excptAlert);

			Assert.assertEquals(alert_text, excptAlert);
			driver.switchTo().defaultContent();
			
			Assert.assertFalse(true);

		} else {
			Assert.assertTrue(true);// User or Password is not valid
			lp.clickLogoutBtn();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}



	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		System.out.println(System.getProperty("user.dir"));
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rownum][colCount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}

		}

		return loginData;
	}

}
