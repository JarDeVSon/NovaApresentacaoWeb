package steps;

import core.Browser;
import core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class SharedSteps {
    @Before
    public void openNavegator(Scenario scenario) {
        new Driver(Browser.CHROME);
        Driver.setNameScenario(scenario.getName());
        Driver.makeDirectory();
    }

    @After
    public void closeNavegator(Scenario scenario) throws IOException {
        System.out.println(" | Scenario: " + scenario.getName() + " | Status: " + scenario.getStatus());
        if (scenario.isFailed()) {
            Driver.printScreenshots("Scenario is failed! | Step failed!");
        }
        Driver.getDriver().quit();
    }
}
