package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
    //initialize the driver instance and object of the page
    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
