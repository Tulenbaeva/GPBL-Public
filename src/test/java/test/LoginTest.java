package test;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {
    @Test(description = "Авторизация физ лица(меню)")
    public void authOfIndividual() throws InterruptedException{
        sidebar.openMainPage();
        mainPage.cancelInstallation()
                .acceptCookies();
        sidebar.openLoginPage();
        loginPage.authOfIndividual();
        Assert.assertTrue(sidebar.getProfileLink().isDisplayed());
    }
    @Test(description = "Авторизация юр. лица(меню)")
    public void authOfLegalEntity() throws InterruptedException {
        sidebar.openMainPage();
        mainPage.cancelInstallation()
                .acceptCookies();
        sidebar.openLoginPage();
        loginPage.authOfLegalEntity();
        Assert.assertTrue(sidebar.getProfileLink().isDisplayed());
    }
    @Test(description = "Деавторизация")
    public void deAuthorization() {
        sidebar.openProfilePage();
        profilePage.logOut();
        Assert.assertTrue(sidebar.isProfileButtonAbsent());
    }
}


