package bitcamp.project2.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class TodoListCommand {
    private final ArrayList<Todo> todoList = new ArrayList<>();
//    private final

    public void testData() {
        Todo todo = new Todo();
        todo.setNo(Todo.getSeqNo());
        todo.setStartDate(LocalDate.parse("2024-11-12"));
        todo.setEndDate(LocalDate.parse("2024-11-12"));
        todo.setTitle("테스트");
        todoList.add(todo);

        Todo todo1 = new Todo();
        todo1.setNo(Todo.getSeqNo());
        todo1.setStartDate(LocalDate.parse("2024-07-03"));
        todo.setEndDate(LocalDate.parse("2024-11-12"));
        todo1.setTitle("과거");
        todoList.add(todo1);

        Todo todo2 = new Todo();
        todo2.setNo(11);
        todo2.setStartDate(LocalDate.parse("2024-07-02"));
        todo.setEndDate(LocalDate.parse("2024-11-12"));
        todo2.setTitle("오늘입니다");
        todo2.setComplete(true);
        todoList.add(todo2);
    }

    public TodoListCommand(){
        testData();
    }

    // 할 일 리스트 중 오늘 할 일 분류
    public ArrayList<Todo> setTodayTodoList() {
        ArrayList<Todo> todayList = new ArrayList<>();

        for (Todo todo : todoList) {
            if (todo.getStartDate().equals(LocalDate.now())) {
                todayList.add(todo);
            }
        }
        return todayList;
    }

    public ArrayList<Todo> setCompleteTodoList(){
        ArrayList<Todo> completeList = new ArrayList<>();
        for(Todo todo : todoList){
            if(todo.isComplete()){
                completeList.add(todo);
            }
        }
        return completeList;
    }

    // 고른 할 일이 있는지 여부 확인
    public Todo nullTodo(int number, ArrayList<Todo> todoList) {
        for (Todo todo : todoList) {
            if (todo.getNo() == number) {
                return todo;
            }
        }
        return null;
    }

    public ArrayList<Todo> getTodoList() {
        return todoList;
    }

}
