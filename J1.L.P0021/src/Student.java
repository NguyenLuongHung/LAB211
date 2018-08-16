/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Student {
    String id;
    String name;
    String semester;
    String course;
    
    Student(String id, String name, String semester, String course){
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
