package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ui.drivers.Driver.driver;

public class MainPage extends BasePage {
    @FindBy(xpath = "//button[contains(@class, 'cancel_pwa_button')]")
    private WebElement cancelButton;
    @FindBy(xpath = "//button[contains(@class, 'button') and .//span[text()='Принять']]")
    private WebElement acceptCookiesButton;
    @FindBy(css = "div.category-slider.slider_outer_wrapper a")
    private List<WebElement> links;
    @FindBy(xpath = "//a[@href='/auction?sort=fire']")
    private WebElement viewAllLots;
    @FindBy(xpath = "//div[@class='css-1cybrxp']")
    private List<WebElement> selectedFilters;
    @FindBy(css = "ul.css-njwz9s a.button")
    private List<WebElement> footerSocialLinks;

    public MainPage cancelInstallation() {
        if (cancelButton.isDisplayed()) {
            cancelButton.click();
        }
        return this;
    }

    public MainPage acceptCookies() {
        try {
            elementActions.waitElementToBeVisible(acceptCookiesButton);
            acceptCookiesButton.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public void inspectAutoSelectionLinks() throws IOException {
        SoftAssert a = new SoftAssert();
        elementActions.scrollToElements(links);
        for (WebElement element : links) {
            String url = element.getAttribute("href");
            HttpURLConnection conn;
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            a.assertTrue(respCode == 200, url + " : " + respCode);
        }
        a.assertAll();
    }

    public void checkViewAllButton() {
        String originalWindow = driver.getWindowHandle();
        Set<String> existingWindows = driver.getWindowHandles();
        elementActions.clickButton(viewAllLots);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.getWindowHandles().size() > existingWindows.size());
        Set<String> allWindows = driver.getWindowHandles();
        String newWindowHandle = allWindows.stream()
                .filter(windowHandle -> !existingWindows.contains(windowHandle))
                .findFirst()
                .orElseThrow(() -> new NoSuchWindowException("New window not found"));
        driver.switchTo().window(newWindowHandle);
        elementActions.waitElementsToBeVisible(selectedFilters);
        boolean isDamagedOrRunningButtonPresent = selectedFilters.stream()
                .anyMatch(chip -> chip.findElement(By.className("css-mjiy4b")).getText().contains("Кроме повреждённых или не на ходу"));
        boolean isResetButtonPresent = selectedFilters.stream()
                .anyMatch(chip -> chip.findElement(By.className("css-30g5gi")).getText().contains("Сбросить все"));
        Assert.assertTrue(isDamagedOrRunningButtonPresent);
        Assert.assertTrue(isResetButtonPresent);
    }

    public void inspectFooterSocialLinks() {
        SoftAssert softAssert = new SoftAssert();
        elementActions.scrollToElements(footerSocialLinks);
        List<WebElement> filteredLinks = footerSocialLinks.stream()
                .filter(element -> !element.getAttribute("href").contains("vk.com"))
                .collect(Collectors.toList());
        for (WebElement element : filteredLinks) {
            try {
                String url = element.getAttribute("href");
                elementActions.waitElementToBeDisplayed(element);
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                int respCode = conn.getResponseCode();
                conn.disconnect();
                softAssert.assertTrue(respCode == 200, url + " : " + respCode);
            } catch (IOException e) {
                softAssert.fail("IOException for element: " + element.getAttribute("href") + " : " + e.getMessage());
            }
        }
        softAssert.assertAll();
    }
}




