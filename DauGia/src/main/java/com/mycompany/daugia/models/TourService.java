/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daugia.models;

import com.mycompany.daugia.database.DB;
import java.util.List;

/**
 *
 * @author thang
 */
public class TourService {
    public List<Tour> getAllTours() {
        return DB.getInstance().getAllTours();
    }
    
    public Tour getTour(long id) {
        List<Tour> tours = getAllTours();
        for (Tour tour : tours) {
            if(tour.getId() == id)
                return tour;
        }
        return null;
    }
    
    public void saveCustomer(Customer customer) {
        
    }
    
    public void saveBooking(Booking booking) {
        
    }
    
    public long getLastCustomerId() {
        return DB.getInstance().getLastCustomerId();
    }
    
    public long getLastBookingId() {
        return DB.getInstance().getLastBookingId();
    }
}
