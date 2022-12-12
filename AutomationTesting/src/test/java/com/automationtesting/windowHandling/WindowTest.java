package com.automationtesting.windowHandling;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://github.com/login");

		String parent_window = driver.getWindowHandle();
		System.out.println(parent_window);

		String btn_click = Keys.chord(Keys.CONTROL, Keys.ENTER);

		driver.findElement(By.partialLinkText("Forgot")).sendKeys(btn_click);
		
		Set<String> allwindows=driver.getWindowHandles();
		
		for(String window:allwindows) {
			
			driver.switchTo().window(window); //2
			
			String app_url=driver.getCurrentUrl(); //2 window url
			
			if(app_url.equals("https://github.com/password_reset"))// True False True
				{
				driver.findElement(By.name("email")).sendKeys("testing@gmail.com");
			}
			
		}
		
		driver.switchTo().window(parent_window); // Now my instance in parent window
		
		driver.findElement(By.xpath("//input[@name='commit']")).click();
	}

}
