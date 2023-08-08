package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SeleniumScope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());

        WebElement discountCouponColumn = footer.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
        System.out.println(discountCouponColumn.findElements(By.tagName("a")).size());

        for (int i = 1; i < discountCouponColumn.findElements(By.tagName("a")).size(); i++)
        {
            String actionToOpenLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
            discountCouponColumn.findElements(By.tagName("a")).get(i).sendKeys(actionToOpenLinks);
            Thread.sleep(2000);
        }

        Set<String> childTabs = driver.getWindowHandles();
        //Iterator<String> iterator = childTabs.iterator();
        /*
        while(iterator.hasNext())
        {
        driver.switchTo().window(iterator.next());
        System.out.println(driver.getTitle());
        }
         */

        for (String childTab : childTabs)
        {
            driver.switchTo().window(childTab);
            System.out.println(driver.getTitle());
        }

        driver.quit();

    }
}
