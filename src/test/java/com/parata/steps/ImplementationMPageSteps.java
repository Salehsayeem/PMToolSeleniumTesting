package com.parata.steps;

import com.parata.base.AutomationBase;
import com.parata.pages.ImplementationMPage;
import com.parata.utils.SmartWait;
import com.parata.utils.Utility;
import com.parata.utils.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("user clicks  ImplementaionMgmt icon")
    public void implementaionMgmtClicked() {
        implementationMPage.implementaionMgmtClicked();
    }

    @Then("user should land {string} page")
    public void userShouldLandPage(String url_part) {
        String landingUrl = openDriver().getCurrentUrl();
        System.out.println(landingUrl);
        Assert.assertTrue(landingUrl.contains(url_part));
        smartWait.waitUntilPageIsLoaded(15);
    }


}

