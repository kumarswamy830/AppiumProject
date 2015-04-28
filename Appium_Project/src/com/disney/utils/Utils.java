package com.disney.utils;

import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;





public class Utils {

	private static SimpleDateFormat scrShot = new SimpleDateFormat(
			"MMddyy_HHmmss");
	private static String scrShotDir = new SimpleDateFormat("MMddyy")
			.format(new Date());
	private static String strScreenshotName = "";
	public Properties miscProps = new Properties();
	
	WebDriver driver = null;

	/* Method to create screenshot */

	public String takeScreenShot(WebDriver driver, String page,
			String scriptName, String property) throws Exception {

		String name = System.getProperty("user.dir")
				+ "/ScreenShots/HkdlExecution";

		createDir(name, "HkdlExecution");

		name = name + "/HKDL_Execution_" + scrShotDir;

		createDir(name, "HKDL_Execution_TimeStamp");

		name = name + "/" + scriptName;

		createDir(name, "Test Name");

		String execlog = property;

		if (execlog.equalsIgnoreCase("NOTSET")) {
			execlog = scrShot.format(new Date());
			miscProps.setProperty("execlog", execlog);
		}

		name = name + "/" + "Log - " + miscProps.getProperty("execlog");

		createDir(name, "Log Name");

		strScreenshotName = name + "/" + page + "_"
				+ scrShot.format(new Date()) + ".png";

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(f, new File(strScreenshotName));
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

		return strScreenshotName;

	}

	/* Method to create folder structure for screenshot */

	public static void createDir(String dirName, String Message) {
		File f = new File(dirName);
		try {
			if (!f.exists()) {
				f.mkdir();
				System.out.println("Directory Created :: " + Message);
			}
		} catch (Throwable e) {
			System.out.println("Unable to create directory with " + Message);
		}
	}

	/* Method to create testng log with screenshot */
	public void testNgAlmLogsrnsht(String log, WebDriver driver, String page,
			String scriptName, String property) throws Exception {
		
		waitForDomComplete(driver, null);

		String srcPath = takeScreenShot(driver, page, scriptName, property);

		Reporter.log(log
				+ "<span style=\"background-color: #00FF00\">Passed</span>"
				+ "<br>");

		Reporter.log("<a href=\"" + srcPath + "\">Screenshot</a>" + "<br>");

	}
	
	public void testNgLogsrnsht(String log, WebDriver driver, String page,
			String scriptName, String property) throws Exception {
		
		waitForDomComplete(driver, null);

		String srcPath = takeScreenShot(driver, page, scriptName, property);

		Reporter.log(log+ "<br>");

		Reporter.log("<a href=\"" + srcPath + "\">Screenshot</a>" + "<br>");

	}
	
	/* Method to create testng log with screenshot */
	public void testNsrnsht(WebDriver driver, String page,
			String scriptName, String property) throws Exception {
		
		waitForDomComplete(driver, null);

		String srcPath = takeScreenShot(driver, page, scriptName, property);

		Reporter.log("<a href=\"" + srcPath + "\">Screenshot</a>" + "<br>");

	}

	/* Method to create testng log */
	public void testNgAlmLogs(String log) {

		Reporter.log(log
				+ "<span style=\"background-color: #00FF00\">Passed</span>"
				+ "<br>");

	}
	
	/* Method to create testng log */
	public void testNgLogs(String log) {

		Reporter.log(log + "<br>");

	}
	
	public static void waitForDomComplete(WebDriver driver, String errorMsg)
			throws Exception {
		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {

				// Returning a boolean which will perform the DOM-ready check
				// on the browser instead of checking within Selenium.

				Object obj = ((JavascriptExecutor) driver)
						.executeScript("var result = document.readyState; return (result == 'complete');");

				// We expect a Boolean object, however there have been some
				// cases where the results just aren't making sense - so for
				// the purpose of diagnostics, we're going to report any
				// odd behaviors from the browser (firefox).

				if (obj == null) {
//					Log.log(driver)
//							.warning("JavascriptExecutor object is null");
					return false;

				} else if (obj instanceof Boolean) {
					return obj.equals(true);

				} else if (obj instanceof String) {
//					Log.log(driver).warning(
//							"JavascriptExecutor object is an UNEXPECTED type "
//									+ "[" + obj.getClass().toString() + "] ["
//									+ obj.toString() + "]");
					return obj.equals("true");
				}

//				Log.log(driver).warning(
//						"JavascriptExecutor object is NOT recognized " + "["
//								+ obj.getClass().toString() + "] ["
//								+ obj.toString() + "]");

				return obj.equals(true);
			}
		};

		// Note that we're only going to wait for the majority of the global
		// time-out period and then retry for the rest of the half. This is
		// an effort to mitigate issues seen with DOM ready timeouts.

		Wait<WebDriver> wait = new WebDriverWait(driver, 45);
		try {

			wait.until(condition);

		} catch (Exception ex) {

//			Log.log(driver).warning(
//					"Dom ready-state check is taking a "
//							+ "while, will continue with a less strict check");

			try {
				condition = new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver driver) {

						// Performing a less-strict version due to time-outs
						// waiting for readyState to change to "complete".

						Object obj = ((JavascriptExecutor) driver)
								.executeScript("return document.readyState;");

						if (obj == null) {
//							Log.log(driver).warning(
//									"JavascriptExecutor object is null");
							return false;

						} else if (obj instanceof String) {

							if (obj.equals("complete")) {
//								Log.log(driver).info(
//										"DOM ready-state is complete");
								return true;

							} else if (obj.equals("interactive")) {
//								Log.log(driver)
//										.warning(
//												"DOM ready-state is interactive, will continue anyway");
								return true;

							}

//							Log.log(driver).warning(
//									"Failed waiting for DOM " + "["
//											+ obj.getClass().toString() + "] ["
//											+ obj.toString() + "]");

							return false;
						}

//						Log.log(driver).warning(
//								"JavascriptExecutor object is NOT recognized "
//										+ "[" + obj.getClass().toString()
//										+ "] [" + obj.toString() + "]");

						return (obj.equals("complete") || obj
								.equals("interactive"));
					}
				};

				wait = new WebDriverWait(driver, 15);
				wait.until(condition);

			} catch (Exception retryException) {
				String msg = (errorMsg == null || errorMsg.isEmpty()) ? "Failed to wait for DOM readyState"
						: "Failed to wait for DOM readyState, " + errorMsg;

				throw new Exception(msg);
			}
		}
	}
	
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
		}
	
	
    
	public void datePicker(int month, int day, int year,WebDriver driver) throws NumberFormatException, Exception {
		
		System.out.println(day+month+year);
		int curYear = Integer.valueOf(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).getText().trim());
		
		System.out.println("curYear"+curYear);

		while (curYear < year) {
			driver.findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			curYear = Integer.valueOf(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).getText().trim());
			System.out.println("curYear"+curYear);
		}

		int curMonth = getMonth(driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")).getText().trim());
		
		System.out.println("curMonth"+curMonth);

		while (curMonth < month) {
			driver.findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			curMonth = getMonth(driver.findElement(By.xpath(".//*[@class='ui-datepicker-month']")).getText().trim());
			
			System.out.println("curMonth1"+curMonth);
		}

		boolean dateFound = false;

		for (int i = 0; i < 5; i++) {

			if (dateFound) {
				break;
			}

			for (int j = 0; j < 7; j++) {
				String tempDay;
				try {
					tempDay = driver
							.findElement(
									By.xpath(".//*[@class='ui-datepicker-calendar']/tbody/tr["
											+ (i + 1) + "]/td[" + (j + 1) + "]"))
							.getText().trim();
					System.out.println("tempDay"+tempDay);
				} catch (Exception e) {
					tempDay = ""; // To avoid compiler errors
				}

				if (tempDay.equals(String.valueOf(day))) {
					WebElement element = driver.findElement(By.xpath(".//*[@class='ui-datepicker-calendar']/tbody/tr["
									+ (i + 1) + "]/td[" + (j + 1) + "]/a"));
					JavascriptExecutor js = (JavascriptExecutor)driver;
				    js.executeScript("arguments[0].click();", element);
					dateFound = true;
					break;
				}
			}
		}
	}
	
	/**
	 * Returns the integer representation of given month
	 *
	 * @param month
	 *            Month as a String
	 * @return Integer representation of month
	 */
	public int getMonth(String month) {
		
			if (month.equals("January")) {
				return 1;
			} else if (month.equals("February")) {
				return 2;
			} else if (month.equals("March")) {
				return 3;
			} else if (month.equals("April")) {
				return 4;
			} else if (month.equals("May")) {
				return 5;
			} else if (month.equals("June")) {
				return 6;
			} else if (month.equals("July")) {
				return 7;
			} else if (month.equals("August")) {
				return 8;
			} else if (month.equals("September")) {
				return 9;
			} else if (month.equals("October")) {
				return 10;
			} else if (month.equals("November")) {
				return 11;
			} else if (month.equals("December")) {
				return 12;
			}
		

		return -1;
	}
}
