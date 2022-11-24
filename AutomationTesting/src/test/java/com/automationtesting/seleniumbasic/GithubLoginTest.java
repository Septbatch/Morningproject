package com.automationtesting.seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GithubLoginTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		// This two lines launch an empty browser
		
		driver.manage().window().maximize();
		// This command maximize opened browser
		
		driver.manage().deleteAllCookies(); 
		// This command will delete all temp store cookies
		
		driver.get("https://github.com/login");
		// This will launch particular url in opened browser.
		
		WebElement login_textbox = driver.findElement(By.id("login_field"));
		
		login_textbox.sendKeys("septembertraining2022@gmail.com");
		
		driver.findElement(By.name("password")).sendKeys("G@htc2018");
		
		driver.findElement(By.name("commit")).click();
		
		String page_title=driver.getTitle();
		
		System.out.println("Git hub page title is "+page_title);
		
		Thread.sleep(5000); // completely halt the execution
		
		driver.close(); // This command close particular opened browser.
	}

}
