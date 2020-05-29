package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventInformationPage {

    @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)[1]")
    public WebElement title;

    @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)[2]")
    public WebElement description;

    @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)[3]")
    public WebElement start;

    @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)[4]")
    public WebElement end;

    @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)[5]")
    public WebElement allDayEvent;

    @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)[6]")
    public WebElement organizer;

    @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)[7]")
    public WebElement guests;

    @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)[8]")
    public WebElement recurrence;

    @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)[9]")
    public WebElement callViaHangout;

}
