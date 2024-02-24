package student;

public class FullTimeStudent extends AbstractStudent {
  private int examScore1;
  private int examScore2;

  public FullTimeStudent(String name) {
    super(name);
    this.examScore1 = (int) Math.round(Math.random() * 100);
    this.examScore2 = (int) Math.round(Math.random() * 100);
  }

  public int getExamScore(int examNumber) {
    if (examNumber == 1) {
      return this.examScore1;
    } else if (examNumber == 2) {
      return this.examScore2;
    } else {
      return 0;
    }
  }
}
