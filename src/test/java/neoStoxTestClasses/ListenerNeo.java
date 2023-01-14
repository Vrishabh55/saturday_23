package neoStoxTestClasses;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase.BaseNeo;

public class ListenerNeo extends BaseNeo implements ITestListener
{
	
	
	public void onTestSuccess(ITestResult result) 
	{
	String methodName = result.getName();
	Reporter.log("TC "+methodName+"is completed successfuliy",true);
	}
	public void onTestFailure(ITestResult result) 
	{
	Reporter.log("TC "+result.getName()+" is failed",true);
	}
	public void onTestSkipped(ITestResult result) 
	{
	Reporter.log("TC "+result.getName()+ "is skipped please check",true);
	}
	
	

}
