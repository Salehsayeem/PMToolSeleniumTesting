package com.parata.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Muhemmet UYAR
 * 8/22/2021
 */
public interface DriverSetup {

    WebDriver getWebDriverObject (DesiredCapabilities desiredCapabilities);
}
