package utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;

import java.net.MalformedURLException;

public class Hooks extends ConfigDriver{

    @Before
    public void startClient(Scenario scenario) throws MalformedURLException {
        startDriver(scenario);
    }

    @After
    public void closeDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        stopDriver();
    }
}
