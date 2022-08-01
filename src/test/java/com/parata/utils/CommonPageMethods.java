package com.parata.utils;



import com.parata.base.AutomationBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.parata.utils.SmartWait.waitFor;


/**
 * @author Muhemmet UYAR
 * 4/12/2021
 */
public class CommonPageMethods extends AutomationBase{
    SmartWait smartWait = new SmartWait();



    //This method allows you to click with wait for the element available.
    public void click (WebElement webElement)
    {
        SmartWait.awaitUntilPageIsLoaded(openDriver(),10);
        waitFor (webElement, 7);
        webElement.click();
        System.out.println(webElement+" clicked");
        smartWait.waitUntilPageIsLoaded(5);
    }

    public void submit (WebElement webElement)
    {
        webElement.submit();
        System.out.println(webElement+" submitted");
    }



}
