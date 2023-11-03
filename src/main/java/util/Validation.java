package util;

import service.dbService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
    public static Scanner scanner = new Scanner(System.in);
    public static dbService service;

    public static boolean passwordValidation(String password) {
        String pass = password;
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern specialCharPattern = Pattern.compile("[@#$%^&*_+=()-]");

        if (pass.length() < 8) {
            System.out.println("Kurang 8");
        } else if (pass.length() > 20) {
            System.out.println("max 20");
        } else if (!digitPattern.matcher(pass).find()) {
            System.out.println("Tidak Ada Angka");
        } else if (!upperCasePattern.matcher(pass).find()) {
            System.out.println("Tidak Ignorcase");
        } else if (!specialCharPattern.matcher(pass).find()) {
            System.out.println("Tidak Ada Karakter (@#$%^&*_+=()-)");
        } else {
            return true;
        }
        return false;
    }

    public static String emailValidation(){
        System.out.print("Email : ");
        String email = scanner.nextLine();
        if (service.emailAlredyValidation(email)) {
            System.out.println("Email ada yang sama");
            return emailValidation();
        }
        return email;
    }
    public static boolean maxTodo(String Todo) {
        String todo = Todo;
        if (todo.length() < 50) {
            System.out.println("Berhasil");
            return true;
        }
        System.out.println("Todo lebih dari 50 huruf");
        return false;
    }

    public static boolean msg(String message) {
        System.out.print(message + " ");
        String validation = scanner.nextLine();
        return validation.equalsIgnoreCase("y");
    }

    public static String inputPassword() {
        System.out.print("Password : ");
        String pass = scanner.nextLine();
        if (passwordValidation(pass)) {
            return pass;
        }
        return inputPassword();
    }

    public static String inputMax() {
        System.out.print("input Todo : ");
        String todo = scanner.nextLine();
        if (maxTodo(todo)) {
            return todo;
        }
        return inputMax();
    }
}
