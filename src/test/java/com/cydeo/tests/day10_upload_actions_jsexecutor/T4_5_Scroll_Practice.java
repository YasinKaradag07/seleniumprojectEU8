package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_5_Scroll_Practice {

    @Test
    public void scrollDown_practice_test1() {
        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");
        BrowserUtils.sleep(2);


        //3- Scroll down to “Powered by CYDEO”
        //4- Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());
        WebElement poweredByCydeo = Driver.getDriver().findElement(By.xpath("//div[@id='page-footer']/div/div[1]"));
        actions.moveToElement(poweredByCydeo).perform();
        BrowserUtils.sleep(2);


        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        // 2- Scroll back up to “Home” link using PageUP button
        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']"));
        actions.moveToElement(homeLink).perform();
    }


}
