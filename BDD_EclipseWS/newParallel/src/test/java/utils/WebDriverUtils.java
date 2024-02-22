package utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {

	public WebDriver driver;

	public WebDriver getDriver() {

		System.out.println("Creating chrome browser instance");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver getDriver(String type) {
		System.out.println("Creating a instance for Browser " + type);
		switch (type) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Please contact framework developers to support" + type + " driver");
			break;
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public void printCollections(Map<String, String> data) {

		System.out.println("First Name : " + data.get("firstname"));
		System.out.println("Last  Name : " + data.get("lastname"));
		System.out.println("Job  Title : " + data.get("jobtitle"));
		System.out.println("Education  : " + data.get("education"));
		System.out.println("SEX		   : " + data.get("sex"));
		System.out.println("Experience : " + data.get("experience"));
		System.out.println("-------------------------------------------------");
	}

	public void printCollections(List<String> data) {

		System.out.println("First Name : " + data.get(0));
		System.out.println("Last  Name : " + data.get(1));
		System.out.println("Job  Title : " + data.get(2));
		System.out.println("Education  : " + data.get(3));
		System.out.println("SEX		   : " + data.get(4));
		System.out.println("Experience : " + data.get(5));
		System.out.println("-------------------------------------------------");
	}
}
