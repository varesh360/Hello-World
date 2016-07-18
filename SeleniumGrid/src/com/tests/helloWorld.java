package com.tests;
 
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class helloWorld {
   private WebDriver driver;
   private String baseUrl;
 
   @BeforeMethod
   public void setUp() throws MalformedURLException {
      URL hubUrl = new URL("http://192.168.0.100:6666/wd/hub");
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setBrowserName("firefox");
      capabilities.setPlatform(Platform.WIN8_1);
 
      driver = new RemoteWebDriver(hubUrl, capabilities);
      baseUrl = "http://www.google.com/";
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }
 
   @Test
   public void windowsTest() {
      driver.get(baseUrl);
      Reporter.log("Opened a browser");
      
      System.out.println("This is a Hello World Program");
      
   }
 
   @AfterMethod
   public void tearDown() {
	   System.out.println("close driver");
      driver.quit();
   }
}