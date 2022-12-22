package com.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.objects.pageObject.OrangeHrmPIM;
import com.objects.pageObject.OrangeHRMAdmin;
import com.objects.pageObject.OrangeHrmLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_TestScript {

	WebDriver driver;

	@BeforeMethod
	public void setUP() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(enabled= false)
	public void orangeHRMLogin() throws InterruptedException {
		OrangeHrmLoginPage test = new OrangeHrmLoginPage(driver);
		test.orangeHRMLogin();
		
		OrangeHrmPIM empadd= new OrangeHrmPIM(driver);
		empadd.addEployee();
	}
	
	
	@Test(enabled= true)
	public void adminTest() {
		OrangeHrmLoginPage test = new OrangeHrmLoginPage(driver);
		test.orangeHRMLogin();
		
		OrangeHRMAdmin admin= new OrangeHRMAdmin();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
