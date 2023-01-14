package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import commonMethods.Utility1;

public class NeoStoxSignLogin 
{
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber")private WebElement mobileNumField;
	@FindBy(id="lnk_signup1")private WebElement signInButton;
	
	public NeoStoxSignLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendMobileNum(WebDriver driver, String mobNum)
	{
		Utility1.wait(driver, 1000);
		mobileNumField.sendKeys(mobNum);
		Reporter.log("sending mobile number..", true);
	}
	public void clickOnSignInButton(WebDriver driver)
	{
		Utility1.wait(driver, 1000);
		signInButton.click();
		Reporter.log("clicking on sign in Button", true);
		
	}

}
