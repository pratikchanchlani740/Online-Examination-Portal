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
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratik
 */
public class ExamQuestions extends javax.swing.JFrame {

    /** Creates new form ExamQuestions */
    CommonFunction cf=new CommonFunction();
    public ResultSet rs;
    //public ResultSet rs;
    public ExamQuestions(String eid)
    {
         Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
              setTitle("Exam Questions");
Image icon=new ImageIcon(this.getClass().getResource("removebg/megaExam.jpg")).getImage();
setIconImage(icon);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        System.out.println("Enrollment ID is"+eid);
        try{
           DefaultTableModel model=(DefaultTableModel)jTable1.getModel(); 
          rs=cf.getResultset("examquestion where eid="+eid);
          
          while(rs.next())
          {
            // System.out.println("Eid"+rs.getString(3));
              ResultSet rst1=cf.getResultset("question where qno="+rs.getString(2));
              if(rst1.next())
              {
                  model.addRow(new Object[]{rst1.getString("qno"),rst1.getString("ques"),rst1.getString("op1"),rst1.getString("op2"),rst1.getString("op3"),rst1.getString("op4"),"EDIT","DELETE"});
              }
          }
            
        }catch(Exception ee)
        {
            System.out.println("Error is"+ee);
        }
    }
    public ExamQuestions() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Qno", "Question Name", "Option 1", "Option 2", "Option 3", "Option 4", "Edit", "Delete "
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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      try{
          DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
        int colidx=jTable1.getSelectedColumn();
        int rowidx=jTable1.getSelectedRow();
        if(colidx==6)
        {
            int id=Integer.parseInt(model.getValueAt(rowidx,0).toString());
            if(JOptionPane.showConfirmDialog(this,"Surely Want to Edit ?")==JOptionPane.OK_OPTION)
            {
            QuestionForm frm=new QuestionForm(id);
            frm.setVisible(true);
            }
            else{
                
               
            }
        }
        if(colidx==7)
        {
            int id=Integer.parseInt(model.getValueAt(rowidx,0).toString());
            if(JOptionPane.showConfirmDialog(this,"Surely Want to Delete ?")==JOptionPane.OK_OPTION)
            {
//            QuestionForm frm=new QuestionForm(id);
//            frm.setVisible(true);
            model.removeRow(rowidx);
            }
            else{
                
               
            }
        }
                }
      catch(Exception ee)
      {
          System.out.println("Exception in Exam Question Table"+ee);
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
            java.util.logging.Logger.getLogger(ExamQuestions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamQuestions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamQuestions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamQuestions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamQuestions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
