package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");
        WebElement sigInButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        String expectedButtonText = "Log In";
        String actualButtonText = sigInButton.getAttribute("value");
        System.out.println("actualButtonText = " + actualButtonText);

        if(expectedButtonText.equals(actualButtonText)){
            System.out.println("Lod In button verification PASSED!");
        }else{
            System.out.println("Lod In button verification FAILED!");
        }


    }
}
/*
TC #3: NextBaseCRM, locators, getText(), getAttribute() practice 1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
PS: Inspect and decide which locator you should be using to locate web elements.
PS2: Pay attention to where to get the text of this button from
 */