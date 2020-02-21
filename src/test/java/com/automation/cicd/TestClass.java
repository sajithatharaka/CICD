package com.automation.cicd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
	private static String driverLocation="C:\\infor-taas\\Studio\\19.6.0\\studio_metadata\\drivers\\windows\\chrome\\32\\chromedriver.exe";
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchDriver() {
		System.setProperty("webdriver.chrome.driver", driverLocation);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void Test1() {
		driver.navigate().to("www.google.com");
		System.out.print("Test1 title is "+ driver.getTitle());
	}
	
	@Test
	public void Test2() {
		driver.navigate().to("www.google.com");
		System.out.print("Test2 title is "+ driver.getTitle());
	}
	
	@Test
	public void Test3() {
		driver.navigate().to("www.google.com");
		System.out.print("Test3 title is "+ driver.getTitle());
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
