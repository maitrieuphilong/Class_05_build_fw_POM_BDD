package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumberOptions.Hooks;
import io.cucumber.java.en.Then;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;

public class HomePageSteps {
	WebDriver driver;
	HomePageObject homePage;
	
	public HomePageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Then("Home Page is displayed")
	public void homePageIsDisplayed() {
		Assert.assertTrue(homePage.isWelcomMessageDisplayed());
	}
}
