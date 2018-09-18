package utils;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;

public class ConfigDriver {

    File appPath;
    public static AppiumDriver<MobileElement> driver;
    static AppiumDriverLocalService appiumDriverLocalService;

    public static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info").usingAnyFreePort();
        appiumDriverLocalService = builder.build();
        appiumDriverLocalService.start();
    }

    public void startDriver(Scenario scenario) throws MalformedURLException {

        File[] app = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "app").listFiles();
        for (File item : app) {
            if (!(item.isHidden())) {
                appPath = item.getAbsoluteFile();
            }
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SampleDevice");
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        if (scenario.getSourceTagNames().contains("@reset")) {
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

        } else {
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        }
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appWaitActivity", "com.shopback.app.ui.splash.SplashActivity");
        driver = new AndroidDriver<MobileElement>(appiumDriverLocalService.getUrl(), capabilities);
    }

    // Closing the driver
    public void stopDriver() {
        try {
            driver.quit();
        } catch (Exception e) {
        }
    }

    public static void stopServer() {
        appiumDriverLocalService.stop();
    }


}
