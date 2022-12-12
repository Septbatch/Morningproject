package com.automationtesting.orangeHrmLogin;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	public static void main(String[] args) throws IOException {
		
		FileReader reader= new FileReader("C:\\Users\\gurum\\Desktop\\Cloud Sep Batch\\Demo\\MyProject\\AutomationTesting\\config.properties");
		
		Properties pr= new Properties();
		
		pr.load(reader); // This line completely read data.
		
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		String app_url=pr.getProperty("Url");
		
		driver.get(app_url);
		
		String username=pr.getProperty("username");
		
		String password=pr.getProperty("password");
		
		driver.findElement(By.cssSelector("input[name^='user']")).sendKeys(username);
		
		driver.findElement(By.cssSelector("input[name*='password']")).sendKeys(password);
		
		driver.findElement(By.cssSelector("button.oxd-button")).click();
		
		String exp_url= "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
		String curr_url=driver.getCurrentUrl();
		
		if(exp_url.equals(curr_url)) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
	}

}













































































































































































