package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Dashboard extends GenericFunctions {
	
	//**************************** Dashboard *************************
	
	@FindBy(how=How.XPATH,using="//b[text()='Dashboard']")
	
	public static WebElement Menu_Dasboard;
	
	@FindBy(how=How.XPATH,using="//span[text()='Apply Leave']")
	
	public static WebElement icon_ApplyLeave;
	
	
	public static boolean navigateToApplyLeave()
	{
		boolean status=true;
		
		
			
				
			
			status=hoverAndClick(Menu_Dasboard);
			
			if(status)
			{
				System.out.println("DashBorad is clicked successfully");
				status=hoverAndClick(icon_ApplyLeave);
				
				
				if(status)
				{
					System.out.println("Apply Leave is clicked successfully");
					
				}
				else
				{
					System.out.println("Apply Leave is not clicked successfully");
					status=false;
				}
				
				
			}
			else
			{
				System.out.println("DashBorad is not clicked successfully");
				status=false;
			}
			
			return status;
			
		}
		
	
	
	

}
