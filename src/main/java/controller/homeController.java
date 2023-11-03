package controller;

import service.dbService;
import util.Validation;
import view.AdminView;
import view.TodoView;
import view.UserView;

import java.util.Scanner;

public class homeController {
    public static UserView viewUser = new UserView();
    public static AdminView viewAdmin = new AdminView();
    public static dbService service = new dbService();
    public static TodoView viewTodo = new TodoView();
    public static Validation validation = new Validation();
    public static Scanner scanner = new Scanner(System.in);
    public static void home() {
        System.out.println("\n----------To Do List App----------");
        System.out.println("1. login");
        System.out.println("2. Registrasi");
        System.out.println("3. Exit");
        System.out.print("Pilihan : ");
        String pilih = scanner.nextLine();
        try {
            if (validation.msg("Is it already correct? y/n")) {
                int option = Integer.parseInt(pilih);
                switch (option) {
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                    case 3:
                        System.out.println("Exit.....");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                        home();
                        break;

                }
            } else {
                home();
            }
        } catch (NumberFormatException e) {
            System.out.println("Bukan angka. Tolong input angka.");
            home();
        }
    }
    public static void roleMenu(Integer role) {
        if (role == 1) {
            System.out.println("\nHello " + service.user.getName() + "!");
            adminController.menuAdmin();
        }else if(role==2){
            System.out.println("\nHello " + service.user.getName() + "!");
            userController.menuUser();
        }
    }
    public static void login() {
        System.out.println("\nLOGIN");
        System.out.print("Email : ");
        String user = scanner.nextLine();
        String pass = validation.inputPassword();
        if (service.authenticateLoginService(user, pass)) {
            if (service.user.isStatus()) {
                roleMenu((Integer) service.user.getRole_id());
            }else {
                System.out.println("Akun tidak aktif");
                home();
            }
        } else {
            System.out.println("Gagal Login");
            home();
        }
    }

    public static void register(){
        System.out.println("\nREGISTRASI");
        System.out.print("Nama : ");
        String nama = scanner.nextLine();
        String email = validation.emailValidation();
        String pass = validation.inputPassword();
        if (service.registerUserService(nama,email,pass)){
            System.out.println("Registrasi berhasil");
            home();
        }else {
            System.out.println("Registrasi gagal");
        }
    }
}
