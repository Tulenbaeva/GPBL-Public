package ui.helper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.drivers.Driver;
import java.time.Duration;
import java.util.List;

import static ui.drivers.Driver.driver;

public class ElementActions {
    public void waitButtonToBeClickable(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
    }
    public void waitElementsToBeDisplayed(List<WebElement> elements) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf((WebElement) elements));
    }

    public void clickButton(WebElement element) {
        waitButtonToBeClickable(element);
        element.click();
    }

    public void sendKeys(WebElement element, String txt) {
        waitElementToBeDisplayed(element);
        element.sendKeys(txt);
    }

    public void sendKeysWithDelay(WebElement element, String text, int delayInMillis) {
        for (char character : text.toCharArray()) {
            element.sendKeys(Character.toString(character));
            try {
                Thread.sleep(delayInMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public void clickJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click(true);", element);

    }

    public ElementActions writeTextWithEnter(WebElement element, String txt) {
        waitElementToBeDisplayed(element);
        element.sendKeys(txt, Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid green");
    }

    public ElementActions scrollToTop() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollTo(0, 0);");
        return this;
    }

    public void sendKeysByJs(WebElement element, String text) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + text + "')", element);
    }

    public void inputPhoneNumberWithPauses(WebElement field, String phoneNumber, int pauseMillis) throws InterruptedException {
        for (char ch : phoneNumber.toCharArray()) {
            field.sendKeys(String.valueOf(ch));
            Thread.sleep(pauseMillis);
        }
    }

    public void clickViaJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void waitElementsToBeVisible(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }

    public void waitElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public void scrollToElements(List<WebElement> elements) {
        if (elements != null && !elements.isEmpty()) {
            for (WebElement element : elements) {
                scrollToElement(element);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void scrollBy(WebDriver driver, int xOffset, int yOffset) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + xOffset + "," + yOffset + ")");
    }
}