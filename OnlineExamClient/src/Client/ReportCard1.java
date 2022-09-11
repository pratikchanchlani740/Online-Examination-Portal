/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Pack1.CourseDemo1;
import Pack1.Exam;
import Pack1.ExamResult1;
import Pack1.FinalResult;
import Pack1.FinalResult1;
import Pack1.User;
import Pack1.UserRemote;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratik
 */
public class ReportCard1 extends javax.swing.JFrame {

    /**
     * Creates new form ReportCard
     */
    Demo client=null;
    public ReportCard1() {
        initComponents();
        Container ctx=getContentPane();
            ctx.setBackground(new Color(255,255,150));
            jPanel1.setBackground(new Color(255,255,150));
            setTitle("Report Card");
Image icon=new ImageIcon(this.getClass().getResource("removebg/online1.png")).getImage();
setIconImage(icon);
//            jPanel2.setBackground(new Color(255,255,150));
//            jPanel3.setBackground(new Color(255,255,150));
            
    }
    public List<FinalResult> list1=null;
    public List<CourseDemo1> list2=null;
    public List<ExamResult1> list3=null;
    public List<Exam> list4=null;
    public ReportCard1(Demo inform) {
        initComponents();
        try{
            client=inform;
            System.out.println("Client Report Card");
            Container ctx=getContentPane();
            //ctx.setBackground(new Color(255,255,150));
//            jPanel1.setBackground(new Color(255,255,150));
//            jPanel2.setBackground(new Color(255,255,150));
//            jPanel3.setBackground(new Color(255,255,150));
            User u=inform.getUser();
            int sid=u.getId();
            int course=u.getCourse();
            UserRemote ur=Demo.getUserRemote();
            list2=ur.courseDetails(course);
            Iterator it2=list2.iterator();
            if(it2.hasNext())
            {
                CourseDemo1 crs=(CourseDemo1)it2.next();
                String cname=crs.getCname();
                System.out.println("Course Name is"+cname);
                System.out.println("Student ID is"+sid);
                list1=ur.getFinalReport(sid, cname);
                Iterator it1=list1.iterator();
                if(it1.hasNext())
                {
                    FinalResult fin=(FinalResult)it1.next();
                    jTextField1.setText(""+fin.getSid());
                    jTextField2.setText(u.getFirstname()+" "+u.getLastname());
                    jTextField13.setText(fin.getCname());
                    jTextField3.setText(u.getPhone());
                    byte b[]=u.getImg();
 System.out.println(""+b.length);

 
 Image im= Toolkit.getDefaultToolkit().createImage(b,0,b.length);

ImageIcon img= new ImageIcon(im);

        

Image im1=img.getImage().getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH);

img=new ImageIcon(im1);

 jLabel16.setIcon(img);
 System.out.println(""+fin.getTotalq());
//                    jTextField4.setText(""+fin.getTotalq());
//                    jTextField5.setText(""+fin.getAttempted());
//                    jTextField6.setText(""+fin.getNattempted());
//                    jTextField7.setText(""+fin.getCorrect());
//                    jTextField8.setText(""+fin.getWrong());
//                    jTextField9.setText(""+fin.getTotalm());
//                    jTextField12.setText(""+fin.getMaxm());
//                    jTextField10.setText(""+fin.getPer());
//                    jTextField11.setText(fin.getResult());
                    
                    //Exam
                    
                   
                    
                }
                
                
            }
            else{
                JOptionPane.showMessageDialog(this,"No Result Of this Course");
            }
            list3=ur.getStudentResult(sid);
                    Iterator it3=list3.iterator();
                    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                    while(it3.hasNext())
                    {   
                        System.out.println("student result list");
                        ExamResult1 exam=(ExamResult1)it3.next();
                        System.out.println("student result "+exam.getEid());
                        
                        list4=ur.examDetails1(exam.getEid());
                         Iterator it4=list4.iterator();
                         if(it4.hasNext())
                         {
                             Exam ex=(Exam)it4.next();
                             System.out.println("exam table "+ex.getEid());
                             if(exam.getEid()==(ex.getEid()))
                                 System.out.println("Exam Total Questions"+ex.getTotalq());
                            model.addRow(new Object[]{exam.getEid(),exam.getCname(),exam.getSname(),ex.getDate(),ex.getTotalq(),ex.getMax(),ex.getDur(),ex.getPass()});
                         }    
                        
                    }
            
            //list1=ur.getFinalReport(WIDTH, course);
            
        }catch(Exception ee)
        {
            System.out.println("Report Card Error"+ee);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Phone No.");

        jButton1.setText("SAVE THE RESULT");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(114, 114, 114)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam ID", "CourseName", "SubjectName", "Exam Date", "Total Questions", "MaximumMarks", "Duration", "Passing Marks"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel18.setText("Course");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(59, 59, 59)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(360, 360, 360))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
//            Connection cnn=db.MyConnection.getConnection();
//            PreparedStatement psmt1=cnn.prepareStatement("insert into finalresult values(?,?,?,?,?,?,?,?,?,?,?)");
//            int sid1=Integer.parseInt(jTextField1.getText());
//            String course=jTextField13.getText();
//            ResultSet rst=cf.getResultset("finalresult where sid="+sid1+" and cname='"+course+"'");
//            psmt1.setInt(1,Integer.parseInt(jTextField1.getText()));
//            psmt1.setString(2,jTextField13.getText());
//
//            psmt1.setInt(3,Integer.parseInt(jTextField4.getText()));
//            psmt1.setInt(4,Integer.parseInt(jTextField5.getText()));
//            psmt1.setInt(5,Integer.parseInt(jTextField6.getText()));
//            psmt1.setInt(6,Integer.parseInt(jTextField7.getText()));
//            psmt1.setInt(7,Integer.parseInt(jTextField8.getText()));
//            psmt1.setInt(8,Integer.parseInt(jTextField9.getText()));
//            psmt1.setInt(9,Integer.parseInt(jTextField12.getText()));
//            System.out.println("Final Percentage is"+per1);
//            //float per2=Float.parseFloat(jTextField10.getText());
//            //System.out.println("Field Percentage is"+per2);
//            psmt1.setFloat(10,per1);
//            //psmt1.setInt(10,per1);
//
//            psmt1.setString(11,jTextField11.getText());
//
//            // System.out.println("Count is"+count);
//            if(rst.next())
//            {
//                JOptionPane.showMessageDialog(this,"Record Already Present");
//
//                return;
//            }
//            else{
//                int count=psmt1.executeUpdate();
//                System.out.println("Count is"+count);
//                if(count>0)
//                {
//                    System.out.println("Record Inserted");
//                }
//                else{
//                    System.out.println("Record Not Inserted");
//                }
//            }
        }catch(Exception ee)
        {
            System.out.println("Exception ee"+ee);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
            int rowidx=jTable1.getSelectedRow();
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            int eid=Integer.parseInt(model.getValueAt(rowidx,0).toString());
//            ExamReport exm=new ExamReport(client,eid);
//            exm.setVisible(true);
              ExamReport1 exm=new ExamReport1(client,eid);
             exm.setVisible(true);
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
            java.util.logging.Logger.getLogger(ReportCard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportCard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportCard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportCard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportCard1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
