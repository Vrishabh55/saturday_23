package commonMethods;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility1 
{
	public static String ReaddataFromPropfile(String key) throws IOException
	{

		Properties prop=new Properties();
		
		
		
		
		
		
		FileInputStream stream=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\ProjectName\\mavenProp");
		prop.load(stream);
		String Skey = prop.getProperty(key);
		
		Reporter.log("Reading Values From Property Files",true);
		return Skey;
	}
	
	public static void wait(WebDriver driver, int waittime)
	{
		
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
	Reporter.log("waiting for "+waittime+"milis",true);
	}
	
	public static void takeSceenshot(WebDriver driver, String userName) throws IOException 
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		
		String RD = RandomString.make(3);
		 File destination= new File("C:\\Users\\Admin\\Desktop\\Study Screenshots"+RD+".png");
		 FileHandler.copy(source, destination);
		 System.out.println("program is running successfully");
		Reporter.log("taking screenshot ",true);
		
	}

}
