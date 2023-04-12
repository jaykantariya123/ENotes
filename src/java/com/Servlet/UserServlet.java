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

/**
 *
 * @author hp
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String name=request.getParameter("fname");
        String email=request.getParameter("femail");
        String password=request.getParameter("fpassword");
        
        UserDetails ud=new UserDetails();
        ud.setName(name);
        ud.setEmail(email);
        ud.setPassword(password);
        
        UserDAO dao=new UserDAO(DBConnect.getConn());
        boolean f=dao.addUser(ud);
        //PrintWriter out=response.getWriter();
        
        HttpSession session;
        if(f)
        {
            session=request.getSession();
            session.setAttribute("reg-success", "Registration Successfully..");
            response.sendRedirect("register.jsp");
            //out.print("User Register Successfully");
        }
        else{
            //out.print("data not insert");
            session=request.getSession();
            session.setAttribute("failed-msg", "Something went wrong on server");
            response.sendRedirect("register.jsp");
        }
    }
}
