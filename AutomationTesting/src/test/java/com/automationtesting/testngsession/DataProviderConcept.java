package com.automationtesting.testngsession;

import org.testng.annotations.DataProvider;

public class DataProviderConcept {
	
	
	@DataProvider(name = "AddEmployee")
	public Object[][] readData() {
		
		Object [][] data= new Object[3][4];
		
		data[0][0]= "Chiranjeevi";
		data[0][1]= "Testing";
		data[0][2]= "Trainier";
		data[0][3]=  20455;
		
		
		data[1][0]= "BalaKrishna";
		data[1][1]= "Testing";
		data[1][2]= "Trainer";
		data[1][3]= 20466;
		
		data[2][0]= "Venkatesh";
		data[2][1]= "Testing";
		data[2][2]= "Trainer";
		data[2][3]= 20366;
		
		return data;
	}
	
	@org.testng.annotations.Test(dataProvider = "AddEmployee")
	public void addemployee(String fname, String mname, String lname, int empid) {
		
		System.out.println(fname);
		System.out.println(mname);
		System.out.println(lname);
		System.out.println(empid);
		
		System.out.println();
	}

}



