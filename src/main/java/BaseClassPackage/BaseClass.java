package BaseClassPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\Suprabhat\\IdeaProjects\\" +
                    "FreeCrmPOMproject\\src\\main\\java\\ConfigurationPackage\\config.properties");
            prop.load(ip);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void initialization() {
        String browserValue = prop.getProperty("browser");
        if (browserValue.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\Eclips JAVA project\\Automations\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();


        } else {
            System.setProperty("webdriver.gecko.driver", "E:\\Eclips JAVA project\\Automations\\chromedriver_win32.gecko.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }
    }

