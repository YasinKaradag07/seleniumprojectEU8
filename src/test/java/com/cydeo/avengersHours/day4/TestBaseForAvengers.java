package com.cydeo.avengersHours.day4;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBaseForAvengers {

    @BeforeMethod
    public void setUpTestEnvironment(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlExercise"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
