package orangeHRM.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver=null;
	public static FileInputStream fis=null;
	public static Properties prop=null;
	
	public BaseTest() {
		
		String fileName = System.getProperty("user.dir")+"\\src\\test\\java\\orangeHRM\\resources\\config.properties";
		try {
		
			fis = new FileInputStream(fileName);
			prop =  new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			new RuntimeException("file not found :-"+fileName);
			e.printStackTrace();
			
		} catch (IOException e) {

			new RuntimeException("file load exception" + fileName);
			e.printStackTrace();
		}
	}

//initialization of browser and URL launch 
	
	public void inti() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("CHROME")) {
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 
		}else if(browserName.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver =  new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("EDGE")) {
			
			WebDriverManager.edgedriver().setup();
			driver =  new EdgeDriver();
			
		}else  {
			new RuntimeException("Invaid browser"+ browserName);
		}

		String URL= prop.getProperty("url");
		driver.get(URL);
	int timeout=Integer.parseInt(prop.getProperty("timeout"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	
	boolean maixmize = Boolean.parseBoolean(prop.getProperty("maixmize"));
		if (maixmize)
			driver.manage().window().maximize();
	}
	
	
	

}










