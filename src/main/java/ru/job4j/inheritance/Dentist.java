package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int torn;

    public Dentist(int y, int x, String name, String surname, String education, String birthday) {
        super(x, name, surname, education, birthday);
        this.torn = y;
    }

    public void torn(int torn) {
        System.out.println(getName());
        System.out.println("Вырвано зубов: " + torn);
    }

    public static void main(String[] args) {
        Dentist dentist = new Dentist(22, 10, "Павел", "Власов", "дантист", "10.12.2014");
        dentist.torn(10);
    }

}
