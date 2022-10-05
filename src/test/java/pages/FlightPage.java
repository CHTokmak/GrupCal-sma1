package pages;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import methods.BaseMethods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightPage extends BaseMethods {

    public FlightPage(WebDriver driver) {}


    public void isDateCorrect(){
        String depDate = getText(By.xpath("(//span[@class=\"value\"])[1]"));
        String arivDate = getText(By.xpath("(//span[@class=\"value\"])[2]"));
        String[] depDateSep = depDate.split("\\s");
        // ? Assertions.assertEquals(depDateSep[0],dayOfMonthStr,"Uçuş günleri eşleşmekte");
        System.out.println(depDate);
        System.out.println(arivDate);
        waitByMiliSeconds(500);
        previousPage();
        waitBySeconds(5);
    }
}
