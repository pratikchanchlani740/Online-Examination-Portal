/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack1;


import java.rmi.Remote;

import Pack1.UserRemote;
import Pack1.User;

import java.util.*;

/**
 *
 * @author Pratik
 */
public interface UserRemote extends Remote{
    
    public User checkLogin(String user,String pass) throws Exception;
    
    public boolean updateData(String query) throws Exception;
 
    // public List<Exam> examDetails(String course) throws Exception;
   
     public List<Exam> examDetails(String course) throws Exception;
     
     public List<Exam> examDetails1(int eid) throws Exception;
     
     public List<Question> getQuestions(String subject) throws Exception;
     
     public List<ExamQuestion> getExamQuestions(int examid) throws Exception;
     
     public List<Question> QuestionDetails(int qno)throws Exception;
     
    public boolean SubmitExam(StudentExam e) throws Exception;
     
     public boolean Exam(Exam e) throws Exception;
     
      public List<StudentExam1> checkExam(int sid,int eid) throws Exception;
      
      public boolean checkExam1(int sid,int eid) throws Exception;
      
      public List<ExamResult1> getStudentResult(int sid) throws Exception;
      
      public List<ExamResult1> getStudentResult1(String query) throws Exception;
      
      public List<SubjectDemo1> subjectDetails(String course) throws Exception;
      
      public List<CourseDemo1> courseDetails(int course) throws Exception;
     
      public List<FinalResult> getFinalReport(int sid,String course) throws Exception;
    
}
