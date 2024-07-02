package bitcamp.project2;

import bitcamp.project2.Prompt.Prompt;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.w3c.dom.ls.LSOutput;

public class App {

    Scanner scanner = new Scanner(System.in);
    List<Task> tasks = new ArrayList<>();

    public void run() {
        while (true) {
            printMenu();
            int choice = getIntInput("");

            switch (choice) {
                case 1:
                    toDo();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    //기능 넣기
                    break;
                case 4:
                    //기능 넣기
                    break;
                case 5:
                    //기능 넣기
                    break;
                case 0:
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void printMenu() {
        System.out.println("1. 해야할 일");
        System.out.println("2. 목록 조회");
        System.out.println("3. 조회");
        System.out.println("4. 수정");
        System.out.println("5. 삭제");
        System.out.println("0. 종료");
    }

    public int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    public void toDo() {
        scanner.nextLine();
        String list = getStringInput("할 일을 입력하세요: ");
        boolean completed = getBooleanInput("완료했습니까?(y/n): ");
        LocalDate date = getDateInput("날짜를 입력하세요(yyyy-MM-dd 또는 yyyyMMdd): ");
        tasks.add(new Task(list, date, completed));
        System.out.println("할 일을 추가했습니다.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
        } else {
            System.out.println("완료   할 일       날짜");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void consumeNewLine() {
        scanner.nextLine();
    }

    public LocalDate getDateInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String dateString = scanner.nextLine();
            try {
                return Prompt.parseDate(dateString);
            } catch (DateTimeParseException e) {
                System.out.println("올바른 날짜 형식을 입력해주세요 (yyyy-MM-dd 또는 yyyyMMdd).");
            }
        }
    }

    public void closeScanner() {
        scanner.close();
    }

    private boolean getBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다. 'y' 또는 'n'을 입력해주세요.");
            }
        }
    }
}
