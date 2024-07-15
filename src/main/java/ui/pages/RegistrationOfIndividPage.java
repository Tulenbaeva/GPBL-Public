package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.config.ConfigProvider;
import ui.models.IndividualCredentials;

public class RegistrationOfIndividPage extends BasePage {
    @FindBy(xpath = "//div[@class='typography default css-1segv6e']")
    private WebElement registrationButton;
    @FindBy(xpath = "//*[contains(text(), 'Физическое лицо')]")
    private WebElement individualTypeButton;
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
    @FindBy(xpath = "//label[text()='Телефон: проверьте номер']")
    private WebElement errorMsg;


    public void registrationOfIndividual() throws InterruptedException {
        elementActions.scrollToElement(registrationButton);
        elementActions.clickButton(registrationButton);
        individualTypeButton.click();
        elementActions.scrollToElement(consentCheckBox);
        consentCheckBox.click();
        continueButton.click();
        Thread.sleep(5000);
        String phoneNumber = fakeDataProvider.generatePhoneNumber();
        String lastName = fakeDataProvider.generateUserLastName();
        String firstName = fakeDataProvider.generateUserFirstName();
        String password = passwordGenerator.generatePassword();
        elementActions.sendKeys(phoneField, phoneNumber);
        elementActions.sendKeys(lastNameField, lastName);
        elementActions.sendKeys(firstNameField, firstName);
        elementActions.sendKeys(passwordField, password);
        elementActions.sendKeys(passwordConfirmationField, password);
        elementActions.scrollToElement(submitButton);
        submitButton.click();
        elementActions.sendKeys(verificationInput, ConfigProvider.VERIFICATION_INPUT);
        IndividualCredentials individualCredentials = new IndividualCredentials(phoneNumber, firstName, lastName, password);
        credentialsSaver.saveIndividual(individualCredentials);
    }
}



