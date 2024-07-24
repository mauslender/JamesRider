package app.jamesrider.pages;

import app.jamesrider.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    @FindBy(id = "com.hdw.james.rider:id/profileName")
    private WebElement currentProfileName;
    private By currentProfileNameLocator = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.hdw.james.rider:id/chevron\").instance(0)");
    private By signOutLocator = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(8)");

    public MenuPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnCurrentProfile() {
        WaitUtils.waitForElementPresence(driver, currentProfileNameLocator, 5);

        // Click on current profile name
        driver.findElement(currentProfileNameLocator).click();
    }

    public boolean assertCurrentProfileName(String profileName) {
        String actualProfileName = currentProfileName.getText();
        return actualProfileName.equals(profileName);
    }

    public void clickOnSignOut() {
        WaitUtils.waitForElementPresence(driver, signOutLocator, 5);

//        String signOutSelector = String.format("new UiSelector().className(\"android.view.ViewGroup\").instance(8)");
//        WebElement signOutElement = driver.findElement(AppiumBy.androidUIAutomator(signOutSelector));
        // Click on current profile name
        driver.findElement(signOutLocator).click();
    }
}
