package com.elbaih.jsonOpjects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import groovy.transform.ToString;

import java.util.List;

@JsonPropertyOrder({"firstname", "lastname", "totalprice", "depositpaid", "bookingdates", "additionalneeds"})
public class Booking {


    private String ID;
    private String firstname;
    private String lastname;

    private int totalprice;

    private String depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public Booking() {
    }

    public Booking(String id) {
        this.ID = id;
    }

    public Booking(String firstname, String lastname, int totalprice, String depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;

        this.additionalneeds = additionalneeds;
    }

    public Booking(String firstname, String lastname, int totalprice, String depositpaid, BookingDates bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(String depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getBookingdates() {
         String s= bookingdates.getBookingDates();
         return s;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public String getBooking() {
        String s =
        getID().toString()+"\n"+
        getFirstname().toString()+"\n"+
        getLastname().toString()+"\n"+
        getDepositpaid().toString()+"\n"+
        getTotalprice().toString()+"\n"+
        getBookingdates().toString()+"\n"+
        getAdditionalneeds();

        return s;

    }


}
