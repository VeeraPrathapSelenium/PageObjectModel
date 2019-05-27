package com.GenericFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class GenericFunctions extends TestNGListeners {
	
	
	public static  WebDriver driver;

	
	

	/*************************************************
	
	
	Function Name:launchApplication
	
	Purpose:-This Function is used to launch the HRM Application when ever the user is required
	
	Input Parameters:-User must send in which browser does the application need to be launch
	
	Output Parameters:-This method will return a boolean value stating wheter the user logged into in the system
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/30/2017
	
	
	**************************************************/
	
	
	
	
	
	public static boolean launchApplication(String browser) {
		
		boolean status=true;
		
		String url=getCommontestdata("Url");
		
		switch (browser.toLowerCase()) {
	
		case "firefox":
			
			driver= new FirefoxDriver();
	
			
			driver.get(url);
			
			
			
			break;
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			
			driver=new ChromeDriver();
			driver.get(url);
			
			break;
			
			
			
		default:
			break;
		}
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	return status;	
		
	}
	

	/*************************************************
	
	
	Function Name:GetCommonTestdata 
	
	Purpose:-This Function is used to get the common test data which can be accessed commonly for each testcase such as Environment,Url,Username,Password
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/31/2017
	
	
	**************************************************/
	
	
	
	public static String getCommontestdata(String data)
	{
		
		String strQuery="Select "+ data+" from CommonTestdata";
		
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(data));
				
				fetcheddata=recordset.getField(data);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	
	public static String getdata(String sheetname,String userdata,int itr)
	{
		
		String strQuery="Select "+ userdata+" from "+sheetname+ " where Tc_Name='"+crntclass+"' and Iteration="+itr;
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(userdata));
				
				fetcheddata=recordset.getField(userdata);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	public static boolean waitForElement(WebElement element)
	{
	boolean status=false;
		for(int i=1;i<=10;i++)
		{
		try
		{
			System.out.println("Wait is executing");
			Actions acc=new Actions(driver);
			acc.moveToElement(element).build().perform();
			
			System.out.println("Element Found");
			status=true;
			break;
			
		}
		catch(Exception e)
		{
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			
		}
		}
		return status;	
		
	}
	
	
	public static boolean hoverAndClick(WebElement element)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Actions acc=new Actions(driver);
			acc.moveToElement(element).click().build().perform();
		
		
			
			
		}
		catch(Exception e)
		{
			
			status=false;
		
		}	
		
	
	
	return status;
	}	
	
	public static void forceClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
		
	}
	
	
	public static boolean clickAndSendData(WebElement element,String data)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Actions acc=new Actions(driver);
			acc.moveToElement(element).click().build().perform();
			element.clear();
			element.sendKeys(data);
		
			
			
		}
		catch(Exception e)
		{
			
			status=false;
		
		}	
		
	
	
	return status;
	}	

	
	
	
	
	public static boolean selectDropDOwn(WebElement element,String data)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Select slct=new Select(element);
			
			slct.selectByValue(data);
			
			
		}
		catch(Exception e)
		{
			
			status=false;
		
		}	
		
	
	
	return status;
	}		
	
	
	
}
