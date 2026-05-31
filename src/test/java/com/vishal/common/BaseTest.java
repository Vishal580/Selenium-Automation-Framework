package com.vishal.common;

import com.vishal.constants.FrameworkConstants;
import com.vishal.driver.DriverManager;
import com.vishal.driver.TargetFactory;
import com.vishal.helpers.PropertiesHelpers;
import com.vishal.keywords.WebUI;
import com.vishal.listeners.TestListener;
import com.vishal.projects.cms.CommonPageCMS;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest extends CommonPageCMS {

   @Parameters("BROWSER")
   @BeforeMethod
   public void createDriver(@Optional("chrome") String browser) {
      WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
      if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
         driver.manage().window().setSize(new Dimension(1920, 1080)); // ép Selenium resize
         System.out.println("Actual window size: " + driver.manage().window().getSize());
      } else {
         driver.manage().window().maximize();
      }
      DriverManager.setDriver(driver);
   }

   @AfterMethod(alwaysRun = true)
   public void closeDriver() {
      WebUI.stopSoftAssertAll();
      DriverManager.quit();
   }

   public WebDriver createBrowser(@Optional("chrome") String browser) {
      PropertiesHelpers.loadAllFiles();
      WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
      if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
         driver.manage().window().setSize(new Dimension(1920, 1080)); // ép Selenium resize
         System.out.println("Actual window size: " + driver.manage().window().getSize());
      } else {
         driver.manage().window().maximize();
      }
      DriverManager.setDriver(driver);
      return DriverManager.getDriver();
   }

}
