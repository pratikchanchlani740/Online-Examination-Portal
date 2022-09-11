/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Pack1.CourseDemo1;
import Pack1.EQuestion;
import Pack1.Exam;
import Pack1.ExamQuestion;
import Pack1.Question;
import Pack1.StudentExam;
import Pack1.User;
import Pack1.UserRemote;
import db.CommonFunction;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import static javax.management.Query.eq;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

/**
 *
 * @author Pratik
 */
public class ExamPaper extends javax.swing.JFrame {

    /**
     * Creates new form ExamPaper
     */
    CommonFunction cf=new CommonFunction();
    Connection cnn;
    PreparedStatement psmt1,psmt2;
    public List<CourseDemo1> list1=null;
    public void getCourse(int cid)
   { try{
       UserRemote ur=Demo.getUserRemote();         
list1=ur.courseDetails(cid);
Iterator it1=list1.iterator();
if(it1.hasNext())
{
    CourseDemo1 crs=(CourseDemo1)it1.next();
    cname.setText(crs.getCname());
}
//       ResultSet rs=cf.getResultset("course where cid="+cid);
//       if(rs.next())
//       {
//           System.out.println(rs.getString("cname"));
//          // jComboBox1.setSelectedItem(""+rs.getString("cname"));
//          cname.setText(rs.getString("cname"));
//       }
   }
   catch(Exception ee)
   {
       System.out.println("Course Name Error"+ee);
   }
   }
    ExamQuestion eq;
    public void setExamQuestion(ExamQuestion eq)
    {
        this.eq =eq;
    }
    public ExamQuestion getExamQuestion()
    {
        return this.eq;
    }
    public ExamPaper()
    {
        initComponents();
    }
     List<ExamQuestion> list=null;
    public void showQuestion(ExamQuestion eq)
    {
         qno.setText(""+eq.getQno());
           quesname.setText(eq.getQues());
             op1.setText(eq.getOp1());
             op2.setText(eq.getOp2());
             op3.setText(eq.getOp3());
             op4.setText(eq.getOp4());
             System.out.println("User Ans"+eq.getUserans().length());
             if(eq.getUserans().length()==0)
             {
//                 op1.setSelected(false);
//                 op2.setSelected(false);
//                 op3.setSelected(false);
//                 op4.setSelected(false);
                 System.out.println("Hello World"+eq.getUserans());
                 buttonGroup1.clearSelection();
             }
             else
             {
                 String str=eq.getUserans();
                 System.out.println("String Anser is"+str);
             switch (str) {
                 case "A":
                     op1.setSelected(true);
                     break;
                 case "B":
                     op2.setSelected(true);
                     break;
                 case "C":
                     op3.setSelected(true);
                     break;
                 case "D":
                     op4.setSelected(true);
                     break;
                 default:
                     break;
             }
                 
             }
    }
    public ExamPaper(Demo inform,Vector v) {
        initComponents();
        try{
            User u=inform.getUser();
            sid.setText(""+u.getId());
            
            
           
          // ctx.setBackground(Color.DARK_GRAY);
          Container ctx=getContentPane();
            ctx.setBackground(new Color(255,255,150));
            setTitle("Exam Paper");
Image icon=new ImageIcon(this.getClass().getResource("removebg/online1.png")).getImage();
setIconImage(icon);
            jPanel1.setBackground(new Color(255,255,150));
            jPanel3.setBackground(new Color(255,255,150));
            jPanel4.setBackground(new Color(255,255,150));
            getCourse(u.getCourse());
            name.setText(u.getFirstname()+u.getLastname());
            System.out.println(""+u.getImg());
            byte b[]=u.getImg();
            
           // System.out.println(""+b.length);
            if(b!=null)
            {
 

 
Image im= Toolkit.getDefaultToolkit().createImage(b,0,b.length);

ImageIcon img= new ImageIcon(im);

        

Image im1=img.getImage().getScaledInstance(250, 200, java.awt.Image.SCALE_SMOOTH);

img=new ImageIcon(im1);

 image.setIcon(img);
            }
            else{
                image.setIcon(null);
            }
 System.out.println("Vector is"+v);
        eid.setText(""+v.get(0));
        sname.setText(""+v.get(1));
        totalq.setText(""+v.get(2));
        maxm.setText(""+v.get(4));
        passm.setText(""+v.get(5));
        dur.setText(""+v.get(3));
        date.setText(""+v.get(6));
        
        UserRemote ur=Demo.getUserRemote();
         String subject1=sname.getText();
         int id=Integer.parseInt(eid.getText());
      //System.out.println("Course is "+course);
      list=ur.getExamQuestions(id);
      System.out.println("List  is"+list);
      
      Iterator it= list.iterator();
      if(it.hasNext())
      {  
          ExamQuestion eq=(ExamQuestion)it.next();
          showQuestion(eq);
      }
        int num=Integer.parseInt(totalq.getText());
        System.out.println("Total Questions is"+num);
        //jPanel2.setLayout(new BoxLayout(this,num));
       // jPanel2.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        
        Button btn[];
        btn=new Button[num];
         it= list.iterator();
        for(int i=0;i<num;i++)
        {
            //int j=i+1;
            if(it.hasNext())
            {
                ExamQuestion eq=(ExamQuestion)it.next();
        btn[i]=new Button(""+eq.getQno());
        btn[i].setSize(200,100);
        
            }
        btn[i].addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e)
            {
                Button bb= (Button)e.getSource();
               System.out.println(bb.getLabel());
               int num= Integer.parseInt(bb.getLabel());
               
                Iterator it= list.iterator();
                while(it.hasNext())
                {
                    ExamQuestion eq= (ExamQuestion)it.next();
                    
                    if(eq.getQno()==num)
                    {
                        showQuestion(eq);
                       
                        
                        break;
                    }
                }
               
               // String qnum=btn[i].getLabel();
            }
        });
        
        
        
        
        // btn[i].setSize(100, 100);
        jPanel2.add(btn[i]);
       
       
          String qnum=btn[i].getLabel();
        }
        
         
//          int qnum=eq.getQno();
//          List<Question> list1=ur.QuestionDetails(qnum);
//          Iterator it1= list1.iterator();
//          if(it1.hasNext())
//          {
//              Question q=(Question)it1.next();
//               quesname.setText(q.getQues());
//             op1.setText(q.getOp1());
//             op2.setText(q.getOp2());
//             op3.setText(q.getOp3());
//             op4.setText(q.getOp4());
//          }
          
//      }
          
//      List<Question> list= ur.getQuestions(subject1);
//      Iterator it= list.iterator();
//       if(it.hasNext())
//	{  Question q=(Question)it.next();
//           
//             quesname.setText(q.getQues());
//             op1.setText(q.getOp1());
//             op2.setText(q.getOp2());
//             op3.setText(q.getOp3());
//             op4.setText(q.getOp4());
//             
//        }
        }catch(Exception ee)
        {
            System.out.println("Exception in Exam Paper"+ee);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        cname = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();
        sname = new javax.swing.JTextField();
        maxm = new javax.swing.JTextField();
        passm = new javax.swing.JTextField();
        dur = new javax.swing.JTextField();
        totalq = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        quesname = new javax.swing.JLabel();
        op1 = new javax.swing.JRadioButton();
        op2 = new javax.swing.JRadioButton();
        op3 = new javax.swing.JRadioButton();
        op4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        qno = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Student ID");

        jLabel2.setText("Name");

        jLabel3.setText("Course Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel3)
                        .addGap(77, 77, 77)
                        .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton21.setText("Submit");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Student Details");

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel4.setText("Exam ID");

        jLabel5.setText("Subject Name");

        jLabel7.setText("Total Questions");

        jLabel8.setText("Maxmimum Marks");

        jLabel9.setText("Passing Marks");

        jLabel10.setText("Duration");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(maxm))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38)
                        .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sname)
                    .addComponent(passm, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dur, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalq, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(maxm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        quesname.setText("Question ");

        buttonGroup1.add(op1);
        op1.setText("Option 1");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(op2);
        op2.setText("Option 2");

        buttonGroup1.add(op3);
        op3.setText("Option 3");

        buttonGroup1.add(op4);
        op4.setText("Option 4");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        qno.setText("Qno");

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(op4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(op3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(op2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(op1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(372, 372, 372)
                        .addComponent(jButton1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(qno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quesname, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quesname, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(op1)
                .addGap(18, 18, 18)
                .addComponent(op2)
                .addGap(18, 18, 18)
                .addComponent(op3)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op4)
                    .addComponent(jButton1))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(jButton21))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(53, 53, 53)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton21)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void op1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_op1ActionPerformed
 String ans="";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
      if(JOptionPane.showConfirmDialog(this,"Are you want to Select this question Only?","Select Option",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
      {
            
      Iterator it= list.iterator();
      ExamQuestion eq=null;
      for(int i=0;i<list.size();i++)
      {
           eq= list.get(i);
          int n= Integer.parseInt(qno.getText());
          if(n==eq.getQno())
          {
              if(op1.isSelected())
          {
              ans="A";
          }
          else if(op2.isSelected())
          {
              ans="B";   
          }
          else if(op3.isSelected())
          {
              ans="C";
          }
          else if(op4.isSelected())
          {
              ans="D";
          }
          else{
              ans="";
          }
            eq.setUserans(ans);
            break;
          }
              
              
      }
            
      }
//      else if(JOptionPane.showConfirmDialog(this,"Are you want to Select this question Only?","Select Option",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION){
//      
//      }
      else{
           buttonGroup1.clearSelection();
      }
            
        }catch(Exception ee)
        {
            System.out.println("Ok Button Error"+ee);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
       try{
           cnn=db.MyConnection.getConnection();
           
           StudentExam e= new StudentExam();
           
          
           
           psmt1=cnn.prepareStatement("insert into studentexam values(?,?,?,?,?)");
         psmt2=cnn.prepareStatement("update exam set state='Attempted' where eid=?");
           
          //System.out.println("Exam Question is"+getExamQuestion());
          Iterator it= list.iterator();
         int count=0;
         ExamQuestion eq=null;
         UserRemote ur=null;
          e.setSid(Integer.parseInt(sid.getText()));
           e.setEid(Integer.parseInt(eid.getText()));
           ArrayList<EQuestion> list1=new ArrayList<EQuestion>();
            while(it.hasNext())
          {
              EQuestion t= new EQuestion();
               eq=(ExamQuestion)it.next();
              t.setUserans(eq.getUserans());
              t.setQno(eq.getQno());
              t.setAns(eq.getAns());
              list1.add(t);
             
          } 
            e.setData(list1);
            ur=Demo.getUserRemote();
            System.out.println("Student Exam "+e);
          boolean a=  ur.SubmitExam(e);
          
          if(a==true)
              System.out.println("Your Exam Successfully Submitted....");
          else
              System.out.println("Exam Error...");
          
            
            
           // System.out.println("Count is"+count);
//            if(count>0)
//            {
               // psmt2.setString(1,"Attempted");
               // psmt2.setString(2,eid.getText());
                
               // System.out.println("Exam id is"+eid.getText());
                // ArrayList<Exam> list1=new <Exam>ArrayList();
                //=Demo.getUserRemote();
                
               // Exam exam1=new Exam();
                //exam1.setEid(Integer.parseInt(eid.getText()));
               // exam1.setCname(cname.getText());
                //exam1.setState("Attempted");
                
                //System.out.println("State"+exam1.getState());
                //ur.Exam(exam1);
                //list1.add(exam);
                // list1.add(exam1);
                 //System.out.println("List is"+list1);
                 //int eid1=Integer.parseInt(eid.getText());
                // UserRemote ur=Demo.getUserRemote();
              // boolean list2=ur.Exam(list1);
                // ChangeStatus frm=new ChangeStatus(eid1);
                // frm.setVisible(true);
              //  int eid1=Integer.parseInt(eid.getText());
              //  OnlineExam.Server.ChangeStatus frm=new ChangeStatus(eid1);
              //  frm.setVisible(true);
//                psmt2.setString(1,eid.getText());
//                psmt2.executeUpdate();
//                System.out.println("Record Updated");
               dispose();
//            }
           // eq.setState("Attempted");
//             UserRemote ur=Demo.getUserRemote();
//             String cname=
//            List<Exam> list1=ur.examDetails(ans)
//            int num=Integer.parseInt(totalq.getText());
//            if(count==num)
//            {
//                
//            }
            
           
       }catch(Exception ee)
       {
           System.out.println("Exception in Submit Button "+ee);
       }
    }//GEN-LAST:event_jButton21ActionPerformed

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
            java.util.logging.Logger.getLogger(ExamPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamPaper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cname;
    private javax.swing.JTextField date;
    private javax.swing.JTextField dur;
    private javax.swing.JTextField eid;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField maxm;
    private javax.swing.JTextField name;
    private javax.swing.JRadioButton op1;
    private javax.swing.JRadioButton op2;
    private javax.swing.JRadioButton op3;
    private javax.swing.JRadioButton op4;
    private javax.swing.JTextField passm;
    private javax.swing.JLabel qno;
    private javax.swing.JLabel quesname;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField totalq;
    // End of variables declaration//GEN-END:variables
}
