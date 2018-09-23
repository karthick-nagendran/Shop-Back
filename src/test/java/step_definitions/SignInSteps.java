package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.SignInPage;
import utils.AppiumHelper;

import static utils.Locators.shopBackGoTitle;

public class SignInSteps extends SignInPage {

    @Given("^I am on App launch screen$")
    public void iAmOnAppLaunchScreen() {
        verifyWelcomeScreen();
    }

    @Then("^I click on Select button$")
    public void iClickOnSelectButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I login to the app$")
    public void iLogignToTheApp() throws Throwable {
        login();
    }

    @When("^I logout from app$")
    public void iLogoutFromApp() throws Throwable {
        logout();
    }

    @Then("^I should see the shop back go screen$")
    public void iShouldSeeTheShopBackGoScreen() throws Throwable {
        Assert.assertTrue(AppiumHelper.checkElementExists(shopBackGoTitle));
    }

    @When("^I click on (\\d+)(?:st|nd|rd|th) result from shop back go result$")
    public void iClickOnFirstResultFromShopBackGoResult(int resultRow) throws Throwable {
        clickOnFirstResultfromSBG(resultRow);
    }

    @Given("^I am on quick access page$")
    public void iAmOnQuickAccessPage() throws Throwable {
        verifyQuickAccessScreen();
    }
}
