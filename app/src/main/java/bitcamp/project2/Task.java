package bitcamp.project2;

import java.time.LocalDate;

public class Task {

  private static int seqNo;
  private int no;
  private String list;
  private LocalDate date;
  private boolean completed;

  public Task(String title, LocalDate date, boolean completed) {
    this.no = ++seqNo; // 고유 번호 자동 생성
    this.list = title;
    this.date = date;
    this.completed = completed;
  }

  public int getNo() {
    return no;
  }

  @Override
  public String toString() {
    return String.format("%-4s %-15s %-10s", (completed ? "\u001B[31m⬤\u001B[0m" : "〇"), list, date);
  }
}
