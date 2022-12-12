package com.automationtesting.windowHandling;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTest2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://letcode.in/windows");

		String parent_window = driver.getWindowHandle(); //store parent window

		driver.findElement(By.xpath("//button[@id='multi']")).click(); // This command will open multiple windows

		Set<String> allwindows = driver.getWindowHandles(); // This will store all opened windows to set<String>

		for (String window : allwindows) {
			driver.switchTo().window(window);

			String url = driver.getCurrentUrl();

			if (url.equals("https://letcode.in/alert")) {   //True
				driver.findElement(By.xpath("//button[.='Simple Alert']")).click();

				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
			}
		}

		driver.switchTo().window(parent_window);

		driver.findElement(By.linkText("Log in")).click();
		
		driver.quit(); // This command will close entire session.

	}

}
