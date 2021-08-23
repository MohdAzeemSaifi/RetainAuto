package com.retain.feature.steps;

import org.testng.Assert;

import com.retain.utility.RetainWebHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateJob extends RetainWebHelper{

	@When("^Access groupwise job page$")
	public void access_groupwise_job_page() throws Throwable 
	{
		Assert.assertEquals(openGroupWiseJobPage(),true);	    
	}

	@Then("^Add and enter groupwise job details$")
	public void create_groupwise_job() throws Throwable 
	{
		Assert.assertEquals(createGroupWiseJob(), true);
	}
	
	@When("^Access exchange job page$")
	public void access_exchange_job_page() throws Throwable 
	{
		Assert.assertEquals(openExchangeJobPage(),true);	    
	}
	
	@And("^Add and enter exchange job details$")
	public void create_exchange_job() throws Throwable 
	{
		Assert.assertEquals(createExchnageJob(), true);
	}
	
}
