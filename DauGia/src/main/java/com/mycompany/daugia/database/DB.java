/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daugia.database;

import com.mycompany.daugia.models.Booking;
import com.mycompany.daugia.models.Customer;
import com.mycompany.daugia.models.Tour;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thang
 */
public class DB {
    public List<Tour> tours = new ArrayList<Tour>();
    public List<Customer> customers = new ArrayList<Customer>();
    public List<Booking> bookings = new ArrayList<Booking>();
    public static DB instance;
    private DB() {
        tours.add(new Tour(1, "PHÚ QUỐC (Khuyến mãi mùa hè)", "3 ngày 2 đêm", "Thuyền", "Hằng ngày", 1595000));
        tours.add(new Tour(2, "NHA TRANG", "2 ngày 2 đêm", "Tàu hoả", "Tối thứ 6 và CN", 1540000));
        tours.add(new Tour(3, "CÔN ĐẢO", "3 ngày 2 đêm", "Thuyền", "Hằng ngày", 1345000));
        tours.add(new Tour(4, "PHAN THIẾT - MŨI NÉ", "2 ngày 1 đêm", "Xe khách", "Thứ 7 mỗi tuần", 1250000));
        tours.add(new Tour(5, "ĐÀ LẠT - ĐỒI MỘNG MƠ", "4 ngày 3 đêm", "Xe khách", "Thứ 7 mỗi tuần", 1320000));
        tours.add(new Tour(6, "BUÔN MA THUỘT - GIA LAI - KONTUM", "Định kỳ", "Xe khách", "Hằng ngày", 1790000));
    }
    
    public static DB getInstance() {
        if(instance == null)
            instance = new DB();
        return instance;
    }
    
    public List<Tour> getAllTours() {
        return this.tours;
    }
    
    public long getLastCustomerId() {
        if(customers.isEmpty())
            return 0;
        else return customers.get(customers.size() - 1).getId();
    }
    
    public long getLastBookingId() {
        if(bookings.isEmpty())
            return 0;
        else return bookings.get(bookings.size() - 1).getId();
    }
    
    public void saveBooking(Booking booking) {
        this.bookings.add(booking);
    }
    
    public void saveCustomer(Customer customer) {
        this.customers.add(customer);
    }
}
