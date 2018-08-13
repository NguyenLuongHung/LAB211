// J1.L.P0021

public class Student {
    private String id;
    private String name;
    private int semester;
    private String course;
    
    Student(String id, String name, int semester, String course){
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }
    
    void setId(String id){
        this.id = id;
    }
    void setName (String name){
        this.name = name;
    }
    void setSemester (int semester){
        this.semester = semester;
    }
    void setCourse (String course){
        this.course = course;
    }
    
    String getId(){
        return this.id;
    }
    String getName(){
        return this.name;
    }
    int getSemester(){
        return this.semester;
    }
    String getCourse(){
        return this.course;
    }
    
    void display(){
        System.out.println(name);
    }
}
