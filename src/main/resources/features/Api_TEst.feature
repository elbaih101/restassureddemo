Feature: Api TEst
  Scenario Outline: client request for the us time zone
    When requestin the get request with "<country>" "<zipcode>"

    Then the response must return code 200 andcontent type of "json"
    Then the check the response body for the place to be "<place>"
    Then  check reponse body fore the state to be "<state>"
    Then check whether the collection places has item "<SA>"
    Examples:
      |country|zipcode|place|state|SA|
      |us     |90210  |Beverly Hills|California|CA|
      |us     |12345  |Schenectady|New York    |NY|
      |ca     |B2R    |Waverley|Nova Scotia    |NS|
      |DE    |01067  |Dresden  |Sachsen        |SN|
