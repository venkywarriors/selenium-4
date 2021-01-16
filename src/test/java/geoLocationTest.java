import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

// Geo Location override
public void geoLocationTest(){
  ChromeDriver driver = new ChromeDriver();
  Map coordinates = new HashMap()
 {{
    put("latitude", 50.2334);
    put("longitude", 0.2334);
    put("accuracy", 1);
 }};

 driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
 driver.get("<your site url>");
}
