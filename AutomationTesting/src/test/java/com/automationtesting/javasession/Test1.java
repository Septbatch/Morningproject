package com.automationtesting.javasession;

public class Test1 {
	
	public void addition() {
		int a=110345;
		int b=12200;
		int c= a+b;
		System.out.println(c);
	}
	
	// In above approach every time we need to change code for our requirement
	
	public void addition(int a, int b) {
		int c= a+b;
		System.out.println(c);
	}
	
	// No here we are not changing any code syntax, we by-passing through method parameter.
	
	public static void main(String[] args) {
		Test1 ref=new Test1();
		
		ref.addition();
		ref.addition(12345, 987654);
	}

}
