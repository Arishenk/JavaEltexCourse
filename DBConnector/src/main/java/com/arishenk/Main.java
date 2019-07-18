package com.arishenk;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/USERS";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, "arishenk", "qwerty123"); //соединение с БД
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO DEVELOPERS(fio, phone) VALUE ('katya', '666');"); // добавление/удаление/изменение записей
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DEVELOPERS;"); // получение записей
            while (resultSet.next()){ // проход по полученным записям
                String fio = resultSet.getString("fio"); // получение значений полей
                System.out.println(fio);
            }
            connection.close(); // отключение от БД
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
