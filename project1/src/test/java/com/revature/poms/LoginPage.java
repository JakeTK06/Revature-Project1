package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "usernameInput")
    private WebElement usernameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(tagName = "input")
    private WebElement loginButton;

    @FindBy(tagName = "a")
    private WebElement registrationLink;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setupLoggedInUser(){
        driver.get("http://localhost:8080/");
        usernameInput.sendKeys("Batman");
        passwordInput.sendKeys("Iamthenight1939");
        loginButton.submit();
    }

    public void openLoginPage(){
        driver.get("http://localhost:8080/");
    }

    public void setUsernameInput(String username){
        usernameInput.sendKeys(username);
    }

    public void setPasswordInput(String password){
        passwordInput.sendKeys(password);
    }

    public void submitCredentials(){
        loginButton.submit();
    }

    public void clickRegistrationLink(){
        registrationLink.click();
    }
}
