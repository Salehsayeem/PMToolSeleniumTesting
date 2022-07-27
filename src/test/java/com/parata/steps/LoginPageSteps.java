package com.parata.steps;

import com.parata.base.AutomationBase;
import com.parata.pages.LoginPage;
import com.parata.utils.Launcher;
import com.parata.utils.ConfigReader;
import com.parata.utils.SmartWait;
import com.parata.utils.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.parata.utils.context.TestContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageSteps extends AutomationBase{

    Launcher launcher = new Launcher(openDriver());
    LoginPage loginPage = new LoginPage(openDriver());
    SmartWait smartWait = new SmartWait();

    public LoginPageSteps(TestContext context) {
        testContext = context;
    }

    @Given("user logged in TacoUI with {string} credentials")
    public void userLoggedInTacoUIWithCredentials(String arg0) {
        System.out.format("Thread ID - %2d ", Thread.currentThread().getId());
        String username = ConfigReader.getProperty(arg0 + ".username");
        System.out.println(username + " " + arg0);
        String password = ConfigReader.getProperty(arg0 + ".password");

        assert username != null;
        if (username.contains(("@parata.com"))) {
            System.out.println("Running internal login steps");
            launcher.navigateToParataApplication();
            loginPage.clickMainLoginButton();
            loginPage.typeEmailNew(username);
            loginPage.clickLoginButton();
            loginPage.typePasswordInternal(password);
            //loginPage.clickLoginButton(); //added
            loginPage.clickSignInButton();
            loginPage.clickSignInButton();
            smartWait.waitUntilPageIsLoaded(20);
        } else {
            System.out.println("Running external login steps");
            launcher.navigateToParataApplication();
            loginPage.clickMainLoginButton();
            loginPage.typeEmailNew(username);
            //loginPage.clickLoginButton();
            loginPage.typePasswordExternal(password);
            loginPage.clickLoginButton();
            smartWait.actionDelay(5000);
            smartWait.waitUntilPageIsLoaded(20);
        }

        if (username == (ConfigReader.getProperty("unauthorized.username"))) {
            String landingUrl = openDriver().getCurrentUrl();
            System.out.println(landingUrl);
        } else if (!username.equals(ConfigReader.getProperty("IM.username")) & !username.equals(ConfigReader.getProperty("PTAC.username"))) {
            String landingUrl = openDriver().getCurrentUrl();
            System.out.println(landingUrl);
        } else if (username.equals(ConfigReader.getProperty("PTAC.username"))) {
            String landingUrl = openDriver().getCurrentUrl();
            System.out.println(landingUrl);
        } else {
            String landingUrl = openDriver().getCurrentUrl();
            System.out.println(landingUrl);
        }
        try {
            loginPage.btnCloseWarning.click();
        } catch (Exception e) {
            System.out.println("No warning");
        }
    }

    @Then("select login link button")
    public void selectLoginLinkButton() throws InterruptedException
    {
        launcher.navigateToParataApplication();
        loginPage.clickMainLoginButton();
        Thread.sleep(2000);
    }

//    @When("user enters a parata Email Address and hits login button")
//    public void userEntersAParataEmailAddress()throws InterruptedException {
//
//        driver.findElement(By.id("email")).sendKeys("vdr_ssayeem@parata.com");
//        driver.findElement(By.id("btn-login")).click();
//        System.out.println("Inside Step - enters a parata Email Address");
//        Thread.sleep(2000);
//    }
//
//    @Then("enters microsoft password")
//    public void enters_microsoft_password()throws InterruptedException
//    {
//        driver.findElement(By.id("i0118")).sendKeys("1010997637@Hydrus");
//        System.out.println("Inside Step - enters microsoft password");
//        Thread.sleep(2000);
//    }
//    @And("hits sign in button")
//    public void hits_enter_button() throws InterruptedException
//    {
//        driver.findElement(By.id("idSIButton9")).submit();
//        System.out.println("Inside Step - clicked login button");
//        Thread.sleep(2000);
//    }

}
