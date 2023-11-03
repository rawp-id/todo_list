package model;

public class todoModel<T, U> {
    private T id;
    private U todo;
    private T user_id;

    public todoModel(T id, U todo, T user_id) {
        this.id = id;
        this.todo = todo;
        this.user_id = user_id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public U getTodo() {
        return todo;
    }

    public void setTodo(U todo) {
        this.todo = todo;
    }

    public T getUser_id() {
        return user_id;
    }

    public void setUser_id(T user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "id=" + getId() + ", todo=" + getTodo() + ", user_id=" + getUser_id() + "\n";
    }
}