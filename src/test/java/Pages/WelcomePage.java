package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WelcomePage extends  BasePage{
    public WelcomePage(WebDriver driver) {
        super(driver);

    }
    //locators
    @FindBy(xpath = "//span[@class='fontBig ng-binding']")
    WebElement txt_Welcomemsg;
    public  String confirmLogin(){
        logger.info("Getting the welcome message.");
        return  txt_Welcomemsg.getText();




    }
}
