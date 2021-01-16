import java.io.*; 
// Function to Take screenshot 
    public static void TakeScreenshot(String FileName) 
        throws IOException 
    { 
        // Creating instance of File 
        File src = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
  
        FileUtils.copyFile(src, new File("image location" + FileName + ".jpeg")); 
    } 
