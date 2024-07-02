package ui.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.drivers.Driver;

import java.time.Duration;

public class ElementActions {
    public void waitButtonToBeClickable(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void clickButton(WebElement element) {
        waitButtonToBeClickable(element);
        highlightElement(element);
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

    public ElementActions writeNumber(WebElement element, int number) {
        waitElementToBeDisplayed(element);
        element.sendKeys(Integer.toString(number));
        return this;
    }

    public ElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public ElementActions clickJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click(true);", element);
        return this;

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
    public  void inputPhoneNumberWithPauses(WebElement field, String phoneNumber, int pauseMillis) throws InterruptedException {
        // Очистка поля перед вводом (если необходимо)
//        field.clear();

        // Ввод номера телефона по одному символу с паузами
        for (char ch : phoneNumber.toCharArray()) {
            field.sendKeys(String.valueOf(ch));
            Thread.sleep(pauseMillis); // Пауза между вводом символов
        }
    }
}



