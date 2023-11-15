<%-- 
    Document   : showTopic
    Created on : Nov 16, 2023, 1:12:17 AM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Topic</title>
    </head>

    <style>
        .message-date {
            background: darkgray;
            padding: 4px 8px;
        }

        .header {
            display: flex;
            justify-content: flex-end;
        }

        .header form {
            display: inline-block;
        }

        .header form button {
            border: none;
            outline: none !important;
            background: transparent;
            color: blue;
            cursor: pointer;
            text-decoration: underline;
            font-weight: bold;
        }

        .message {
            margin-top: 20px;
            width: 600px;
            margin-left: auto;
            margin-right: auto;
        }

        .message-info {
            display: flex;
            justify-content: space-between;
        }

        .message-author {
            width: 30%;
            background: aquamarine;
            text-align: center;
            display: flex;
            align-items: center;
        }

        .message-details {
            width: 70%;
        }

        .message-title {
            background: aqua;
            font-weight: bold;
            margin: 0;
            display: flex;
            justify-content: space-between;
            padding: 4px 6px;
        }
    </style>

    <body>

        <div class="header">
            <span>Chào <b>${sessionScope.loginUser.getUsername()}</b> | 
                <form method="POST" action="/logout"><button type="submit">Thoát</button></form>
            </span>
        </div>

        <div class="message">
            <div class="message-date">${topicCalendar}</div>
            <div class="message-info">
                <div class="message-author">
                    <div class="wrapper">
                        <div><b>${topic.getCreator().getUsername()}</b></div>
                        <div>${topic.getCreator().getJoinDate()}</div>
                    </div>
                </div>
                <div class="message-details">
                    <h4 class="message-title">
                        <span>${topic.getTitle()}</span>
                        <a href="/replyTopic?id=${topic.getId()}&reply=${topic.getTitle()}">Trả lời</a>
                    </h4>
                    <div class="message-content">${topic.getContent()}</div>
                </div>
            </div>
        </div>

        <c:forEach items="${topic.getMessages()}" var="message" varStatus="status">
            <div class="message">
                <div class="message-date">${calendars.get(status.index)}</div>
                <div class="message-info">
                    <div class="message-author">
                        <div class="wrapper">
                            <div><b>${message.getCreator().getUsername()}</b></div>
                            <div>${message.getCreator().getJoinDate()}</div>
                        </div>
                    </div>
                    <div class="message-details">
                        <h4 class="message-title">
                            <span>${topic.getTitle()}</span>
                            <a href="/replyTopic?id=${topic.getId()}&reply=${message.getTitle()}">Trả lời</a>
                        </h4>
                        <div class="message-content">${message.getContent()}</div>
                    </div>
                </div>
            </div>
        </c:forEach>

        <div style="text-align: right;">
            <a href="/listTopics">Danh sách chủ đề</a>
        </div>
    </body>
</html>
