/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidcode.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.bidcode.service.AuctionService;

/**
 *
 * @author thang
 */

@WebServlet("/listItems")
public class ListItemController extends HttpServlet {
    
    private AuctionService auctionService = new AuctionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        
        req.setAttribute("auctionItems", auctionService.getAllAuctionItems());
        
        RequestDispatcher rd = req.getRequestDispatcher("listItems.jsp");
        rd.forward(req, resp);
    }
    
}
