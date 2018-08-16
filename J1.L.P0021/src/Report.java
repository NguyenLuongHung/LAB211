/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Report {
    String name;
    String course;
    int total;
    
    public Report(String name, String course, int total){
        this.name = name;
        this.course = course;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getTotal() {
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
