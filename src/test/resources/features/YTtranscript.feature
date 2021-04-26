Feature: YTtranscript

  Scenario Outline: Transcript window appears
    Given I have opened the browser for transcript test
    When I maximize the window on transcript test
    And I open the YouTube video from <fromurl>
    And I open the transcript section
    Then Transcript element appears

    Examples:
      | fromurl                                       |
      | "https://www.youtube.com/watch?v=8IQbF0IK-f4" |
