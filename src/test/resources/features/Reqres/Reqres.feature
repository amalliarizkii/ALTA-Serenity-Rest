Feature: Features to test Reqres

  @Latihan #PositiveCase(TC_001)
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameter page <page>
    When Send request get list user
    Then Should return 200 OK
    And Response body page should <page>
    And Get list user json schema validator
    Examples:
    |page|
    |1   |
    |2   |

  @Tugas #NegativeCase(TC_001)
  Scenario Outline: Get list user with alphabet parameter page
    Given Get list user with alphabet parameter page "<page>"
    When Send request get list user
    Then Should return 404 Not found
    Examples:
      |page|
      |one |
      |two |

  @Tugas #NegativeCase(TC_002)
  Scenario Outline: Get list user with not registered parameter page
    Given Get list user with not registered parameter page <page>
    When Send request get list user
    Then Should return 404 Not found
    Examples:
    |page|
    |10  |
    |20  |

  @Tugas #NegativeCase(TC_003)
  Scenario Outline: Get list user with invalid parameter page
    Given Get list user with invalid parameter page "<page>"
    When Send request get list user
    Then Should return 404 Not found
    Examples:
    |page|
    |@!@ASF|
    |*#DF#*|

  @Tugas #PositiveCase(TC_004)
  Scenario Outline: Get single user with valid id
    Given Get single user with valid id <id>
    When Send request get single user
    Then Should return 200 OK
    And Response body should contain first name "<first_name>" and last name "<last_name>"
    And Get single user json schema validator
    Examples:
    |id|first_name|last_name|
    |6 |Tracey    |Ramos    |
    |8 |Lindsay   |Ferguson |

  @Tugas #NegativeCase(TC_005)
  Scenario Outline: Get single user with not registered id
    Given Get single user with not registered id <id>
    When Send request get single user
    Then Should return 404 Not found
    Examples:
    |id|
    |25|
    |50|

  @Tugas #NegativeCase(TC_006)
  Scenario Outline: Get single user with invalid id
    Given Get single user with invalid id "<id>"
    When Send request get single user
    Then Should return 404 Not found
    Examples:
    |id  |
    |*CF#|
    |#FG$|

  @Tugas #PositiveCase(TC_007)
  Scenario Outline: Get list resource with valid parameter page
    Given Get list resource with parameter page <page>
    When Send request get list resource
    Then Should return 200 OK
    And Response body page should <page>
    And Get single resource json schema validator
    Examples:
      |page|
      |1   |

  @Tugas #NegativeCase(TC_008)
  Scenario Outline: Get list resource with not registered parameter page
    Given Get list resource with not registered parameter page <page>
    When Send request get list resource
    Then Should return 404 Not found
    Examples:
      |page|
      |5   |
      |10  |

  @Tugas #(NegativeCase(TC_009)
  Scenario Outline: Get list resource with alphabet parameter page
    Given Get list resource with alphabet parameter page "<page>"
    When Send request get list resource
    Then Should return 404 Not found
    Examples:
      |page|
      |one |
      |two |

  @Tugas #NegativeCase(TC_010)
  Scenario Outline: Get list resource with invalid parameter page
    Given Get list resource with invalid parameter page "<page>"
    When Send request get list resource
    Then Should return 404 Not found
    Examples:
      |page|
      |@!@ASF|
      |*#DF#*|





















