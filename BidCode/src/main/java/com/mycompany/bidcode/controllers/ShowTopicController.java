/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidcode.controllers;

import com.mycompany.bidcode.model.CustomCalendar;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AuctionItem;
import model.Duration;
import service.AuctionService;

/**
 *
 * @author thang
 */

@WebServlet("/showTopics")
public class ShowTopicController extends HttpServlet {
    
    private AuctionService auctionService = new AuctionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        long id = Long.parseLong(req.getParameter("id"));
        AuctionItem auctionItem = auctionService.getAuctionItem(id);
        Duration duration = new Duration(auctionItem.getStartDate(), auctionItem.getEndDate());
        CustomCalendar startDate = new CustomCalendar(auctionItem.getStartDate());
        CustomCalendar endDate = new CustomCalendar(auctionItem.getEndDate());
        req.setAttribute("item", auctionItem);
        req.setAttribute("startDate", startDate);
        req.setAttribute("endDate", endDate);
        req.setAttribute("duration", duration);
        req.setAttribute("message", session.getAttribute("message"));
        RequestDispatcher rd = req.getRequestDispatcher("/showTopics.jsp");
        rd.forward(req, resp);
        session.removeAttribute("message");
    }
    
}
