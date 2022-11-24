package com.automationtesting.dropdownsession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://letcode.in/dropdowns");
		
		
		WebElement fruits_dropdown=driver.findElement(By.id("fruits"));
		
		Select fruits= new Select(fruits_dropdown);
		
		List<WebElement> allfruits=fruits.getOptions();
		
		
		for(WebElement fruit:allfruits) {
			String fruitname= fruit.getText();
			System.out.println(fruitname);
			if(fruitname.equals("JackFruit")) {
				fruit.click();
				break;
			}
		}
	}

}
