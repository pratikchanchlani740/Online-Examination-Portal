/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.Date;

/**
 *
 * @author Pratik
 */
public class Paper {
    private int eid;
    private String cname;
    private String sname;
    private int totalq,dur,max,pass;
    private Date d;
    private String time;
    
    private String type,date;

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
     * @return the dur
     */
    public int getDur() {
        return dur;
    }

    /**
     * @param dur the dur to set
     */
    public void setDur(int dur) {
        this.dur = dur;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the pass
     */
    public int getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(int pass) {
        this.pass = pass;
    }

    /**
     * @return the d
     */
    public Date getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(Date d) {
        this.d = d;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
    
}
