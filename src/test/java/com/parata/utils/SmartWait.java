package com.parata.utils;

import com.parata.base.AutomationBase;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Muhemmet UYAR
 * 6/9/2021
 */
public class SmartWait extends AutomationBase {



    //This method allows to wait until the specific page load
    public  void waitUntilPageIsLoaded (int timer)
    {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {
            public Boolean apply (WebDriver driver)
            {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
           actionDelay (2000);
            new WebDriverWait(openDriver(), timer).until(expectation);

        } catch (Throwable error)
        {
            Assert.fail("Timeout waiting for the page load request to complete");
        }

    }

    public static void awaitUntilPageIsLoaded (WebDriver driver, int timer)
    {
        await().
                atMost(timer, TimeUnit.SECONDS).
                pollDelay(5, TimeUnit.SECONDS).
                pollInterval(1, TimeUnit.SECONDS).
                ignoreExceptions().
                untilAsserted (() -> assertThat (((JavascriptExecutor) driver).executeScript ("return document.readyState").toString ()).
                        as ("Wait for the Web Page to be rendered and loaded completely.").
                        isEqualTo ("complete"));

    }

    //This method allows until wait the WebElement available for synchronize pages.
    public static void waitFor (WebElement webElement, int timer)
    {
        WebDriver driver = openDriver();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timer))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoreAll(Arrays.asList
                        (
                                NoSuchElementException.class,
                                StaleElementReferenceException.class
                        )).withMessage("TimeoutException is thrown");

    }

    public  Function<WebDriver, Boolean> elementLoaded (WebElement webElement)
    {
        return driver ->
        {
            return webElement != null && webElement.isDisplayed();
        };
    }
    //This method allows until wait the WebElement available for asynchronous pages.
    public static void awaitFor (WebElement webElement, int timer)
    {
        await().
                atMost(timer, TimeUnit.SECONDS).
                pollDelay(1, TimeUnit.SECONDS).
                pollInterval(1, TimeUnit.SECONDS).
                ignoreExceptions().
                untilAsserted(() ->
                        assertThat ("Wait for the WebElement to be displayed.", webElement.isDisplayed (), equalTo(true)));

    }

    public void actionDelay (int timer)
    {
        try {
            Thread.sleep(timer);
        }
        catch (Exception ign) {}
    }


    /*
        Genericized version of waitFor that accepts an arbitrary condition
    */
    public  <T> void waitForCondition(ExpectedCondition<T> condition, int timer)
    {
        try {
            //actionDelay (5000);
            new WebDriverWait(openDriver(), timer)
                    .until(condition);
        } catch (Throwable error)
        {
            Assert.fail("Timeout waiting for the condition to be met:" + error.getMessage());
        }
    }


}
