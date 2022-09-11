/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Pack1.CourseDemo1;
import Pack1.User;
import Pack1.UserRemote;
import db.CommonFunction;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
//import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import java.sql.Statement;
//import java.sql.Types;
//import java.util.ArrayList;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;

/**
 *
 * @author Pratik
 */
public final class StudentForm extends javax.swing.JFrame {
//        int crow=0;
//    int flag=0;
String path=null;
//     int id=0;
//     public String nn="";
    CommonFunction cf=new CommonFunction();
//    public Graphics img1;
//    public void paint(Graphics g)
//    {
//        img1=g;
//    }
//    public Graphics paint()
//    {
//        return img1;
//    }
//    public void readData() throws Exception
//    {
//         txtid.setText(rs.getString("ID"));
//        txtfname.setText(rs.getString("First_Name"));
//        txtlname.setText(rs.getString("Last_Name"));
//        txtphone.setText(rs.getString("Phone"));
//        txtadd.setText(rs.getString("Address"));
//         ImageIcon img=new ImageIcon(rs.getString("image"));
//             jComboBox3.setSelectedItem(rs.getString("session"));
//path=rs.getString("image");
//    if(img==null)
//    {
//        System.out.println("No Image");
//         image.setIcon(null);
//    } 
//    else
//    {
//            System.out.println("Image is There");       
//    Image im= img.getImage().getScaledInstance(250, 200, java.awt.Image.SCALE_SMOOTH);
//    
//    img= new ImageIcon(im);
//     image.setIcon(img);
//    }
//    
//       
//        String courseid= rs.getString("course");
//        
//        ResultSet rst= cf.getResultset(" course where cid="+courseid);
//        
//        rst.next();
//        jComboBox1.setSelectedItem(rst.getString(2));
//        
//        rst.close();
//       
//    }
//    
//    
//    public void enableNavigation(boolean mod)
//    {
//        txtfname.setEditable(!mod);
//        txtlname.setEditable(!mod);
//        txtphone.setEditable(!mod);
//        txtadd.setEditable(!mod);
//       
//        uploadbtn.setEnabled(!mod);
//        
//        //jComboBox1.setEditable(!mod);
//        //jComboBox3.setEditable(!mod);
//        jComboBox1.setEnabled(!mod);
//        jComboBox3.setEnabled(!mod);
//      
//        editbtn.setEnabled(mod);
//       
//        
//        
//        
//    }
//    
//
//    /**
//     * Creates new form StudentForm
//     */
   public ResultSet rs;
   PreparedStatement psmt1,psmt2,psmt3;
   Connection cnn;
   public List<CourseDemo1> list1=null;
   public void getCourse(int cid)
   { 
       try{
       UserRemote ur=Demo.getUserRemote();         
list1=ur.courseDetails(cid);
Iterator it1=list1.iterator();
if(it1.hasNext())
{
    CourseDemo1 crs=(CourseDemo1)it1.next();
    txtcourse.setText(crs.getCname());
}
//       ResultSet rs=cf.getResultset("course where cid="+cid);
//       if(rs.next())
//       {
//           System.out.println(rs.getString("cname"));
//          // jComboBox1.setSelectedItem(""+rs.getString("cname"));
//          txtcourse.setText(rs.getString("cname"));
//       }
   }
   catch(Exception ee)
   {
       System.out.println("Course Name Error"+ee);
   }
   }
 
   
   public StudentForm(Demo inform)
   {  
       initComponents();
       try{
           Container ctx=getContentPane();
            ctx.setBackground(new Color(255,255,150));
            setTitle("Change Student Details");
Image icon=new ImageIcon(this.getClass().getResource("removebg/online1.png")).getImage();
setIconImage(icon);
//            jPanel1.setBackground(new Color(255,255,150));
//            jPanel2.setBackground(new Color(255,255,150));
//            jPanel3.setBackground(new Color(255,255,150));
       User u=inform.getUser();
       System.out.println("Hello");
      txtid.setText(""+u.getId());
      txtfname.setText(u.getFirstname());
      txtlname.setText(u.getLastname());
      getCourse(u.getCourse());
      //jComboBox1.setSelectedItem(""+u.getCourse());
      
      txtuser.setText(u.getUser());
      txtpass.setText(u.getPass());
      txtphone.setText(u.getPhone());
      txtadd.setText(u.getAddress());
      txtsess.setText(u.getSession());
      txtsess.setEditable(false);
    
      txtcourse.setEditable(false);
      path=u.getImage();
//      ImageIcon img=new ImageIcon(path);
//    System.out.println("Default Image Value is"+img);
//    Image im= img.getImage().getScaledInstance(250, 200, java.awt.Image.SCALE_SMOOTH);
//    String img1=im.toString();
//    img= new ImageIcon(im);
// //   img2=new ImageIcon();
//      System.out.println("Image Value is"+img1);
//     image.setIcon(img);



byte b[]=u.getImg();
 System.out.println(""+b.length);

 
 Image im= Toolkit.getDefaultToolkit().createImage(b,0,b.length);

ImageIcon img= new ImageIcon(im);

        

Image im1=img.getImage().getScaledInstance(250, 200, java.awt.Image.SCALE_SMOOTH);

img=new ImageIcon(im1);

 image.setIcon(img);


       }
       catch(Exception ee)
       {
           System.out.println("Client Student Form Error"+ee);
       }
   }
    public StudentForm() {
        initComponents();
        try{
        Container ctx=getContentPane();
        ctx.setBackground(new Color(255,255,150));
        cnn=db.MyConnection.getConnection();
         psmt2=cnn.prepareStatement("update student set First_Name= ?, Last_Name= ?, Phone= ?, Address=?,  Image=? , user=?, pass=? where ID= ? ");
         
        }
        catch(Exception ee)
        {
            System.out.println("Connection Error"+ee);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtlname = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtadd = new javax.swing.JTextArea();
        image = new javax.swing.JLabel();
        uploadbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        editbtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JTextField();
        txtcourse = new javax.swing.JTextField();
        txtsess = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setForeground(java.awt.Color.black);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Entry Form");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Phone No");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Address");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Session");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Course");

        txtid.setEditable(false);

        txtadd.setColumns(20);
        txtadd.setRows(5);
        jScrollPane1.setViewportView(txtadd);

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        uploadbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        uploadbtn.setText("UPLOAD");
        uploadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadbtnActionPerformed(evt);
            }
        });

        editbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        editbtn.setText("EDIT");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("UserName");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtcourse)
                                                    .addComponent(txtfname, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                                    .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                                    .addComponent(txtlname, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(97, 97, 97)
                                                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(uploadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(1, 1, 1))))
                                            .addComponent(txtsess, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtuser, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtpass, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtphone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(519, 519, 519)
                                .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(uploadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(editbtn)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 50, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadbtnActionPerformed
        int h1=image.getHeight();
        int w1=image.getWidth();
        JFileChooser chooser=new JFileChooser();
     chooser.showOpenDialog(null);
     path=chooser.getSelectedFile().getPath();
     
    ImageIcon img=new ImageIcon(path);
    
    Image im= img.getImage().getScaledInstance(250, 200, java.awt.Image.SCALE_SMOOTH);
    
    img= new ImageIcon(im);
    
    
    // int h=img.getIconHeight();
    // int w=img.getIconWidth();
     //Graphics g=Toolkit.getDefaultToolkit().getImage(path);
     //img.paintIcon(this, img1, w, h);
    
     int h2=image.getHeight();
     int w2=image.getWidth();
     
     System.out.println("width is"+w2+"height is"+h2);
     
     
     image.setIcon(img);
     //image.setText(path);
    }//GEN-LAST:event_uploadbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
try{
    UserRemote u=Demo.getUserRemote();
    // u=Demo.getUserRemote();
    String fname=txtfname.getText();
    String lname=txtlname.getText();
    String phone=txtphone.getText();
    String add=txtadd.getText();
    String img=path;
    String usern=txtuser.getText();
    String passw=txtpass.getText();
    int id=Integer.parseInt(txtid.getText());
    System.out.println("Name is"+fname+" "+lname+" Phone No."+phone+" Address is"+add+" Image "+img+" UserName And Password "+usern+" "+passw+" ID "+id);
    
    String query="update student set First_Name='"+fname+"', Last_Name='"+lname+"', Phone='"+phone+"', Address='"+add+"', user='"+usern+"', pass='"+passw+"' where id="+id+"";
    System.out.println("Query is"+query);
//    PreparedStatement pstmt=cnn.prepareStatement(query);
//     int count=pstmt.executeUpdate();
//     if(count>0)
//     {
//         System.out.println("Record Updated");
//     }
//     else{
//         System.out.println("Record not Updated");
//     }
   boolean value= u.updateData(query);
   System.out.println("Value is"+value);
   if(value==true)
   {
       System.out.println("Record Updated");
       dispose();
   }
   else{
       System.out.println("Record Not Updated");
   }
//    cnn=db.MyConnection.getConnection();
//         psmt2=cnn.prepareStatement("update student set First_Name= ?, Last_Name= ?, Phone= ?, Address=?,  Image=? , user=?, pass=? where ID= ? ");
//    psmt2.setString(1,txtfname.getText());
//   psmt2.setString(2,txtlname.getText());
//   psmt2.setString(3,txtphone.getText());
//   psmt2.setString(4,txtadd.getText());
//   System.out.println("Image path"+path);
//   psmt2.setString(5,path);
//   psmt2.setString(6,txtuser.getText());
//   psmt2.setString(7,txtpass.getText());
//   psmt2.setInt(8,Integer.parseInt(txtid.getText()));
   
   //psmt2.executeUpdate();
   
}catch(Exception ee)
{
    System.out.println("Edit Button Exception "+ee);
}
    }//GEN-LAST:event_editbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtadd;
    private javax.swing.JTextField txtcourse;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtsess;
    private javax.swing.JTextField txtuser;
    private javax.swing.JButton uploadbtn;
    // End of variables declaration//GEN-END:variables
}
