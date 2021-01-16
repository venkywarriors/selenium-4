import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DeprecatedExamples {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH+ "/src/main/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();

 /**********************************************  Selenium 3 usage  *************************************/

        Actions act = new Actions(driver);
        WebElement toDoList= driver.findElement(By.id("toDoListBtn"));

        // click method - to click on a webElement
        act.moveToElement(toDoList).click();

        // double click - double click on a webElement
        act.moveToElement(toDoList).doubleClick();

        // Context click - Right click on a webElement
        act.moveToElement(toDoList).contextClick();

        //clickAndHold method - click and hold on a webElement without releasing
        act.moveToElement(toDoList).clickAndHold();

        // release -release the hold on a webElement
        act.moveToElement(toDoList).release();

 /**********************************************  Selenium 4 usage  *************************************/
        
        Actions act1 = new Actions(driver);
        WebElement toDoList1= driver.findElement(By.id("toDoListBtn"));

        // click method - to click on a webElement
        act1.click(toDoList);

        //clickAndHold method - click and hold on a webElement without releasing
        act1.clickAndHold(toDoList);

        // Context click - Right click on a webElement
        act1.contextClick(toDoList);

        // double click - double click on a webElement
        act1.doubleClick(toDoList);

        // release -release the hold on a webElement
        act1.release(toDoList);

    }
}
