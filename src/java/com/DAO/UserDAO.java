/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.User.UserDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author hp
 */
public class UserDAO {

    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }
    
    public boolean addUser(UserDetails ud)
    {
        boolean f=false;
        
        try{
            String query="insert into user1(name,email,password) values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, ud.getName());
            ps.setString(2, ud.getEmail());
            ps.setString(3, ud.getPassword());
            int i=ps.executeUpdate();
            if(i==1)
            {
                f=true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }
    
    public boolean loginUser(UserDetails ud)
    {
        boolean f=false;
        try{
            String query="select *from  user1 where  email=?  and password=?";
            
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, ud.getEmail());
            ps.setString(2, ud.getPassword());
            
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                f=true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }
}
