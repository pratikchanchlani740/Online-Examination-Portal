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
public class StudentExam1 implements Serializable{
    
    private int eid,sid;
    private String ans,userans;
    private int qno;

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
     * @return the sid
     */
    public int getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(int sid) {
        this.sid = sid;
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
    
    
}
