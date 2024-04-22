package testcase;

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

public class Playback extends BaseTest{

@Test
public static void launch() throws InterruptedException {
	/*
	 *  Verify Playback - Navigate to the Videos page by clicking on Video link from top Menu on Homepage - 
	 *  Choose any video - Validate ads are played before the video starts [most of the cases] - 
	 *  Validate play and pause events for the player
	 */
	
       driver.findElement(By.xpath(locator.getProperty("menuVideo"))).click();
       System.out.println("Vedio window is opened");  
       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       driver.findElement(By.xpath(locator.getProperty("firstVideo"))).click();
     

        String firstWindowHandle = driver.getWindowHandle();

    	 Set<String> allWindowHandles = driver.getWindowHandles();

         // Loop through the handles and switch to the new window
         for (String windowHandle : allWindowHandles) {
             if (!windowHandle.equals(firstWindowHandle)) {
                 driver.switchTo().window(windowHandle);
                 break;
             }
         }
  System.out.println("titele "+driver.getTitle()+" -- "+driver.getCurrentUrl());
	
  JavascriptExecutor js = (JavascriptExecutor) driver;
  js.executeScript("window.scrollBy(0,250)", "");

  
  driver.findElement(By.xpath(locator.getProperty("playicon"))).click();
  Thread.sleep(5000);
  Actions actions = new Actions(driver);
  actions.moveToLocation(500, 300).perform();
  
WebElement surfer = driver.findElement(By.xpath(locator.getProperty("playbackSurfer")));

Assert.assertEquals(surfer.isDisplayed(), true,"Surfer not displayed..!!");

actions.moveToLocation(500, 300).doubleClick().perform();

WebElement playbackPauseIcon = driver.findElement(By.xpath(locator.getProperty("playbackPauseIcon")));
Assert.assertEquals(playbackPauseIcon.isDisplayed(), true,"Puse icon not seen");
  
	}

}
