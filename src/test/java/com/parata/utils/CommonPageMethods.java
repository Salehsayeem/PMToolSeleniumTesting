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


    public void scrollDown ()
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) openDriver ();
        javascriptExecutor.executeScript ("window.scrollBy(0,750)");

    }

    public void scrollDown (WebElement webElement)
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) openDriver ();
        javascriptExecutor.executeScript ("window.scrollBy(0,250)", webElement);

    }

    public void scrollDown (int intPixels, WebElement webElement)
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) openDriver ();
        javascriptExecutor.executeScript ("window.scrollBy(0," + intPixels + ")", webElement);

    }

    public void scrollToBottom ()
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) openDriver ();
        javascriptExecutor.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

    }
    public void scrollToBottom (WebElement webElement)
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) openDriver ();
        javascriptExecutor.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void scrollToUp ()
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) openDriver ();
        javascriptExecutor.executeScript ("window.scrollTo(document.body.scrollHeight, 0)");

    }

    public void scrollIntoView (WebElement element)
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) openDriver ();
        javascriptExecutor.executeScript ("arguments[0].scrollIntoView(true);", element);

    }

    public void scrollUp ()
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) openDriver ();
        javascriptExecutor.executeScript ("window.scrollBy(0,-250)");
    }

    public void scrollUp (int intPixels)
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) openDriver ();
        javascriptExecutor.executeScript ("window.scrollBy(0,-" + intPixels + ")");
    }



}
