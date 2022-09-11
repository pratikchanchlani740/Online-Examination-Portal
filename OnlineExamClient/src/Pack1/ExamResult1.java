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
public class ExamResult1 implements Serializable{
    
    private int sid,eid,totalq,attques,obtmarks;
    private String stuname,cname,sname,result,resstate;
    private int corans;
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
     * @return the totalq
     */
    public int getTotalq() {
        return totalq;
    }

    /**
     * @param totalq the totalq to set
     */
    public void setTotalq(int totalq) {
        this.totalq = totalq;
    }

    /**
     * @return the attques
     */
    public int getAttques() {
        return attques;
    }

    /**
     * @param attques the attques to set
     */
    public void setAttques(int attques) {
        this.attques = attques;
    }

    /**
     * @return the obtmarks
     */
    public int getObtmarks() {
        return obtmarks;
    }

    /**
     * @param obtmarks the obtmarks to set
     */
    public void setObtmarks(int obtmarks) {
        this.obtmarks = obtmarks;
    }

    /**
     * @return the stuname
     */
    public String getStuname() {
        return stuname;
    }

    /**
     * @param stuname the stuname to set
     */
    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    /**
     * @return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

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
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the resstate
     */
    public String getResstate() {
        return resstate;
    }

    /**
     * @param resstate the resstate to set
     */
    public void setResstate(String resstate) {
        this.resstate = resstate;
    }

    /**
     * @return the corans
     */
    public int getCorans() {
        return corans;
    }

    /**
     * @param corans the corans to set
     */
    public void setCorans(int corans) {
        this.corans = corans;
    }
    
}
