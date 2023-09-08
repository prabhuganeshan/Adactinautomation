package utility;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;




public class Utility {
	
	public static WebDriver driver;
	
	public static void launchBrowser(String string) throws Throwable{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(string);
	}
	
	public static void visibility_of_Element(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	
	
	public static void click_element(WebElement element) {
		
		//wait.until(ExpectedConditions.visibilityOf(element));
		//element.click();
		
		visibility_of_Element(element);
		element.click();

	}
	
	public static void send_keys(WebElement element,String string) {
		visibility_of_Element(element);
		element.clear();
		element.sendKeys(string);
	}
	
	public String  read_property_file(String key) throws Throwable {
	    Properties prop = new Properties();
	    File file = new File("C:\\Users\\Dell\\eclipse-workspace\\selenium2022\\Intranet_Time_sheet\\addactin.properties");
	    FileInputStream inputstream = new FileInputStream(file);
	    prop.load(inputstream);
	    String property = prop.getProperty(key);
	    return property;
	   
	}

	
	public static void select_by_visible_text_in_dropDwon(WebElement element,String string) {
		
		visibility_of_Element(element);
		Select s=new Select(element);
		s.selectByValue(string);
	}
	
	public static void Take_screen_shot() throws Throwable{
		
		TakesScreenshot tk=(TakesScreenshot)driver;
		File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
	    File destination=new File("C:\\Users\\Dell\\eclipse-workspace\\selenium2022\\Intranet_Time_sheet\\Screenshot"+"\\screenshot.png");
		FileUtils.copyFile(screenshotAs, destination);
			}
	
	
	public static void takeScreenshot() throws Throwable {
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String fileName = "screenshot_" + timestamp + ".png";
	    String directory = System.getProperty("user.dir") + File.separator + "screenshots";

	    File destination = new File(directory, fileName);
	    FileUtils.copyFile(screenshot, destination);

	    System.out.println("Screenshot captured: " + destination.getAbsolutePath());
	}
	
	
	public static void read_the_table() {
		
		
	}

}
