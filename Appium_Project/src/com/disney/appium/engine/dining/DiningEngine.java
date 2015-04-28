/***********************************************************************************************************************
 * FileName - ItineraryEngine.java
 * 
 * (c) Disney. All rights reserved.
 * 
 * $Author: @disney.com $
 * $Revision: #1 $
 * $Change: 715510 $
 * $Date: November 17, 2014 $
 ***********************************************************************************************************************/

package com.disney.appium.engine.dining;

import org.openqa.selenium.WebDriver;

/**
 * Engine for the Itinerary helper methods
 * @author Michael Yardley
 */
public class DiningEngine {
	
	protected WebDriver driver;
	
	public DiningPage diningPage;
	
	
	/**
	 * Initializes the helper functions for the Itinerary page<br>
	 * URL: https://wdw-stage.disney.go.com/plan/itinerary/
	 * @param driver The WebDriver to use
	 */
	public DiningEngine(WebDriver driver) {
		this.driver = driver;
		diningPage = new DiningPage(driver);
		
	}
}