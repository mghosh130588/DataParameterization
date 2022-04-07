package com.dataparameter.withoutparameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataParameterwithoutParameter {
	
	WebDriver driver;
	public String driverpath = "//Users//mousumighosh//Selenium//Driver//chromedriver";
	
	
	@BeforeTest
	public void launchchrome()
	{
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void test() throws InterruptedException {
		String author = "guru99";
        String searchKey = "india";
		driver.get("https://google.com");
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[text()='I agree']")).click();
		System.out.println("Author key used "+author+" Search key used " +searchKey);
		driver.findElement(By.name("q")).sendKeys(searchKey);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.name("q")).getAttribute("value"),searchKey);
		System.out.println("matching string");
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}
