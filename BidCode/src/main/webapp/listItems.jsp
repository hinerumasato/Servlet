<%-- 
    Document   : listItems.jsp
    Created on : Nov 15, 2023, 9:37:36 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List items</title>
    </head>
    
    <style>
        .header {
            background: aquamarine;
            display: flex;
            justify-content: flex-end;
            padding: 8px 16px;
        }
        
        .username {
            color: blue;
        }
        
        table tr td, table tr th {
            border: solid 1px #000;
            padding: 0 8px;
        }
        
        table tr th {
            background: aqua;
        }
        
        button[type="submit"] {
            background: transparent;
            border: none;
            outline: none !important;
            color: blue;
            font-weight: bold;
            cursor: pointer;
        }
        
        form {
            display: inline;
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
        
        <h2>Danh mục các mặt hàng đấu giá</h2>
        <table>
            <thead>
                <tr>
                    <th>Mặt hàng</th>
                    <th>Giá</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${auctionItems}" var="item">
                    <tr>
                        <td><a href="/showTopics?id=${item.getId()}">${item.getDescription()}</a></td>
                        <td>
                            <div>Giá khởi đầu: ${item.getInitialPrice()}</div>
                            <c:if test="${item.getCurrentPrice() > 0}">
                                <div>Giá hiện tại: ${item.getCurrentPrice()}</div>
                                <div>(${item.getBids().size()} lời đặt giá)</div>    
                            </c:if>
                            
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
