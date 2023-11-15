/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidcode.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AuctionItem;
import model.User;
import service.AuctionService;

/**
 *
 * @author thang
 */
@WebServlet("/bid")
public class BidController extends HttpServlet {
    
    private AuctionService auctionService = new AuctionService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        
        long id = Long.parseLong(req.getParameter("id"));
        double amount = Double.parseDouble(req.getParameter("amount"));
        User user = (User) session.getAttribute("loginUser");
        AuctionItem auctionItem = auctionService.getAuctionItem(id);
        double bidAmount  = auctionItem.getCurrentPrice() > 0 ? auctionItem.getCurrentPrice() : auctionItem.getInitialPrice();
        if(amount >= bidAmount) {
            auctionService.bid(user, auctionItem, amount);
            resp.sendRedirect("/listItems");
        }
        else {
            session.setAttribute("message", "Giá đặt không hợp lệ");
            resp.sendRedirect("/showTopics?id=" + id);
        }
        
    }
    
}
