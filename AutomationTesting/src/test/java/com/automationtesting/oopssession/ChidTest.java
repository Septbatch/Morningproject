package com.automationtesting.oopssession;

public class ChidTest  extends Test {

	void logout() {
		System.out.println("Logout succesfully");
		
	}
	
	public static void main(String[] args) {
		ChidTest test= new ChidTest();
		
		test.login();
		
		test.logout();
	}

}
