package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SeleniumSortingWithJavaStreams {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("th[role='columnheader']:nth-child(1)")).click();
        List<WebElement> vegFruitNameElement = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        List<String> vegrfruitNameOriginal = vegFruitNameElement.stream().map(WebElement::getText).toList();
        List<String> vegrfruitNameSorted = vegrfruitNameOriginal.stream().sorted().toList();
        //Assert.assertEquals(vegrfruitNameOriginal,vegrfruitNameSorted);
        //Assert.assertTrue(vegrfruitNameOriginal.equals(vegrfruitNameSorted));
        Assert.assertEquals(vegrfruitNameOriginal, vegrfruitNameSorted);

        List<String> priceOfVegFruit;
        do
        {
            vegFruitNameElement = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            priceOfVegFruit = vegFruitNameElement.stream().filter(s -> s.getText().contains("Wheat"))
                    .map(SeleniumSortingWithJavaStreams::getPrice).collect(Collectors.toList());
            priceOfVegFruit.forEach(System.out::println);
            if (priceOfVegFruit.size() < 1) driver.findElement(By.cssSelector("[aria-label='Next']")).click();
        }
        while (priceOfVegFruit.size() < 1);
    }
    public static String getPrice(WebElement element){

        return element.findElement(By.xpath("following-sibling::td[1]")).getText();

    }
}
