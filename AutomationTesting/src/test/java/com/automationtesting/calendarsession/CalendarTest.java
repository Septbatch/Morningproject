package com.automationtesting.calendarsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.cssSelector("input#datepicker")).click();

		String monthyearvalue = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();

		System.out.println(monthyearvalue);

		String month = monthyearvalue.split(" ")[0].trim();

		String year = monthyearvalue.split(" ")[1].trim();

		while (!((month.equals("February")) && (year.equals("2023")))) {

			driver.findElement(By.xpath("//span[text()='Next']")).click();

			monthyearvalue = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();

			month = monthyearvalue.split(" ")[0].trim();

			year = monthyearvalue.split(" ")[1].trim();
		}
		
		
		driver.findElement(By.xpath("//a[text()='17']")).click();

	}

}
