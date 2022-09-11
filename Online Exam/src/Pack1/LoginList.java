/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack1;
 
import Pack1.UserRemote;
import Pack1.User;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;

/**
 *
 * @author Pratik
 */
public class LoginList extends UnicastRemoteObject implements UserRemote{
    
    
    public LoginList() throws RemoteException
    {
        super();
    }
    
    @SuppressWarnings("empty-statement")
    public User checkLogin(String user,String pass) 
    {
        try{
			
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/College","root","");
			Connection cnn=db.MyConnection.getConnection();
                        PreparedStatement pstmt=cnn.prepareStatement("select * from student where user='"+user+"' and pass='"+pass+"'");
			ResultSet rst=pstmt.executeQuery();
                        if(rst.next())
                        {
                            User u= new User();
                            u.setId(rst.getInt("ID"));
                            u.setFirstname(rst.getString("First_Name"));
                            u.setLastname(rst.getString("Last_Name"));
                            u.setCourse(rst.getInt("Course"));
                            u.setAddress(rst.getString("Address"));
                            u.setPhone(rst.getString("Phone"));
                            u.setSession(rst.getString("Session"));
                           
                            String image=rst.getString("Image");
                            System.out.println("Image is no there");
                            Vector V=new Vector();
                            //byte ch[]=image.getBytes();
                          //  FileInputStream in =new FileInputStream(image);
                        //   byte ch[]=new byte[in.available()];
                        byte[] data=null;
//                        if(image.endsWith("jpg"))
//                        {
 System.out.println("Image is");
                            if(image.endsWith("jpg"))
                            {
                             BufferedImage bImage = ImageIO.read(new File(image));
                           // System.out.println("Image is no there"+bImage);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                       ImageIO.write(bImage, "jpg", bos );
                        data = bos.toByteArray();
//                             BufferedImage bImage = ImageIO.read(new File("sample.jpg"));
//      ByteArrayOutputStream bos = new ByteArrayOutputStream();
//      ImageIO.write(bImage, "jpg", bos );
//      byte [] data = bos.toByteArray();
                            for(byte bb:data)
                            {
                                V.add(bb);
                                //System.out.println(""+V);
                            }
                           // System.out.println("Data  is"+data);
                            u.setImg(data);
                            }
                            else{
                                data=null;
                                   u.setImg(data);
                            }
                            
                           // u.setPicture(V);
                            u.setImage(rst.getString("Image"));
                            u.setUser(rst.getString("user"));
                            u.setPass(rst.getString("pass"));
                            
                                    
                            return u;
                        }
                        else
                        {
                            return null;
                        }
			
                       
			
			
			
		}
		
		catch(Exception ee)
		{
			System.out.println("LoginList Error"+ee);
		}
		
		return null;
    }
    
    
   
     public boolean updateData(String query)
                        {
                            try{
                                Connection cnn=db.MyConnection.getConnection();
                                 //PreparedStatement pstmt=cnn.prepareStatement(query);
                                 Statement stmt= cnn.createStatement();
		              System.out.println("Query is"+query);
		               int count=stmt.executeUpdate(query);
                                System.out.println("Count is"+count);
			     //  int count=pstmt.executeUpdate();
                              // if(rst.next())
                               if(count>0)
                               {
                                   return true;
                               }
                               else
                               {
                                   return false;
                               }
                            
                               
                                
                                
                                
                            }catch(Exception ee){
                                System.out.println("Update Data Error"+ee);
                        }
                            return false;
}

   public List<Exam> examDetails(String course)
   {
       List<Exam> list=new ArrayList<Exam>();
       try{
           Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from exam where cname='"+course+"' and state='Activate'");
                      // Date d2=new Date();
                        while(rst.next())
                        {
                            Exam e=new Exam();
                            e.setEid(rst.getInt("eid"));
                            e.setCname(rst.getString("cname"));
                            e.setSname(rst.getString("sname"));
                            e.setTotalq(rst.getInt("totalq"));
                            e.setDur(rst.getInt("dur"));
                            e.setMax(rst.getInt("max"));
                            e.setPass(rst.getInt("pass"));
                             e.setDate(rst.getDate("date"));
                             e.setQuetype(rst.getString("quetype"));
                             e.setState(rst.getString("state"));
                            list.add(e);
                            System.out.println(e);
                             
                        }
                        return list;
                        
           
       }catch(Exception ee)
       {
           
           System.out.println("Exam Detail Error"+ee);
           return null;
       }
       
   }
    public List<Exam> examDetails1(int eid)
   {
       List<Exam> list=new ArrayList<Exam>();
       try{
           Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from exam where eid="+eid);
                      // Date d2=new Date();
                        while(rst.next())
                        {
                            Exam e=new Exam();
                            e.setEid(rst.getInt("eid"));
                            e.setCname(rst.getString("cname"));
                            e.setSname(rst.getString("sname"));
                            e.setTotalq(rst.getInt("totalq"));
                            e.setDur(rst.getInt("dur"));
                            e.setMax(rst.getInt("max"));
                            e.setPass(rst.getInt("pass"));
                             e.setDate(rst.getDate("date"));
                             e.setQuetype(rst.getString("quetype"));
                             e.setState(rst.getString("state"));
                            list.add(e);
                            System.out.println(e);
                             
                        }
                        return list;
                        
           
       }catch(Exception ee)
       {
           
           System.out.println("Exam Detail Error"+ee);
           return null;
       }
       
   }
   public List<Question> getQuestions(String Subject)
   {
       List<Question> list1=new ArrayList<Question>();
       try{
           Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from question where sid='"+Subject+"'");
                      // Date d2=new Date();
                        while(rst.next())
                        {
                            Question q=new Question();
                            q.setQno(rst.getInt("qno"));
                           // e.setCname(rst.getString("cname"));
                            q.setSname(rst.getString("sid"));
                            q.setOp1(rst.getString("op1"));
                            q.setOp2(rst.getString("op2"));
                            q.setOp3(rst.getString("op3"));
                            q.setOp4(rst.getString("op4"));
                             q.setQues(rst.getString("ques"));
                             q.setAns(rst.getString("ans"));
                             q.setUserans("");
                            list1.add(q);
                            System.out.println(q);
                             
                        }
                        return list1;
                        
           
       }catch(Exception ee)
       {
           
           System.out.println("Question Detail Error"+ee);
           return null;
       }
       
   }
   
   public List<ExamQuestion> getExamQuestions(int examid)
   {
        List<ExamQuestion> list1=new ArrayList<ExamQuestion>();
        try{
           Connection cnn=db.MyConnection.getConnection();
           Statement pstmt=cnn.createStatement();
           PreparedStatement question= cnn.prepareStatement("select * from question where qno=?");
           
			ResultSet rst=pstmt.executeQuery("select * from examquestion where eid="+examid);
                      // Date d2=new Date();
                        while(rst.next())
                        {
                            ExamQuestion q=new ExamQuestion();
                            int q1=rst.getInt("qno");
                            q.setEid(rst.getInt("eid"));
                            q.setQno(q1);
                            
                           question.setInt(1, q1);
                           
                           ResultSet r= question.executeQuery();
                           
                           if(r.next())
                           {
                               
                               q.setQues(r.getString("ques"));
                               q.setOp1(r.getString("op1"));
                               q.setOp2(r.getString("op2"));
                               q.setOp3(r.getString("op3"));
                               q.setOp4(r.getString("op4"));
                                q.setAns(r.getString("ans"));
                                q.setUserans("");
                                
                           }
                            
                            
                           // e.setCname(rst.getString("cname"));
//                            q.setSname(rst.getString("sid"));
//                            q.setOp1(rst.getString("op1"));
//                            q.setOp2(rst.getString("op2"));
//                            q.setOp3(rst.getString("op3"));
//                            q.setOp4(rst.getString("op4"));
//                             q.setQues(rst.getString("ques"));
//                             q.setAns(rst.getString("ans"));
//                             q.setUserans("");
                            list1.add(q);
                            System.out.println(q);
                             
                        }
                        return list1;
           
        }catch(Exception ee)
        {
            System.out.println("ExamQuestion Detail Error"+ee);
            return null;
        }
       
   }
   public List<Question> QuestionDetails(int qno)
   {
       List<Question> list1=new ArrayList<Question>();
       try{
           Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from question where qno="+qno);
                      // Date d2=new Date();
                        while(rst.next())
                        {
                            Question q=new Question();
                            q.setQno(rst.getInt("qno"));
                           // e.setCname(rst.getString("cname"));
                            q.setSname(rst.getString("sid"));
                            q.setOp1(rst.getString("op1"));
                            q.setOp2(rst.getString("op2"));
                            q.setOp3(rst.getString("op3"));
                            q.setOp4(rst.getString("op4"));
                             q.setQues(rst.getString("ques"));
                             q.setAns(rst.getString("ans"));
                             q.setUserans("");
                            list1.add(q);
                            System.out.println(q);
                             
                        }
                        return list1;
                        
           
       }catch(Exception ee)
       {
           
           System.out.println("Question Detail Error"+ee);
           return null;
       }
   }

    
    public boolean SubmitExam(StudentExam e) throws Exception {
       try{
           System.out.println("Student Exam"+e);
           Connection cnn=db.MyConnection.getConnection();
        PreparedStatement psmt1= cnn.prepareStatement("insert into studentexam value(?,?,?,?,?)");
       int eid=e.getEid();
       int sid=e.getSid();
       System.out.println("Eid is"+eid+"And Subject id"+sid);
       List<EQuestion> lst=e.getData();
       System.out.println("List Data is"+lst);
       Iterator it=lst.iterator();
       while(it.hasNext())
       {
           EQuestion eq=(EQuestion)it.next();
           int qno=eq.getQno();
           String ans=eq.getAns();
           String userans=eq.getUserans();
           psmt1.setInt(1,eid);
           psmt1.setInt(2,sid);
           psmt1.setInt(3,qno);
           psmt1.setString(4, ans);
           psmt1.setString(5,userans);
           int r=psmt1.executeUpdate();
           if(r>0)
           {
               System.out.println("Exam Question Added");
           }
           else{
               System.out.println("Exam Question not Added");
           }
           
       }
       return true;
       }catch(Exception ee)
       {
           System.out.println("Exception is"+ee);
           return false;
       }
        
    }
   
   public boolean Exam(Exam e) throws Exception{
       
      try{
          Connection cnn=db.MyConnection.getConnection();
        PreparedStatement psmt1= cnn.prepareStatement("update exam set state='Attempted' where eid=?");
        
        psmt1.setInt(1,e.getEid());
        int count=psmt1.executeUpdate();
        if(count>0)
        {
            System.out.println("Record Successfully Updated");
            return true;
        }
        else{
            System.out.println("Record Not Updated");
        }
        return false;
      }catch(Exception ee)
      {
          System.out.println("Exception is"+ee);
          return false;
      }
   }
   
    public List<StudentExam1> checkExam(int sid,int eid)
   {
       List<StudentExam1> list1=new ArrayList<StudentExam1>();
       try{
           Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from studentexam where sid="+sid+"and eid="+eid);
                        System.out.println("Result Set is There");
                      // Date d2=new Date();
                        while(rst.next())
                        {
                            //Question q=new Question();
                            StudentExam1 exam=new StudentExam1();
                           exam.setEid(rst.getInt("eid"));
                           exam.setSid(rst.getInt("sid"));
                           exam.setQno(rst.getInt("qno"));
                           exam.setAns(rst.getString("ans"));
                           exam.setUserans(rst.getString("expans"));
                            list1.add(exam);
                            System.out.println(exam);
                             
                        }
                        return list1;
                       
          // return true;
       }catch(Exception ee)
       {
           
           System.out.println("Check Exam Error"+ee);
           return null;
       }
   }
     public boolean checkExam1(int sid,int eid)
   {
       //List<StudentExam1> list1=new ArrayList<StudentExam1>();
       try{
           Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from studentexam where sid="+sid+" and eid="+eid);
                        System.out.println("Result Set is There");
                      // Date d2=new Date();
                     if(rst.next())
                       {
                          return true;
                       }
                     else{
                         return false;
                     }
                     
                      
                       
         // return true;
       }catch(Exception ee)
       {
           
           System.out.println("Check Exam Error"+ee);
           return false;
           
       }
       
   }
     public List<ExamResult1> getStudentResult(int sid)
     {
         List<ExamResult1> list1=new ArrayList<ExamResult1>();
         try{
              Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from studentresult where sid="+sid);
                        System.out.println("Result Set is There");
                      // Date d2=new Date();
                        //while(rst.next())
                        while(rst.next())
                        {
                            //Question q=new Question();
                            ExamResult1 exam=new ExamResult1();
                            exam.setSid(rst.getInt("sid"));
                            exam.setEid(rst.getInt("eid"));
                            exam.setStuname(rst.getString("stu_name"));
                            exam.setCname(rst.getString("cname"));
                            exam.setSname(rst.getString("sname"));
                            exam.setAttques(rst.getInt("attques"));
                            exam.setCorans(rst.getInt("correct"));
                            exam.setObtmarks(rst.getInt("obtmarks"));
                            exam.setResult(rst.getString("result"));
                            exam.setResstate(rst.getString("res_state"));
                           
                            list1.add(exam);
                            System.out.println(exam);
                             
                        }
             
             
             return list1;
         }catch(Exception ee)
         {
             System.out.println("Student Result Error"+ee);
             return null;
         }
     }
      public List<ExamResult1> getStudentResult1(String query)
     {
         List<ExamResult1> list1=new ArrayList<ExamResult1>();
         try{
              Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery(query);
                        System.out.println("Result Set is There");
                      // Date d2=new Date();
                        //while(rst.next())
                        while(rst.next())
                        {
                            //Question q=new Question();
                            ExamResult1 exam=new ExamResult1();
                            exam.setSid(rst.getInt("sid"));
                            exam.setEid(rst.getInt("eid"));
                            exam.setStuname(rst.getString("stu_name"));
                            exam.setCname(rst.getString("cname"));
                            exam.setSname(rst.getString("sname"));
                            exam.setAttques(rst.getInt("attques"));
                            exam.setObtmarks(rst.getInt("obtmarks"));
                            exam.setResult(rst.getString("result"));
                            exam.setResstate(rst.getString("res_state"));
                           
                            list1.add(exam);
                            System.out.println(exam);
                             
                        }
             
             
             return list1;
         }catch(Exception ee)
         {
             System.out.println("Student Result Error"+ee);
             return null;
         }
     
     }
   // @Override
         public List<SubjectDemo1> subjectDetails(String course) 
         {
              List<SubjectDemo1> list1=new ArrayList<SubjectDemo1>();
              try{
                  Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from subject where cid='"+course+"'");
                        System.out.println("Result Set is There");
                        while(rst.next())
                        {
                           SubjectDemo1 sub=new SubjectDemo1();
                           sub.setCname(rst.getString("cid"));
                           sub.setSid(rst.getInt("sid"));
                           sub.setSname(rst.getString("sname"));
                           list1.add(sub);
                           System.out.println(sub);
                        }
                  
                  return list1;
              }catch(Exception ee)
              {
                  System.out.println("Subject Details Exception"+ee);
                  return null;
              }
         }
             public List<CourseDemo1> courseDetails(int course) 
         {
              List<CourseDemo1> list1=new ArrayList<CourseDemo1>();
              try{
                  Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from course where cid="+course);
                        System.out.println("Result Set is There");
                        if(rst.next())
                        {
                           CourseDemo1 sub=new CourseDemo1();
                           
                           sub.setCid(rst.getInt("cid"));
                           sub.setCname(rst.getString("cname"));
                          // sub.setSid(rst.getInt("sid"));
                          // sub.setSname(rst.getString("sname"));
                           list1.add(sub);
                           System.out.println(sub);
                        }
                  
                  return list1;
              }catch(Exception ee)
              {
                  System.out.println("Subject Details Exception"+ee);
                  return null;
              }
         }
             public List<FinalResult> getFinalReport(int sid,String course)
     {
         List<FinalResult> list1=new ArrayList<FinalResult>();
         try{
              Connection cnn=db.MyConnection.getConnection();
                        Statement pstmt=cnn.createStatement();
			ResultSet rst=pstmt.executeQuery("select * from finalresult where sid="+sid+" and cname='"+course+"'");
                        System.out.println("Result Set is There");
                      // Date d2=new Date();
                        //while(rst.next())
                        while(rst.next())
                        {
                            //Question q=new Question();
                            FinalResult fin=new FinalResult();
                            fin.setSid(rst.getInt("sid"));
                            
                            fin.setCname(rst.getString("cname"));
                            
                           fin.setTotalq(rst.getInt("totalq"));
                            fin.setAttempted(rst.getInt("attques"));
                            fin.setNattempted(rst.getInt("nattques"));
                            fin.setCorrect(rst.getInt("corans"));
                            fin.setWrong(rst.getInt("wrgans"));
                            fin.setTotalm(rst.getInt("totalm"));
                            fin.setMaxm(rst.getInt("maxm"));
                            fin.setPer(rst.getInt("per"));
                            fin.setResult(rst.getString("result"));
                           
                            list1.add(fin);
                            System.out.println(fin);
                             
                        }
             
             
             return list1;
         }catch(Exception ee)
         {
             System.out.println("Final Result Error"+ee);
             return null;
         }
     }

    
         
}
