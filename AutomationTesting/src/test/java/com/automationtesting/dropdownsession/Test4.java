package com.automationtesting.dropdownsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4 {
	
	public void dropDownValueSelectByText(String selectfruit) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://letcode.in/dropdowns");
		
		Select fruits= new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText(selectfruit);
	}
	
	public static void main(String[] args) {
		Test4 ref= new Test4();
		ref.dropDownValueSelectByText("Orange");
	}

}
