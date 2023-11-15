/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.forum.controllers;

import com.mycompany.forum.models.User;
import com.mycompany.forum.services.ForumService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thang
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    
    private ForumService forumService = ForumService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        HttpSession session = req.getSession();
        req.setAttribute("message", session.getAttribute("message"));
        rd.forward(req, resp);
        session.removeAttribute("message");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        
        User user = forumService.checkUser(username, password);
        
        if(user != null) {
            session.setAttribute("loginUser", user);
            resp.sendRedirect("/listTopics");
        } else {
            session.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
            resp.sendRedirect("/login");
        }
    }
    
    
    
}
