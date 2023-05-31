package student;

public class Student {
    private int id;
    private String studentName;
    private Double score;


    public Student(int id, String studentName, Double score){
        super();
        this.id = id;
        this.studentName = studentName;
        this.score = score;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String productName){
        this.studentName = productName;
    }
    public Double getScore(){
        return score;
    }
    public void setScore(Double score){
        this.score = score;
    }


}
