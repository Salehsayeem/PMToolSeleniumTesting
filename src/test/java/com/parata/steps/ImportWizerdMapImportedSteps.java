package com.parata.steps;

import com.parata.base.AutomationBase;
import com.parata.pages.ImplementationMPage;
import com.parata.pages.ImportWizerdMapImportedPage;
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

public class ImportWizerdMapImportedSteps extends AutomationBase {
    ImportWizerdMapImportedPage importWizerdMapImportedPage = new ImportWizerdMapImportedPage(openDriver());
    SmartWait smartWait = new SmartWait();

    @Then("user click import button")
    public void clickImportButton() throws InterruptedException{

        importWizerdMapImportedPage.userclickedImportButton();
        smartWait.waitUntilPageIsLoaded(90);
    }

    @Then("user click browse button")
    public void clickBrowseButton() throws InterruptedException{
        importWizerdMapImportedPage.userclickedBrowseButton();
        smartWait.waitUntilPageIsLoaded(90);
    }

    @Then("user click update button")
    public void clickUploadButton() throws InterruptedException{
        importWizerdMapImportedPage.userclickedUploadButton();
        smartWait.waitUntilPageIsLoaded(90);
    }

    @Then("user clicks Production Drug dropdown")
    public void userClicksDrugMapDropdown1() throws InterruptedException {
        importWizerdMapImportedPage.userselectMapDropdown1();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("select {string} from drug dropdown")
    public void selectDrugProducName(String arg0) throws InterruptedException {
        Utility.dropdownCount(openDriver(), ".mat-option>span");
        importWizerdMapImportedPage.selectBtnProductDragName();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("user clicks NDC from Drug dropdown")
    public void userClicksDrugMapDropdown2() throws InterruptedException {
        importWizerdMapImportedPage.userselectMapDropdown2();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("select {string} NDC from drug dropdown")
    public void selectDrugNdcName(String arg0) throws InterruptedException {
        Utility.dropdownCount(openDriver(), ".mat-option>span");
        importWizerdMapImportedPage.selectBtnNdcDragName();
        smartWait.waitUntilPageIsLoaded(15);
    }

    @Then("user clicks Rx from drug dropdown")
    public void userClicksDrugMapDropdown3() throws InterruptedException {
        importWizerdMapImportedPage.userselectMapDropdown3();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("select {string} Rx from drug dropdown")
    public void selectDrugRxName(String arg0) throws InterruptedException {
        Utility.dropdownCount(openDriver(), ".mat-option>span");
        importWizerdMapImportedPage.selectBtnRxDragName();
        smartWait.waitUntilPageIsLoaded(10);
    }

    @Then("user click next button")
    public void userClicksNextButton() throws InterruptedException {
        importWizerdMapImportedPage.userclickedNextButton();
        smartWait.waitUntilPageIsLoaded(10);
    }
}
