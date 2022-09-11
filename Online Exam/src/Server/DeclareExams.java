/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import db.CommonFunction;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratik
 */
public final class DeclareExams extends javax.swing.JFrame {

    /**
     * Creates new form DeclareExams
     */
    CommonFunction cf=new CommonFunction();
    public int CorrectAnswers(int eid)
    {
        try{
         ResultSet rst=cf.getResultset("studentexam inner join exam where studentexam.eid=exam.eid and studentexam.sid="+eid);
         int count=0,correct=0;
        
         while(rst.next())
         {
//            if(rst.getString("expans").equals(rst.getString("ans")))
//            {
                 //marks=rst.getInt("max")/rst.getInt("totalq");
               // System.out.println("Per Question Marks"+marks);
             //   System.out.println("Marks Count is"+count);
             if(count==rst.getInt("totalq"))
             {
                return correct;
                 //break;
             }
             else{
                 ++count;
                  if(rst.getString("expans").equals(rst.getString("ans")))
                  {
                   System.out.println("Correct Answer"); 
                   ++correct;
                // obmarks=marks+obmarks;
                 
                 
                  }
                  else{
                      
                  }
             }
         }
            
        }catch(SQLException ee)
        {
            System.out.println("Obtained Marks Error"+ee);
            return 0;
        }
       return 0; 
        
    }
     public int ObtainedMarks(int eid)
    { 
        try{
            System.out.println("Student Id is"+eid);
         ResultSet rst=cf.getResultset("studentexam inner join exam where studentexam.eid=exam.eid and studentexam.sid="+eid);
         int count=0,marks=0,obmarks=0;
        
         while(rst.next())
         {
//            if(rst.getString("expans").equals(rst.getString("ans")))
//            {
                 marks=rst.getInt("max")/rst.getInt("totalq");
                 
               // System.out.println("Per Question Marks"+marks);
             //   System.out.println("Marks Count is"+count);
             if(count==rst.getInt("totalq"))
             {
                return obmarks;
                 //break;
             }
             else{
                 ++count;
                  if(rst.getString("expans").equals(rst.getString("ans")))
                  {
                   System.out.println("Correct Answer"); 
                   obmarks=marks;
                 obmarks=0+obmarks;
                 
                 
                  }
                  else{
                      
                  }
             }
//            }
//            else{
//                marks=0;
//            }
             
         }
            
        }catch(SQLException ee)
        {
            System.out.println("Obtained Marks Error"+ee);
            return 0;
        }
       return 0; 
    }
     public void GetResult(int obmarks,int row,int eid)
     {
         try{
             DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
             //ResultSet rst=cf.getResultset("studentexam inner join exam where studentexam.eid=exam.eid and studentexam.sid="+eid);
             ResultSet rst=cf.getResultset("studentexam inner join exam where studentexam.eid=exam.eid and studentexam.sid="+eid);
             if(rst.next())
             {
                 System.out.println("Exam Passing Marks"+rst.getInt("exam.pass"));
                 System.out.println("Obtained Marks"+obmarks);
             if(obmarks>=rst.getInt("exam.pass"))
               {
                   model.setValueAt("Pass",row,6);
                   
               }
               else{
                   model.setValueAt("Fail",row,6);
               }
             }
         }catch(Exception ee)
         {
             System.out.println("Exception is"+ee);
         }
     }
    public int AttemptedQuestion(int eid)
    { 
        try{
         ResultSet rst=cf.getResultset("studentexam inner join exam where studentexam.eid=exam.eid and studentexam.sid="+eid);
         
         int count=0;
         while(rst.next())
         {
             System.out.println("Hello"+count);
            if(rst.getString("expans")!=null)
            { 
                ++count;
             if(count==rst.getInt("totalq"))
             {
                 return count;
                 //break;
             }
             
            }
             
         }
            
        }catch(SQLException ee)
        {
            System.out.println("Attempted Questions Error"+ee);
            return 0;
        }
       return 0; 
    }
    public void enableNavigation()
    {
        eid1.setEditable(false);
        cname1.setEditable(false);
        sname1.setEditable(false);
        totalq1.setEditable(false);
        dur1.setEditable(false);
        quetype1.setEditable(false);
        max1.setEditable(false);
        min1.setEditable(false);
        date1.setEditable(false);

        
        
    }
    public DeclareExams(int eid) {
        initComponents();
        try{
             Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
              setTitle("Setting Result");
Image icon=new ImageIcon(this.getClass().getResource("removebg/megaExam.jpg")).getImage();
setIconImage(icon);
            enableNavigation();
            ResultSet rs=cf.getResultset("exam where eid="+eid);
            if(rs.next())
            {
                eid1.setText(""+rs.getInt("eid"));
                cname1.setText(rs.getString("cname"));
                sname1.setText(rs.getString("sname"));
                totalq1.setText(""+rs.getInt("totalq"));
                dur1.setText(""+rs.getInt("dur"));
                quetype1.setText(rs.getString("quetype"));
                max1.setText(""+rs.getInt("max"));
                min1.setText(""+rs.getInt("pass"));
                date1.setText(rs.getString("date"));
                
            }
            int count=0;
             DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            ResultSet rst=cf.getResultset("studentexam inner join student where studentexam.sid=student.id and studentexam.eid="+eid+" group by studentexam.sid");
           int row=0;
            while(rst.next())
            {
                System.out.println("Count is"+count);
               model.addRow(new Object[]{rst.getInt("student.id"),rst.getString("First_Name")+" "+rst.getString("Last_Name"),totalq1.getText(),"","",""});
              int eid2=Integer.parseInt(model.getValueAt(row, 0).toString());
              System.out.println("Exam ID is"+eid2);
                      
               count=AttemptedQuestion(eid2);
               model.setValueAt(count, row, 3);
               int corans=CorrectAnswers(eid2);
               model.setValueAt(corans,row,4);
               int marks=ObtainedMarks(eid2);
               model.setValueAt(marks,row,5);
               int obmarks=Integer.parseInt(model.getValueAt(row, 5).toString());
               System.out.println("Obtained Marks "+obmarks);
              // System.out.println("Passing Marks "+rst.getString("studentexam.pass"));
              GetResult(obmarks,row,eid2);
//               if(obmarks>rst.getInt("studentexam.pass"))
//               {
//                   model.setValueAt("Pass",row,5);
//                   
//               }
//               else{
//                   model.setValueAt("Fail",row,5);
//               }
            if(model.getValueAt(row,6)!=null)
            {
                model.setValueAt("Declare Result",row,7);
                
                
            } 
            else{
                model.setValueAt("",row,7);
            }
               ++row;
//               if(rst.getString("studentexam.ans")!=null)
//               {
//                   ++count;
//               }
            }
        }catch(Exception ee)
        {
            System.out.println("Decalare Exams Error"+ee);
        }
    }
    
    
    public DeclareExams() {
        initComponents();
         Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
             
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        eid1 = new javax.swing.JTextField();
        cname1 = new javax.swing.JTextField();
        sname1 = new javax.swing.JTextField();
        totalq1 = new javax.swing.JTextField();
        dur1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        quetype1 = new javax.swing.JTextField();
        max1 = new javax.swing.JTextField();
        min1 = new javax.swing.JTextField();
        date1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Exam ID");

        jLabel2.setText("Course Name");

        jLabel3.setText("Subject Name");

        jLabel4.setText("Total Questions");

        jLabel5.setText("Duration");

        jLabel6.setText("Maximum Marks");

        jLabel7.setText("Minimum Marks");

        jLabel8.setText("Question Type");

        jLabel9.setText("Date");

        jLabel10.setText("Minutes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalq1)
                            .addComponent(max1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(eid1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(min1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cname1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dur1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)))))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(sname1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quetype1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(date1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(eid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(totalq1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quetype1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(max1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(min1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Total Questions", "Attempted Questions", "Correct Answers", "Obtained Marks", "Result", "We Can Declare"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
Connection cnn;
PreparedStatement psmt1;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
           try{
              int colidx=jTable1.getSelectedColumn();
              int rowidx=jTable1.getSelectedRow();
              cnn=db.MyConnection.getConnection();
              psmt1=cnn.prepareStatement("insert into studentresult values (?,?,?,?,?,?,?,?,?,?,?)");
              DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
              if(colidx==7)
              {
                   if(JOptionPane.showConfirmDialog(this,"Are you surely want to declare Result?","Select Option",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                   { 
                       int sid=Integer.parseInt(model.getValueAt(rowidx,0).toString());
                       int eid=Integer.parseInt(eid1.getText());
                       System.out.println("Student ID is"+sid);
                       psmt1.setInt(1,Integer.parseInt(model.getValueAt(rowidx,0).toString()));
                       psmt1.setInt(2,Integer.parseInt(eid1.getText()));
                       psmt1.setString(3,model.getValueAt(rowidx,1).toString());
                       psmt1.setString(4,cname1.getText());
                       psmt1.setString(5,sname1.getText());
                       psmt1.setInt(6,Integer.parseInt(model.getValueAt(rowidx,2).toString()));
                       psmt1.setInt(7,Integer.parseInt(model.getValueAt(rowidx,3).toString()));
                       psmt1.setInt(8,Integer.parseInt(model.getValueAt(rowidx,4).toString()));
                       psmt1.setInt(9,Integer.parseInt(model.getValueAt(rowidx,5).toString()));
                       psmt1.setString(10,model.getValueAt(rowidx,6).toString());
                       if(JOptionPane.showConfirmDialog(this,"You Want Result to be Declared on Student Portal ?","Select Option",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                           psmt1.setString(11,"Declared");
                       } 
                       else {
                       }    psmt1.setString(11,"To be Declared");
                       //int count=psmt1.executeUpdate();
                       ResultSet rst=cf.getResultset("studentresult where sid="+sid+" and eid="+eid);
                    // int count=psmt1.executeUpdate();
//                       if(count>0 )
//                       {
//                           while(rst.next())
//                           {
//                               if(rst.getInt("sid")==sid && rst.getInt("eid")==eid)
//                               {
//                                  JOptionPane.showMessageDialog(this,"Record is Already Inserted");
//                                   count=0;
//                                  return;
//                                 
//                               }
//                               else{
//                                   JOptionPane.showMessageDialog(this,"Checking.....");
//                               }
//                           }
                           if(rst.next())
                           {
                               JOptionPane.showMessageDialog(this,"Record is Already Inserted");
                               ExamReport frm=new ExamReport(sid);
                               frm.setVisible(true);
                               //count=0;
                               return;
                              // break;
                              
                           }
                           else{
                             //  if(JOptionPane.showConfirmDialog(this,"Are you want to Insert Record?","Select Option",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                             ExamReport frm=new ExamReport(sid);
                               frm.setVisible(true);
                             JOptionPane.showMessageDialog(this,"You can insert Record");
                             System.out.println("OBT MARKS"+model.getValueAt(rowidx,5));
                           int count=psmt1.executeUpdate();
                           if(count>0)
                           {
                               System.out.println("Record Inserted");
                           }
                           else{
                               System.out.println("Record Not Inserted");
                           } 
                           }
                         //return;
                       }
//                       else{
//                           System.out.println("Record Not Inserted");
//                       }
//                       
//                   }
              }
               
           }catch(Exception ee)
           {
               System.out.println("Exception is"+ee);
           }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(DeclareExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeclareExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeclareExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeclareExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeclareExams().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cname1;
    private javax.swing.JTextField date1;
    private javax.swing.JTextField dur1;
    private javax.swing.JTextField eid1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField max1;
    private javax.swing.JTextField min1;
    private javax.swing.JTextField quetype1;
    private javax.swing.JTextField sname1;
    private javax.swing.JTextField totalq1;
    // End of variables declaration//GEN-END:variables
}
