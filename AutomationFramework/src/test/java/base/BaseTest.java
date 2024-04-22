package base;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties locator = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	// This class takecare of system config and browser launch & teardown process	
	// setUp-void :Runs Before each test
	@BeforeTest
	public void setUp() throws Exception {
		
		if (driver==null) {
			System.out.println(System.getProperty("user.dir"));
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\config.properties");
			 fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\locators.properties");
			prop.load(fr);
			locator.load(fr1);
			
		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			  ChromeOptions ops = new ChromeOptions();
	            ops.addArguments("--disable-notifications");

			driver = new ChromeDriver(ops);
			driver.manage().window().maximize();
			 driver.get(prop.getProperty("testUrl"));
	          
			
		}
		
	}
	
	// tearDown-void: Runs After each test
	@AfterTest
	public void tearDown() throws Exception {
		
		driver.quit();
		System.out.println("Teardown Done...!!!");
	}

}
