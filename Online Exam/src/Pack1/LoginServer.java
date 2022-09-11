/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack1;

import Pack1.UserRemote;
import java.rmi.Naming;

/**
 *
 * @author Pratik
 */
public class LoginServer {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
       UserRemote U=new LoginList();
       
       Naming.rebind("rmi://localhost:6001/dc",U);
       
    }
    
}
