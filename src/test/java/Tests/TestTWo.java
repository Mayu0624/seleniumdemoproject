package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseClass;

public class TestTWo extends BaseClass {
	
	public WebDriver driver;
	@Test

	public void testwto() throws IOException, InterruptedException 
	{
		System.out.println("testtwo");
		
	 driver = initializeDriver();
		
		driver.get("http://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		driver.close();
	}

}
