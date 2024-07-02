package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.config.ConfigProvider;

import java.time.Duration;

import static ui.drivers.Driver.driver;

public class MainPage extends BasePage {
    @FindBy(xpath = "//button[@class='button cancel_pwa_button css-1ipagq3']")
    private WebElement cancelButton;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/aside/div[3]/div/div")
    private WebElement loginButton;
    @FindBy(xpath = "//button[@class='button css-193laco']")
    private WebElement acceptCookiesButton;

    public MainPage openMainPage(){
        driver.get(ConfigProvider.URL);
        return this;
    }
    public MainPage cancelInstallation() {
        if (cancelButton.isDisplayed()){
            cancelButton.click();
    }
        return this;
    }
    public MainPage acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(acceptCookiesButton));
            acceptCookiesButton.click();
        } catch (Exception e) {
        }

        return this;
}
    public LoginPage openLoginPage() {
        loginButton.click();
       return  new LoginPage();
    }
}
