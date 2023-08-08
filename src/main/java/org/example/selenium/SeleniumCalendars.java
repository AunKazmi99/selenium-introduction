package org.example.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumCalendars {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,1100)");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#form-field-travel_comp_date")).click();

        while (!driver.findElement(By.cssSelector("div.flatpickr-current-month")).getText().contains("May"))
        {
            driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
            Thread.sleep(1000);
        }

        List<WebElement> dates = driver.findElements(By.cssSelector("div[class='dayContainer'] span[class='flatpickr-day ']"));

        for (int i = 0; i < dates.size(); i++)
        {
            if ((dates.get(i).getText()).equalsIgnoreCase("2"))
            {
                dates.get(i).click();
                break;
            }
        }

    }
}
