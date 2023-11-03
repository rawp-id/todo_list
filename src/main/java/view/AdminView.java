package view;

import model.todoModel;
import model.userModel;

import java.util.List;

public class AdminView<T> {

    public T msg(T msg) {
        return msg;
    }

    public T helloMsg(T name) {
        return (T) ("Hello " + name + "!");
    }

    public T menu() {
        return (T) "Menu :\n1. Add New Admin\n2. Data User\n3. User Status\n4. Profile\n5. Logout";
    }

    public T profile(Integer id, String name, String email, String password, boolean status, Integer role_id) {
        return (T) ("Profile : \n" + "ID : " + id + "\nname : " + name + "\nemail : " + email + "\npassword : " + password + "\nstatus : " + status + "\nrole_id : " + role_id);
    }

    public void AllUsers(List<userModel> userList) {
        for (userModel user : userList) {
            System.out.print("ID : " + user.getId());
            System.out.print(", Nama : " + user.getName());
            System.out.print(", email : " + user.getEmail());
            System.out.print(", status : " + user.isStatus() + "\n");
        }
    }
}
