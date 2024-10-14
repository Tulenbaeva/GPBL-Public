package ui.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.config.ConfigProvider;
import ui.models.LegalEntityCredentials;

public class RegistrationOfLegalEntityPage extends BasePage {
    @FindBy(xpath = "//div[@class='typography default css-1segv6e' and contains(text(), 'Регистрация')]")
    private WebElement registrationButton;
    @FindBy(xpath = "//div[@class='css-uoxj1n']/div[@class='typography default css-9j3io3' and contains(text(), 'Юридическое лицо')]")
    private WebElement legalEntityType;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement consentCheckBox;
    @FindBy(xpath = "//button[span[text()='Продолжить']]")
    private WebElement continueButton;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneField;
    @FindBy(xpath = "//input[@name='inn']")
    private WebElement INNField;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement companyNameField;
    @FindBy(xpath = "//input[@name='contactPerson']")
    private WebElement contactPersonNameField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='passwordConfirm']")
    private WebElement passwordConfirmField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@aria-label='verification input']")
    private WebElement verificationInput;


    public void registrationOfLegalEntity() throws InterruptedException {
        elementActions.scrollToElement(registrationButton);
        elementActions.clickButton(registrationButton);
        legalEntityType.click();
        elementActions.scrollToElement(consentCheckBox);
        consentCheckBox.click();
        continueButton.click();
        String phoneNumber = fakeDataProvider.generatePhoneNumber();
        String inn = fakeDataProvider.generateINN();
        String companyName = fakeDataProvider.generateCompanyName();
        String contactPersonName = fakeDataProvider.generateContactPersonName();
        String password=passwordGenerator.generatePassword();
        Thread.sleep(1000);
        elementActions.inputPhoneNumberWithPauses(phoneField, phoneNumber, 10);
        elementActions.sendKeys(INNField, inn);
        elementActions.sendKeys(companyNameField, companyName);
        elementActions.sendKeys(contactPersonNameField, contactPersonName);
        elementActions.sendKeys(passwordField, password);
        elementActions.sendKeys(passwordConfirmField, password);
        elementActions.scrollToElement(submitButton);
        submitButton.click();
        elementActions.sendKeys(verificationInput, ConfigProvider.VERIFICATION_INPUT);
        LegalEntityCredentials legalEntityCredentials=new LegalEntityCredentials(phoneNumber, inn, companyName, contactPersonName, password);
        credentialsSaver.saveLegalEntity(legalEntityCredentials);
    }
}
