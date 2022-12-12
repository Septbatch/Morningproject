package com.automationtesting.jssession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsClick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		// Click operation by js concept. When ever click operation is unable to perform
		// on specific eleemnt due to eleemnt Not Interceptable Exception.

		WebElement button = driver.findElement(By.id("alertbtn"));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", button);

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());
		alert.accept();

		driver.close();
	}

}
