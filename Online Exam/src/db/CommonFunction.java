/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Pratik
 */
public class CommonFunction {
    
    
    Connection cnn;
    
    public CommonFunction()
    {
        try{
            
            
            cnn=db.MyConnection.getConnection();
            
        }catch(Exception ee)
        {
            System.out.println("Exception In Common Function Class Constructor"+ee);
        }
    }
    
    
    public ResultSet getResultset(String tablename)
    {
        try{
     
            Statement stmt= cnn.createStatement();
            
            ResultSet rst= stmt.executeQuery("select * from "+tablename);
            
            return rst;
            
        }catch(Exception ee)
        {
            
             System.out.println("Exception In Common Function getResult"+ee);
        }
        return null;
    }
    
    public int getMaxId(String query)
    {
         try{
     
            Statement stmt= cnn.createStatement();
            
            ResultSet rst= stmt.executeQuery(query);
            
            if(rst.next())
            {
                return rst.getInt(1);
            }
            else
                return 0;
            
        }catch(Exception ee)
        {
            
             System.out.println("Exception In Common Function getResult"+ee);
        }
        return 0;
    }
     public int getId(String query)
    {
         try{
     
            Statement stmt= cnn.createStatement();
            
            ResultSet rst= stmt.executeQuery(query);
            
            if(rst.next())
            {
                return rst.getInt(1);
            }
            else
                return 0;
            
        }catch(Exception ee)
        {
            
             System.out.println("Exception In Common Function getResult"+ee);
        }
        return 0;
    }
     public ResultSet getResult(String query)
    {
        try{
     
            Statement stmt= cnn.createStatement();
            
            ResultSet rst= stmt.executeQuery(query);
            
            return rst;
            
        }catch(Exception ee)
        {
            
             System.out.println("Exception In Common Function getResult"+ee);
        }
        return null;
    }
}
