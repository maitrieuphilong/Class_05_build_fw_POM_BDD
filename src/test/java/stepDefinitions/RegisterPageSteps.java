package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumberOptions.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import utils.DataHelper;

public class RegisterPageSteps {
	WebDriver driver;
	static String username, password;
	DataHelper dataTest;
	RegisterPageObject registerPage;

	public RegisterPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		dataTest = DataHelper.getData();
	}

	@When("Input to Email textbox")
	public void inputToEmailTextbox() {
		registerPage.inputToEmailTextboxToRegisterForm(dataTest.getEmail());
	}

	@When("Click to Submit button")
	public void clickToSubmitButton() {
		registerPage.clickToSubmitButtonToRegisterForm();
	}

	@Then("Get Username and Password info")
	public void getUsernameAndPasswordInfo() {
		username = registerPage.getUserIDText();
		password = registerPage.getPasswordText();
	}

	@When("Back to Login Page")
	public void backToLoginPage() {
		registerPage.openLoginPage(LoginPageSteps.loginPageUrl);
	}

	

}
