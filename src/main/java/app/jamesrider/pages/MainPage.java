package app.jamesrider.pages;

import app.jamesrider.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "com.hdw.james.rider:id/MAIN_MENU_ID")
    private WebElement mainMenuButton;
    private By mainPageCarouselLocator = AppiumBy.id("com.hdw.james.rider:id/carousel");

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean assertMainPageIsDisplayed() {
        WaitUtils.waitForElementPresence(driver, mainPageCarouselLocator, 7);

        boolean elementIsDisplayed;
        elementIsDisplayed = driver.findElement(mainPageCarouselLocator).isDisplayed();
        return elementIsDisplayed;
    }

    public void clickMainMenuButton() { mainMenuButton.click(); }
}
