/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Pack1.UserRemote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Pack1.User;
/**
 *
 * @author Pratik
 */
public class Demo {
    
    
        public static UserRemote chk;
        
        private   User user;
        
        public void connect() throws Exception
    {
        Registry reg=LocateRegistry.getRegistry("localhost",6001);
        
         chk=(UserRemote)reg.lookup("rmi://localhost:6001/dc");
        
        
        
    }
        public static UserRemote getUserRemote()
        {
            return chk;
        }
        
    
        public void setUser(User u)
        {
            user=u;
        }
        
        
        public   User getUser()
        {
            return user;
        }
    
}
