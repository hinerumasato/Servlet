/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daugia.controllers;

import com.mycompany.daugia.models.TourService;
import java.io.IOException;
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

@WebServlet("/bookingTour")
public class BookingTourController extends HttpServlet {
    
    private TourService tourService = new TourService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("tour", tourService.getTour(id));
        RequestDispatcher rd = req.getRequestDispatcher("/bookingTour.jsp");
        rd.forward(req, resp);
    }
    
}
