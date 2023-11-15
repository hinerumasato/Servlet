<%-- 
    Document   : showTopic
    Created on : Nov 15, 2023, 10:06:23 PM
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
        .header {
            background: aquamarine;
            display: flex;
            justify-content: flex-end;
            padding: 8px 16px;
        }

        button[type="submit"] {
            background: transparent;
            border: none;
            outline: none !important;
            color: blue;
            font-weight: bold;
            cursor: pointer;
        }

        .username {
            color: blue;
        }

        form {
            display: inline;
        }

        table tr td, table tr th {
            border: solid 1px #000;
            padding: 0 8px;
        }
        
        table tr th {
            background: aqua;
        }

        .alert {
            background: darkgray;
            color: red;
            text-align: center;
            margin: 8px 0;
        }
    </style>

    <body>
        <div class="header">
            <span>
                Chào mừng <b class="username">${sessionScope.loginUser.getUsername()}</b> | 
                <form method="POST" action="/logout">
                    <button type="submit">Thoát</button>
                </form>
            </span>
        </div>

        <c:if test="${not empty message}">
            <div class="alert">${message}</div>
        </c:if>

        <table>
            <thead>
                <tr>
                    <th></th>
                    <th><b>Thông tin người bán</b></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <form method="POST" action="/bid">
                            <c:choose>
                                <c:when test="${item.getCurrentPrice() > 0}">
                                    <div>Giá hiện tại: ${item.getCurrentPrice()}</div>
                                </c:when>
                                <c:otherwise>
                                    <div>Giá hiện tại: ${item.getInitialPrice()}</div>
                                </c:otherwise>
                            </c:choose>

                            <c:if test="${item.getBids().size() > 0}">
                                <div>Người đặt: ${item.getBids().get(item.getBids().size() - 1).getBidder().getUsername() }</div>
                            </c:if>

                            <div>Giá khởi điểm: ${item.getInitialPrice()}</div>
                            <div>Bước giá: ${item.getPriceStep()}</div>
                            <div>Bắt đầu lúc: ${startDate}</div>
                            <div>Kết thúc lúc: ${endDate}</div>
                            <div>Thời gian còn: ${duration}</div>
                            <c:choose>
                                <c:when test="${item.getCurrentPrice() > 0}">
                                    <div><b>Giá đặt: </b> <input type="number" name="amount" /> >= ${item.getCurrentPrice() + item.getPriceStep()}</div>
                                    </c:when>
                                    <c:otherwise>
                                    <div><b>Giá đặt: </b> <input type="number" name="amount" /> >= ${item.getInitialPrice() + item.getPriceStep()}</div>
                                    </c:otherwise>
                                </c:choose>

                            <input type="hidden" value="${item.getId()}" name="id" />
                            <button type="submit">Đặt giá</button>
                        </form>

                        <a href="/listItems">Danh sách đấu giá</a>
                    </td>

                    <td>
                        <div><b>Tên tài khoản:</b> <a>${item.getSeller().getUsername()}</a></div>
                        <div><b>Tên cửa hàng:</b> ${item.getSeller().getFullName()}</div>
                        <div><b>Điện thoại:</b> ${item.getSeller().getPhone()}</div>
                        <div><b>Email: </b> <a>${item.getSeller().getEmail()}</a></div>
                        <div><b>Địa chỉ:</b> ${item.getSeller().getAddress()}</div>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
