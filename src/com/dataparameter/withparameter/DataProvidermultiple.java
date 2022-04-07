package com.dataparameter.withparameter;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProvidermultiple {
	
	@DataProvider(name = "SearchProvider")
	public static Object[][] getdataprovidervalue(Method m){
		if(m.getName().equalsIgnoreCase("testMethodA"))
		
		{
		return new Object[][]
				{
			
			{"Guru99","India"},
			{"Demo","UK"},
			{"TestDemo","USA"}
				
				};
		}
		else 
		{
			return new Object[][]
					{
				{"Canada"},
				{"Russia"},
				{"Japan"}
					};
		}
	}
}


