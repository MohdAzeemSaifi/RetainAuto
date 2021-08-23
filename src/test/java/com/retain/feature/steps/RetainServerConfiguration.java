package com.retain.feature.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.retain.utility.AutoProperties;
import com.retain.utility.RetainWebHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RetainServerConfiguration extends RetainWebHelper{
    
	@Given("^Load Retain Server Configuration page$")
	public void Load_Retain_Server_Config_Page() throws Throwable 
	{
		Assert.assertEquals(true, LoadURL());
	}
	
	@When("^Enter Base path configuration details$")
	public void enter_base_configuration() throws Throwable 
	{
		Assert.assertEquals(true, basePathConfiguration());	    
	}

	@And("^Enter Message store Database details$")
	public void enter_message_store_database() throws Throwable 
	{
		Assert.assertEquals(true, messageStoreDatabaseCongig());
	}

	@And("^Enter Database Configuration details$")
	public void click_on_search_button() throws Throwable 
	{
		Assert.assertEquals(true, databaseConfiguration());
	}
	
	@And("^Enter administrator Account Configuration$")
	public void administrator_account_cinfiguration() throws Throwable 
	{
		Assert.assertEquals(true, administratorAccountConfig());
	}
	
	@And("^Enter SMTP Configuration details$")
	public void smtp_cinfiguration() throws Throwable 
	{
		Assert.assertEquals(true, smtpConfiguration());
	}
	
	@And("^Enter indexing engine Configuration details$")
	public void indexing_engine_cinfiguration() throws Throwable 
	{
		Assert.assertEquals(true, indexingConfiguration());
	}
	
	@And("^Retain Server Connection Configuration details$")
	public void retain_connection_cinfiguration() throws Throwable 
	{
		Assert.assertEquals(true, retainConnectionConfigration());
	}
	
	@When("^Complete Retain Configuration$")
    public void complete_retain_configuration() {
		Assert.assertEquals(true, completeRetainConfiguration());
	}

	@Then("^Login Retain server after configuration$")
	public void login_ratain_server() throws Throwable 
	{
		Assert.assertEquals(true, LoginRetainServer());
	}
	
}
