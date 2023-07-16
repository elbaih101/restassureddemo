Feature: testing api for restfull Booker
Background:
  Given authenticating with path param "/auth" using user name "admin" and password "password123"
  Scenario: user login and can get booking and create booking
    When sending get "/booking" Request
    Then REsponse returns with Booking Ids

    Scenario: getting bookings with id
      When sending a get Request with path param"/booking/{id}" and "id"
      Then response is returned with the booking infos

     Scenario Outline: posting a booking request
        When posting a request with data as "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"

        Then its ok
       Examples:
         |firstname|lastname|totalprice|depositpaid|checkin|checkout|additionalneeds|
         |mohamed  |aly     |300       |true       |2018-01-01|2019-01-01|Breakfast|


       Scenario Outline: dleting an entery
         When sending delete request with url "/booking/{id}" and "<id>" and body with "authentication"
         Then a succsefull status code 200 is returned
         Examples:
           |id|
           |6|
         Scenario Outline: confirming deletion of a deleted entery
           When when sending a get request with url "/booking/{id}" and "<id>" response body is empty
           Examples:
             |id|
             |6|

           Scenario Outline: update request
             When sending put request for booking "/booking/{id}" "<id>" with data as "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"


             Examples:
              |id|firstname|lastname|totalprice|depositpaid|checkin|checkout|additionalneeds|
              |1|mohamed  |aly     |300       |true       |2018-01-01|2019-01-01|Breakfast|