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
        smartWait.waitUntilPageIsLoaded(20);
    }

    @Then("user click import button")
    public void clickImportButton() throws InterruptedException{
        implementationMPage.userclickedImportButton();
        smartWait.waitUntilPageIsLoaded(90);
    }

    @Then("user click browse button")
    public void clickBrowseButton() throws InterruptedException{
        implementationMPage.userclickedBrowseButton();
        smartWait.waitUntilPageIsLoaded(90);
    }

    @Then("user click update button")
    public void clickUploadButton() throws InterruptedException{
        implementationMPage.userclickedUploadButton();
        smartWait.waitUntilPageIsLoaded(90);
    }

    @Then("user clicks Production Drug dropdown")
    public void userClicksDrugMapDropdown1() throws InterruptedException {
        implementationMPage.userselectMapDropdown1();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("select {string} from drug dropdown")
    public void selectDrugProducName(String arg0) throws InterruptedException {
        Utility.dropdownCount(openDriver(), ".mat-option>span");
        implementationMPage.selectBtnProductDragName();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("user clicks NDC from Drug dropdown")
    public void userClicksDrugMapDropdown2() throws InterruptedException {
        implementationMPage.userselectMapDropdown2();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("select {string} NDC from drug dropdown")
    public void selectDrugNdcName(String arg0) throws InterruptedException {
        Utility.dropdownCount(openDriver(), ".mat-option>span");
        implementationMPage.selectBtnNdcDragName();
        smartWait.waitUntilPageIsLoaded(15);
    }

    @Then("user clicks Rx from drug dropdown")
    public void userClicksDrugMapDropdown3() throws InterruptedException {
        implementationMPage.userselectMapDropdown3();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("select {string} Rx from drug dropdown")
    public void selectDrugRxName(String arg0) throws InterruptedException {
        Utility.dropdownCount(openDriver(), ".mat-option>span");
        implementationMPage.selectBtnRxDragName();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("user click next button")
    public void userClicksNextButton() throws InterruptedException {
        implementationMPage.userclickedNextButton();
        smartWait.waitUntilPageIsLoaded(10);
    }

}


