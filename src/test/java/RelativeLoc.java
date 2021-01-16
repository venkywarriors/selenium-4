package sel4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.time.Duration;
import java.util.List;

public class RelativeLoc {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeMethod
    void Login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        driver.get("https://qavbox.github.io/demo/webtable/");
        //driver.get("https://qavbox.github.io/demo/signup/");
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void ElScreenshot() throws InterruptedException {
       /* WebElement Functional = driver.findElement(By.xpath("//td[contains(., 'Functional')]"));

        WebElement QTP = driver.findElement(withTagName("td").toRightOf(Functional));
        highlight(driver, QTP);*/


        WebElement bugZ = driver.findElement(By.xpath("//td[contains(., 'Bugzilla')]"));
        //WebElement qcAlm = driver.findElement(By.xpath("//td[contains(., 'QC ALM')]"));
        //WebElement TFS = driver.findElement(withTagName("td").below(bugZ).above(qcAlm));//instead of TFS, we get the checkbox

        /*WebElement selLink = driver.findElement(By.linkText("Selenium"));
        WebElement TFS = driver.findElement(withTagName("td").below(bugZ).toRightOf(selLink));
        highlight(driver, TFS); */

             List<WebElement> els = driver.findElements(withTagName("td").below(bugZ));
            for(WebElement el : els){
                System.out.println(el.getTagName() + " " +el.getText());
            }
        Thread.sleep(3000);
        driver.quit();

    }
    public void highlight(WebDriver driver, WebElement el){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",el);
    }
    }

