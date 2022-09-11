/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack1;

import java.io.Serializable;

/**
 *
 * @author Pratik
 */
public class ExamQuestion implements Serializable{
    
    
  private int eid,qno;
  private String ques,op1,op2,op3,op4;
  private String ans,userans;
  private String state;

    /**
     * @return the eid
     */
    public int getEid() {
        return eid;
    }

    /**
     * @param eid the eid to set
     */
    public void setEid(int eid) {
        this.eid = eid;
    }

    /**
     * @return the qno
     */
    public int getQno() {
        return qno;
    }

    /**
     * @param qno the qno to set
     */
    public void setQno(int qno) {
        this.qno = qno;
    }

    /**
     * @return the ques
     */
    public String getQues() {
        return ques;
    }

    /**
     * @param ques the ques to set
     */
    public void setQues(String ques) {
        this.ques = ques;
    }

    /**
     * @return the op1
     */
    public String getOp1() {
        return op1;
    }

    /**
     * @param op1 the op1 to set
     */
    public void setOp1(String op1) {
        this.op1 = op1;
    }

    /**
     * @return the op2
     */
    public String getOp2() {
        return op2;
    }

    /**
     * @param op2 the op2 to set
     */
    public void setOp2(String op2) {
        this.op2 = op2;
    }

    /**
     * @return the op3
     */
    public String getOp3() {
        return op3;
    }

    /**
     * @param op3 the op3 to set
     */
    public void setOp3(String op3) {
        this.op3 = op3;
    }

    /**
     * @return the op4
     */
    public String getOp4() {
        return op4;
    }

    /**
     * @param op4 the op4 to set
     */
    public void setOp4(String op4) {
        this.op4 = op4;
    }

    /**
     * @return the ans
     */
    public String getAns() {
        return ans;
    }

    /**
     * @param ans the ans to set
     */
    public void setAns(String ans) {
        this.ans = ans;
    }

    /**
     * @return the userans
     */
    public String getUserans() {
        return userans;
    }

    /**
     * @param userans the userans to set
     */
    public void setUserans(String userans) {
        this.userans = userans;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
  
    
}
