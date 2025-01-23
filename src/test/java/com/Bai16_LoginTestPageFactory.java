package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.utils.BasicTest;
import com.pages.LoginPageFactory;
import com.pages.HomePage;

public class Bai16_LoginTestPageFactory extends BasicTest {
    LoginPageFactory LoginPageFactory = new LoginPageFactory(driver);
    HomePage homePage = new HomePage(driver);
    
    @Test()
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        LoginPageFactory LoginPageFactory = new LoginPageFactory(driver);
        LoginPageFactory.fillEmail("nhanvip124@gmail.com").fillPassword("P@ssword1235678").clickSubmit();

        // Verify successful login
        HomePage homePage = new HomePage(driver);
        // homePage.getUsername();
        Assert.assertEquals(homePage.getUsername(), "nhanvip124");
    }
    @Test()
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        LoginPageFactory LoginPageFactory = new LoginPageFactory(driver);
        LoginPageFactory.fillEmail("nhanvip124@gmail.com").clickSubmit();
       // Verify unsuccessful login

        HomePage homePage = new HomePage(driver);
        // homePage.errorMessage();
        Assert.assertEquals(homePage.errorMessage(), "Lỗi: Mục nhập mật khẩu trống.");
   }
 }


