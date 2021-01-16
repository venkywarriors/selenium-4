package sel4;

import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.BlockedReason;
import org.openqa.selenium.devtools.network.model.ResourceType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.network.Network.loadingFailed;
import static org.testng.Assert.assertEquals;

public class inetIntercept {
    WebDriver driver;
    WebDriverWait wait;
    DevTools devTools;

    @Test
    public void networkIntercepting() throws InterruptedException {
        //https://chromedevtools.github.io/devtools-protocol/tot/Network/
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        devTools =  ((ChromeDriver)driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        driver.get("https://www.qavalidation.com");
        Thread.sleep(3000);


        //devTools.send(Network.setBlockedURLs(ImmutableList.of("any specific resource path")));

        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.png","*.css")));

        devTools.addListener(loadingFailed(), loadingFailed -> {

            if (loadingFailed.getType().equals(ResourceType.STYLESHEET)) {
                assertEquals(loadingFailed.getBlockedReason(), BlockedReason.INSPECTOR);
            }

            else if (loadingFailed.getType().equals(ResourceType.IMAGE)) {
                assertEquals(loadingFailed.getBlockedReason(), BlockedReason.INSPECTOR);
            }

        });

        driver.get("https://www.qavalidation.com");
        Thread.sleep(3000);
        driver.quit();
    }

}
