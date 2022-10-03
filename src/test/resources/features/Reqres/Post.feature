Feature: Features to test Reqres

  @Latihan #PositiveCase(TC_002)
  Scenario: Post create new user with valid json
    Given Post create new user
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "Tamara Rizki" and job "Junior QA"
    And Post create new user json schema validator

  @Tugas #NegativeCase(TC_011)
  Scenario: Post create new user with empty job
    Given Post create new user with empty job
    When Send request post create new user
    Then Should return 400 Bad request
    And Post create new user with empty job json schema validator

  @Tugas #NegativeCase(TC_012)
  Scenario: Post create new user with empty name
    Given Post create new user with empty name
    When Send request post create new user
    Then Should return 400 Bad request
    And Post create new user with empty name json schema validator

  @Tugas #PositiveCase(TC_013)
  Scenario: Post register successful with valid email and password
    Given Post register successful with valid email and password
    When Send request post register successful
    Then Should return 200 OK
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"
    And Post register successful json schema validator

  @Tugas #NegativeCase(TC_014)
  Scenario: Post register unsuccessful with empty password
    Given Post register unsuccessful with empty password
    When Send request post register unsuccessful
    Then Should return 400 Bad request
    And Response body should contain error "Missing password"
    And Post register unsuccessful with empty password json schema validator

  @Tugas #NegativeCase(TC_015)
  Scenario: Post register unsuccessful with empty email
    Given Post register unsuccessful with empty email
    When Send request post register unsuccessful
    Then Should return 400 Bad request
    And Response body should contain error "Missing email or username"
    And Post register unsuccessful with empty email json schema validator

  @Tugas #NegativeCase(TC_016)
  Scenario: Post register unsuccessful with invalid email and password
    Given Post register unsuccessful with invalid email and password
    When Send request post register unsuccessful
    Then Should return 400 Bad request
    And Response body should contain error "Note: Only defined users succeed registration"
    And Post register unsuccessful with invalid email and password json schema validator

  @Tugas #PositiveCase(TC_017)
  Scenario: Post login successful with valid email and password
    Given Post login successful with valid email and password
    When Send request post login successful
    Then Should return 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"
    And Post login successful json schema validator

  @Tugas #NegativeCase(TC_018)
  Scenario: Post login unsuccessful with empty password
    Given Post login unsuccessful with empty password
    When Send request post login unsuccessful
    Then Should return 400 Bad request
    And Response body should contain error "Missing password"
    And Post login unsuccessful with empty password json schema validator

  @Tugas #NegativeCase(TC_019)
  Scenario: Post login unsuccessful with empty email
    Given Post login unsuccessful with empty email
    When Send request post login unsuccessful
    Then Should return 400 Bad request
    And Response body should contain error "Missing email or username"
    And Post login unsuccessful with empty email json schema validator

  @Tugas #NegativeCase(TC_020)
  Scenario: Post login unsuccessful with invalid email and password
    Given Post login unsuccessful with invalid email and password
    When Send request post login unsuccessful
    Then Should return 400 Bad request
    And Response body should contain error "user not found"
    And Post login unsuccessful with invalid email and password json schema validator