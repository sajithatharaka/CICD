package com.automation.cicd;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
	private static String driverLocation="C:\\infor-taas\\Studio\\19.6.0\\studio_metadata\\drivers\\windows\\chrome\\32\\chromedriver.exe";
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchDriver() throws MalformedURLException {
		DesiredCapabilities dr=null;
		dr=DesiredCapabilities.chrome();
		dr.setBrowserName("chrome");
		dr.setPlatform(Platform.WINDOWS);
		
		System.setProperty("webdriver.chrome.driver", driverLocation);
		driver=new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"),dr);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void Test1() {
		driver.get("www.google.com");
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
