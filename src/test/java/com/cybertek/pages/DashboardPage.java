package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

    @FindBy(id = "main-menu")
    public WebElement modulesBar;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement DashboardTitle;

}
