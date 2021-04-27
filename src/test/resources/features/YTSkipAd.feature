Feature: YTSkipAd

  Scenario Outline: Skip Ad
    Given I have opened the browser for ad test
    When I maximize the window for ad test
    And I open the YouTube <fromurl> website for ad test
    Then Skip the ad

    Examples:
      | fromurl                                      |
      | "https://www.youtube.com/watch?v=PAgQHcKMOIk"|
      | "https://www.youtube.com/watch?v=SiBXgBUUihM"|

