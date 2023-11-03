package controller;

import model.userModel;
import util.Validation;
import view.TodoView;
import view.UserView;
import view.AdminView;
import service.dbService;

import java.util.List;
import java.util.Scanner;

public class userController {
    public static UserView viewUser = new UserView();
    public static AdminView viewAdmin = new AdminView();

    public static dbService service = new dbService();
    public static TodoView viewTodo = new TodoView();
    public static Validation validation = new Validation();
    public static Scanner scanner = new Scanner(System.in);

    public static void menuUser() {
        System.out.println("\n----------To Do List App----------");
        System.out.println(viewUser.menu());
        System.out.print("Pilihan : ");
        String choice = scanner.nextLine();
        try {
            if (validation.msg("Is it already correct? y/n")) {
                int option = Integer.parseInt(choice);
                choiceUser(option);
            } else {
                menuUser();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            menuUser();
        }
    }

    public static void choiceUser(Integer choices) {
        switch (choices) {
            case 1:
                System.out.println("\n---To Do List---");
                todoController.displayTodo((Integer) service.user.getId());
                menuUser();
            case 2:
                System.out.println("\n---Input To Do List---");
                System.out.print("Task : ");
                String task = scanner.nextLine();
                System.out.println(service.addTodoService(task, (Integer) service.user.getId()));
                menuUser();
            case 3:
                System.out.println("\n---Delete To Do List---");
                System.out.println("To Do List : ");
                todoController.displayTodo((Integer) service.user.getId());
                System.out.print("Pilih ID : ");
                int id = scanner.nextInt();
                userController.displayIdUser(id);
                if (validation.msg("Is it already correct? y/n")) {
                    System.out.println(service.deleteTodoService(id));
                }else {
                    choiceUser(3);
                }
                menuUser();
            case 4:
                System.out.println(viewUser.profile((Integer) service.user.getId(), (String) service.user.getName(), (String) service.user.getEmail(), (String) service.user.getPassword()));
                menuUser();
            case 5:
                System.out.println("Logout.......");
                homeController.home();
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                menuUser();
        }
    }

    public static void displayAllUser() {
        List<userModel> userList = service.getAllUserService();
        if (userList == null) {
            System.out.println("data kosong");
        }
        viewUser.AllUsers(userList);
    }

    public static void displayIdUser(Integer id) {
        List<userModel> userList = service.getIdServiceService(id);
        if (userList == null) {
            System.out.println("data kosong");
        }
        viewUser.AllUsers(userList);
    }

    public void detailUserDetail() {
        System.out.println("id :" + service.user.getId());
        System.out.println("nama :" + service.user.getName());
        System.out.println("email :" + service.user.getEmail());
    }

}
