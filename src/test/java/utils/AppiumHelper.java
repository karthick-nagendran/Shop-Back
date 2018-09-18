package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumHelper extends ConfigDriver {

    /***
     * Check the element present in the screen or not
     */
    public static boolean checkElementExists(By locator) {
        boolean status = driver.findElements(locator).isEmpty();
        if (!status) {
            return true;
        } else
            System.out.println(locator + " is not present in the screen");
        return false;
    }

    /**
     * Wait until the element display, max wait time is 30s
     */
    public static void waitForVisibilityOfElement(By locator) {
        WebDriverWait wdwait = new WebDriverWait(driver, 30);
        wdwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait until the element disappear, max wait time is 30s
     */
    public static void waitForInVisibilityOfElement(By locator) {

        WebDriverWait wdwait = new WebDriverWait(driver, 30);
        wdwait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Swipe or scroll any given direction one time
     */

    public static void swipeTheScreen(String direction) {
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        MobileElement slider;
        try {
            slider = driver.findElementByXPath("//XCUIElementTypeScrollView");

        } catch (NoSuchElementException e) {
            slider = driver.findElementByXPath("//XCUIElementTypeCollectionView");
        }
        Dimension size = slider.getSize();
        switch (direction.toLowerCase()) {
            case "left":
                startX = size.width - 20 ;
                startY = size.height / 2;
                endX = size.width / 2;
                endY = size.height /2;
                break;
            case "right":
                startX = size.width - 20 ;
                startY = size.height / 2;
                endX = size.width / 2;
                endY = size.height /2;
                break;
            case "up":
                startX = size.width / 2 ;
                startY = size.height / 2;
                endX = size.width / 2;
                endY = size.height -20;
                break;
            case "down":
                startX = size.width /2 ;
                startY = size.height - 20;
                endX = size.width / 2;
                endY = size.height /2;
                break;
            default:
                break;
        }
        TouchAction swipe = new TouchAction(driver).press(ElementOption.element(slider, startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(slider, endX, endY)).release();
        swipe.perform();
    }

    /**
     *Scroll down or up until find the given element
     */
    public static void scrollUntilVisibilityOf(String direction, String locatorName) {
        int swipeCount = 0;
        MobileElement slider;
        try {
            slider = driver.findElementByXPath("//XCUIElementTypeScrollView");

        } catch (NoSuchElementException e) {
            slider = driver.findElementByXPath("//XCUIElementTypeCollectionView");
        }
        Dimension size = slider.getSize();
        if (direction.toLowerCase().equals("down")) {
            do {
                TouchAction swipe = new TouchAction(driver).press(ElementOption.element(slider, size.width / 2, size.height - 20))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                        .moveTo(ElementOption.element(slider, size.width / 2, size.height / 2)).release();
                swipe.perform();
                swipeCount++;
            } while (elementNotDisplayedExceptionHandling(locatorName)
                    && swipeCount < 7);
        } else if (direction.toLowerCase().equals("up")) {
            do {
                TouchAction swipe = new TouchAction(driver).press(ElementOption.element(slider, size.width / 2, size.height / 2))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                        .moveTo(ElementOption.element(slider, size.width / 2, size.height - 20)).release();
                swipe.perform();
                swipeCount++;
            } while (elementNotDisplayedExceptionHandling(locatorName)
                    && swipeCount < 7);
        }
    }

    public static boolean elementNotDisplayedExceptionHandling(String locator) {
        boolean state = false;
        try {
            state = !(driver.findElement(By.name(locator)).isDisplayed());
        } catch (NoSuchElementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            state = true;
        }
        return state;
    }

    public static boolean checkVisiablityOfText(String stringElement){
        return driver.findElement(By.xpath(stringElement)).isDisplayed();
    }
}
