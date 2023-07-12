Feature: testing api for restfull Booker

  Scenario: user login and can get booking and create booking
    Given authenticating with path param "/auth" using user name "admin" and password "password123"
    When sending get "/booking" Request
    Then REsponse returns with Booking Ids

    Scenario: getting bookings with id
      When sending a get Request with path param"/booking/{id}" and "id"
      Then response is returned with the booking infos

