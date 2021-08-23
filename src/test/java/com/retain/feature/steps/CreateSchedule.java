package com.retain.feature.steps;

import org.testng.Assert;

import com.retain.utility.RetainWebHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateSchedule extends RetainWebHelper{
	
	@When("^Access Schedule configuration page$")
	public void enter_base_configuration() throws Throwable 
	{
		Assert.assertEquals(openSchedulePage(),true);	    
	}

	@Then("^Add and create groupwise Schedule details$")
	public void create_groupwise_schedule() throws Throwable 
	{
		Assert.assertEquals(createGroupWiseSchedule(), true);
	}
	
	@Then("^Add and create exchange Schedule details$")
	public void create_exchange_schedule() throws Throwable 
	{
		Assert.assertEquals(createExchangeSchedule(), true);
	}
	
}
