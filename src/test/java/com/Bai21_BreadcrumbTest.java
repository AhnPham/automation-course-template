package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.utils.BasicTest;


public class Bai21_BreadcrumbTest extends BasicTest {
    @Test()
    public void breadcrumbTest() throws Exception {
        Wait<WebDriver> wait = new WebDriverWait(driver, 3);

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        // Hover to Hệ thống truyền động, Khung gầm -> Hệ thống phanh using Action Class methods
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//li[@id=\"menu-item-347\"]"))).perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@id=\"menu-item-347\"]"))));
        // Choose Phanh tay oto
        action.moveToElement(driver.findElement(By.xpath("//li[@id=\"menu-item-465\"]"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id=\"menu-item-465\"]")));
        driver.findElement(By.xpath("//a[text()='Phanh tay ô tô']")).click();

        // Verify the breadcrumb is visible
        Boolean showBreadbrum = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']")).getText().contains("Phanh tay ô tô");
        Assert.assertTrue(showBreadbrum, "Breadcrumb is not visible");
        }
 }

