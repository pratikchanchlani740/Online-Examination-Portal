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
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratik
 */
public final class ShowResult extends javax.swing.JFrame {

    /**
     * Creates new form ShowResult
     * @throws java.lang.Exception
     */
    public void readData() throws Exception
    {
        ResultSet rst=cf.getResultset("course");
        cname.removeAllItems();
        while(rst.next())
        {
           cname.addItem(rst.getString("cname")); 
        }
        
    }
    public void readData2(String sname1,String cname1) // throws Exception 
    {
        try{
             Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
              setTitle("Results");
Image icon=new ImageIcon(this.getClass().getResource("removebg/megaExam.jpg")).getImage();
setIconImage(icon);
         DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
           while(model.getRowCount()>0)
        {
           model.removeRow(model.getRowCount()-1);
       } 
           Date d2=new Date();
           ResultSet rst1=null;
           if(sname1.equalsIgnoreCase("All"))
           {
               rst1=cf.getResultset("exam where cname='"+cname1+"'");
           }
           else{
           rst1=cf.getResultset("exam where cname='"+cname1+"' and sname='"+sname1+"'");
           }// Date d1=rs.getDate("date");
           
           if(rst1.next())
           {
              
//               
                  // System.out.println("Hello");
          do{
               Date d1=rst1.getDate("date");
              if(d1.compareTo(d2)>0 && rst1.getString("state").equalsIgnoreCase("Attempted"))
//                   
               {
           model.addRow(new Object[]{rst1.getString("eid"),rst1.getString("totalq"),rst1.getString("dur"),rst1.getString("max"),rst1.getString("pass"),rst1.getString("date"),rst1.getString("quetype")});
              } 
       }while(rst1.next());
               }
//           }
    }
    
    catch(Exception ee)
    {
        System.out.println("Exception is"+ee);
    }
    }
//    public void readData1() throws Exception
//    {
//        
//      
//        System.out.println("Course Name is"+cname1);
//        ResultSet rst=cf.getResultset("subject where cid='"+cname1+"'");
//        sname.removeAllItems();
//       while(rst.next())
//       {
//           sname.addItem(rst.getString("sname"));
//       }
//        //Result
//    }
    public void readData1(String cname) throws Exception
    {
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount()>0)
       {
           model.removeRow(model.getRowCount()-1);
       }
          Date d2=new Date();
        ResultSet rst1=cf.getResultset("exam where cname='"+cname+"'");
        if(rst1.next())
        {
            do{
               Date d1=rst1.getDate("date");
              if(d1.compareTo(d2)>0 && rst1.getString("state").equalsIgnoreCase("Attempted"))
//                   
               {
           model.addRow(new Object[]{rst1.getString("eid"),rst1.getString("totalq"),rst1.getString("dur"),rst1.getString("max"),rst1.getString("pass"),rst1.getString("date"),rst1.getString("quetype")});
              } 
       }while(rst1.next());
        }
            
         System.out.println("Course Name is"+cname);
         ResultSet rst=cf.getResultset("subject where cid='"+cname+"'");
        sname.removeAllItems();
       sname.addItem("All");
       while(rst.next())
       {
           sname.addItem(rst.getString("sname"));
       }
//       System.out.println("Rows Count"+model.getRowCount());
//       
//       
//       if(rst1==null) {
//         } 
//       else if(rst1.next())
//       {    
//       while(rst1.next())
//       {
//           model.addRow(new Object[]{rst1.getString("eid"),rst1.getString("totalq"),rst1.getString("dur"),rst1.getString("max"),rst1.getString("pass"),rst1.getString("date"),rst1.getString("quetype")});
//           
//       }
//       }
    }
    Connection cnn;
    CommonFunction cf=new CommonFunction();
    
    public ShowResult(String course)
    {
        initComponents();
         try{
        
          
        }catch(Exception ee)
        {
            System.out.println("Exception in Show Result"+ee);
        }
        
    }
    public ShowResult() {
        initComponents();
        try{
            Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
 
            ResultSet rs=cf.getResultset("exam");
            readData();

            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
             Date d2=new Date();

//           while(rs.next())
//            {
//
//              Date d1=rs.getDate("date");
//            
//              if(d1.compareTo(d2)>=0)
//              {
//
//                  if(rs.getString("state").equalsIgnoreCase("Attempted"))
//                model.addRow(new Object[]{rs.getString("eid"),rs.getString("totalq"),rs.getString("dur"),rs.getString("max"),rs.getString("pass"),rs.getString("date"),rs.getString("quetype")});   
//
//              }
//            
//              else{
//                  rs.next();
//              }
//
//            }
       
        }catch(Exception ee)
        {
            System.out.println("Exception in Show Result"+ee);
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
        cname = new javax.swing.JComboBox<>();
        sname = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Course");

        jLabel2.setText("Subject");

        cname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cnameItemStateChanged(evt);
            }
        });

        sname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                snameItemStateChanged(evt);
            }
        });

        jButton1.setText("Show All Result");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam ID", "Total Questions", "Duration", "Maximum", "Minimum", "Date", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cnameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cnameItemStateChanged
      try{
         String cname1=cname.getSelectedItem().toString();
        
        readData1(cname1);
//          ShowResult showResult = new ShowResult(cname1);
//          showResult.setVisible(true);
      }catch(Exception ee)
      {
          System.out.println("Exception is"+ee);
      }
    }//GEN-LAST:event_cnameItemStateChanged

    private void snameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_snameItemStateChanged
      try{
          if(sname.getSelectedIndex()==-1)
          {
          }
          else{
        String sname1=sname.getSelectedItem().toString();
        String cname1=cname.getSelectedItem().toString();
       readData2(sname1,cname1);
          }
      }catch(Exception ee)
      {
          System.out.println("Subject Chnaged Exception"+ee);
      }
    }//GEN-LAST:event_snameItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try{
//        String sname1=sname.getSelectedItem().toString();
//        String cname1=cname.getSelectedItem().toString();
//        readData2(sname1,cname1);
          ResultSet rs=cf.getResultset("exam");
           // readData();
          
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
             Date d2=new Date();
             while(model.getRowCount()>0)
       {
           model.removeRow(model.getRowCount()-1);
       }
           while(rs.next())
            {
             
              Date d1=rs.getDate("date");
              
              if(d1.compareTo(d2)>=0)
              {
                 if(rs.getString("state").equalsIgnoreCase("Attempted"))
                model.addRow(new Object[]{rs.getString("eid"),rs.getString("totalq"),rs.getString("dur"),rs.getString("max"),rs.getString("pass"),rs.getString("date"),rs.getString("quetype")});   
             
                
              }
              
              else{
                  rs.next();
              }

            }
            
      }catch(Exception ee)
      {
          System.out.println("Exception in Button"+ee);
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
            java.util.logging.Logger.getLogger(ShowResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> sname;
    // End of variables declaration//GEN-END:variables
}
