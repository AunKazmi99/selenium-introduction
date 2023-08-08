package PageObjectModels;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".cartSection h3")
    List<WebElement> cartProducts;
    @FindBy(css=".totalRow button")
    WebElement checkoutButton;
    public boolean VerifyProductDisplay(String productName){
        return cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage GoToCheckoutPage(){
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

}




