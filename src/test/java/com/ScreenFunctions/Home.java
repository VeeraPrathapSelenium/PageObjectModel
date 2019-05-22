package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Home extends GenericFunctions{

	//************************************** Home Page Header Section *******************
	@FindBy(how=How.XPATH,using="//a[normalize-space(text())='Sign in']")
	public WebElement lnk_Signin;
	
	
	
	//*************************************** Methods Implementation ********************
	
	/**
	 * Method Name: click_SignIn()
	 * @return:boolean
	 * Date:22-May-19
	 */
	
	
	public boolean click_SignIn()
	{
		boolean status=true;
		// wait till the element is founbd on the page
		status=waitForElement(lnk_Signin);
		
		// check if the element is available
		
		if (status)
		{
			logEvent("Pass", "Sign in link is available on the Home page");
			
			//click on the sign in click
			status=hoverAndClick(lnk_Signin);
			
			if(status)
			{
				logEvent("Pass", "Sign in link is clicked sucessfully on the Home page");
			}else{
				logEvent("fail", "Sign in link is not clicked on the Home page");
			}
			
		}else
		{
			logEvent("fail", "Unable to find the Siggn in Link on the Home Page");
		}
		
		return status;
				
				
		
	}
	

}
