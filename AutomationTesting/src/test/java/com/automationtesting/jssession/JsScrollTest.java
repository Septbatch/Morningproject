package com.automationtesting.jssession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsScrollTest {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");
		
		
		WebElement mousehover=driver.findElement(By.xpath("//button[text()='Mouse Hover']"));
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].scrollIntoView();", mousehover);
	}

}
