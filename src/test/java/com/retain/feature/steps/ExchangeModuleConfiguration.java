package com.retain.feature.steps;

import org.testng.Assert;

import com.retain.utility.RetainWebHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExchangeModuleConfiguration extends RetainWebHelper {
	
	@When("^Access module configuration page$")
	public void access_module_configuration_page() throws Throwable 
	{
		Assert.assertEquals(true,openModuleConfigurationPage());	    
	}


	@Then("^Select and enter exchange module configuration details$")
	public void select_enter_config_details() throws Throwable 
	{
		Assert.assertEquals(true, configureExchangeModule());
	}
	

	@And("^Refresh address book$")
	public void refresh_address_book() throws Throwable 
	{
		Assert.assertEquals(refreshAddressBook(),true);
	}
	
	
}
