package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistrationTest extends BaseClass
{
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("*****Starting TC01_AccountRegistrationTest *****");
		logger.debug("this is a debug log message");
		try
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			
			hp.clickRegister();
			logger.info("Clicked on Register Link.. ");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			logger.info("Providing customer details...");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
			regpage.setTelephone(randomeNumber());
			
			String password=randomeAlphaNumberic();
			
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			logger.info("Validating expected message..");
			
			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

			logger.info("Test passed");
		}
		catch(Exception e)
		{
			logger.error("Test failed:"+e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		}
		finally 
		{
		logger.info("***** Finished TC01_AccountRegistrationTest *****");
		}
	}

}
