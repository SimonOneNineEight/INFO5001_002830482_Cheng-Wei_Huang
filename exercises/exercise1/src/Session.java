import java.util.ArrayList;
import java.util.Arrays;
import student.AbstractStudent;
import student.FullTimeStudent;
import student.PartTimeStudent;

public class Session {
  private ArrayList<AbstractStudent> students;

  public Session(int classSize) {
    this.students = new ArrayList<>();
    for (int i = 0; i < classSize; i ++) {
      String studentName = "student" + String.valueOf(i);
      AbstractStudent student = Math.random() > 0.5 ? new FullTimeStudent(studentName) : new PartTimeStudent(studentName);
      this.students.add(student);
    }
  }

  public void printPartTimeStudents() {
    System.out.println("Part-time student list:");
    for (AbstractStudent student: this.students) {
      if (student instanceof PartTimeStudent) {
        System.out.println(student.getName());
      }
    }
  }
  public void printAscendingQuizScore() {
    System.out.println("Ascending Quiz Score for every student: ");
    for (AbstractStudent student: this.students) {
      System.out.println(student.getName() + ": " + Arrays.toString(student.getAscendingQuizScores()));
    }
  }

  public void printExamScoresOfFullTimeStudent() {
    System.out.println("Exam Scores of Full-time Student:");
    for (AbstractStudent student: this.students) {
      if (student instanceof FullTimeStudent) {
        System.out.println(student.getName() + ",Exam 1: " + ((FullTimeStudent) student).getExamScore(1) + ", Exam 2: " + ((FullTimeStudent) student).getExamScore(2));
      }
    }
  }
}
