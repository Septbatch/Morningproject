package com.automationtesting.javasession;

import java.util.ArrayList;
import java.util.HashSet;

public class Test3 {
	
	public static void main(String[] args) {
		ArrayList<String> fruits= new ArrayList<String>();
		
		fruits.add("Mango");
		fruits.add("PineApple");
		fruits.add("Kiwi");
		fruits.add("Mango");
		
		System.out.println(fruits); //[Mango, PineApple, Kiwi, Mango]
		//In above arraylist duplicates allowed, insertion order preserved
		
		HashSet<String> ff= new HashSet<String>();
		
		ff.add("Mango");
		ff.add("PineApple");
		ff.add("Kiwi");
		ff.add("Mango");
		
		System.out.println(ff); //[Kiwi, PineApple, Mango]
		
		//In above set duplicates not allowed and insertion order not preserved.
	}

}
