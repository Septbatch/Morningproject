package com.automationtesting.syncronationsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");

		driver.findElement(By.id("btn1")).click();

		
		driver.findElement(By.xpath("//div[@itemprop='articleBody']//h3//input")).sendKeys("first textbox");

		driver.findElement(By.id("btn2")).click();

		driver.findElement(By.xpath("//div[@itemprop='articleBody']//h3//input[@id='txt2']")).sendKeys("textbox2");
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
