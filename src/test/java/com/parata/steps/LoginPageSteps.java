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

            loginPage.clickSignInButton();

            smartWait.waitUntilPageIsLoaded(20);
        } else {
            System.out.println("Running external login steps");
            launcher.navigateToParataApplication();
            loginPage.clickMainLoginButton();
            loginPage.typeEmailNew(username);
            loginPage.typePasswordExternal(password);
            loginPage.clickLoginButton();
            smartWait.actionDelay(5000);
            smartWait.waitUntilPageIsLoaded(20);
        }

//        if (username == (ConfigReader.getProperty("unauthorized.username"))) {
//            String landingUrl = openDriver().getCurrentUrl();
//            System.out.println(landingUrl);
//        } else if (!username.equals(ConfigReader.getProperty("IM.username")) & !username.equals(ConfigReader.getProperty("PTAC.username"))) {
//            String landingUrl = openDriver().getCurrentUrl();
//            System.out.println(landingUrl);
//        } else if (username.equals(ConfigReader.getProperty("PTAC.username"))) {
//            String landingUrl = openDriver().getCurrentUrl();
//            System.out.println(landingUrl);
//        } else {
//            String landingUrl = openDriver().getCurrentUrl();
//            System.out.println(landingUrl);
//        }

    }

    @Then("logged in to Parata UI Website {}")
    public void logged_in_to_parata_ui_website(String arg0) throws InterruptedException {
        System.out.println(loginPage.loggedUserName.getText());
        String fullName = loginPage.loggedUserName.getText();
        System.out.println(ConfigReader.getProperty("ValidLastNameForGayco"));
        Assert.assertTrue(fullName.equalsIgnoreCase(ConfigReader.getProperty("ValidLastNameForGayco")) || fullName.equalsIgnoreCase(ConfigReader.getProperty("ValidLastNameForGaycoD")));
    }

//    @Then("select login link button")
//    public void selectLoginLinkButton() throws InterruptedException
//    {
//        launcher.navigateToParataApplication();
//        loginPage.clickMainLoginButton();
//        Thread.sleep(2000);
//    }



}
