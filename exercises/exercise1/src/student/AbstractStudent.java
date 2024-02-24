package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public abstract class AbstractStudent {
  private String name;
  private int[] quizzesScores;

  public AbstractStudent(String name) {
    this.name = name;

    this.quizzesScores = new int[15];
    for (int i = 0; i < 15; i++) {
      this.quizzesScores[i] = (int) Math.round(Math.random() * 100);
    }
  }

  public String getName() {
    return this.name;
  }

  public int[] getQuizScores() {
    return this.quizzesScores;
  }

  public int getAverageQuizScore() {
    int total = 0;

    for (int score: this.quizzesScores) {
      total += score;
    }

    return total / this.quizzesScores.length;
  }

  public int[] getAscendingQuizScores() {
    int[] sortedScores = this.quizzesScores.clone();
    Arrays.sort(sortedScores);
    return sortedScores;
  }

}
