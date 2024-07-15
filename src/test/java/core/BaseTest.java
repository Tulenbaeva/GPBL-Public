package core;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
        registrationOfIndividPage=new RegistrationOfIndividPage();
        registrationOfLegalEntityPage=new RegistrationOfLegalEntityPage();
        sidebar= new Sidebar();
        auctionPage=new AuctionPage();
        myBetsPage=new MyBetsPage();
        profilePage=new ProfilePage();
    }
//    @AfterClass
//    public void deAuthorization() throws InterruptedException {
//        sidebar.openProfilePage();
//        profilePage.logOut();
//    }
}
