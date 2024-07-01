package bitcamp.project2.vo;

import java.time.LocalDate;

public class Todo {
    private static int seqNo;
    private int no;
    private String title;
    private LocalDate date;
    private boolean complete;

    public static int getSeqNo() {
        return seqNo++;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
