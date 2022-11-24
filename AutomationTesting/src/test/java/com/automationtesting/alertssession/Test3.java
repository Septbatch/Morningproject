package com.automationtesting.alertssession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {

	public void alert_confirmation(String confirmation_status) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys("CloudNaradha");

		driver.findElement(By.id("confirmbtn")).click();

		Alert alert = driver.switchTo().alert();
		
		if(confirmation_status.equals("Yes")) {
			alert.accept();
		}else if (confirmation_status.equals("No")) {
			alert.dismiss();
		}

	}
	
	public static void main(String[] args) {
		Test3 ref= new Test3();
		ref.alert_confirmation("Yes");
		
	}

}
