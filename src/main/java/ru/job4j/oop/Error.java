package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println();
        System.out.print("Ошибка: " + active + " ");
        System.out.println("Код: " + status);
        System.out.print(message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error01 = new Error();
        Error error02 = new Error(true, 404, "перейти на ручное управление");
        error01.printError();
        error02.printError();
    }

}
