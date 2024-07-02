package test;
import core.BaseTest;
import org.junit.Test;



public class LoginTest extends BaseTest {
    @Test()
        public void loginWithValidCredentials() throws InterruptedException {
        mainPage.openMainPage()
                .cancelInstallation()
                .acceptCookies()
                .openLoginPage();
        loginPage.auth();
        }
    }

