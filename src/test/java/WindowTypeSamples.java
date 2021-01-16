package sel4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WindowTypeSamples {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeMethod
    void Login() throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void Test_newWindowType() throws InterruptedException {
        System.out.println("Before navigating to new window" + driver.getCurrentUrl());
        String parentWindow = driver.getWindowHandle();
        Thread.sleep(2000);

        //driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.com/");
        System.out.println("After navigating to new window" + driver.getCurrentUrl());
        Thread.sleep(2000);
        //perform google operations
        driver.close();

        driver.switchTo().window(parentWindow);
        System.out.println("Parent windows" + driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.close();
    }
}
