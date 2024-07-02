package bitcamp.project2.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class TodoList {
    private final ArrayList<Todo> todoList = new ArrayList<>();
    private final ArrayList<Todo> todayList = new ArrayList<>();
//    private final ArrayList<Todo> completeList = new ArrayList<>();

    public void testData() {
        Todo todo = new Todo();
        todo.setNo(Todo.getSeqNo());
        todo.setDate(LocalDate.parse("2024-11-12"));
        todo.setTitle("테스트");
        todoList.add(todo);

        Todo todo1 = new Todo();
        todo1.setNo(Todo.getSeqNo());
        todo1.setDate(LocalDate.parse("2024-07-02"));
        todo1.setTitle("과거");
        todoList.add(todo1);

        Todo todo2 = new Todo();
        todo2.setNo(11);
        todo2.setDate(LocalDate.parse("2024-07-02"));
        todo2.setTitle("오늘입니다");
        todo2.setComplete(true);
        todoList.add(todo2);
    }

    public TodoList(){
        testData();
    }

    // 할 일 리스트 중 오늘 할 일 분류
    public ArrayList<Todo> setTodayTodoList() {
        if(!todayList.isEmpty()){
            todayList.clear();
        }

        for (Todo todo : todoList) {
            if (todo.getDate().equals(LocalDate.now())) {
                todayList.add(todo);
            }
        }
        return todayList;
    }

//    public ArrayList<Todo> setCompleteTodoList(){
//        if(!completeList.isEmpty()){
//            completeList.clear();
//        }
//
//        for(Todo todo : todoList){
//            if(todo.isComplete()){
//                completeList.add(todo);
//            }
//        }
//        return completeList;
//    }

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

    public ArrayList<Todo> getTodayList() {
        return todayList;
    }

//    public ArrayList<Todo> getCompleteList() {
//        return completeList;
//    }
}
