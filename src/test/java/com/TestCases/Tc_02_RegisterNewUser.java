package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Authentication;
import com.ScreenFunctions.Home;


public class Tc_02_RegisterNewUser extends GenericFunctions {
	
	
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
			auth.enter_EmailId_NewUser();
			
		}
	}
	
		
		
		
	}
			
			
			

}
