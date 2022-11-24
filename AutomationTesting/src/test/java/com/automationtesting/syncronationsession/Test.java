package com.automationtesting.syncronationsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		
		driver.findElement(By.id("btn1")).click();
		
		Thread.sleep(5000); // This will halt execution for 5 sec
		
		driver.findElement(By.xpath("//div[@itemprop='articleBody']//h3//input")).sendKeys("first textbox");
		
		driver.findElement(By.id("btn2")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//div[@itemprop='articleBody']//h3//input[@id='txt2']")).sendKeys("textbox2");
		
		
	}

}
