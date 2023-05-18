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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Post> getData(String email)
    {
         List<Post> list=new ArrayList<Post>();
         Post post =null;
         try{
             String q="select * from ENOTE.NOTES1 where email=?";
             
             PreparedStatement ps=conn.prepareStatement(q);
             ps.setString(1, email);
             
             ResultSet rs= ps.executeQuery();
             while(rs.next())
             {
                 post= new Post();
                 post.setTitle(rs.getString(1));
                 post.setContent(rs.getString(2));
                 list.add(post);
                 
             }
         }
         
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return list;
    }
    
    public Post getDatabyTitle(String title){
        Post p=null;
        try{
            String q="select * from ENOTE.NOTES1 where title=?";
            
            PreparedStatement ps=conn.prepareStatement(q);
            ps.setString(1, title);
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next())
            {
                p=new Post();
                p.setTitle(rs.getString(1));
                p.setContent(rs.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return p;
        
    }
    
    public boolean PostUpdate (String ti,String co){
        boolean f=false;
        
        try{
            String q="update ENOTE.NOTES1 set content=? where title=?";
            PreparedStatement ps=conn.prepareStatement(q);
            ps.setString(1, co);
            ps.setString(2, ti);
            
            int i= ps.executeUpdate();
            
            if(i==1)
            {
                return true;
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
