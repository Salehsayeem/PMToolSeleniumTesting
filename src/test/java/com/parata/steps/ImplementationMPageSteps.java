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
 * 7/17/2022
 */
public class ImplementationMPageSteps extends AutomationBase {
    ImplementationMPage implementationMPage = new ImplementationMPage(openDriver());
    SmartWait smartWait = new SmartWait();


    public ImplementationMPageSteps(TestContext context) {
        testContext = context;
    }

    @When("user clicks ImplementaionMgmt icon")
    public void implementaionMgmtClicked() {
        implementationMPage.implementaionMgmtClicked();
    }

    @Then("user will land {string} page")
    public void userWillLandPage(String url_part) {
        String landingUrl = openDriver().getCurrentUrl();
        System.out.println(landingUrl);
        Assert.assertTrue(landingUrl.contains(url_part));
        smartWait.waitUntilPageIsLoaded(15);
    }

    @And("user clicks Project Status dropdown")
    public void userClicksAllRolesDropdown() throws InterruptedException {
         implementationMPage.userclickedAllStatus();
         smartWait.waitUntilPageIsLoaded(15);

    }

    @And("select {string} project status")
    public void selectRole(String arg0) throws InterruptedException {
        Utility.dropdownCount(openDriver(), ".mat-option>span");
        implementationMPage.selectBtnImplementationManager();
        smartWait.waitUntilPageIsLoaded(15);

    }

    @And("user enters {string} into the search bar")
    public void searchCustomerNumber(String customerNumber) throws InterruptedException{
        implementationMPage.enterCustomerNumber(customerNumber);
        smartWait.waitUntilPageIsLoaded(70);
    }

    @And("user click import button")
    public void clickImportButton() throws InterruptedException{
        implementationMPage.userclickedImportButton();
        smartWait.waitUntilPageIsLoaded(70);
    }

}


