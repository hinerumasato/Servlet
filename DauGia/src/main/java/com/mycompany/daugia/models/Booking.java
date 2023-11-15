/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daugia.models;

import java.util.Date;

/**
 *
 * @author thang
 */
public class Booking {

    private long id;
    private Customer customer;
    private Date departureDate;
    private int noAdults;
    private int noChildrens;
    private Tour tour;

    public Booking(long id, Customer customer, Date departureDate, int noAdults, int noChildrens, Tour tour) {
        this.id = id;
        this.customer = customer;
        this.departureDate = departureDate;
        this.noAdults = noAdults;
        this.noChildrens = noChildrens;
        this.tour = tour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getNoAdults() {
        return noAdults;
    }

    public void setNoAdults(int noAdults) {
        this.noAdults = noAdults;
    }

    public int getNoChildrens() {
        return noChildrens;
    }

    public void setNoChildren(int noChildren) {
        this.noChildrens = noChildren;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

}
