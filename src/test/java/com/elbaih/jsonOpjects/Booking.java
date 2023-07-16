package com.elbaih.jsonOpjects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import groovy.transform.ToString;

import java.util.List;

@JsonPropertyOrder({"ID","firstname", "lastname", "totalprice", "depositpaid", "bookingdates", "additionalneeds"})
public class Booking {

@JsonIgnore
    private String ID;
    private String firstname;
    private String lastname;

    private String totalprice;

    private String depositpaid;
    private BookingDates bookingdates;

    private String additionalneeds;

    public Booking() {
    }

    public Booking(String id) {
        this.ID = id;
    }

    public Booking(String firstname, String lastname, String totalprice, String depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;

        this.additionalneeds = additionalneeds;
    }

    public Booking(String firstname, String lastname, String totalprice, String depositpaid, BookingDates bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }
    @JsonIgnore
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

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(String depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "ID='" + ID + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice='" + totalprice + '\'' +
                ", depositpaid='" + depositpaid + '\'' +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}



