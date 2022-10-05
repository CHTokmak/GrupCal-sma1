package pages;

import methods.BaseMethods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class HomePage extends BaseMethods {
    public HomePage(WebDriver driver){}
    public void goToFlightTab(){
        clickElement(By.id("nxm2CookieSubmitButton"));
        waitByMiliSeconds(250);
        //clickElement(By.xpath("//a[text()=\"KAMPANYALAR\"]"));
        //waitByMiliSeconds(250);
        scrollByPixel(0,250);
        clickElement(By.xpath("(//div[contains(text(),\"Nereden\")])[2]"));
        waitByMiliSeconds(500);
        sendKeysJs(By.xpath("//input[@class=\"nxm-360-search-select-airpot-list-input nxm-360-search-input\"][1]"),"Istanbul");
        waitByMiliSeconds(500);
        clickByRandom("//div[@class=\"nxm-360-search-select-airpot-list-content\"]//div//ul//li/..//div//div[contains(text(),\"Istanbul\")]");
        waitByMiliSeconds(250);
        clickElement(By.xpath("(//div[contains(text(),\"Nereye\")])[2]"));
        waitByMiliSeconds(250);
        clickByRandom("(//div[@class=\"nxm-360-search-select-airpot-list-content\"])[2]//ul[@class=\"nxm-360-search-select-airpot-list-ul airports\"]//li");
        waitByMiliSeconds(250);
        clickElementJs(By.xpath("(//span[@class=\"arrow\"])[1]"));
        waitByMiliSeconds(250);
        dateSelectionWithRealTime();
        waitByMiliSeconds(500);
        dateSelectionDesiredTime(22,2);
        waitByMiliSeconds(500);
        clickElement(By.xpath("(//span[@class=\"arrow\"])[2]"));
        waitByMiliSeconds(500);
        clickElement(By.xpath("(//span[text()=\"1 Yetişkin\"])[1]"));
        waitByMiliSeconds(250);
        clickElement(By.xpath("(//i[@class=\"nxm2-icon nxm2-plus\"])[1]"));
        Assertions.assertTrue(isElementVisible(By.xpath("(//span[text() = \"2 Yetişkin\"])[2]"),10));
        waitByMiliSeconds(100);
        clickElement(By.xpath("(//a[text() = \"TAMAM\"])[1]"));
        waitByMiliSeconds(250);
        clickElement(By.xpath("//button[text() = \"Ucuz Uçuş Ara\"]"));
    }



}
