<%-- 
    Document   : register
    Created on : 9 Apr, 2023, 4:57:05 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
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
        <div class="container-fluid div-color">
            <div class="row back-img">
                <div class="col-md-4 offset-md-4">
                    <div class="card mt-5">
                        <div class="card-header text-center bg-custom">
                            <i class="fa fa-user-plus fa-3x " aria-hidden="true"></i>
                            <h4>Registration</h4>
                        </div>




                        <%
                            String regMsg = (String) session.getAttribute("reg-success");
                            if (regMsg != null) {%>
                        <div class="alert alert-success" role="alert">
                            <%=regMsg%>
                            Login<a href="login.jsp">Click here</a>
                        </div>
                        <% session.removeAttribute("reg-success");}
                        %>
                        
                        

                        <%
                            String failMsg = (String) session.getAttribute("failed-msg");
                            if (failMsg != null) {%>
                        <div class="alert alert-danger" role="alert">
                            <%=failMsg%>
                        </div>
                        <% session.removeAttribute("failed-msg");}
                        %>

                        <div class="card-body">
                            <form action="UserServlet" method="post"> 

                                <div class="form-group">
                                    <label>Enter  Full Name</label>
                                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="fname">

                                </div>
                                <div class="form-group">
                                    <label>Enter Email</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="femail">

                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Enter Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" name="fpassword" >
                                </div>

                                <button type="submit" class="btn btn-primary badge-pill btn-block">Register</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="all_component/footer.jsp" %>
    </body>
</html>
