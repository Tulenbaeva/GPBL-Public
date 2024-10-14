package ui.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.*;

import static ui.drivers.Driver.driver;


public class AuctionPage extends BasePage {
    @FindBy(xpath = "//div[a[span[text()='Сделать ставку']]]")
    private List<WebElement> placeBetButtons;
    @FindBy(xpath = "(//button[@class='button css-1l3sw6q'])[3]")
    private WebElement bidButton;
    @FindBy(xpath = "//div[@class='typography secondary-text default css-4wstx7']")
    private WebElement numberOfLot;
    @FindBy(xpath = "//div[@class=' css-1a0g2vr']")
    private List<WebElement> lotItems;
    @FindBy(xpath = "(//div[@class='hiding-panel-trigger css-1ougbp4'])[2]")
    private WebElement historyOfTradingDropDown;
    @FindBy(xpath = "(//table[@class='custom-table css-3b1ss9'])[2]")
    private List<WebElement> tradingHistoryTable;
    @FindBy(id = "like-lot-btn")
    private List<WebElement> likeBtn;
    @FindBy(xpath = "//button[@class='button css-19ryklm'])[1]")
    private WebElement likedButton;
    @FindBy(xpath = "//div[@class='tbi header css-me0zjk' and @data-item-title='common']")
    private WebElement autoTab;
    @FindBy(xpath = "//div[@class='tbi header css-me0zjk' and @data-item-title='special']")
    private WebElement specTechTab;
    @FindBy(xpath = "(//div[text()='Все'])[2]")
    private WebElement allTab;
    @FindBy(xpath = "//div[@class=' css-1a0g2vr']")
    private List<WebElement> listOfAllLots;
    @FindBy(xpath = "//section[div[h3[text()='Основные характеристики']]]")
    private List<WebElement> characteristicsTable;
    @FindBy(xpath = "(//div[text()='Ваша ставка лидирует'])[1]")
    private WebElement msgAfterBid;
    @FindBy(xpath = "(//div[div[h2[text()='Аукцион завершен']]])[1]")
    private WebElement msgAfterBlitzBid;
    @FindBy(xpath = "//div[text()='Great Wall Hover H5, 2013']")
    private WebElement lotWithBlitzRate;
    @FindBy(xpath = "(//button[span[text()='Купить cейчас']])[2]")
    private WebElement buyNowButton;
    @FindBy(xpath = "//button[span[text()='Да']]")
    private WebElement blitzBidConfirmation;
    @FindBy(xpath = "(//input[@placeholder='Марка'])[1]")
    private WebElement brandPlaceholder;
    @FindBy(css = ".typography.typography.default.default.css-1m5714k")
    private WebElement brandAndModelOnCard;
    @FindBy(css = ".scroll-container .button")
    private List<WebElement> brandMenu;
    @FindBy(xpath = "(//div[@class='scroll-container css-1bbhgoo'])[2]")
    private List<WebElement> modelMenu;
    @FindBy(xpath = "(//input[@placeholder='Модель'])[1]")
    private WebElement modelPlaceholder;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement showButton;
    @FindBy(xpath = "//div[@class='toggle-box toggle-box-small']")
    private WebElement advancedFilterToggle;
    @FindBy(xpath = "(//input[@placeholder='Год от'])[1]")
    private WebElement inputOfYearFrom;
    @FindBy(xpath = "(//input[@placeholder='до'])[1]")
    private WebElement inputOfYearTo;
    @FindBy(xpath = "(//input[@placeholder='Пробег от'])[2]")
    private WebElement inputOfMileAgeFrom;
    @FindBy(xpath = "(//input[@placeholder='до'])[8]")
    private WebElement inputOfMileAgeTo;
    @FindBy(xpath = "(//div[@class='typography default css-bdji1y'])[1]")
    private List<WebElement> mileAgeOfLots;
    @FindBy(xpath = "(//input[@placeholder='Объем от, л'])[2]")
    private WebElement volumeFromInput;
    @FindBy(xpath = "(//input[@placeholder='до'])[9]")
    private WebElement volumeToInput;
    @FindBy(xpath = "(//input[@placeholder='Мощность от, л.с.'])[2]")
    private WebElement powerFromInput;
    @FindBy(xpath = "(//input[@placeholder='до'])[10]")
    private WebElement powerToInput;
    @FindBy(xpath = "(//input[@placeholder='Тип двигателя'])[2]")
    private WebElement engineTypeInput;
    @FindBy(xpath = "(//div[@class='scroll-container css-1bbhgoo'])[11]")
    private List<WebElement> engineTypeMenu;
    @FindBy(xpath = "(//input[@placeholder='Коробка передач'])[2]")
    private WebElement gearboxInput;
    @FindBy(xpath = "(//div[@class='scroll-container css-1bbhgoo'])[12]")
    private List<WebElement> gearboxMenu;
    @FindBy(xpath = "(//input[@placeholder='Привод'])[2]")
    private WebElement driveDropDown;
    @FindBy(xpath = "(//div[@class='scroll-container css-1bbhgoo'])[13]")
    private List<WebElement> driveMenu;

    public void bidding() {
        elementActions.scrollToElements(lotItems);
        elementActions.waitElementsToBeVisible(lotItems);
        Random random = new Random();
        for (WebElement betButton : placeBetButtons) {
            elementActions.scrollToElement(betButton);
            elementActions.waitElementToBeVisible(betButton);
        }
        WebElement randomBetButton = placeBetButtons.get(random.nextInt(placeBetButtons.size()));
        elementActions.clickJavaScript(randomBetButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementActions.waitButtonToBeClickable(bidButton);
        elementActions.clickButton(bidButton);
        Assert.assertNotNull(msgAfterBid);
    }

    public void blitzBidConfirmationAppearsWhenAvailable() {
        elementActions.scrollToElement(lotWithBlitzRate);
        elementActions.clickButton(lotWithBlitzRate);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 150);");
        elementActions.clickButton(buyNowButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationModal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[span[text()='Да']]")));
        Assert.assertTrue(confirmationModal.isDisplayed());
    }

    public void addToFavorites() {
        elementActions.scrollToElements(lotItems);
        elementActions.waitElementsToBeVisible(lotItems);
        Random random = new Random();
        WebElement randomLikeButton = likeBtn.get(random.nextInt(likeBtn.size()));
        elementActions.clickButton(randomLikeButton);
        String initialClass = randomLikeButton.getAttribute("class");
        String expectedClassAfterClick = "button css-19ryklm";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(randomLikeButton, "class", expectedClassAfterClick));
        System.out.println("Лот успешно добавлен в избранное.");

    }

    public void validateTabHasOnlyAutomobiles() {
        elementActions.clickButton(autoTab);
        elementActions.waitElementsToBeVisible(listOfAllLots);
        Random random = new Random();
        WebElement randomAutoLot = listOfAllLots.get(random.nextInt(listOfAllLots.size()));
        elementActions.clickButton(randomAutoLot);
        boolean isAuto = characteristicsTable.stream()
                .map(element -> element.findElement(By.xpath(".//li[@class='css-1t7964o']//div[text()='VIN номер:']")))
                .anyMatch(vinElement -> vinElement.getText().contains("VIN номер:"));
        Assert.assertTrue(isAuto);
    }

    public void validateTabHasOnlySpecTech() {
        elementActions.clickButton(specTechTab);
        elementActions.waitElementsToBeVisible(listOfAllLots);
        Random random = new Random();
        WebElement randomAutoLot = listOfAllLots.get(random.nextInt(listOfAllLots.size()));
        elementActions.clickButton(randomAutoLot);
        boolean isSpecTech = characteristicsTable.stream()
                .map(element -> element.findElement(By.xpath(".//li[div[text()='Заводской номер:']]")))
                .anyMatch(serNumElement -> serNumElement.getText().contains("Заводской номер:"));
        Assert.assertTrue(isSpecTech);
    }

    public void validateTabHasAllLots() {
        List<WebElement> autoLots = getLotsOnTab(autoTab);
        List<WebElement> specTechLots = getLotsOnTab(specTechTab);
        List<WebElement> allLots = getLotsOnTab(allTab);
        List<WebElement> combinedLots = new ArrayList<>();
        combinedLots.addAll(autoLots);
        combinedLots.addAll(specTechLots);
        for (WebElement lot : combinedLots) {
            Assert.assertTrue(allLots.contains(lot));
        }
    }

    private List<WebElement> getLotsOnTab(WebElement tab) {
        elementActions.clickButton(tab);
        elementActions.waitElementsToBeVisible(listOfAllLots);
        return new ArrayList<>(listOfAllLots);
    }

    public void filterByBrand() {
        elementActions.clickButton(brandPlaceholder);
        for (WebElement selectedBrand : brandMenu) {
            String selectedBrandText = selectedBrand.getText();
            selectedBrand.click();
            elementActions.clickButton(brandPlaceholder);
            elementActions.clickButton(showButton);
            String carBrand = lotItems.get(0).findElement(By.cssSelector(".typography.typography.default.default.css-1m5714k")).getText();
            Assert.assertTrue(carBrand.contains(selectedBrandText));
            break;
        }
    }

    public void filterByBrandAndModel() {
        elementActions.clickButton(brandPlaceholder);
        for (WebElement selectedBrand : brandMenu) {
            String selectedBrandText = selectedBrand.getText();
            selectedBrand.click();
            elementActions.clickButton(brandPlaceholder);
            elementActions.clickButton(modelPlaceholder);
            elementActions.waitElementsToBeVisible(modelMenu);
            for (WebElement selectedModel : modelMenu) {
                String selectedModelText = selectedModel.getText();
                selectedModel.click();
                elementActions.clickButton(showButton);
                String carBrand = lotItems.get(0)
                        .findElement(By.cssSelector(".typography.typography.default.default.css-1m5714k"))
                        .getText();
                Assert.assertTrue(carBrand.contains(selectedBrandText));
                break;
            }
        }
    }

    public void filterByYear() throws InterruptedException {
        elementActions.clickButton(inputOfYearFrom);
        inputOfYearFrom.sendKeys("1980");
        Thread.sleep(3000);
        elementActions.clickButton(inputOfYearTo);
        inputOfYearTo.sendKeys("2024");
        elementActions.clickButton(showButton);
        elementActions.waitElementsToBeVisible(lotItems);
        for (WebElement lot : lotItems) {
            String carInfo = lot.findElement(By.cssSelector(".typography.typography.default.default.css-1m5714k")).getText();
            System.out.println("Информация о лоте: " + carInfo);
            String[] infoParts = carInfo.split(",");
            String yearText = infoParts[infoParts.length - 1].trim();
            int carYear = Integer.parseInt(yearText);
            Assert.assertTrue(carYear >= 1980 && carYear <= 2024,
                    "Год выпуска не попадает в диапазон 1980-2024");
        }
    }

    public void filterByMaleAge() {
        elementActions.clickButton(advancedFilterToggle);
        int mileageFrom = new Random().nextInt(1000000);
        elementActions.clickButton(inputOfMileAgeFrom);
        inputOfMileAgeFrom.sendKeys(String.valueOf(mileageFrom));
        int mileageTo = new Random().nextInt(1000000 - mileageFrom) + mileageFrom;
        elementActions.clickButton(inputOfMileAgeTo);
        inputOfMileAgeTo.sendKeys(String.valueOf(mileageTo));
        showButton.click();
        verifyAllLotsMileage(mileageFrom, mileageTo);
    }

    public void verifyAllLotsMileage(int mileageFrom, int mileageTo) {
        boolean isAnyLotMatching = false;
        if (listOfAllLots.isEmpty()) {
            System.out.println("Лоты не найдены. Пробег: от " + mileageFrom + " до " + mileageTo + ".");
            return;
        }
        for (WebElement lotCard : listOfAllLots) {
            WebElement mileageElement = lotCard.findElement(By.xpath(".//div[contains(text(), 'км')]"));
            String mileageText = mileageElement.getText().replaceAll("[^0-9]", "");
            int mileage = Integer.parseInt(mileageText);
            if (mileage >= mileageFrom && mileage <= mileageTo) {
                isAnyLotMatching = true;
            } else {
                System.out.println("Лот с пробегом " + mileage + " не соответствует фильтру, должен быть от " + mileageFrom + " до " + mileageTo + ".");
            }
        }
        if (!isAnyLotMatching) {
            System.out.println("Лоты с пробегом от " + mileageFrom + " до " + mileageTo + " не найдены.");
        }
    }

    public void filterByVolume() {
        Random random = new Random();
        double volumeFrom = 0.1 + (999 - 0.1) * random.nextDouble();
        double volumeTo = volumeFrom + (999 - volumeFrom) * random.nextDouble();
        elementActions.clickButton(advancedFilterToggle);
        elementActions.sendKeys(volumeFromInput, String.format("%.2f", volumeFrom));
        elementActions.sendKeys(volumeToInput, String.format("%.2f", volumeTo));
        elementActions.clickButton(showButton);
        elementActions.waitElementsToBeVisible(listOfAllLots);
        for (WebElement lotCard : listOfAllLots) {
            WebElement volumeElement = lotCard.findElement(By.xpath(".//div[contains(text(), 'л')]"));
            String volumeText = volumeElement.getText().replaceAll("[^0-9.]", "");
            double lotVolume = Double.parseDouble(volumeText);
            Assert.assertTrue(lotVolume >= volumeFrom && lotVolume <= volumeTo,
                    "Лот с объемом " + lotVolume + " не соответствует диапазону: " + volumeFrom + " - " + volumeTo);
        }
        if (listOfAllLots.isEmpty()) {
            System.out.println("Лоты с таким объемом не найдены.");
        }
    }

    public void enginePowerFilter() {
        elementActions.clickButton(advancedFilterToggle);
        Random random = new Random();
        int powerFrom = random.nextInt(100000);
        int powerTo = powerFrom + random.nextInt(100);
        powerFromInput.click();
        powerFromInput.sendKeys(String.valueOf(powerFrom));
        powerToInput.click();
        powerToInput.sendKeys(String.valueOf(powerTo));
        showButton.click();
        if (listOfAllLots.isEmpty()) {
            System.out.println("Лоты с такой мощностью не найдены.");
        } else {
            for (WebElement lot : listOfAllLots) {
                String enginePowerText = lot.findElement(By.xpath(".//div[contains(text(), 'л.с')]")).getText();
                int enginePower = Integer.parseInt(enginePowerText.replaceAll("\\D+", ""));
                Assert.assertTrue(enginePower >= powerFrom && enginePower <= powerTo,
                        "Мощность двигателя " + enginePower + " вне диапазона: " + powerFrom + " - " + powerTo);
            }
        }
    }

    public void engineTypeFilter() {
        elementActions.clickButton(advancedFilterToggle);
        elementActions.clickButton(engineTypeInput);
        for (WebElement selectedEngineType : engineTypeMenu) {
            String selectedEngineTypeText = selectedEngineType.getText();
            selectedEngineType.click();
            elementActions.clickButton(engineTypeInput);
            elementActions.clickButton(showButton);
            String carBrand = lotItems.get(0).findElement(By.xpath("(//div[@class='typography default css-bdji1y'])[4]")).getText();
            Assert.assertTrue(carBrand.contains(selectedEngineTypeText));
            break;
        }
    }

    public void gearboxFilter() {
        elementActions.clickButton(advancedFilterToggle);
        elementActions.clickButton(gearboxInput);
        for (WebElement selectedGearbox : gearboxMenu) {
            String selectedGearboxText = selectedGearbox.getText().trim();
            selectedGearbox.click();
            elementActions.clickButton(gearboxInput);
            elementActions.clickButton(showButton);
            boolean allLotsContainCorrectGearbox = true;
            for (WebElement lotDetail : lotItems) {
                String carDetails = lotDetail.getText().trim();
                System.out.println("Проверяемая карточка автомобиля: " + carDetails);
                if (selectedGearboxText.equals("Механическая")) {
                    if (!carDetails.contains("Механическая")) {
                        allLotsContainCorrectGearbox = false;
                        System.out.println("Ошибка: Ожидалось, что автомобиль содержит коробку передач 'Механическая', но найдено: " + carDetails);
                    }
                } else if (selectedGearboxText.equals("Вариатор")) {
                    if (!carDetails.contains("Вариатор")) {
                        allLotsContainCorrectGearbox = false;
                        System.out.println("Ошибка: Ожидалось, что автомобиль содержит коробку передач 'Вариатор', но найдено: " + carDetails);
                    }
                }
            }
            Assert.assertTrue(allLotsContainCorrectGearbox,
                    "Один или несколько лотов не содержат выбранную коробку передач '" + selectedGearboxText + "'.");
            break;
        }
    }

}












