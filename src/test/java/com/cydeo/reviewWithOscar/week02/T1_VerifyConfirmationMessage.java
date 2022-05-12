package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_VerifyConfirmationMessage {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/");

        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();

        WebElement emailBox = driver.findElement(By.name("email"));
        String expectedEmail = "mike.smith@garbage.com";
        emailBox.sendKeys(expectedEmail);

        String actualEmail = emailBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        if(actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("Email verification PASSED!");
        }else{
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("Email verification FAILED!");
        }

        //driver.findElement(By.id("form_submit")).click();
        //driver.findElement(By.cssSelector("#form_submit")).click();
        //driver.findElement(By.tagName("//button")).click();

        driver.findElement(By.xpath("//i[contains(text(),'Retrieve')]")).click();

        HandleWait.staticWait(1);

        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = driver.findElement(By.name("confirmation_message")).getText();

        driver.close();


    }
}
/*
Task 1:
 Verify confirmation message
        open chrome browser
        go to https://practice.cydeo.com/forgot_password
        then click on "forgot_password" link
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'
 */