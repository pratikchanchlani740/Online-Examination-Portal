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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Pratik
 */
public class QuestionForm extends javax.swing.JFrame {
    
    int flag=0;
    public ResultSet rs;
    PreparedStatement psmt1,psmt2,psmt3;
    CommonFunction cf=new CommonFunction();
    String ans="";
     public void readData() throws Exception
    {  
        
       ResultSet rs=cf.getResultset("course");
    
        while(rs.next())
        {
        //sid.addItem(rs.getString(3));
        cid.addItem(rs.getString(2));
        }
    }
     public void readData1(int no) throws Exception
     {
          ResultSet rs=cf.getResultset("question inner join subject where question.sid=subject.sname AND qno="+no);
          if(rs.next())
          {
              cid.setSelectedItem(rs.getString("cid"));
              sid.setSelectedItem(rs.getString("sid"));
              qno.setText(""+rs.getInt("qno"));
              ques.setText("");
              op1.setText("");
              op2.setText("");
              op3.setText("");
              op4.setText("");
          }
     }

    /**
     * Creates new form QuestionForm
     */
    
   // QuestionList frm;
    
   public QuestionForm(int id)
   {
       initComponents();
       System.out.println(""+id);
       //System.out.println(""+cid1);
       try{
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
              setTitle("Add Questions");
Image icon=new ImageIcon(this.getClass().getResource("removebg/megaExam.jpg")).getImage();
setIconImage(icon);
            readData();
           Connection cnn=db.MyConnection.getConnection();
            psmt2=cnn.prepareStatement("update question set sid=?, ques=?, op1=?, op2=?, op3=?, op4=?, ans=? where qno= ?");
           ResultSet rs=cf.getResultset("question inner join subject where question.sid=subject.sname AND question.qno="+id);
            
           if(rs.next())
           {    
               flag=1;
         System.out.println("Flag is"+rs.getString("qno"));
         
         String sid1,qn,ques1,o1,o2,o3,o4,ans1,cid2;
        cid2=rs.getString("cid");
         sid1=rs.getString("sid");
         
         qn=rs.getString("qno");
         ques1=rs.getString("ques");
         o1=rs.getString("op1");
         o2=rs.getString("op2");
         o3=rs.getString("op3");
         o4=rs.getString("op4");
         ans1=rs.getString("ans");
       //  ResultSet rst=cf.getResultset("subject where sname=")
         System.out.println(sid1);
               //System.out.println(""+rs.getString("sid"));
              // cid.setSelectedItem(rs.getString("cid")); 
             cid.setSelectedItem(cid2);
               sid.setSelectedItem(sid1);
              qno.setText(qn);
                 ques.setText(ques1);
          op1.setText(o1);
        op2.setText(o2);
           op3.setText(o3);
        op4.setText(o4);
        
                switch (ans1) {
                    case "A":
                        jRadioButton1.setSelected(true);
                        break;
                    case "B":
                        jRadioButton2.setSelected(true);
                        break;
                    case "C":
                        jRadioButton3.setSelected(true);
                        break;
                //           ResultSet rst= cf.getResultset("subject inner join question where question.sid=subject.sname and question.sid='"+rs.getString("sid")+"'");
                //             rst.next();
//                   System.out.println("Hello"+rst.getString("cid"));
//                cid.setSelectedItem(rst.getString("cid"));
//                rst.close();
//               
                    case "D":
                        jRadioButton4.setSelected(true);
                        break;
                    default:
                        break;
                }
                
                
                jButton1.setText("Edit");
                nextbtn.setEnabled(false);
               // psmt2.setString(1,sid1);
               // psmt2.setString
                //int count=psmt2.executeUpdate();
                //System.out.println("Question No"+rs.getString(2));
//               if(count>0)
//               {
//                   System.out.println("Question is Edited");
//                   
//               }
//               else{
//                   System.out.println("Question is not Edited");
//               }
            
        
         
           
         
           }
           else{
//               int qno1=cf.getMaxId("select max(qno) from question");
//                qno1++;
//                System.out.println("Question No"+qno1);
//                qno.setText(""+qno1);
           }
       
       }catch(Exception ee)
       {
           System.out.println("Exception in QuesForm Constructor : "+ee);
       }
   }
    public QuestionForm() {
        initComponents();
       try{
           Container ctx=getContentPane();
            ctx.setBackground(new Color(150,255,255));
            //this.frm=frm;
            qno.setEditable(false);
            Connection cnn=db.MyConnection.getConnection();
            psmt1=cnn.prepareStatement("insert into question values(?,?,?,?,?,?,?,?)");
            psmt2=cnn.prepareStatement("update question set sid=?, ques=?, op1=?, op2=?, op3=?, op4=?, ans=? where qno= ?");
            psmt3=cnn.prepareStatement("delete from question where qno=?");
            readData();
             rs=cf.getResultset("question");
             QueList.setEnabled(false);
            // frm.rs=rs;
             //rs=getResult();
             setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             
          if(rs.next())
           {   
//               int qno1=1;
////                System.out.println("Hello");
////               if(rs.getInt("qno")!=qno1)
////               {
////                   
              int qno1=cf.getMaxId("select max(qno) from question");
                 // System.out.println("Equal");
                ++qno1;
//                
//               // System.out.println("Question No"+qno1);
                qno.setText(""+qno1);
//               }
//               else{
//                 //  rs.first();
//                  qno.setText("1");
//  }
// int qno1=1;
//while(rs.next())
//{
//   
//    if(rs.getInt("qno")!=qno1)
//    {
//        qno.setText(""+qno1);
//       // ++qno1;
//        
//        
//    }
//    else{
//      ++qno1;  
//    }
    
//    else{
//        rs.next();
//    }
}
//               String sid1=sid.getSelectedItem().toString();
//               System.out.println("Item Seletedted"+sid1);
//               System.out.println("Result Set"+rs.getString(1));
//              if(rs.getString(1).equals(sid1))
//              {
////           System.out.println(""+rs.getString(1));
//               rs.last();
//             System.out.println(""+rs.getString(2));
//          int qno1=(rs.getInt(2));
//          
//               ++qno1;
//              
//               qno.setText(""+qno1);
//              }
//               //System.out.println(qno.getText());
//               System.out.println("Flag is"+flag);
//       }
           else
           {
              
               qno.setText("1");
           }
             setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            
        }catch(Exception ee)
        {
            System.out.println("Exception in Question Form"+ee);
            
        } 
    }
  public ResultSet getResult()throws Exception
    {
        Connection cnn=db.MyConnection.getConnection();
        
        
        Statement smt=cnn.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
        
        return smt.executeQuery("select * from question inner join subject where question.sid=subject.sname");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        sid = new javax.swing.JComboBox<>();
        ques = new javax.swing.JTextField();
        op1 = new javax.swing.JTextField();
        op2 = new javax.swing.JTextField();
        op4 = new javax.swing.JTextField();
        op3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        qno = new javax.swing.JTextField();
        cid = new javax.swing.JComboBox<>();
        nextbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        QueList = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sidItemStateChanged(evt);
            }
        });
        sid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Options");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Enter the Question");

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Enter Question No.");

        cid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cidItemStateChanged(evt);
            }
        });
        cid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidActionPerformed(evt);
            }
        });

        nextbtn.setText("NEXT");
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("ANSWER IS");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("A");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("B");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("C");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("D");

        QueList.setText("Question List");
        QueList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueListActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Course Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Subject Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ques, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(op1)
                                        .addComponent(op3))
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(op2)
                                        .addComponent(op4, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(126, 126, 126)
                                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(48, 48, 48)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(47, 47, 47)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(52, 52, 52)
                                            .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(49, 49, 49)
                                            .addComponent(QueList)
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45)
                                .addComponent(qno, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(cid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sid, 0, 151, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(qno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(ques, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(op2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(op4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(nextbtn)
                    .addComponent(QueList))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{ 
          if(jButton1.getText().equalsIgnoreCase("Add"))
          {
           psmt1.setString(1,sid.getSelectedItem().toString());
            System.out.println("Item"+sid.getSelectedItem().toString());
            
            
           psmt1.setInt(2,Integer.parseInt(qno.getText()));
           psmt1.setString(3,ques.getText());
           psmt1.setString(4,op1.getText());
           psmt1.setString(5,op2.getText());
           psmt1.setString(6,op3.getText());
           psmt1.setString(7,op4.getText());
           if(jRadioButton1.isSelected())
              // ans=op1.getText();
               ans="A";
           else if(jRadioButton2.isSelected())
               //ans=op2.getText();
               ans="B";
            else if(jRadioButton3.isSelected())
               //ans=op3.getText();
                ans="C";
            else if(jRadioButton4.isSelected())
               ans="D";
           else
                JOptionPane.showMessageDialog(this,"Choose the Answer");
           psmt1.setString(8,ans);
           System.out.println("hello");
          
           int count=psmt1.executeUpdate();
           System.out.println("Count is"+count);
          }
          else{
              QueList.setEnabled(true);
             qno.setEditable(false);
              System.out.println("Hello"+flag);
           System.out.println("SID"+sid.getSelectedItem().toString());
         psmt2.setString(1,sid.getSelectedItem().toString());
         System.out.println("Ques"+ques.getText());
           psmt2.setString(2,ques.getText());
           System.out.println("Ques"+op1.getText());
            psmt2.setString(3,op1.getText());
          
           psmt2.setString(4,op2.getText());
           psmt2.setString(5,op3.getText());
           psmt2.setString(6,op4.getText());
           String ans="";
            if(jRadioButton1.isSelected())
              // ans=op1.getText();
               ans="A";
           else if(jRadioButton2.isSelected())
               //ans=op2.getText();
               ans="B";
            else if(jRadioButton3.isSelected())
               //ans=op3.getText();
                ans="C";
            else if(jRadioButton4.isSelected())
               ans="D";
           else
                JOptionPane.showMessageDialog(this,"Choose the Answer");
          
            psmt2.setString(7,ans);
           
          //psmt2.setString(7,ans);
           psmt2.setString(8,qno.getText());
           System.out.println("hello");
           // QuestionList frm=new QuestionList();
          // String query=psmt2.toString();
          // System.out.println(query+"Query ");
          // frm.readData1(query);
           int count=psmt2.executeUpdate();
           System.out.println("Count is"+count);
          // dispose();
          QuestionList frm=new QuestionList();
          frm.setVisible(true);
          dispose();
          
          }
          
        
    }catch(Exception ee)
    {
        System.out.println("Exception is "+ee);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        sid.setSelectedIndex(-1);
        qno.setText("");
        ques.setText("");
        op1.setText("");
        op2.setText("");
        op3.setText("");
        op4.setText("");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cidItemStateChanged
       try{
        if(cid.getSelectedIndex()!=-1)
        {
           String cid1= (String)cid.getSelectedItem();
           
           ResultSet rst= cf.getResultset("subject where cid='"+cid1+"'");
           
           sid.removeAllItems();
           while(rst.next())
           {
               sid.addItem(rst.getString(3));
           }
           
           
        }
        
       }catch(Exception ee)
       {
           System.out.println("Exception : "+ee);
       }
    }//GEN-LAST:event_cidItemStateChanged

    private void sidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sidItemStateChanged
        try{
            if(sid.getSelectedIndex()==-1)
            {              
                return;
            }
            else
            {
            String sid1=sid.getSelectedItem().toString();
            rs=cf.getResultset("question");
            if(rs.next())
            {            
                        
//                if(rs.getString(1).equals(sid1))
//                {  
                  int qno1=cf.getMaxId("select max(qno) from question");
                  System.out.println("Equal");
                ++qno1;
                
                System.out.println("Question No"+qno1);
                qno.setText(""+qno1);
//               }  
                
//                    int qno1=1;
//     while(rs.next())
//{
//   
//    if(rs.getInt("qno")!=qno1)
//    {
//        qno.setText(""+qno1);
//       // ++qno1;
//        
//        
//    }
//    else{
//      ++qno1;  
//    } 
//}
//               int qno1=1;
//                System.out.println("Hello");
//                 if(rs.getInt("qno")!=qno1)
//               {
                   
              
//               else{
//                   qno.setText("1");
//               }
//                int qno1=cf.getMaxId("select max(qno) from question");
//                qno1++;
//                qno.setText(""+qno1);
                }
//            else{
//                int id1=Integer.parseInt(qno.getText());
//                id1=++id1;
//                qno.setText(""+id1);
//            }
//            }
//            
            
            }
        }catch(Exception ee)
        {
            System.out.println("Exception is"+ee);
        }
    }//GEN-LAST:event_sidItemStateChanged

    private void cidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidActionPerformed

    private void sidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sidActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        int id1=Integer.parseInt(qno.getText());
                id1=++id1;
                qno.setText(""+id1);
            try{
               // readData1(id1);
               ques.setText("");
              op1.setText("");
              op2.setText("");
              op3.setText("");
              op4.setText("");
              buttonGroup1.clearSelection();
            }catch(Exception ee)
            {
                System.out.println("Next Button Exception "+ee);
            }
    }//GEN-LAST:event_nextbtnActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void QueListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueListActionPerformed
       QuestionList frm=new QuestionList();
       frm.setVisible(true);
    }//GEN-LAST:event_QueListActionPerformed

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
            java.util.logging.Logger.getLogger(QuestionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton QueList;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> cid;
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton nextbtn;
    public javax.swing.JTextField op1;
    public javax.swing.JTextField op2;
    public javax.swing.JTextField op3;
    public javax.swing.JTextField op4;
    public javax.swing.JTextField qno;
    public javax.swing.JTextField ques;
    public javax.swing.JComboBox<String> sid;
    // End of variables declaration//GEN-END:variables
}
