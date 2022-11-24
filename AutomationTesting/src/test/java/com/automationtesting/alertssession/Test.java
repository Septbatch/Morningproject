package com.automationtesting.alertssession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://courses.letskodeit.com/practice");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys("CloudNaradha");
		
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert=driver.switchTo().alert(); // This syntax switches driver instance to alert.
		
		String alert_message=alert.getText();
		
		System.out.println("Alert Message is ::"+alert_message);
		
		if(alert_message.contains("CloudNaradha")) {
			System.out.println("Alert message test passed");
		}
		else {
			System.out.println("Alert message test failed");
		}
		
		alert.accept();
	}

}
