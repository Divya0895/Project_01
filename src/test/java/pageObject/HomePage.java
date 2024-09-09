package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//span[normalize-space()='My Account']")  WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")WebElement lnkRegister;
	@FindBy(linkText = "Login")   WebElement linkLogin;   // Login link added in step5
	@FindBy(xpath="//input[@placeholder='Search']") 	WebElement txtSearchbox;  //For Search Product Test
	@FindBy(xpath="//div[@id='search']//button[@type='button']") WebElement btnSearch; //For Search Product Test
	
  public void clickMyAccount()
  {
	  lnkMyaccount.click();
  }
  public void clickRegister()
  {
	  lnkRegister.click();
  }
  public void clickLogin ()
  {
	  linkLogin.click();
  }
  public void enterProductName(String pName)  //for search product test
  {
	  txtSearchbox.sendKeys(pName);
  }
  public void clickSearch()  //for search product test
  {
	  btnSearch.click();
  }

}
