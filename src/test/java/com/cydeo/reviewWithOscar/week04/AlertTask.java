package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTask {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.demoblaze.com/index.html");
    }

    @Test
    public void alertTask(){

        ReviewUtils.getLink(driver,"Laptops");
        ReviewUtils.getLink(driver,"Sony vaio i5");
        ReviewUtils.getLink(driver,"Add to cart");

        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.close();
    }


}

 /*
    You have to implement the following Web automated checks over our DEMO ONLINE SHOP:
     https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
     */
