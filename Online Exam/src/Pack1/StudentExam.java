/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack1;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pratik
 */
public class StudentExam implements Serializable{
    
    private int sid,eid;
   
    private List<EQuestion> data;

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
     * @return the data
     */
    public List<EQuestion> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<EQuestion> data) {
        this.data = data;
    }

   
    
}
