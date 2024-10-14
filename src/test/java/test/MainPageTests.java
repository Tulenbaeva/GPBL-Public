package test;
import core.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class MainPageTests extends BaseTest {
    @Test(description = "Проверка ссылок в разделе 'Подборка автомобилей'", groups = {"authRequired"})
    public void inspectAutoSelectionLinks() throws IOException {
        mainPage.inspectAutoSelectionLinks();
    }
    @Test(description = "Смотреть все лоты", groups = {"authRequired"})
    public void checkViewAllLotsBtn(){
        mainPage.checkViewAllButton();
    }
    @Test(description = "Проверка ссылок на соцсети во футере", groups = {"authRequired"})
    public void inspectFooterSocialLinks() {
        mainPage.inspectFooterSocialLinks();
    }
}