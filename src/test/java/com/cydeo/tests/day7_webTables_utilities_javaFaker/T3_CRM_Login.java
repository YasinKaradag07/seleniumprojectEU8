package com.cydeo.tests.day7_webTables_utilities_javaFaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_Login {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void crm_login_test(){
        driver.get("http://login1.nextbasecrm.com/");
        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("helpdesk1@cybertekschool.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        BrowserUtils.verifyTitle(driver,"Portal");

        driver.close();
    }
}
/*
TC #3: Login scenario
1. Createnewtestandmakesetups
2. Goto:http://login1.nextbasecrm.com/
3. Entervalidusername
4. Entervalidpassword
5. Clickto`LogIn`button
6. Verifytitleisasexpected:
 Expected: Portal

USERNAME
helpdesk1@cybertekschool.com
Helpdesk2@cybertekschool.com
PASSWORD
UserUser
UserUser

 */