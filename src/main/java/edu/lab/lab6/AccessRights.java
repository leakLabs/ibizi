package edu.lab.lab6;

public class AccessRights {
    boolean read;
    boolean write;
    boolean grant;

    public AccessRights(boolean read, boolean write, boolean grant) {
        this.read = read;
        this.write = write;
        this.grant = grant;
    }

    @Override
    public String toString() {
        return "Чтение: " + (read ? "Да" : "Нет") +
                ", Запись: " + (write ? "Да" : "Нет") +
                ", Передача прав: " + (grant ? "Да" : "Нет");
    }
}
