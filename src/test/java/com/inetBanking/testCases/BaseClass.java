package com.inetBanking.testCases;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	//https://github.com/SivaAkasapu/inetbankingv1.git
	
	ReadConfig readconfig= new ReadConfig();
	
	public String baseUrl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String excptAlert=readconfig.expectedAlertMessage();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	//@Parameters("browser")
	public void setUp(String br) {
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		/*else if (br.equals("fireFor")) {
		System.setProperty("webdriver.gecko.driver",readconfig.getFireFox());
		driver = new FireFoxDriver();
	}else if(br.equals("ie")) {
		System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
		driver = new InternetExplorerDriver();
	}*/
		driver.get(baseUrl);
		driver.manage().window().maximize();
		}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomestring() {
		String generatedString=RandomStringUtils.randomAlphabetic(8);
			return generatedString;
		}
	
	
	
	
}
