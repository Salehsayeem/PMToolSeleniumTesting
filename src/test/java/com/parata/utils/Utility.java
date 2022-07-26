package com.parata.utils;

import com.parata.base.AutomationBase;
import com.parata.constants.CONSTANTS;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

/**
 * @author MFU
 * 1/13/2021
 */
public class Utility extends AutomationBase {
    WebDriver webDriver;
    SmartWait smartWait = new SmartWait();
   Actions actions = new Actions(openDriver());

    public Utility(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public static void captureScreenshot(WebDriver webDriver, String screenshotName) {

        try {
            TakesScreenshot ts = (TakesScreenshot) webDriver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./screenshots/" + screenshotName + ".png"));
            System.out.println("Screenshot Taken");
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }
    }

    //Gives a boolean value if web element exists or not in specific page.
    public static boolean elementExists(WebElement el) {
        try {
            if (el != null) {
                if (el.isDisplayed() || el.isEnabled()) {
                    return true;
                }
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }


    public void click_any_element1(String CSS) throws InterruptedException {
        Thread.sleep(3000);
        WebElement webElement = webDriver.findElement(By.cssSelector(CSS));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", webElement);
    }

    public void click_any_elementActions(String Id) throws InterruptedException {
        Thread.sleep(3000);
        WebElement webElement = webDriver.findElement(By.id(Id));
        actions.moveToElement(webElement).click().perform();
         }
    public void click_any_elementwithId(String Id, String type) throws InterruptedException {
        Thread.sleep(3000);
        WebElement webElement = webDriver.findElement(By.id(Id));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", webElement);
        smartWait.waitUntilPageIsLoaded(10);
    }

    public void click_any_element2(String strCSS) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        String script = "return document.querySelector(" + "'" + strCSS + "'" + ").click;";
        javascriptExecutor.executeScript(script).toString();
    }


    public static int dropdownCount(WebDriver webDriver, String CSS) {
        List<WebElement> dropdownmenuelements = webDriver.findElements(By.cssSelector(CSS));
        int count = dropdownmenuelements.size();
        for (WebElement dropdownmenuelement : dropdownmenuelements) {
            System.out.println(dropdownmenuelement.getText());

        }
        System.out.println(count);
        return count;
    }

    public static String getCurrentUrl(WebDriver webDriver) {
        String url = webDriver.getCurrentUrl();
        System.out.println(url);
        return url;
    }
    public static int sumHourly(int[] input) {

        int sum=0;
        //sum=sum+sumhourly(hourly);
        for (int i = 0; i < input.length; i++) {
            sum=sum+input[i];
        }
        System.out.println(sum);
        return sum;
    }

    public static void milliseconstohours(int mill) {
        int s = mill / 1000;
        int second = s % 60;
        int h = s / 60;
        int minute = h % 60;
        int hour = h / 60;
        System.out.println("HH:MM:SS");
        String time =String.format("%s :%s :%s ",hour,minute,second);
        System.out.println(time);
    }

    public static void main(String[] args) {

    //sumHourly(CONSTANTS.hourlyUtilizationTime);
    //sumHourly(CONSTANTS.overallIdleTime);
    milliseconstohours(sumHourly(CONSTANTS.hourlyUtilizationTime));
        System.out.println(sumHourly(CONSTANTS.hourlyUtilizationTime));
            //+sumHourly(CONSTANTS.overallIdleTime)+sumHourly(CONSTANTS.hourlyUtilizationTime2)+sumHourly(CONSTANTS.overallIdleTime2));
    milliseconstohours(3600000);

    }


}
