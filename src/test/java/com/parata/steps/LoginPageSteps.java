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
import org.openqa.selenium.chrome.ChromeDriver;
import com.parata.pages.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.util.concurrent.TimeUnit;

public class LoginPageSteps extends AutomationBase{

   public WebDriver driver;
    LoginPage login;

    Launcher launcher = new Launcher(openDriver());
    LoginPage loginPage = new LoginPage(openDriver());
    SmartWait smartWait = new SmartWait();

    public LoginPageSteps(TestContext context) {
        testContext = context;
    }

    @Given("user visits to the pm portal")
    public void user_visits_to_the_pm_portal() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver","./src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("user on PM Tool  main page")
    public void user_on_PM_Tool_main_page() throws InterruptedException{
        System.out.println("Inside Step- user is on PM Tool  main page");
        driver.get("https://frontend.stg.tacodevdomain.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Then("select login link button")
    public void selectLoginLinkButton()  throws InterruptedException{
        //driver.findElement(By.xpath("//button[@class='btn-primary btn-sm']")).click();
        //System.out.println("Inside Step-select login link/button");
        launcher.navigateToParataApplication();
        loginPage.clickMainLoginButton();
        Thread.sleep(2000);
    }

    @When("user enters a parata Email Address and hits login button")
    public void userEntersAParataEmailAddress()throws InterruptedException {

        driver.findElement(By.id("email")).sendKeys("vdr_ssayeem@parata.com");
        driver.findElement(By.id("btn-login")).click();
        System.out.println("Inside Step - enters a parata Email Address");
        Thread.sleep(2000);
    }

    @Then("enters microsoft password")
    public void enters_microsoft_password()throws InterruptedException
    {
        driver.findElement(By.id("i0118")).sendKeys("1010997637@Hydrus");
        System.out.println("Inside Step - enters microsoft password");
        Thread.sleep(2000);
    }
    @And("hits sign in button")
    public void hits_enter_button() throws InterruptedException
    {
        driver.findElement(By.id("idSIButton9")).submit();
        System.out.println("Inside Step - clicked login button");
        Thread.sleep(2000);
    }

}
