package com.automationtesting.webtablessession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		driver.get("https://letcode.in/table");
		
		WebElement table =driver.findElement(By.id("simpletable"));
		
		Actions action= new Actions(driver);
		
		action.moveToElement(table).perform();
			
		
		List<WebElement> table_header=table.findElements(By.tagName("thead"));
		
		for(WebElement header:table_header) {
			System.out.println(header.getText());
		}
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
