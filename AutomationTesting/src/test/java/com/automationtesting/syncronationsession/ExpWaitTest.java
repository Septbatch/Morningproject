package com.automationtesting.syncronationsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpWaitTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://letcode.in/waits");

		driver.findElement(By.xpath("//button[@id='accept']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		String alertmessage = alert.getText();

		System.out.println("Alert message is ::" + alertmessage);

		alert.accept();
	}

}
