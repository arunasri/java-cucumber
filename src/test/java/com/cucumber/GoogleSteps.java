package com.cucumber;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GoogleSteps {
	@Given("^User went to primier home page$")
	public void user_went_to_primier_home_page() throws Throwable {
		driver.get("https://www.premierinc.com/");
	}

	@When("^I click on carriers links$")
	public void i_click_on_carriers_links() throws Throwable {
		driver.findElement(By.partialLinkText("Careers")).click();
	}

	@Then("^I should see carriers$")
	public void i_should_see_carriers() throws Throwable {
		Assert.assertEquals(driver.findElement(By.className("breadcrumb_last")).getText(), "adfareers");
	}

	protected WebDriver driver;
	public static final String USERNAME = "waitforvisible";
	public static final String ACCESS_KEY = "1c352c9a-036d-49ee-a066-9994a25eb629";

	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "43.0");

		driver = new RemoteWebDriver(new URL(URL), caps);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	// @Given("^I go to premier registration page$")
	// public void i_go_to_premier_registration_page() throws Throwable {
	// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	// driver.get("https://www.premierinc.com/");
	// driver.findElement(By.linkText("Register")).click();;
	// }
	//
	// @When("^I gave consent to Terms of use$")
	// public void i_give_consent_to_Terms_of_use() throws Throwable {
	// JavascriptExecutor jse = (JavascriptExecutor)driver;
	// jse.executeScript("window.scrollBy(0,250)", "");
	// WebElement iframeElement =
	// driver.findElement(By.cssSelector("iframe[title='Registration']"));
	// driver.switchTo().frame(iframeElement);
	// driver.findElement(By.cssSelector("input[value='Y']")).click();;
	// driver.findElement(By.id("submit1")).click();;
	// }
	//
	// @Then("^I should i see Registration Page$")
	// public void i_should_i_see_Registration_Page() throws Throwable {
	// // Write code here that turns the phrase above into concrete actions
	//
	// Assert.assertEquals(driver.findElement(By.cssSelector(".minimal-h2.pull-left")).getText(),
	// "Personal Information");
	// }
}
