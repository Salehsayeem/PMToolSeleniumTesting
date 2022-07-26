package com.parata.utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



/**
 * @author Muhemmet UYAR
 * 4/12/2021
 */
public class CommonPageMethods {




    //This method allows you to click with wait for the element available.
    public void click (WebElement webElement)
    {
        webElement.click();
        System.out.println(webElement+" clicked");
    }

    public void submit (WebElement webElement)
    {
        webElement.submit();
        System.out.println(webElement+" submitted");
    }



}
