package pages;

import methods.BaseMethods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseMethods {
    public HomePage(WebDriver driver){}

    /*public void gidisdonus () {
        waitByMiliSeconds(250);
        scrollByPixel(0,250);
        waitByMiliSeconds(250);
        clickElementJs(By.xpath("(//div[@class=\"nxm-360-search-selected-title nxm-360-departure-name\"])[1]"));
        waitByMiliSeconds(500);
        sendKeysJs(By.xpath("(//input[@class=\"nxm-360-search-select-airpot-list-input nxm-360-search-input\"])[1]"),"Istanbul");
        waitBySeconds(2);
        windowRefresh();
        waitBySeconds(2);
        scrollDownBottom();
        waitBySeconds(2);
        scrollUpTop();
        waitBySeconds(3);
        scrollByElementJs(By.xpath("//a[@href=\"#panel1\"]"));
        waitBySeconds(3);
        clickElement(By.xpath("//a[@href=\"/kampanyali-ucak-biletleri\"]"));
        waitBySeconds(2);
        previousPage();
        waitBySeconds(2);

        //Js komutlarının kullanımı için örnektir

    }*/

    //public final

    public void goToCampaignPage(){
        clickElement(By.id("nxm2CookieSubmitButton"));
        waitByMiliSeconds(250);
        clickElement(By.xpath("//a[text()=\"KAMPANYALAR\"]"));
        waitByMiliSeconds(250);

    }



}
