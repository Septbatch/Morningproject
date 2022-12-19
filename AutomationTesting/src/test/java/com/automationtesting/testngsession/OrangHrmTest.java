package com.automationtesting.testngsession;

import java.io.BufferedReader;
import java.io.File;
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
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangHrmTest {
	WebDriver driver;

	Properties pr;

	SoftAssert soft = new SoftAssert();

	@DataProvider(name = "AddEmployee")
	public Object[][] readData() {

		Object[][] data = new Object[3][4];

		data[0][0] = "Ram";
		data[0][1] = "Testing";
		data[0][2] = "Trainier";
		data[0][3] = "20455";

		data[1][0] = "Rahim";
		data[1][1] = "Testing";
		data[1][2] = "Trainer";
		data[1][3] = "20466";

		data[2][0] = "Cloud";
		data[2][1] = "Testing";
		data[2][2] = "Trainer";
		data[2][3] = "20366";

		return data;
	}

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

	// Author is GuruMohanReddy
	@org.testng.annotations.Test(priority = 1, enabled = false)
	public void addEmployee_Page() throws InterruptedException {
		driver.findElement(By.xpath("//a//span[.='PIM']")).click();
		driver.findElement(By.xpath("//a[.='Add Employee']")).click();

		Thread.sleep(5000);

		boolean condition = driver.findElement(By.xpath("(//h6)[2]")).isDisplayed();

		/*
		 * Assert.assertFalse(condition, "AddEmployee page is not opened"); //hard
		 * assertion System.out.println("Add Employee page completed");
		 * System.out.println(driver.getTitle());
		 */

		soft.assertFalse(condition);

		System.out.println(driver.getTitle());
		soft.assertAll();
	}

	@org.testng.annotations.Test(priority = 2, dataProvider = "AddEmployee")
	public void RegisterEmployee(String fname, String mname, String lname, String empid) throws InterruptedException {
		driver.findElement(By.xpath("//a//span[.='PIM']")).click();
		driver.findElement(By.xpath("//a[.='Add Employee']")).click();
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("middleName")).sendKeys(mname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.xpath("//label[text()='Employee Id']/../../div[2]/input")).sendKeys(empid);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		boolean condition = driver.findElement(By.xpath("(//h6)[3]")).isDisplayed();
		Assert.assertTrue(condition, "Unable to add employee Test Failed");

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
