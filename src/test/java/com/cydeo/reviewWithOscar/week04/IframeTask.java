package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.cydeo.utilities.BrowserUtils.sleep;

public class IframeTask {

    @Test
    public void iframeTest(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        driver.switchTo().frame("iframeResult");
        sleep(2);
        WebElement demoElement =    driver.findElement(By.id("demo"));

        String demoText = demoElement.getText();

        System.out.println("demoText = " + demoText);

        driver.close();




    }


}
//1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
//2. Switch to iframe.
//3. Get the text “Double-click me to change my text color.” and verify the text