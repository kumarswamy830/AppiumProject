package com.disney.appium.engine.dining;

import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Browser_Mobile {
	
	WebDriver driver = null;
	
	
	@BeforeMethod
	
	public void openBrowser() throws MalformedURLException{
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				"Android");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		// capabilities.setCapability(MobileCapabilityType.APP,"Chrome");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				"Galaxy S5");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				"4.4.2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
				200);

		 
		driver = new RemoteWebDriver(new URL(
				"http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		}
	
	@Test
	public void menuTest() throws Exception {


		String    baseUrl = "https://stage.www.hongkongdisneyland.com/";
		
		System.out.println("Starting browser");
	  
		//Thread.sleep(10000);
	    driver.get(baseUrl);
	    
	    System.out.println("Page title: "+driver.getTitle());
	

	    driver.findElement(By.xpath("//*[@id='mobileNavToggle']")).click();
	    
	    driver.findElement(By.xpath("//nav/li[1]/div[1]")).click();
	    
	    driver.findElement(By.xpath("//nav/li[1]/div[2]/div/div[1]/ul/li[4]/a")).click();
	    
	    Thread.sleep(10000);
	    
	    WebElement attractionDropdown= driver.findElement(By.xpath("//*[@id='activitySelect']"));
	    
	    Select s = new Select(attractionDropdown);
	    
	    s.selectByValue("dining");
	    
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    WebElement element = driver.findElement(By.xpath("//input[@id='sort_alpha']"));
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", element);
	    
	  
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    element = driver.findElement(By.xpath("//input[@id='sort_location']"));
	    
	   
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    element = driver.findElement(By.xpath("//input[@id='sort_cuisine']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    element = driver.findElement(By.xpath("//input[@id='sort_diningType']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
        element = driver.findElement(By.xpath("//fieldset[5]/legend"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='reservations-accepted']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
        driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
		   
        element = driver.findElement(By.xpath("//fieldset[6]/legend"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='quick-service']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
        driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
		   
        element = driver.findElement(By.xpath("//fieldset[7]/legend"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='outdoor-vending-cart']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
        driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
		   
        element = driver.findElement(By.xpath("//fieldset[8]/legend"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='hk100-and-under']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
        driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//section[@id='finderListMetaForms']/div[2]/button")).click();
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
		   
        element = driver.findElement(By.xpath("//fieldset[9]/legend"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='western']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
        driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
