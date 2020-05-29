package com.cybertek.tests.LoginTests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginWithDriver() {
        LoginPage loginPage = new LoginPage();
        loginPage.logInAsADriver();

        DashboardPage dashboarhPage = new DashboardPage();
        Assert.assertTrue(dashboarhPage.modulesBar.isDisplayed());

    }

    @Test
    public void loginWithSalesManagerCredentials(){
        LoginPage loginpage = new LoginPage();
        loginpage.logInAsASalesManager();

        DashboardPage dashboarhPage = new DashboardPage();
        Assert.assertTrue(dashboarhPage.modulesBar.isDisplayed());

    }

    @Test
    public void loginWithStoreManagerCredentials(){
        LoginPage loginPage = new LoginPage();
        loginPage.logInAsAStoreManager();

        DashboardPage dashboarhPage = new DashboardPage();
        Assert.assertTrue(dashboarhPage.modulesBar.isDisplayed());

    }

}
