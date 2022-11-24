package com.automationtesting.seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMApplication {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(5000);

		WebElement username_textbox = driver.findElement(By.name("username"));

		username_textbox.sendKeys("Admin");

		WebElement password_textbox = driver.findElement(By.name("password"));

		password_textbox.sendKeys("admin123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String title = driver.getTitle();

		System.out.println(title);

		String login_url = driver.getCurrentUrl();

		String expected_url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

		if (login_url.equals(expected_url)) {  // True // False
			System.out.println(" Logged in successfully -- TestPass");    //True
		} else {
			System.out.println("Logged in failed-- TestFail"); // This false area wil execute
		}

		Thread.sleep(3000);

		driver.close();

	}

}
