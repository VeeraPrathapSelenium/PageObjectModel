package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Login extends GenericFunctions{
	
	// ****************************  Login Panel Section Object  *********************************
	
	
//User Name	
	@FindBy(how=How.ID,using="txtUsername")
	
		public static WebElement Username;
	
//Password	
	@FindBy(how=How.ID,using="txtPassword")
	
		public static WebElement Password;
	
	
//Login Button
	@FindBy(how=How.ID,using="btnLogin")
		
		public static WebElement Login;	
	
	
/*************************************************
	
	
	Function Name:Login
	
	Purpose:-This Function is used to login into the HRM Application when ever the user is required
	
	Input Parameters:-NA
	
	Output Parameters:-This method will return a boolean value stating wheter the application is launched or not
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/30/2017
	
	
	**************************************************/	
	
	
	public static boolean Login()
	{
		boolean status=true;
		
		try
		{
			String username=getCommontestdata("Username");
			Username.click();
			Username.clear();
			Username.sendKeys(username);
			
		}
		
		catch(Exception e)
		{
			status=false;
		}
		
		
		//Based on the Username status Enter password
		
		if(status)
		{
			
			try
			{
				String password=getCommontestdata("Password");
				Password.click();
				Password.clear();
				Password.sendKeys(password);
				
			}
			
			catch(Exception e)
			{
				status=false;
			}
			
			//Based on the Password status Click on the Login Button
			
			try
			{
				Login.click();
								
			}
			
			catch(Exception e)
			{
				status=false;
			}
			
			
			
		}
		
		
		
		return status;
		
	}


}
