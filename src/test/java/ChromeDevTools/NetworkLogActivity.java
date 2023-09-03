package ChromeDevTools;

import org.apache.poi.sl.draw.geom.GuideIf;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.Request;
import org.openqa.selenium.devtools.v116.network.model.Response;

import java.util.Optional;

public class NetworkLogActivity {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\AunAbbas\\Desktop" +
                "\\SeleniumUdemyResources\\SeleniumWebDriverDownload" +
                "\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //ChromeDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();


        devTools.send(Network.enable(Optional.empty(), Optional.empty(),
                Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),requestWillBeSent -> {
            Request req =  requestWillBeSent.getRequest();
            System.out.println(req.getUrl());
            //System.out.println(req.getPostData());
        });


        devTools.addListener(Network.responseReceived(),responseReceived -> {
            Response res = responseReceived.getResponse();
            //System.out.println(res.getUrl());
            System.out.println(res.getStatus());
            if (res.getStatus().toString().startsWith("4")){
                System.out.println(res.getUrl()+"is failing with status code "+res.getStatus());
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
    }
}
