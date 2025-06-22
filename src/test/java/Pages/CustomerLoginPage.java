package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CustomerLoginPage extends  BasePage{
    public  CustomerLoginPage(WebDriver driver){
        super(driver);

    }
    HomePage homePage=new HomePage(driver);




    //locators
    @FindBy(id ="userSelect")
     WebElement dropdown_name;
    @FindBy(xpath = "//button[text()='Login']")
    WebElement btn_Login;


    //actions
    public  void select_Customer(String customerName){
        homePage.click_customerLogin();
        wait.until(ExpectedConditions.visibilityOf(dropdown_name));




        Select select=new Select(dropdown_name);
        select.selectByVisibleText(customerName);
    }
    public  void login(){
        btn_Login.click();
    }
}