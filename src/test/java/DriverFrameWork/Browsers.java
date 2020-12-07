package DriverFrameWork;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {
    public static WebDriver drivers;
    private String filePath = System.getProperty("user.dir");
    public Browsers(BrowserTypes browserTypes)
    {
        switch (browserTypes)
        {
            case chrome:
                System.setProperty("webdriver.chrome.driver",filePath+"\\Drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start--maximized");
                drivers = new ChromeDriver(options);
                break;
            case firefox:
                System.setProperty("webdriver.gecko.driver",filePath+"Drivers\\geckodriver.exe");
                System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                drivers = new FirefoxDriver();
                break;
            case ie:
                System.setProperty("webdriver.id.driver",filePath+"Drivers\\IEDriverServer.exe");
                drivers = new InternetExplorerDriver();
                break;

        }
    }
   /* public static void main(String[] args)
    {
        Browsers br = new Browsers(BrowserTypes.chrome);
        WebDriver dr = Browsers.drivers;
        dr.get("http://www.baidu.com");
        dr.quit();
    }*/
}
