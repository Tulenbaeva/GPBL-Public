package ui.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.config.ConfigProvider;

import java.time.Duration;

import static ui.drivers.Driver.driver;

public class Sidebar extends BasePage {
    @FindBy(xpath = "//div[text()='Главная']")
    private WebElement mainPageButton;
    @FindBy(xpath = "//a[@href='/auction']")
    private WebElement auctionPageButton;
    @FindBy(xpath = "//a[@href='/how-buy']")
    private WebElement howBuyPageButton;
    @FindBy(xpath = "//a[@href='/about']")
    private WebElement aboutCompanyPageButton;
    @FindBy(xpath = "//a[@href='/faq']")
    private WebElement fAQPageButton;
    @FindBy(xpath = "//a[@href='/favorites']")
    private WebElement favoritesPageButton;
    @FindBy(xpath = "//a[@href='/my-bets']/div[@class='css-106uiby']")
    private WebElement myBetsPageButton;
    @FindBy(xpath = "(//a[@href='/profile'])[2]")
    private WebElement profilePageButton;
    @FindBy(xpath = "//div[@class='css-comszl']")
    private WebElement loginPageButton;

    public void openMainPage() {
        driver.get(ConfigProvider.URL);
        new MainPage();
    }


    public void openAuctionPage() {
        elementActions.clickViaJS(auctionPageButton);
        new AuctionPage();
    }

    public HowToBuyPage openHowBuyPage() {
        elementActions.clickButton(howBuyPageButton);
        return new HowToBuyPage();
    }

    public AboutCompanyPage openAboutCompanyPage() {
        elementActions.clickButton(aboutCompanyPageButton);
        return new AboutCompanyPage();
    }

    public FAQPage openFAQPage() {
        elementActions.clickButton(fAQPageButton);
        return new FAQPage();
    }

    public FavoritesPage openFavoritesPage() {
        elementActions.clickButton(favoritesPageButton);
        return new FavoritesPage();
    }

    public MyBetsPage openMyBetsPage() {
        elementActions.clickButton(myBetsPageButton);
        return new MyBetsPage();
    }

    public void openProfilePage() {
        elementActions.scrollToElement(profilePageButton);
        elementActions.clickButton(profilePageButton);
        new ProfilePage();
    }

    public void openLoginPage() {
        elementActions.clickButton(loginPageButton);
        new LoginPage();
    }

    public WebElement getProfileLink() {
        return profilePageButton;
    }

    public boolean isProfileButtonAbsent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(profilePageButton));
            return true;
        } catch (NoSuchElementException e) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


