package common.classess;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

public class BrowserSession {

	private WebDriver driver;

	public WebDriver initiateBrowserSession(String environmentUrl, String browserType) {
		try {

			if (browserType.equalsIgnoreCase(BrowserType.FIREFOX)) {

				System.setProperty("webdriver.gecko.driver",
						"src\\com\\att\\netbond\\systemtest\\selenium\\resources\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserType.equalsIgnoreCase(BrowserType.CHROME)) {
				System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserType.equalsIgnoreCase(BrowserType.IE)) {

				System.setProperty("webdriver.ie.driver",
						"src\\com\\att\\netbond\\systemtest\\selenium\\resources\\drivers\\IEDriverServerx32.exe");
				driver = new InternetExplorerDriver();
			} else if (browserType.equalsIgnoreCase(BrowserType.EDGE)) {

				System.setProperty("webdriver.ie.driver",
						"src\\com\\att\\netbond\\systemtest\\selenium\\resources\\drivers\\IEDriverServerx64.exe");
				driver = new InternetExplorerDriver();

			}

			driver.manage().window().maximize();
			driver.get(environmentUrl);
			// driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
