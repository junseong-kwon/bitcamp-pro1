package bitcamp.project2.command;

import bitcamp.project2.Prompt.Prompt;
import bitcamp.project2.vo.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodayTodoCommand {
    ArrayList<Todo> todoList = new ArrayList<Todo>();
    ArrayList<Todo> todayTodoList = new ArrayList<Todo>();
    String[] menus = {"오늘 할 일 보기","할 일 수정", "할 일 삭제", "할 일 완료"};

    //    public TodayTodoCommand(ArrayList<Todo> todoList){
//        this.todoList = todoList;
//    }
    public void testData() {
        Todo todo = new Todo();
        todo.setNo(Todo.getSeqNo());
        todo.setDate(LocalDate.parse("2024-11-12"));
        todo.setTitle("테스트");
        todoList.add(todo);

        Todo todo1 = new Todo();
        todo1.setNo(Todo.getSeqNo());
        todo1.setDate(LocalDate.parse("2024-11-15"));
        todo1.setTitle("과거");
        todoList.add(todo1);

        Todo todo2 = new Todo();
        todo2.setNo(Todo.getSeqNo());
        todo2.setDate(LocalDate.parse("2024-07-02"));
        todo2.setTitle("오늘입니다");
        todoList.add(todo2);
    }

    private void setTodayTodoList() {
        for (Todo todo : todoList) {
            if (todo.getDate().equals(LocalDate.now())) {
                todayTodoList.add(todo);
            }
        }
    }

    private void todoListPrint() {
        System.out.printf("[%s]\n", LocalDate.now());
        System.out.println("번호 내용");
        for (Todo todayTodo : todayTodoList) {
            System.out.printf("%d. %s\n", todayTodo.getNo(), todayTodo.getTitle());
        }
    }

    private void printTodayTodoMenus(){
        int menuNo = 1;
        System.out.println("[오늘 할 일]");
        for(String menu : menus){
            System.out.printf("%d. %s\n", menuNo++, menu);
        }
    }

    public void executeToday() {
        setTodayTodoList();
        printTodayTodoMenus();
        int number;
        String input;
        while (true) {
            input = Prompt.input("메뉴 번호 입력 >");
            if (input.equals("9")) {
                break;
            }else if(input.equalsIgnoreCase("menu")){
                printTodayTodoMenus();
            }else if(input.equals("1")){
                todoListPrint();
            }
            try {
                number = Integer.parseInt(input);
                if (number < 0 || number > menus.length) {
                    System.out.println("올바른 메뉴 번호를 입력해주세요.");
                } else {
                    String menu = menus[number - 1];
                    switch (menu) {
                        case "할 일 수정":
                            todayListUpdate();
                            break;
                        case "할 일 삭제":
                            todayListDelete();
                            break;
                        case "할 일 완료":
                            todayComplete();
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("메뉴는 숫자로 입력해주세요.");
            }
        }
    }

    private void todayListUpdate() {
        String input;
        int number;
        while (true) {
            input = Prompt.input("수정 할 일 번호 >");
            try {
                number = Integer.parseInt(input);
                if (number < 0) {
                    System.out.println("없는 번호입니다.");
                    break;
                }
                Todo updateTodo = nullTodo(number);
                if (updateTodo == null) {
                    System.out.println("없는 할 일입니다.");
                    break;
                }
                updateTodo.setDate(Prompt.inputDate("수정할 날짜를 입력해주세요.(ex 20240101)"));
                updateTodo.setTitle(Prompt.input("수정할 타이틀을 입력해주세요."));
                isComplete(updateTodo);
                break;
            } catch (NumberFormatException e) {
                System.out.println("번호로 입력해주세요.");
            }
        }
    }

    private void todayListDelete() {
        String input;
        int number;
        while (true) {
            input = Prompt.input("삭제하길 원하는 할 일 번호를 입력해주세요.");
            try {
                number = Integer.parseInt(input);
                if (number < 0) {
                    System.out.println("없는 번호입니다.");
                    break;
                }
                Todo deleteTodo = nullTodo(number);
                if (deleteTodo == null) {
                    System.out.println("없는 할 일입니다.");
                    break;
                }
                for(int i = 0; i < todayTodoList.size(); i++){
                    if(todayTodoList.get(i).equals(deleteTodo)){
                        todayTodoList.remove(i);
                    }
                    if(todoList.get(i).equals(deleteTodo)){
                        todoList.remove(i);
                    }
                }
                System.out.println("삭제했습니다");
                break;
            } catch (NumberFormatException e) {
                System.out.println("번호로 입력해주세요.");
            }
        }
    }

    private void todayComplete(){
        String input;
        int number;
        while (true) {
            input = Prompt.input("완료한 할 일 번호를 입력해주세요.");
            try {
                number = Integer.parseInt(input);
                if (number < 0) {
                    System.out.println("없는 번호입니다.");
                    break;
                }
                Todo updateTodo = nullTodo(number);
                if (updateTodo == null) {
                    System.out.println("없는 할 일입니다.");
                    break;
                }
                isComplete(updateTodo);
                break;
            } catch (NumberFormatException e) {
                System.out.println("번호로 입력해주세요.");
            }
        }
    }

    private void isComplete(Todo todo){
        while (true) {
            String complete = Prompt.input("완료 여부를 입력해주세요.");
            if (complete.equalsIgnoreCase("y")) {
                todo.setComplete(true);
                break;
            } else if (complete.equalsIgnoreCase("n")) {
                todo.setComplete(false);
                break;
            } else {
                System.out.println("y 나 n만 입력해주세요.");
            }
        }
    }

    private Todo nullTodo(int number) {
        for (Todo todo : todayTodoList) {
            if (todo.getNo() == number) {
                return todo;
            }
        }
        return null;
    }
}
