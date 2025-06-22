package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public  HomePage(WebDriver driver){
        super(driver);

    }

    //locators

    @FindBy(xpath = "//button[text()='Customer Login']")
    WebElement btn_customerLogin;
    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    WebElement btn_BankManagerLogin;


    //Actions
    public  void click_customerLogin(){
        logger.info("Loggint the customer in");
        btn_customerLogin.click();

    }
    public  void  click_BankManagerLogin(){
        btn_BankManagerLogin.click();
    }
}
