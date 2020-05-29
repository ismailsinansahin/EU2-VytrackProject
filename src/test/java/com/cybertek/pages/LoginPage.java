package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement logInButton;

    public void logInAsADriver(){
        BrowserUtils.waitFor(1);
        String username = ConfigurationReader.get("driverUsername");
        String password = ConfigurationReader.get("driverPassword");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInButton.click();
    }

    public void logInAsASalesManager(){
        BrowserUtils.waitFor(1);
        String username = ConfigurationReader.get("salesmanagerUsername");
        String password = ConfigurationReader.get("salesmanagerPassword");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInButton.click();
    }

    public void logInAsAStoreManager(){
        BrowserUtils.waitFor(1);
        String username = ConfigurationReader.get("storemanagerUsername");
        String password = ConfigurationReader.get("storemanagerPassword");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInButton.click();
    }

}
