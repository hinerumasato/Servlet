<%-- 
    Document   : listTours
    Created on : Nov 13, 2023, 8:03:36 PM
    Author     : thang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Tours</title>
    </head>
    
    <style>
        .bookingButton {
            background: blue;
            color: white;
            font-weight: bold;
            padding: 4px 8px;
        }
        
        table tr td {
            padding: 0 8px;
            height: 30px;
        }
        
        table td, table th {
            border: 1px solid #000;
        }
    </style>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Chương trình</th>
                    <th>Lịch khởi hành</th>
                    <th>Giá</th>
                    <th>Đặt</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tours}" var="tour">
                    <tr>
                        <td>
                            <a href="/tourDetails?id=${tour.getId()}">${tour.getDescription()}</a>
                            <p style="margin: 0;">${tour.getDays()}</p>
                        </td>
                        <td>${tour.getDepartureSchedule()}</td>
                        <td>${tour.getPrice()}</td>
                        <td>
                            <a class="bookingButton" href="/bookingTour?id=${tour.getId()}">Đặt tour</a>
                        </td>
                    </tr>    
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>
