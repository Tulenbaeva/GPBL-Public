package test;
import core.BaseTest;
import org.testng.annotations.Test;

public class AuctionPageTests extends BaseTest {
    @Test(description = "Обычная ставка", groups = {"authRequired"})
    public void biddingTest() {
        sidebar.openAuctionPage();
        auctionPage.bidding();
    }
    @Test(description = "Блиц-ставка", groups = {"authRequired"})
    public void blitzBiddingTest() {
        sidebar.openAuctionPage();
        auctionPage.blitzBidConfirmationAppearsWhenAvailable();
    }
    @Test(description = "Добавить в избранное", groups = {"authRequired"})
    public void addToFavoritesTest() {
        sidebar.openAuctionPage();
        auctionPage.addToFavorites();
    }
    @Test(description = "Фильтрация по типу лота 'Автомобили'", groups = {"authRequired"})
    public void validateTabHasOnlyAuto() {
        sidebar.openAuctionPage();
        auctionPage.validateTabHasOnlyAutomobiles();
    }
    @Test(description = "Фильтрация по типу лота 'Спецтехника'", groups = {"authRequired"})
    public void validateTabHasOnlySpecTech() {
        sidebar.openAuctionPage();
        auctionPage.validateTabHasOnlySpecTech();
    }
    @Test(groups = {"authRequired"})
    public void validateTabHasAllLots() {
        sidebar.openAuctionPage();
        auctionPage.validateTabHasAllLots();
    }
    @Test(description = "Фильтрация по марке", groups = {"authRequired"})
    public void filterByBrand(){
        sidebar.openAuctionPage();
        auctionPage.filterByBrand();
    }
    @Test(description = "Фильтрация по марке и модели", groups = {"authRequired"})
    public void filterByBrandAndModel(){
        sidebar.openAuctionPage();
        auctionPage.filterByBrandAndModel();
    }
    @Test(description = "Фильтрация по году", groups = {"authRequired"})
    public void filterByYear() throws InterruptedException {
        sidebar.openAuctionPage();
        auctionPage.filterByYear();
    }
    @Test(description = "Фильтрация по пробегу", groups = {"authRequired"})
    public void filterByMileAge() {
        sidebar.openAuctionPage();
        auctionPage.filterByMaleAge();
    }
    @Test(description = "Фильтрация по объему двигателя", groups = {"authRequired"})
    public void filterByVolume() {
        sidebar.openAuctionPage();
        auctionPage.filterByVolume();
    }
    @Test(description = "Фильтрация по мощности двигателя", groups = {"authRequired"})
    public void filterByEnginePower() {
        sidebar.openAuctionPage();
        auctionPage.enginePowerFilter();
    }
    @Test(description = "Фильтрация по коробке передач", groups = {"authRequired"})
    public void filterByGearbox() {
        sidebar.openAuctionPage();
        auctionPage.gearboxFilter();
    }

}



