package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class PmToolSteps {
    WebDriver driver = null;
    @Given("open chrome browser")
    public void open_chrome_browser() {
        System.out.println("Inside Step- browser is open");
        System.setProperty("webdriver.chrome.driver",
                "D:\\Projects\\PMTCustomer\\Testing\\PMToolSeleniumTesting\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @And("user is on PM Tool  main page")
    public void user_is_on_PM_Tool_main_page() throws InterruptedException {
        System.out.println("Inside Step- user is on PM Tool  main page");
        driver.navigate().to("http://localhost:4200/");
        Thread.sleep(2000);
    }
    @And("select login link\\/button")
    public void selectLoginLinkButton()  throws InterruptedException {
        System.out.println("Inside Step-select login link/button");
        WebElement loginLink = driver.findElement(By.xpath("//button[@class='btn-primary btn-sm']"));
        loginLink.click();
        Thread.sleep(2000);
    }
    @When("user enters a parata Email Address and hits login button")
    public void userEntersAParataEmailAddress()throws InterruptedException {

         System.out.println("Inside Step - enters a parata Email Address");
         WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("vdr_ssayeem@parata.com");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();
        Thread.sleep(2000);
    }
    @And("enters microsoft password")
    public void enters_microsoft_password()throws InterruptedException{
        System.out.println("Inside Step - enters microsoft password");
        WebElement inputPassword = driver.findElement(By.id("i0118"));
        inputPassword.sendKeys("1010997637@Hydrus");
        Thread.sleep(2000);
    }
    @And("hits sign in button")
    public void hits_enter_button() throws InterruptedException{
            System.out.println("Inside Step - clicked login button");
            driver.findElement(By.id("idSIButton9")).submit();
            Thread.sleep(2000);
    }
    @And("Stay signed in on microsoft")
    public void stay_signed_in_on_microsoft() throws InterruptedException{
        System.out.println("Inside Step - Stay signed in on microsoft");
        driver.findElement(By.id("KmsiCheckboxField")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).submit();
        Thread.sleep(2000);
    }
    @Then("user is navigated to im-tool page")
    public void user_is_navigated_to_im_tool_page() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/im-tool");
        Thread.sleep(8000);
        driver.close();
        driver.quit();
    }


}
