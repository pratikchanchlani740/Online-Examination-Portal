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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratik
 */
public class ChangeStatus extends javax.swing.JFrame {

    /**
     * Creates new form ChangeStatus
     */
    public int row1;
    public void setmodelRow(int r)
    {
       row1=r;
    }
    public int getmodelRow()
    {
        return row1;
    }
    public ResultSet rs;
    CommonFunction cf=new CommonFunction();
    ArrayList lst2=new ArrayList();
    ExamConduction frm;
    DeactivatedExams frm1;
    public ChangeStatus(int eid1) throws Exception
    {
        ResultSet rst=cf.getResultset("exam where eid="+eid1);
        if(rst.next())
        {
        //  eid.setText(""+(rst.getString("eid"));
          eid.setText(""+rst.getInt("eid"));
          cname.setText(rst.getString("cname"));
          sname.setText(rst.getString("sname"));
          status.setSelectedItem(rst.getString("state"));
        }
           
    }
            
    public ChangeStatus(DeactivatedExams frm1,int id) throws Exception
    {
        initComponents();
        this.frm1=frm1;
        ResultSet rst=cf.getResultset("exam where eid="+id);
        if(rst.next())
        {
          eid.setText(rst.getString("eid"));
          cname.setText(rst.getString("cname"));
          sname.setText(rst.getString("sname"));
          status.setSelectedItem(rst.getString("state"));
        }
        jButton1.setText("EDIT");
    }
    public ChangeStatus(String state1,int id1,int row,String type)
    {
        initComponents();
//        this.frm=frm;
//        this.lst2=lst2;
        try{
           //type1.setText(""+type);
            System.out.println("State is"+state1);
           //status.removeAllItems();
           int idx=0;
           
           if(state1.equalsIgnoreCase("Activate"))
           {
               idx=0;
           }
           else if(state1.equalsIgnoreCase("Deactivate"))
           {
               idx=1;
           }
           else{
               idx=2;
           }
           status.setSelectedIndex(idx);
          // System.out.println("Row is"+row);
          setmodelRow(row);
           //status.setSelectedItem((Object)state1);
            rs=cf.getResultset("exam where state='"+state1+"' and eid="+id1);
            if(rs.next())
            {
                eid.setText(rs.getString("eid"));
                cname.setText(rs.getString("cname"));
                sname.setText(rs.getString("sname"));
                
               // System.out.println("ResultSet Object is"+rs.getObject("state"));
               //Object obj=rs.getObject("state");
                //status.setSelectedItem();
                        }
        }catch(Exception ee)
        {
            System.out.println("Exception in Change Status Parameter"+ee);
        }
        
    }
   public ChangeStatus(ExamConduction frm,int id1,String state,int row,ArrayList lst)  
   { 
       initComponents();
       this.frm=frm;
       this.lst2=lst;
       try{
            // lst.remove(row);
           System.out.println("Hello");
           System.out.println("Exam id"+id1);
      
      String query="select * from exam where eid="+id1;
      ResultSet rst=cf.getResult(query);
       Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
              setTitle("Change Status");
Image icon=new ImageIcon(this.getClass().getResource("removebg/megaExam.jpg")).getImage();
setIconImage(icon);
           cname.setEditable(false);
           sname.setEditable(false);
       if(rst.next())
       {
        
           System.out.println("Hello1");
              eid.setText(rst.getString("eid"));
                cname.setText(rst.getString("cname"));
               sname.setText(rst.getString("sname"));
                
                status.setSelectedItem(state);
       }
//      
       else{
           
       }
       }catch(Exception ee)
       {
           System.out.println("Exception in ChangeStatus"+ee);
       }
       
  }
    public void enableNavigation()
    {
        eid.setEditable(false);
         cname.setEditable(false);
          sname.setEditable(false);
    }
    public ChangeStatus() {
        initComponents();
        enableNavigation();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();
        cname = new javax.swing.JTextField();
        sname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Exam ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Course Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Subject Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setText("Status");

        eid.setText("\n");

        sname.setText("\n");

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setText("CHANGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVATE", "DEACTIVATE", "ATTEMPTED" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eid)
                            .addComponent(cname)
                            .addComponent(sname)
                            .addComponent(status, 0, 132, Short.MAX_VALUE))))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     // String status1=status.getSelectedItem().toString();
      int index=getmodelRow();
      System.out.println("Rows to Transfer"+index);
      try{
           Connection cnn=db.MyConnection.getConnection();
          PreparedStatement psmt1=cnn.prepareStatement("update exam set state=? where eid=?");
          if(jButton1.getText().equalsIgnoreCase("Change"))
          {
         
          psmt1.setString(1, status.getSelectedItem().toString());
          
          psmt1.setInt(2,Integer.parseInt(eid.getText()));
          //String time=status.getSelectedItem().toString();
          int count=psmt1.executeUpdate();
          if(count>0)
          {
              System.out.println("Record Upadated");
              dispose();
              int row=Integer.parseInt(eid.getText());
              String time="Remaining";
              
             ExamConduction frm=new ExamConduction(time,lst2);
             frm.setVisible(true);            
              
          }
          else{
              System.out.println("Record Not Updated");
          }
          }
          else{
              psmt1.setString(1, status.getSelectedItem().toString());
          
             psmt1.setInt(2,Integer.parseInt(eid.getText()));
              psmt1.executeUpdate();
              String cname1=cname.getText();
              String sname1=sname.getText();
             
//              DeactivatedExams frm=new DeactivatedExams();
//              frm.dispose();
//              frm.setVisible(true);
               frm1.fillTable();
                dispose();
               //dispose();
                 // DeactivatedExams frm=new DeactivatedExams();
                  
          }
          //ArrayList lst=new ArrayList();
          //int id=Integer.parseInt(eid.getText());
          //lst.add(id);
            //String time=type1.getText();
          //System.out.println("Time"+time);
//           ExamConduction frm=new ExamConduction(lst);
//           frm.setVisible(true);
          
      }catch(Exception ee)
      {
          System.out.println("Exception in Change Button"+ee);
      }
//      ExamConduction frm=new ExamConduction(status1,index);
//      frm.setVisible(true);
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
            java.util.logging.Logger.getLogger(ChangeStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cname;
    private javax.swing.JTextField eid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField sname;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
