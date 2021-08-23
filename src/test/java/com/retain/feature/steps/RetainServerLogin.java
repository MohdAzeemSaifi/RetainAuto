package com.retain.feature.steps;
 

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.retain.utility.AutoProperties;
import com.retain.utility.ClientProvider;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.retain.utility.PropertiesProvider;
import com.retain.utility.RetainWebHelper;

public class RetainServerLogin extends RetainWebHelper{
	
	@Given("^Load URL for server$")
	public void load_retain_server_url() throws Exception
	{
			Assert.assertEquals(LoadURL(), true);
	}
	
    @When("^Login with retain server$")
    public void login_retain_server() throws Exception {
    	Assert.assertEquals(LoginRetainServer(), true);
    }
    
    @And("^Logout the from the retain server$")
    public void logout_retain_server() throws Exception {
    	Assert.assertEquals(LogoutRetainServer(), true);
    }
	
}