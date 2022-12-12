package com.automationtesting.actionssession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardTest2 {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		driver.get("https://the-internet.herokuapp.com/key_presses");
		
		Actions action= new Actions(driver);
		
		action.keyDown(Keys.CONTROL).keyUp(Keys.CONTROL).perform();
		
		action.keyDown(Keys.SHIFT).keyUp(Keys.SHIFT).perform();
		
		
	}

}
