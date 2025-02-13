package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    public WebDriver driver;
    // Constructor
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }
}

