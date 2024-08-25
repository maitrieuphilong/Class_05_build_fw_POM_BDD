package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumberOptions.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class LoginPageSteps {
	WebDriver driver;
	static String loginPageUrl;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	public LoginPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Given("Get Login page URL")
	public void getLoginPageURL() {
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@When("Open Register Page by click here linktext")
	public void openRegisterPageByClickHereLinktext() {
		registerPage = loginPage.clickToHereLink();
	}
	
	@When("Submit valid info UserId and Password to Login Page")
	public void submitValidInfoUserIdAndPasswordToLoginPage() {
		loginPage.inputTextToUserIDTextboxAtLoginForm(RegisterPageSteps.username);
		loginPage.inputTextToPasswordTextboxAtLoginForm(RegisterPageSteps.password);
		loginPage.clickToLoginButtonAtLoginForm();
	}
}
