package ui.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.support.PageFactory;
import ui.config.FakeDataProvider;
import ui.config.PasswordGenerator;
import ui.helper.CredentialsSaver;
import ui.helper.ElementActions;
import ui.drivers.Driver;

public class BasePage {
    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public final ElementActions elementActions = new ElementActions();
    public WebDriverManager webDriverManager = new ChromeDriverManager();
    public final FakeDataProvider fakeDataProvider = new FakeDataProvider();
    public final PasswordGenerator passwordGenerator = new PasswordGenerator();
    public final CredentialsSaver credentialsSaver = new CredentialsSaver();

}
