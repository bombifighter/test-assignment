Feature: YTSearch

  Scenario Outline: Search rolls
    Given I have opened the browser
    When I maximize the window
    And I open the YouTube <fromurl> website
    And I enter <searchwords> in the search bar
    Then The title element <titleelement> should be <title>

    Examples:
      | fromurl                    | searchwords               | titleelement                                                                                                                                                                                                                                  | title                                           |
      | "https://www.youtube.com/" | "never gonna give you up" | "/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string" | "Rick Astley - Never Gonna Give You Up (Video)" |
      | "https://www.youtube.com/" | "wednesday ritual"        | "/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string" | "The Wednesday ritual"                          |
