/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.forum.controllers;

import com.mycompany.forum.models.Message;
import com.mycompany.forum.models.Topic;
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

@WebServlet("/replyTopic")
public class ReplyTopicController extends HttpServlet {
    
    private ForumService forumService = ForumService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String reply = req.getParameter("reply");
        RequestDispatcher rd = req.getRequestDispatcher("/replyTopic.jsp");
        
        req.setAttribute("id", id);
        req.setAttribute("reply", reply);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        User user = (User) session.getAttribute("loginUser");
        
        Topic topic = forumService.findTopic(id);
        Message message = new Message(title, description, user);
        forumService.saveMessage(topic, message);
        
        resp.sendRedirect("/showTopic?id=" + id);
    }
    
    
    
}
