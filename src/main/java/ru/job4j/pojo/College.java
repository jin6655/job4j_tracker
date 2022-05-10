package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setOwner("Vasily Gromov");
        student.setGroup(7);
        student.setDate(new Date());

        System.out.println("ФИО: " + student.getOwner()
                + System.lineSeparator()
                + "Группа № " + student.getGroup()
                + System.lineSeparator()
                + "Дата поступления: " + student.getDate());
    }
}
