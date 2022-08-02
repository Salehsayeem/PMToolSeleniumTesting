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
 * @author MFU
 * 1/7/2021
 */
public class ImplementationMPage extends CommonPageMethods {

    @FindBy(how = How.XPATH, using = ("//*[@id=\"D-MnuImTool\"]/a/div"))
    public WebElement btnImplementationMgt;

    @FindBy(how = How.XPATH, using = ("//td[contains(text(),'DUBLIN')]"))
    public WebElement linkDublin;

    WebDriver webDriver;

    public ImplementationMPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void implementaionMgmtClicked()
    {
        click(btnImplementationMgt);
    }
}
