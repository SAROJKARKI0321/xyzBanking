package tests;

import Pages.BankManagerLoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.ConfigReader;

public class T002_accountCreationTest  extends BaseTest {
    @Test
    public  void accountNameCheck(){
        //will use better logic the next time;
        String expectedName= ConfigReader.properties.getProperty("new_customer_Fname");
        BankManagerLoginPage bankManagerLoginPage=new BankManagerLoginPage(driver);
        bankManagerLoginPage.addCustomer();
        bankManagerLoginPage.OpenAccount();
        String accountFirstName=bankManagerLoginPage.checkAccount();
        Assert.assertEquals(accountFirstName,expectedName);
        //Assumpted fail case
        //Assert.assertEquals(accountFirstName,"");


    }
}
