package sel4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.network.Network.loadingFailed;

public class emulateNetworkCond {
    WebDriver driver;
    WebDriverWait wait;
    DevTools devTools;

    @Test
    public void emulateNetworkConditionTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        devTools =  ((ChromeDriver)driver).getDevTools();

        driver.get("https://www.qavalidation.com");

        devTools.createSession();

        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        //change the download, upload speed and connection type to verify how your web app reacts
        devTools.send(
                Network.emulateNetworkConditions(true, 100, 200000, 100000, Optional.of(ConnectionType.ETHERNET)));


        //when offline
        devTools.addListener(loadingFailed(), loadingFailed ->
        {
            System.out.println(loadingFailed.getErrorText());
            Assert.assertEquals(loadingFailed.getErrorText(), "net::ERR_INTERNET_DISCONNECTED");
        });


        long startTime = System.currentTimeMillis();
        driver.get("https://www.qavalidation.com");

        long endTime = System.currentTimeMillis();

        System.out.println("page loaded in " + (endTime - startTime));

        Thread.sleep(3000);
        driver.quit();
    }

}
