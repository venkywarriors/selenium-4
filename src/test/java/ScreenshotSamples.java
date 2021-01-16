package sel4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotSamples {

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
    public void ElScreenshot() throws InterruptedException {
        driver.manage().window().minimize();

        driver.findElement(By.id("user-name")).sendKeys("qavbox");
        driver.findElement(By.id("password")).sendKeys("qavbox1");
        driver.findElement(By.id("login-button")).click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product_label")));
        } catch (Exception e) {
            System.out.println("Login Error" + e.getMessage());
            WebElement el = driver.findElement(By.cssSelector("[data-test='error']"));
            captureScreenShotOf(el, driver);
        }

        Thread.sleep(2000);
        driver.quit();

    }

    //@Test
    public void FullPageShotTest() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product_label")));
        //captureFullPageShot(driver);

        captureFullPageShot_old(driver); //applicable for all brosers

        Thread.sleep(2000);
        driver.quit();
    }

    void captureScreenShotOf(WebElement el, WebDriver driver){
        File newImg = el.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(newImg, new File("./screenshot/ElPageShot.jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

// full page Screenshot in firefox
    void captureFullPageShot(WebDriver driver){
        File newImg = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(newImg, new File("./screenshot/FullPageShot.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void captureFullPageShot_old(WebDriver driver){
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("./screenshot/FullPageShot_old.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
