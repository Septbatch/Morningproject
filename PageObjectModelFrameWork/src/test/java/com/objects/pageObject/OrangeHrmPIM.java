package com.objects.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHrmPIM {
	
	WebDriver driver;
	
	
	public OrangeHrmPIM(WebDriver driver) {
		this.driver= driver;
	}
	
	By PIM = By.xpath("//span[text()='PIM']");
	
	//AddEmployee Locators
	By addemployee_btn = By.xpath("//a[text()='Add Employee']");
	
	By fname= By.name("firstName");
	
	By mname= By.name("middleName");
	
	By lname = By.name("lastName");
	
	By empid= By.xpath("//label[text()='Employee Id']/../../div[2]/input");
	
	By submit= By.xpath("//button[@type='submit']");
	
	
	//Report page Locators
	By Reports_btn= By.xpath("//a[text()='Reports']");
	
	
	public void addEployee() throws InterruptedException {
		driver.findElement(PIM).click();
		
		driver.findElement(addemployee_btn).click();
		
		Thread.sleep(3000);
		
		driver.findElement(fname).sendKeys("Ram");
		
		driver.findElement(mname).sendKeys("Ramhim");
		
		driver.findElement(lname).sendKeys("Rao");
		
		driver.findElement(empid).sendKeys("20455");
		
		driver.findElement(submit).click();
	}
	
	public void addReport() {
		driver.findElement(PIM).click();
		
		driver.findElement(Reports_btn).click();
	}

}
