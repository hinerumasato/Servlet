/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.forum.controllers;

import com.mycompany.forum.models.CustomCalendar;
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
@WebServlet("/listTopics")
public class ListTopicsController extends HttpServlet {

    private ForumService forumService = ForumService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        RequestDispatcher rd = req.getRequestDispatcher("/listTopics.jsp");
        List<Topic> topics = new ArrayList<>(forumService.getTopics());
        System.out.println("SIZE = " + topics.size());
        List<CustomCalendar> customCalendars = new ArrayList<CustomCalendar>();
        for (Topic topic : topics) {
            if (topic.getMessages().size() > 0) {
                customCalendars.add(new CustomCalendar(topic.getNewMessage().getCreatedTime()));
            } else {
                customCalendars.add(new CustomCalendar(topic.getCreatedTime()));
            }
        }
        
        System.out.println(customCalendars);
        
        req.setAttribute("topics", topics);
        req.setAttribute("calendars", customCalendars);

        rd.forward(req, resp);
    }

}
