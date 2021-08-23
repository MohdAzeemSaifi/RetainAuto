package com.retain.utility;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
//import org.testng.annotations.*;
import org.junit.BeforeClass;
import java.time.Duration;

public class ClientProvider {
	
	public static final Logger log = LogManager.getLogger(RetainWebHelper.class);
  
    
	public void createWorker(RetainWebElements retainPage_object, String ModuleName, String workerName) {

	}

	public boolean createSchedule(WebDriver retainDriver, RetainWebElements retainPage_object, String scheduleName,
			String scheduleMonth, String scheduleYear, String scheduleDay, String scheduleHour,
			String scheduleMinutes) {
		try {
			log.debug(scheduleMinutes);
			retainDriver.switchTo().frame(0);
			log.debug("Click on Add schedule");
			retainPage_object.AddSchedule().click();
			// retainDriver.findElement(By.name("Add")).click();
			// retainDriver.fi
			log.debug("creating a schdule with the name: "+scheduleName);
			retainPage_object.ScheduleId().clear();
			retainPage_object.ScheduleId().sendKeys(scheduleName);

			log.debug("Select month: "+scheduleMonth);
			Select s = new Select(retainPage_object.MydateMonth());
			s.selectByValue(scheduleMonth);

			log.debug("Select year: "+scheduleYear);
			Select s1 = new Select(retainPage_object.MydateYear());
			s1.selectByValue(scheduleYear);

			log.debug("Select day: "+scheduleDay);
			Select s2 = new Select(retainPage_object.MydateDay());
			s2.selectByValue(scheduleDay);

			log.debug("Select hours: "+scheduleYear);
			Select seTime1 = new Select(retainPage_object.MydateHours());
			seTime1.selectByValue(scheduleHour);

			log.debug("Select minutes: "+scheduleYear);
			Select seTime2 = new Select(retainPage_object.MydateMinute());
			seTime2.selectByValue(scheduleMinutes);
			
			log.debug("Saving the changes");
			retainPage_object.SaveChanges().click();
			retainDriver.switchTo().defaultContent();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;

	}

}