package cucumberOptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import commons.GlobalConstants;
import io.cucumber.java.Before;

public class Hooks {

	private static WebDriver driver;
	
	@Before
	public synchronized static WebDriver openAndQuitBrowser() {
		String browser = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browser);
        
		if (driver == null) {
            try {
                if (browser == null) {
                    browser = System.getenv("BROWSER");
                    if (browser == null) {
                        browser = "chrome";
                    }
                }
                switch (browser) {
                    case "chrome":
//                        driver = new ChromeDriver();
                    	ChromeOptions options = new ChromeOptions();
                    	options.addArguments("--headless=new");
                    	driver = new ChromeDriver(options);
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    default:
                        driver = new ChromeDriver();
                        break;
                }
                // Browser crash/ stop
            }
            finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
            driver.get(GlobalConstants.BANKGURU_URL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        }
        return driver;
	}
	
	public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }
}
