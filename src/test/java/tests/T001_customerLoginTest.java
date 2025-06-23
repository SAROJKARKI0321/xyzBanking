package tests;
import Pages.CustomerLoginPage;
import  util.ConfigReader;

import Pages.WelcomePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T001_customerLoginTest extends BaseTest {
    @Test
    public  void login(){
        String testUser= ConfigReader.properties.getProperty("test_customer");

        CustomerLoginPage customerLoginPage=new CustomerLoginPage(driver);
        logger.info("Logging in for the test user...");

        customerLoginPage.select_Customer(testUser);

        customerLoginPage.login();



        WelcomePage welcomePage=new WelcomePage(driver);
        Assert.assertEquals(welcomePage.confirmLogin(),testUser);

        logger.debug("Checking the user logged in");
        //fail case
     //Assert.assertEquals(welcomePage.confirmLogin(),"Harry Potter");








    }

}
