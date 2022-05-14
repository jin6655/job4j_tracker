package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private int programs;

    public Programmer(int y, boolean x, String name, String surname, String education, String birthday) {
        super(x, name, surname, education, birthday);
        this.programs = y;
    }

    public void program(int program) {
        System.out.println(getEducation());
        System.out.println(getName());
        System.out.println("Создано программ: " + program);
    }

    public static void main(String[] args) {
        Programmer programmer = new Programmer(20, false, "Василий", "Шохов", "програмист", "12.05.2005");
        programmer.program(10);
    }

}
