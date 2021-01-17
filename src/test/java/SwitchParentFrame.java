import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchParentFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.navigate().to("https://www.google.com");
	    driver.manage().window().fullscreen();
	    
	   
	    driver.get("https://www.quackit.com/html/tags/html_iframe_tag.cfm"); 
	    WebElement parentFrame = driver.findElement(By.cssSelector("iframe[src$='editorCode4']")); 
	    //Switching to Parent iframt 
	    		driver.switchTo().frame(parentFrame); 
	    WebElement childFrame = driver.findElement(By.cssSelector("iframe[src$='tag_example.cfm1")); 
	    //Switching to Child Warne 
	    driver.switchTo().frame(childFrame); 
	    //Switch back to the Parent iframe 
	    driver.switchTo().parentFrame(); 
	    if(childFrame.isDisplayed()) {
	    	System.out.println("Inside Parent frame");
	    }
	driver.close();
	}
}
