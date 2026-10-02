package Todo;
import java.util.ArrayList;
import java.util.Scanner;
 class Todo {
    int id;
    String task;
    
Todo(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public String toString() {
        return id + " - " + task;
    }
}

public class TodoApp {

    static ArrayList<Todo> todos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

   
    static void createTodo() {
        System.out.print("Enter Todo ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Task: ");
        String task = sc.nextLine();

        todos.add(new Todo(id, task));
        System.out.println("Todo Created Successfully!");
    }

   
    static void showTodos() {
        if (todos.isEmpty()) {
            System.out.println("No Todos Available.");
            return;
        }

        System.out.println("\nTodo List:");
        for (Todo todo : todos) {
            System.out.println(todo);
        }
    }

    
    static void updateTodo() {
        System.out.print("Enter Todo ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Todo todo : todos) {
            if (todo.id == id) {
                System.out.print("Enter New Task: ");
                todo.task = sc.nextLine();

                System.out.println("Todo Updated Successfully!");
                return;
            }
        }

        System.out.println("Todo Not Found!");
    }

    
    static void deleteTodo() {
        System.out.println("Enter Todo ID to Delete: ");
        int id = sc.nextInt();

        for (Todo todo : todos) {
            if (todo.id == id) {
                todos.remove(todo);
                System.out.println("Todo Deleted Successfully!");
                return;
            }
        }

        System.out.println("Todo Not Found!");
    }
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== TODO APPLICATION =====");
            System.out.println("1. Create Todo");
            System.out.println("2. Show Todos");
            System.out.println("3. Update Todo");
            System.out.println("4. Delete Todo");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createTodo();
                    break;

                case 2:
                    showTodos();
                    break;

                case 3:
                    updateTodo();
                    break;

                case 4:
                    deleteTodo();
                    break;

                case 5:
                    System.out.println("Application Closed.");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

