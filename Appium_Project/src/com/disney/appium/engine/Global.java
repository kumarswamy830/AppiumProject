/***********************************************************************************************************************
 * FileName - Global.java
 * 
 * (c) Disney. All rights reserved.
 * 
 * $Authors: 
 * Thomas.Kessler@disney.com, Tigran.Khanpapyan@disney.com, Jarad.Medbery@disney.com, 
 * Michael.Yardley@disney.com, Son.Huy.Pham@disney.com $   
 * $Revision: #1 $
 * $Change: 715510 $
 * $Date: November  19, 2014 $
 ***********************************************************************************************************************/

package com.disney.appium.engine;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.disney.appium.engine.dining.DiningEngine;


/**
 * Singleton class to access Engine's variables
 */
public class Global {

	public DiningEngine diningEngine; 
	
	
	private Global(WebDriver driver, 
		DiningEngine diningMeEngine 
		) {
			this.diningEngine = diningMeEngine;
			
		}

	public static void setGlobalClass(WebDriver driver,
			DiningEngine diningMeEngine 
			) {

		global.put(driver.toString(), new Global(driver, 
				diningMeEngine
				));
	}

	public static Global getGlobalObject(WebDriver driver) {
		return global.get(driver.toString());
	}

	// private static Global global;
	private static Map<String, Global> global = new HashMap<String, Global>();
}
