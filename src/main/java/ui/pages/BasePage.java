package ui.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.support.PageFactory;
import ui.helper.ElementActions;
import ui.drivers.Driver;

public class BasePage {
    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public final ElementActions elementActions = new ElementActions();
    public WebDriverManager webDriverManager = new ChromeDriverManager();

}
