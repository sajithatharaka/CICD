package com.automation.cicd;

import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class TestClass {
	private static String chromeDriverLocation="C:\\infor-taas\\Studio\\19.6.0\\studio_metadata\\drivers\\windows\\chrome\\32\\chromedriver.exe";
	private static String firefoxDriverLocation="C:\\infor-taas\\Studio\\19.6.0\\studio_metadata\\drivers\\windows\\gecko\\64\\geckodriver.exe";
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchDriver() throws MalformedURLException {
		DesiredCapabilities dr=null;
		dr=DesiredCapabilities.firefox();
		dr.setCapability("marionette",true);
		//ChromeOptions k=new ChromeOptions();
		dr.setBrowserName("firefox");
		dr.setPlatform(Platform.LINUX);
		
		//System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
		System.setProperty("webdriver.gecko.driver",firefoxDriverLocation);
		driver=new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"),dr);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void Test1() throws JiraException {
		driver.get("https://www.google.com/");
		System.out.print("Test1 title is "+ driver.getTitle());
	}
	
	@Test
	public void Test2() {
		driver.navigate().to("https://www.google.com/");
		System.out.print("Test2 title is "+ driver.getTitle());
	}
	
	@Test
	public void Test3() {
		driver.navigate().to("https://www.google.com/");
		System.out.print("Test3 title is "+ driver.getTitle());
	}
	
	@AfterMethod
	public void quit(ITestResult result) throws JiraException {
		driver.quit();
		if(result.getStatus()==ITestResult.FAILURE) {
			BasicCredentials creds=new BasicCredentials("sajithatharaka@gmail.com", "");
			JiraClient jira=new JiraClient("https://dassana.atlassian.net/projects/TP", creds);
			FluentCreate create= jira.createIssue("Test Project", "Task").field(Field.SUMMARY, "This is a summary");
			
		}
	}
}
