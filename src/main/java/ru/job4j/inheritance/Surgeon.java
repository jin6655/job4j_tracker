package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private int operated;

    public Surgeon(int y, int x, String name, String surname, String education, String birthday) {
        super(x, name, surname, education, birthday);
        this.operated = y;
    }

    public void operated(int operated) {
        System.out.println(getName());
        System.out.println("Прооперировано: " + operated);
    }

    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon(22, 10, "Виктор", "Власов", "хирург", "10.12.2014");
        surgeon.operated(33);
    }
}
