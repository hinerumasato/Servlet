<%-- 
    Document   : listTopics
    Created on : Nov 16, 2023, 12:18:27 AM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Topics</title>
    </head>

    <style>
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

        table th, table td {
            border-left: 1px solid #000;
            border-bottom: 1px solid #000;
            padding: 4px 8px;
        }

        table th {
            background: darkgray;
            border-top: 1px solid #000;
        }

        table tbody tr:nth-child(even) {
            background: aqua;
        }

        table tbody tr:nth-child(odd) {
            background: #FFF;
        }

        table {
            width: 600px;
            border-right: 1px solid #000;
        }

        .topic-amount {
            text-align: center;
        }
        
        .new-topic-btn {
            margin: 8px 0;
        }
    </style>

    <body>
        <div class="header">
            <span>Chào <b>${sessionScope.loginUser.getUsername()}</b> | 
                <form method="POST" action="/logout"><button type="submit">Thoát</button></form>
            </span>
        </div>

        <h2>Diễn đàn: Chuyện học phí và các chính sách hỗ trợ học tập</h2>
        <a href="/newTopic" class="new-topic-btn">Gửi bài mới</a>
        <table>
            <thead>
                <tr>
                    <th>Chủ đề</th>
                    <th>Hồi âm</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${topics}" var="topic" varStatus="status">
                    <tr>
                        <td>
                            <div><a href="/showTopic?id=${topic.getId()}">${topic.getTitle()}</a></div>
                            <c:choose>
                                <c:when test="${topic.getMessages().size() > 0}">
                                    <div>Bài mới nhất by <a href="">${topic.getNewMessage().getCreator().getUsername()}</a>, ${calendars.get(status.index)}</div>
                                </c:when>
                                <c:otherwise>
                                    <div>Bài mới nhất by <a href="">${topic.getCreator().getUsername()}</a>, ${calendars.get(status.index)}</div>
                                </c:otherwise>
                            </c:choose>

                        </td>
                        <td>
                            <div class="topic-amount">${topic.getMessages().size()}</div>
                        </td> 
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>
