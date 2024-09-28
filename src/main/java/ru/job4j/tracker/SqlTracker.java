package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        Item rsl = item;
        try (PreparedStatement statement = cn.prepareStatement("insert into items(name, created) values(?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            Timestamp dateSql = Timestamp.valueOf(item.getCreated());
            statement.setString(1, item.getName());
            statement.setTimestamp(2, dateSql);
            statement.execute();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                item.setId(generatedKey.getInt(1));
            }
            item.setId(statement.getGeneratedKeys().getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (Statement statement = cn.createStatement()) {
            String sql = String.format("update items set name = '%s', created = '%s' where id = %s",
                    item.getName(), item.getCreated().toString(), id
            );
            statement.execute(sql);
            if (statement.getUpdateCount() > 0) {
                rsl = true;
                item.setId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (Statement statement = cn.createStatement()) {
            String sql = String.format("delete from items where id = %s", id);
            if (statement.executeUpdate(sql) > 0) {
                rsl = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    rsl.add(new Item(resultSet.getInt(1), resultSet.getString(2)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    rsl.add(new Item(resultSet.getInt(1), resultSet.getString(2)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = new Item();
        try (PreparedStatement statement = cn.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    rsl.setId(id);
                    rsl.setName(resultSet.getString(2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

}
