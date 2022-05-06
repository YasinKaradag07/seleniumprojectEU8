package com.cydeo.reviewWithOscar.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToDemoBlaze {

    public static void main(String[] args) throws InterruptedException {

        // https://www.demoblaze.com/index.html
        //Verify the title

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        String title = driver.getTitle();

        Thread.sleep(5000);
        if(title.equals("STORE")){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!");
        }
        driver.close();


    }
}
