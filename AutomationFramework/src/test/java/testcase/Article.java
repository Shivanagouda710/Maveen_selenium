package testcase;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class Article extends BaseTest{

@Test
public static void launch() throws InterruptedException {
/*
 * Verify Article - Navigate to Latest News by selecting 
 * Sports -> Football -> Latest News on the left hamburger menu on the Homepage - Select any article 
 * Validate Article Title, Description and Hero Image is present
 */
	
       driver.findElement(By.xpath(locator.getProperty("hamburger"))).click();
       System.out.println("Hamburger is selected");  
       driver.findElement(By.xpath(locator.getProperty("submenuFootball"))).click();
//       Below list store footBallSubmenu options
       List<WebElement> ele=driver.findElements(By.xpath((locator.getProperty("footBallSubmenu"))));
       System.out.println(ele.size());
       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
      for(int i=80;i<ele.size();i++) {
    	  System.out.println(i+" --- "+ele.get(i).getText());
    	if (ele.get(i).getText().equalsIgnoreCase("Latest News")) { // Select once Latest News found
    		ele.get(i).click();
			break;
		} 	
      }
//       Below once are validations of Article Title, Description and Hero Image is present or not
      String Title = driver.findElement(By.xpath(locator.getProperty("mainHeadding"))).getText();
      Assert.assertEquals(Title, "LATEST FOOTBALL NEWS","This is not Latest footbal news");
     int numofTitle =  driver.findElements(By.xpath(locator.getProperty("title"))).size();
     System.out.println("numofTitle "+numofTitle);
      Assert.assertEquals(numofTitle>1, true,"No Title on Latest footbal news");
      int numHeroImg =  driver.findElements(By.xpath(locator.getProperty("heroImg"))).size();
      Assert.assertEquals(numHeroImg>1, true,"No Hero image on Latest footbal news");
	}

}
