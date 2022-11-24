package com.automationtesting.dropdownsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		// If any interviewer will ask you how to launch browser/initialize browser
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://letcode.in/dropdowns");
		
		//My req is to select value from dropdown
		
		WebElement fruits_dropdown = driver.findElement(By.id("fruits"));
		
		//Now I want to select specific fruit from dropdown
		
		Select fruits= new Select(fruits_dropdown);
		
		fruits.selectByIndex(4);// banana is going to select 
		
		
		Thread.sleep(3000);
		
		fruits.selectByVisibleText("Pine Apple");
		
	
		
		WebElement selectedfruit=fruits.getFirstSelectedOption();
		
		String fruits_selcted=selectedfruit.getText();
		
		System.out.println("Selected fruit from dropdown is ::"+fruits_selcted);
	
		Thread.sleep(3000);
		
		driver.close();
		
		
	}

}
