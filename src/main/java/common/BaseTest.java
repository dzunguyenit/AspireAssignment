package common;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
	WebDriver driver;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultiBrowser(String browser, String url, String version) {
		if (browser.equals("ie")) {
			InternetExplorerDriverManager.getInstance().version(version).setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("chrome")) {
			ChromeDriverManager.getInstance().version(version).setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extendsions");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String randomUniqueNumber() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Long ExtentEmail = timestamp.getTime();
		return ExtentEmail.toString();
	}

	public String readFile(String filename) {
		String result = "";
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String randomEmail() {
		Random rand = new Random();
		int n = rand.nextInt(9999999);
		return String.valueOf(n);
	}

	protected void verifyTrue(boolean condition) {
		Assert.assertTrue(condition);
	}

	protected void verifyFalse(boolean condition) {
		Assert.assertFalse(condition);
	}

	protected void verifyEquals(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	public void closeBrowser() {
		driver.quit();
	}

}