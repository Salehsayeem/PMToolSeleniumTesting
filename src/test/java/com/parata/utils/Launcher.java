package com.parata.utils;

import com.parata.base.AutomationBase;
import com.parata.constants.GLOBAL;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author MFU
 * 1/11/2021
 */
public class Launcher extends AutomationBase
{
    private WebDriver webDriver;

    public Launcher(WebDriver webDriver)
    {
      
        this.webDriver = webDriver;
       
    }

    public void navigateToParataApplication()
    {
        webDriver.manage().deleteAllCookies();

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()){
            case "STAGING":
            case "STAG":
            case "STG":
                webDriver.get(ConfigReader.getProperty("urlStg"));
                break;
            case "PRODUCTION":
            case "PROD":
                webDriver.get(ConfigReader.getProperty("urlProd"));
                break;
            default:
                webDriver.get(ConfigReader.getProperty("urlDev"));
        }

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }
    public void navigateToGoogle ()
    {
        webDriver.manage().deleteAllCookies();
        webDriver.get(ConfigReader.getProperty("urlgoogle"));
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }
}
