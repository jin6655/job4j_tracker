package ru.job4j.test01;

import ru.job4j.map.Subject;
import ru.job4j.oop.Cat;
import ru.job4j.stream.Pupil;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.StubOutput;

import java.math.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Caty {

 private int x;
 private int y;
 private String str;

    public Caty(int x, String str) {
        this.x = x;
        this.str = str;
    }

    @Override
    public String toString() {
        return "{" + "x = " + x + ", "
                + "y = " + y + ", "
                + "str = " + str + "}";
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/tracker";
        String login = "postgres";
        String password = "tRonheart32";
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

}
