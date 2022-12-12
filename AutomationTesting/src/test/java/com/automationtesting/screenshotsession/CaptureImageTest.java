package com.automationtesting.screenshotsession;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureImageTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		driver.get("https://letcode.in/signin");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Testingtraining@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("G@testing2022");
		
		driver.findElement(By.xpath(" //button[text()='LOGIN']")).click();
		
		Thread.sleep(5000);
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String project_location=System.getProperty("user.dir");
		
		File Desti= new File(project_location+"\\CaptureImages\\TestingLogin.png");
		
		FileUtils.copyFile(src, Desti);
		
	}

}
