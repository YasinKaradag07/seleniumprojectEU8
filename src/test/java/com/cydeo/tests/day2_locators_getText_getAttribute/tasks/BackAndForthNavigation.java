package com.cydeo.tests.day2_locators_getText_getAttribute.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForthNavigation {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.className("gb_d")).click();
        String actualTitle = driver.getTitle();
        //String expectedTitle = "Gmail";
        if(actualTitle.contains("Gmail")){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
        Thread.sleep(2000);
        driver.navigate().back();

        if(driver.getTitle().equals("Google")){
            System.out.println("Gmail Title verification PASSED!");
        }else{
            System.out.println("Google Title verification FAILED!");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
/*
TC #3: Back and forth navigation 1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right. 4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back(); 6- Verify title equals:
Expected: Google
 */