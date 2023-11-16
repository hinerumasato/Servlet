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
            justify-content: flex-start;
        }
        
        .button-actions a {
            background: #99FFCC;
            text-decoration: none;
            padding: 8px 16px;
        }
    </style>

    <body>
        <strong>Thông tin khách hàng</strong>
        
        <table border="1">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Họ tên:</td>
                    <td>${customer.getName()}</td>
                </tr>
                <tr>
                    <td>Địa chỉ:</td>
                    <td>${customer.getAddress()}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${customer.getEmail()}</td>
                </tr>
                <tr>
                    <td>Điện thoại:</td>
                    <td>${customer.getPhone()}</td>
                </tr>
            </tbody>
        </table>

        <strong>Thông tin chuyến đi</strong>
        
        <table border="1">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Ngày khởi hành:</td>
                    <td>${booking.getDepartureDate()}</td>
                </tr>
                <tr>
                    <td>Số người lớn:</td>
                    <td>${booking.getNoAdults()}</td>
                </tr>
                <tr>
                    <td>Số trẻ em:</td>
                    <td>${booking.getNoChildren()}</td>
                </tr>
            </tbody>
        </table>
        
        <div class="button-actions">
            <a href="/listTours">Xác nhận</a>
        </div>
    </body>
</html>
