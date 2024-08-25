package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToHereLink() {
		waitForElementClickable(driver, LoginPageUI.HERE_LINKTEXT);
		clickToElement(driver, LoginPageUI.HERE_LINKTEXT);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public void inputTextToUserIDTextboxAtLoginForm(String username) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, username);
	}
	
	public void inputTextToPasswordTextboxAtLoginForm(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickToLoginButtonAtLoginForm() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}

}
