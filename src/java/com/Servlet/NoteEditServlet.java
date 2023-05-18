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

@WebServlet ("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try{
             String s=(String)request.getParameter("note");
            String content =request.getParameter("content");
            
            PostDAO dao=new PostDAO(DBConnect.getConn());
            boolean f=dao.PostUpdate(s, content);
            
            if(f)
            {
                System.out.println("data updated successfully");
                
                HttpSession session =request.getSession();
                session.setAttribute("updateMsg", "Notes Update Succesfully");
                response.sendRedirect("showNotes.jsp");
            }
            else{
                System.out.println("data not updated");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        
        
       
    }


}
