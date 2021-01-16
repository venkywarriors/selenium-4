package sel4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Emulate_Geo_TimeZone {

    WebDriver driver;
    DevTools devTools;
    WebDriverWait wait;

    @BeforeMethod
    void Login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        devTools =  ((ChromeDriver)driver).getDevTools();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void emulateGeoLocation() throws InterruptedException {
        //https://www.selenium.dev/selenium/docs/api/rb/Selenium/WebDriver/DevTools/Emulation.html
        driver.get("https://the-internet.herokuapp.com/geolocation");
        By Where = By.xpath("//button[contains(text(),'Where am I')]");

        wait.until(elementToBeClickable(driver.findElement(Where))).click();
        Thread.sleep(8000);
        Map<String, Object> params = new HashMap<>();
        params.put("latitude", 51.5055);
        params.put("longitude", 0.0754);
        params.put("accuracy", 1);

        ((ChromeDriver)driver).executeCdpCommand("Emulation.setGeolocationOverride", params);

        wait.until(elementToBeClickable(driver.findElement(Where))).click();

        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void emulateGeoLocation_1() throws InterruptedException {
        driver.get("https://mycurrentlocation.net/");
        Thread.sleep(8000);

        Map<String, Object> params = new HashMap<>();
        params.put("latitude", 41.881832);
        params.put("longitude", -87.623177);
        params.put("accuracy", 1);
        ((ChromeDriver)driver).executeCdpCommand("Emulation.setGeolocationOverride", params);

        driver.get("https://mycurrentlocation.net/");

        Thread.sleep(6000);
        driver.quit();
    }

    @Test
    public void emulateTimezoneTest() throws InterruptedException {
        driver.get("https://whatismytimezone.com/");
        Thread.sleep(4000);
        devTools.createSession();

        Map<String, Object> map = new HashMap<>();
        //https://en.wikipedia.org/wiki/List_of_tz_database_time_zones#List
        map.put("timezoneId", "Asia/Singapore");

        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        ((ChromeDriver)driver).executeCdpCommand("Emulation.setTimezoneOverride", map);

        driver.get("https://whatismytimezone.com/");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("article")).getText());
        driver.quit();
    }
}
