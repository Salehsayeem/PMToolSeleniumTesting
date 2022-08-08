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

/**
 * @author Abid
 * 8/2/2022
 */
public class ImplementationMPage extends CommonPageMethods {

    @FindBy(how = How.XPATH, using = ("//*[@id=\"D-MnuImTool\"]/a"))
    public WebElement btnImplementationMgt;

    @FindBy(how = How.XPATH, using = ("//*[@id=\"mat-select-0\"]"))
    public WebElement dropdownAllStatus;

    @FindBy(how = How.XPATH, using = ("//*[@id=\"mat-option-5\"]/span"))
    public WebElement btnNotProcessed;

    @FindBy(how = How.ID, using = ("search_customers"))
    public WebElement inputCustomerNumber;




    WebDriver webDriver;

    public ImplementationMPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void implementaionMgmtClicked(){
        click(btnImplementationMgt);
    }

    public void userclickedAllStatus() throws InterruptedException {
        click(dropdownAllStatus);
    }

    public void selectBtnImplementationManager() throws InterruptedException {
        click(btnNotProcessed);
    }

    public void enterCustomerNumber(String customerNumber) {
        inputCustomerNumber.sendKeys(customerNumber);
    }



}
