package app.jamesrider.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverSetup {
    private AppiumDriver driver;

    public AppiumDriver getDriver(String platform) {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (platform == null || platform.isEmpty()) {
                throw new IllegalArgumentException("Platform property is not set. Please set the platform to either 'android' or 'ios'.");
            }

            try {
                switch (platform.toLowerCase()) {
                    case "android":
                        capabilities.setCapability("platformName", "Android");
                        capabilities.setCapability("platformVersion", "15.0");
                        capabilities.setCapability("deviceName", "emulator-5554");
                        capabilities.setCapability("automationName", "UiAutomator2");
                        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/apk/James Rider_1.22.0.apk");
                        capabilities.setCapability("appPackage", "com.hdw.james.rider");
                        capabilities.setCapability("appActivity", ".viewlayer.launcher.LauncherActivity");
                        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
                        break;
                    case "ios":
                        capabilities.setCapability("platformName", "iOS");
                        capabilities.setCapability("platformVersion", "14.5");
                        capabilities.setCapability("deviceName", "iPhone Simulator");
                        capabilities.setCapability("automationName", "XCUITest");
                        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/ipa/James Rider.ipa");
                        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid platform: " + platform);
                }

                // Set implicit wait
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid URL for Appium server", e);
            }
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
