package stepdefinitions;

import app.jamesrider.pages.*;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps {

    private AppiumDriver driver;
    private BasePage basePage;
    private MainPage mainPage;
    private MenuPage menuPage;
    private ProfilePage profilePage;

    public ProfileSteps(Hooks hooks) {
        this.driver = hooks.getDriver(); // Get the shared driver instance
        this.basePage = new BasePage(driver);
        this.mainPage = new MainPage(driver);
        this.menuPage = new MenuPage(driver);
        this.profilePage = new ProfilePage(driver);
    }

    @When("I click on the Main Menu button")
    public void i_click_on_the_main_menu_button() {
        mainPage.clickMainMenuButton();
    }

    @When("I click on the current profile name")
    public void i_click_on_the_current_profile_name() {
        menuPage.clickOnCurrentProfile();
    }

    @When("I update the First Name to {string}")
    public void i_update_the_first_name_to(String firstName) {
        profilePage.enterFirstName(firstName);
    }

    @When("I update the Last Name to {string}")
    public void i_update_the_last_name_to(String lastName) {
        profilePage.enterLastName(lastName);
    }

    @When("I click on the Done button")
    public void i_click_on_the_done_button() {
        profilePage.clickDoneButton();
    }

    @Then("I should see that the current profile name is {string}")
    public void i_should_see_that_the_current_profile_name_is(String expectedProfileName) {
        boolean expectedProfileNameStatus = menuPage.assertCurrentProfileName(expectedProfileName);
        assert expectedProfileNameStatus;
    }

}
