package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class LoginPageFactory extends BasePage{
    public WebDriver driver;
    // Constructor
    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath= "//input[@id='username']")
    private WebElement emailInput;

    @FindBy(xpath ="//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement submitButton;

    public LoginPageFactory fillEmail(String string) {
        emailInput.clear();
        emailInput.sendKeys(string);

        return this;
    }
    public LoginPageFactory fillPassword(String string) {
        passwordInput.clear();
        passwordInput.sendKeys(string);

        return this;
    }
    public LoginPageFactory clickSubmit() {
        submitButton.click();

        return this;
    } 
}
