package neoStoxBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import commonMethods.Utility1;

public class BaseNeo 

{
	protected WebDriver driver;
	public void launchBrowser()
{
		System.setProperty("webdriver.chrome.driver","C:\\Java\\chromedriver_win32\\chromedriver.exe");

        driver= new ChromeDriver();
        driver.get("https://neostox.com/sign-in");
        driver.manage().window().maximize();
        Reporter.log("Launching browser",true);
        Utility1.wait(driver, 1000);
}
	public static void closingBrowser(WebDriver driver) throws 
	InterruptedException
	{
	Reporter.log("closing browser", true);
	Thread.sleep(500);
	driver.close();
	}
}
