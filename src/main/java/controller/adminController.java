package controller;

import model.roleModel;
import service.dbService;
import util.Validation;
import view.AdminView;
import view.TodoView;
import view.UserView;

import java.util.Scanner;

public class adminController {
    public static UserView viewUser = new UserView();
    public static AdminView viewAdmin = new AdminView();
    public static dbService service = new dbService();
    public static TodoView viewTodo = new TodoView();
    public static Validation validation = new Validation();
    public static Scanner scanner = new Scanner(System.in);

    public static void menuAdmin() {
        System.out.println("\n----------To Do List App----------");
        System.out.println(viewAdmin.menu());
        System.out.print("Pilihan : ");
        String choice = scanner.nextLine();
        try {
            if (validation.msg("Is it already correct? y/n")) {
                int option = Integer.parseInt(choice);
                choiceAdmin(option);
            } else {
                menuAdmin();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            menuAdmin();
        }
    }

    public static void choiceAdmin(Integer choices) {
        switch (choices) {
            case 1:
                System.out.println("\n---Input Data Admin---");
                System.out.print("Nama : ");
                String nama = scanner.nextLine();
                System.out.print("Email : ");
                String email = scanner.nextLine();
                String password = validation.inputPassword();
                if(validation.msg("Apakah data sudah benar? (y/n)")) {
                    System.out.println(service.addAdminService(nama, email, password));
                }else{
                    choiceAdmin(1);
                }
                menuAdmin();
            case 2:
                System.out.println("\n---Data User---");
                userController.displayAllUser();
                menuAdmin();
            case 3:
                System.out.println("\n---User Status---");
                System.out.println("Data User :");
                userController.displayAllUser();
                System.out.print("Pilih ID : ");
                int id = scanner.nextInt();
                userController.displayIdUser(id);
                System.out.print("Status (true/false) : ");
                boolean status = scanner.nextBoolean();
                if (validation.msg("Apakah data sudah benar? (y/n)")) {
                    System.out.println(service.statusUserService(id, status));
                }else {
                    choiceAdmin(3);
                }
                menuAdmin();
            case 4:
                System.out.println(viewAdmin.profile((Integer) service.user.getId(), (String) service.user.getName(), (String) service.user.getEmail(), (String) service.user.getPassword(), service.user.isStatus(), (Integer) service.user.getRole_id()));
                menuAdmin();
            case 5:
                System.out.println("Logout.......");
                homeController.home();
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                menuAdmin();
        }
    }

    public void detailUserDetailAdmin() {
        System.out.println("id : " + service.user.getId());
        System.out.println("nama : " + service.user.getName());
        System.out.println("email : " + service.user.getEmail());
        System.out.println("password : " + service.user.getPassword());
        System.out.println("status : " + service.user.getPassword());
    }
}
