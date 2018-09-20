package pages
        ;

import org.testng.Assert;
import utils.AppiumHelper;
import utils.ConfigDriver;

import static utils.Locators.*;

public class SignInPage extends ConfigDriver {

    protected void login() throws InterruptedException {
        AppiumHelper.waitForVisibilityOfElement(selectBtn);
        driver.findElement(selectBtn).click();
        AppiumHelper.waitForVisibilityOfElement(getStartedBtn);
        driver.findElement(getStartedBtn).click();
        driver.findElement(loginSelectBtn).click();
        driver.findElement(emailTextField).sendKeys("venkatesh.polina27@gmail.com");
        driver.findElement(pswField).sendKeys("pass123");
        driver.findElement(signInBtn).click();
        AppiumHelper.waitForVisibilityOfElement(shopBackGoBtn);
        Assert.assertTrue(AppiumHelper.checkElementExists(shopBackGoBtn));
    }

    protected void verifyWelcomeScreen(){
        AppiumHelper.waitForVisibilityOfElement(selectBtn);
        Assert.assertTrue(AppiumHelper.checkElementExists(selectBtn));
    }

    protected void logout(){
        driver.findElement(pannelSwipeBtn).click();
        driver.findElement(userLogoBtn).click();
        AppiumHelper.waitForVisibilityOfElement(userSettingLogoBtn);
        driver.findElement(userSettingLogoBtn).click();
        AppiumHelper.waitForVisibilityOfElement(userLogoutBtn);
        driver.findElement(userLogoutBtn).click();
    }

    protected  void clickOnFirstResultfromSBG(){
        driver.findElements(shopBackStoreResult).get(0).click();
    }
}
