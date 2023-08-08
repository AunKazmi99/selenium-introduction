package PageObjectModels;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {

    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
    WebElement spinner;

    By productLocator = By.cssSelector(".mb-3");
    By addToCartLocator = By.cssSelector(".card-body button:last-of-type");
    //ng-animating
    By toastMessage = By.cssSelector("#toast-container");
    //WebElement animation = driver.findElement(By.cssSelector(".ng-animating")));
    public List<WebElement> GetProductList(){
        WaitForElementToAppear(productLocator);
        return products;
    }

    public WebElement GetProductByName(String productName){
        return GetProductList().stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    }

    public void AddProductToCart(String productName){
        GetProductByName(productName).findElement(addToCartLocator).click();
        WaitForElementToAppear(toastMessage);
        WaitForElementToDisappear(spinner);
    }

}




