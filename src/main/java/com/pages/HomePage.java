package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage{
    public WebDriver driver;
    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By username = By.xpath("(//strong[contains(text(), 'nhanvip124')][1])");
    By errormessage = By.xpath("//ul[@class='woocommerce-error']");

    public String getUsername() {
        return findElement(username).getText();
    }
    public String errorMessage() {
        return findElement(errormessage).getText();
    }
}
