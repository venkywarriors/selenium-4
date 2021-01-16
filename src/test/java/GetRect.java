package sel4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GetRect {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeMethod
    void Login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://qavbox.github.io/demo/webtable/");
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void Test_getRect() throws InterruptedException {

        WebElement el = driver.findElement(By.id("regform"));

        Point p = el.getLocation();
        System.out.println("X-cord - " + p.x + "  " + p.getX());
        System.out.println("Y-cord - " + p.y + "  " + p.getY());

        Dimension d = el.getSize();
        System.out.println("Width - " + d.width + "  " + d.getWidth());
        System.out.println("height - " + d.height + "  " + d.getHeight());

        System.out.println("getRect method output");

        Rectangle rect = el.getRect();
        System.out.println("X-cord - " + rect.x + "  " + rect.getX());
        System.out.println("Y-cord - " + rect.y + "  " + rect.getY());
        System.out.println("Width - " + rect.width + "  " + rect.getWidth());
        System.out.println("height - " + rect.height + "  " + rect.getHeight());


        Thread.sleep(3000);
        driver.quit();

    }


}
