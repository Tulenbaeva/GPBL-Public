package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.config.ConfigProvider;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@class='typography default css-1segv6e']")
    private WebElement  registrationButton;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void auth() throws InterruptedException {
        loginField.clear();
        elementActions.sendKeysByJs(loginField, ConfigProvider.USER_LOGIN);
        elementActions.sendKeys(passwordField, ConfigProvider.USER_PASSWORD);
        elementActions.scrollToElement(submitButton).clickButton(submitButton);

    }
}