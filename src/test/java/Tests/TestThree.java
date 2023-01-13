package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseClass;

public class TestThree extends BaseClass {
	
    public WebDriver driver;
	@Test
	public void testthree() throws IOException, InterruptedException {
		
		System.out.println("testthree");
     driver = initializeDriver();
		
		driver.get("http://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
