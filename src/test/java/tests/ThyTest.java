package tests;

import drivers.Driver;
import org.junit.jupiter.api.Test;
import pages.CampaignPage;
import pages.FlightPage;
import pages.HomePage;

public class ThyTest extends Driver {
    @Test
    public void generalTest(){

        HomePage homePage = new HomePage(driver);
        CampaignPage campaignPage = new CampaignPage(driver);
        FlightPage flightPage = new FlightPage(driver);
        homePage.goToFlightTab();
        flightPage.isDateCorrect();






    }
}
