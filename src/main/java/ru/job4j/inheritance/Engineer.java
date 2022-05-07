package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean qualification;

    public Engineer(boolean x, String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
        this.qualification = x;
    }

    public void qualification(boolean qualification) {
        System.out.println(getName());
        System.out.println("Нужная квалификация: " + qualification);
    }

    public static void main(String[] args) {
        Engineer engineer = new Engineer(false, "Семён", "Шохов", "инженер", "12.05.2005");
        engineer.qualification(false);
    }

}
