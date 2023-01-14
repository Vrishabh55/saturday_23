package neoStoxTestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonMethods.Utility1;
import neoStoxBase.BaseNeo;
import neoStoxPOM.NeoStoxHomePage;
import neoStoxPOM.NeoStoxPasswordPage;
import neoStoxPOM.NeoStoxSignLogin;
@Listeners(neoStoxTestClasses.ListenerNeo.class)

public class TestClassNeo extends BaseNeo
{
	NeoStoxSignLogin login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	  @BeforeClass
	  public void launchBrowser1()
	  {
		  launchBrowser();
		  login= new NeoStoxSignLogin(driver);
		  password= new NeoStoxPasswordPage(driver);
		  home= new NeoStoxHomePage(driver);

		  }
	  @BeforeMethod
	  public void loginToNeoStox() throws  IOException, InterruptedException
	  {
	  //login.sendMobileNum(driver, Utility.readDataFromExcel(0, 0));
		  login.sendMobileNum(driver, Utility1.ReaddataFromPropfile("mobNo"));  //reading data from property file
	  login.clickOnSignInButton(driver);
	  Thread.sleep(1000);
	  //password.sendPassword(driver, Utility.readDataFromExcel(0, 1));
	  password.sendPassword(driver, Utility1.ReaddataFromPropfile("password"));

	  password.clickOnSubmitButton(driver);
	  Thread.sleep(1000);
	  home.popUpHandle(driver);
	  }

	  @Test
	  public void validateUserName() throws IOException
	 {
	//Assert.assertEquals(home.getUserName(),Utility.readDataFromExcel(0, 2),"TC failed, actual and expected User Names are not matching"); 
	// Utility.takeSceenshot(driver,home.getUserName());
			Assert.assertEquals(home.getUserName(),Utility1.ReaddataFromPropfile("username"),"TC failed, actual and expected User Names are not matching"); 
			 Utility1.takeSceenshot(driver,home.getUserName());

		  
	 }
	  @AfterMethod
	  public void logout()
	  {
		  home.logoutFormNeoStox(driver);
	  }
	  @AfterClass
	  public void closeApplication() throws InterruptedException
	  {
		  closingBrowser(driver);
		  
	  }
	  
  
}
