package com.automationtesting.webtablessession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableTest2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://letcode.in/table");

		WebElement table = driver.findElement(By.id("simpletable"));

		Actions action = new Actions(driver);

		action.moveToElement(table).perform();

		List<WebElement> tablerows = table.findElements(By.cssSelector("tbody>tr"));
		
		int tablerow_count=tablerows.size(); 
		
		if(tablerow_count==3) {
			System.out.println("testpass");
		}
		else {
			System.out.println("testfail");
		}

	}

}
