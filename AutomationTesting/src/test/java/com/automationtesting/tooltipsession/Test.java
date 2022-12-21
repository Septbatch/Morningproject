package com.automationtesting.tooltipsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		
		
		driver.get("http://omayo.blogspot.com/");
		
		WebElement tooltip=driver.findElement(By.xpath("//input[@value='Search']"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(tooltip).perform();
		
		String tooltiptext=tooltip.getAttribute("title");
		
		if(tooltiptext.equals("search")) {
			System.out.println("Tool tip exist");
			
		}
		else {
			System.out.println("Tool tip not exist");
			
		}
	}

}
