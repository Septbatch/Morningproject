package com.automationtesting.oopssession;

public class ChromeBrowser implements webDriverTest {

	public void login() {
		System.out.println("Login successfully");
		
	}

	public void logout() {
		System.out.println("Logout successfully");
		
	}
	
	public void sendKeys() {
		System.out.println("entered text in username box");
		
	}

	public void click() {
	System.out.println("Click on specific element");
		
	}
	
	public static void main(String[] args) {
		webDriverTest driver= new ChromeBrowser();
		
		driver.login();
		
		driver.logout();
		
		driver.sendKeys();
		
		driver.click();
	}



}
