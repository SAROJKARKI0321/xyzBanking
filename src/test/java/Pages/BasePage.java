package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public final Logger logger= LogManager.getLogger(getClass());
    public  BasePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));




        PageFactory.initElements(driver,this);
    }
}
