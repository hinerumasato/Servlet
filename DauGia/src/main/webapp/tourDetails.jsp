<%-- 
    Document   : tourDetails
    Created on : Nov 13, 2023, 9:21:21 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tour Details</title>
    </head>
    
    <style>
        .bookingButton {
            background: blue;
            color: white;
            font-weight: bold;
            padding: 4px 8px;
        }
    </style>
    
    <body>
        <p><strong>${tour.getDescription()}</strong></p>
        <strong>Số ngày: </strong> <span>${tour.getDays()}</span>
        <strong>Phương tiện: </strong> <span>${tour.getTransportation()}</span>
        
        <a style="margin-top: 20px;" class="bookingButton" href="/bookingTour?id=${tour.getId()}">Đặt tour</a>
    </body>
</html>
