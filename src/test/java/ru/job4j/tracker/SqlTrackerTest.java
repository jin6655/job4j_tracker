package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class SqlTrackerTest {

    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenAddItemAndFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item itemReplace = new Item("Anna");
        tracker.add(item);
        int id = item.getId();
        tracker.replace(id, itemReplace);
        assertThat(tracker.findById(id).getName(), Matchers.is(itemReplace.getName()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item01 = new Item("Anna");
        Item item02 = new Item("Bob");
        List<Item> expected = new ArrayList<>();
        expected.add(item01);
        expected.add(item02);
        tracker.add(item01);
        tracker.add(item02);
        assertThat(tracker.findAll(), Matchers.is(expected));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Anna");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()).getName(), Matchers.is("Anna"));
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()).getName(), Matchers.is(nullValue()));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Anna");
        tracker.add(item);
        List<Item> items = new ArrayList<>();
        items.add(item);
        assertThat(tracker.findByName(item.getName()), is(items));
    }

}