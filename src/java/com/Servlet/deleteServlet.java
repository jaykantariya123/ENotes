/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlet;

import com.DAO.PostDAO;
import com.Db.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/deleteServlet"})
public class deleteServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title=(String)request.getParameter("title");
        
        PostDAO dao=new PostDAO(DBConnect.getConn());
        
        boolean f=dao.DeleteNotes(title);
        
        HttpSession sess=null;
        if(f){
             sess=request.getSession();
            sess.setAttribute("updateMsg","Notes Delete Successfully..");
            response.sendRedirect("showNotes.jsp");
        }
        else{
            sess= request.getSession();
            sess.setAttribute("wrongMsg", "Something went wrong on server");
            response.sendRedirect("showNotes.jsp");
        }
    }

}
