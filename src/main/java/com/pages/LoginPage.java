package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage{
    public WebDriver driver;
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By email = By.xpath("//input[@id='username']");
    By password = By.xpath("//input[@id='password']");
    By submit = By.xpath("//button[@name='login']");

    public void enterEmail(String string) {
        findElement(email).clear();
        findElement(email).sendKeys(string);
    }
    public void enterPassword(String string) {
        findElement(password).clear();
        findElement(password).sendKeys(string);
    }
    public void clickSubmit() {
        findElement(submit).click();
    } 
}
