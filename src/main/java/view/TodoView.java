package view;

import model.todoModel;
import model.userModel;

import java.util.List;

public class TodoView {
//    public void displayTodoDetail(T id, U todo, T user_id) {
//        System.out.println(
//                "todo{" +
//                        "id=" + id +
//                        ", todo=" + todo +
//                        ", use_id=" + user_id +
//                        '}'
//        );
//    }
    public void todo(List<todoModel> todoList) {
        for (todoModel todo : todoList) {
            System.out.println("ID : " + todo.getId());
            System.out.println("Task : " + todo.getTodo() + "\n");
        }
    }
}
