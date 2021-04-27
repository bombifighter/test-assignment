Feature: YTSettings

  Scenario Outline: Login window appears
    Given I have opened the browser for settings test
    When I maximize the window on YT Login needed test
    And I open the YouTube <fromurl> website for YT Login needed test
    And I click on the <button> button
    And I click on the Login button
    Then The destination URL should be <toURL>

    Examples:
      | fromurl                                                    | button                                                                                                                                                                                  | toURL
      | "https://www.youtube.com/"                                 | "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-entry-renderer[3]/a/tp-yt-paper-item"           | "https://accounts.google.com/signin/v2/identifier?service=youtube&uilel=3&passive=true&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Dhu%26next%3Dhttps%253A%252F%252Fwww.youtube.com%252Faccount%253Fpbjreload%253D102%26feature%3Dredirect_login&hl=hu&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
      | "https://www.youtube.com/" | "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[2]/div/ytd-guide-entry-renderer[1]/a/tp-yt-paper-item"           | "https://accounts.google.com/signin/v2/identifier?service=youtube&uilel=3&passive=true&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Dhu%26next%3D%252Ffeed%252Flibrary&hl=hu&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
      | "https://www.youtube.com/"                     | "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[2]/div/ytd-guide-entry-renderer[2]/a/tp-yt-paper-item"           | "https://accounts.google.com/signin/v2/identifier?service=youtube&uilel=3&passive=true&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Dhu%26next%3D%252Ffeed%252Fhistory&hl=hu&flowName=GlifWebSignIn&flowEntry=ServiceLogin"