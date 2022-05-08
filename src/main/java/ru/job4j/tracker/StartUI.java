package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI extends Item {

    public static void main(String[] args) {
        Item dateTime = new Item();
        DateTimeFormatter dTM = DateTimeFormatter.ofPattern("dd.MM.u HH:mm:ss EEEE ");
        String dTFormat = dateTime.getCreated().format(dTM);
        System.out.println("Текущие время и дата: " + dTFormat);
    }
}
