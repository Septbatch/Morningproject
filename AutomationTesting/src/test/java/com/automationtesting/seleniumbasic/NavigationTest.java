package com.automationtesting.seleniumbasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationTest {
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize(); 
		
		driver.get("https://google.com/");
		
		driver.navigate().to("https://facebook.com/");
		
		
		driver.navigate().back();// googlepage
		
		Thread.sleep(3000); // This is not recommended in real time projects.
		
		String page_titlee=driver.getTitle();
		
		System.out.println(page_titlee);
		
		System.out.println(driver.getCurrentUrl()); // This will get url of current application
		
		
		driver.navigate().refresh();// This commnad refresh google page.
		
		
		driver.navigate().forward();// facebook
		
		Thread.sleep(3000);
		
		driver.navigate().refresh(); // this command refresh particular page.
		
		String page_title=driver.getTitle();
		
		System.out.println(page_title);
		
		 String  url=driver.getCurrentUrl();
		 
		 System.out.println(url);
		
		// This will get url of current application
		
		Thread.sleep(3000);
		
		driver.close();// This command close particular instance browser, will close
	}

}
