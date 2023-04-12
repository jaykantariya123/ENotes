<%-- 
    Document   : index
    Created on : 9 Apr, 2023, 4:56:01 PM
    Author     : hp
--%>

<%--<%@page import="com.Db.DBConnect"%>--%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="css/style.css">
        <style type="text/css">
            .back-img{
                background: url("img/notes.jpg");
                width: 100%;
                height:150vh;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
        <%@include file="all_component/allcss.jsp" %>
    </head>
    <body>
        
        <%@include file= "all_component/navbar.jsp" %>
        
        
        <div class="container-fluid back-img">
            <div class="text-center">
                <h1><i class="fa fa-book" aria-hidden="true"></i> E Notes- Save Your Notes
            </h1>
            <a href="login.jsp" class="btn btn-light" ><i class="fa fa-user-circle-o" aria-hidden="true"></i> Login</a>
            <a href="register.jsp" class="btn btn-light" ><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a>
            </div>
        </div>

        <%@include file="all_component/footer.jsp" %>
    </body>
</html>
