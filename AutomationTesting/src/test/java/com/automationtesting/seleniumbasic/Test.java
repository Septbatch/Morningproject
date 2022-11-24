package com.automationtesting.seleniumbasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gurum\\Desktop\\Cloud Sep Batch\\Softwars\\chromedriver.exe"); 
		// This will build required .exe file for the given location.
		WebDriver driver= new ChromeDriver();// This will launch your chrome empty browser
	}

}
