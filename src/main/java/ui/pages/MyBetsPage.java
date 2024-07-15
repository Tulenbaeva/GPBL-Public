package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBetsPage extends BasePage {
    @FindBy(xpath = "//div[@class='typography default css-1pct9j8']")
    private WebElement numberOfLot;

    public boolean isLotPresent(String lotNumber) {
        return numberOfLot.getText().equals(lotNumber);
    }
}

