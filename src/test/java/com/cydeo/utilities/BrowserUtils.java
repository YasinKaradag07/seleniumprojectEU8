package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    public static void sleep(int seconds){
        seconds*=1000;
        try{
            Thread.sleep(seconds);
        }catch(InterruptedException e){

        }
    }

    public static void switchWindowAndVerify (WebDriver driver, String expectedUrl, String expectedTitle) {

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: "+driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public static void verifyTitle(WebDriver driver, String expectedTitle) {

        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }



}
