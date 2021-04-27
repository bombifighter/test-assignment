Feature: YTLoginNeeded

  Scenario Outline: Login window appears
    Given I have opened the browser for settings test
    When I maximize the window on YT Login needed test
    And I open the YouTube <fromurl> website for YT Login needed test
    And I click on the <button> button
    And I click on the Login button
    Then The destination URL should be bejelentkezes

    Examples:
      | fromurl                       | button |
      | "https://www.youtube.com/"    | "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-entry-renderer[3]/a/tp-yt-paper-item" |
      | "https://www.youtube.com/channel/UCEgdi0XIXXZ-qJOFPf4JSKw"    | "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[2]/div/ytd-guide-entry-renderer[1]/a/tp-yt-paper-item" |