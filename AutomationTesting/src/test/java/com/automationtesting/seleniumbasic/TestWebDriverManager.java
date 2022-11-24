package com.automationtesting.seleniumbasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebDriverManager {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();// Internally it will check browser version in your laptop
		// and download required .exe in backend.
		WebDriver driver= new ChromeDriver();
		
		// I want to maximize my browser
		
		driver.manage().window().maximize(); // This syntax helps to maximize browser
		
		driver.get("https://ts.meeseva.telangana.gov.in/meeseva/home.htm");  // By  using get method we can laucnh any url of the applicaiton
	
		  Thread.sleep(3000);
		
		driver.close();// This syntax close opened browser
	}

}
