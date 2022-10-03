package pages;

import methods.BaseMethods;
import org.openqa.selenium.By;

import javax.xml.soap.Text;

public class CampaignInsightPage extends BasePage {
    public void insightControl(){
        text = getText(By.xpath("//h1[@class=\"campaign-detail-content__title\"]"));
        System.out.println(text);
    }
}
