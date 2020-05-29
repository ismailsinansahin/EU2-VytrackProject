package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectOwnerPage extends BasePage {

    @FindBy(xpath = "//span[@class='caret'][@xpath='1']")
    public WebElement viewPerPage;

    @FindBy(xpath = "//a[@data-size='100']")
    public WebElement viewPerPage100;



}
