package testCases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		
		logger.info("*****Starting TC003_LoginDDT******");
		try {
		//HomePage
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		/* data is valid --login Success--test pass--logout
		 * data is valid---login failed ---test fail
		 * 
		 * data is invalid ---login success---test fail--logout
		 * data is invalid--login failed ---test pass
		 */
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				hp.clickMyAccount();
				macc.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
				
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				hp.clickMyAccount();
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		}catch(Exception e)
		{
			Assert.fail();
			
		}
		logger.info("****TC003_LoginDDT Test is finished*****") ;
		
		
	}
	
	

}
