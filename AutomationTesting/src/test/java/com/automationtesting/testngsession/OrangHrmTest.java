package com.automationtesting.testngsession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangHrmTest {
	WebDriver driver;

	Properties pr;

	@BeforeSuite
	public void propertiesData() throws IOException {
		File fi = new File(
				"C:\\Users\\gurum\\Desktop\\Cloud Sep Batch\\Demo\\MyProject\\AutomationTesting\\config.properties");
		BufferedReader reader = new BufferedReader(new FileReader(fi));
		pr = new Properties();
		pr.load(reader);

	}

	@BeforeTest
	public void basicSetup() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@BeforeClass
	public void launchUrl() {
		String app_url = pr.getProperty("Url");
		driver.get(app_url);
	}

	@BeforeMethod
	public void login() {
		String user_name = pr.getProperty("username");

		driver.findElement(By.name("username")).sendKeys(user_name);

		String user_pwsd = pr.getProperty("password");

		driver.findElement(By.name("password")).sendKeys(user_pwsd);

		driver.findElement(By.cssSelector("button.oxd-button")).click();
	}

	@org.testng.annotations.Test(priority = 1)
	public void addEmployee_Page() throws InterruptedException {
		driver.findElement(By.xpath("//a//span[.='PIM']")).click();
		driver.findElement(By.xpath("//a[.='Add Employee']")).click();

		Thread.sleep(3000);

		boolean condition = driver.findElement(By.xpath("(//h6)[2]")).isDisplayed();

		Assert.assertTrue(condition, "AddEmployee page is not opened");
	}
	
	@org.testng.annotations.Test(priority = 2)
	public void RegisterEmployee() throws InterruptedException {
		driver.findElement(By.xpath("//a//span[.='PIM']")).click();
		driver.findElement(By.xpath("//a[.='Add Employee']")).click();
		driver.findElement(By.name("firstName")).sendKeys("Ram");
		driver.findElement(By.name("middleName")).sendKeys("Mohan");
		driver.findElement(By.name("lastName")).sendKeys("Rao");
		driver.findElement(By.xpath("//label[text()='Employee Id']/../../div[2]/input")).sendKeys("123987");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		boolean condition=driver.findElement(By.xpath("(//h6)[3]")).isDisplayed();
		Assert.assertFalse(condition, "Unable to add employee Test Failed");
		
	}

	@AfterMethod
	public void logOut() {

		driver.findElement(By.xpath("//span/img[@alt='profile picture']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
