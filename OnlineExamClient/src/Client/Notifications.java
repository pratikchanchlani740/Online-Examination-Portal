/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Pack1.CourseDemo1;
import Pack1.Exam;
import Pack1.ExamQuestion;
import Pack1.StudentExam1;
import Pack1.User;
import Pack1.UserRemote;
import db.CommonFunction;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratik
 */
public class Notifications extends javax.swing.JFrame {

    /**
     * Creates new form Notifications
     */CommonFunction cf=new CommonFunction();
     public List<CourseDemo1> list1=null;
     public void getCourse(int cid)
   { try{
//       ResultSet rs=cf.getResultset("course where cid="+cid);
UserRemote ur=Demo.getUserRemote();         
list1=ur.courseDetails(cid);
Iterator it1=list1.iterator();
if(it1.hasNext())
{
    CourseDemo1 crs=(CourseDemo1)it1.next();
    cname.setText(crs.getCname());
}
//       if(rs.next())
//       {
//           System.out.println(rs.getString("cname"));
//          // jComboBox1.setSelectedItem(""+rs.getString("cname"));
//          cname.setText(rs.getString("cname"));
//       
         
   }
   catch(Exception ee)
   {
       System.out.println("Course Name Error"+ee);
   }
   }

     Demo A;
    public Notifications() {
        initComponents();
        try{
            Container ctx=getContentPane();
            ctx.setBackground(new Color(255,255,150));
            setTitle("Notifications");
Image icon=new ImageIcon(this.getClass().getResource("removebg/online1.png")).getImage();
setIconImage(icon);
           //  A= new Demo();
           //A.connect();
          // UserRemote u=Demo.getUserRemote();
         //User u= A.getUser();
       //  getCourse(u.getCourse());
           
           
        }catch(Exception ee)
        {
            System.out.println("Exception is"+ee);
        }
    }
    int sid=0;
    public Notifications(Demo inform)
    {
          initComponents();
          try{
              String path="onlineexam.jpg";
      //  path="...\\Client\\loginform.png";
        ImageIcon img=new ImageIcon(path);
        jLabel4.setIcon(img);
                 User u=inform.getUser();
               getCourse(u.getCourse());
               sid=u.getId();
               Container ctx=getContentPane();
           
          // ctx.setBackground(Color.DARK_GRAY);
            ctx.setBackground(new Color(255,255,150));
               
                DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
          String course=cname.getText();
     
      UserRemote ur=Demo.getUserRemote();
      System.out.println("Course is "+course);
      List<Exam> list= ur.examDetails(course);
      
      Iterator it= list.iterator();
      System.out.println("Size OF Exam IS : "+list.size());
		Date d2=new Date();
               int day=d2.getDate();
               int month=d2.getMonth()+1;
               int year=d2.getYear()+1900;
               String str="",str1="";
               if(d2.getDate()<10)
               {
                   str="0";
                   if(d2.getMonth()<9)
                   {
                       str1="0";
                   }
                   else
                   {
                      str1="";   
                   }
                }
               else{
                   str="";
                   if(d2.getMonth()<9)
                   {
                       str1="0";
                   }
                   else{
                       str1="";
                   }
               }
              // System.out.println(""+day+" "+month+" "+year);
               String date=str+day+"-"+str1+month+"-"+year;
               System.out.println("Date is"+date);
              Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);
              System.out.println("Converted Date is"+date1);
        while(it.hasNext())
	{  Exam c=(Exam)it.next();
            Date d1=c.getDate();
            
            System.out.println(d1 + " Date " + d2);
            
            System.out.println(""+c.getState());
            if(d1.compareTo(date1)>0)
            {
            System.out.println("Hello");
           model.addRow(new Object[]{c.getEid(),c.getSname(),c.getTotalq(),c.getDur(),c.getMax(),c.getPass(),c.getDate(),c.getQuetype(),c.getState(),"Please Prepare Your Exam",""});
//            model.setValueAt("", 1, 10);
            }
            else if(d1.compareTo(date1)==0)
            {  
               
                model.addRow(new Object[]{c.getEid(),c.getSname(),c.getTotalq(),c.getDur(),c.getMax(),c.getPass(),c.getDate(),c.getQuetype(),c.getState(),"Click on Link And Give Exam","Click here"});
                  A=inform;
               
            }
            
            else if(d1.compareTo(date1)<0)
            {
               c.setState("Attempted");
               ur.Exam(c);
               model.addRow(new Object[]{c.getEid(),c.getSname(),c.getTotalq(),c.getDur(),c.getMax(),c.getPass(),c.getDate(),c.getQuetype(),c.getState(),"Your Exam is Done",""}); 
               //Exam exam=new Exam();
               
            }
            else
            {
                
            }
        }
          }catch(Exception ee)
          {
              System.out.println("Notification Exception "+ee);
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
        cname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Notifications");

        jLabel3.setText("Course Name");

        jButton1.setText("Get Notifications");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam ID", "Subject Name", "Total Questions", "Duration", "Maximum", "Minimum", "Date", "Type", "State", "Message", "Give Paper"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3)
                        .addGap(56, 56, 56)
                        .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try{
         
//          DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
//          String course=cname.getText();
//     
//      UserRemote u=Demo.getUserRemote();
//      System.out.println("Course is "+course);
//      List<Exam> list= u.examDetails(course);
//      
//      Iterator it= list.iterator();
//      System.out.println("Size OF Exam IS : "+list.size());
//		Date d2=new Date();
//               int day=d2.getDate();
//               int month=d2.getMonth()+1;
//               int year=d2.getYear()+1900;
//               String str="";
//               if(d2.getDate()<10 || d2.getMonth()<9 )
//               {
//                   str="0";
//               }
//              // System.out.println(""+day+" "+month+" "+year);
//               String date=str+day+"-"+str+month+"-"+year;
//               System.out.println("Date is"+date);
//              Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);
//              System.out.println("Converted Date is"+date1);
//        while(it.hasNext())
//	{  Exam c=(Exam)it.next();
//            Date d1=c.getDate();
//            
//            System.out.println(d1 + "  " + d2);
//            if(d1.compareTo(date1)>0)
//            {
//            System.out.println("Hello");
//            model.addRow(new Object[]{c.getEid(),c.getSname(),c.getTotalq(),c.getDur(),c.getMax(),c.getPass(),c.getDate(),c.getQuetype(),c.getState(),"Please Prepare Your Exam",""});
////            model.setValueAt("", 1, 10);
//            }
//            else if(d1.compareTo(date1)==0)
//            {
//                 model.addRow(new Object[]{c.getEid(),c.getSname(),c.getTotalq(),c.getDur(),c.getMax(),c.getPass(),c.getDate(),c.getQuetype(),c.getState(),"Click on Link And Give Exam","Click here"});
//            }
//            else{
//                
//            }
//        }
      }catch(Exception ee)
      {
          System.out.println("Exception in Notification Button"+ee);
      }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
int rowidx=jTable2.getSelectedRow();
int colidx=jTable2.getSelectedColumn();
try{
    DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
    if(colidx==10)
    {
     String value=model.getValueAt(rowidx,9).toString(); 
     if(value.startsWith("Please"))
     {
         JOptionPane.showMessageDialog(this,"You have to Prepare for Exams If Exams Date Comes Then You Have Click");
     }
     else
     { 
         UserRemote ur=Demo.getUserRemote();
         int eid=Integer.parseInt(model.getValueAt(rowidx, 0).toString());
         
         System.out.println("Student ID"+sid);
         System.out.println("Exam id"+eid);
       //  List<StudentExam1> list1=ur.checkExam(sid,eid);
         boolean a=ur.checkExam1(sid,eid);
        
    // System.out.println("List is"+list1);
        if(a==false)    
        {
         JOptionPane.showMessageDialog(this,"You can give Exam");
        // int id=Integer.parseInt(model.getValueAt(rowidx,0).toString());
         
         Vector V=new Vector();
         V.add(0,model.getValueAt(rowidx, 0));
         V.add(1,model.getValueAt(rowidx, 1));
         V.add(2,model.getValueAt(rowidx, 2));
         V.add(3,model.getValueAt(rowidx, 3));
         V.add(4,model.getValueAt(rowidx, 4));
         V.add(5,model.getValueAt(rowidx, 5));
         V.add(6,model.getValueAt(rowidx, 6));
         ExamPaper exam=new ExamPaper(A,V);
         exam.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this,"You have Already Given Exam");
     }
    }
    }
}catch(Exception ee)
{
    System.out.println("Notification Table Error"+ee);
}
    }//GEN-LAST:event_jTable2MouseClicked

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        try{
            int row=0;
            DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
            while(row<model.getRowCount())
            {
                Date d1=(Date)model.getValueAt(row, 6);
                System.out.println("Date is"+d1);
                Date d2=new Date();
                if(d2.compareTo(d1)>0)
                {
                    System.out.println("Exam is Attempted");
                }
                ++row;
                
            }
            
        }catch(Exception ee)
        {
            System.out.println("Exception in Closing"+ee);
        }
    }//GEN-LAST:event_formWindowIconified

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
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notifications().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
