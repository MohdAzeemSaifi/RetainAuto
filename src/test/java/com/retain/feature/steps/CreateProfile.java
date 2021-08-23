package com.retain.feature.steps;

import org.testng.Assert;

import com.retain.utility.RetainWebHelper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProfile extends RetainWebHelper{

	
	@When("^Access groupwise profile page$")
	public void access_groupwise_profile_page() throws Throwable 
	{
		Assert.assertEquals(openProfilePage("groupwise"),true);	    
	}

	@Then("^Add and enter groupwise profile details$")
	public void create_groupwise_profile() throws Throwable 
	{
		Assert.assertEquals(createProfile(groupWiseProfileID), true);
	}
	
	@When("^Access exchange profile page$")
	public void access_exchange_profile_page() throws Throwable 
	{
		Assert.assertEquals(openProfilePage("exchange"),true);	    
	}

	@Then("^Add and enter exchange profile details$")
	public void create_exchange_profile() throws Throwable 
	{
		Assert.assertEquals(createProfile(exchangeProfileID), true);
	}
	
}
