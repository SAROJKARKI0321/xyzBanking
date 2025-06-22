package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver,String screenshotName){
        String timestamp=new SimpleDateFormat("yyyy_MM_dd---hh_mm_ss").format(new Date());
        String filename=screenshotName +"_"+timestamp+".png";
        String relpath="screenshots/"+ filename;
        String destPath= System.getProperty("user.dir")+"/test-output/"+relpath;
        try {
            File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File dest=new File(destPath);
            Files.copy(src.toPath(),dest.toPath());


        } catch (IOException e) {

            System.out.println("Failed to capture screenshot"+e.getMessage());;
        }
        return relpath;

    }
}
