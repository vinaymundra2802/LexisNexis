Feature: This feature is to test whether user can navigate and click on the homepage and industry tab
  Scenario Outline: Ensure the elements are present and clickable in choose industry tab

    Given User is on "https://risk.lexisnexis.co.uk"
    When  User clicks on link Choose Your Industry tab
    Then  user should be able to validate the he can click on submenu "<Sub-menus>"

    Examples:
      | Sub-menus                  |
      | Financial Crime Compliance |
      | Customer Data Management   |
      | Collections and Recovery         |
      | Risk Orchestration               |
      | Fraud and Identity Management    |
      | Credit Risk Assessment           |
      | Investigations and Due Diligence |