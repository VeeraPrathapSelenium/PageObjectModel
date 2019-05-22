package com.ScreenFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Authentication extends GenericFunctions {
	
	//********************************** Global Variable ****************************
	
	public static String emailid="";
	
	
	
	//************************************** Home Page Header Section *******************
		@FindBy(how=How.XPATH,using="//h3[text()='Already registered?']")
		public WebElement txt_AlreadyRegisterUser_SectionHeader;
		
		
		@FindBy(how=How.XPATH,using="//input[@id='email_create']")
		public WebElement edi_emailaddress;
		
		
		
		//*************************************** Methods Implementation ********************
		/***
		 * Method Name:verify_SectionHeader_Display
		 * Purpose:Thsi method will verify wheter the section header is displayed or not
		 * 
		 * @return
		 */
		public boolean verify_SectionHeader_Display()
		{
			boolean status=true;
			
			try {
				
				status=waitForElement(txt_AlreadyRegisterUser_SectionHeader);
				
				
				if(status)
				{
					logEvent("Pass", "Section header \" Already Registered User ?\" is displayed");
				}else
				{
					logEvent("Fail", "Section header \" Already Registered User ?\" is not displayed");
				}
				
			}catch(Exception e)
			{
				
			}
			
			
			
			return status;
		}
		
		
		public boolean enter_EmailId_NewUser()
		{
			boolean status=true;
			try
			{

				SimpleDateFormat sdf=new SimpleDateFormat("hhmmss");
				
				emailid="abc"+sdf.format(new Date())+".xyz@tcs.com";
				status=clickAndSendData(edi_emailaddress, emailid);
							
				
				if(status)
				{
					logEvent("Pass", "Email id is entered sucessfully for new user registration");
					edi_emailaddress.sendKeys(Keys.TAB);
					
				}else
				{
					logEvent("Fail", "Email id is not entered sucessfully for new user registration");
				}
				
				
			}catch(Exception e)
			{
				logEvent("Fail", e.getMessage());
			}
			return status;
			
		}
}
