package Tests;

import PageObjectModels.*;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<Object,Object> input) throws IOException {

        ProductCatalogue productCatalogue = landingPage.LoginApplication((String) input.get("email"), (String) input.get("password"));
        productCatalogue.AddProductToCart((String) input.get("productName"));
        CartPage cartPage = productCatalogue.GoToCartPage();
        boolean match = cartPage.VerifyProductDisplay((String) input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.GoToCheckoutPage();
        checkoutPage.SelectCountry("Pakistan");
        ConfirmationPage confirmationPage = checkoutPage.SubmitOrder();
        String confirmMessage = confirmationPage.VerifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistory() {
        ProductCatalogue productCatalogue = landingPage.LoginApplication("aun@gmail.com", "Asad19671999@");
        OrderHistoryPage orderHistoryPage = productCatalogue.goToOrderHistory();
        Assert.assertTrue(orderHistoryPage.verifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<Object,Object>> data=  getDataToMap(System.getProperty("user.dir") +
                "\\src\\test\\java\\Data\\PurchaseOrder.json");

        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }
    /*HashMap<Object,Object> map = new HashMap<Object,Object>();
        map.put("email","aun@gmail.com");
        map.put("password","Asad19671999@");
        map.put("productName","ZARA COAT 3");

        HashMap<Object,Object> map1 = new HashMap<Object,Object>();
        map1.put("email","shetty@gmail.com");
        map1.put("password","Iamking@000");
        map1.put("productName","ADIDAS ORIGINAL");*/
}