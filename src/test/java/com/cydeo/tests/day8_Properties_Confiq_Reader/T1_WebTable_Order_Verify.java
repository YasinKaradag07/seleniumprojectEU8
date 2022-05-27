package com.cydeo.tests.day8_Properties_Confiq_Reader;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_name_verify_test(){
        WebElement bobMertinCell = driver.findElement(By.xpath
                ("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[.='Bob Martin']"));
        System.out.println("bobMertinCell.getText() = " + bobMertinCell.getText());
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMertinCell.getText();

        Assert.assertEquals(actualBobName,expectedBobName);

        // alternative locator to bobMartinDateCell = "//td[.='Bob Martin']/../td[5]"
        WebElement bobMertinDateCell = driver.findElement(By.xpath
                ("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedBobDate = "12/31/2021";
        String actualBobDate = bobMertinDateCell.getText();

        Assert.assertEquals(actualBobDate,expectedBobDate);

        driver.close();

    }


}
/*
TC #1: Web table practice
1. Goto:https://practice.cydeo.com/web-tables
2. VerifyBob’snameislistedasexpected.
Expected: “Bob Martin”
3. VerifyBobMartin’sorderdateisasexpected
Expected: 12/31/2021
 */