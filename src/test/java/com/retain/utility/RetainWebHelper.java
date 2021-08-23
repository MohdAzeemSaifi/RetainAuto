package com.retain.utility;

import static novell.util.Log.Debug_VVVV;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RetainWebHelper extends PropertiesProvider {

	/***
	 * 
	 * @throws Exception
	 */
	public boolean initalSetup() throws Exception {
		LOGGER.debug("Initialize Webdriver Setup..");
		LOGGER.debug("Setting browsers driver location.");

		retainDriver = setUpDriver(browser_Selected);

		if (loadLoginURL()) {
			LOGGER.debug("load Retain Server URL.");
			return true;
		} else {
			LOGGER.debug("Load Retain Server URL failed. Quit Execution.");
			return false;
		}
	}

	/***
	 * Browser Setup.
	 * 
	 * @param browser_Name
	 * @return
	 * @throws Exception
	 */
	protected WebDriver setUpDriver(String browser_Name) throws Exception {
		LOGGER.debug("Setting up properties file");
		// props = AutoProperties.getGlobalProps(prop_file);
		LOGGER.debug("Initializing Desired Capablities.");
		DesiredCapabilities capability;
		LOGGER.debug("Checking for Browser Name in Properties File.");
		if (browser_Name.equalsIgnoreCase("firefox")) {
			LOGGER.debug("Browser: Firefox");
			LOGGER.debug("Setting Capabilities for firefox.");
			capability = DesiredCapabilities.firefox();
			LOGGER.debug("Setting up system properties for Gecko Driver form loacation: " + script_Location_in_Windows);
			System.setProperty("webdriver.gecko.retainDriver", script_Location_in_Windows + "geckodriver");

			LOGGER.debug("Setting up \"Marionette\" Capability");
			capability.setCapability("marionette", true);
			LOGGER.debug("Initialize Webdriver Remote Driver.");
			LOGGER.debug("Gecko Driver version is :" + capability.getVersion());
			retainDriver = new RemoteWebDriver(new URL("http://" + RemoteDriver_IP + ":" + Port + "/wd/hub"),
					capability);
		} else if (browser_Name.equalsIgnoreCase("chrome")) {
			LOGGER.debug("Browser: Chrome");
			LOGGER.debug("Setting Capabilities for Chrome.");
			ChromeOptions options = new ChromeOptions();

			// options.setBinary(new File("C:\\Program
			// Files\\Google\\Chrome\\Application\\chrome.exe"));
			capability = DesiredCapabilities.chrome();
			capability.setCapability(ChromeOptions.CAPABILITY, options);
			capability.acceptInsecureCerts();
			LOGGER.debug(
					"Setting up system properties for Chrome Driver form loacation: " + script_Location_in_Windows);
			System.setProperty("webdriver.chrome.driver", script_Location_in_Windows + "chromedriver.exe");
			LOGGER.debug("Initialize Webdriver Remote Driver.");

			LOGGER.debug("Remote Desktop IP:" + RemoteDriver_IP);
			// retainDriver = new RemoteWebDriver(new URL("http://" + RemoteDriver_IP + ":"
			// + Port + "/wd/hub"),
			// capability);
			retainDriver = new ChromeDriver();
		} else if (browser_Name.equalsIgnoreCase("Edge")) {
			// ToDo!
		} else if (browser_Name.equalsIgnoreCase("ie")) {
			// ToDo!
		} else if (browser_Name.equalsIgnoreCase("safari")) {
			// ToDo!
		} else {
			retainDriver = null;
			LOGGER.debug("Please provide one of the following browser name: \"Firefox, Chrome, IE.\"");
		}
		return retainDriver;
	}

	/***
	 * Load filr URL on browser.
	 * 
	 * @return true/false
	 */
	public boolean loadLoginURL() {
		String baseURL = "http://" + retain_IP + "/RetainServer";
		LOGGER.debug("Launching Browser");
		LOGGER.debug("Loading URL: " + baseURL);
		retainDriver.get(baseURL);
		LOGGER.debug("Creating Page Factory object for \"retainPage_object.java \"class.");
		retainPage_object = PageFactory.initElements(retainDriver, RetainWebElements.class);
		maximizeBrowser();
		LOGGER.debug("Waiting for loginUserName element.");
		// wait_For_Element_For_60Sec(retainPage_object.loginUsername());
		LOGGER.debug("Checking for Title \"Micro Focus Retain\" and Login: " + retainPage_object.loginUsername()
				+ " Title is: " + retainDriver.getTitle());
		if (retainDriver.getTitle().equals("Micro Focus Retain")
				&& isElementPresent(retainPage_object.loginUsername())) {
			LOGGER.debug(
					"Title \" Micro Focus Retain\"  and Login: \"" + retainPage_object.loginUsername() + " Found.");
			LOGGER.debug("Return True.");
			return true;
		} else if (retainDriver.getTitle().equals("Retain: Configuration Wizard")) {
			LOGGER.debug("Title Retain: Configuration Wizard Found.");
			LOGGER.debug("Return True.");
			return true;
		} else {
			LOGGER.debug("Title \"Retain\"  and Login: \"" + retainPage_object.loginUsername() + " Not Found.");
			LOGGER.debug("Also try with configuration page Title Retain: Configuration Wizard Not Found.");
			LOGGER.debug("Return False");
			return false;

		}
	}

	/***
	 * Maximizing the browser.
	 */
	public void maximizeBrowser() {
		LOGGER.debug("Maximize Browser.");
		retainDriver.manage().window().maximize();
	}

	/***
	 * Browser Refresh.
	 */
	public void refreshBrowser() {
		LOGGER.debug("Refresh Browser. \"F5\"");
		retainDriver.navigate().refresh();
	}

	/***
	 * Implement Fluent wait, Does not Ignore any class, Accepts Web-Element,
	 * Polling time and TimeOut in Seconds.
	 * 
	 * @param pollingEvery
	 * @param timeOut
	 * @param findBy_Element
	 * @return
	 */
	public WebElement wait_For_element_fluentWait(long pollingEvery, long timeOut, final WebElement findBy_Element) {
		LOGGER.debug("Initializing Fluent wait.");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(retainDriver).pollingEvery(Duration.ofSeconds(pollingEvery))
				.withTimeout(Duration.ofSeconds(timeOut));

		LOGGER.debug("Returning Element");
		return wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement((By) findBy_Element);
			}
		});
	}

	/***
	 * Explicit wait for elements for 60 seconds.
	 * 
	 * @param findBy_Element
	 * @return
	 */
	public WebElement wait_For_Element_For_60Sec(WebElement findBy_Element) {

		try {
			LOGGER.debug("Initialize WebDriver wait");
			WebDriverWait wait = new WebDriverWait(retainDriver, 60);
			return wait.until(ExpectedConditions.visibilityOf(findBy_Element));
		} catch (NoSuchElementException e) {
			LOGGER.debug("No Such Element Present. : " + findBy_Element);
			return null;

		}
	}

	/***
	 * Check presence of WEB-Element.
	 * 
	 * @param findBy_Element
	 * @return
	 */
	public boolean isElementPresent(WebElement findBy_Element) {
		try {
			LOGGER.debug("Find Element: " + findBy_Element);
			findBy_Element.getTagName();
			LOGGER.debug("Element Found.");
			return true;
		} catch (NoSuchElementException e) {
			LOGGER.debug("No Such Element Present : " + findBy_Element);
			return false;
		}
	}

	/***
	 * 
	 * @throws Exception
	 */
	public boolean LoginRetainServer() throws Exception {
		try {
			retainPage_object.loginUsername().sendKeys("admin");
			retainPage_object.loginPassword().sendKeys("novell");
			retainPage_object.login_Btn().click();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.debug(e.getMessage());
			return false;
		}
		return true;

	}

	
	/***
	 * 
	 * @throws Exception
	 */
	public boolean LogoutRetainServer() throws Exception {
		try {
			retainDriver.switchTo().defaultContent();
			retainPage_object.Logout().click();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.debug(e.getMessage());
			return false;
		}
		return true;

	}

	
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean LoadURL() throws Exception {

		if (initalSetup()) {
			LOGGER.debug("URL is load successfully");
			return true;
		} else {
			LOGGER.debug("URL is load failed..");
			return false;
		}

	}

	/***
	 * 
	 * @return
	 */
	public boolean basePathConfiguration() {

		// Base Path Configuration...
		if (isElementPresent(retainPage_object.ConfigDone()) && isElementPresent(retainPage_object.Next())) {
			LOGGER.debug("Already Configured Path. Hence moving to next page and Message as:");
			LOGGER.debug(retainPage_object.ConfigDone().getText());
			retainPage_object.Next().click();
			return true;
		} else if (isElementPresent(retainPage_object.ConfigurationWelcomePage())) {
			LOGGER.debug("We are on configuration Page. Let's start configuration");
			if (isElementPresent(retainPage_object.storagePath())) {
				Select se = new Select(retainPage_object.basePath());
				se.selectByVisibleText(basePath);
				if (basePath.equals("custom")) {
					retainPage_object.customPath().clear();
					retainPage_object.customPath().sendKeys(customPath);
				}
			}
			if (isElementPresent(retainPage_object.continueButton())) {
				retainPage_object.continueButton().click();
				return true;
			} else {
				LOGGER.debug("Continue Button not found..");
				return false;
			}
		} else {
			LOGGER.debug("Configuration page not found. Please check the setup.");
			return false;
		}
	}

	public boolean messageStoreDatabaseCongig() {
		// Message Store DataBase:
		LOGGER.debug("We are on Message store database page..");
		if (isElementPresent(retainPage_object.ConfigDone()) && isElementPresent(retainPage_object.Next())) {
			LOGGER.debug("Already Configured Message Store Database. Hence moving to next page");
			retainPage_object.Next().click();
		} else if (isElementPresent(retainPage_object.DatabaseEntryPage())) {
			LOGGER.debug("Continue with Message store database..");
			Select se = new Select(retainPage_object.DriverEntry());
			se.selectByVisibleText(DatabaseDriver);
			retainPage_object.DatabaseServerEntry().clear();
			retainPage_object.DatabaseServerEntry().sendKeys(DatabaseServer);

			retainPage_object.DatabaseNameEntry().clear();
			retainPage_object.DatabaseNameEntry().sendKeys(DatabaseName);

			if (DatabaseDriver.equals("MS SQL 2005,2008,2012,2014,2016,2017,2019")) {
				retainPage_object.DBInstance().clear();
				retainPage_object.DBInstance().sendKeys(DatabaseInstance);
			}

			retainPage_object.DBUsername().clear();
			retainPage_object.DBUsername().sendKeys(DatabaseUsername);

			retainPage_object.DBPassword().clear();
			retainPage_object.DBPassword().sendKeys(DatabasePassword);
			retainPage_object.continueButton().click();

			if (isElementPresent(retainPage_object.Error())) {
				LOGGER.debug("Please check the Error Message and DB details and Error is :");
				LOGGER.debug(retainPage_object.Error().getText());
				return false;
			}

		} else {
			LOGGER.error("Message Store DataBase page not found.");
			return false;
		}
		return true;
	}

	public boolean databaseConfiguration() {
		LOGGER.debug("We are on Database configuration page..");
		// Configuration DataBase:
		try {
			if (isElementPresent(retainPage_object.ConfigDone()) && isElementPresent(retainPage_object.Next())) {
				LOGGER.debug("Already Configured Database. Hence moving to next page");
				retainPage_object.Next().click();
			} else {
				LOGGER.debug("Continue with DataBase configuration..");
				Select se = new Select(retainPage_object.DriverEntry());
				se.selectByVisibleText(DatabaseDriver);
				retainPage_object.DatabaseServerEntry().clear();
				retainPage_object.DatabaseServerEntry().sendKeys(DatabaseServer);

				retainPage_object.DatabaseNameEntry().clear();
				retainPage_object.DatabaseNameEntry().sendKeys(DatabaseName);

				if (DatabaseDriver.equals("MSSQL")) {
					retainPage_object.DBInstance().clear();
					retainPage_object.DBInstance().sendKeys(DatabaseInstance);
				}

				retainPage_object.DBUsername().clear();
				retainPage_object.DBUsername().sendKeys(DatabaseUsername);

				retainPage_object.DBPassword().clear();
				retainPage_object.DBPassword().sendKeys(DatabasePassword);
				if (isSslEnable.equals("true")) {
					retainPage_object.enableSSL().click();
				}
				retainPage_object.continueButton().click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean administratorAccountConfig() {
		LOGGER.debug("We are on Administrator configuration page..");
		// Administrator Account..
		try {
			if (isElementPresent(retainPage_object.ConfigDone()) && isElementPresent(retainPage_object.Next())) {
				LOGGER.debug("Already Administrator Account. Hence moving to next page");
				retainPage_object.Next().click();
			} else {
				LOGGER.debug("Continue with administrator configuration..");
				retainPage_object.adminUser().clear();
				retainPage_object.adminUser().sendKeys(adminUser);
				retainPage_object.adminPassword().clear();
				retainPage_object.adminPassword().sendKeys(adminPassword);
				retainPage_object.confirmPassword().clear();
				retainPage_object.confirmPassword().sendKeys(adminPassword);
				retainPage_object.continueButton().click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean smtpConfiguration() {
		LOGGER.debug("We are on SMTP configuration Page");
		try {
			// SMTP configuration..
			if (isElementPresent(retainPage_object.ConfigDone()) && isElementPresent(retainPage_object.Next())) {
				LOGGER.debug("Already Configured SMTP Details. Hence moving to next page");
				retainPage_object.Next().click();
			} else {
				LOGGER.debug("Continue with SMTP Details configuration..");
				retainPage_object.smtpServer().clear();
				retainPage_object.smtpServer().sendKeys(smtpMailServer);

				Select se = new Select(retainPage_object.smtpProtocol());
				se.selectByVisibleText(smtpSecurityProtocol);

				retainPage_object.smtpPort().clear();
				retainPage_object.smtpPort().sendKeys(smtpPort);

				retainPage_object.smtpFrom().clear();
				retainPage_object.smtpFrom().sendKeys(smtpMailFromAddress);

				retainPage_object.smtpTo().clear();
				retainPage_object.smtpTo().sendKeys(smtpToAddress);

				retainPage_object.smtpUser().clear();
				retainPage_object.smtpUser().sendKeys(smtpUsername);

				retainPage_object.smtpPass().clear();
				retainPage_object.smtpPass().sendKeys(smtpPassword);

				retainPage_object.continueButton().click();
			}

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean indexingConfiguration() {

		LOGGER.debug("We are on indexing configuration page");
		try {
			// Indexing Engine Configuration..
			if (isElementPresent(retainPage_object.ConfigDone()) && isElementPresent(retainPage_object.Next())) {
				LOGGER.debug("Already Configured Details");
				retainPage_object.Next().click();
			} else {
				LOGGER.debug("Continue with Indexing Engine Configuration.");
				retainPage_object.IndexingPort().clear();
				retainPage_object.IndexingPort().sendKeys(IndexingPort);

				retainPage_object.IndexingUsername().clear();
				retainPage_object.IndexingUsername().sendKeys(IndexingUsername);

				retainPage_object.IndexingPassword().clear();
				retainPage_object.IndexingPassword().sendKeys(IndexingPassword);
				retainPage_object.continueButton().click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean retainConnectionConfigration() {
		LOGGER.debug("We are on retain connection server configuration page ");
		try {
			if (isElementPresent(retainPage_object.ConfigDone()) && isElementPresent(retainPage_object.Next())) {
				LOGGER.debug("Already Configured Details");
				retainPage_object.Next().click();
			} else {
				LOGGER.debug("Configuring Retain Connection Server ");
				Select se = new Select(retainPage_object.retainServerProtocol());
				se.selectByVisibleText(retainServerProtocol);

				retainPage_object.retainServerProtocol().sendKeys(retainServerProtocol);
				retainPage_object.retainServerHost().clear();
				retainPage_object.retainServerHost().sendKeys(retainServerHost);
				retainPage_object.retainServerPort().clear();
				retainPage_object.retainServerPort().sendKeys(retainServerPort);
				retainPage_object.retainServerURL().clear();
				retainPage_object.retainServerURL().sendKeys(retainServerURL);
				retainPage_object.continueButton().click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean completeRetainConfiguration() {
		try {
			LOGGER.debug("Configuration is done and moving to next step after clicking on complete button");
			retainPage_object.completeButton().click();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("Complete button not found");
			return false;
		}
		return true;
	}

	public boolean openModuleConfigurationPage() {

		LOGGER.debug("Click on module configuration..");
		try {
			retainDriver.switchTo().defaultContent();
			retainPage_object.ModuleConfiguration().click();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("Module configuration option not found.");
			return false;
		}
		return true;
	}

	public boolean configureExchangeModule() {

		try {
			LOGGER.debug("Exchange module configuration...");
			String exchangeURL = "http://" + retain_IP + retainServerURL + "/Manager/exchangesummary.jsp";
			LOGGER.debug("Current title is : " + retainDriver.getTitle());
			LOGGER.debug("Azeem " + retainDriver.findElement(By.cssSelector("body")));

			retainDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

			LOGGER.debug("Opening Exchange module configuration page");
			((JavascriptExecutor) retainDriver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(retainDriver.getWindowHandles());
			retainDriver.switchTo().window(tabs.get(1));
			retainDriver.get(exchangeURL);

			LOGGER.debug("Current title is : " + retainDriver.getTitle());

			LOGGER.debug(" Exchange module core setting");
			retainPage_object.CoreSettings().click();

			LOGGER.debug(" Exchange module module name: "+exchangeModuleName);
			retainPage_object.ModuleName().clear();
			retainPage_object.ModuleName().sendKeys(exchangeModuleName);

			if (addressBookCaching.equals("disabled")) {
				retainPage_object.EnableAddressBookCache().click();
			}
			if (enableAuth.equals("disabled")) {
				retainPage_object.EnableAuthentication().click();
			}
			if (enableJob.equals("disabled")) {
				retainPage_object.EnableJobs().click();
			}

			
			Select se = new Select(retainPage_object.MessageBody());
			se.selectByVisibleText(messageBody);

			Select se1 = new Select(retainPage_object.ifAutodiscoverFail());
			se1.selectByVisibleText(autodiscoverFail);

			Select se2 = new Select(retainPage_object.ForwardingMethod());
			se2.selectByVisibleText(sendMethod);

			retainPage_object.ImpersonationTab().click();

			retainPage_object.GlobalUser().clear();
			retainPage_object.GlobalUser().sendKeys(globalCatalogUser);

			retainPage_object.GlobalPassword().clear();
			retainPage_object.GlobalPassword().sendKeys(globalCatalogPassword);

			if (isHostedSystem.equals("enable"))
				retainPage_object.HostedService().click();

			retainPage_object.ExchangeForest().click();
			retainPage_object.GlobalHost().clear();
			retainPage_object.GlobalHost().sendKeys(globalCatalogHost);

			retainPage_object.GlobalPort().clear();
			retainPage_object.GlobalPort().sendKeys(globalCatalogPort);

			Select globalSec = new Select(retainPage_object.GlobalSecurity());
			globalSec.selectByVisibleText(globalCatalogSecurity);

			retainPage_object.ExchangeAddSearchBase().click();

			retainPage_object.AddSearchBase().sendKeys(addSearchBase);

			retainPage_object.TestConnection().click();
			Thread.sleep(15000);
			// wait_For_Element_For_60Sec(retainPage_object.TestResult());
			LOGGER.debug(retainPage_object.TestResult().getText());

			if (retainPage_object.TestResult().getText().contains("SUCCESS:")) {
				retainPage_object.SaveChanges().click();
				retainPage_object.ImpersonationTab().click();
				retainPage_object.TestImpersonation().click();

				if (retainPage_object.TestResult().getText().contains("SUCCESS:")) {
					LOGGER.debug("Module configuration Done Successfully....");

				} else {
					LOGGER.debug("Impersonation Test Connection is failed please check the details");
			//		return false;
				}
			} else {
				LOGGER.error("Test Connection failed for Exchange and result is: "
						+ retainPage_object.TestResult().getText());
			//	return false;
			}
			retainPage_object.SaveChanges().click();//Delete after Exchange up
			retainDriver.switchTo().window(tabs.get(1)).close();
			retainDriver.switchTo().window(tabs.get(0));
			LOGGER.debug("Current title is : " + retainDriver.getTitle());
			retainDriver.switchTo().frame(0);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}

		return true;
	}

	public boolean refreshAddressBook() {
		try {
			LOGGER.debug("Refreshing address book after module configuration...");
		//	Thread.sleep(5000);
		//	retainDriver.switchTo().frame(0);
			retainPage_object.refreshAddressBook().click();
			if (isElementPresent(retainPage_object.noButton()))
				retainPage_object.noButton().click();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.debug(e.getMessage());
			return false;

		}
		return true;
	}

	public boolean openSchedulePage() {

		LOGGER.debug("Click on Schedule under Data Collection..");
		try {
			retainDriver.switchTo().defaultContent();
			retainPage_object.Schedules().click();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			LOGGER.info("Please check module is configured or not.");
			return false;
		}
		return true;
	}

	public boolean createGroupWiseSchedule() {
	   	if(clientProvider.createSchedule(retainDriver, retainPage_object, groupwiseScheduleId, scheduleMonth, scheduleYear, scheduleDay, scheduleHour, scheduleMinutes))
	   	{
	   		LOGGER.debug("Groupwise schedule created successfully!!");
	   		return true;
	   	}else {
	   		LOGGER.error("Groupwise schedule creation failed.");
	   		return false;
	   	}
	   		
	}

	public boolean selectGroupwiseModule() {
		try {
			LOGGER.debug("Selecting Groupwise module");
			String exchangeURL = "http://" + retain_IP + retainServerURL + "/Manager/gwsummary.jsp";
			LOGGER.debug("Current title is : " + retainDriver.getTitle());
			LOGGER.debug("Azeem " + retainDriver.findElement(By.cssSelector("body")));

			retainDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

			((JavascriptExecutor) retainDriver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(retainDriver.getWindowHandles());
			retainDriver.switchTo().window(tabs.get(1));
			retainDriver.get(exchangeURL);
			LOGGER.debug("Current title is : " + retainDriver.getTitle());

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean groupWiseModuleConfiguration() {
		try {

			LOGGER.debug("Selecting Groupwise module");
			String exchangeURL = "http://" + retain_IP + retainServerURL + "/Manager/gwsummary.jsp";
			LOGGER.debug("Current title is : " + retainDriver.getTitle());
			LOGGER.debug("Azeem " + retainDriver.findElement(By.cssSelector("body")));

			retainDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

			((JavascriptExecutor) retainDriver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(retainDriver.getWindowHandles());
			retainDriver.switchTo().window(tabs.get(1));
			retainDriver.get(exchangeURL);
			LOGGER.debug("Current title is : " + retainDriver.getTitle());

			retainPage_object.CoreSettings().click();
			retainPage_object.ModuleName().clear();
			retainPage_object.ModuleName().sendKeys(groupWiseModuleName);

			if (addressBookCaching.equals("false")) {
				retainPage_object.EnableAddressBookCache().click();
			}
			if (enableAuth.equals("false")) {
				retainPage_object.EnableAuthentication().click();
			}
			if (enableJob.equals("false")) {
				retainPage_object.EnableJobs().click();
			}

			if (showSharedFolder.equals("true")) {
				retainPage_object.showSharedFolder().click();
			}

			Select se2 = new Select(retainPage_object.ForwardingMethod());
			se2.selectByVisibleText(sendMethod);

			if (retentionFlag.equals("true")) {
				retainPage_object.RetentionFlag().click();
			}

			if (purgeFlag.equals("true")) {
				retainPage_object.PurgeFlag().click();
			}

			retainPage_object.SOAP().click();
			retainPage_object.TrustedKeyName().clear();
			retainPage_object.TrustedKeyName().sendKeys(trustedKeyName);

			retainPage_object.TrustedKey().clear();
			retainPage_object.TrustedKey().sendKeys(trustedKey);

			retainPage_object.POAHostName().clear();
			retainPage_object.POAHostName().sendKeys(poaHostName);

			retainPage_object.SOAPPort().clear();
			retainPage_object.SOAPPort().sendKeys(poaSoapPort);

			if (soapSSL.equals("true"))
				retainPage_object.SOAPSSL().click();

			retainPage_object.LDAP().click();

			if (emailAddLookup.equals("true"))
				retainPage_object.ldapEnabled().click();

			retainPage_object.ldapHostIP().clear();
			retainPage_object.ldapHostIP().sendKeys(ldapServerIP);
			retainPage_object.ldapPort().clear();
			retainPage_object.ldapPort().sendKeys(ldapPort);
			if (useSSL.equals("true"))
				retainPage_object.ldapSSL().click();

			retainPage_object.ldapAdminDN().clear();
			retainPage_object.ldapAdminDN().sendKeys(ldapAdminUser);

			retainPage_object.ldapAdminPass().clear();
			retainPage_object.ldapAdminPass().sendKeys(ldapAdminPassword);

			retainPage_object.ldapAdminSearchTop().clear();
			retainPage_object.ldapAdminSearchTop().sendKeys(topSearchContext);

			retainPage_object.Proxy().click();
			if (enableSupportProxy.equals("true")) {
				retainPage_object.EnableAddressBookCache().click();
				retainPage_object.proxyCache().clear();
				retainPage_object.proxyCache().sendKeys(cacheVerification);
			}

			retainPage_object.SOAP().click();
			retainPage_object.TestConnection().click();
			Thread.sleep(15000);

			if (retainPage_object.TestResult().getText().contains("SUCCESS:")) {
				LOGGER.debug("Test connection Passed");
				LOGGER.debug(retainPage_object.TestResult().getText());
				LOGGER.debug("Everything is fine. Save the changes.");
				retainPage_object.SaveChanges().click();
			} else {
				LOGGER.debug("Test connection failed...");
				LOGGER.error(retainPage_object.TestResult().getText());
				return false;
			}

			retainDriver.switchTo().window(tabs.get(1)).close();
			retainDriver.switchTo().window(tabs.get(0));
			LOGGER.debug("Current title is : " + retainDriver.getTitle());
			retainDriver.switchTo().frame(0);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean openProfilePage(String moduleName) {

		LOGGER.debug("Click on group wise Profile under Data Collection..");
		try {
			retainDriver.switchTo().defaultContent();
			if(isElementPresent(retainPage_object.expandProfileButton())) {
			if(!retainPage_object.groupWiseProfiles().isDisplayed() || !retainPage_object.ExchangeProfiles().isDisplayed()) {
			retainPage_object.Profiles().click();
			LOGGER.debug("Clicked on profile. ");
			}else {
				LOGGER.debug("Already profile expand.");
			}	
			if(moduleName.equalsIgnoreCase("groupwise") && isElementPresent(retainPage_object.groupWiseProfiles())) {
				retainPage_object.groupWiseProfiles().click();
			}else if(moduleName.equalsIgnoreCase("exchange") && isElementPresent(retainPage_object.ExchangeProfiles())) {
				retainPage_object.ExchangeProfiles().click();
			}else {
				LOGGER.debug("Module " +moduleName+ " profile is not automated. Please contact automation team.");
			}
			}else {
				retainPage_object.Profiles().click();
				LOGGER.debug("Clicked on profile. ");
			}
			LOGGER.debug("Selected groupwise profile.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOGGER.error("Please check module is configured or not.");
			return false;
		}
		return true;
	}

	public boolean createProfile(String profileID) {
		try {
			retainDriver.switchTo().frame(0);
			retainPage_object.AddProfile().click();
			retainPage_object.ProfileID().clear();
			retainPage_object.ProfileID().sendKeys(profileID);

			// TODO other tab setting

			retainPage_object.SaveChanges().click();

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.debug(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean openWorkerPage() {

		LOGGER.debug("Click on Worker under Data Collection..");
		try {
			retainDriver.switchTo().defaultContent();
			retainPage_object.Workers().click();
			LOGGER.debug("Clicked on Workers. ");
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			LOGGER.info("Please check module is configured or not.");
			return false;
		}
		return true;
	}

	public boolean createWorker() {
		try {
			retainDriver.switchTo().frame(0);
			LOGGER.debug("Click on Add worker");
			retainPage_object.AddWorkers().click();
			retainPage_object.WorkerID().clear();
			LOGGER.debug("Creating worker with name " + workerID);
			retainPage_object.WorkerID().sendKeys(workerID);

			// TODO other tab setting

			LOGGER.debug("Adding module specific details for groupwise and exchange");
			retainPage_object.moduleSpecificWorker().click();
			retainPage_object.soapHostWorker().clear();
			LOGGER.debug("POA Host Name: " + poaHostName);
			retainPage_object.soapHostWorker().sendKeys(poaHostName);
			retainPage_object.soapPortWorker().clear();
			LOGGER.debug("POA SOAP Port: " + poaSoapPort);
			retainPage_object.soapPortWorker().sendKeys(poaSoapPort);
			if (soapSSL.equals("true")) {
				LOGGER.debug("SSL certificate is enabled.");
				retainPage_object.soapSSLWorker().click();
			}
			LOGGER.debug("Saving the changes...");
			retainPage_object.SaveChanges().click();

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.debug(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean configureWorker() throws InterruptedException {
		try {
			LOGGER.debug("Click on bootstrap tab.");
			retainPage_object.Bootstrap().click();
			LOGGER.debug("Going to download bootstrap file.");
			// retainDriver.findElement(By.xpath("/html/body/div/form/div/div[6]/fieldset/a")).click();

			Thread.sleep(10000);
			// retainDriver.switchTo().alert().accept();
			((JavascriptExecutor) retainDriver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(retainDriver.getWindowHandles());
			retainDriver.switchTo().window(tabs.get(1));
			// retainDriver.get("http://google.com");

			String WorkerURL = "http://" + retain_IP + "/" + RetainWorkerID;
			retainDriver.get(WorkerURL);

			if (isElementPresent(retainPage_object.ChooseFile())) {
				retainPage_object.ChooseFile().sendKeys("C:\\Users\\MASaifi\\Downloads\\RetainWorker2.cfg");
				retainPage_object.UploadFile().click();
			} else {
				System.out.println("Already Configured");
			}
			retainDriver.switchTo().window(tabs.get(1)).close();
			retainDriver.switchTo().window(tabs.get(0));
			Thread.sleep(5000);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean openGroupWiseJobPage() {

		LOGGER.debug("Click on group wise Job under Data Collection..");
		try {
			retainDriver.switchTo().defaultContent();
			if(isElementPresent(retainPage_object.expandJobButton())) {
			if(!retainPage_object.groupWiseJob().isDisplayed())
				retainPage_object.CreateJobs().click();
			else
				LOGGER.debug("Already expand job");
			Thread.sleep(10000);
			if (isElementPresent(retainPage_object.groupWiseJob())) {
				LOGGER.debug("Click on groupwise job");
				retainPage_object.groupWiseJob().click();
			}
			}else {
				LOGGER.debug("Job expand button not available. So click on job button");
				retainPage_object.CreateJobs().click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			LOGGER.info("Please check module is configured or not.");
			return false;
		}
		return true;
	}

	public boolean createGroupWiseJob() {

		try {
			retainDriver.switchTo().frame(0);
			LOGGER.debug("Selecting group wise module from the list and name is: " + groupWiseModuleName);
			if(!retainPage_object.AddJob().isEnabled())
				new Select(retainPage_object.SelectModule()).selectByVisibleText(groupWiseModuleName);
			// selMod.selectByVisibleText("Exchange-1Azeem");
			LOGGER.debug("Click on Add job button");
			retainPage_object.AddJob().click();
			retainPage_object.JobName().clear();
			LOGGER.debug("Group wise job name is: " + groupwiseJobID);
			retainPage_object.JobName().sendKeys(groupwiseJobID);
			retainPage_object.JobCoreSettings().click();

			LOGGER.debug("Select Schedule: " + groupwiseScheduleId);

			new Select(retainPage_object.JobScheduleID()).selectByVisibleText(groupwiseScheduleId);
			LOGGER.debug("Select groupwise Profile : " + groupWiseProfileID);
			new Select(retainPage_object.JobProfileID()).selectByVisibleText(groupWiseProfileID);
			LOGGER.debug("Select Worker: " + workerID);
			new Select(retainPage_object.JobWorkerID()).selectByVisibleText(workerID);

			LOGGER.debug("Click on Job Mailboxes.");
			retainPage_object.JobMailboxes().click();
			
            Thread.sleep(5000);
            if(addMailServer("GroupWise",groupwiseEmailServer)) {
            	LOGGER.debug("Mail Servers added successfully !!!!");
            }else {
            	LOGGER.error("Mail Servers not added and have some issue.");
            	return false;
            }
            
            if(includeUser(includeUser)) {
            	LOGGER.debug("Include users added successfully !!!!");
            }else {
            	LOGGER.error("Include users not added and have some issue.");
            	return false;
            }
			
			// Exclude user
			// TO DO
			int size = retainDriver.findElements(By.tagName("iframe")).size();
			System.out.println("Total Frames --" + size);

			retainDriver.switchTo().defaultContent();
			retainDriver.switchTo().frame(0);
			retainPage_object.JobNotification().click();
			retainPage_object.JobStatus().click();
			retainPage_object.SaveChanges().click();

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	
	/**
	 * Include users based on properties file
	 * @throws InterruptedException
	 */
	public boolean includeUser(String includeUser) throws InterruptedException {
		try {
		LOGGER.debug("Click on Add users.");
		retainPage_object.AddUsers().click();
		retainDriver.findElement(By.xpath("//input[@onclick=\"EList('mailboxsearch','include.jobmembers');\"]"))
				.click();
		retainDriver.switchTo().frame("ListBox2_ifrm");
		
		if (includeUser.equalsIgnoreCase("all")) {
			// wait_For_Element_For_60Sec(retainPage_object.addAllButton());
			LOGGER.debug("Click on All users.");
			retainPage_object.addAllButton().click();
			Thread.sleep(10000);
			LOGGER.debug("Click on OK.");
			retainPage_object.Ok().click();
		} else {
			LOGGER.debug("Selected Name Type for Filter criteria: " + nameType);
			new Select(retainPage_object.NameType()).selectByVisibleText(nameType);
			LOGGER.debug("Selected Name Operator for Filter criteria: " + nameOperator);
			new Select(retainPage_object.NameOperator()).selectByVisibleText(nameOperator);
			String[] users = includeUser.split(",");
			for (int i = 0; i < users.length; i++) {			
				LOGGER.debug("Enter Name phrase for Filter criteria: "+ i + " :  " + users[i]);
				retainPage_object.NamePhrase().clear();
				retainPage_object.NamePhrase().sendKeys(users[i]);
				retainPage_object.Search().click();
				Thread.sleep(5000);
				if (isElementPresent(retainPage_object.selectCheckBox())) {
					LOGGER.warn("Email Address is available in the list: " + users[i]);
					LOGGER.debug("Selected check box for Email Address: " + users[i]);
					retainPage_object.selectCheckBox().click();
					LOGGER.debug("Add Selected for the email: " + users[i]);
					retainPage_object.addSelected().click();
				} else {
					LOGGER.warn("Email Address not available in the list: " + users[i]);
					return false;
				}

			}
			LOGGER.debug("Click on OK.");
			retainPage_object.Ok().click();

		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	/***
	 * Add Mail Server on Job Page.
	 * @throws InterruptedException 
	 */
	
	public boolean addMailServer(String MailServer, String inputMailServer) throws InterruptedException {
		try {
		LOGGER.debug("Adding Mail Servers");
		retainPage_object.MailServers().click();
		//retainPage_object.MailServers().click();
		String[] mailserver = inputMailServer.split(",");
		LOGGER.debug("Adding Mailserver based retain properties file.");
	for (int i = 0; i < mailserver.length; i++) {
		LOGGER.debug("Searching Mailserver: "+mailserver[i]);
		retainPage_object.addMailServer().clear();
		retainPage_object.addMailServer().sendKeys(mailserver[i]);
		Thread.sleep(5000);
		if(isElementPresent(retainPage_object.checkBoxMailServers())) {
			LOGGER.debug("Mailserver listed and selecting check box for : "+mailserver[i]);
			WebElement checkbox = null;
			
			if(MailServer.equals("GroupWise")) {
			if(mailserver[i].equals("ExternalPO")) {
				 checkbox = retainDriver.findElement(By.xpath("//div[@id='9D6A2638FAD6D56680185F7BC817BE64']//input[@type='checkbox' and @onclick='JournalMe(this)']"));
			}else if(mailserver[i].equals("office365")) {
				checkbox = retainDriver.findElement(By.xpath("//div[@id='C6A54DD90AFACC15B84854A9A3568250']//input[@type='checkbox' and @onclick='JournalMe(this)']"));
			}else if(mailserver[i].equals("RetainPO")) {
				checkbox = retainDriver.findElement(By.xpath("//div[@id='6BB95B3E5AE3C3C2943B55D166D318D5']//input[@type='checkbox' and @onclick='JournalMe(this)']"));
			}else {
				LOGGER.error("List ID is not present in the code please check the id of mail server and contact automation team");
			return false;
			}
			}
			if(MailServer.equals("Exchange")) {
			 if(mailserver[i].equals("EXCHANGEQA2")) {
				checkbox = retainDriver.findElement(By.xpath("//div[@id='C0A9B0FD4F9BD9A29B944E3DCEB0C220']//input[@type='checkbox' and @onclick='JournalMe(this)']"));
			}else if(mailserver[i].equals("EXCHANGEQA3")) {
				checkbox = retainDriver.findElement(By.xpath("//div[@id='BE0941F9FB3AEABCE93D3711C9E1A952']//input[@type='checkbox' and @onclick='JournalMe(this)']"));
			}else if(mailserver[i].equals("EXCHANGEQA4")) {
				checkbox = retainDriver.findElement(By.xpath("//div[@id='A09EA1B36F6A132DD625900586E00A2B']//input[@type='checkbox' and @onclick='JournalMe(this)']"));
			}else {
				LOGGER.error("List ID is not present in the code please check the id of mail server and contact automation team");
			return false;
			}		
			}
			checkbox.click();
		
	}else {
		LOGGER.debug("Mailserver is not listed please check in propertiese file or module configuration: "+mailserver[i]);
	return false;
	}
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}return true;
	
	}
	
	
	
	
	public boolean openExchangeJobPage() {

		LOGGER.debug("Click on Exchange Job under Data Collection..");
		try {
			retainDriver.switchTo().defaultContent();
			retainDriver.switchTo().defaultContent();
			if(!retainPage_object.exchangeJob().isDisplayed())
				retainPage_object.CreateJobs().click();
			else
				LOGGER.debug("Already expand job");
			
			Thread.sleep(10000);
			if (isElementPresent(retainPage_object.exchangeJob())) {
				LOGGER.debug("Click on Exchange job");
				retainPage_object.exchangeJob().click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			LOGGER.info("Please check exchange module is configured or not.");
			return false;
		}
		return true;
	}
	
	
	/***
	 * Create job for Exchange
	 */
	
	public boolean createExchnageJob() {

		try {
			retainDriver.switchTo().frame(0);
			LOGGER.debug("Selecting Exchange module from the list and name is: " + exchangeModuleName);
			if(!retainPage_object.AddJob().isEnabled())
				new Select(retainPage_object.SelectModule()).selectByVisibleText(exchangeModuleName);
			// selMod.selectByVisibleText("Exchange-1Azeem");
			LOGGER.debug("Click on Add job button");
			retainPage_object.AddJob().click();
			retainPage_object.JobName().clear();
			LOGGER.debug("exchange job name is: " + exchangeJobID);
			retainPage_object.JobName().sendKeys(exchangeJobID);
			retainPage_object.JobCoreSettings().click();

			LOGGER.debug("Select exchange Schedule: " + exchangeScheduleId);

			new Select(retainPage_object.JobScheduleID()).selectByVisibleText(exchangeScheduleId);
			LOGGER.debug("Select Exchange Profile : " + exchangeProfileID);
			new Select(retainPage_object.JobProfileID()).selectByVisibleText(exchangeProfileID);
			LOGGER.debug("Select Worker: " + workerID);
			new Select(retainPage_object.JobWorkerID()).selectByVisibleText(workerID);

			LOGGER.debug("Click on Job Mailboxes.");
			retainPage_object.JobMailboxes().click();
			
            Thread.sleep(5000);
            if(addMailServer("Exchange",exchangeEmailServer)) {
            	LOGGER.debug("Mail Servers added successfully !!!!");
            }else {
            	LOGGER.error("Mail Servers not added and have some issue.");
            	return false;
            }
            
            if(includeUser("all")) {
            	LOGGER.debug("Include users added successfully !!!!");
            }else {
            	LOGGER.error("Include users not added and have some issue.");
            	return false;
            }
			
			// Exclude user
			// TO DO
			int size = retainDriver.findElements(By.tagName("iframe")).size();
			System.out.println("Total Frames --" + size);

			retainDriver.switchTo().defaultContent();
			retainDriver.switchTo().frame(0);
			retainPage_object.JobNotification().click();
			retainPage_object.JobStatus().click();
			retainPage_object.SaveChanges().click();
			

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	
	
	
	
	/***
	 * Create Exchange Schedule
	 */
	public boolean createExchangeSchedule() {
		if(clientProvider.createSchedule(retainDriver, retainPage_object, exchangeScheduleId, scheduleMonth, scheduleYear, scheduleDay, scheduleHour, scheduleMinutes))
		{
			LOGGER.debug("Schedule created successfully!!!");
			return true;
		}else {
			LOGGER.error("Schedule creation failed ");
			return false;
		}
	}

}
