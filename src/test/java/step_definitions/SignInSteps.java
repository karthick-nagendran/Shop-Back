package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.SignInPage;
import utils.AppiumHelper;

public class SignInSteps extends SignInPage{

    @Given("^I am on App launch screen$")
    public void iAmOnAppLaunchScreen(){
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

    @Then("^I should see the text (.*)$")
    public void iShouldSeeTheTextSignUpWithEmail(String visibilityText) throws Throwable {
        String textPath = String.format("//android.widget.TextView[@text='%s']", visibilityText);
        AppiumHelper.waitForVisibilityOfElement(By.xpath(textPath));
        Assert.assertTrue(AppiumHelper.checkVisiablityOfText(textPath));
    }
}
