package com.automationtesting.framessession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DrapAndDropTest2 {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement frame=driver.findElement(By.className("demo-frame"));
		
		driver.switchTo().frame(frame);
		
		WebElement draggable=driver.findElement(By.id("draggable"));
		
		WebElement droppable=driver.findElement(By.id("droppable"));
		
		Actions action= new Actions(driver);
		
		action.dragAndDrop(draggable, droppable).perform();
		
		driver.switchTo().defaultContent();// This command come out of the frame.
		
		driver.findElement(By.xpath("//a[text()='Download']")).click();
	}

}
