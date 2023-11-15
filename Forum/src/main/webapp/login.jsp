<%-- 
    Document   : login
    Created on : Nov 15, 2023, 11:49:19 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>

    <style>

        .wrapper {
            display: flex;
            justify-content: center;
        }

        h2 {
            margin: 0;
            padding: 0;
            text-align: center;
            background: aqua;
        }

        .login-wrapper {
            border: 1px solid #000;
            width: 600px;
        }

        .login-inputs {
            display: flex;
            justify-content: center;
        }

        .login-inputs .form-group {
            margin-top: 4px;
        }

        .login-inputs label {
            display: inline-block;
            width: 100px;
            text-align: right;
        }

        button[type="submit"] {
            display: block;
            margin: 4px auto;
        }

        .alert {
            background: blanchedalmond;
            color: red;
            text-align: center;
            padding: 8px 16px;
        }
    </style>

    <body>
        <c:if test="${not empty message}">
            <div class="alert">${message}</div>
        </c:if>
        <div class="wrapper">
            <div class="login-wrapper">
                <h2>Đăng nhập</h2>
                <div class="login-inputs">
                    <form method="POST" action="/login">
                        <div class="form-group">
                            <label for="#username">Tên đăng nhập</label>
                            <input type="text" id="username" name="username" />
                        </div>
                        <div class="form-group">
                            <label for="#password">Mật khẩu</label>
                            <input type="password" id="password" name="password" />
                        </div>

                        <button type="submit">Đăng nhập</button>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
