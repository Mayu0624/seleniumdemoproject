package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver () throws IOException 
	{
		WebDriver driver = null;
		
		 prop = new Properties();
		String propath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		
		FileInputStream fis = new FileInputStream(propath);
		
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		
		if (browsername.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
		    driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

     public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		
		return destinationFilePath;
	
	}

}
