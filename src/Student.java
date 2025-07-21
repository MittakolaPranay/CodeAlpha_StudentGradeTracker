import java.util.Comparator;

public class Student implements Comparator<Student> {
    private String name;
    private int score;

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student name : "+this.name+" , grade : "+this.score;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}
