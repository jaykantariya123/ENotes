<%-- 
    Document   : home
    Created on : 12 Apr, 2023, 4:27:20 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Insert title here</title>
        <link rel="stylesheet" href="css/style.css">
        <style type="text/css">
            .back-img{
                background: url("img/download.jpg");
                width: 100%;
                height:95vh;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
        <%@include file="all_component/allcss.jsp" %>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp" %>
        <div class="container-fluid">
            
            <div class="card py-5 mb-2">
                <div class="card-body text-center">
                    <img alt="" src="img/d.jpg" class="img-fluid mx-auto" style="max-width: 380px;">
                    <h1>START TAKING YOUR NOTES</h1>
                    <a href="addNotes.jsp" class="btn btn-outline-primary">Start here</a>
                </div>
            </div>
        </div>
        
        <%@include file="all_component/footer.jsp" %>
    </body>
</html>
