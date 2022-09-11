/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pratik
 */
public class MyConnection {
    
    public static Connection getConnection()
{
    try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam","root","");
         return cnn;
         
    }catch(Exception ee)
    {
        System.out.println("Exception : "+ee.toString());
    }
    
    return null;
}
    
}
