package com.automationtesting.calendarsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarTest2 {

	public void selectDate(String smonth, String syear, String sdate) {
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

		while (!((month.equals(smonth)) && (year.equals(syear)))) {

			driver.findElement(By.xpath("//span[text()='Next']")).click();

			monthyearvalue = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();

			month = monthyearvalue.split(" ")[0].trim();

			year = monthyearvalue.split(" ")[1].trim();
		}

		try {
		driver.findElement(By.xpath("//a[text()='" + sdate + "']")).click();
		}
		catch (Exception e) {
			System.out.println("Wrong Data selected : "+smonth+" "+sdate);
		}
		
	}

	public static void main(String[] args) {
		CalendarTest2 test= new CalendarTest2();
		
	
		test.selectDate("November", "2025", "31");
		
		
	}

}
