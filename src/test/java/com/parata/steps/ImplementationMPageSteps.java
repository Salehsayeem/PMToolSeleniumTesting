package com.parata.steps;

import com.parata.base.AutomationBase;
import com.parata.pages.ImplementationMPage;
import com.parata.utils.SmartWait;
import com.parata.utils.Utility;
import com.parata.utils.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;


/**
 * @author MFU
 * 1/4/2021
 */
public class ImplementationMPageSteps extends AutomationBase {
    ImplementationMPage implementationMPage = new ImplementationMPage(openDriver());
    SmartWait smartWait = new SmartWait();
    WebDriver webDriver = openDriver();

    public ImplementationMPageSteps(TestContext context){
        testContext = context;
    }

    @Then("user should see {string}")
    public void userShouldSeeText(String text) {
        System.out.println(new ByAll(By.id(text), (By.xpath(String.format("//*[(text()='%s')]",text))), By.xpath(String.format("//*[contains(text(),'%s')]",text))));
        WebElement txtContains = webDriver.findElement(new ByAll(By.id(text), (By.xpath(String.format("//*[(text()='%s')]",text))), By.xpath(String.format("//*[contains(text(),'%s')]",text))));
        Assert.assertTrue(text +"  is not visible", txtContains.isDisplayed());
    }

    @And("user click DUBLIN icon")
    public void userClickDUBLINIcon() throws InterruptedException {

        implementationMPage.dublinLink();
    }

    @Then("user should not see {string} icon")
    public void userShouldNotSeeConsumablesSubscriptionIcon(String text) {
        smartWait.waitUntilPageIsLoaded(20);
        Assert.assertFalse(Utility.elementExists(implementationMPage.txt_Consumable_Subscription));
        System.out.println(text +" text is not visible");

    }


}

