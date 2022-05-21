package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static com.cydeo.utilities.BrowserUtils.sleep;

public class WindowHandlingTask {

    @Test
    public void windowsTest(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://shino.de/parkcalc/");
// click on first calendar
        driver.findElement(By.xpath("(//img[@src='cal.gif'])[1]")).click();


        // get all the opened windows handles
        Set<String> windowHandles = driver.getWindowHandles();

        //   System.out.println("windowHandles = " + windowHandles);

        // get your current windowHandle
        String mainWindowHandle = driver.getWindowHandle();

        // to switch to window which we are NOT at
        for (String eachWindowHandle : windowHandles) {
            if(!eachWindowHandle.equals(mainWindowHandle)){
                driver.switchTo().window(eachWindowHandle);
            }
        }

//        String mainWindowHandle = driver.getWindowHandle();
//        ReviewUtils.windowHandle(driver,"Pick a Date");

        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        System.out.println("title = " + title);

        // click on the element at the second window
        driver.findElement(By.linkText("24")).click(); // the window closes itself, however I am still inside that closed window programatically
        sleep(3);
        driver.switchTo().window(mainWindowHandle);

        // select PM from the page
        WebElement pmButton = driver.findElement(By.xpath("(//input[@name='StartingTimeAMPM'])[2]"));
        pmButton.click();

        Assert.assertTrue(pmButton.isSelected());

        sleep(3);

        driver.quit();



    }
}
 /*
    automate the following scenarios for this website https://shino.de/parkcalc/
Scenario 1)
-  Using the Valet parking lot, set today as the entry date & time and tomorrow as the exit giving
a full 24 hours window (you can attempt to use the DatePicker).
     */