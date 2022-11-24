package com.automationtesting.seleniumbasic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GithubLoginLocators {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		// Aboue two steps is used to launch browser
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://github.com/login");
		
		driver.findElement(By.id("login_field")).sendKeys("testingtraining@gmail.com");
		
		driver.findElement(By.name("password")).sendKeys("T@htc2022");
		
		String page_header=driver.findElement(By.tagName("h1")).getText();
		
		System.out.println("Github page heading is:: "+page_header);
		
		driver.findElement(By.partialLinkText("Forgot")).click();
	}

}
