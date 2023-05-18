<%-- 
    Document   : showNotes
    Created on : 13 May, 2023, 2:15:37 PM
    Author     : hp
--%>

<%@page import="com.User.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.DAO.PostDAO"%>
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
        <link rel="stylesheet" href="css/style.css">

        <%@include file="all_component/allcss.jsp" %>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp" %>
        
        <%
            String updateMsg=(String)session.getAttribute("updateMsg");
            
            if(updateMsg!=null)
            {%>
               
            <div class="alert alert-success" role="alert">
                            <%=updateMsg%>
                        </div>
                            <% session.removeAttribute("updateMsg");}
        %>
        
        <%
            String wrongMsg=(String)session.getAttribute("wrongMsg");
            
            if(wrongMsg!=null)
            {%>
               
            <div class="alert alert-danger" role="alert">
                            <%=wrongMsg%>
                        </div>
                            <% session.removeAttribute("wrongMsg");}
        %>

        <div class="container">

            <h2 class="text-center">All Notes:</h2>

            <div class="row">
                <div class="col-md-12">

                    <%                            if (user1 != null) {
                            PostDAO ob = new PostDAO(DBConnect.getConn());
                            List<Post> post = ob.getData(user1.getEmail());

                           for (Post po : post) {%>               
                    <div class="card mt-3">

                        <img alt="" src="img/d.jpg" class="card-img-top mt-2 mx-auto" style="max-width: 100px;">

                        <div  class="card-body p-4">


                            <h5 class="card-title "><%=po.getTitle()%></h5>

                            <p><%= po.getContent() %></p>

                            <p>
                                <b class="text-success" > Published By:<%= user1.getName() %></b></br>
                                <b class="text-primary"></b>


                            </p>

                            <div class="container text-center mb-2">
                                <a href="deleteServlet?title=<%= po.getTitle() %>" class="btn btn-danger">Delete</a>
                                
                                <a href="edit.jsp?title=<%= po.getTitle() %>" class="btn btn-primary">Edit</a>


                            </div>
                        </div>
                    </div>

                    <%}
                        }
                    %>


                </div>
            </div>
        </div>
    </body>
</html>
