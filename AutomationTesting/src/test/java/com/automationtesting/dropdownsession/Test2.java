package com.automationtesting.dropdownsession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		// This is called instance, or this is called object creation of webDriver.

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://letcode.in/dropdowns");

		WebElement multipdropdown = driver.findElement(By.id("superheros"));

		Select heros = new Select(multipdropdown);

		heros.selectByIndex(1);

		heros.selectByVisibleText("Captain America");

		heros.selectByValue("bp");

		heros.deselectByValue("ca"); // deselecting captain america

		List<WebElement> selectedheros = heros.getAllSelectedOptions();

		for (WebElement selectedhero : selectedheros) {
			System.out.println(selectedhero.getText());
		}

	}

}
