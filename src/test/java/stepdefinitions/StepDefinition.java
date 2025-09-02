package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the bank's business homepage")
    public void userIsOnBankBusinessHomepage() {
        implementation.launchUrl();
        System.out.println("test");
        implementation.waitForSeconds(2);
    }

    @When("User scrolls to {string} section")
    public void userScrollsToCompareSection(String sectionName) {
        implementation.scrollToSectionCompareAccounts(sectionName);
    }

    @And("User waits for {int} seconds")
    public void userWaitsForSeconds(int seconds) {
        implementation.waitForSeconds(seconds);
    }

    @And("User clicks on 'chakra arrow' link")
    public void userClicksOnChakraArrowLink() {
        implementation.clickChakraArrowLink();
    }

    @And("User fails to click on 'chakra arrow' link")
    public void userClicksOnChakraArrowLinkFail() {
        implementation.clickChakraArrowLinkFail();
    }

    @Then("User should be redirected to the comparison page")
    public void userShouldBeRedirectedToComparisonPage() {
        implementation.verifyRedirectionToComparisonPage();
    }

    @When("User clicks on the first checkbox")
    public void userClicksOnFirstCheckbox() {
        implementation.clickFirstCheckbox();
    }

    @And("User clicks on the second checkbox")
    public void userClicksOnSecondCheckbox() {
        implementation.clickSecondCheckbox();
    }

    @And("User clicks on the Compare button")
    public void userClicksOnCompareButton() {
        implementation.clickCompareButton();
    }

    @Then("User should be redirected to the comparison results page")
    public void userShouldBeRedirectedToComparisonResultsPage() {
        implementation.verifyRedirectionToComparisonResultsPage();
    }

    @And("User scrolls to {string}")
    public void userScrollsToAccountMaintenanceChargesHeading(String sectionName) {
        implementation.scrollToSectionAccountMaintenanceCharges(sectionName);
    }

    @Then("User should see the Account closure Fee <12 months for 'Business Basic Account'")
    public void userShouldSeeAccountClosureFeeForBusinessBasicAccount() {
        implementation.verifyBusinessBasicAccountClosureFee();
    }

    @And("User should see the Account closure Fee <12 months for 'Business Advantage Account'")
    public void userShouldSeeAccountClosureFeeForBusinessAdvantageAccount() {
        implementation.verifyBusinessAdvantageAccountClosureFee();
    }
}