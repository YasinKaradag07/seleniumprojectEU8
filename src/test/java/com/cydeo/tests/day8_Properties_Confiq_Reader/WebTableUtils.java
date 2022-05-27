package com.cydeo.tests.day8_Properties_Confiq_Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableUtils {

    public static String returnOrderDate(WebDriver driver, String customerName){
        String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";
        WebElement customerDateCell = driver.findElement(By.xpath(locator));
        return customerDateCell.getText();
    }


}
/*
// alternative locator to bobMartinDateCell = "//td[.='Bob Martin']/../td[5]"
 */