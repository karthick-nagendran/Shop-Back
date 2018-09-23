package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.AppiumHelper;

public class CommonSteps {
    @Then("^I should see the text (.*)$")
    public void iShouldSeeTheTextSignUpWithEmail(String visibilityText) throws Throwable {
        String textPath = String.format("//android.widget.TextView[@text='%s']", visibilityText);
        AppiumHelper.waitForVisibilityOfElement(By.xpath(textPath));
        Assert.assertTrue(AppiumHelper.checkVisiablityOfText(textPath));
    }

    @When("^I click on (.*) button$")
    public void iClickOnShopBackGoButton(String visibilityText) throws Throwable {
        String textPath = String.format("//*[@text='%s']", visibilityText);
        AppiumHelper.waitForVisibilityOfElement(By.xpath(textPath));
        AppiumHelper.clickOnButton(textPath);
    }
}
