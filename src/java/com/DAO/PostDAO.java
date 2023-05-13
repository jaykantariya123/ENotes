/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.User.Post;
import com.User.UserDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author hp
 */
public class PostDAO {
    private  Connection conn;

    public PostDAO() {
    }

    public PostDAO(Connection conn) {
        this.conn = conn;
    }
    
    public boolean addNotes(String ti,String co,String ui)
    {
        boolean  f=false;
        try{
            String q="insert into ENOTE.NOTES1(title,content,email) values(?,?,?)";
            
            PreparedStatement ps=conn.prepareStatement(q);
            ps.setString(1,ti);
            ps.setString(2,co);
            ps.setString(3,ui);
            
            int i=ps.executeUpdate();
            if(i==1)
            {
                f=true;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
