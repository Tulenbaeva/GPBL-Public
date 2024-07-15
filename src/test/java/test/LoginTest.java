package test;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {
    @BeforeClass
    @Test(description = "Авторизация физ лица(меню)")
    public void authOfIndividual() throws InterruptedException {
        mainPage.openMainPage()
                .cancelInstallation()
                .acceptCookies();
        sidebar.openLoginPage();
        loginPage.authOfIndividual();
    }

    @Test(description = "Авторизация юр. лица(меню)")
    public void authOfLegalEntity() throws InterruptedException {
        mainPage.openMainPage()
                .cancelInstallation()
                .acceptCookies();
        sidebar.openLoginPage();
        loginPage.authOfLegalEntity();
    }
    @Test(description = "Деавторизация")
    public void deAuthorization() {
        sidebar.openProfilePage();
        profilePage.logOut();
        Assert.assertTrue(sidebar.isProfileButtonAbsent());
    }
}


