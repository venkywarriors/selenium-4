import java.util.concurrent.TimeUnit; // Selenium 3
import java.time.Duration; // Selenium 4

// selenium 3 usage
      FluentWait wait = new FluentWait(driver)
                            .pollingEvery(20, TimeUnit.MILLISECONDS)
                            .withTimeout(20, TimeUnit.SECONDS)
                            .ignoring(NoSuchElementException.class);

//selenium 4 usage
      FluentWait wait = new FluentWait(driver)
                            .pollingEvery(Duration.ofMillis(500))
                            .ignoring(NoSuchElementException.class)
                            .withTimeout(Duration.ofSeconds(60));
