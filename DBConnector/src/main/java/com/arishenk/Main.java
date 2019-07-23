package com.arishenk;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/USERS";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, "arishenk", "qwerty123"); //соединение с БД
            Statement statement = connection.createStatement();

            long startTime = System.nanoTime();

            for (int i = 0; i < 1000; i++) {
                statement.executeUpdate("INSERT INTO EXAMPLE(letter) VALUE ('" + i + "');"); // добавление/удаление/изменение записей
            }

            long estimatedTime = System.nanoTime() - startTime;
            System.out.println("Time without transaction: " + estimatedTime + " ns");

            connection.close(); // отключение от БД
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(DB_URL, "arishenk", "qwerty123"); //соединение с БД
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            long startTime = System.nanoTime();

            for (int i = 0; i < 1000; i++) {
                statement.executeUpdate("INSERT INTO EXAMPLE(letter) VALUE ('" + i + "');"); // добавление/удаление/изменение записей
            }

            long estimatedTime = System.nanoTime() - startTime;
            System.out.println("Time with transaction: " + estimatedTime + " ns");

            connection.commit();
            connection.close(); // отключение от БД
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
