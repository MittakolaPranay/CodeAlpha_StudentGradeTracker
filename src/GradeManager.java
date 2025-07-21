import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class GradeManager {

    static  List<Student> students = new ArrayList<>();
    public static void main(String[] args) {

       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           String choice;
           int number;

           do {
               System.out.println("---Students grade manager---");
               System.out.println("1 :Add the student");
               System.out.println("2 :Summary of all students");
               System.out.println("3 :Average score");
               System.out.println("4 :Highest score");
               System.out.println("5 :Lowest score ");
               System.out.println("6 :Exit");
               System.out.println("Enter your choice -");
               choice = reader.readLine();
               number = Integer.parseInt(choice);

               switch (number){
                   case 1:
                       addStudent(reader);
                       break;
                   case 2:
                       summaryOfStudents();
                       break;
                   case 3:
                       averageScore();
                       break;
                   case 4:
                       highestScore();
                       break;
                   case 5:
                       lowestScore();
                       break;
                   case 6:
                       System.out.println("Exit....");
                       break;
                   default:
                       System.out.println("Invalid input..");

               }
           }while (number != 6);
       }catch (Exception e){
           System.out.println(e);
       }
    }

    //method for adding the student

    public static void addStudent(BufferedReader reader) {
        try {
            System.out.println("--Adding the student--");
            System.out.println("Enter student name -");
            String name = reader.readLine().trim();
            name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
            System.out.println("Enter student score");
            int score = Integer.parseInt(reader.readLine());
            if(score <= 0) {
                System.out.println("Invalid score");
                return;
            }
            students.add(new Student(name,score));
            System.out.println("task completed...");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //method for display all student in ascending order according to score

    public static void summaryOfStudents(){
      if(students.isEmpty()){
          System.out.println("No student data available");
          return;
      }else {
          Collections.sort(students,(Student s1,Student s2) -> {
              return s1.getScore() - s2.getScore();
          });
          Iterator<Student> iterator = students.iterator();
          while(iterator.hasNext()){
              System.out.println(iterator.next().toString());
          }
      }
    }

    //method for display average of score

    public static void averageScore() {
        if(students.size() == 0){
            System.out.println("No student data available");
            return;
        }else {
            Iterator<Student> iterator = students.iterator();
            int sum = 0;
            while(iterator.hasNext()){
                sum += iterator.next().getScore();
            }
            System.out.println("Average score is :"+sum/students.size());
        }
    }


    //method for display the highest score

    public static void highestScore(){
       if(students.size() == 0){
           System.out.println("No student data available");
           return;
       }else {
           Iterator<Student> iterator = students.iterator();
           int highestScore = 0;

           while(iterator.hasNext()){
               Student student = iterator.next();
               if(highestScore < student.getScore()){
                   highestScore = student.getScore();
               }
           }
           System.out.println("highest score is :"+highestScore);
       }
    }

    //method for display the lowest score

    public static void lowestScore() {
        if(students.size() == 0){
            System.out.println("No student data available");
            return;
        }else {
            Iterator<Student> iterator = students.iterator();
            int LowestScore = students.get(0).getScore();

            while(iterator.hasNext()){
                Student student = iterator.next();
                if(LowestScore > student.getScore()){
                    LowestScore = student.getScore();
                }
            }
            System.out.println("Lowest score is :"+LowestScore);
        }
    }
}