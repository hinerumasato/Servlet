<%-- 
    Document   : newTopic
    Created on : Nov 16, 2023, 1:44:15 AM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Topic</title>
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
        
        .form-group input,textarea {
            width: 400px;
        }
        
        textarea {
            height: 200px;
        }
    </style>
    
    <body>
        
        <div class="header">
            <span>Chào <b>${sessionScope.loginUser.getUsername()}</b> | 
                <form method="POST" action="/logout"><button type="submit">Thoát</button></form>
            </span>
        </div>
        
        <form method="POST" action="/newTopic">
            <div class="form-group">
                <h4>Tiêu đề</h4>
                <input name="title" />
            </div>
            
            <div class="form-group">
                <h4>Nội dung</h4>
                <textarea name="description"></textarea>
            </div>
            <div class="button-groups">
                <button type="submit">Gửi</button>
                <a href="/listTopics">Huỷ bỏ</a>
            </div>
        </form>
    </body>
</html>
