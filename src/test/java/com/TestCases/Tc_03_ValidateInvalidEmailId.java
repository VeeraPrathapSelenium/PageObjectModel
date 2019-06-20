package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Authentication;
import com.ScreenFunctions.Home;


public class Tc_03_ValidateInvalidEmailId extends GenericFunctions {
	
	
	@Test
	
	
	public static void Tc_01_ValidateLoginCredentials()
	{boolean status =true;
		//Step1:-Launch Appplication
		GenericFunctions gnf=new GenericFunctions();
		
	status=	GenericFunctions.launchApplication("chrome");
	
	
	// check for the browser launch status
	
	if(status)
	{
		Home home=PageFactory.initElements(driver, Home.class);
		
		status=home.click_SignIn();
		// check for the signin status
		if(status)
		{
			Authentication auth=PageFactory.initElements(driver, Authentication.class);
			status=auth.enter_EmailId_NewUser();
			
			
			System.out.println("**************************************");
	if(status)
	{
		status=auth.enter_UserDaetails();
		
		if(status)
		{
			status=auth.logout();
			
			if(status)
			{
				auth.login_AlreadyRegisterd();
			}
		}
	}
		
		}
	}
	
		
		
		
	}
			
			
			

}
