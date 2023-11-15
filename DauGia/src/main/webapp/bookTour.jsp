<%-- 
    Document   : bookTour
    Created on : Nov 13, 2023, 9:05:24 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <style>
        .form-group {
            width: 400px;
            display: flex;
            justify-content: space-between;
            margin-top: 4px;
        }

        .form-group label {
            display: block;
            width: 150px;
        }

        .button-actions {
            margin-top: 8px;
            width: 400px;
            display: flex;
            justify-content: flex-end;
        }
    </style>

    <body>
        <strong>Thông tin khách hàng</strong>
        <div class="form-group">
            <label>Họ tên (*)</label>
            <p>${customer.getName()}</p>
        </div>
        <div class="form-group">
            <label>Địa chỉ:</label>
            <p>${customer.getAddress()}</p>
        </div>
        <div class="form-group">
            <label>Email (*)</label>
            <p>${customer.getEmail()}</p>
        </div>
        <div class="form-group">
            <label>Điện thoại (*)</label>
            <p>${customer.getPhone()}</p>
        </div>

        <strong>Thông tin chuyến đi</strong>
        <div class="form-group">
            <label>Ngày khởi hành: (*)</label>
            <p>${booking.getDepartureDate()}</p>
        </div>

        <div class="form-group">
            <label>Số người lớn: (*)</label>
            <p>${booking.getNoAdults()}</p>
        </div>
        <div class="form-group">
            <label>Số trẻ em:</label>
            <p>${booking.getNoChildrens()}</p>
        </div>
        
        <div class="button-actions">
            <a href="/listTours">Xác nhận</a>
        </div>
    </body>
</html>
