package test;

import core.BaseTest;
import org.junit.Test;


public class RegistrationTest extends BaseTest {
    @Test()
    public void registration() throws InterruptedException {

        mainPage.openMainPage()
                .acceptCookies()
                .cancelInstallation()
                .openLoginPage();
        registrationPage.registrationOfIndividual();

    }
}

