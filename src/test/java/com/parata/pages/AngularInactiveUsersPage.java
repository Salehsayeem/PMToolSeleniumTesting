package com.parata.pages;

import com.parata.utils.CommonPageMethods;
import com.parata.utils.SmartWait;
import com.parata.utils.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByAll;

public class AngularInactiveUsersPage extends CommonPageMethods {

	SmartWait smartWait = new SmartWait();
	@FindBy(how = How.ID, using = ("UserManagementActiveUsersMore0"))
	public WebElement btn_firstellips;

	@FindBy(how = How.XPATH, using = ("//button[text()='Edit']"))
	public WebElement btnEditinEllipse;

	@FindBy(how = How.XPATH, using = ("//button[text()='Inactive']"))
	public WebElement btnInactivateinEllipse;

	@FindBy(how = How.XPATH, using = ("//button[text()='Resend Invitation']"))
	public WebElement btnResendInvitationinEllipse;

	@FindBy(how = How.CSS, using = ("tbody > tr.row-editing.mat-row.ng-star-inserted"))
	public WebElement editoption;

	@FindBy(how = How.ID, using = ("mat-select-2"))
	public WebElement arrowfirstrole;

	@FindBy(how = How.ID, using = ("UserManagementActiveUsersEmail0"))
	public WebElement firstEmail;

	@FindBy(how = How.ID, using = ("reactivate"))
	public WebElement reactivate;

	WebDriver webDriver;

	public AngularInactiveUsersPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void clickFirstEllipsebtn() {
		click(btn_firstellips);
	}
	public String getEmail(){
		String email = firstEmail.getText();
		return email;
	}
	public String getWebelementId(){

		String id= firstEmail.getAttribute("id");
		String InactiveEmailId=id.replace("Active","Inactivate");
		return InactiveEmailId;
	}

	public boolean alloptionsexists() {

		boolean isalldisplayed =
				Utility.elementExists(btnEditinEllipse)
						& Utility.elementExists(btnInactivateinEllipse)
						& Utility.elementExists(btnResendInvitationinEllipse);

		return isalldisplayed;
	}

	public void clicksedit() {
		click(btnEditinEllipse);
	}

	public void clicksInactivate() {
		click(btnInactivateinEllipse);
	}

	public boolean editrow() {

		boolean isEditrowdisplayed =
				Utility.elementExists(editoption);

		return isEditrowdisplayed;
	}

	public boolean isRoleoptionsdisplayed() {

		boolean arrowroleoptions =
				Utility.elementExists(arrowfirstrole);
		return arrowroleoptions;
	}
public void verifyEmailInactivated(String text){
	WebElement txtContains = webDriver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", text)));
	System.out.println(txtContains.getAttribute("id"));
	Assert.assertTrue(txtContains.getAttribute("id").contains("Inactive"));
}

	public void clickTextWebelement(String text){

		System.out.println(new ByAll(By.id(text), (By.xpath(String.format("//*[(text()='%s')]",text))), By.xpath(String.format("//*[contains(text(),'%s')]",text))));
		WebElement txtContains = webDriver.findElement(new ByAll(By.id(text), (By.xpath(String.format("//*[(text()='%s')]",text))), By.xpath(String.format("//*[contains(text(),'%s')]",text))));
		click(txtContains);
		System.out.println(text+" is clicked");
		smartWait.waitUntilPageIsLoaded(15);
	}

	public void clickTextOrg(String text){

		System.out.println(new ByAll(By.id(text), (By.xpath(String.format("//td[(text()='%s')]",text))), By.xpath(String.format("//td[contains(text(),'%s')]",text))));
		WebElement txtContains = webDriver.findElement(new ByAll(By.id(text), (By.xpath(String.format("//td[(text()='%s')]",text))), By.xpath(String.format("//td[contains(text(),'%s')]",text))));
		click(txtContains);
		System.out.println(text+" is clicked");
		smartWait.waitUntilPageIsLoaded(10);
	}

	public void clickTextWebelementandweblemenetvisible(String text, String Id){
		System.out.println(new ByAll(By.id(text), (By.xpath(String.format("//*[(text()='%s')]",text)))));
		WebElement txtContains = webDriver.findElement(new ByAll(By.id(text), (By.xpath(String.format("//*[(text()='%s')]",text))), By.xpath(String.format("//*[contains(text(),'%s')]",text))));
		if(txtContains.isDisplayed()){
			txtContains.click();
			//txtContains.submit();
			WebElement txtContains2 = webDriver.findElement(new ByAll(By.id(text), (By.xpath(String.format("//*[(text()='%s')]",Id))), By.xpath(String.format("//*[contains(text(),'%s')]",Id))));
			Assert.assertTrue(Utility.elementExists(txtContains2));
			System.out.println(Id + " is visible");
			System.out.println(text+" is clicked");
			smartWait.waitUntilPageIsLoaded(5);
		}else{
			System.out.println("User already inactive");
		}
	}

	public void clickTextWebelementwithText(String text,String tag){
		WebElement txtContains = webDriver.findElement(By.xpath(String.format("//"+tag+"[contains(text(),'%s')]", text)));
		click(txtContains);
		System.out.println(text+" is clicked");
	}
	public void textWebelementIsVisibleandEnabled(String text){
		WebElement txtContains = webDriver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", text)));
		Assert.assertTrue(Utility.elementExists(txtContains)&txtContains.isEnabled());
		System.out.println(text+" is visible and enabled");
	}

	public void clickEllipseWebelement(String text){
		WebElement txtContains = webDriver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", text)));
		String id = txtContains.getAttribute("id");

		String ellipseId= id.replace("UserManagementActiveUsersEmail","UserManagementActiveUsersMore");
		System.out.println(ellipseId);
		WebElement ellipseID = webDriver.findElement(By.id(String.format("%s", ellipseId)));
		click(ellipseID);
		System.out.println(ellipseID);
	}
	public void userShouldSeeWarningOnParataUIWebsite(String warning) throws InterruptedException {
		smartWait.waitUntilPageIsLoaded(20);
		WebElement txtContains = webDriver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", warning)));
		System.out.println(txtContains.getText());
		Assert.assertTrue(Utility.elementExists(txtContains));
	}
}