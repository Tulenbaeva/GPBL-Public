package core;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ui.enums.ErrorMessages;
import ui.pages.*;
import ui.drivers.Driver;
import ui.helper.ElementActions;

abstract public class BaseTest {
    protected static WebDriver driver;
    protected static ElementActions elementActions;
    protected static MainPage mainPage;
    protected static LoginPage loginPage;
    protected static RegistrationOfIndividPage registrationOfIndividPage;
    protected static RegistrationOfLegalEntityPage registrationOfLegalEntityPage;
    protected static ErrorMessages errorMessages;
    protected static Sidebar sidebar;
    protected static AuctionPage auctionPage;
    protected static MyBetsPage myBetsPage;
    protected static ProfilePage profilePage;

    @BeforeClass
    public static void Initializer() {
        driver = Driver.getDriver();
        elementActions = new ElementActions();
        loginPage = new LoginPage();
        mainPage = new MainPage();
        registrationOfIndividPage = new RegistrationOfIndividPage();
        registrationOfLegalEntityPage = new RegistrationOfLegalEntityPage();
        sidebar = new Sidebar();
        auctionPage = new AuctionPage();
        myBetsPage = new MyBetsPage();
        profilePage = new ProfilePage();

    }

    @BeforeMethod(onlyForGroups = {"authRequired"})
    public void setUp() throws InterruptedException {
        sidebar.openMainPage();
        mainPage.cancelInstallation()
                .acceptCookies();
        sidebar.openLoginPage();
        loginPage.authOfIndividual();
    }

    public void authorize(ITestResult result) {
        if (result.getMethod().getGroups() != null) {
            result.getMethod().getGroups();
        }
    }
}
//    @AfterClass
//    public void tearDown() throws InterruptedException {
//        sidebar.openProfilePage();
//        profilePage.logOut();
//        driver.quit();
//    }

