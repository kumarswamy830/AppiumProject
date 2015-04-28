package com.disney.appium.engine.dining;

import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.disney.utils.Utils;


public class T02_DiningListing {
	
	WebDriver driver = null;
	Utils commonMethods = new Utils();
	
	
	static public class DateStruct {
        public int month;
        public int day;
        public int year;
    }
	
    private Calendar calendar = Calendar.getInstance();

	
	//Device configuration for browser 
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
				300);

		 
		driver = new RemoteWebDriver(new URL(
				"http://127.0.0.1:4723/wd/hub"), capabilities);
		  
		}
	
	@Test
	public void menuTest() throws Exception {


		String    baseUrl = "https://stage.www.hongkongdisneyland.com/";
		
		String scriptName = "T02_DiningListing";
		
		
		
		System.out.println("Starting browser");
	  
	    driver.get(baseUrl);
	    
	    System.out.println("Page title: "+driver.getTitle());
	
 
	    driver.findElement(By.xpath("//*[@id='mobileNavToggle']")).click();
	    
	    driver.findElement(By.xpath("//nav/li[1]/div[1]")).click();
	    
	    driver.findElement(By.xpath("//nav/li[1]/div[2]/div/div[1]/ul//li"));
	    
	    String log = "Step 1: Clicked on 'Things To Do' from the Global Nav, All activities results are displayed";
	    
	    commonMethods.testNgAlmLogsrnsht(log, driver, "Home_page", scriptName, "NOTSET");
	    
	    driver.findElement(By.xpath("//nav/li[1]/div[2]/div/div[1]/ul/li[4]/a")).click();
	    
	    commonMethods.waitForDomComplete(driver, null);
	    
		log = "Clicked on 'Attractions' , Navigated to attrations page";
	    
	    commonMethods.testNgAlmLogsrnsht(log, driver, "Attacrions_page", scriptName, "SET");
	    
	    if(driver.findElements(By.xpath("//*[contains(@class,'siteSurveyDialog')]")).size()!=0){
	    	
	    	driver.findElement(By.xpath("//*[@id='modalUIPlusButtonPane']/div[2]/span")).click();
	    	
	    	log = "Survey popup displayed and clicked on 'No Thanks' button";
	    	
	    	commonMethods.testNgLogs(log);
	    }
	    
	    Thread.sleep(10000);
	    
	    commonMethods.waitForDomComplete(driver,null);
	    
	    WebElement attractionDropdown= driver.findElement(By.xpath("//*[@id='activitySelect']"));
	    
	    Select s = new Select(attractionDropdown);
	    
	    s.selectByValue("dining");
	    
	    Thread.sleep(10000);
	    
        log = "Step 3: Selected \"Dining\" from the \"All Activities\" drop down, Dining entities are selected and displayed";
	    
	    commonMethods.testNgAlmLogsrnsht(log, driver, "Dining_page", scriptName, "SET");
	    
	    driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
	    log = "Step 4: Verified info in each listing card, validated following info in each listing card: Thumbnail,Name,Facets,cuisine type,Location";
	    
	    commonMethods.testNgAlmLogs(log);
	    
	    driver.findElement(By.xpath("//*[@id='availabilityForm-searchDateid-base']/div/button")).click();
	    
	    calendar.add(Calendar.DATE, 2);

		DateStruct date = new DateStruct();
		date.month = calendar.get(Calendar.MONTH) + 1;
		date.day = calendar.get(Calendar.DATE);
		date.year = calendar.get(Calendar.YEAR);
		
		commonMethods.datePicker(date.month, date.day, date.year, driver);
		
		commonMethods.waitForDomComplete(driver, null);
		
		log = "Step 5: Tested schedule module by changing the date, Schedule module time has changed with in listing card";
		
		commonMethods.testNgAlmLogsrnsht(log, driver, "Diningpage_ModifiedDate ", scriptName, "SET");
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    WebElement element = driver.findElement(By.xpath("//input[@id='sort_alpha']"));
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", element);
	    
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
	    Thread.sleep(10000);
	    
        driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
        log = "Sorted by Name";
		
		commonMethods.testNgLogsrnsht(log, driver, "Diningpage_SortbyName ", scriptName, "SET");
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    element = driver.findElement(By.xpath("//input[@id='sort_location']"));
	    
	   
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
	    Thread.sleep(10000);
	    
        driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
        log = "Sorted by Location";
		
		commonMethods.testNgLogsrnsht(log, driver, "Diningpage_SortbyLocation ", scriptName, "SET");
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    element = driver.findElement(By.xpath("//input[@id='sort_cuisine']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
	    Thread.sleep(10000);
	    
        driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
        log = "Sorted by Cuisine";
		
		commonMethods.testNgLogsrnsht(log, driver, "Diningpage_SortbyCuisine ", scriptName, "SET");
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    element = driver.findElement(By.xpath("//input[@id='sort_diningType']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
	    Thread.sleep(10000);
	    
        driver.findElement(By.xpath("//picture[@class='thumbnail']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/h2[@class='cardName']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='dining type']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='facets']"));
	    
	    driver.findElement(By.xpath("//div[@class='itemInfo']/span[@aria-label='location']"));
	    
        log = "Sorted by DiningType";
		
		commonMethods.testNgLogsrnsht(log, driver, "Diningpage_SortbyType ", scriptName, "SET");
		
		log = "Step 6: Sorted by Name,Location,Cuisine,Type";
		
		commonMethods.testNgAlmLogs(log);
	    
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
	    
        log = "Filtered  by Reservations Accepted";
		
		commonMethods.testNgLogsrnsht(log, driver, "Diningpage_Filteredby_ReservationsAccepted ", scriptName, "SET");
	    
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
	    
        log = "Filtered  by Reservations Accepted,Quick Service";
		
		commonMethods.testNgLogsrnsht(log, driver, "Diningpage_Filteredby_ReservationsAccepted_QuickService ", scriptName, "SET");
	    
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
	    
        log = "Filtered  by Reservations Accepted,Quick Service,Outdoor Vending Cart";
		
		commonMethods.testNgLogsrnsht(log, driver, "Diningpage_Filteredby_ReservationsAccepted_QuickService_OutdoorVendingCart ", scriptName, "SET");
	    
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
	    
        log = "Filtered  by Reservations Accepted,Quick Service,Outdoor Vending Cart,Price Range";
		
		commonMethods.testNgLogsrnsht(log, driver, "Diningpage_Filteredby_ReservationsAccepted_QuickService_OutdoorVendingCart_PriceRange ", scriptName, "SET");
	    
	    driver.findElement(By.xpath("//section[@id='finderListMetaForms']/div[2]/button")).click();
	    
	    log = "Cleared all filters";
	    
	    commonMethods.testNgLogsrnsht(log, driver, "Diningpage_NoFilters", scriptName, "SET");
	    
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
	    
	    Thread.sleep(10000);
	    
        log = "Filtered  by Western";
		
		commonMethods.testNgLogsrnsht(log, driver, "Diningpage_Filteredby_Western ", scriptName, "SET");
		
		log = "Step 7 : Guest is able to use each of the options in each of the facets individually and in combination and the filtering is applied correctly";
		
		commonMethods.testNgAlmLogs(log);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
        element = driver.findElement(By.xpath("//fieldset[5]/legend"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='reservations-accepted']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
        element = driver.findElement(By.xpath("//fieldset[6]/legend"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='quick-service']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
        element = driver.findElement(By.xpath("//fieldset[7]/legend"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='outdoor-vending-cart']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
        element = driver.findElement(By.xpath("//fieldset[8]/legend"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='hk100-and-under']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    log = "Facets selected are Dining Experience,Price Range,Cuisine";
	    
	    commonMethods.testNgLogs(log);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
        Thread.sleep(10000);
        
        commonMethods.testNgLogsrnsht(log, driver, "DiningPage", scriptName, "SET");
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    boolean status=driver.findElement(By.xpath("//input[@id='reservations-accepted']")).isSelected();
	    
	    commonMethods.testNgLogs("Reservations-accepted checkbox status : "+status);
	    
	    Assert.assertTrue(status);
	    
        status=driver.findElement(By.xpath("//input[@id='quick-service']")).isSelected();
	    
        commonMethods.testNgLogs("Quick-service checkbox status : "+status);
        
        Assert.assertTrue(status);
	    
        status=driver.findElement(By.xpath("//input[@id='outdoor-vending-cart']")).isSelected();
	    
        commonMethods.testNgLogs("Outdoor-vending-cart checkbox status : "+status);
        
        Assert.assertTrue(status);
	    
        status=driver.findElement(By.xpath("//input[@id='hk100-and-under']")).isSelected();
	    
        commonMethods.testNgLogs("Hk100-and-under checkbox status : "+status);
        
        Assert.assertTrue(status);
	    
        status=driver.findElement(By.xpath("//input[@id='western']")).isSelected();
	    
        commonMethods.testNgLogs("Western checkbox status : "+status);
        
        Assert.assertTrue(status);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
        Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//section[@id='finderListMetaForms']/div[2]/button")).click();
	    
        Thread.sleep(10000);
        
        log = "Clicked Clear Filters in a facet group ";
        
        commonMethods.testNgLogs(log);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    status=driver.findElement(By.xpath("//input[@id='reservations-accepted']")).isSelected();
	    
	    commonMethods.testNgLogs("Reservations-accepted checkbox status : "+status);
	    
	    Assert.assertFalse(status);
	    
        status=driver.findElement(By.xpath("//input[@id='quick-service']")).isSelected();
	    
        commonMethods.testNgLogs("Quick-service checkbox status : "+status);
        
        Assert.assertFalse(status);
	    
        status=driver.findElement(By.xpath("//input[@id='outdoor-vending-cart']")).isSelected();
	    
        commonMethods.testNgLogs("Outdoor-vending-cart checkbox status : "+status);
        
        Assert.assertFalse(status);
	    
        status=driver.findElement(By.xpath("//input[@id='hk100-and-under']")).isSelected();
	    
        commonMethods.testNgLogs("Hk100-and-under checkbox status : "+status);
        
        Assert.assertFalse(status);
	    
        status=driver.findElement(By.xpath("//input[@id='western']")).isSelected();
	    
        commonMethods.testNgLogs("Western checkbox status : "+status);
        
        Assert.assertFalse(status);
        
        log = "Step 8 : Clicked Clear Filters in a facet group, All the facet filters in that filter group are unchecked";
        
        commonMethods.testNgAlmLogsrnsht(log, driver, "FilterPage", scriptName, "SET");
	    
	    element = driver.findElement(By.xpath("//input[@id='reservations-accepted']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='quick-service']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='outdoor-vending-cart']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    element = driver.findElement(By.xpath("//input[@id='hk100-and-under']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
        element = driver.findElement(By.xpath("//input[@id='western']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
        Thread.sleep(10000);
        
        log = "Facets selected are Dining Experience,Price Range,Cuisine";
	    
	    commonMethods.testNgLogsrnsht(log, driver, "Diningpage_FacetsSelected", scriptName, "SET");
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    status=driver.findElement(By.xpath("//input[@id='reservations-accepted']")).isSelected();
	    
	    commonMethods.testNgLogs("Reservations-accepted checkbox status : "+status);
	    
	    Assert.assertTrue(status);
	    
        status=driver.findElement(By.xpath("//input[@id='quick-service']")).isSelected();
	    
        commonMethods.testNgLogs("Quick-service checkbox status : "+status);
        
        Assert.assertTrue(status);
	    
        status=driver.findElement(By.xpath("//input[@id='outdoor-vending-cart']")).isSelected();
	    
        commonMethods.testNgLogs("Outdoor-vending-cart checkbox status : "+status);
        
        Assert.assertTrue(status);
	    
        status=driver.findElement(By.xpath("//input[@id='hk100-and-under']")).isSelected();
	    
        commonMethods.testNgLogs("Hk100-and-under checkbox status : "+status);
        
        Assert.assertTrue(status);
	    
        status=driver.findElement(By.xpath("//input[@id='western']")).isSelected();
	    
        commonMethods.testNgLogs("Western checkbox status : "+status);
        
        Assert.assertTrue(status);
	    
        element = driver.findElement(By.xpath("//*[@id='resetButton']"));
	    
	    js.executeScript("arguments[0].click();", element);
	    
	    commonMethods.testNgLogs("Clicked on 'Reset' button");
	    
	    driver.findElement(By.xpath("//*[@id='finderFacets']/div/button")).click();
	    
        Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//*[@id='filterBtn']")).click();
	    
	    status=driver.findElement(By.xpath("//input[@id='reservations-accepted']")).isSelected();
	    
	    commonMethods.testNgLogs("Reservations-accepted checkbox status : "+status);
	    
	    Assert.assertFalse(status);
	    
        status=driver.findElement(By.xpath("//input[@id='quick-service']")).isSelected();
	    
        commonMethods.testNgLogs("Quick-service checkbox status : "+status);
        
        Assert.assertFalse(status);
	    
        status=driver.findElement(By.xpath("//input[@id='outdoor-vending-cart']")).isSelected();
	    
        commonMethods.testNgLogs("Outdoor-vending-cart checkbox status : "+status);
        
        Assert.assertFalse(status);
	    
        status=driver.findElement(By.xpath("//input[@id='hk100-and-under']")).isSelected();
	    
        commonMethods.testNgLogs("Hk100-and-under checkbox status : "+status);
        
        Assert.assertFalse(status);
	    
        status=driver.findElement(By.xpath("//input[@id='western']")).isSelected();
	    
        commonMethods.testNgLogs("Western checkbox status : "+status);
        
        Assert.assertFalse(status);
        
        log = "Step 9 : Clicked Reset button on filter page, All the facet filters in that filter group are unchecked";
        
        commonMethods.testNgAlmLogsrnsht(log, driver, "FilterPage", scriptName, "SET");
        
		int diningRestaurantSize = driver
				.findElements(
						By.xpath("//li[@class='card show']//a"))
				.size();
		
		System.out.println("diningRestaurantSize"+diningRestaurantSize);

		int randomRestaurantNumber = (int) Math.floor(Math.random()
				* diningRestaurantSize);
		
		System.out.println("randomRestaurantNumber"+randomRestaurantNumber);


		if (randomRestaurantNumber == 0) {

			randomRestaurantNumber = 1;

		}
		
		List<WebElement> list=driver.findElements(By.xpath("//li[@class='card show']//a"));
		
		element = list.get(randomRestaurantNumber);
		
		js.executeScript("arguments[0].click();", element);
		
		commonMethods.waitForDomComplete(driver, null);
		
		log = "Clicked on random restaurant";
		
		commonMethods.testNgLogsrnsht(log, driver, "Dining_page_with_restaurants", scriptName, "SET");
		
		driver.findElement(By.xpath("//*[@class='finderDetailsExperienceImage']"));
		
		commonMethods.testNgLogs("Verified image on restaurant detail page");
		
        driver.findElement(By.xpath(".//*[contains(@class,'standardContentContainer')]"));
		
		commonMethods.testNgLogs("Verified content on restaurant detail page");
		
		log = "Step 10: Selected one of the restaurants at random and navigated to restaurant detail page";
		
		commonMethods.testNgAlmLogsrnsht(log, driver, "Restaurant_Detail_Page", scriptName, "SET");


	    
	   
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
