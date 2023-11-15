package com.mycompany.daugia.controllers;


import com.mycompany.daugia.models.Tour;
import com.mycompany.daugia.models.TourService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thang
 */

@WebServlet("/tourDetails")
public class TourDetailController extends HttpServlet {
    
    private TourService tourService = new TourService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Tour tour = tourService.getTour(id);
        
        req.setAttribute("tour", tour);
        RequestDispatcher rd = req.getRequestDispatcher("/tourDetails.jsp");
        rd.forward(req, resp);
    }
    
}
