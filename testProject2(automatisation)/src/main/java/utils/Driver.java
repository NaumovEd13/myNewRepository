package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public final class Driver {

    private Driver() {
    }

    private static WebDriver driver;

    private static void createDriver() {
        if (System.getenv("env_variable.") == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            try {
                driver = new RemoteWebDriver(new URL(PropertyLoader.loadProperty("remoteWebDriverUrl")), DesiredCapabilities.chrome());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }

    public static void getPage(final String address) {
        if (driver != null) {
            driver.get(address);
        } else {
            System.out.println("Драйвер не инициализирован");
        }
    }
}
