package crime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication4;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prana
 */

public class dbhelper {
    Connection con;
    String pass="chipz";
    
    public void close()
    {
    }
    
    public void createdb(String dbname) throws Exception
    {
    

Class.forName("com.oracle.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:oracle://localhost/:1158","chipz",pass);
        PreparedStatement ta = con.prepareStatement("create database "+dbname+";");
             
        
//        ta.setString(1, userc);
//        ta.setString(2, passc);
       ta.execute();
          con.close();
       
    }
    //query
    public ResultSet dbcallq(String que) throws Exception
    {
        

 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

         con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","chipz",pass);
        PreparedStatement ta = con.prepareStatement(que);
                
         ResultSet rs= ta.executeQuery();
          
         // con.close();
          return rs;
        


    }
    //update
     public void dbcallup(String que)throws Exception
    {
        

 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

         con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","chipz",pass);
        PreparedStatement ta = con.prepareStatement(que);
                
          ta.executeUpdate();
//con.close();
       


    }
}
