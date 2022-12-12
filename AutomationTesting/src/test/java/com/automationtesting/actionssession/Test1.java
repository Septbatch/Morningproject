package com.automationtesting.actionssession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement rightClick_btn = driver.findElement(By.xpath(" //span[text()='right click me']"));

		Actions action = new Actions(driver);

		action.contextClick(rightClick_btn).perform();

		WebElement click_btn=driver.findElement(By.xpath("//span[text()='Copy']"));
		
		action.click(click_btn).perform();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept(); // CTRL+SHIFT+F [Code re-arragement]
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
