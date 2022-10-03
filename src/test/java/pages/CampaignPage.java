package pages;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampaignPage extends BasePage {
    public CampaignPage(WebDriver driver) {
        super();
    }

    public void campaignSets(){
        waitByMiliSeconds(250);
        scrollByPixel(0,250);
        waitBySeconds(500);
        //text = getText(By.xpath("(//h2[@class=\"text-24 text-light m-t-20\"])[1]"));
        //System.out.println(text);
        waitByMiliSeconds(500);
        clickElement(By.xpath("(//span[@class=\"v-a-mid inline-block text-bold m-r-5\" and text()=\"DETAY\"])[1]//ancestor::a"));
        waitBySeconds(250);
    }
}
