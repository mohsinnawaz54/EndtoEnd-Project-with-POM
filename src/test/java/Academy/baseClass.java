package Academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class baseClass {
	public WebDriver driver;
	public Properties prop;

	@BeforeTest
	public void init() throws IOException {
		driver = InitializeDriver();
		driver.get("http://qaclickacademy.com");

	}

	public WebDriver InitializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/mohsinnawaz/eclipse-workspace/E2EProject/src/test/java/Academy/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/mohsinnawaz/Downloads/chromedriver");
			driver = new ChromeDriver();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	@AfterTest
	public void teardown() {
		driver.close();
		System.out.println("Added");

	}

}
