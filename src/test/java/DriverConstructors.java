
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverExample {

    final static String PROJECT_PATH = System.getProperty("user.dir");

@Test
// ChromeDriver(Capabilities) is replaced by ChromeDriver(ChromeOptions)
    public void ChromeOptionsTest throws IOException {

        System.setProperty("webdriver.chrome.driver", PROJECT_PATH+ "/src/main/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        ChromeDriver driver = new ChromeDriver(options);
    }
    
@Test
// SafariDriver(Capabilities) is replaced by SafariDriver(SafariOptions).
    public void SafariOptionsTest throws IOException {

        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setAcceptInsecureCerts(true);

        SafariDriver safariDriver = new SafariDriver(safariOptions);
        safariDriver.get("https://www.google.com");
    }
    
@Test
// EgdeDriver(Capabilities) is replaced by EdgeDriver(EdgeOptions).
    public void EdgeOptionsTest throws IOException {

       EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setAcceptInsecureCerts(true);

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://www.google.com");
    }
    @Test
// InternetExplorerDriver(Capabilities) is replaced by InternetExplorerDriver(InternetExplorerOptions)
    public void InternetExplorerOptionsTest throws IOException {

  System.setProperty("webdriver.ie.driver", PROJECT_PATH+ "/src/main/resources/IEDriverServer.exe");

        InternetExplorerOptions ops = new InternetExplorerOptions();
        ops.setAcceptInsecureCerts(true);

        InternetExplorerDriver ie = new InternetExplorerDriver(ops);
        ie.get("https://www.gmail.com");
    }
    
@Test
// FirefoxDriver(Capabilities) is replaced by FirefoxDriver(FirefoxOptions)
    public void FirefoxOptionsTest throws IOException {

        System.setProperty("webdriver.gecko.driver", PROJECT_PATH+ "/src/main/resources/geckodriver");

        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        FirefoxDriver driver = new FirefoxDriver(options);
        driver.get("https://www.google.com");
    }
}
