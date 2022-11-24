package com.automationtesting.dropdownsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test5 {
	
	public void dropDownValueSelectByText() {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://letcode.in/dropdowns");
		
		Select fruits= new Select(driver.findElement(By.id("fruits")));
		
		if(fruits.isMultiple()) { // True  //False
			fruits.selectByIndex(1);
			fruits.selectByIndex(3);
		}
		else {
			fruits.selectByIndex(1);	
		}
		
	}
	
	public static void main(String[] args) {
		Test5 ref= new Test5();
		ref.dropDownValueSelectByText();
	}

}
