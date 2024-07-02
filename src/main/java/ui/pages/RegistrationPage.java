package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.config.ConfigProvider;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//div[@class='typography default css-1segv6e']")
    private WebElement registrationButton;
    @FindBy(xpath = "//div[@class='typography default css-9j3io3']")
    private WebElement individualType;
    @FindBy(xpath = "//div[@class='typography default css-9j3io3']")
    private WebElement individualTypeButton;
    @FindBy(xpath = "typography default css-9j3io3")
    private WebElement legalTypeButton;
    @FindBy(xpath = "//input[@class='checkbox-layout css-1wr05cf']")
    private WebElement consentCheckBox;
    @FindBy(xpath = "//button[@class='button css-1jc2v83']")
    private WebElement continueButton;
    @FindBy(xpath = "//input[@class='input-wrapper-input']")
    private WebElement phoneField;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleNameField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='passwordConfirm']")
    private WebElement passwordConfirmationField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
      @FindBy(xpath = "//input[@aria-label='verification input']")
    private WebElement verificationInput;


    public void registrationOfIndividual() throws InterruptedException {
        elementActions.scrollToElement(registrationButton);
        registrationButton.click();
        individualTypeButton.click();
        elementActions.scrollToElement(consentCheckBox);
        consentCheckBox.click();
        continueButton.click();
        elementActions.inputPhoneNumberWithPauses(phoneField, ConfigProvider.USER_PHONE, 10);
        elementActions.sendKeys(lastNameField, ConfigProvider.USER_LASTNAME);
        elementActions.sendKeys(firstNameField, ConfigProvider.USER_FIRSTNAME);
        elementActions.sendKeys(middleNameField, ConfigProvider.USER_MIDDLENAME);
        elementActions.sendKeys(passwordField, ConfigProvider.USER_PASSWORD);
        elementActions.sendKeys(passwordConfirmationField, ConfigProvider.USER_PASSWORD);
        elementActions.scrollToElement(submitButton);
        submitButton.click();
       elementActions.sendKeys(verificationInput, ConfigProvider.VERIFICATION_INPUT);
    }
}

