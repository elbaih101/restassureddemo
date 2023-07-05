Feature: Api TEst
  Scenario: client request for the us time zone
    When requestin the get request "http://zippopotam.us/us/90210"
    Then the response must return code 200 andcontent type of "json"