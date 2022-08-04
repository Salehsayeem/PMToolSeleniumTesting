package com.parata.pages;


import com.parata.utils.CommonPageMethods;
import org.openqa.selenium.WebDriver;
import com.parata.utils.SmartWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Abid
 * 8/2/2021
 */

public class LoginPage extends CommonPageMethods {

    SmartWait smartWait = new SmartWait();

    @FindBy(how = How.CSS, using = ("mat-card-actions > button"))
    public WebElement btnMainLogin;

    @FindBy(how = How.ID, using = ("pendo-close-guide-3e3a5ca8"))
    public WebElement btnCloseWarning;

    @FindBy(how = How.ID, using = ("1-email"))
    public WebElement txtEmail;

    @FindBy(how = How.ID, using = ("email"))
    public WebElement txtEmail2;

    @FindBy(how = How.NAME, using = ("password"))
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = ("password"))
    public WebElement txtPasswordID;

    @FindBy(how = How.ID, using = ("i0118"))
    public WebElement txtPassword3;

    @FindBy(how = How.CSS, using = ("#i0118"))
    public WebElement txtPassword4;

    @FindBy(how = How.NAME, using = ("password"))
    public WebElement txtPassword5;

    @FindBy(how = How.ID, using = ("idSIButton9"))
    public WebElement btnSubmitFinal;

    @FindBy(how = How.NAME, using = ("submit"))
    public WebElement btnLogin;

    @FindBy(how = How.ID, using = ("btn-login"))
    public WebElement btnLogin2;



    @FindBy(how = How.ID, using = ("mat-checkbox-1-input"))
    public WebElement checkBox;

    @FindBy(how = How.XPATH, using = ("//h1[contains(text(),'You do not have authorization to access site')]"))
    public WebElement warningAuthorization;

    @FindBy(how = How.XPATH, using = ("//div[@class='user_profile']"))
    public WebElement accountDropdown;


    @FindBy(how = How.XPATH, using = ("//button[contains(text(),'Logout')]"))
    public WebElement logoutButton;


    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void clickMainLoginButton() {
        click(btnMainLogin);
        System.out.println("Main Login Button Clicked");
    }

    public void typeEmail(String strEmail) {
        txtEmail.sendKeys(strEmail);
    }

    public void typeEmailNew(String strEmail) {
        try {
            txtEmail2.sendKeys(strEmail);
        } catch (Exception e) {

            try {
                txtEmail.sendKeys(strEmail);
            } catch (Exception e2) {

            }
        }
    }

    public void typePasswordExternal(String strPassword) {
        try {
            txtPassword.sendKeys(strPassword);
        } catch (Exception e) {

            try {
                txtPasswordID.sendKeys(strPassword);
            } catch (Exception e2) {
                txtPassword3.sendKeys(strPassword);
            }

        }
    }

    public void typePasswordInternal(String strPassword) {
        try {
            txtPasswordID.sendKeys(strPassword);
        } catch (Exception e2) {
            txtPassword3.sendKeys(strPassword);
        }

    }

    public void clickLoginButton() {
        try {
            click(btnLogin2);
        } catch (Exception e2) {

            click(btnLogin);
        }
    }

    public void clickSignInButton() {
        submit(btnSubmitFinal);
    }
    public void clickCheckBox() {
        click(checkBox);
    }

    public void clickLogout() {
        click(accountDropdown);
        click(logoutButton);
    }


}
