/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Pratik
 */
public class OnlineExam {
    
    private int id,year;
    private String fname,lname,course,add,ses;
    private double phone;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return the add
     */
    public String getAdd() {
        return add;
    }

    /**
     * @param add the add to set
     */
    public void setAdd(String add) {
        this.add = add;
    }

    /**
     * @return the ses
     */
    public String getSes() {
        return ses;
    }

    /**
     * @param ses the ses to set
     */
    public void setSes(String ses) {
        this.ses = ses;
    }

    /**
     * @return the phone
     */
    public double getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(double phone) {
        this.phone = phone;
    }
    
    
}
