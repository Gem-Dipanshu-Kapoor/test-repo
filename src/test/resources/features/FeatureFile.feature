Feature: Compare Business Accounts on https://business.bankfab.com/
  As a user, I want to compare different business accounts offered by the bank

  Scenario: Compare Business Basic Account and Business Advantage Account
    Given User is on the bank's business homepage
    When User scrolls to "Compare our Business Accounts" section
    And User waits for 2 seconds
    And User clicks on 'chakra arrow' link
    Then User should be redirected to the comparison page
    When User clicks on the first checkbox
    And User clicks on the second checkbox
    And User clicks on the Compare button
    Then User should be redirected to the comparison results page
    When User waits for 2 seconds
    And User scrolls to "Account Maintenance Charges"
    Then User should see the Account closure Fee <12 months for 'Business Basic Account'
    And User should see the Account closure Fee <12 months for 'Business Advantage Account'

  Scenario: Check Chakra Click for Navigation to Business Basic Account and Business Advantage Account
    Given User is on the bank's business homepage
    When User scrolls to "Compare our Business Accounts" section
    And User waits for 2 seconds
    And User fails to click on 'chakra arrow' link
    Then User should be redirected to the comparison page
    When User clicks on the first checkbox
    And User clicks on the second checkbox
    And User clicks on the Compare button
    Then User should be redirected to the comparison results page
    When User waits for 2 seconds
    And User scrolls to "Account Maintenance Charges"
    Then User should see the Account closure Fee <12 months for 'Business Basic Account'
    And User should see the Account closure Fee <12 months for 'Business Advantage Account'