package bitcamp.project2;

import java.time.LocalDate;

public class Task {

  private String list;
  private LocalDate date;
  private boolean completed;


  public Task(String title, LocalDate date, boolean completed) {
    this.list = title;
    this.date = date;
    this.completed = completed;
  }

  @Override
  public String toString() {
      return (completed ? "\u001B[31m ⬤ \u001B[0m" : " 〇") + "     " + list + "     " + date;
    }
  }
