package com.dataparameter.withparameter;

import org.testng.annotations.DataProvider;

public class Dataprovidersearch {

	@DataProvider(name = "SearchProvider")
	public static Object[][] getdataprovidervalue(){
		
		return new Object[][]
				{
			
			{"Guru99","India"},
			{"Demo","UK"},
			{"TestDemo","USA"}
				
				};
	}
}
