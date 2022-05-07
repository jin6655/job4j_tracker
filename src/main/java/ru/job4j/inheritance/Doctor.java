package ru.job4j.inheritance;

public class Doctor extends Profession {

    private int cured;

    public Doctor(int x, String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
        this.cured = x;
    }

    public void cured(int cured) {
        System.out.println(getName());
        System.out.println("Излечено пациентов: " + cured);
    }

    public static void main(String[] args) {
        Doctor doctor = new Doctor(10, "Артём", "Шохов", "доктор", "12.05.2005");
        doctor.cured(55);
    }

}
