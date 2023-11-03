package model;

public class roleModel<T,U> {
    private T id;
    private U nama;

    public roleModel(T id, U nama) {
        this.id = id;
        this.nama = nama;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public U getNama() {
        return nama;
    }

    public void setNama(U nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "roleModel{" +
                "id=" + getId() +
                ", nama=" + getNama() +
                '}';
    }
}
