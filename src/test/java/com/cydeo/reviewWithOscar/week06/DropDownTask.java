package com.cydeo.reviewWithOscar.week06;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTask {

    @Test
    public void Task03() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

        // click on order
        Driver.getDriver().findElement(By.linkText("Order")).click();

        /*
        How do we use select class methods:
        1. Dropdown should have select tag
        2. Find locator for dropdown
        3. Create select class object by passing located web element as constructor parameter
         */
        WebElement dropDownElement = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select dropDown = new Select(dropDownElement);
        // selected option should be "mymoney" when you cllick Order button: getFirstselectedOption method
        String expectedValue = "MyMoney";
        String actualValue = dropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualValue,expectedValue,"Default Option Test Failed");

        // select family album
        dropDown.selectByVisibleText("FamilyAlbum");
        ReviewUtils.staticWait(2);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"FamilyAlbum");

    }

}
/*
Task3:
    1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    2. Login with username: Tester, password: test
    3. Click  Order button
    4. Verify under Product Information, selected option is “MyMoney”
    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
    6. Then verify Total is equal to Quantity*PricePerUnit
 */