package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowseFactoryPage {

	
	
	static WebDriver driver;
	static String browser = "chrome";
	static String url = "http://techfios.com/test/102/";

	public static WebDriver init() 
	{
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public static WebDriver tearDown() {
		driver.close();
		driver.quit();
		return driver;
	}
}
