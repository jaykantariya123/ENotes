<%-- 
    Document   : edit
    Created on : 18 May, 2023, 1:48:26 PM
    Author     : hp
--%>

<%@page import="com.User.Post"%>
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
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">

        <%@include file="all_component/allcss.jsp" %>
    </head>
    <body>
        <%
            String s=(String)request.getParameter("title");
            
            PostDAO post=new PostDAO(DBConnect.getConn());
            Post p=post.getDatabyTitle(s);
            
        %>
        
        
        <%@include file="all_component/navbar.jsp" %>
        <div class="container-fluid">

            <h1 class="text-center mt-3">Edit Your Notes</h1>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form action="NoteEditServlet" method="post">
                            
                            <input  type="hidden" value="<%= s %>" name="note">
                            <div class="form-group">
                           
                                <label for="exampleInputEmail1">Enter Title</label>
                                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="title" required="required" value="<%= p.getTitle() %>">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Enter Content</label>
                                <textarea rows="10" cols="" class="form-control" name="content" required="required"><%= p.getContent() %></textarea>
                            </div>


                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary">Edit Notes</button>

                            </div>
                        </form> 
                    </div>
                </div>
            </div>
        </div>

        <%@include  file="all_component/footer.jsp" %>
    </body>
</html>
