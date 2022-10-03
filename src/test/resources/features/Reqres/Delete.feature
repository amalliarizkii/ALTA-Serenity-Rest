Feature: Features to test Reqres

  @Latihan #PositiveCase(TC_004)
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return 204 No content
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas #NegativeCase(TC_021)
  Scenario Outline: Delete user with not registered id
    Given Delete user with not registered id <id>
    When Send request delete user
    Then Should return 400 Bad request
    Examples:
      |id|
      |50|
      |100|

  @Tugas #PostiveCase(TC_022)
  Scenario Outline: Delete user with invalid id
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Should return 400 Bad request
    Examples:
      |id|
      |@#NSNS|
      |n#@*J |