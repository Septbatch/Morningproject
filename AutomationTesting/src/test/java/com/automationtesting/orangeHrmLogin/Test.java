package com.automationtesting.orangeHrmLogin;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws IOException {

		FileReader reader = new FileReader(
				"C:\\Users\\gurum\\Desktop\\Cloud Sep Batch\\Demo\\MyProject\\AutomationTesting\\config.properties");

		Properties pr = new Properties();

		pr.load(reader); // This line completely read data.

		String browsertype = pr.getProperty("browsertype");

		if (browsertype.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get(pr.getProperty("Url"));

		} else if (browsertype.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();

			driver.manage().window().maximize();

			driver.get(pr.getProperty("Url"));

		}
	}

}
