package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.models.IndividualCredentials;
import ui.models.LegalEntityCredentials;
import java.util.List;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@class='typography default css-1segv6e']")
    private WebElement registrationButton;
    @FindBy(xpath = "//input[contains(@placeholder, 'Телефон')]")
    private WebElement loginField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void authOfIndividual() throws InterruptedException {
        List<IndividualCredentials> credentialsList = credentialsSaver.readIndividualsFromFile();
        IndividualCredentials lastCredentials = credentialsList.get(credentialsList.size() - 1);
        Thread.sleep(5000);
        elementActions.inputPhoneNumberWithPauses(loginField, lastCredentials.getPhoneNumber(), 10);
        elementActions.sendKeys(passwordField, lastCredentials.getPassword());
        elementActions.scrollToElement(submitButton).clickButton(submitButton);
    }

    public void authOfLegalEntity() throws InterruptedException {
        List<LegalEntityCredentials> credentialsList = credentialsSaver.readLegalEntitiesFromFile();
        LegalEntityCredentials lastCredentials = credentialsList.get(credentialsList.size() - 1);
        Thread.sleep(3000);
        elementActions.inputPhoneNumberWithPauses(loginField, lastCredentials.getPhone(), 10);
        elementActions.sendKeys(passwordField, lastCredentials.getPassword());
        elementActions.scrollToElement(submitButton).clickButton(submitButton);

    }
}