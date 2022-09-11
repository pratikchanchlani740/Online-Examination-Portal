/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Pratik
 */
public class MyPanel extends JPanel {
    
//    public MyPanel()
//    {
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        //setSize((int)d.getWidth(),(int)d.getHeight());
        LoginForm frm=new LoginForm();
//    }
     public void paint(Graphics g)
    { 
        System.out.println("Hello World");
        
        Image img= Toolkit.getDefaultToolkit().getImage("onlineexam.jpg");
        //g.drawImage(img, 750, 494, this);
        g.drawImage(img, 0, 0,(int) d.getWidth(), (int)d.getHeight(),new LoginForm());
        
    }
    
}
