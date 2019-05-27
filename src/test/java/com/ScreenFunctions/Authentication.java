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
		
		@FindBy(how=How.XPATH,using="//button[@id='SubmitCreate']")
		public WebElement btn_createaccount;
		
		
		//************     User Details ***************************************
		@FindBy(how=How.XPATH,using="//input[@id='id_gender1']")
		public WebElement btn_gender_male;
		
		@FindBy(how=How.XPATH,using="//input[@id='id_gender2']")
		public WebElement btn_gender_female;
		
		@FindBy(how=How.XPATH,using="//input[@id='customer_firstname']")
		public WebElement txt_firstname;
		
		@FindBy(how=How.XPATH,using="//input[@id='customer_lastname']")
		public WebElement txt_lastname;
		
		
		@FindBy(how=How.XPATH,using="//input[@id='email']")
		public WebElement txt_email;
		
		@FindBy(how=How.XPATH,using="//input[@id='passwd']")
		public WebElement txt_password;
		
		@FindBy(how=How.XPATH,using="//select[@id='days']")
		public WebElement slct_DOB_days;
		
		@FindBy(how=How.XPATH,using="//select[@id='months']")
		public WebElement slct_DOB_months;
		
		@FindBy(how=How.XPATH,using="//select[@id='years']")
		public WebElement slct_DOB_years;
		
		@FindBy(how=How.XPATH,using="//input[@id='firstname']")
		public WebElement txt_Address_firstname;
		
		@FindBy(how=How.XPATH,using="//input[@id='lastname']")
		public WebElement txt_Address_lasttname;
		
		@FindBy(how=How.XPATH,using="//input[@id='address1']")
		public WebElement txt_Address_Address1;
		
		@FindBy(how=How.XPATH,using="//input[@id='address2']")
		public WebElement txt_Address_Address2;
		
		@FindBy(how=How.XPATH,using="//input[@id='city']")
		public WebElement txt_Address_city;
		
		@FindBy(how=How.XPATH,using="//select[@id='id_state']")
		public WebElement slct_Address_state;
		
		@FindBy(how=How.XPATH,using="//input[@id='postcode']")
		public WebElement slct_Address_zip;
		
		@FindBy(how=How.XPATH,using="//select[@id='id_country']")
		public WebElement slct_Address_country;
		
		@FindBy(how=How.XPATH,using="//input[@id='phone_mobile']")
		public WebElement txt_Address_mobilenumber;
		
		@FindBy(how=How.XPATH,using="//input[@id='alias']")
		public WebElement txt_Address_aliasAddress;
		
		@FindBy(how=How.XPATH,using="//button[@id='submitAccount']")
		public WebElement btn_Register;
		
		
		//**************** Logout Section **********************
		
		@FindBy(how=How.XPATH,using="(//a[normalize-space(text())='Sign out'])[1]")
		public WebElement lnk_Signout;
		
		
		@FindBy(how=How.XPATH,using="//button[@id='SubmitLogin']")
		public WebElement btn_submitlogin;
		
		
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
					
					status=hoverAndClick(btn_createaccount);
					if(status)
					{
						logEvent("Pass", "Create Account button is clicked sucessfully");
					}
					else
					{
						logEvent("Fail", "Create Account button is not clicked sucessfully");
					}
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



/**
 * Method:enter_UserDaetails()
 * 
 * @Input Parameters:NA
 * 
 * @Output parameters:boolean
 */

		public boolean enter_UserDaetails()
		{
			boolean status=false;
			try
			{
				// get gender 
				
				String gender=getdata("RegisterUser", "Gender", 1);
				
				if(gender.trim().toLowerCase().equals("male"))
				{
					status=hoverAndClick(btn_gender_male);
					
					if(status)
					{
						logEvent("pass", "Option Male is seleted as gender");
					}else
					{
						logEvent("fail", "Option Male is not seleted as gender");
					}
				}else
				{
					status=hoverAndClick(btn_gender_female);
					if(status)
					{
						logEvent("pass", "Option female is seleted as gender");
					}else
					{
						logEvent("fail", "Option female is not seleted as gender");
					}
				}
				
			//enter firstname	
				String fname=getdata("RegisterUser", "Firstname", 1);
				status=clickAndSendData(txt_firstname, fname);
				if(status)
				{
					logEvent("pass", "First Name is Entered as :"+fname);
				}else
				{
					logEvent("fail", "Unable to enter first name");
				}
				
				
				//enter lastname	
				String lname=getdata("RegisterUser", "LastName", 1);
				status=clickAndSendData(txt_lastname, lname);
				if(status)
				{
					logEvent("pass", "Last Name is Entered as :"+lname);
				}else
				{
					logEvent("fail", "Unable to enter last name");
				}
				
				//verify email prefill	
				String prefillemail=txt_email.getAttribute("value").trim();
				if(prefillemail.equals(emailid))
				{
					logEvent("pass", "Email is prefilled as "+emailid);
				}else
				{
					logEvent("fail", "Email is not prefilled as "+emailid);
				}
				
				//enter pasword	
				String password=getdata("RegisterUser", "password", 1);
				status=clickAndSendData(txt_password, password);
				if(status)
				{
					logEvent("pass", "Password is Entered as :"+password);
				}else
				{
					logEvent("fail", "Password is not Entered as :"+password);
				}
				
				
				//select dateofbirth
				String day=getdata("RegisterUser", "Days", 1);
				status=selectDropDOwn(slct_DOB_days, day);
				if(status)
				{
					logEvent("pass", "Day is selected as :"+day);
				}else
				{
					logEvent("fail", "Day is selected as :"+day);
				}
				
				
				//select month
				String month=getdata("RegisterUser", "Months", 1);
				status=selectDropDOwn(slct_DOB_months, month);
				if(status)
				{
					logEvent("pass", "Month is selected as :"+month);
				}else
				{
					logEvent("fail", "Month is selected as :"+month);
				}
				
				//select Year
				String year=getdata("RegisterUser", "Years", 1);
				status=selectDropDOwn(slct_DOB_years, year);
				if(status)
				{
					logEvent("pass", "Year is selected as :"+year);
				}else
				{
					logEvent("fail", "Year is selected as :"+year);
				}
				
				// Adress Section
				
				//enter firstname	
				String afname=getdata("RegisterUser", "Address_FirstName", 1);
				status=clickAndSendData(txt_Address_firstname, afname);
				if(status)
				{
					logEvent("pass", "Address firstname is Entered as :"+afname);
				}else
				{
					logEvent("fail", "Address firstname is not Entered as :"+afname);
				}
				
				//enter lastname	
				String alname=getdata("RegisterUser", "Address_LastName", 1);
				status=clickAndSendData(txt_Address_lasttname, alname);
				if(status)
				{
					logEvent("pass", "Address Lastname is Entered as :"+alname);
				}else
				{
					logEvent("fail", "Address Lastname is not Entered as :"+alname);
				}
				
				
				

				//enter address1	
				String address1=getdata("RegisterUser", "Address1", 1);
				status=clickAndSendData(txt_Address_Address1, address1);
				if(status)
				{
					logEvent("pass", "Address1  is Entered as :"+address1);
				}else
				{
					logEvent("fail", "Address1  is not Entered as :"+address1);
				}
				
				//enter address2	
				String address2=getdata("RegisterUser", "Address2", 1);
				status=clickAndSendData(txt_Address_Address2, address2);
				if(status)
				{
					logEvent("pass", "Address1  is Entered as :"+address2);
				}else
				{
					logEvent("fail", "Address1  is not Entered as :"+address2);
				}
				
				//enter City	
				String city=getdata("RegisterUser", "City", 1);
				status=clickAndSendData(txt_Address_city, city);
				if(status)
				{
					logEvent("pass", "City  is Entered as :"+city);
				}else
				{
					logEvent("fail", "City  is not Entered as :"+city);
				}
				
				
				//select state
				String state=getdata("RegisterUser", "State", 1);
				status=selectDropDOwn(slct_Address_state, state);
				if(status)
				{
					logEvent("pass", "State is selected as :"+state);
				}else
				{
					logEvent("fail", "State not is selected as :"+state);
				}
				
				
				//enter ZIP	
				String zip=getdata("RegisterUser", "ZipCode", 1);
				status=clickAndSendData(slct_Address_zip, zip);
				if(status)
				{
					logEvent("pass", "ZIP  is Entered as :"+zip);
				}else
				{
					logEvent("fail", "ZIP  is not Entered as :"+zip);
				}
				
				
				
				
				//select Country
				String country=getdata("RegisterUser", "Country", 1);
				status=selectDropDOwn(slct_Address_country, country);
				if(status)
				{
					logEvent("pass", "Country is selected as :"+country);
				}else
				{
					logEvent("fail", "Country is not selected as :"+country);
				}
				
				
				//enter Mobile	
				String mobile=getdata("RegisterUser", "Mobile", 1);
				status=clickAndSendData(txt_Address_mobilenumber, mobile);
				if(status)
				{
					logEvent("pass", "Mobile  is Entered as :"+mobile);
				}else
				{
					logEvent("fail", "Mobile  is not Entered as :"+mobile);
				}
				

				//enter Alias
				String alis=getdata("RegisterUser", "Alias", 1);
				status=clickAndSendData(txt_Address_aliasAddress, alis);
				if(status)
				{
					logEvent("pass", "Alias  is Entered as :"+alis);
				}else
				{
					logEvent("fail", "Alias  is not Entered as :"+alis);
				}
				
				
				//click register
				status=hoverAndClick(btn_Register);
				if(status)
				{
					logEvent("pass", "Register button is clicked sucessfully");
				}else
				{
					logEvent("fail",  "Register button is clicked sucessfully");
				}
				
				
			}
			catch(Exception e)
			{
				
			}
			return status;
		}


public boolean logout()
{
	boolean status=true;
	
	try
	{
		status=hoverAndClick(lnk_Signout);
		if(status)
		{
			logEvent("Pass", "Signout Link is clicked sucessfully");
		}else
		{
			logEvent("Fail", "Signout Link is not clicked sucessfully");
		}
	}catch(Exception e)
	{status=false;
		logEvent("Fail", e.getMessage());
	}
	return status;
}

public boolean login_AlreadyRegisterd()
{
	boolean status=true;
	
	try
	{
		status=clickAndSendData(txt_email, emailid);
		
		if(status)
		{
			logEvent("Pass", "Email id entered sucessfully "+emailid);
			
			String password=getdata("RegisterUser", "password", 1);
			status=clickAndSendData(txt_password, password);
			
			if(status)
			{
				btn_submitlogin.click();
			}
			
		}else
		{
			logEvent("Fail", "Email id not entered sucessfully ");
		}
	}catch(Exception e)
	{status=false;
		logEvent("Fail", e.getMessage());
	}
	return status;
}





}
