package com.arishenk;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public final class DUMP {
    public static void toDB(String fileName) throws TypeException {
        if (fileName.equals("managers.csv")) {
            ReadManagers();
        }
    }

    public static void ReadManagers() throws TypeException {
        try {
            FileReader fr = new FileReader("managers.csv");

            Scanner inFile = new Scanner(fr);

            System.out.println("managers: \n");

                final String DB_URL = "jdbc:mysql://127.0.0.1:3306/USERS";
                try {
                    Connection connection = DriverManager.getConnection(DB_URL, "arishenk", "qwerty123"); //соединение с БД
                    Statement statement = connection.createStatement();

                    while (inFile.hasNextLine()) {
                        Manager manager = new Manager();
                        manager.fromCSV(inFile.nextLine());

                        System.out.print(manager.getFio() + " " + manager.getEmail() + " " + manager.getPhone()
                                + " " + manager.getSales() + "\n");

                        statement.executeUpdate("INSERT INTO MANAGERS(fio, phone, email, sales) VALUE ('"+ manager.getFio() + "', '"
                                + manager.getPhone() + "', '" + manager.getEmail() + "', '" + manager.getSales() + "');"); // добавление/удаление/изменение записей
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM DEVELOPERS;"); // получение записей

                        while (resultSet.next()) { // проход по полученным записям
                            String fio = resultSet.getString("fio"); // получение значений полей
                            System.out.println(fio);
                        }
                    }
                    connection.close(); // отключение от БД
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

            fr.close();
        } catch (IOException error) {
            System.err.println(error.getMessage());
        }
    }
}
