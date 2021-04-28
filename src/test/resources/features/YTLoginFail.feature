Feature: YTLoginfail

  Scenario Outline: Login fail
    Given I have opened the browser for YT Login fail
    When I maximize the window on YT Login Fail test
    And I open the YouTube <fromurl> website for YT Login Fail
    And I click the login button
    And I write <wrongusername> to the username field
    And I click next button
    Then The <responsetext> should be <text>

    Examples:
      | fromurl                    | wrongusername          | responsetext                                                                                                                      | text                                |
      | "https://www.youtube.com/" | "asdasdfdfafadfasdasd" | "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div" | "Couldn't find your Google Account" |
