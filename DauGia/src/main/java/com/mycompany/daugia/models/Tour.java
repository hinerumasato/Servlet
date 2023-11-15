/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daugia.models;

/**
 *
 * @author thang
 */
public class Tour {

    private long id;
    private String description;
    private String days;
    private String transportation;
    private String departureSchedule;
    private double price;

    public Tour(long id, String description, String days, String transportation, String departureSchedule, double price) {
        this.id = id;
        this.description = description;
        this.days = days;
        this.transportation = transportation;
        this.departureSchedule = departureSchedule;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getDepartureSchedule() {
        return departureSchedule;
    }

    public void setDepartureSchedule(String departureSchedule) {
        this.departureSchedule = departureSchedule;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
