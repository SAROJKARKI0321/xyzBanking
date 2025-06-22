package Pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import  util.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BankManagerLoginPage extends BasePage {

    public BankManagerLoginPage(WebDriver driver){
        super(driver);

    }
    HomePage page=new HomePage(driver);


    //LOCATORS
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement Nav_btn_addCustomer;


    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement txt_firstName;
    @FindBy(xpath ="//input[@placeholder='Last Name']" )

    WebElement txt_lastName;
    @FindBy(xpath ="//input[@placeholder='Post Code']" )
    WebElement txt_postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btn_addCustomer;




    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement Navbtn_openAccount;
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement dropdownsCustomer;
    @FindBy(xpath ="//select[@id='currency']" )
    WebElement dropdownCurrency;
    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement btn_Process;


    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement Navbtn_Customers;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement seachBox_CustomerName;
    @FindBy(xpath = "//table//tbody//tr//td[1]")
    WebElement firstName;












    //Actions
    public void addCustomer(){
            page.click_BankManagerLogin();
        Nav_btn_addCustomer.click();
        txt_firstName.sendKeys(ConfigReader.properties.getProperty("new_customer_Fname"));
        txt_lastName.sendKeys(ConfigReader.properties.getProperty("new_customer_lname"));
        txt_postCode.sendKeys(ConfigReader.properties.getProperty("new_customer_postcode"));
        btn_addCustomer.click();
        handleAlert();

    }

    public void OpenAccount(){
        Navbtn_openAccount.click();
        Select Personselect=new Select(dropdownsCustomer);
        Personselect.selectByVisibleText(ConfigReader.properties.getProperty("new_customer_Fname")+" "+ConfigReader.properties.getProperty("new_customer_lname"));
        Select currencySelect=new Select(dropdownCurrency);
        currencySelect.selectByVisibleText("Dollar");
        btn_Process.click();
        handleAlert();



    }
    public String checkAccount(){
        //use better logic next time
        Navbtn_Customers.click();
        seachBox_CustomerName.sendKeys(ConfigReader.properties.getProperty("new_customer_Fname"));
        String nameInTable=firstName.getText();
        return nameInTable;





    }







    public  void handleAlert(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }


}
