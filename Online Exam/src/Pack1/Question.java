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
public class Question implements Serializable{
 
    private String sname,ques,op1,op2,op3,op4,ans;
    private int qno;
    private String userans;

    /**
     * @return the sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * @param sname the sname to set
     */
    public void setSname(String sname) {
        this.sname = sname;
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
    
    
    
}
