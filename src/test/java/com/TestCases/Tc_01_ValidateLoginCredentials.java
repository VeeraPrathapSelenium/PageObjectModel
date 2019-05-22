package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.ApplyLeave;
import com.ScreenFunctions.Dashboard;
import com.ScreenFunctions.Login;

public class Tc_01_ValidateLoginCredentials extends GenericFunctions {
	
	
	@Test
	
	
	public static void Tc_01_ValidateLoginCredentials()
	{
		//Step1:-Launch Appplication
		GenericFunctions gnf=new GenericFunctions();
		
		gnf.launchApplication("firefox");
		
		//Step2:Enter User Credentials
		
		Login lgn=PageFactory.initElements(driver, Login.class);
		
		boolean status=lgn.Login();
		
		System.out.println(status);
		
		//Click on dashboard and click on Apply Leave
		
		Dashboard dshbrd=PageFactory.initElements(driver, Dashboard.class);
		status=dshbrd.navigateToApplyLeave();
		
		System.out.println(status);
		
		
		//Validate Apply Leave 
		ApplyLeave appl=PageFactory.initElements(driver, ApplyLeave.class);
		status=appl.ApplyLeave_Validation();
		
		System.out.println(status);
		
	}
			
			
			

}
