package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.cydeo.utilities.BrowserUtils.sleep;

public class T2_BasicLoginAuthentication {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String expectedTitleBeforeLogin = "Web Orders Login";

        if(expectedTitleBeforeLogin.equals(driver.getTitle())){
            System.out.println("Success");
        }else{
            System.exit(-1);
        }

        WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement signInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));

        userNameBox.sendKeys("Tester");
        passwordBox.sendKeys("test");
        signInButton.click();

        String expectedHomePageTitle = "Web Orders";
        if(expectedHomePageTitle.equals(driver.getTitle())){
            System.out.println("Passed!");
        }else{
            System.exit(-1);
        }

        sleep(2);
        driver.close();

    }
}
/*
Basic login authentication
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Verify title equals: String expectedTitle = "Web Orders Login"
- Enter username: Tester
- Enter password: test
- Click “Sign In” button
- Verify title equals: String expectedHomePageTitle = "Web Orders"
 */