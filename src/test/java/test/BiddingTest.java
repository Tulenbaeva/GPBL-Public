package test;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BiddingTest extends BaseTest {
    @Test(description = "Обычная ставка")
    public void biddingTest() throws InterruptedException {
        sidebar.openAuctionPage();
        auctionPage.bidding();
        Assert.assertTrue(auctionPage.isBidInHistoryOfTrading(), "Ставка не отображается в разделе 'Ход торгов'.");
    }
    @Test(description = "Добавить в избранное")
        public void addToFavoritesTest(){
        sidebar.openAuctionPage();
        auctionPage.addToFavorites();
        Assert.assertTrue(auctionPage.isItemColored());

    }
}