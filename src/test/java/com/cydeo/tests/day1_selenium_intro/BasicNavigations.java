package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //1- Set up the browser driver
        WebDriverManager.chromedriver().setup();

        //2- Create instance of the Selenium WebDriver
        WebDriver driver = new ChromeDriver();

        //3- Go to tesla.com
        driver.get("https://www.tesla.com");

        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //4- Stop code execution for 3 seconds
        Thread.sleep(3000);

        //5- Use selenium to navigate back
        driver.navigate().back();

        //6- Go to tesla.com again
        driver.get("https://www.tesla.com");

        //7- Stop code execution for 3 seconds again
        Thread.sleep(3000);

        //8- Use selenium to navigate refresh
        driver.navigate().refresh();

        //9- Stop code execution for 3 seconds
        Thread.sleep(3000);

        //10- Use navigate().to():
        driver.navigate().to("https://www.google.com");

        //get the title of the page
        //System.out.println("driver.getTitle(): "+driver.getTitle());
        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

    }
}
