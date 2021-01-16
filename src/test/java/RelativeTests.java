import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeTests {

  @Test
  public  void RelativeLocators(){

    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
     driver.get("https://applitools.com/blog/category/advanced-topics/");

        WebElement post1 = driver.findElement(By.id("post-22539"));
        String post4 = driver.findElement( withTagName("article").below(post1)).getText();
        System.out.println(" Below post 1 is : "+ post4);

        WebElement post5 = driver.findElement(By.id("post-22033"));
        //post 2 is above post 5
        String post2 = driver.findElement( withTagName("article").above(post5)).getText();
        System.out.println(" Above of post 5 is : "+ post2);

        // post 4 is on the left of post 5
        post4 = driver.findElement( withTagName("article").toLeftOf(post5)).getText();
        System.out.println(" Left of post 5 is : "+ post4);

        // post 6 is on the right of post 5
        String post6 = driver.findElement( withTagName("article").toRightOf(post5)).getText();
        System.out.println(" Right of post 5 is : "+ post6);
  }

}
