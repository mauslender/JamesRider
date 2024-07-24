package stepdefinitions;

import app.jamesrider.pages.*;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;

public class LoginSteps {
    private AppiumDriver driver;
    private BasePage basePage;
    private LoginPage loginPage;
    private StartPage startPage;
    private LoginValidationPage loginValidationPage;
    private LoginPermissionsPage loginPermissionsPage;
    private MainPage mainPage;
    private MenuPage menuPage;

    public LoginSteps(Hooks hooks) {
        this.driver = hooks.getDriver(); // Get the shared driver instance
        this.basePage = new BasePage(driver);
        this.loginPage = new LoginPage(driver);
        this.startPage = new StartPage(driver);
        this.loginValidationPage = new LoginValidationPage(driver);
        this.loginPermissionsPage = new LoginPermissionsPage(driver);
        this.mainPage = new MainPage(driver);
        this.menuPage = new MenuPage(driver);
    }

    @Given("I am on the Start screen")
    public void i_am_on_the_start_screen() {
        boolean getStartedButtonStatus = startPage.assertGetStartedButtonIsDisplayed();
        assert getStartedButtonStatus;
    }

    @Given("I click on the Get Started button")
    public void i_click_on_the_get_started_button() {
        startPage.clickGetStartedButton();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException {
        boolean loginTitleStatus = loginPage.assertLoginTitleIsDisplayed();
        assert loginTitleStatus;
    }

    @When("I click on the Country Code dropdown")
    public void i_click_on_the_country_code_dropdown() {
        loginPage.clickCountryCodeDropdown();
    }

    @When("I set the Country Code to {string}")
    public void i_set_the_country_code_to(String countryName) {
        loginPage.clickOnCountryCode(countryName);
    }

    @When("I enter phone number {string}")
    public void i_enter_phone_number(String phoneNumber) {
        loginPage.enterPhoneNumber(phoneNumber);
    }

    @When("I click on the Continue button")
    public void i_click_on_the_continue_button() {
        basePage.clickContinueButton();
    }

    @When("I enter validation code {string}")
    public void i_enter_validation_code(String validationCode) { loginValidationPage.enterValidationCode(validationCode); }

    @Then("I should see Permissions page")
    public void i_should_see_the_permissions_page() {
        boolean permissionsTitleStatus = loginPermissionsPage.assertPermissionsPageIsDisplayed();
        assert permissionsTitleStatus;
    }

    @When("I click on the Location permission button")
    public void i_click_on_the_location_permission_button() {
        loginPermissionsPage.clickLocationPermissionButton();
    }

    @When("I click on The Notifications permission button")
    public void i_click_on_the_notifications_permission_button() {
        loginPermissionsPage.clickNotificationsPermissionButton();
    }

    @When("I click on the Continue button on the permissions page")
    public void i_click_on_the_continue_button_on_the_permissions_page() {
        loginPermissionsPage.clickContinueButton();
    }

    @Then("I should see the Main screen")
    public void i_should_see_the_main_screen() {
        boolean mainScreenStatus = mainPage.assertMainPageIsDisplayed();
        assert mainScreenStatus;
    }

    @When("I click on Sign Out")
    public void i_click_on_sign_out() {
        menuPage.clickOnSignOut();
    }

    @Then("I should see the Login page")
    public void i_should_see_the_login_page() {
        boolean loginPageStatus = loginPage.assertLoginTitleIsDisplayed();
        assert loginPageStatus;
    }
}
