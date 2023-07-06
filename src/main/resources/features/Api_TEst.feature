Feature: Api TEst
  Scenario Outline: client request for the us time zone
    When requestin the get request with "<country>" "<zipcode>"

    Then the response must return code 200 andcontent type of "json"
    Then the check the response body for the place to be "<place>"
#    Then  check reponse body fore the state to be "California"
#    Then check whether the collection places has item "CA"
    Examples:
      |country|zipcode|place|
      |us     |90210  |Beverly Hills|
      |us     |12345  |Schenectady|
      |ca     |B2R    |Waverley|
