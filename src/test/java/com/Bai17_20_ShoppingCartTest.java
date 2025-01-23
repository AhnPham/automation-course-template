package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.utils.BasicTest;
import com.Bai16_LoginTestPOM;


public class Bai17_20_ShoppingCartTest extends BasicTest {
    @Test()
    public void shoppingCartTest() throws Exception {
        Wait<WebDriver> wait = new WebDriverWait(driver, 3);

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // Login
        Bai16_LoginTestPOM login = new Bai16_LoginTestPOM();
        login.loginTestSuccess();
        // Search with keyword "merc"
        WebElement searchInput = driver.findElement(By.xpath("(//input[@id = 's'])[1]"));
        searchInput.sendKeys("merc");
        wait.until(ExpectedConditions.visibilityOf(searchInput));
    
        // Select the first result "Bơm nước xe"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Bơm nước xe')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Bơm nước xe')]")).click();

        // Select option "England"
        WebElement select = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']"));
        wait.until(ExpectedConditions.elementToBeClickable(select)).click();
        WebElement option = driver.findElement(By.xpath("//option[@value='england']"));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

        // Click "Thêm vào giỏ hàng" button
        WebElement addToCart = driver.findElement(By.xpath("(//button[@type = 'submit'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

        // Verify item added to cart using Assert method
        WebElement productName = driver.findElement(By.xpath("//td[@class = 'product-name']"));
        wait.until(ExpectedConditions.visibilityOf(productName));
        Assert.assertEquals(productName.isDisplayed(), true);
        }
 }
