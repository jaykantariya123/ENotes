/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hp
 */
public class DBConnect {
    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null) {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                conn=DriverManager.getConnection("jdbc:derby://localhost:1527/enote","enote","enote");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
