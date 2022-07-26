package com.parata.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

/**
 * @author Muhemmet UYAR
 * 8/22/2021
 */
public enum DriverOptions implements DriverSetup {

    chrome
            {
                public WebDriver getWebDriverObject (DesiredCapabilities desiredCapabilities) {

                    WebDriverManager.chromedriver().setup();
                    HashMap<String, Object> chromePreferences = new HashMap<>();
                    chromePreferences.put("profile.password_manager_enabled", false);
                    ChromeOptions options = new ChromeOptions();
                  //  options.addArguments("--incognito");
                    options.addArguments("--start-maximized");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-device-emulation");
                    options.setHeadless(HEADLESS);
                    options.setPageLoadStrategy(PageLoadStrategy.NONE);
                    options.merge(desiredCapabilities);

                    return new ChromeDriver(options);
                }
            },

    firefox
            {
                public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities)
                {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    desiredCapabilities.setPlatform(Platform.ANY);
                   // options.setBinary("C://agent//_work//r5//a//New_folder1//taco-frontend-tacoui//geckodriver.exe");
                    options.setPageLoadStrategy(PageLoadStrategy.NONE);
                    options.setHeadless(HEADLESS);
                    options.merge(desiredCapabilities);

                    return new FirefoxDriver(options);
                }

            },
    edge
            {
                public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities)
                {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    desiredCapabilities.setPlatform(Platform.ANY);
                    // options.setBinary("C://agent//_work//r5//a//New_folder1//taco-frontend-tacoui//geckodriver.exe");
                    options.setPageLoadStrategy(String.valueOf(PageLoadStrategy.NONE));
                    options.setCapability("useAutomationExtension", false);
                    options.merge(desiredCapabilities);

                    return new EdgeDriver(options);
                }

            },
    ie
            {
                public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities)
                {
                    WebDriverManager.iedriver().setup();
                    InternetExplorerOptions options = new InternetExplorerOptions();
                    desiredCapabilities.setPlatform(Platform.ANY);
                    desiredCapabilities.setCapability("EnableNativeEvents", false);
                    //desiredCapabilities.setCapability("ignoreZoomSetting", true);
                    // options.setBinary("C://agent//_work//r5//a//New_folder1//taco-frontend-tacoui//geckodriver.exe");
                    options.setPageLoadStrategy(PageLoadStrategy.NONE);
                    options.setCapability("useAutomationExtension", false);
                    options.merge(desiredCapabilities);

                    return new InternetExplorerDriver(options);
                }

            };

    public final static boolean HEADLESS = Boolean.getBoolean("headless");
}
