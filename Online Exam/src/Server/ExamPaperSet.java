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
import java.util.*;
//import java.sql.Date;
//import java.util.Date;
import java.time.*;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratik
 */
public class ExamPaperSet extends javax.swing.JFrame {

    /**
     * Creates new form ExamPaperSet
     */
    //Paper V=new Paper();
    PreparedStatement psmt2;
    Connection cnn;
    CommonFunction cf=new CommonFunction();
    public ExamPaperSet(Paper V)
    {
        initComponents();
         
        try{
             Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
              setTitle("Exam Paper Set");
Image icon=new ImageIcon(this.getClass().getResource("removebg/megaExam.jpg")).getImage();
setIconImage(icon);
            ResultSet rs=cf.getResultset("exam");
            DefaultTableModel model=(DefaultTableModel)tab.getModel();
             Date d2=new Date();
           while(rs.next())
            {
              Date d1=rs.getDate("date");
              
              if(d1.compareTo(d2)>=0)
                model.addRow(new Object[]{rs.getString("eid"),rs.getString("cname"),rs.getString("sname"),rs.getString("totalq"),rs.getString("dur"),rs.getString("max"),rs.getString("pass"),rs.getString("date"),rs.getString("quetype"),"Remaining"});   
              else if(d1.compareTo(d2)<0)
              {
              model.addRow(new Object[]{rs.getString("eid"),rs.getString("cname"),rs.getString("sname"),rs.getString("totalq"),rs.getString("dur"),rs.getString("max"),rs.getString("pass"),rs.getString("date"),rs.getString("quetype"),"Expires"});   
              }
            
            }
//           int row=0;   
//           int rowindex=jTable1.getRowCount();
//             System.out.println("Rows"+rowindex);
//           
//           while (row<rowindex)
//           {
//               String type=model.getValueAt(row,9).toString();
//               System.out.println("Selected Type"+type);
//              // System.out.println(""+model.getColumnName(9));
//               if(type.equals("Expires"))
//               {
//                   jTable1.getColumnModel().getColumn(9).setCellRenderer(new EditDesign2());
//                   
//               }
//               else if(type.equals("Remaining"))
//               {
//                   System.out.println("Remaining");
//                    jTable1.getColumnModel().getColumn(9).setCellRenderer(new EditDesign());
//
//               }
//               ++row;
//           }
//            
            
//            //LocalDate d=new LocalDate();
//            System.out.println(""+LocalDate.now());
//            String dt2=LocalDate.now().toString();
//            StringTokenizer A=new StringTokenizer(dt2,"-");
//               int y2=0,m2=0,d2=0;
//               while(A.hasMoreTokens())
//                   {
//                       if(y2==0)
//                         y2=Integer.parseInt(A.nextToken())-1900;
//                       else if(m2==0)
//                        m2=Integer.parseInt(A.nextToken())-1;
//                       else
//                         d2=Integer.parseInt(A.nextToken());
//                   }
//            
//            String dt1=V.getD().toString();
//            StringTokenizer B=new StringTokenizer(dt1,"-");
//               int y1=0,m1=0,d1=0;
//               while(B.hasMoreTokens())
//                   {
//                       if(y1==0)
//                         y1=Integer.parseInt(B.nextToken())-1900;
//                       else if(m1==0)
//                        m1=Integer.parseInt(B.nextToken())-1;
//                       else
//                         d1=Integer.parseInt(B.nextToken());
//                   }
//               
//            if(y2>y1)
//            {
//                model.setValueAt("Remaining", 0, 9);
//                if(m2>m1)
//                        {
//                          model.setValueAt("Remaining",0,9);
//                        if(d2>d1)
//                        {
//                            model.setValueAt("Remaining",0,9);
//                        }
//                        }
//                
//            }
//            
            
            
        }
        catch(Exception ee)
        {
            System.out.println("Exception in ExamPaperSet"+ee);
        }
        
    }
    
    
    public ExamPaperSet() {
        initComponents();
       // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try{
            
            ResultSet rs=cf.getResultset("exam");
            DefaultTableModel model=(DefaultTableModel)tab.getModel();
             Date d2=new Date();
             
             //int colindex=jTable1.getSelectedColumn();
             
            //int row=0;
           while(rs.next())
            {
             tab.getColumnModel().getColumn(9).setCellRenderer(new EditDesign());  
              Date d1=rs.getDate("date");
              
              if(d1.compareTo(d2)>=0)
              {
                model.addRow(new Object[]{rs.getString("eid"),rs.getString("cname"),rs.getString("sname"),rs.getString("totalq"),rs.getString("dur"),rs.getString("max"),rs.getString("pass"),rs.getString("date"),rs.getString("quetype"),"Remaining"});   
              // tab.getColumnModel().getColumn(9).setCellRenderer(new EditDesign());
                // tab.getColumnModel().getColumn(9).setCellRenderer(new EditDesign2());
// String type=model.getValueAt(row,9).toString();
               // System.out.println("Selected Type"+type);
               // jTable1.getColumnModel().getColumn(9).setCellRenderer(new EditDesign1());
                
              }
              else if(d1.compareTo(d2)<0)
              {
              model.addRow(new Object[]{rs.getString("eid"),rs.getString("cname"),rs.getString("sname"),rs.getString("totalq"),rs.getString("dur"),rs.getString("max"),rs.getString("pass"),rs.getString("date"),rs.getString("quetype"),"Expires"});   
             // tab.getColumnModel().getColumn(9).setCellRenderer(new EditDesign2());
              //tab.getColumnModel().getColumn(8).setCellRenderer(new EditDesign());
//String type=model.getValueAt(row,9).toString();
              //  System.out.println("Selected Type"+type);
              
             // jTable1.getColumnModel().getColumn(9).setCellRenderer(new EditDesign());
              }
            //row++;
            }
          int row=0;   
           int rowindex=model.getRowCount();
             System.out.println("Rows"+rowindex);
           
//           while (row<rowindex)
//           {
//               String type=model.getValueAt(row,9).toString();
//               
//               System.out.println("Selected Type"+type);
//              // System.out.println(""+model.getColumnName(9));
//               if(type.equalsIgnoreCase("Expires"))
//               {
//                  tab.getColumnModel().getColumn(9).setCellRenderer(new EditDesign());
//                   
//               }
//               else if(type.equalsIgnoreCase("Remaining"))
//               {
//                   //System.out.println("Remaining");
//                   tab.getColumnModel().getColumn(9).setCellRenderer(new EditDesign());
//                    
//                    
//
//               }
//             
//               ++row;
//                 break;
//           }
           
           
           
           
           
           
       
           
           
           
           
           
           
           
           
           
//           int row=0;
//           while (row<rowindex)
//           {
//               String type=model.getValueAt(row,9).toString();
//               System.out.println("Selected Type"+type);
//               if(type.equals("Expires"))
//               {
//                   jTable1.getColumnModel().getColumn(9).setCellRenderer(new EditDesign());
//               }
//               else{
//                    jTable1.getColumnModel().getColumn(9).setCellRenderer(new EditDesign1());
//
//               }
//               row++;
//           }
          
           //System.out.println("Selected Type"+type);
       // String type1=model.getValueAt(rowindex,colindex).toString();
//            jTable1.getColumnModel().getColumn(4).setCellRenderer(new EditDesign());
//            jTable1.getColumnModel().getColumn(5).setCellRenderer(new EditDesign1());
//            ResultSet rs=cf.getResultset("exam");
//            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
//            
//            
//            //LocalDate d=new LocalDate();
//            System.out.println(""+LocalDate.now());
//            while(rs.next())
//            {
//              
//             model.addRow(new Object[]{rs.getString("eid"),rs.getString("cname"),rs.getString("sname"),rs.getString("totalq"),rs.getString("dur"),rs.getString("max"),rs.getString("pass"),rs.getString("date"),rs.getString("quetype"),"Expired"});   
//            }
//            
            
        }
        catch(Exception ee)
        {
            System.out.println("Exception in ExamPaperSet"+ee);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam ID", "Course Name", "Subject Name", "Total Questions", "Duration", "Maximum Marks", "Passing Marks", "Date", "Type", "Expired/Remaining"
            }
        ));
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("SHOW REMAINING");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
         try{
             DefaultTableModel model=(DefaultTableModel)tab.getModel();
         
          
        int index=tab.getSelectedRow();
          int column=tab.getSelectedColumn();
           String cname=model.getValueAt(index,1).toString();
           String sname=model.getValueAt(index,2).toString();
         ResultSet  rs=cf.getResultset("exam where cname='"+cname+"' and sname='"+sname+"'");
         //QuestionList frm=new QuestionList();
         String eid=model.getValueAt(index,0).toString();
         
         //String query1=" examquestion where eid="+eid;
            
         
         Paper V=new Paper();
         V.setEid(Integer.parseInt(model.getValueAt(index,0).toString()));
//         V.setCname(model.getValueAt(index, 1).toString());
//         V.setSname(model.getValueAt(index, 2).toString());
        //ConductExam frm=new ConductExam(V);
         //frm.rs=rs;
         String time=model.getValueAt(index,9).toString();
         
        if(time.equalsIgnoreCase("Expires"))
        {
//             ExamQuestions frm=new ExamQuestions(eid);
//       
//         frm.setVisible(true);
             if(JOptionPane.showConfirmDialog(this,"Surely Want to Delete ?")==JOptionPane.OK_OPTION) 
             {
            System.out.println("Eid "+V.getEid());
            cnn=db.MyConnection.getConnection();
         psmt2=cnn.prepareStatement("delete from exam where eid=?");
         psmt2.setInt(1,V.getEid());
         int count1=psmt2.executeUpdate();
         if(count1>0)
         {
             System.out.println("Record is Deleted");
             model.removeRow(index);
         }
        }
         else{
             System.out.println("Record Not Deleted");
         }
         
        }
        else{
        ExamQuestions frm=new ExamQuestions(eid);
       
         frm.setVisible(true);
        }
         }catch(Exception ee)
         {
             System.out.println("Table Error"+ee);
         }
           
    }//GEN-LAST:event_tabMouseClicked
int count=0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model=(DefaultTableModel)tab.getModel();
        try{
            
            
            
            String time="";
        int rows=model.getRowCount();
        System.out.println("Total Number of Rows"+rows);
    int row=0;
        
       
      int id=0;
       
        ArrayList lst=new ArrayList();
       while(row<rows-1)
       {  
          //System.out.println("No. of Rows"+rows);
          ++row;
           time=model.getValueAt(row,9).toString();
           if(time.equals("Remaining"))
            {    
                //System.out.println("Hello"+count);
               // id[]=new int[10];
               // count++;
                
                id= Integer.parseInt(model.getValueAt(row,0).toString());
                    lst.add(id);
                    
//                System.out.println("ID is"+id);
//                  ExamConduction frm=new ExamConduction(id);
//           frm.setVisible(true);

                 //count++;
            }
           
          
           
           
           
           
       }
        
      // System.out.println("Count is"+count);
          // while(rows)
        
          
             ExamConduction frm=new ExamConduction(time,lst);
           frm.setVisible(true);
       
      
        }
        catch(Exception ee)
        {
            System.out.println("Error is"+ee);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ExamPaperSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamPaperSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamPaperSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamPaperSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamPaperSet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab;
    // End of variables declaration//GEN-END:variables
}
