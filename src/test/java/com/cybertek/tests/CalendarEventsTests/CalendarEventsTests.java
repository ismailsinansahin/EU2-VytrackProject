package com.cybertek.tests.CalendarEventsTests;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CalendarEventsTests extends TestBase {

//    @DataProvider
//    public Object[][] loginCredentials(){
//        String[][] loginCredentials = {{},{}};
//        return loginCredentials;
//    }

    @Test
    public void verify1PageSubtitle() {

        extentLogger = report.createTest("Verify Page Subtitle Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.logInAsAStoreManager();
        extentLogger.info("Login as a store manager (Username: storemanager85, Password: UserUser123");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities/Calender Events");

        BrowserUtils.waitFor(2);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(calendarEventsPage.optionsLink,10);
        Assert.assertTrue(calendarEventsPage.optionsLink.isDisplayed());
        extentLogger.info("Verify Page Subtitle is displayed");

        extentLogger.pass("Verify Page Subtitle Test is Passed");

    }

    @Test
    public void verify2PageNumber() {

        extentLogger = report.createTest("Verify Page Number Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.logInAsAStoreManager();
        extentLogger.info("Login as a store manager (Username: storemanager85, Password: UserUser123");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities/Calender Events");

        BrowserUtils.waitFor(2);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(calendarEventsPage.pageNumber,10);
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1");
        extentLogger.info("Verify page number is '1'");

        extentLogger.pass("Verify Page Number Test is Passed");

    }

    @Test
    public void verify3ViewPerPageDefaultNumber() {

        extentLogger = report.createTest("Verify View Per Page Default Number Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.logInAsAStoreManager();
        extentLogger.info("Login as a store manager (Username: storemanager85, Password: UserUser123");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities/Calender Events");

        BrowserUtils.waitFor(2);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(calendarEventsPage.viewPerPageDefault,10);
        Assert.assertTrue(calendarEventsPage.viewPerPageDefault.getText().contains("25"),
                          "Verifying default view per page number is 25");
        extentLogger.info("Verify page view per page default value is '25'");

        extentLogger.pass("Verify View Per Page Default Number Test is Passed");

    }

    @Test
    public void verify4NumberOfRecords() {

        extentLogger = report.createTest("Verify Number of Records Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.logInAsAStoreManager();
        extentLogger.info("Login as a store manager (Username: storemanager85, Password: UserUser123");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities/Calender Events");

        BrowserUtils.waitFor(1);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(calendarEventsPage.totalOfRecordsMessage,10);
        String expectedTotalOfRecords = calendarEventsPage.totalOfRecordsMessage.getText().split(" ")[2];
        extentLogger.info("Get the total number of records from the message");

        BrowserUtils.waitFor(1);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickability(calendarEventsPage.viewPerPageButton,10);
        calendarEventsPage.viewPerPageButton.click();
        extentLogger.info("Click the view per page button");
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(calendarEventsPage.viewPerPage100,10);
        calendarEventsPage.viewPerPage100.click();
        extentLogger.info("Select the '100' from the dropdown");
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(calendarEventsPage.maxPageMessage,10);
        int maxPageNumber = Integer.parseInt(calendarEventsPage.maxPageMessage.getText().split(" ")[1]);
        extentLogger.info("Get the total number of pages from the message");

        int totalOfRecords = 0;

        for (int i=1 ; i<=maxPageNumber ; i++){
            BrowserUtils.waitFor(1);
            dashboardPage.waitUntilLoaderScreenDisappear();
            BrowserUtils.waitForPageToLoad(5);
            totalOfRecords += calendarEventsPage.rowsNumber.size();
            BrowserUtils.waitFor(1);
            BrowserUtils.waitForClickability(calendarEventsPage.nextPageArrow,10);
            calendarEventsPage.nextPageArrow.click();
        }

        String actualTotalOfRecords = String.valueOf(totalOfRecords);
        extentLogger.info("Get the total number of records from the pages one by one with the number of rows");

        Assert.assertEquals(actualTotalOfRecords,expectedTotalOfRecords,
                           "Verifying the total number of records");
        extentLogger.info("Verify the counted number of records is the same with the number in the message");

        extentLogger.pass("Verify Number of Records Test is Passed");

    }

    @Test
    public void verify5SelectAll(){

        extentLogger = report.createTest("Verify Select All Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.logInAsAStoreManager();
        extentLogger.info("Login as a store manager (Username: storemanager85, Password: UserUser123");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities/Calender Events");

        BrowserUtils.waitFor(1);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(calendarEventsPage.totalOfRecordsMessage,10);
        String expectedTotalOfRecords = calendarEventsPage.totalOfRecordsMessage.getText().split(" ")[2];
        extentLogger.info("Get the total number of records from the message");

        BrowserUtils.waitFor(1);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickability(calendarEventsPage.viewPerPageButton,10);
        calendarEventsPage.viewPerPageButton.click();
        extentLogger.info("Click the view per page button");
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickability(calendarEventsPage.viewPerPage100,10);
        calendarEventsPage.viewPerPage100.click();
        extentLogger.info("Select the '100' from the dropdown");
        BrowserUtils.waitFor(1);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(calendarEventsPage.maxPageMessage,10);
        int maxPageNumber = Integer.parseInt(calendarEventsPage.maxPageMessage.getText().split(" ")[1]);
        extentLogger.info("Get the total number of pages from the message");

        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickability(calendarEventsPage.selectAllBox,10);
        calendarEventsPage.selectAllBox.click();
        extentLogger.info("Click 'Select All' box to select all");

        int totalOfRecords = 0;

        for (int i=1 ; i<=maxPageNumber ; i++){
            BrowserUtils.waitFor(1);
            dashboardPage.waitUntilLoaderScreenDisappear();
            BrowserUtils.waitForPageToLoad(5);
            for (int j=1 ; j<=calendarEventsPage.rowsNumber.size() ; j++){
                if (Driver.get().findElement(By.xpath("//tr[" + j + "]//td[1]//input[1]")).isSelected()){
                    totalOfRecords ++;
                }
            }
            BrowserUtils.waitFor(1);
            BrowserUtils.waitForClickability(calendarEventsPage.nextPageArrow,10);
            calendarEventsPage.nextPageArrow.click();
        }

        dashboardPage.waitUntilLoaderScreenDisappear();
        String actualTotalOfRecords = String.valueOf(totalOfRecords);
        extentLogger.info("Get the total number of checked records from the pages one by one with the number of rows");

        Assert.assertEquals(actualTotalOfRecords,expectedTotalOfRecords,
                "Verifying the total number of records");
        extentLogger.info("Verify the counted number of checked records is the same with the number in the message");

        extentLogger.pass("Verify Select All Test is Passed");

    }

    @Test
    public void  verify6Data(){

        extentLogger = report.createTest("Verify Data Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalenderEventPage createCalenderEventPage = new CreateCalenderEventPage();
        ExcelUtil newEventInfo = new ExcelUtil("src/test/resources/eventInformations.xlsx","Sheet1");

        loginPage.logInAsAStoreManager();
        extentLogger.info("Login as a store manager (Username: storemanager85, Password: UserUser123");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities/Calender Events");

        BrowserUtils.waitFor(5);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickability(calendarEventsPage.createCalendarEventButton,10);
        calendarEventsPage.createCalendarEventButton.click();

        BrowserUtils.waitFor(2);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickability(createCalenderEventPage.ownerDropdown,10);

        String[][] eventInfo = newEventInfo.getDataArrayWithoutFirstRow();

        String owner = eventInfo[0][3];
        String title = eventInfo[0][0];
        String startDate = eventInfo[0][1].split(",")[0] + eventInfo[0][1].split(",")[1];
        String startTime = eventInfo[0][1].split(",")[2];
        String endDate = eventInfo[0][2].split(",")[0] + eventInfo[0][2].split(",")[1];
        String endTime = eventInfo[0][2].split(",")[2];

        createCalenderEventPage.ownerDropdown.click();
        BrowserUtils.waitFor(1);

        for (int i=1 ; i<=createCalenderEventPage.ownerList.size() ; i++){
            BrowserUtils.waitFor(1);
            WebElement each = Driver.get().findElement(By.xpath("//div[@id='select2-drop']//li[" + i + "]"));
            if(each.getText().contains(owner)){
                each.click();
                BrowserUtils.waitFor(2);
            }
        }

        BrowserUtils.waitFor(2);
        createCalenderEventPage.title.sendKeys(title);
        BrowserUtils.waitFor(1);
        createCalenderEventPage.startDate.clear();
        BrowserUtils.waitFor(1);
        createCalenderEventPage.startDate.sendKeys(startDate);
        BrowserUtils.waitFor(1);
        createCalenderEventPage.startTime.clear();
        BrowserUtils.waitFor(1);
        createCalenderEventPage.startTime.sendKeys(startTime);
        BrowserUtils.waitFor(1);
        createCalenderEventPage.endDate.clear();
        BrowserUtils.waitFor(1);
        createCalenderEventPage.endDate.sendKeys(endDate);
        BrowserUtils.waitFor(1);
        createCalenderEventPage.endTime.clear();
        BrowserUtils.waitFor(1);
        createCalenderEventPage.endTime.sendKeys(endTime);
        BrowserUtils.waitFor(1);
        actions.sendKeys(Keys.RETURN);

        BrowserUtils.waitFor(10);
        dashboardPage.waitUntilLoaderScreenDisappear();
        EventInformationPage eventInformationPage = new EventInformationPage();
        System.out.println("eventInformationPage.title.getText() = " + eventInformationPage.title.getText());
        System.out.println("eventInformationPage.description.getText() = " + eventInformationPage.description.getText());
        System.out.println("eventInformationPage.start.getText() = " + eventInformationPage.start.getText());
        System.out.println("startDate + startTime = " + startDate + startTime);
        System.out.println("eventInformationPage.end.getText() = " + eventInformationPage.end.getText());
        System.out.println("endDate + endTime = " + endDate + endTime);
        System.out.println("eventInformationPage.allDayEvent.getText() = " + eventInformationPage.allDayEvent.getText());
        System.out.println("eventInformationPage.organizer.getText() = " + eventInformationPage.organizer.getText());
        System.out.println("eventInformationPage.callViaHangout.getText() = " + eventInformationPage.callViaHangout.getText());

        Assert.assertTrue(eventInformationPage.title.getText().contains(title),
                "Verifying title");
        Assert.assertTrue(eventInformationPage.description.getText().contains("N/A"),
                "Verifying description");
        Assert.assertTrue(eventInformationPage.start.getText().contains(startDate + startTime),
                "Verifying start");
        Assert.assertTrue(eventInformationPage.end.getText().contains(endDate + endTime),
                "Verifying end");
        Assert.assertTrue(eventInformationPage.allDayEvent.getText().contains("No"),
                "Verifying all day event");
        Assert.assertTrue(eventInformationPage.organizer.getText().contains(owner),
                "Verifying organizer");
        Assert.assertTrue(eventInformationPage.callViaHangout.getText().contains("No"),
                "Verifying call via hangout");
        extentLogger.info("Verify the information with the info in the excel sheet");

        extentLogger.pass("Verify Verify Data Test is Passed");

    }

}
