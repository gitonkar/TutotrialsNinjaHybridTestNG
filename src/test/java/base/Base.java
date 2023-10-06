package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {
	public WebDriver driver;

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	@Parameters({ "browsername" })
	public WebDriver setup(@Optional("ie") String browsername) {
		// TODO Auto-generated method stub
		switch (browsername) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\wedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		case "ie":
			System.setProperty("webdriver.edge.driver", "./wedriver/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			return driver;
		default:
			System.err.println("..webdriver not created");
			return null;
		}
	}

}
