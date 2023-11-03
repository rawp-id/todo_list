package controller;

import model.todoModel;
import service.dbService;
import util.Validation;
import view.AdminView;
import view.TodoView;
import view.UserView;

import java.util.List;
import java.util.Scanner;

public class todoController {
    public static UserView viewUser = new UserView();
    public static AdminView viewAdmin = new AdminView();
    public static dbService service = new dbService();
    public static TodoView viewTodo = new TodoView();
    public static Validation validation = new Validation();
    public static Scanner scanner = new Scanner(System.in);
    
    public static void displayTodo(Integer id) {
        List<todoModel> todoList = service.getUserTodo(id);
        if (todoList == null) {
            System.out.println("data kosong");
        }
        viewTodo.todo(todoList);
    }
}
