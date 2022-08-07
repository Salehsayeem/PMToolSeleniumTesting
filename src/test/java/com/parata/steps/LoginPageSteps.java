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

    @Then("user should land the page {string}")
    public void userShouldLandPageequalsor(String url_part) {
        String landingUrl = openDriver().getCurrentUrl();
        System.out.println(landingUrl);
        Assert.assertTrue(landingUrl.equals(url_part));
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


    @Then("user should see warning and should not log in to Parata UI Website")
    public void userShouldSeeWarningOnParataUIWebsite() throws InterruptedException {
        smartWait.waitUntilPageIsLoaded(20);
        System.out.println(loginPage.warningAuthorization.getText());
        Assert.assertTrue(Utility.elementExists(loginPage.warningAuthorization));
    }

    @When("user clicks login button")
    public void user_clicks_login_button() throws InterruptedException {
        loginPage.clickLoginButton();
        Thread.sleep(3000);
    }


    @When("user relogs in TacoUI with {string} credentials")
    public void userRelogsWithUserCredentials(String user) {
        loginPage.clickLogout();
        String username = ConfigReader.getProperty(user + ".username");
        String password = ConfigReader.getProperty(user + ".password");
        if (username.contains(("@parata.com"))) {
            System.out.println("Running internal login steps");
            launcher.navigateToParataApplication();
            loginPage.clickMainLoginButton();
            loginPage.typeEmailNew(username);
            loginPage.clickLoginButton();
            loginPage.typePasswordInternal(password);
            //loginPage.clickLoginButton(); //added
            loginPage.clickSignInButton();
            smartWait.actionDelay(5000);
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
        SmartWait.awaitUntilPageIsLoaded(openDriver(), 15);
        try {
            loginPage.btnCloseWarning.click();
        } catch (Exception e) {
            System.out.println("No warning");
        }
    }

}
