package com.automationtesting.checkradiobuttonsession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxTest {

	public void checkSelect(String checkvalue) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://courses.letskodeit.com/practice");

		List<WebElement> check_boxs = driver.findElements(By.xpath("//div[@id='checkbox-example-div']//label/input"));

		for (WebElement check_box : check_boxs) {
			String value = check_box.getAttribute("value");
			if (value.equalsIgnoreCase(checkvalue)) {
				if (!(check_box.isSelected())) { // False
					check_box.click(); // true area
				} else { // false area
					System.out.println("Hey boss aleady checkbox is already selected");
				}
			}
		}
		System.out.println("Check box option is selected");
	}

	public static void main(String[] args) {
		CheckBoxTest tet = new CheckBoxTest();

		tet.checkSelect("benz");
	}

}
