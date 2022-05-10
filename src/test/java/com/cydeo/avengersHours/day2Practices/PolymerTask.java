package com.cydeo.avengersHours.day2Practices;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class PolymerTask {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

    }
}
/*
Write a basic browser automation framework to validate a Polymer website.
The focus should be on the interaction with the browser.
The Web Application under test http://todomvc.com/
    The first step should be to load the website,
    click within the JavaScript tab,
    and select the Polymer link.
    The second step should be: Add one Todo item
    Then Verify that the item added.
 */