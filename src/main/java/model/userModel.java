package model;

public class userModel<T, U> {
    private T id;
    private U name;
    private U email;
    private U password;
    private boolean status;
    private T role_id;

    public userModel(T id, U name, U email, U password, boolean status, T role_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role_id = role_id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public U getName() {
        return name;
    }

    public void setName(U name) {
        this.name = name;
    }

    public U getEmail() {
        return email;
    }

    public void setEmail(U email) {
        this.email = email;
    }

    public U getPassword() {
        return password;
    }

    public void setPassword(U password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getRole_id() {
        return role_id;
    }

    public void setRole_id(T role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", email=" + getEmail() +
                ", password=" + getPassword() +
                ", status=" + isStatus() +
                ", role_id=" + getRole_id() +
                '}';
    }
}
