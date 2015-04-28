/***********************************************************************************************************************
 * FileName - Engine.java
 * 
 * (c) Disney. All rights reserved.
 * 
 * $Author: ANDAK003 $
 * $Revision: #1 $
 * $Date: April 26, 2015 $
 ***********************************************************************************************************************/

package com.disney.appium.engine;

import org.openqa.selenium.WebDriver;


import com.disney.appium.engine.dining.DiningEngine;

/**
 * Core Engine class that allows you to call any of the helper functions
 * 
 * @author kaiy001
 */
public class Engine {

	protected WebDriver driver;

	public DiningEngine diningEngine;
	
	/**
	 * Initializes all of the sub-engine classes
	 * 
	 * @param driver
	 *            The WebDriver to use
	 * @param testName
	 *            Name to use for test (used in log file)
	 */
	public Engine(WebDriver driver, String testName) {
		this.driver = driver;

		diningEngine = new DiningEngine(driver);
		

		// TODO (SonHuy Pham) - This should really take in an interface of some
		// sort to avoid expanding the function-prototype/arguments every time
		// a new page is introduced.  Just my opinion, but especially since  
		// the static Global class stores everything in a map anyway.
		
		Global.setGlobalClass(driver, 
				diningEngine
				
				);
	}
}
