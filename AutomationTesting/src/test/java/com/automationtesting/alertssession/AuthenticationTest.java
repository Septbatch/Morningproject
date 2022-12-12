package com.automationtesting.alertssession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationTest {

	public static void main(String[] args) {
		
		String page_title = ""; //nothing  // Basic Auth
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		List<WebElement> page_header = driver.findElements(By.tagName("h3"));

		if (page_header.size() >= 1) {  //true  //false
			for (WebElement page_head : page_header) {

				page_title = page_head.getText();

			}
		}
		
		if (page_title.equals("Basic Auth")) { // False
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}

}
