package view;

import model.userModel;

import java.util.List;

public class UserView<T, U> {

    public T msg(T msg) {
        return msg;
    }
    public T profile(Integer id, String name, String email, String password) {
        return (T) ("Profile : \n" + "ID : " + id + "\nname : " + name + "\nemail : " + email + "\npassword : " + password);
    }
    public T menu() {
        return (T) "Menu :\n1. List Todo\n2. Add Todo\n3. Delete Todo\n4. Profile\n5. Logout";
    }

    public void AllUsers(List<userModel> userList) {
        for (userModel user : userList) {
            System.out.print("ID : " + user.getId());
            System.out.print(", Nama : " + user.getName());
            System.out.print(", email : " + user.getEmail());
            System.out.print(", status : " + user.isStatus() + "\n");
        }
    }

    public void displayUserDetail(T id, U name, U email, U password, boolean status, T role_id) {
        System.out.println(
                "user{" +
                        "id=" + id +
                        ", name=" + name +
                        ", email=" + email +
                        ", password=" + password +
                        ", status=" + status +
                        ", role_id=" + role_id +
                        '}'
        );
    }
}
