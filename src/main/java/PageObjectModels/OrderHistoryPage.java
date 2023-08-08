package PageObjectModels;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderHistoryPage extends AbstractComponent {

    WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//tr/td[2]")
    List<WebElement> orders;
    public boolean verifyOrderDisplay(String productName){
        return orders.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }
}




