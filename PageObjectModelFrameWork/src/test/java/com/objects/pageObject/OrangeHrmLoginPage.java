package com.objects.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrangeHrmLoginPage {

	WebDriver driver; // To use any where in this class, we are defining webdriver at class level

	public OrangeHrmLoginPage(WebDriver driver) {
		this.driver = driver; // In run time we are passing driver instance to class level
	}

	By username = By.name("username");
	
	By password= By.name("password");
	
	By login_btn= By.xpath("//button[@type='submit']");
	
	
	public void orangeHRMLogin() {
		driver.findElement(username).sendKeys("Admin");
		
		driver.findElement(password).sendKeys("admin123");
		
		driver.findElement(login_btn).click();
		
		String page_url=driver.getCurrentUrl();
		
		String exp_url="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
		Assert.assertEquals(page_url, exp_url);
	}

}
