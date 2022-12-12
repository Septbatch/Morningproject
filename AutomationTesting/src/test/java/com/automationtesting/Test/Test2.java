package com.automationtesting.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();

		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));

		String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();

		String month = monthYear.split(" ")[0].trim();
		String year = monthYear.split(" ")[1].trim();

		while (!(month.equals("March") && year.equals("2029"))) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
			
			month = monthYear.split(" ")[0].trim();
			year = monthYear.split(" ")[1].trim();

		}
		
		driver.findElement(By.xpath("//a[text()='7']")).click();

	}
}
