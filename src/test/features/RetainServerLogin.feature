@RetainServerBuildValidation
Feature: Retain Server P0 Build Validation with windows Server.
@ValidatingRetainConfiguration
  Scenario: Retain Server Configuration with MSSQL Database.
    Given Load Retain Server Configuration page
    When Enter Base path configuration details
    And Enter Message store Database details
    And Enter Database Configuration details   
    And Enter administrator Account Configuration
    And Enter SMTP Configuration details
    And Enter indexing engine Configuration details
    And Retain Server Connection Configuration details
    When Complete Retain Configuration
    Then Login Retain server after configuration


@GroupwiseModuleConfiguration
  Scenario: Groupwise module configuration.
  	Given Load URL for server
    And Login with retain server
    When Access module configuration page
    And Select and enter Groupwise module configuration details 
     

@ExchangeModuleConfiguration
  Scenario: Exchange module configuration.
    When Access module configuration page
    And Select and enter exchange module configuration details
    Then Refresh address book
         
@CreateGroupWiseSchedule     
  Scenario: Create Schedule for groupwise module.
    When Access Schedule configuration page
    Then Add and create groupwise Schedule details   
    
@CreateExchangeSchedule       
 Scenario: Create Schedule for exchange module.
    When Access Schedule configuration page
    Then Add and create exchange Schedule details   
    
@CreateGroupWiseProfile     
  Scenario: Create Profile for groupwise module.
    When Access groupwise profile page
    Then Add and enter groupwise profile details  
     
@CreateExchangeProfile 
Scenario: Create Profile for exchange module.   
    When Access exchange profile page
    Then Add and enter exchange profile details 
      
@CreateWorker     
  Scenario: Create Worker for the module.
    When Access worker page
    And Add and enter worker details
    Then Configure bootstrap for wokrer 
     
@CreateGroupWiseJob     
  Scenario: Create Job for groupwise module
    When Access groupwise job page
    And Add and enter groupwise job details   
      
@CreateExchangeJob     
  Scenario: Create Job for exchange module.
    When Access exchange job page
    And Add and enter exchange job details
    Then Logout the from the retain server

   



  
   	
   	
   	
	
		