package com.parata.pages;


import com.parata.utils.CommonPageMethods;
import org.openqa.selenium.WebDriver;
import com.parata.utils.SmartWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonPageMethods {

    SmartWait smartWait = new SmartWait();

    @FindBy(how = How.XPATH, using = ("//button[@class='btn-primary btn-sm']"))
    public WebElement btnMainLogin;

    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void clickMainLoginButton() {
        click(btnMainLogin);
        System.out.println("Main Login Button Clicked");
    }


}
