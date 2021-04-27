Feature: YTLanguage

  Scenario Outline: Language changes
    Given I have opened the browser for language test
    When I maximize the window for language test
    And I open YouTube
    And I change the language to <language>
    Then Login button contains <text>

    Examples:
      | language       | text       |
      | "English (UK)" | "SIGN IN"  |
      | "Deutsch"      | "ANMELDEN" |
      | "Nederlands"   | "INLOGGEN" |
