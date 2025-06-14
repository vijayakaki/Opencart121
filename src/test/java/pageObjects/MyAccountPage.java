package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement lnkLogout;
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return (msgHeading.isDisplayed());
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout() throws InterruptedException
	{
		
		lnkLogout.click();
		Thread.sleep(5000);
	}
	

}
