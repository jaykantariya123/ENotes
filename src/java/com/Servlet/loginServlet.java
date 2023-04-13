/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlet;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email=request.getParameter("uemail");
        String password=request.getParameter("upassword");
        
        UserDetails ud=new UserDetails();
        ud.setEmail(email);
        ud.setPassword(password);
        
        UserDAO dao=new UserDAO(DBConnect.getConn());
        UserDetails user=dao.loginUser(ud);
        
        if(user!=null)
        {
            HttpSession session=request.getSession();
            session.setAttribute("userD", user);
            response.sendRedirect("home.jsp");
        }
        else{
            HttpSession session=request.getSession();
            session.setAttribute("login-failed", "Invalid UserName and Password");
            response.sendRedirect("login.jsp");
        }
    }

}
