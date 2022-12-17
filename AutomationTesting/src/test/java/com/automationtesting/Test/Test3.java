package com.automationtesting.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {

	 static WebDriver driver;
	

	public  void  datePicker() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();

		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));
		selectDate("24", "December", "2023");
	}

	public static String[] getmonthYear(String monthYear) {
		return monthYear.split(" ");
	}

	public  void selectDate(String date, String monthe, String yeare) {

		String  monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearVal);
		
		   String [] monthyar=monthYearVal.split(" ");
		      String month= monthyar[0];
		      String year= monthyar[1];

		      
		while (!(month.equals(monthe) && year.equals(yeare))) {

			driver.findElement(By.xpath("//span[text()='Next']")).click();
			monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(monthYearVal);

		}

		driver.findElement(By.xpath("//a[text()='" + date + "']")).click();

	}

	public static void main(String[] args) {
		Test3 test = new Test3();
		test.datePicker();

	}
}
