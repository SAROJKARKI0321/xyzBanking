package base;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
        public final Logger logger=LogManager.getLogger(getClass());





    @BeforeClass
    public void setUp() throws MalformedURLException {

        //Steps to run in slenium grid
        Capabilities options=new ChromeOptions();
        driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
        //run java -jar selenium-server-4.33.0.jar standalone
        driver.get(ConfigReader.properties.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //  Normal running
      /*  logger.info("Setting up the driver..");
        driver = new ChromeDriver();
        logger.info("Opening the Url..");
        driver.get(ConfigReader.properties.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Tearing down the driver");
        }
    }
}





