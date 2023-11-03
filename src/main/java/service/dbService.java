package service;

import model.todoModel;
import model.userModel;
import repository.dbManager;

import java.util.List;

public class dbService extends dbManager {
    public boolean isTodoListEmpty(List<todoModel> todoList) {
        return todoList == null || todoList.isEmpty();
    }
    public static boolean isAllUserEmpty(List<userModel> todoList) {
        return todoList == null || todoList.isEmpty();
    }

    public List<todoModel> getUserTodo(Integer id) {
        List<todoModel> userTodoList = getTodo(id);
        if (isTodoListEmpty(userTodoList)) {
            return null;
        }
        return userTodoList;
    }

    public static List<userModel> getAllUserService() {
        List<userModel> userAllList = getAllUsers();
        if (isAllUserEmpty(userAllList)){
            return null;
        }
        return userAllList;
    }

    public static List<userModel> getIdServiceService(Integer id) {
        List<userModel> userAllList = getIdUsers(id);
        if (isAllUserEmpty(userAllList)){
            return null;
        }
        return userAllList;
    }

    public static String addAdminService(String nama, String email, String password) {
        if (addAdmin(nama, email, password)) {
            return"berhasil menambahkan admin";
        }
        return"gagal menamabahkan admin";
    }

//    public String registerUserService(String nama, String email, String password) {
//        if (registerUser(nama, email, password)) {
//            return"berhasil menambahkan admin";
//        }
//        return"gagal menambahkan admin";
//    }

    public static boolean registerUserService(String nama, String email, String password) {
        if (registerUser(nama, email, password)) {
            return true;
        }

        return false;
    }

    public static boolean emailAlredyValidation(String email){
//        if(isEmailAlreadyRegistered(email)){
//            return true;
//        }
//        return false;
        return isEmailAlreadyRegistered(email);
    }

    public static boolean authenticateLoginService(String username, String password) {
        if (authenticateLogin(username, password)) {
            return true;
        }
        return false;
    }

    public String statusUserService(Integer id, Boolean status) {
        if (statusUser(id, status)) {
            return"berhasil mengubah status";
        }
        return"gagal mengubah status";
    }

    public String addTodoService(String todo, Integer user_id){
        if(addTodo(todo, user_id)){
            return"berhasil menambahkan todo";
        }
        return"gagal menambahkan todo";
    }

    public String deleteTodoService(Integer user_id){
        if(deleteTodo(user_id)){
            return "berhasil menghapus todo";
        }
        return "gagal menghapus todo";
    }
}
