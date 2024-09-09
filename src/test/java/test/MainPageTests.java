package test;
import core.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class BiddingTest extends BaseTest {
    @Test(description = "Обычная ставка")
    public void biddingTest() throws InterruptedException {
        sidebar.openAuctionPage();
        auctionPage.bidding();
        auctionPage.isBidInHistoryOfTrading();
    }

    @Test(description = "Добавить в избранное")
    public void addToFavoritesTest() {
        sidebar.openAuctionPage();
        auctionPage.addToFavorites();
        auctionPage.isItemColored();

    }
    @Test
    public void inspectAutoSelectionLinks() throws IOException {
        mainPage.inspectAutoSelectionLinks();
    }
    @Test
    public void checkViewAllLotsBtn(){
        mainPage.checkViewAllButton();
    }
    @Test
    public void inspectFooterSocialLinks() throws IOException, InterruptedException {
        mainPage.inspectFooterSocialLinks();
    }
}