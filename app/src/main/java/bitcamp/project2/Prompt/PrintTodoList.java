package bitcamp.project2.Prompt;

import bitcamp.project2.vo.Todo;

import java.time.LocalDate;
import java.util.ArrayList;

public class PrintTodoList {
    public void printTodoList(ArrayList<Todo> todoList){
        String line2 = "======================================================";
        String ansiRed = "\u001B[31m";
        String ansiEnd = "\u001B[0m";

        System.out.printf("=====================[%s]=====================\n", LocalDate.now());
        if(todoList.isEmpty()){
            System.out.println("할 일이 없습니다.");
            System.out.println("추가해주세요.");
        }else {
            for (Todo todayTodo : todoList) {
                System.out.print("|");
                System.out.printf("%3d | ", todayTodo.getNo());
                System.out.printf("%s", todayTodo.isComplete() ? String.format("%s⬤%s | ", ansiRed,ansiEnd) : "⬤ | ");
                printSort(todayTodo.getTitle());
            }
        }
        System.out.println(line2);
    }

    // 한글 영어 구분
    private void printSort(String title){
        final int TITLE_MAX = 20;
        int eng = 0;
        System.out.print(title);
        for(char titleChar : title.toCharArray()){
            if(isKorean(titleChar)){
                continue;
            }else {
                eng++;
            }
        }
        for(int i = 0; i < TITLE_MAX - title.length(); i++){
            System.out.print("  ");
        }
        for(int i = 0; i < eng; i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
    }

    private boolean isKorean(char titleChar){
        return titleChar >= 0xAC00 && titleChar <= 0xD7A3;
    }
}
