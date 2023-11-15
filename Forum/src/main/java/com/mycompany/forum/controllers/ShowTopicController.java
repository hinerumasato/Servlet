/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.forum.controllers;

import com.mycompany.forum.models.CustomCalendar;
import com.mycompany.forum.models.Message;
import com.mycompany.forum.models.Topic;
import com.mycompany.forum.services.ForumService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet("/showTopic")
public class ShowTopicController extends HttpServlet {
    
    private ForumService forumService = ForumService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Topic topic = forumService.findTopic(id);
        List<CustomCalendar> calendars = new ArrayList<CustomCalendar>();
        for (Message message : topic.getMessages()) {
            calendars.add(new CustomCalendar(message.getCreatedTime()));
        }
        
        CustomCalendar topicCalendar = new CustomCalendar(topic.getCreatedTime());
        req.setAttribute("topic", topic);
        req.setAttribute("topicCalendar", topicCalendar);
        req.setAttribute("calendars", calendars);
        RequestDispatcher rd = req.getRequestDispatcher("/showTopic.jsp");
        rd.forward(req, resp);
    }
    
}
