package OpeningAChromeProfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeProfile {


    public static void main(String[] args) {

        /*System.setProperty("webdriver.chrome.driver", "C:\\Users\\AunAbbas\\Desktop\\SeleniumUdemyResources" +
                "\\SeleniumWebDriverDownload\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");*/
        // Set the path to the profile directory of the new test profile
        //String testProfilePath = "C:\\Users\\AunAbbas\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1";

        // Create ChromeOptions and set user data directory
        System.setProperty("webdriver.chrome.driver","C:\\Users\\AunAbbas\\Desktop" +
                "\\SeleniumUdemyResources\\SeleniumWebDriverDownload" +
                "\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\AunAbbas\\AppData\\Local\\Google\\Chrome\\User Data\\");
        options.addArguments("--profile-directory=Profile 1");

        // Initialize WebDriver with the custom profile
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://dev-online-ordering.innowi.com/branch/maak");

        // Proceed with your automation tasks
        // For example, navigate to the online ordering website and continue with your tasks

        // Close the WebDriver
        //driver.quit();
    }
}

