package com.dataparameter.withparameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class Searchtest {

	WebDriver driver;
	public String driverpath = "//Users//mousumighosh//Selenium//Driver//chromedriver";
	WebElement textbox;
	
	@BeforeSuite
	public void launchchrome()
	{
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver = new ChromeDriver();
		driver.get("https://google.com");
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[text()='I agree']")).click();
		
		
	}
	
	
	@Test(dataProviderClass =Dataprovidersearch.class,dataProvider = "SearchProvider")
	public void test(@Optional("ABC")String author,String searchKey) throws InterruptedException {
		//String author = "guru99";
        //String searchKey = "india";
		textbox = driver.findElement(By.name("q"));
		System.out.println("Author key used "+author+" Search key used " +searchKey);
		textbox.sendKeys(searchKey);
		Thread.sleep(2000);
		Assert.assertEquals(textbox.getAttribute("value"),searchKey);
		System.out.println("matching string");
		textbox.clear();
	}
	
	@AfterSuite
	public void close() {
		driver.quit();
	}
	

}
