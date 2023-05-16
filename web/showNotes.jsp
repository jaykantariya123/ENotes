<%-- 
    Document   : showNotes
    Created on : 13 May, 2023, 2:15:37 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UserDetails user1 = (UserDetails) session.getAttribute("userD");
    if (user1 == null) {
        response.sendRedirect("login.jsp");
        session.setAttribute("Login-error", "Please login...");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Notes</title>
        <%@include file="all_component/allcss.jsp" %>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp" %>
        
        <div class="container">

            <h2 class="text-center ">All Notes:</h2>
            
                <div class="row">
                    <div class="col-md-12">
                        <div class="card mt-3">
                            
                            <img alt="" src="img/d.jpg" class="card-img-top mt-2 mx-auto" style="max-width: 100px;">
                            
                            <div  class="card-body p-4">
                                <h5 class="card-title">jmkkm</h5>
                                
                                <p>njkn bkb</p>
                                
                                <p>
                                    <b class="text-success" > Published By:</b></br>
                                    <b class="text-primary"></b>
                                    
                                    
                                </p>
                                
                                <div class="container text-center mb-2">
                                    <a href="DeleteServlet?title=" class="btn btn-danger">Delete</a>
                                    <a href="edit.jsp?title=" class="btn btn-primary">Edit</a>
                                    
                                    
                                </div>
                            </div>
                            
                          
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
