package com.automationtesting.actionssession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://courses.letskodeit.com/practice");
		
		WebElement hover_btn = driver.findElement(By.id("mousehover"));
		
		Actions action= new Actions(driver);
		
		action.moveToElement(hover_btn).moveToElement(driver.findElement(By.xpath("//a[.='Top']"))).click().perform();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
