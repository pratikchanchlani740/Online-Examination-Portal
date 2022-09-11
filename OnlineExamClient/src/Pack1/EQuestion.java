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
public class EQuestion implements Serializable{
     private int qno;
    private String ans,userans;

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
    
    
}
