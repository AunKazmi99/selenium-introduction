package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SeleniumTableGrids {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> amountsColumn = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
        int sum = 0;
        for (int i = 0; i < amountsColumn.size(); i++)
        {
            sum = sum + Integer.parseInt(amountsColumn.get(i).getText());
        }
        System.out.println(sum);
        int totalAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        //if (sum == totalAmount) System.out.println("Sum is correct");
        //else System.out.println("Sum is incorrect");
        Assert.assertEquals(sum,totalAmount);
        driver.quit();

    }
}
