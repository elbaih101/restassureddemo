Feature: testing api for restfull Booker
  Scenario: user login and can get booking and create booking
    Given authenticating with path param "/auth" using user name "admin" and password "password123"
   Then reponse return with "token"
