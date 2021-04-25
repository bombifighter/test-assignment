Feature: YTsearch

  Scenario Outline: Search rolls
    Given I have opened the browser
    When I maximize the window
    And I open the YouTube <fromurl> website
    And I enter <searchwords> in the search bar
    Then The title element <titleelement> should be <title>

    Examples:
      | fromurl                    | searchwords               | titleelement                                 | title                                           |
      | "https://www.youtube.com/" | "never gonna give you up" | "//*[@id='video-title']/yt-formatted-string" | "Rick Astley - Never Gonna Give You Up (Video)" |
      | "https://www.youtube.com/" | "wednesday ritual"        | "//*[@id='video-title']/yt-formatted-string" | "The Wednesday ritual"                          |
