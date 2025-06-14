package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass  {
	
	
	@Test(groups={ "Regression","Master"})
	public void certify_account_registration ()
	{
		logger.info("*****Starting TC001_AccountRegistrationTest******");
		try
		{
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on MyAcount....");
		hp.clickMyAccount();
		logger.info("Clicked on register....");
		hp.clickRegister();
		logger.info("Entering the customer's details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Validating the expected message.....");
		String confmsg = regpage.getConfirmationMsg();
	    Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Account registration failed!");
	    
		}
		catch(Exception e)
		{
			logger.error("Test Failed...");
			logger.debug("Debug logs....");
			Assert.fail();
			
		}
		logger.info("*****Finished TC001_AccountRegistrationTest******");
		
	}
	
}
