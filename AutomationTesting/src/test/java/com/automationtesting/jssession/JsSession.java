package com.automationtesting.jssession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsSession {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		WebElement textbox = driver.findElement(By.name("enter-name"));
		
		textbox.sendKeys("Cloud");
		Thread.sleep(4000);
		
		textbox.clear();
		
		Thread.sleep(4000);

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].value='Testing';", textbox);
	}

}
