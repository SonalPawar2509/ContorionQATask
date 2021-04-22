package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prp;


    public BaseTest(String browserProperties){
        try {
            prp = new Properties();
            System.out.println("The browser property is: " + browserProperties);
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/config/"
                    + browserProperties);
            prp.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  void initialization(){
        String browserName = prp.getProperty("browser");
        String driverName = prp.getProperty("driver");
        System.out.println("The browser is :" + browserName + ", The driver is: " + driverName);
        System.out.println(System.getProperty("user.dir")+"/src/main/resources/drivers/" + driverName);
        if(browserName.equals("googlechrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/" + driverName);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/" + driverName);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(GenerateScreenshot.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(GenerateScreenshot.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prp.getProperty("url"));

    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
