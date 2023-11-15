/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daugia.controllers;

import com.mycompany.daugia.models.Booking;
import com.mycompany.daugia.models.Customer;
import com.mycompany.daugia.models.Tour;
import com.mycompany.daugia.models.TourService;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thang
 */

@WebServlet("/saveCustomer")
public class SaveCustomerController extends HttpServlet {
    
    private TourService tourService = new TourService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        
        String rawDate = req.getParameter("date");
        int day = Integer.parseInt(rawDate.split("/")[0]);
        int month = Integer.parseInt(rawDate.split("/")[1]);
        int year = Integer.parseInt(rawDate.split("/")[2]);
        Date date = new Date(year, month, day);
        int noAdults = Integer.parseInt(req.getParameter("noAdults"));
        int noChildrens = Integer.parseInt(req.getParameter("noChildrens"));
        long id = Long.parseLong(req.getParameter("id"));
        long customerId = tourService.getLastCustomerId() + 1;
        long bookingId = tourService.getLastBookingId() + 1;
        
        Tour tour = tourService.getTour(id);
        Customer customer = new Customer(customerId, name, address, email, phone);
        Booking booking = new Booking(bookingId, customer, date, noAdults, noChildrens, tour);
        
        tourService.saveCustomer(customer);
        tourService.saveBooking(booking);
        
        req.setAttribute("customer", customer);
        req.setAttribute("booking", booking);
        
        RequestDispatcher rd = req.getRequestDispatcher("/bookTour.jsp");
        rd.forward(req, resp);
    }
    
}
