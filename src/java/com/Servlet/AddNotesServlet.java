 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlet;

import com.DAO.PostDAO;
import com.Db.DBConnect;
import com.User.Post;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email=request.getParameter("email");
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        
        PostDAO dao=new  PostDAO(DBConnect.getConn());
        boolean f= dao.addNotes(title, content, email);
        
        if(f)
        {
            System.out.println("data insert successfully.");
        }
        else
        {
            System.out.println("error");
        }
    }


}
