package com.automationtesting.javasession;

import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		
		ArrayList<String> fruits= new ArrayList<String>();
		
		fruits.add("Mango");
		fruits.add("APPle");
		fruits.add("Kiwi");
		fruits.add("Banana");
		
		for(String fruit:fruits) {
			System.out.println(fruit);
		}
	}

}
