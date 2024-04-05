Feature: This feature is to test whether user can navigate and click on the homepage and industry tab

  Scenario Outline: Ensure the elements are present and clickable on homepage
    Given User is on "https://risk.lexisnexis.co.uk"
    When User clicks on link "<URL>"
    Then user should be able to validate the he is navigated to the page with "<Links>"

    Examples:
    |Links|  URL |
    |Financial Services| https://risk.lexisnexis.co.uk/financial-services |
    |Insurance         | https://risk.lexisnexis.co.uk/insurance          |
    |Life and Pensions                  | https://risk.lexisnexis.co.uk/life-and-pension|
    |Corporations and Non-Profits       |https://risk.lexisnexis.co.uk/corporations-and-non-profits|