package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import implementation.Implementation;

public class Hooks {

    private Implementation implementation;

    public Hooks(Implementation implementation) {
        this.implementation = implementation;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        implementation.startTest(scenario.getName());
        System.out.println("Starting Cucumber Scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        implementation.endTest();
        System.out.println("Finished Cucumber Scenario: " + scenario.getName());
    }
}