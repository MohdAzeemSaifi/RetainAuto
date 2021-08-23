package com.retain.utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetainWebElements {
	/***
	 * ----- Login page Web Elements.
	 */
	@FindBy(id = "login")
	private WebElement login_UserName;

	@FindBy(id = "pass")
	private WebElement login_password;

	@FindBy(id = "loginbutton")
	WebElement login_Btn;

	@FindBy(xpath = "//span[text()=' Invalid credentials ']")
	private WebElement loginFailMessage;

	// Configuration
	@FindBy(xpath = "//h1[text()='Welcome to Micro Focus Retain']")
	private WebElement ConfigurationPage;

	public WebElement ConfigurationWelcomePage() {
		return ConfigurationPage;
	}

	// Storage Path
	@FindBy(xpath = "//td[text()='Storage Path']")
	private WebElement storagePath;

	public WebElement storagePath() {
		return storagePath;
	}

	// Base Path
	@FindBy(xpath = "//select[@id='basePathType']")
	private WebElement basePath;

	public WebElement basePath() {
		return basePath;
	}

	// Custom Path
	@FindBy(xpath = "//input[@id='basePath']")
	private WebElement customPath;

	public WebElement customPath() {
		return customPath;
	}

	// Continue Path
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement Continue;

	public WebElement continueButton() {
		return Continue;
	}

	// Message Store Database Connection Parameters
	@FindBy(xpath = "//legend[text()='Message Store Database Connection Parameters']")
	private WebElement DatabaseEntryPage;

	public WebElement DatabaseEntryPage() {
		return DatabaseEntryPage;
	}

	// Driver Entry
	@FindBy(xpath = "//select[@id='driver']")
	private WebElement Driver;

	public WebElement DriverEntry() {
		return Driver;
	}

	// DataBase Server Entry
	@FindBy(xpath = "//input[@id='dbserver']")
	private WebElement DatabaseServer;

	public WebElement DatabaseServerEntry() {
		return DatabaseServer;
	}

	// DataBase Name
	@FindBy(xpath = "//input[@id='dbname']")
	private WebElement DatabaseName;

	public WebElement DatabaseNameEntry() {
		return DatabaseName;
	}

	// DB Instance
	@FindBy(xpath = "//input[@name='instance']")
	private WebElement DBInstance;

	public WebElement DBInstance() {
		return DBInstance;
	}

	// DB Username
	@FindBy(xpath = "//input[@name='name']")
	private WebElement DBUsername;

	public WebElement DBUsername() {
		return DBUsername;
	}

	// DB Password
	@FindBy(xpath = "//input[@name='pass']")
	private WebElement DBPassword;

	public WebElement DBPassword() {
		return DBPassword;
	}

	// DB Password
	@FindBy(xpath = "//input[@value='Next']")
	private WebElement Next;

	public WebElement Next() {
		return Next;
	}

	// DB Password
	@FindBy(xpath = "//div[@class='error']")
	private WebElement error;

	public WebElement Error() {
		return error;
	}

	// Config Done

	@FindBy(xpath = "//div[@class='config-done']")
	private WebElement configDone;

	public WebElement ConfigDone() {
		return configDone;
	}

	// Enable SSL
	@FindBy(xpath = "//input[@name='dbConnEncrypted']")
	private WebElement enableSSL;

	public WebElement enableSSL() {
		return enableSSL;
	}

	// Administrator account
	@FindBy(xpath = "//input[@name='user']")
	private WebElement adminUser;

	public WebElement adminUser() {
		return adminUser;
	}

	@FindBy(xpath = "//input[@name='pass']")
	private WebElement adminPassword;

	public WebElement adminPassword() {
		return adminPassword;
	}

	@FindBy(xpath = "//input[@name='newpass']")
	private WebElement confirmPassword;

	public WebElement confirmPassword() {
		return confirmPassword;
	}

	// SMTP web Element
	@FindBy(xpath = "//input[@name='server']")
	private WebElement smtpServer;

	public WebElement smtpServer() {
		return smtpServer;
	}

	@FindBy(xpath = "//input[@name='port']")
	private WebElement smtpPort;

	public WebElement smtpPort() {
		return smtpPort;
	}

	@FindBy(xpath = "//input[@name='from']")
	private WebElement smtpFrom;

	public WebElement smtpFrom() {
		return smtpFrom;
	}

	@FindBy(xpath = "//input[@name='to']")
	private WebElement smtpTo;

	public WebElement smtpTo() {
		return smtpTo;
	}

	@FindBy(xpath = "//input[@name='user']")
	private WebElement smtpUser;

	public WebElement smtpUser() {
		return smtpUser;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement smtpPass;

	public WebElement smtpPass() {
		return smtpPass;
	}

	@FindBy(xpath = "//select[@id='protocol']")
	private WebElement smtpProtocol;

	public WebElement smtpProtocol() {
		return smtpProtocol;
	}

	// Indexing Engine
	@FindBy(xpath = "//input[@name='solrEmbeddedPort']")
	private WebElement IndexingPort;

	public WebElement IndexingPort() {
		return IndexingPort;
	}

	@FindBy(xpath = "//input[@name='hpiPassword']")
	private WebElement IndexingPassword;

	public WebElement IndexingPassword() {
		return IndexingPassword;
	}

	@FindBy(xpath = "//input[@name='hpiUsername']")
	private WebElement IndexingUsername;

	public WebElement IndexingUsername() {
		return IndexingUsername;
	}

	// Retain Server Connection

	@FindBy(xpath = "//select[@name='retainServerProtocol']")
	private WebElement retainServerProtocol;

	public WebElement retainServerProtocol() {
		return retainServerProtocol;
	}

	@FindBy(xpath = "//input[@name='retainServerHost']")
	private WebElement retainServerHost;

	public WebElement retainServerHost() {
		return retainServerHost;
	}

	@FindBy(xpath = "//input[@name='retainServerPort']")
	private WebElement retainServerPort;

	public WebElement retainServerPort() {
		return retainServerPort;
	}

	@FindBy(xpath = "//input[@name='retainServerURL']")
	private WebElement retainServerURL;

	public WebElement retainServerURL() {
		return retainServerURL;
	}

	@FindBy(xpath = "//input[@value='Complete']")
	private WebElement completeButton;

	public WebElement completeButton() {
		return completeButton;
	}

	public WebElement verifyLogin_Fail_Message() {
		return loginFailMessage;
	}

	public WebElement loginUsername() {
		return login_UserName;
	}

	public WebElement loginPassword() {
		return login_password;
	}

	public WebElement login_Btn() {
		return login_Btn;
	}

	
	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement logout;

	public WebElement Logout() {
		return logout;
	}
	

	@FindBy(xpath = "//img[@onclick=\"MenuToggleExpand(this,'job');return false\"]")
	private WebElement expandJobButton;

	public WebElement expandJobButton() {
		return expandJobButton;
	}
	
	
	@FindBy(xpath = "//img[@onclick=\"MenuToggleExpand(this,'profile');return false\"]")
	private WebElement expandProfileButton;

	public WebElement expandProfileButton() {
		return expandProfileButton;
	}
	
	
	// Module Configuration

	@FindBy(xpath = "//a[@title='Configure Modules']")
	private WebElement moduleConfiguration;

	public WebElement ModuleConfiguration() {
		return moduleConfiguration;
	}

	@FindBy(xpath = "//a[@href='/RetainServer/Manager/exchangesummary.jsp']")
	private WebElement exchangeModule;

	public WebElement ExchangeModule() {
		return exchangeModule;
	}

	@FindBy(xpath = "//span[text()='Core Settings']")
	private WebElement coreSettings;

	public WebElement CoreSettings() {
		return coreSettings;
	}

	@FindBy(xpath = "//input[@id='friendlyName']")
	private WebElement moduleName;

	public WebElement ModuleName() {
		return moduleName;
	}

	@FindBy(xpath = "//input[@name='enableAddressBookCache']")
	private WebElement enableAddressBookCache;

	public WebElement EnableAddressBookCache() {
		return enableAddressBookCache;
	}

	@FindBy(xpath = "//input[@name='enableAuthentication']")
	private WebElement enableAuthentication;

	public WebElement EnableAuthentication() {
		return enableAuthentication;
	}

	@FindBy(xpath = "//input[@name='enableJobs']")
	private WebElement enableJobs;

	public WebElement EnableJobs() {
		return enableJobs;
	}

	@FindBy(xpath = "//select[@name='exchange.config.bodyformat']")
	private WebElement messageBody;

	public WebElement MessageBody() {
		return messageBody;
	}

	@FindBy(xpath = "//select[@name='genopt.autodiscover.fatal']")
	private WebElement ifAutodiscoverFail;

	public WebElement ifAutodiscoverFail() {
		return ifAutodiscoverFail;
	}

	@FindBy(xpath = "//select[@name='forwardingmethod']")
	private WebElement forwardingMethod;

	public WebElement ForwardingMethod() {
		return forwardingMethod;
	}
	
	@FindBy(xpath = "//input[@name='linksharedfolders']")
	private WebElement showSharedFolder;

	public WebElement showSharedFolder() {
		return showSharedFolder;
	}
	
	@FindBy(xpath = "//input[@name='retentionFlag']")
	private WebElement retentionFlag;

	public WebElement RetentionFlag() {
		return retentionFlag;
	}

	
	@FindBy(xpath = "//input[@name='purgeFlag']")
	private WebElement purgeFlag;

	public WebElement PurgeFlag() {
		return purgeFlag;
	}
	
	@FindBy(xpath = "//span[text()='SOAP']")
	private WebElement soap;

	public WebElement SOAP() {
		return soap;
	}
	
	@FindBy(xpath = "//span[text()='LDAP']")
	private WebElement ldap;

	public WebElement LDAP() {
		return ldap;
	}
	
	@FindBy(xpath = "//span[text()='Proxy']")
	private WebElement proxy;

	public WebElement Proxy() {
		return ldap;
	}
	
	
	@FindBy(xpath = "//input[@name='ldapEnabled']")
	private WebElement ldapEnabled;

	public WebElement ldapEnabled() {
		return ldapEnabled;
	}
	
	
	@FindBy(xpath = "//input[@name='ldapHost']")
	private WebElement ldapHostIP;

	public WebElement ldapHostIP() {
		return ldapHostIP;
	}
	
	
	@FindBy(xpath = "//input[@name='ldapPort']")
	private WebElement ldapPort;

	public WebElement ldapPort() {
		return ldapPort;
	}
	
	@FindBy(xpath = "//input[@name='ldapSSL']")
	private WebElement ldapSSL;

	public WebElement ldapSSL() {
		return ldapSSL;
	}
	
	@FindBy(xpath = "//input[@name='ldapAdminDN']")
	private WebElement ldapAdminDN;

	public WebElement ldapAdminDN() {
		return ldapAdminDN;
	}
	
	@FindBy(xpath = "//input[@name='ldapAdminPass']")
	private WebElement ldapAdminPass;

	public WebElement ldapAdminPass() {
		return ldapAdminPass;
	}
	
	
	@FindBy(xpath = "//input[@name='ldapAdminSearchTop']")
	private WebElement ldapAdminSearchTop;

	public WebElement ldapAdminSearchTop() {
		return ldapAdminSearchTop;
	}
	
	@FindBy(xpath = "//input[@name='enableProxy']")
	private WebElement enableProxy;

	public WebElement enableProxy() {
		return enableProxy;
	}
	
	@FindBy(xpath = "//input[@name='proxyCache']")
	private WebElement proxyCache;

	public WebElement proxyCache() {
		return proxyCache;
	}
	
	
	@FindBy(xpath = "//input[@name='TAName']")
	private WebElement trustedKeyName;

	public WebElement TrustedKeyName() {
		return trustedKeyName;
	}

	
	@FindBy(xpath = "//input[@name='TAKey']")
	private WebElement trustedKey;

	public WebElement TrustedKey() {
		return trustedKey;
	}

	
	@FindBy(xpath = "//input[@name='soapHost']")
	private WebElement poaHostName;

	public WebElement POAHostName() {
		return poaHostName;
	}
	
	@FindBy(xpath = "//input[@name='soapPort']")
	private WebElement soapPort;

	public WebElement SOAPPort() {
		return soapPort;
	}

	@FindBy(xpath = "//input[@name='soapSSL']")
	private WebElement soapSSL;

	public WebElement SOAPSSL() {
		return soapSSL;
	}

	
	@FindBy(xpath = "//span[text()='Module specific']")
	private WebElement moduleSpecificWorker;

	public WebElement moduleSpecificWorker() {
		return moduleSpecificWorker;
	}
	
	//Module specific for the groupwise under worker
	@FindBy(xpath = "//input[@name='defaultSOAPHost']")
	private WebElement soapHostWorker;

	public WebElement soapHostWorker() {
		return soapHostWorker;
	}
	
	@FindBy(xpath = "//input[@name='defaultSOAPPort']")
	private WebElement soapPortWorker;

	public WebElement soapPortWorker() {
		return soapPortWorker;
	}
	
	
	@FindBy(xpath = "//input[@name='defaultSOAPSSL']")
	private WebElement soapSSLWorker;

	public WebElement soapSSLWorker() {
		return soapSSLWorker;
	}
	
	@FindBy(xpath = "//input[@name='exchangesite']")
	private WebElement exchangeSiteWorker;

	public WebElement exchangeSiteWorker() {
		return exchangeSiteWorker;
	}
	
	

	@FindBy(xpath = "//input[@name='globalUser']")
	private WebElement globalUser;

	public WebElement GlobalUser() {
		return globalUser;
	}

	@FindBy(xpath = "//input[@name='globalPassword']")
	private WebElement globalPassword;

	public WebElement GlobalPassword() {
		return globalPassword;
	}

	@FindBy(xpath = "//span[text()='Impersonation']")
	private WebElement impersonationTab;

	public WebElement ImpersonationTab() {
		return impersonationTab;
	}

	@FindBy(xpath = "//span[text()='Hosted Services']")
	private WebElement hostedService;

	public WebElement HostedService() {
		return hostedService;
	}

	@FindBy(xpath = "//span[text()='Exchange Forest']")
	private WebElement exchangeForest;

	public WebElement ExchangeForest() {
		return exchangeForest;
	}

	@FindBy(xpath = "//input[@id='isHostedSystem']")
	private WebElement isHostedSystem;

	public WebElement isHostedSystem() {
		return isHostedSystem;
	}

	@FindBy(xpath = "//input[@name='globalHost']")
	private WebElement globalHost;

	public WebElement GlobalHost() {
		return globalHost;
	}

	@FindBy(xpath = "//input[@name='globalPort']")
	private WebElement globalPort;

	public WebElement GlobalPort() {
		return globalPort;
	}

	@FindBy(xpath = "//select[@name='globalSecurity']")
	private WebElement globalSecurity;

	public WebElement GlobalSecurity() {
		return globalSecurity;
	}

	@FindBy(xpath = "//span[@id='exchange-add-search-base']")
	private WebElement exchangeAddSearchBase;

	public WebElement ExchangeAddSearchBase() {
		return exchangeAddSearchBase;
	}

	@FindBy(xpath = "//input[@name='globalDN']")
	private WebElement addSearchBase;

	public WebElement AddSearchBase() {
		return addSearchBase;
	}

	@FindBy(xpath = "//input[@onclick='TestImpersonation()']")
	private WebElement TestImpersonation;

	public WebElement TestImpersonation() {
		return TestImpersonation;
	}

	@FindBy(xpath = "//input[@onclick='Test()']")
	private WebElement testConnection;

	public WebElement TestConnection() {
		return testConnection;
	}

	@FindBy(xpath = "//img[@title='Save Changes']")
	private WebElement saveChanges;

	public WebElement SaveChanges() {
		return saveChanges;
	}

	@FindBy(xpath = "//div[@id='testresults']")
	private WebElement testResult;

	public WebElement TestResult() {
		return testResult;
	}

	@FindBy(xpath = "//a[text()='Schedules']")
	private WebElement schedules;

	public WebElement Schedules() {
		return schedules;
	}

	@FindBy(xpath = "//input[@name='Add']")
	private WebElement addSchedule;

	public WebElement AddSchedule() {
		return addSchedule;
	}

	@FindBy(xpath = "//input[@id='scheduleId']")
	private WebElement scheduleId;

	public WebElement ScheduleId() {
		return scheduleId;
	}

	@FindBy(xpath = "//select[@id='mydate_month']")
	private WebElement mydateMonth;

	public WebElement MydateMonth() {
		return mydateMonth;
	}

	@FindBy(xpath = "//select[@id='mydate_year']")
	private WebElement mydateYear;

	public WebElement MydateYear() {
		return mydateYear;
	}

	@FindBy(xpath = "//select[@id='mydate_day']")
	private WebElement mydateDay;

	public WebElement MydateDay() {
		return mydateDay;
	}

	@FindBy(xpath = "//select[@id='mydate_hour']")
	private WebElement mydateHours;

	public WebElement MydateHours() {
		return mydateHours;
	}

	@FindBy(xpath = "//select[@id='mydate_minute']")
	private WebElement mydateMinute;

	public WebElement MydateMinute() {
		return mydateMinute;
	}

	// Profile
	@FindBy(xpath = "//a[text()='Profiles']")
	private WebElement profiles;

	public WebElement Profiles() {
		return profiles;
	}

	@FindBy(xpath = "//a[text()='Exchange']")
	private WebElement exchangeProfiles;

	public WebElement ExchangeProfiles() {
		return exchangeProfiles;
	}
	
	
	@FindBy(xpath = "//a[text()='GroupWise']")
	private WebElement groupWiseProfiles;

	public WebElement groupWiseProfiles() {
		return groupWiseProfiles;
	}

	
	
	
	
	@FindBy(xpath = "//input[@value='Add Profile']")
	private WebElement addProfile;

	public WebElement AddProfile() {
		return addProfile;
	}
	
	@FindBy(xpath = "//input[@name='ProfileID']")
	private WebElement profileID;

	public WebElement ProfileID() {
		return profileID;
	}
	
	@FindBy(xpath = "//a[text()='Workers']")
	private WebElement workers;

	public WebElement Workers() {
		return workers;
	}
	
	

	@FindBy(xpath = "//input[@value='Add Worker']")
	private WebElement addWorkers;

	public WebElement AddWorkers() {
		return addWorkers;
	}
	
	
	@FindBy(xpath = "//input[@onclick='CheckFirst(this)' and @value='new worker']")
	private WebElement workerID;

	public WebElement WorkerID() {
		return workerID;
	}
	
	@FindBy(xpath = "//span[text()='Bootstrap']")
	private WebElement bootstrap;

	public WebElement Bootstrap() {
		return bootstrap;
	}
	

	
	@FindBy(xpath = "//input[@name='file1']")
	private WebElement chooseFile;

	public WebElement ChooseFile() {
		return chooseFile;
	}
	
	@FindBy(xpath = "//input[@value='Upload File']")
	private WebElement uploadFile;

	public WebElement UploadFile() {
		return uploadFile;
	}
	
	
	//Jobs
	
	@FindBy(xpath = "//a[text()='Jobs']")
	private WebElement createJob;

	public WebElement CreateJobs() {
		return createJob;
	}
	
	@FindBy(xpath = "//a[@href='/RetainServer/Manager/jobmanagement.jsp']")
	private WebElement groupWiseJob;

	public WebElement groupWiseJob() {
		return groupWiseJob;
	}
	
	
	@FindBy(xpath = "//a[@href='/RetainServer/Manager/ex_jobmanagement.jsp']")
	private WebElement exchangeJob;

	public WebElement exchangeJob() {
		return exchangeJob;
	}
	
	
	
	@FindBy(xpath = "//td[contains(text(), 'Module selection')]/select")
	private WebElement selectModule;

	public WebElement SelectModule() {
		return selectModule;
	}
	
	
	@FindBy(xpath = "//input[@value='Add Job']")
	private WebElement addJob;

	public WebElement AddJob() {
		return addJob;
	}
	
	
	@FindBy(xpath = "//input[@value='new job']")
	private WebElement jobName;

	public WebElement JobName() {
		return jobName;
	}
	
	@FindBy(xpath = "//span[text()='Core Settings']")
	private WebElement jobCoreSettings;

	public WebElement JobCoreSettings() {
		return jobCoreSettings;
	}
	
	@FindBy(xpath = "//span[text()='Journaling']")
	private WebElement jobJournaling;

	public WebElement JobJournaling() {
		return jobJournaling;
	}
	
	
	@FindBy(xpath = "//span[text()='Mailboxes']")
	private WebElement jobMailboxes;

	public WebElement JobMailboxes() {
		return jobMailboxes;
	}
	
	@FindBy(xpath = "//select[@id='NameType']")
	private WebElement NameType;

	public WebElement NameType() {
		return NameType;
	}
	
	@FindBy(xpath = "//select[@id='NameOperator']")
	private WebElement NameOperator;

	public WebElement NameOperator() {
		return NameOperator;
	}
	
	@FindBy(xpath = "//input[@id='NamePhrase']")
	private WebElement NamePhrase;

	public WebElement NamePhrase() {
		return NamePhrase;
	}
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement Search;

	public WebElement Search() {
		return Search;
	}
	
	@FindBy(xpath = "//input[@onclick='CheckMe(this)']")
	private WebElement selectCheckBox;

	public WebElement selectCheckBox() {
		return selectCheckBox;
	}
	
	
	@FindBy(xpath = "//input[@onclick='CopySelected()']")
	private WebElement addSelected;

	public WebElement addSelected() {
		return addSelected;
	}
	
	
	
	
	
	@FindBy(xpath = "//span[text()='Notification']")
	private WebElement jobNotification;

	public WebElement JobNotification() {
		return jobNotification;
	}
	
	@FindBy(xpath = "//span[text()='Status']")
	private WebElement jobStatus;

	public WebElement JobStatus() {
		return jobStatus;
	}
	
	@FindBy(xpath = "//select[@name='scheduleID']")
	private WebElement JobScheduleID;

	public WebElement JobScheduleID() {
		return JobScheduleID;
	}
	
	
	@FindBy(xpath = "//select[@name='profileID']")
	private WebElement JobProfileID;

	public WebElement JobProfileID() {
		return JobProfileID;
	}
	
	@FindBy(xpath = "//select[@name='workerID']")
	private WebElement JobWorkerID;

	public WebElement JobWorkerID() {
		return JobWorkerID;
	}
	
	@FindBy(xpath = "//input[@onkeyup=\"CompleteMe('po_root',this,3)\"]")
	private WebElement addMailServer;

	public WebElement addMailServer() {
		return addMailServer;
	}
	
	
	
	@FindBy(xpath = "//a[text()='Mail Servers']")
	private WebElement MailServers;

	public WebElement MailServers() {
		return MailServers;
	}
	
	@FindBy(xpath = "//input[@id='complete.po']")
	private WebElement searchMailServers;

	public WebElement searchMailServers() {
		return searchMailServers;
	}
	
	@FindBy(xpath = "//input[@type='checkbox' and @onclick='JournalMe(this)']")
	private WebElement checkBoxMailServers;

	public WebElement checkBoxMailServers() {
		return checkBoxMailServers;
	}
	
	
	@FindBy(xpath = "//button[text()='No']")
	private WebElement noButton;

	public WebElement noButton() {
		return noButton;
	}
	
	
	
	
	@FindBy(xpath = "//input[@value='Refresh Address Book']")
	private WebElement refreshAddressBook;

	public WebElement refreshAddressBook() {
		return refreshAddressBook;
	}
	
	
	
	
	
	@FindBy(xpath = "//a[@onclick and text()='Users']")
	private WebElement addUsers;

	public WebElement AddUsers() {
		return addUsers;
	}
	
	@FindBy(xpath = "//input[@id='addAllButton']")
	private WebElement addAllButton;

	public WebElement addAllButton() {
		return addAllButton;
	}
	
	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement ok;

	public WebElement Ok() {
		return ok;
	}
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement retainLogin;

	public WebElement RetainLogin() {
		return retainLogin;
	}
	
	
	@FindBy(xpath = "//input[@id='ref.button']")
	private WebElement refreshJobCache;

	public WebElement RefreshJobCache() {
		return refreshJobCache;
	}
	
	
	@FindBy(xpath = "//span[text()='Status']")
	private WebElement workerStatus;

	public WebElement WorkerStatus() {
		return workerStatus;
	}
	
	
}
