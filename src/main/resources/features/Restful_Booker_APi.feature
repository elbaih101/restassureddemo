Feature: testing api for restfull Booker

  Scenario: user login and can get booking and create booking
    Given authenticating with path param "/auth" using user name "admin" and password "password123"
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

