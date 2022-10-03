Feature: Features to test Reqres

  @Latihan #PositiveCase(TC_003)
  Scenario Outline: Put update user with valid json
    Given Put update user with id <id>
    When Send request put update user
    Then Should return 200 OK
    And Response body should contain name "Tamara New" and job "QA New"
    Examples:
      |id|
      |1 |
      |2 |