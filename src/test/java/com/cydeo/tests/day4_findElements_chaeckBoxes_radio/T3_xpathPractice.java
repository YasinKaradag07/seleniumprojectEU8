package com.cydeo.tests.day4_findElements_chaeckBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_xpathPractice {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/multiple_buttons");
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        if(actualResult.equals("Clicked on button one!")){
            System.out.println("Result is as expected, test PASSED!");
        }else{
            System.out.println("Result is wrong, Test FAILED!");
        }

        driver.quit();

    }
}
/*
XPATH Practice
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #6:  XPATH LOCATOR practice
1. Open Chrome browser
2. Go to http://practice.cydeo.com/multiple_buttons
3. Click on Button 1
4. Verify text displayed is as expected:
Expected: “Clicked on button one!”

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

 */