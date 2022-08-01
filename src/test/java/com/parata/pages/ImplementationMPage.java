package com.parata.pages;


import com.parata.utils.CommonPageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MFU
 * 1/7/2021
 */
public class ImplementationMPage extends CommonPageMethods {
    @FindBy(how = How.ID, using = ("OrgConsumablesTab"))
    public WebElement link_Consumable_Subscription;

    @FindBy(how = How.XPATH, using = ("//h4[contains(text(),'Consumable Order Setup')]"))
    public WebElement txt_Consumable_Subscription;

    @FindBy(how = How.XPATH, using = ("//td[contains(text(),'DUBLIN')]"))
    public WebElement linkDublin;

    WebDriver webDriver;

    public ImplementationMPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void isConsumable_SubcriptionLinkAvaliable()
    {
        link_Consumable_Subscription.isEnabled();
        System.out.println("ConsumablevSubcription Avaliable");
    }
    public void dublinLink() throws InterruptedException {
        click(linkDublin);
        System.out.println("ConsumablevSubcription Avaliable");
    }
}
