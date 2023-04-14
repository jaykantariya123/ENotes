<%-- 
    Document   : addNotes
    Created on : 13 Apr, 2023, 11:16:33 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Notes</title>
        <link rel="stylesheet" href="css/style.css">

        <%@include file="all_component/allcss.jsp" %>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp" %>
        <div class="container-fluid">
            
            <h1 class="text-center mt-3">Add Your Notes</h1>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Enter Title</label>
                                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Enter Content</label>
                                <textarea rows="10" cols="" class="form-control"></textarea>
                            </div>


                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary">Add Notes</button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
            
            <%@include  file="all_component/footer.jsp" %>
    </body>
</html>
