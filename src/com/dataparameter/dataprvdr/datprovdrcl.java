package com.dataparameter.dataprvdr;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class datprovdrcl {
	
	public static Object[][] groupArray = null;
	@DataProvider(name = "SearchProvider")
	public static Object[][] getdatafromprovider(ITestContext c){
	
		for (String group : c.getIncludedGroups()) {
		if(group.equalsIgnoreCase("A")){
			groupArray = new Object[][] { 
					{ "Guru99", "India" }, 
					{ "Krishna", "UK" }, 
					{ "Bhupesh", "USA" } 
				};
		break;	
		}
			else if(group.equalsIgnoreCase("B"))
			{
			groupArray = new Object[][] { 
						{  "Canada" }, 
						{  "Russia" }, 
						{  "Japan" } 
					};
			}
		break;
	}
	return groupArray;
	}

}
