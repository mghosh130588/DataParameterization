package com.dataparameter.dataprvdr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dataparameter.dataprvdr.datprovdrcl;


public class dataprovidermultiplewithitestcontest {
	//private static Object[][] groupArray;
	public WebDriver driver;
	public String driverpath = "//Users//mousumighosh//Selenium//Driver//chromedriver";
	
	@BeforeSuite(groups={"A","B"})
	public void launchchrome() {
		System.setProperty("webdriver.chrome.driver",driverpath);
		this.driver = new ChromeDriver();
	}
	
	@BeforeTest(groups={"A","B"})
	public void openurl()
	{
	
		this.driver.get("https://google.com");
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		this.driver.switchTo().frame(0);
		this.driver.findElement(By.xpath("//span[text()='I agree']")).click();
		
	}
	
	
	@Test(dataProvider = "SearchProvider",groups="A")
	public void testMethodA(String author,String searchKey) throws InterruptedException {
		WebElement textbox;
		System.out.println("Author key used "+author+" Search key used " +searchKey);
		//String author = "guru99";
        //String searchKey = "india";
		textbox = driver.findElement(By.name("q"));
		textbox.sendKeys(searchKey);
		Thread.sleep(2000);
		Assert.assertEquals(textbox.getAttribute("value"),searchKey);
		System.out.println("matching string");
		textbox.clear();
	}
	
	@Test(dataProvider = "SearchProvider",groups="B")
	public void testMethodB(String searchKey) throws InterruptedException {
		WebElement textbox;
		String author = "guru99";
        //String searchKey = "india";
		
		textbox = driver.findElement(By.name("q"));
		System.out.println("Author key used "+author+" Search key used " +searchKey);
		textbox.sendKeys(searchKey);
		Thread.sleep(2000);
		Assert.assertEquals(textbox.getAttribute("value"),searchKey);
		System.out.println("matching string");
		textbox.clear();
	}
	
	@AfterTest(groups={"A","B"})
	public void close() {
		this.driver.close();
	}
	
	@AfterSuite(groups={"A","B"})
	public void afterteat() {
	this.driver.quit();
		}
	
	
	@DataProvider(name = "SearchProvider")
	public Object[][] getdatafromprovider(ITestContext c){
		//Object[][] groupArray = null;
		System.out.println(c.getIncludedGroups().length);
		for (String group : c.getIncludedGroups()){
			
		if(group.equalsIgnoreCase("A")){
			return new Object[][] { 
					{ "Guru99", "India" }, 
					{ "Krishna", "UK" }, 
					{ "Bhupesh", "USA" } 
				};
		//break;	
		}
			else 
			{
			return new Object[][] { 
						{"Canada" }, 
						{"Russia" }, 
						{ "Japan" } 
					};
			}
		
		
	}
		return new Object[][] {
			{"testdefault","default"}
		};
}
}

	

