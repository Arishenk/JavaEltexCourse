package com.arishenk;

import lombok.Cleanup;
import lombok.SneakyThrows;

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

    @SneakyThrows({SQLException.class, IOException.class})
    public DUMP()  {
        FileInputStream fis;
        Properties property = new Properties();

        fis = new FileInputStream("src/main/resources/config.properties");
        property.load(fis);
        host = property.getProperty("db.host");
        login = property.getProperty("db.login");
        password = property.getProperty("db.password");

        Connection connection = DriverManager.getConnection(host, login, password);

        Statement statement = connection.createStatement();

        statement.execute("DROP TABLE IF EXISTS DEVELOPERS;");
        statement.execute("CREATE TABLE DEVELOPERS(id INTEGER(11) AUTO_INCREMENT, fio VARCHAR(50), phone VARCHAR(12), " +
                "email VARCHAR(20), languages VARCHAR(50), PRIMARY KEY(id));");

        statement.execute("DROP TABLE IF EXISTS MANAGERS;");
        statement.execute("CREATE TABLE MANAGERS(id INTEGER(11) AUTO_INCREMENT, fio VARCHAR(50), phone VARCHAR(12), " +
                "email VARCHAR(20), sales VARCHAR(50), PRIMARY KEY(id));");

        connection.close();
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

    @SneakyThrows({IOException.class, SQLException.class})
    private static void ReadDevelopers() throws TypeException {

        @Cleanup FileReader fr = new FileReader("developers.csv");
        @Cleanup Scanner inFile = new Scanner(fr);

        System.out.println("developers: \n");

        Connection connection = DriverManager.getConnection(host, login, password);
        Statement statement = connection.createStatement();

        while (inFile.hasNextLine()){
            Developer developer = new Developer();
            developer.fromCSV(inFile.nextLine());
            System.out.print(developer.getFio() + " " + developer.getEmail() + " " + developer.getPhone()
                    + " " + developer.languagesToString() + "\n\n");

            statement.executeUpdate("INSERT INTO DEVELOPERS(fio, phone, email, languages) VALUE ('"+ developer.getFio() + "', '"
                    + developer.getPhone() + "', '" + developer.getEmail() + "', '" + developer.languagesToString() + "');");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DEVELOPERS;");

            while (resultSet.next()) {
                String fio = resultSet.getString("fio");
                System.out.println(fio);
            }
        }
        connection.close();
    }
    @SneakyThrows({IOException.class, SQLException.class})
    public static void ReadManagers() throws TypeException {

        @Cleanup FileReader fr = new FileReader("managers.csv");
        @Cleanup Scanner inFile = new Scanner(fr);
        System.out.println("managers: \n");

        Connection connection = DriverManager.getConnection(host, login, password); //соединение с БД
        Statement statement = connection.createStatement();

        while (inFile.hasNextLine()) {
            Manager manager = new Manager();
            manager.fromCSV(inFile.nextLine());

            System.out.print(manager.getFio() + " " + manager.getEmail() + " " + manager.getPhone()
                    + " " + manager.getSales() + "\n");

            statement.executeUpdate("INSERT INTO MANAGERS(fio, phone, email, sales) VALUE ('"+ manager.getFio() + "', '"
                    + manager.getPhone() + "', '" + manager.getEmail() + "', '" + manager.getSales() + "');");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DEVELOPERS;");

            while (resultSet.next()) {
                String fio = resultSet.getString("fio");
                System.out.println(fio);
            }
        }

        connection.close();
    }

    @SneakyThrows(SQLException.class)
    public static void writeUnion() {
            Connection connection = DriverManager.getConnection(host, login, password);
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
    }
}
