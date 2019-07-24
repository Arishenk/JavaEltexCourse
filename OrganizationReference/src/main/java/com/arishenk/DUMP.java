package com.arishenk;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public final class DUMP {

    private static String host;
    private static String login;
    private static String password;

    public DUMP() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            this.host = property.getProperty("db.host");
            this.login = property.getProperty("db.login");
            this.password = property.getProperty("db.password");

            System.out.println("HOST: " + host
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        try {
            Connection connection = DriverManager.getConnection(host, login, password);
            Statement statement = connection.createStatement();

            statement.execute("DROP TABLE IF EXISTS DEVELOPERS;");
            statement.execute("CREATE TABLE DEVELOPERS(id INTEGER(11) AUTO_INCREMENT, fio VARCHAR(50), phone VARCHAR(12), " +
                    "email VARCHAR(20), languages VARCHAR(50), PRIMARY KEY(id));");

            statement.execute("DROP TABLE IF EXISTS MANAGERS;");
            statement.execute("CREATE TABLE MANAGERS(id INTEGER(11) AUTO_INCREMENT, fio VARCHAR(50), phone VARCHAR(12), " +
                    "email VARCHAR(20), sales VARCHAR(50), PRIMARY KEY(id));");

            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void toDB(String fileName) throws TypeException {
        if (fileName.equals("managers.csv")) {
            ReadManagers();
        }
        else
        {
            ReadDevelopers();
        }
    }

    static void ReadDevelopers() throws TypeException {
        try {
            FileReader fr = new FileReader("developers.csv");

            Scanner inFile = new Scanner(fr);

            System.out.println("developers: \n");

            try {
                Connection connection = DriverManager.getConnection(host, login, password);
                Statement statement = connection.createStatement();

            while (inFile.hasNextLine()){
                Developer developer = new Developer();

                developer.fromCSV(inFile.nextLine());

                System.out.print(developer.getFio() + " " + developer.getEmail() + " " + developer.getPhone()
                        + " " + developer.languagesToString() + "\n\n");

                statement.executeUpdate("INSERT INTO DEVELOPERS(fio, phone, email, languages) VALUE ('"+ developer.getFio() + "', '"
                        + developer.getPhone() + "', '" + developer.getEmail() + "', '" + developer.languagesToString() + "');"); // добавление/удаление/изменение записей
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

    public static void ReadManagers() throws TypeException {
        try {
            FileReader fr = new FileReader("managers.csv");

            Scanner inFile = new Scanner(fr);

            System.out.println("managers: \n");

                try {
                    Connection connection = DriverManager.getConnection(host, login, password); //соединение с БД
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

    public static void writeUnion() {
        try {
            Connection connection = DriverManager.getConnection(host, login, password); //соединение с БД
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id, fio,phone, email FROM DEVELOPERS UNION SELECT id, fio, phone, email FROM MANAGERS;");

            while (resultSet.next()) {
                String fio = resultSet.getString("fio");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                User user = new User(fio, phone, email);
                System.out.println(user.toString());
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
