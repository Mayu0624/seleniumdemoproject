package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.BaseClass;

public class FourTest extends BaseClass {
	
	 public WebDriver driver;
	@Test
	public void testfour() throws IOException, InterruptedException {
		
		System.out.println("testfour");
		  driver = initializeDriver();
			
			driver.get("http://tutorialsninja.com/demo/");
			Thread.sleep(3000);
			
			Assert.assertTrue(false);
			driver.close();
			
	}
	@AfterMethod
	public void closingbrowser(){
		
		driver.close();
		
	}
	

	

}
