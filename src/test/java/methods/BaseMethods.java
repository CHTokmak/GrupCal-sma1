package methods;

import drivers.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class BaseMethods {
    private static final Logger logger = LogManager.getLogger(Driver.class);

    public String monthStr;

    public String dayStr;

    public String monthOfYearStr;

    public String dayOfMonthStr;


    WebDriver driver;
    FluentWait<WebDriver> fluentWait;
    JavascriptExecutor jsDriver;

    public BaseMethods(){
        this.driver = Driver.driver;
        jsDriver = (JavascriptExecutor) driver;
        fluentWait = setFluentWait(10);
    }

    public FluentWait<WebDriver> setFluentWait(long timeout){

        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElement(By by){

        return driver.findElement(by);
    }

    public WebElement findElementWait(By by){

        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickElement(By by){

        findElementWait(by).click();
        logger.info(by.toString() + " elementine tıklandı");
    }

    public void sendKeys(By by, String text){

        findElementWait(by).sendKeys(text);
        logger.info(by.toString() + " elementine " + text + " texti yazıldı");
    }

    public String getText(By by){

        return findElementWait(by).getText();
    }

    public String getAttribute(By by, String attribute){

        return findElementWait(by).getAttribute(attribute);
    }

    public void hoverElement(By by){

        WebElement webElement = findElementWait(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        logger.info(by.toString() + " elementine hover işlemi yapıldı");
    }

    public String getValue(By by){

        WebElement webElement = findElementWait(by);
        return jsDriver.executeScript("return arguments[0].value;", webElement).toString();
    }

    public void clickElementJs(By by){
        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].click();", webElement);
        logger.info(by.toString() + " elemente js tıklandı");
    }

    public  void clear(By by){

        findElementWait(by).clear();
        logger.info(by.toString() + " elementin texti temizlendi");
    }

    public Select getSelect(By by){

        return new Select(findElementWait(by));
    }

    public void selectByValue(By by, String value){

        getSelect(by).selectByValue(value);
    }

    public void scrollElementCenter(By by){

        WebElement webElement = findElementWait(by);
        jsDriver.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                webElement);
        logger.info(by.toString() + " scroll 1 yapıldı");
    }

    public void scrollElement(By by){

        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].scrollIntoView();", webElement);
        logger.info(by.toString() + " scroll 2 yapıldı");
    }

    public void scrollElementIfNeeded(By by){

        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].scrollIntoViewIfNeeded();", webElement);
        logger.info(by.toString() + " scroll 3 yapıldı");
    }

    public boolean isElementVisible(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info(by.toString() + " true");
            return true;
        }catch (Exception e){
            logger.info(by.toString() + " false");
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean isElementClickable(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.elementToBeClickable(by));
            logger.info(by.toString() + " true");
            return true;
        }catch (Exception e){
            logger.info(by.toString() + " false");
            logger.error(e.getMessage());
            return false;
        }
    }

    public void waitBySeconds(long seconds){

        waitByMiliSeconds(1000*seconds);
        logger.info(seconds + " saniye beklendi");
    }

    public void rightClick(By by){

        Actions actions = new Actions(driver);
        WebElement webElement = findElementWait(by);
        actions.contextClick(webElement).perform();
        logger.info(by.toString() + " right clicked");
    }

    public void waitByMiliSeconds(long miliSeconds){

        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (miliSeconds % 1000 != 0)
            logger.info(miliSeconds + " milisaniye beklendi");
    }
     public void scrollDownBottom(){
        jsDriver.executeScript("window.scrollBy(0,document.body.scrollHeight)");
     }
     //scroll untill bottom of the page,
    public void scrollByElementJs(By by){
        WebElement element = findElement(by);
        jsDriver.executeScript("arguments[0].scrollIntoView();", element);

    }
    public void scrollUpTop(){
        jsDriver.executeScript("window.scrollBy(document.body.scrollHeight,0)");
    }

    public void scrollByPixel(Integer x , Integer y){
        jsDriver.executeScript("window.scrollBy(arguments[0],arguments[1]);", x , y);
    }
    public void sendKeysJs(By by, String text){
        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].value=arguments[1];", webElement,text);

    }
    public void windowRefresh(){
        jsDriver.executeScript("location.reload()");
    }

    public void previousPage(){
        jsDriver.executeScript("window.history.go(-1)");
    }

    public void clickByRandom(String xpath){
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        Random rand = new Random();
        int index = rand.nextInt(elements.size()-1);
        elements.get(index).click();
    }
    public void dateSelectionWithRealTime (){
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int monthOfYear = cal.get(Calendar.MONTH);
        monthOfYearStr = String.valueOf(monthOfYear);
        dayOfMonthStr = String.valueOf(dayOfMonth);
        clickElementJs(By.xpath("//td[@data-month=\""+monthOfYearStr+"\"]//a[text()=\""+dayOfMonthStr+"\"]"));
    }
    public void dateSelectionDesiredTime(Integer d,Integer m){
        dayStr = String.valueOf(d);
        monthStr = String.valueOf(m-1);
        for(int i = 0 ; i<12 ;i++){
            if(isElementVisible(By.xpath("//td[@data-month=\""+monthStr+"\"]//a[text()=\""+dayStr+"\"]"),1) == false){
                clickElementJs(By.xpath("(//a[@class=\"ui-datepicker-next ui-corner-all\"])[2]"));
            }
            else {clickElementJs(By.xpath("//td[@data-month=\""+monthStr+"\"]//a[text()=\""+dayStr+"\"]"));
                break;
            }
        }
    }





}
