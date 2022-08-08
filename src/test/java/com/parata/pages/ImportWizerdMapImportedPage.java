package com.parata.pages;

import com.parata.utils.CommonPageMethods;
import com.parata.utils.SmartWait;
import com.parata.utils.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ImportWizerdMapImportedPage extends CommonPageMethods{


    @FindBy(how = How.XPATH, using = ("//*[@id=\"add_site\"]"))
    public WebElement btnImport;

    @FindBy(how = How.ID, using = ("fileDropRef"))
    public WebElement btnBrowse;

    @FindBy(how = How.XPATH, using = ("/html/body/div[3]/div[2]/div/mat-dialog-container/app-import-wizard-one/div/div/div/div[2]/button"))
    public WebElement btnUpload;

    @FindBy(how = How.XPATH, using = ("//*[@id=\"mat-select-6\"]"))
    public WebElement dropdownDrugName;

    @FindBy(how = How.XPATH, using = ("//*[@id=\"mat-option-12\"]"))
    public WebElement btnProductName;

    @FindBy(how = How.XPATH, using = ("//*[@id=\"mat-select-8\"]"))
    public WebElement dropdownDrugName2;

    @FindBy(how = How.XPATH, using = ("//*[@id=\"mat-option-18\"]"))
    public WebElement btnNdcName;

    @FindBy(how = How.XPATH, using = ("//*[@id=\"mat-select-10\"]"))
    public WebElement dropdownDrugName3;

    @FindBy(how = How.XPATH, using = ("//*[@id=\"mat-option-24\"]"))
    public WebElement btnRxName;

    @FindBy(how = How.XPATH, using = ("/html/body/div[3]/div[2]/div/mat-dialog-container/app-import-wizard-one/div/form/mat-dialog-actions/button[2]"))
    public WebElement btnNext;

    WebDriver webDriver;

    public ImportWizerdMapImportedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void userclickedImportButton() throws InterruptedException {
        click(btnImport);
    }

    public void userclickedBrowseButton() throws InterruptedException {
        btnBrowse.sendKeys("E:\\Kroger_025-644_03-21-2022.xlsx");
    }

    public void userclickedUploadButton() throws InterruptedException {
        click(btnUpload);
    }

    public void userselectMapDropdown1() throws InterruptedException {
        click(dropdownDrugName);
    }

    public void selectBtnProductDragName() throws InterruptedException {
        click(btnProductName);
    }

    public void userselectMapDropdown2() throws InterruptedException {
        click(dropdownDrugName2);
    }

    public void selectBtnNdcDragName() throws InterruptedException {
        click(btnNdcName);
    }

    public void userselectMapDropdown3() throws InterruptedException {
        click(dropdownDrugName3);
    }

    public void selectBtnRxDragName() throws InterruptedException {
        click(btnRxName);
    }

    public void userclickedNextButton() throws InterruptedException {
        click(btnNext);
    }
}
