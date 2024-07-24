package stepdefinitions;

import app.jamesrider.utils.AppiumDriverSetup;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private AppiumDriver driver;
    private AppiumDriverSetup driverSetup;

    public Hooks() {
        driverSetup = new AppiumDriverSetup();
    }

    @Before
    public void setUp(Scenario scenario) {
        String platform = getPlatformFromTags(scenario);
        System.out.println("Platform property: " + platform);

        if (platform != null) {
            System.setProperty("platform", platform); // Set system property for platform
        } else {
            throw new IllegalArgumentException("Platform property is null. Please ensure the scenario has the correct tags.");
        }

        driver = driverSetup.getDriver(platform);
        if (driver == null) {
            throw new RuntimeException("Driver could not be initialized. Please check your configuration.");
        }
        System.out.println("Driver initialized successfully: " + driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        driverSetup.quitDriver();
        System.out.println("Driver quit successfully for scenario: " + scenario.getName());
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    private String getPlatformFromTags(Scenario scenario) {
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.equalsIgnoreCase("@android")) {
                return "android";
            } else if (tag.equalsIgnoreCase("@ios")) {
                return "ios";
            }
        }
        throw new IllegalArgumentException("Platform tag not found in scenario tags: " + scenario.getSourceTagNames());
    }
}
