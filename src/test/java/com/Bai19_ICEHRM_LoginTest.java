package com;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
// import com.utils.Utils;
import com.utils.BasicTest;
import org.testng.annotations.DataProvider; 

public class Bai19_ICEHRM_LoginTest extends BasicTest {
    @DataProvider(name = "testData")
    public Object[][] testDataFeed()  {
        // Create object array
        Object[][] account = new Object[2][3];
        // Enter 2 login account data
            account[0][0] = "admin";
            account[0][1] = "admin";
            account[0][2] = true;

            account[1][0] = "admin";
            account[1][1] = "admin123";
            account[1][2] = false;

        // return arrayobject
        return account;
    }
    public boolean isErrorMessageDisplayed(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            return element.isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
    }

    @Test(enabled = true, dataProvider = "testData", priority = 1)
    public void loginTest(String username, String password, boolean expectedLogin) throws Exception {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "The current URL does not match the expected URL.");

        // Enter username and password
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        // Click login button
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        // Verify error message based on expected login outcome
        Boolean isDisplayed = isErrorMessageDisplayed("//div[@class='alert alert-danger']"); // Update this XPath
        if (expectedLogin) {
            Assert.assertFalse(isDisplayed, "Expected login to succeed, but an error message was displayed.");
        } else {
            Assert.assertTrue(isDisplayed, "Expected login to fail, but no error message was displayed.");
        }
    }
}