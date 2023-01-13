package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.Loginpage;
import pageobjects.RegisterPage;
import resources.BaseClass;

public class LoginTest extends BaseClass {
	
	 public WebDriver driver;
	Logger log;
	
	
	@Test(dataProvider ="getlogindata")
	public void login (String email,String password , String Expectedstatus ) throws IOException, Exception 
	{
		
		LandingPage landingpage = new LandingPage(driver);
		landingpage.myaccountdropdown().click();
		log.debug("Clicked on My Account dropdown");
		//landingpage.registeroption().click();
		landingpage.loginOption().click();
		log.debug("Clicked on login option");
		
		Thread.sleep(3000);
		
		/*RegisterPage registerpage = new RegisterPage(driver);
		registerpage.firstnamefield().sendKeys("mayur");
		registerpage.lastnamefield().sendKeys("chaudhari");
		registerpage.emailfield().sendKeys("mayureshchaudhari205@gmail.com");
		registerpage.telephonefield().sendKeys("9168988068");
		registerpage.passwordfield().sendKeys("mayur205");
		registerpage.confirmpasswordfield().sendKeys("mayur205");
		registerpage.tandccheckboxbutton().click();
		registerpage.continueregisterbutton().click();*/
		
		Loginpage loginPage = new Loginpage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");
		
		AccountPage accountpage = new AccountPage (driver);
		
		String actualresult = null;
		
		try {
			
			 if(accountpage.editYourAccountInformation().isDisplayed())
				 log.debug("User got logged in");
				 actualresult = "Successful";
				 
				
		}
		catch(Exception e){
			log.debug("User didn't log in");
			actualresult = "Failure";
		}
	   Assert.assertEquals(actualresult,Expectedstatus);
	   log.info("Login Test got passed");
	   }
	
	@BeforeMethod
	public void openapplication() throws Exception {
		
		 log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}
	@AfterMethod
	public void closure()
	{
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider
	public Object[][] getlogindata()
	{
		Object[][] data = {{"mayureshchaudhari205@gmail.com","mayur205","Successful"},{"mayu@gmail.com","mayu0624","Failure"}};
	    return data;
	}
}
