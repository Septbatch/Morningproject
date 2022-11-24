package com.automationtesting.dropdownsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		// This is called instance, or this is called object creation of webDriver.

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.facebook.com/signup");

		WebElement date = driver.findElement(By.xpath("//select[@title='Day']"));

		Select date_picker = new Select(date);

		date_picker.selectByIndex(4);

		WebElement date1 = date_picker.getFirstSelectedOption();
		String date_selected = date1.getText();
		System.out.println(date_selected);

		System.out.println(date_picker.getFirstSelectedOption().getText());
	}

}
