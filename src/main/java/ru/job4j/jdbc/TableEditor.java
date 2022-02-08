package ru.job4j.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException, IOException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver"));
        var url = properties.getProperty("url");
        var login = properties.getProperty("login");
        var password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    private void test(String tableName, String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println(getTableScheme(connection, tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        var sql = String.format(
                "create table if not exists %s(id serial primary key);",
                tableName
        );
        test(tableName, sql);
    }

    public void dropTable(String tableName) {
        var sql = String.format(
                "drop table if exists %s cascade;", tableName
        );
    }

    public void addColumn(String tableName, String columnName, String type) {
        var sql = String.format(
                "ALTER TABLE %s ADD %s %s", tableName, columnName, type
        );
        test(tableName, sql);
    }

    public void dropColumn(String tableName, String columnName) {
        var sql = String.format(
                "ALTER TABLE %s drop %s", tableName, columnName
        );
        test(tableName, sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        var sql = String.format(
                "ALTER TABLE %s rename column %s to %s", tableName, columnName, newColumnName
        );
        test(tableName, sql);
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("./src/main/resources/connection_idea-db.txt");
        properties.load(in);
        try {
            TableEditor tableEditor = new TableEditor(properties);
            tableEditor.createTable("demo_table");
            tableEditor.addColumn("demo_table", "name", "text");
            tableEditor.addColumn("demo_table", "lastname", "text");
            tableEditor.renameColumn("demo_table", "name", "firstname");
            tableEditor.dropColumn("demo_table", "lastname");
            tableEditor.dropTable("demo_table");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
