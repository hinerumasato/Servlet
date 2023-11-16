/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tourcode.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.tourcode.services.TourService;

/**
 *
 * @author thang
 */
@WebServlet("/listTours")
public class ListToursController extends HttpServlet {
    
    private TourService tourService = new TourService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        req.setAttribute("tours", tourService.getAllTours());
        
        RequestDispatcher rd = req.getRequestDispatcher("/listTours.jsp");
        rd.forward(req, resp);
    }
    
    
}
