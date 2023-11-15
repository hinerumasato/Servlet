<%-- 
    Document   : login
    Created on : Nov 15, 2023, 9:07:07 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <style>
            
            .wrapper {
                display: flex;
                justify-content: center;
            }
            
            .login-wrapper {
                border: 1px solid #000;
                display: inline-block;
                width: 600px;
            }

            .login-wrapper h2 {
                text-align: center;
                padding: 16px;
                margin: 0;
                background-color: aqua;
            }

            .form-group {
                margin-top: 4px;
                display: flex;
                justify-content: center;
            }

            .form-group label {
                display: block;
                width: 100px;
                text-align: right;
            }
            
            .alert {
                background: darkgray;
                color: red;
                text-align: center;
                margin: 8px 0;
            }

            button[type="submit"] {
                display: block;
                margin: 8px auto;
            }

        </style>
    </head>

    <body>
        <form method="POST" action="/login">
            
            <c:if test="${not empty message}">
                <div class="alert">${message}</div>
            </c:if>
            
            <div class="wrapper">
                <div class="login-wrapper">
                    <h2>Đăng nhập</h2>
                    <div class="form-group">
                        <label for="#username">Tên đăng nhập</label>
                        <input type="text" name="username" id="username">
                    </div>

                    <div class="form-group">
                        <label for="#password">Mật khẩu</label>
                        <input type="password" name="password" id="password">
                    </div>

                    <button type="submit">Đăng nhập</button>
                </div>
            </div>

        </form>
    </body>
</html>
