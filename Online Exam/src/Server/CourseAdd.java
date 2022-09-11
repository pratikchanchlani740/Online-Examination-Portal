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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratik
 */
public class CourseAdd extends javax.swing.JFrame {
    
    
    
    
     public void readData() throws Exception
    {
        ResultSet rs=cf.getResultset("course");
          DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
//         if(JOptionPane.showConfirmDialog(this,"Do you Surely Want To Delete The Record ?")==JOptionPane.OK_OPTION)
//         {
         while(model.getRowCount()>0)
         {
             
             model.removeRow(model.getRowCount()-1);
             }
            
             
//         }
//          else{
//              
//          }
         
       
        if(rs.next())
        {
          do{
               
          
                model.addRow(new String[]{rs.getString(1),rs.getString(2),"Edit","Delete"});
          
          }while(rs.next());
          
        }
    }
    

    /**
     * Creates new form CourseAdd
     */
    public ResultSet rs;
    PreparedStatement psmt1,psmt2;
    CommonFunction cf=new CommonFunction();
    
    public CourseAdd() {
        
        initComponents();
        try{
         Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
              setTitle("Manage Courses");
Image icon=new ImageIcon(this.getClass().getResource("removebg/megaExam.jpg")).getImage();
setIconImage(icon);
        Connection cnn=db.MyConnection.getConnection();
        psmt1=cnn.prepareStatement("insert into course values(?,?)");
        psmt2=cnn.prepareStatement("delete from course where cid=?");
        
        rs=cf.getResultset("course");
        
        //frm.cid=cid;
        
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        if(rs.next())
        {
            int cid1=cf.getMaxId("select max(cid) from course");
            
            cid1++;
            cid.setText(cid1+"");
          //  cid.setEditable(false);
            readData();
        }
        else{
            JOptionPane.showMessageDialog(null,"No Record");
            cid.setText("1");
        }
            
        }catch(Exception ee)
        {
            
        }
    }
//     public ResultSet getResult()throws Exception
//    {
//        Connection cnn=db.MyConnection.getConnection();
//        
//        
//        Statement smt=cnn.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
//        
//        return smt.executeQuery("select * from course");
//    }
//    

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
        cid = new javax.swing.JTextField();
        cname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cyear = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Course ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Course Name");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Course Name", "Edit", "Delete"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        cyear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIRST", "SECOND", "THIRD" }));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("NEXT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cid)
                                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cyear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(85, 85, 85)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
           
          // System.out.println(cid.getText());
          // System.out.println(cname.getText());
          int crow=rs.getRow();
           psmt1.setString(1,cid.getText());
           String c=cname.getText()+"-"+cyear.getSelectedItem().toString();
           System.out.println(""+c);
           psmt1.setString(2,c);
           int count=psmt1.executeUpdate();
//           System.out.println(""+count);
//           Course C=new Course();
//           C.setCid(cid.getText());
//           C.setCname(c);
//           addRow(C);
               readData();
//          Vector V=new Vector();
//           V.add(cid.getText());
           if(count>0)
           {
               System.out.println("Record is Added");
               
           }
           else{
               System.out.println("No Record Found");
           }
       }
       catch(Exception ee)
       {
           
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 try{
     
 
        int columnidx= jTable1.getSelectedColumn();
 
 System.out.println(""+columnidx);
 
       int rowindex=jTable1.getSelectedRow();
       rowidx=rowindex;
       if(columnidx==2)
       {
          DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
           int id=Integer.parseInt(model.getValueAt(rowindex, 0)+"");
           
                System.out.println("ID "+id);   
          
          psmt2.setInt(1,id);
           if(JOptionPane.showConfirmDialog(this,"Surely Want to Edit ?")==JOptionPane.OK_OPTION)
          {
              cid.setText(model.getValueAt(rowindex, 0)+"");
         cname.setText(model.getValueAt(rowindex, 1)+"");
             int count=psmt2.executeUpdate();
            
            System.out.println("Count Is "+count);
           
           readData();
          }
           else{
               
           }
             //int count=psmt2.executeUpdate();
            
           //System.out.println("Count Is "+count);
           
          // readData();
        
           
           
            
           
           
           
       }
       if(columnidx==3)
       {
          DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
           int id=Integer.parseInt(model.getValueAt(rowindex, 0)+"");
           
                System.out.println("ID "+id);   
          
          psmt2.setInt(1,id);
          if(JOptionPane.showConfirmDialog(this,"Surely You Want To Delete ?")==JOptionPane.OK_OPTION)
          {
             int count=psmt2.executeUpdate();
            
            System.out.println("Count Is "+count);
           
           readData();
          }
          else{
              
          }
              
        // addRow(S);
       }
       
       
 }
 catch(Exception ee)
 {
   System.out.println("Exception "+ee);  
 }
              
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        try{
            //DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
        
      int id=cf.getMaxId("select max(cid) from course");
        //int row=model.getRowCount();
        //int id=Integer.parseInt(model.getValueAt(row, 0)+"");
        ++id;
        cid.setText(""+id);
        }
        catch(Exception ee)
        {
            System.out.println("Next Button Error "+ee);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
int rowidx=0;
    public void deleteRow(Course Cr)
  {    int rowindex=jTable1.getSelectedRow();
         DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
         model.removeRow(rowindex);
//lst.remove(Stu);
     
  }
    
    int flag=0;
    public void addRow(Course Cr) throws Exception
           
    {
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        
         if(flag==0)
          {
            if(lst.isEmpty())
           {

           lst.add(Cr);
           
           System.out.println("Hello");
           
         model.addRow(new String[]{Cr.getCid(),Cr.getCname(),"EDIT","DELETE"});
             jTable1.getColumnModel().getColumn(2).setCellRenderer(new EditDesign());
            jTable1.getColumnModel().getColumn(3).setCellRenderer(new EditDesign1());

           }

          else
          {
              
             for(Course C:lst)
              {
                  if(C.getCid()==Cr.getCid())
                  {
                      JOptionPane.showMessageDialog(this,"Course ID Already Present");
                      return;
                  }
                  
              }
               
             // lst.clear();
                     // lst.set(tab.getSelectedRow(),Stu);
                    // lst.remove(Stu); 
                  
                     lst.add(Cr);
                    
                     // lst.clear();
               
                
             //lst.clear();
            // lst.add(Stu);
              
              jTable1.getColumnModel().getColumn(2).setCellRenderer(new EditDesign());
              jTable1.getColumnModel().getColumn(3).setCellRenderer(new EditDesign1());
             model.addRow(new Object[]{Cr.getCid(),Cr.getCname(),"EDIT","DELETE"});
             
              
                   }    
             
          }
    
          else if(flag==1)
          {
               
               System.out.println(""+flag);
              lst.add(rowidx,Cr);
              while(model.getRowCount()>0)
              {
                  model.removeRow(model.getRowCount()-1);
                  
              }
              
              for(Course C1:lst)
              {
               model.addRow(new Object[]{C1.getCid(),C1.getCname(),"EDIT","DELETE"});
              }
               rowidx=0;
          }
                  
          
                  
      }
          
    
    
    
    /**
     * @param args the command line arguments
     */
    ArrayList<Course> lst=new ArrayList<Course>();
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
            java.util.logging.Logger.getLogger(CourseAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cid;
    private javax.swing.JTextField cname;
    private javax.swing.JComboBox<String> cyear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
