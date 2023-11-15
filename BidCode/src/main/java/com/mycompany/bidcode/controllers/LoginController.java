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
import javax.servlet.http.HttpSession;
import model.User;
import service.AuctionService;

/**
 *
 * @author thang
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
    
    private AuctionService auctionService = new AuctionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF=8");
        HttpSession session = req.getSession();
        req.setAttribute("message", session.getAttribute("message"));
        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req, resp);
        session.removeAttribute("message");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = auctionService.authenticateUser(username, password);
        if(user != null) {
            session.setAttribute("loginUser", user);
            resp.sendRedirect("/listItems");
        } else {
            session.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
            resp.sendRedirect("/login");
        }
    }
    
    
}
