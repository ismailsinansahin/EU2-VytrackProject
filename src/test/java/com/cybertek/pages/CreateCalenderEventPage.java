package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateCalenderEventPage extends BasePage{

    @FindBy(xpath = "//a[@class='select2-choice']")
    public WebElement ownerDropdown;

    @FindBy(xpath = "//div[@id='select2-drop']//li")
    public List<WebElement> ownerList;

    @FindBy(xpath = "//div[@class='select2-search']")
    public WebElement ownerInputBox;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[title]']")
    public WebElement title;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[1]")
    public WebElement startDate;

   @FindBy(xpath = "(//input[@placeholder='time'])[1]")
   public WebElement startTime;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[2]")
    public WebElement endDate;

    @FindBy(xpath = "(//input[@placeholder='time'])[2]")
    public WebElement endTime;

//    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
//    public WebElement saveAndClose;

    @FindBy(xpath = "//button[contains(text(),'Save and Close')]")
    public WebElement saveAndClose;

}
