import java.util.ArrayList;
import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int lessonBalance;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.lessonBalance = 0; // изначально уроков 0
        this.grades = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getLessonBalance() { return lessonBalance; }
    public ArrayList<Integer> getGrades() { return grades; }

    public void buyLessons(int amount) {
        this.lessonBalance += amount;
    }

    public void conductLesson() {
        if (this.lessonBalance > 0) {
            this.lessonBalance--;
        }
    }

    public void addGrade(int grade) {
        this.grades.add(grade);
    }
}
