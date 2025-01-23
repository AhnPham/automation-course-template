package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.utils.BasicTest;
import com.pages.LoginPage;
import com.pages.HomePage;

public class Bai16_LoginTestPOM extends BasicTest {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    
    @Test()
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // // Enter email
        // WebElement email =  driver.findElement (By.xpath("//input[@id='username']"));
        // email.sendKeys("nhanvip124@gmail.com");
        // // Enter password
        // WebElement password =  driver.findElement (By.xpath("//input[@id='password']"));
        // password.sendKeys("P@ssword1235678");
        // // Click submit button
        // WebElement submit = driver.findElement(By.xpath("//button[@name='login']"));
        // submit.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("nhanvip124@gmail.com");
        loginPage.enterPassword("P@ssword1235678");
        loginPage.clickSubmit();
        // Verify successful login
        // WebElement accountName = driver.findElement(By.xpath("(//strong[contains(text(), 'nhanvip124')][1])"));
        // Assert.assertEquals(accountName.getText(), "nhanvip124");
        // Utils.hardWait();
        HomePage homePage = new HomePage(driver);
        homePage.getUsername();
        Assert.assertEquals(homePage.getUsername(), "nhanvip124");
    }
    @Test()
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // // Enter email
        // WebElement email =  driver.findElement (By.xpath("//input[@id='username']"));
        // email.sendKeys("nhanvip124@gmail.com");
        // // Click submit button
        // WebElement submit = driver.findElement(By.xpath("//button[@name='login']"));
        // submit.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("nhanvip124@gmail.com");
        loginPage.clickSubmit();
       // Verify unsuccessful login
    //    WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
    //    String actualErrorMessage = errorMessage.getText(); // Extract text content
    //    String expectedErrorMessage = "Lỗi: Mục nhập mật khẩu trống.";
        HomePage homePage = new HomePage(driver);
        homePage.errorMessage();
        Assert.assertEquals(homePage.errorMessage(), "Lỗi: Mục nhập mật khẩu trống.");
    //    // Compare the actual and expected error messages
    //    Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    //    Utils.hardWait();
   }
 }


