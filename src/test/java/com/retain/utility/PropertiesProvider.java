package com.retain.utility;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PropertiesProvider {

	public static final Logger LOGGER = LogManager.getLogger(RetainWebHelper.class);
	/*** Setting Firefox capabilities; */
	public static WebDriver retainDriver;
	public String Port = "4444";
	ClientProvider clientProvider = new ClientProvider();
	protected static Properties props = AutoProperties.getGlobalProps("src/test/resources/retain.properties");
	public static String RemoteDriver_IP = props.getProperty("novell.retain.remoteDriverIp");
	public static String retain_IP = props.getProperty("novell.retain.ip");
	public String script_Location_in_Windows = props.getProperty("novell.retain.location");
	public static RetainWebElements retainPage_object;
	String browser_Selected = props.getProperty("retain.web.select.browser");
	protected String isConfiguration = props.getProperty("retain.web.configuration");
	protected static boolean isSetupReady = false;
	private String xpath;
	private WebDriver d;
	protected boolean loadURL = false;
	public String downloadPath = props.getProperty("retain.download.path");
	public static String basePath = props.getProperty("retain.web.base.path");
	public static String customPath = props.getProperty("retain.web.custom.path");
	protected String DatabaseDriver = props.getProperty("retain.web.database.driver");

	protected String DatabaseServer = props.getProperty("retain.web.database.server");
	protected String DatabaseName = props.getProperty("retain.web.database.name");
	protected String DatabaseInstance = props.getProperty("retain.web.database.instance");

	protected String DatabaseUsername = props.getProperty("retain.web.database.username");
	protected String DatabasePassword = props.getProperty("retain.web.database.password");
	protected String isSslEnable = props.getProperty("retain.database.ssl.enable");

	protected String adminUser = props.getProperty("retain.web.admin.username");
	protected String adminPassword = props.getProperty("retain.web.admin.password");

//SMTP Details:
	protected String smtpMailServer = props.getProperty("retain.smtp.mail.server");
	protected String smtpSecurityProtocol = props.getProperty("retain.security.protocol");

	protected String smtpPort = props.getProperty("smtp.port");
	protected String smtpMailFromAddress = props.getProperty("smtp.mail.from.address");

	protected String smtpToAddress = props.getProperty("smtp.to.address");
	protected String smtpUsername = props.getProperty("smtp.username");
	protected String smtpPassword = props.getProperty("smtp.password");

///Indexing Details:
	protected String IndexingPort = props.getProperty("retain.index.port");
	protected String IndexingUsername = props.getProperty("retain.index.username");
	protected String IndexingPassword = props.getProperty("retain.index.password");

//Retain Server Connection
	protected String retainServerProtocol = props.getProperty("retain.server.protocol");
	protected String retainServerHost = props.getProperty("retain.server.host");
	protected String retainServerPort = props.getProperty("retain.server.port");
	protected String retainServerURL = props.getProperty("retain.server.url");

	// Exchange Configuration
	protected String exchangeModuleName = props.getProperty("retain.exchange.module.name");
	protected String addressBookCaching = props.getProperty("retain.exchange.address.book.caching");
	protected String enableAuth = props.getProperty("retain.exchange.enable.auth");
	protected String enableJob = props.getProperty("retain.exchange.enable.jobs");
	protected String messageBody = props.getProperty("retain.exchange.message.body");
	
	
	//Group wise module configuration
	protected String groupWiseModuleName = props.getProperty("retain.groupwise.module.name");
	protected String showSharedFolder = props.getProperty("retain.groupwise.enable.sharedFolder");
	protected String retentionFlag = props.getProperty("retain.groupwise.enable.retentionFlag");
	protected String purgeFlag = props.getProperty("retain.groupwise.enable.purgeFlag");
	
	protected String trustedKeyName = props.getProperty("retain.groupwise.trusted.key.name");
	protected String trustedKey = props.getProperty("retain.groupwise.trusted.key");
	protected String poaHostName = props.getProperty("retain.groupwise.poa.host.name");
	protected String poaSoapPort = props.getProperty("retain.groupwise.poa.soap.port");
	protected String soapSSL = props.getProperty("retain.groupwise.enable.ssl");
	protected String emailAddLookup = props.getProperty("retain.groupwise.enable.email.address.lookup");
	protected String ldapServerIP = props.getProperty("retain.groupwise.ldap.server.ip");
	
	protected String ldapPort = props.getProperty("retain.groupwise.ldap.port");
	protected String useSSL = props.getProperty("retain.groupwise.use.ssl");
	protected String ldapAdminUser = props.getProperty("retain.groupwise.ldap.admin.user");
	protected String ldapAdminPassword = props.getProperty("retain.groupwise.ldap.admin.password");
	protected String topSearchContext = props.getProperty("retain.groupwise.top.search.context");
	protected String enableSupportProxy = props.getProperty("retain.groupwise.enable.support.proxy");
	protected String cacheVerification = props.getProperty("retain.groupwise.cache.varification");
	

	protected String autodiscoverFail = props.getProperty("retain.exchange.autodiscover.fail");
	protected String sendMethod = props.getProperty("retain.exchange.send.method");

	protected String globalCatalogUser = props.getProperty("retain.exchange.global.catalog.user");
	protected String globalCatalogPassword = props.getProperty("retain.exchange.global.catalog.password");

	protected String isHostedSystem = props.getProperty("retain.exchange.hosted.exchange.system");

	protected String globalCatalogHost = props.getProperty("retain.exchange.global.catalog.host");
	protected String globalCatalogPort = props.getProperty("retain.exchange.global.catalog.port");

	protected String globalCatalogSecurity = props.getProperty("retain.exchange.global.catalog.security");
	protected String addSearchBase = props.getProperty("retain.exchange.add.search.base");

	protected String addUserForest = props.getProperty("retain.exchange.add.user.forest");
	protected String delegatesSupport = props.getProperty("retain.exchange.enable.delegates.support");

	protected String groupwiseScheduleId = props.getProperty("retain.groupwise.schedule.id");
	protected String scheduleMonth = props.getProperty("retain.schedule.date.month");

	protected String scheduleYear = props.getProperty("retain.schedule.date.year");
	protected String scheduleDay = props.getProperty("retain.schedule.date.day");

	protected String scheduleHour = props.getProperty("retain.schedule.time.hour");
	protected String scheduleMinutes = props.getProperty("retain.schedule.time.minutes");

	protected String exchangeProfileID = props.getProperty("retain.exchange.profile.id");
	protected String groupWiseProfileID = props.getProperty("retain.groupWise.profile.id");
	protected String workerID = props.getProperty("retain.schedule.worker.id");
	protected String RetainWorkerID = props.getProperty("retain.schedule.workerid.name");

	protected String groupwiseJobID = props.getProperty("retain.groupwise.job.id");
	protected String includeUser = props.getProperty("retain.job.include.user");
	protected String nameType = props.getProperty("retain.job.include.nameType");
	protected String nameOperator = props.getProperty("retain.job.include.nameOperator");
	
	protected String exchangeScheduleId = props.getProperty("retain.exchange.schedule.id");
	protected String exchangeJobID = props.getProperty("retain.exchange.job.id");
	protected String excludeUser = props.getProperty("retain.job.exclude.user");
	protected String exchangeEmailServer = props.getProperty("retain.job.exchange.mailserver");
	protected String groupwiseEmailServer = props.getProperty("retain.job.groupwise.mailserver");


	 
}
