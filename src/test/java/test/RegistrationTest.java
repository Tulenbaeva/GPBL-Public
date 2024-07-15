package test;
import core.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
   @Test(description = "Регистрация физ лица (меню)")
    public void registrationOfIndividual() throws InterruptedException {
        mainPage.openMainPage()
                .acceptCookies()
                .cancelInstallation();
        sidebar.openLoginPage();
        registrationOfIndividPage.registrationOfIndividual();
        Assert.assertTrue(sidebar.getProfileLink().isDisplayed());
    }
    @Test(description = "Регистрация юр. лица (меню)")
    public void registrationOfLegalEntity() throws InterruptedException {
        mainPage.openMainPage()
                .acceptCookies()
                .cancelInstallation();
        sidebar.openLoginPage();
        registrationOfLegalEntityPage.registrationOfLegalEntity();
        Assert.assertTrue(sidebar.getProfileLink().isDisplayed());
    }

    @Test(description = "Регистрация с невалидным номером телефона(короче 10 цифр)")
    public void registrationOfIndividualWithInvalidPhoneNum() {
        mainPage.openMainPage()
                .acceptCookies()
                .cancelInstallation();
        sidebar.openLoginPage();
//        registrationOfIndividPage.registrationOfIndividualWithInvalidPhoneNum();


    }
}
