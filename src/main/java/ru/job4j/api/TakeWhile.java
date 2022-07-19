package ru.job4j.api;

import  java.util.List;
import java.util.stream.Stream;

public class TakeWhile {

    public static void main(String[] args) {
        //Stream.takeWhile - этот метод позволяет получать поток данных до тех пор, пока условие истина.
        List.of(1, 2, 3, 4).stream()
                .takeWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
        //Stream.dropWhile - этот метод позволяет получать поток данных после того, как условие стало ложным
        System.out.println();
        List.of(1, 2, 3, 4).stream()
                .dropWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
        //Stream.ofNullable - сделает из элемента поток, если элемент равен null, то элемент пропускается.
        System.out.println();
        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }

}
