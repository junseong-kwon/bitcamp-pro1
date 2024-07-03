package bitcamp.project2.command;

import bitcamp.project2.PROCESS;
import bitcamp.project2.Prompt.PrintTodoList;
import bitcamp.project2.vo.Todo;
import bitcamp.project2.vo.TodoList;

import java.util.ArrayList;

public class CompleteTodoCommand {
    TodoList todoList = new TodoList();
    ArrayList<Todo> todoAllList = todoList.getTodoList();
    ArrayList<Todo> todoCompleteList = todoList.setCompleteTodoList();

//    public CompleteTodoCommand(ArrayList<Todo> todoList){
//
//    }

    public void printList(){
        System.out.println("지금까지 완료한 할 일");
        PrintTodoList printTodoList = new PrintTodoList();
        printTodoList.printTodoList(PROCESS.DEFAULT, todoCompleteList);
    }

}
