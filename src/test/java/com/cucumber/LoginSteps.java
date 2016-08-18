package com.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSteps {
	private WebDriver driver;

	@Given("^I went to login screen$")
	public void i_went_to_login_screen() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://stagingwaitforvisible.herokuapp.com/");
	}

	@When("^I enter valid login$")
	public void i_enter_valid_login() throws Throwable {
		driver.findElement(By.id("user_email")).sendKeys("waitforvisible@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("welcome123");
		driver.findElement(By.name("commit")).click();
	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Throwable {
		String text = driver.findElement(By.cssSelector(".col h3")).getText();
		Assert.assertEquals(text, "Hello waitforvisible@gmail.com");
	}

}
