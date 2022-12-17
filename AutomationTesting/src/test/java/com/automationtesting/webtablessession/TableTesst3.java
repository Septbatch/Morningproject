package com.automationtesting.webtablessession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableTesst3 {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		driver.get("https://letcode.in/table");
		
		WebElement simpletable =driver.findElement(By.id("simpletable"));
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].scrollIntoView();", simpletable);
		
		
		String path= "//table[@id='simpletable']//td[text()='%s']/following-sibling::td/input";
		
		String value= "Iron";
		
		
		driver.findElement(By.xpath(String.format(path, value))).click();
	}

}
