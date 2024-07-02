package core;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.drivers.Driver;
import ui.helper.ElementActions;
import ui.pages.RegistrationPage;

abstract public class BaseTest {
    protected static WebDriver driver;
    protected static ElementActions elementActions;
    protected static MainPage mainPage;
    protected static LoginPage loginPage;
    protected static RegistrationPage registrationPage;

    @BeforeClass
    public static void Initializer() {
        driver = Driver.getDriver();
        elementActions = new ElementActions();
        loginPage = new LoginPage();
        mainPage = new MainPage();
        registrationPage=new RegistrationPage();
    }
}
