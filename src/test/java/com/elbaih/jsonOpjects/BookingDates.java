package com.elbaih.jsonOpjects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"checkin","checkout"})
public class BookingDates {



   private String checkin;
   private String checkout;
    public BookingDates(){}

    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    public String getBookingDates()
    { String s=
        getCheckin().toString()+"\n"+ getCheckout().toString();

        return s;
    }
}
