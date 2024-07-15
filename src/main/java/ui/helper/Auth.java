package ui.helper;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.Sidebar;

public class Auth{
    public void authOfIndividual() throws InterruptedException {
        MainPage mainPage=new MainPage();
        Sidebar sidebar=new Sidebar();
        LoginPage loginPage=new LoginPage();
        mainPage.openMainPage()
                .acceptCookies()
                .cancelInstallation();
        sidebar.openLoginPage();
        loginPage.authOfIndividual();
    }
}
