<%-- 
    Document   : bookingTours.jsp
    Created on : Nov 13, 2023, 8:26:33 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Tour</title>
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
        <p style="font-size: 40px;">Đặt tour: <strong>${tour.getDescription()}</strong> ${tour.getDays()}<p>
        <form action="/saveCustomer" method="POST">
            <strong>Thông tin khách hàng</strong>
            <div class="form-group">
                <label>Họ tên (*)</label>
                <input type="text" name="name" />
            </div>
            <div class="form-group">
                <label>Địa chỉ:</label>
                <input type="text" name="address" />
            </div>
            <div class="form-group">
                <label>Email (*)</label>
                <input type="email" name="email" />
            </div>
            <div class="form-group">
                <label>Điện thoại (*)</label>
                <input type="text" name="phone" />
            </div>
            
            <strong>Thông tin chuyến đi</strong>
            <div class="form-group">
                <label>Ngày khởi hành: (*)</label>
                <input type="text" name="date" />
            </div>
            
            <div class="form-group">
                <label>Số người lớn: (*)</label>
                <input type="number" name="noAdults" />
            </div>
            <div class="form-group">
                <label>Số trẻ em:</label>
                <input type="number" name="noChildrens" />
            </div>
            
            <input type="hidden" name="id" value="${tour.getId()}" />
            
            <div class="button-actions">
                <button type="submit">Gởi</button>
                <a href="/listTours">Huỷ</a>
            </div>
        </form>
    </body>
</html>
