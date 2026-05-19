Feature: Alerts in Webpages

  Scenario Outline: : Clicking the JS alerts in Herokuapp
    When I am on the JS alerts page
    Then I click the "<alerts>" alert
    Then I accept the "<alerts>" alert
    Examples:
      | alerts        |
      | alert         |
      | confirm       |
      | confirmCancel |
      | prompt        |
