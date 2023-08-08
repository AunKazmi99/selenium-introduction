package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExtentReportsDemoTests {

    ExtentReports extent;

    @BeforeTest
    public void config() {
        String path = System.getProperty("user.dir") + "//reportsExtent/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Automation Extent Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Aun");
    }

    @Test
    public void initialDemo() {

        ExtentTest test = extent.createTest("InitialDemo");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        test.addScreenCaptureFromPath("Image");
        test.fail("Result don't match");
        driver.close();
        extent.flush();

    }
}
