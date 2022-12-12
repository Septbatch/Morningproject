package com.automationtesting.checkradiobuttonsession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonTest {

	WebDriver driver; // It is non static, we need to call based on object reference

	public void radioSelect(String radiotype) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(); // Here in local we define driver, so only this method can access

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://courses.letskodeit.com/practice");

		List<WebElement> radio_buttons = driver.findElements(By.xpath("//div[@id='radio-btn-example']//label/input"));

		for (WebElement radio_button : radio_buttons) { // 1, 2, 3

			String value = radio_button.getAttribute("value"); // bmwradio, benzradio, hondaradio; bmw, benz honda;
																// cars,cars,cars
			if (value.equalsIgnoreCase(radiotype)) { // false,false, True

				if (!(radio_button.isSelected())) {  // True // False 
					radio_button.click();
					break; // I'm satisfied, I don't want to continue coming out of the loop
				}
			}

		}

		System.out.println(radiotype + " option selected succesfully....!");
	}

	public void tearDown() {
		driver.close();
	}

	public void generateReport() {
		System.out.println("radioSelect Testcase passed");
	}

	public static void main(String[] args) {
		RadioButtonTest test = new RadioButtonTest();

		test.radioSelect("bmw");

		test.tearDown();

		test.generateReport();

	}

}
