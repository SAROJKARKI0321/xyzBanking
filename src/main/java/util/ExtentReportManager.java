package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private  static ExtentReports extentReports;

    public  static ExtentReports createInstance(String filename){
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(filename);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("XYZ Banking report");
        sparkReporter.config().setDocumentTitle("User Experince in XYZ app");
        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("OperatingSystem","WIN11");
        extentReports.setSystemInfo("Device","AcerSaroj");
        return  extentReports;
    }
    public  static ExtentReports getExtent(){
        return  extentReports;
    }
}
