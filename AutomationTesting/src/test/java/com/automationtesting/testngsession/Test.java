package com.automationtesting.testngsession;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Test {
	
	@BeforeSuite
	public void readPropertydata() {
		System.out.println("Properties data is readed");
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("cookies, maximize, implicity wait");
		System.out.println("Browser launched");
	}
	
	@BeforeClass
	public void lauchUrl() {
		System.out.println("Application lauched");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("username, passowrd entred and logged successuly");
	}
	
	@org.testng.annotations.Test(priority = 1)
	public void applyInsurance() {
		System.out.println("Insurance applied");
	}
	
	@org.testng.annotations.Test(priority = 2)
	public void insuranceRenewal() {
		System.out.println("Insurance renewal is done");
	}
	
	@org.testng.annotations.Test(priority = 3)
	public void cancelInsurance() {
		System.out.println("Insurance cancelled");
		
		Assert.assertEquals(true, false);
	}
	
	@AfterMethod
	public void logoff() {
		System.out.println("Logout successfuly");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Closed browser successfully");
	}

	@AfterSuite
	public void removeconnecion() {
		System.out.println("Properties connection removed");
	}
}
