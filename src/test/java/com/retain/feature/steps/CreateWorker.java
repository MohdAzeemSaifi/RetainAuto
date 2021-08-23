package com.retain.feature.steps;

import org.testng.Assert;

import com.retain.utility.RetainWebHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateWorker extends RetainWebHelper{

	@When("^Access worker page$")
	public void access_worker_page() throws Throwable 
	{
		Assert.assertEquals(openWorkerPage(),true);	    
	}

	@And("^Add and enter worker details$")
	public void create_worker() throws Throwable 
	{
		Assert.assertEquals(createWorker(), true);
	}
	
	@And("^Configure bootstrap for wokrer$")
	public void configure_worker_bootstrap() throws InterruptedException {
		Assert.assertEquals(configureWorker(), true);
	}
}
