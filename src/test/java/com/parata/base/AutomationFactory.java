package com.parata.base;

import com.parata.constants.GLOBAL;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.parata.base.DriverOptions.chrome;
import static com.parata.base.DriverOptions.valueOf;

/**
 * @author Muhemmet UYAR
 * 8/30/2021
 */
public class AutomationFactory {

    private WebDriver webDriver;
    private DriverOptions selectedDriverOption;
    private final        String        operatingSystem       = System.getProperty ("os.name").toUpperCase ();
    private final        String        systemArchitecture    = System.getProperty ("os.arch").toUpperCase ();
    private final        boolean       useRemoteWebDriver    = Boolean.getBoolean ("remoteDriver");
    private final        boolean       headlessMode          = Boolean.getBoolean ("headless");

    public AutomationFactory() {

        DriverOptions driverOption = chrome;
        String browser = System.getProperty("browserType", driverOption.toString());
        try
        {
            driverOption = valueOf(browser);
        }
        catch (IllegalArgumentException ignored)
        {
            System.err.println("Unknown driver specified, defaulting to '" + driverOption + "'....");
        }
        catch (NullPointerException ignored)
        {
            System.err.println("No driver specified, defaulting to '" + driverOption + "'....");
        }
        selectedDriverOption = driverOption;

    }

    public WebDriver getDriver () {
        if (null == webDriver) {
            instantiateWebDriver(selectedDriverOption);
        }

        return webDriver;
    }

    public void quitDriver () {
        if (null != webDriver) {
            webDriver.quit();
            webDriver = null;
        }
    }

    private void instantiateWebDriver (DriverOptions driverOption) {
        System.out.println (" ");
        System.out.println ("Current Operating System: " + operatingSystem);
        System.out.println ("Current Architecture: " + systemArchitecture);
        System.out.println ("Current Application Environment: " + GLOBAL.APPLICATION_ENVIRONMENT);
        System.out.println ("Browser Selected: " + selectedDriverOption);
        System.out.println ("Headless Mode: " + headlessMode);
        System.out.println ("Connected to Selenium Grid: " + useRemoteWebDriver);
        System.out.println (" ");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        if (useRemoteWebDriver)
        {
            String host = System.getProperty("gridHost");

            desiredCapabilities.setBrowserName(driverOption.toString());
            if (driverOption.equals("ie")){
                webDriver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL, "0");
            }
            try {
                webDriver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            webDriver = driverOption.getWebDriverObject(desiredCapabilities);
        }

        Dimension dimension = new Dimension(1920, 1080);
        webDriver.manage().window().setSize(dimension);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        System.out.println("Cookies deleted");

        System.out.println("Dimensions of viewport is  "+ webDriver.manage().window().getSize());
        System.out.println("Leaving getWebDriver and driver is currently null? " + webDriver);

    }
}
