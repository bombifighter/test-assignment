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
      | fromurl                    | wrongusername       | responsetext                                                                                                     | text                         |
      | "https://www.youtube.com/" | "asdasdfdfafadfasdasd" | "#view_container > div > div > div.pwWryf.bxPAYd > div > div.WEQkZc > div > form > span > section > div > div > div.d2CFce.cDSmF.cxMOTc > div > div.LXRPh > div.dEOOab.RxsGPe > div" | "Couldn't find your Google Account"|
