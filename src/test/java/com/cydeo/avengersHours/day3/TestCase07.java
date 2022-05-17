package com.cydeo.avengersHours.day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase07 {

    WebDriver driver; // Declare your variable global
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome"); // initialize your variable
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void Test1() {
        driver.get("http://automationexercise.com");

        // Verify that home page is visible successfully : What they mean? --> Verify that you have Hope Page URL and Title, another option verify that test cases button is displayed
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        // verify Title
        Assert.assertEquals(actualTitle, expectedTitle, "Home Page is NOT displayed");
    }
}

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com/'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
     */
