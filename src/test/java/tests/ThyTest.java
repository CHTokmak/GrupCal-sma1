package tests;

import drivers.Driver;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.CampaignPage;
import pages.HomePage;

public class ThyTest extends Driver {
    @Test
    public void generalTest(){

        HomePage homePage = new HomePage(driver);
        CampaignPage campaignPage = new CampaignPage(driver);
        BasePage basePage = new BasePage(driver);
        homePage.goToFlightTab();








    }
}
