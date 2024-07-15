package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    @FindBy(xpath = "(//button[@class='button css-eoc6xo'])[2]")
    private WebElement logOutButton;

    public void logOut(){
        elementActions.clickButton(logOutButton);
    }
}
