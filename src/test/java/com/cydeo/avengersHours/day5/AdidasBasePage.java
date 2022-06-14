package com.cydeo.avengersHours.day5;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AdidasBasePage {

    public AdidasBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public static void getLink(String link){
        Driver.getDriver().findElement(By.partialLinkText(link)).click();
        ReviewUtils.staticWait(1);
    }

    /*
   public final String str = "Laptops"; // I made it constant
   @FindBy(linkText = str) // it works only with constants
   public WebElement getLinkElement;
   */
    public WebElement getLinkElement(String str){
        return Driver.getDriver().findElement(By.linkText(str));
    }

    @FindBy(xpath = "//a[@class='hrefch']")
    public List<WebElement> products;


}
