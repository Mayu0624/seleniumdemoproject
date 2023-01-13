package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstnamefield;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastnamefield;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailfield;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephonefield;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmpasswordfield;
	
	@FindBy(css="input[type='checkbox']")
	private WebElement tandccheckboxbutton;
	
	@FindBy(css="input[value='Continue']")
	private WebElement continueregisterbutton;
	
	public WebElement firstnamefield()
	{
		return firstnamefield;
	}
	public WebElement lastnamefield()
	{
		return lastnamefield;
		
	}
	public WebElement emailfield()
	{
		return emailfield;
		
	}
	public WebElement telephonefield()
	{
		return telephonefield;
     }
	public WebElement passwordfield()
	{
		return passwordfield;
	}
	public WebElement confirmpasswordfield()
	{
		return confirmpasswordfield;
	}
	public WebElement tandccheckboxbutton()
	{
		return tandccheckboxbutton;
	}
	public WebElement continueregisterbutton()
	{
		return continueregisterbutton;
	}
}
