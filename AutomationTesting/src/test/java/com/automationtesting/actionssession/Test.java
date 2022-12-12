package com.automationtesting.actionssession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement doubleclick_btn = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

		Actions action = new Actions(driver);
		action.doubleClick(doubleclick_btn).perform();

		Alert alert = driver.switchTo().alert();

		String alert_message = alert.getText();

		System.out.println("Message on alert is ::" + alert_message);
		alert.accept();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
