Feature: YTSkipAd

  Scenario Outline: Subscribe to channel
    Given I have opened the browser
    When I maximize the window
    And I open the YouTube <fromurl> website
    And I open the video <number>
    And I click skip ad button
    Then The ad replaced by the video

    Examples:
      | fromurl                   | number
      | "https://www.youtube.com/"| 1
      | "https://www.youtube.com/"| 2