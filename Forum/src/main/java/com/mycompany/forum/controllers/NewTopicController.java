/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.forum.controllers;

import com.mycompany.forum.models.Category;
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

@WebServlet("/newTopic")
public class NewTopicController extends HttpServlet {
    
    private ForumService forumService = ForumService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/newTopic.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        User user = (User) session.getAttribute("loginUser");
        
        
        int id = forumService.getCurrentId();
        
        Topic topic = new Topic(id, title, description, user, new Category("Học hành"));
        forumService.saveTopic(topic);
        
        System.out.println("NEW TOPIC: " + forumService.findTopic(id));
        
        resp.sendRedirect("/listTopics");
    }
    
    
    
}
