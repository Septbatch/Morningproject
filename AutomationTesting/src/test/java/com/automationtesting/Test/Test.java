package com.automationtesting.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://the-internet.herokuapp.com/upload");
		
		WebElement element=driver.findElement(By.cssSelector("input#file-upload"));
		
		Actions action= new Actions(driver);
		action.moveToElement(element).click().perform();
		
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("D:\\FileData\\FileUpload.exe");
	}

}
