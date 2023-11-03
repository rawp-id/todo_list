package rawp;

import model.todoModel;
import model.userModel;
import repository.dbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class example {
    static Scanner scanner = new Scanner(System.in);

    private static userModel user;
    private static todoModel todo;

    public static boolean addTodo(String todo, Integer user_id) {
        try {
            String sql = "INSERT INTO `todo`(`todo`, `user_id`) VALUES (?,?)";

            PreparedStatement preparedStatement
                    = dbConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, todo);
            preparedStatement.setInt(2, user_id);
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean addAdmin(String nama, String email, String password) {
        try {
            String sql = "INSERT INTO `user`(`name`, `email`, `password`, `status`, `role_id`) VALUES (?,?,?,'1','1')";

            PreparedStatement preparedStatement
                    = dbConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                return true;
            }
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean registerUser(String nama, String email, String password) {
        try {
            String sql = "INSERT INTO `user`(`name`, `email`, `password`, `status`, `role_id`) VALUES (?,?,?,'0','2')";

            PreparedStatement preparedStatement
                    = dbConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                return true;
            }
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean authenticateLogin(String username, String password) {
        try {
            String sql = "SELECT * FROM `user` WHERE email = ? AND password = ?";

            PreparedStatement preparedStatement
                    = dbConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                user = new userModel<Integer, String>(result.getInt("id"), result.getString("name"), result.getString("email"), result.getString("password"), result.getBoolean("status"), result.getInt("role_id"));
                result.close();
                preparedStatement.close();
                dbConnection.getConnection().close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<todoModel> getTodo(Integer id) {
        List<todoModel> todoList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `todo` WHERE user_id = ?";

            PreparedStatement preparedStatement
                    = dbConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                todo = new todoModel<Integer, String>(result.getInt("id"), result.getString("todo"), result.getInt("user_id"));
                todoList.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }

    public static List<todoModel> getAllTodo() {
        return getTodo((Integer) user.getId());
    }

    public static void displayAllUser() {
        List<todoModel> userList = getAllTodo();
        displayAllUsers(userList);
    }

    public static void displayAllUsers(List<todoModel> todoList) {
        for (todoModel todo : todoList) {
            System.out.println("ID: " + todo.getId());
            System.out.println("Username: " + todo.getTodo());
            System.out.println("Email: " + todo.getUser_id());
            System.out.println();
        }
    }
//    public static boolean passwordValidation(String password) {
//        String pass = password;
//        Pattern digitPattern = Pattern.compile("[0-9]");
//        Pattern upperCasePattern = Pattern.compile("[A-Z]");
//        Pattern specialCharPattern = Pattern.compile("[@#$%^&-+=()_]");
//
//        if (pass.length() < 8) {
//            System.out.println("Kurang 8");
//        } else if (pass.length() > 20) {
//            System.out.println("max 20");
//        } else if (!digitPattern.matcher(pass).find()) {
//            System.out.println("Tidak Ada Angka");
//        } else if (!upperCasePattern.matcher(pass).find()) {
//            System.out.println("Tidak Ignorcase");
//        } else if (!specialCharPattern.matcher(pass).find()) {
//            System.out.println("Tidak Ada Karakter");
//        } else {
//            System.out.println("berhasil");
//            return true;
//        }
//        return false;
//    }
//
//    public static String inputPassword() {
//        System.out.print("input Password : ");
//        String pass = scanner.nextLine();
//        if (passwordValidation(pass)) {
//            return pass;
//        }
//        return inputPassword();
//    }
//
//    public static boolean maxTodo(String Todo) {
//        String todo = Todo;
//        if (todo.length() < 50) {
//            System.out.println("Berhasil");
//            return true;
//        }
//        System.out.println("Todo lebih dari 50 huruf");
//        return false;
//    }
//
//    public static String inputMax() {
//        System.out.print("input Todo : ");
//        String todo = scanner.nextLine();
//        if (maxTodo(todo)) {
//            return todo;
//        }
//        return inputMax();
//    }

    public static void main(String[] args) {
//        System.out.println(authenticateLogin("user@user.com", "User@123"));
//        displayAllUser();
//        System.out.println(getTodo((Integer) user.getId()));
//        System.out.println(user.getId());
//        System.out.println(user.getName());
//        System.out.println(user.isStatus());
//        System.out.println(user.getRole_id());
    }
}