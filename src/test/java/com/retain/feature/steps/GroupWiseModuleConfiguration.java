package com.retain.feature.steps;

import org.testng.Assert;

import com.retain.utility.RetainWebHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GroupWiseModuleConfiguration extends RetainWebHelper{

   
	@When("^Select and enter Groupwise module configuration details$")
	public void click_on_search_button() throws Throwable 
	{
		Assert.assertEquals(groupWiseModuleConfiguration(), true);
	}
 
	
}
