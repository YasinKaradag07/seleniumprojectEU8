package com.cydeo.reviewWithOscar.week06;

import com.cydeo.reviewWithOscar.week06.pomForReview.ContactUsPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task06 {

    @Test
    public void Test(){
        Driver.getDriver().get("http://automationexercise.com/");

        // Create object so that you can use elements and methods
        ContactUsPage page = new ContactUsPage();
        // click contact us
        //page.contactUs.click();
        page.getElement("Contact us").click();

        // for scrolling test cases
        // create actions object
        // first way
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        ReviewUtils.staticWait(2);
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
        ReviewUtils.staticWait(2);
        // second way
        actions.moveToElement(page.submit).perform();
        // third way
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0, 750)");
        ReviewUtils.staticWait(1);
        jse.executeScript("window.scrollBy(0, -750)");
        ReviewUtils.staticWait(1);
        // last way
        jse.executeScript("arguments[0].scrollIntoView(true)",page.submit);
        ReviewUtils.staticWait(2);


        Faker faker = new Faker();
        page.name.sendKeys(faker.name().fullName());
        page.email.sendKeys(faker.internet().emailAddress());
        page.subject.sendKeys(faker.chuckNorris().fact());
        page.message.sendKeys(faker.howIMetYourMother().catchPhrase());

        String path = "/Users/yasinkaradag/Desktop/EU8_Review_Week_Optional_Tasks.docx";

        // to upload file use sendkeys method and provide path of the file as parameter
        page.uploadFile.sendKeys(path);
        page.submit.click();

        // we get JS Alert
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        String expectedValue = "Success! Your details have been submitted successfully.";
        String actualValue = page.success.getText();

        Assert.assertEquals(actualValue,expectedValue,"Message Test Failed!");

    }

}
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com/'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
 */