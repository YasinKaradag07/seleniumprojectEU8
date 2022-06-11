package com.cydeo.tests.additionalTasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ETSTask {

    // go to sign up on home page, click, and click terms and conditions check box.
    @Test
    public void check_box_test(){
        Driver.getDriver().get("https://www.etstur.com/Erken-Rezervasyon-Otelleri?gclid=" +
                "CjwKCAjwkYGVBhArEiwA4sZLuAqydYVBjpndcqLNo982FFnoIbESKJjS4TbbcCd3wMths2dMRmVXYBoCDaUQAvD_BwE&gclsrc=aw.ds");
        WebElement dropButton = Driver.getDriver().findElement(By.xpath("//div[@class='dropbtn nothidden']"));
        dropButton.click();

        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-outline-primary'])[2]"));
        signUpButton.click();

/*
        WebElement checkBox = Driver.getDriver().findElement(By.cssSelector("#signupForm > div > div:nth-child(7) > div > label"));
        checkBox.click();
        BrowserUtils.sleep(3);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.cssSelector("#signupForm > div > div:nth-child(7) > div > label"))).perform();

        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//label[@for='cb-termPrivacy']"));
        checkBox.click();
*/

        String cssPath = "#cb-termPrivacy";
        ((JavascriptExecutor)Driver.getDriver()).executeScript("document.querySelector(arguments[0],':before').click();",cssPath);

    }
}
