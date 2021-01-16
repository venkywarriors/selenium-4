# Selenium :heavy_check_mark: 4
![alt text](https://github.com/venkywarriors/selenium-4/blob/main/selenium-04.jpg ":mag_right: Keep Exploring :mag:")

## Important Architecture Related Changes

1) ***Supports removed for some browsers:*** Now, they have removed the supports for the browsers Opera and Phantom JS. Opera users can use the Chrome browser, whereas Phantom JS users can use Chrome or Firefox in headless mode.

2) ***Optimized Selenium Grid:*** Selenium Grid was developed long back in 2011.

Selenium 4 has come up with new architecture to remove the issues which occurred earlier during installation and configuration, also during the connection between the hub and node machine.

Let’s understand in brief about the Selenium Grid, which contains two major components:

***Node:*** It is used to execute tests on individual computer systems. There can be multiple nodes in a grid.

***Hub:*** It is the central point from where it controls all the machines present in the network, and it contains only one hub which helps in allocating test execution to different nodes.
But in Selenium 4, Grid is very flexible. It allows us to test the cases against multiple browsers, browsers of different versions, and also on different Operating systems. Even now, there is no need for a setup to start hub and nodes individually once the user starts the server, the Grid automatically works as both nodes and hub.

It also supports advanced tools like Docker, AWS, Azure, and much more, useful in the DevOps process. Now Grid has a more user-friendly UI and contains relevant information related to the session, running, capacity, etc.

3) ***Standardized Documentation:*** Documents play an essential role for any user, and Selenium documents were not updated since Selenium 2.0.

With Selenium 4, they have updated all the official documents related to Selenium that include web driver, Grid, and IDE to explain the latest changes.

4) ***Improvement in Selenium 4 IDE:*** Selenium IDE is a record and playback tool that is used for user interaction with the browser, and the new version of IDE is available with more features

5) ***Better Monitoring:*** Logging and request tracing process are now improved to make a better grip on the debugging process for automation engineers as it is not limited to DevOps only.

:clipboard: [Selenium 4 Architecture Introduction](https://github.com/venkywarriors/selenium-4/blob/main/Selenium%20WebDriver%204.pdf)

:pencil2: [Same programs](https://github.com/venkywarriors/selenium-4/tree/main/src/test/java)
```
import java.time.Duration;
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

driver.switchTo().parentFrame() is generally used to switch the control back to the parent frame.

driver.switchTo().defaultContent() is used to switch the control back to default content in the window.
```
