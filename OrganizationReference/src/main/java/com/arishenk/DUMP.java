package com.arishenk;

import com.arishenk.entity.Developer;
import com.arishenk.entity.Manager;
import com.arishenk.entity.Sale;
import com.arishenk.entity.User;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
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
                "email VARCHAR(20), PRIMARY KEY(id));");

        statement.execute("DROP TABLE IF EXISTS MANAGERS;");
        statement.execute("CREATE TABLE MANAGERS(id INTEGER(11) AUTO_INCREMENT, fio VARCHAR(50), phone VARCHAR(12), " +
                "email VARCHAR(20), sales VARCHAR(50), PRIMARY KEY(id));");

        statement.execute("DROP TABLE IF EXISTS LANGUAGES;");
        statement.execute("CREATE TABLE LANGUAGES(id INTEGER(11) AUTO_INCREMENT, language VARCHAR(12), PRIMARY KEY(id));");

        statement.execute("DROP TABLE IF EXISTS USERSLANGUAGES;");
        statement.execute("CREATE TABLE USERSLANGUAGES(id INTEGER(11) AUTO_INCREMENT, id_user INTEGER(11), id_language INTEGER(11), PRIMARY KEY(id));");

        statement.execute("DROP TABLE IF EXISTS SALES;");
        statement.execute("CREATE TABLE SALES(id INTEGER(11) AUTO_INCREMENT, cost VARCHAR(12), PRIMARY KEY(id));");

        statement.execute("DROP TABLE IF EXISTS SALEITEMS;");
        statement.execute("CREATE TABLE SALEITEMS(id INTEGER(11) AUTO_INCREMENT, id_sale INTEGER(11), item VARCHAR(12), PRIMARY KEY(id));");

        statement.execute("DROP TABLE IF EXISTS USERSALES;");
        statement.execute("CREATE TABLE USERSALES(id INTEGER(11) AUTO_INCREMENT, id_user INTEGER(11), id_sale INTEGER(11), PRIMARY KEY(id));");

        connection.close();
    }

    @SneakyThrows(SQLException.class)
    public static void fillLanguages(LinkedList<Developer> developers) {
        Connection connection = DriverManager.getConnection(host, login, password);

        Statement statement = connection.createStatement();

        for (Developer developer : developers) {

            String[] languages = developer.getLanguages();

            for (String language : languages) {
                ResultSet resultSet = statement.executeQuery("SELECT id FROM LANGUAGES WHERE language LIKE '%" + language + "%';");
                if (!resultSet.next()) {
                    statement.executeUpdate("INSERT INTO LANGUAGES(language) VALUE ('" + language + "');");
                }
            }
        }

        connection.close();
    }

    @SneakyThrows(SQLException.class)
    public static void fillSales(LinkedList<Manager> managers) throws TypeException {
        Connection connection = DriverManager.getConnection(host, login, password);

        Statement statement = connection.createStatement();

        for (Manager manager : managers) {

            Sale[] sales = manager.getSales();

            for (Sale sale : sales) {
                ResultSet resultSet = statement.executeQuery("SELECT id FROM SALES WHERE cost LIKE '%" + sale.getCost() + "%';");
                if (!resultSet.next()) {
                    statement.executeUpdate("INSERT INTO SALES(cost) VALUE ('" + sale.getCost()+ "');");
                }
            }
        }

        connection.close();
    }

    @SneakyThrows(SQLException.class)
    public static void fillSaleItems(LinkedList<Manager> managers) throws TypeException {
        Connection connection = DriverManager.getConnection(host, login, password);

        Statement statement = connection.createStatement();

        for (Manager manager : managers) {

            Sale[] sales = manager.getSales();

            for (Sale sale : sales) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM SALES WHERE cost LIKE '%" + sale.getCost() + "%';");
                if (resultSet.next()) {
                    String id = resultSet.getString("id");
                    for (String item : sale.getItems()) {
                        statement.executeUpdate("INSERT INTO SALEITEMS(id_sale, item) VALUE ('" + id + "','" + item + "');");
                    }
                }
            }
        }
            connection.close();
    }

    @SneakyThrows(SQLException.class)
    public static void fillUsersSales(LinkedList<Manager> managers) throws TypeException {
        Connection connection = DriverManager.getConnection(host, login, password);

        Statement statement = connection.createStatement();

        for (Manager manager : managers) {

            Sale[] sales = manager.getSales();

            for (Sale sale : sales) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM SALES WHERE cost LIKE '%" + sale.getCost() + "%';");
                if (resultSet.next()) {
                    String id = resultSet.getString("id");
                    for (String item : sale.getItems()) {
                        statement.executeUpdate("INSERT INTO USERSALES(id_user, id_sale) VALUE ('" + manager.getId() + "','" + id + "');");
                    }
                }
            }
        }
        connection.close();
    }

    @SneakyThrows(SQLException.class)
    public static void fillUsersLanguages(LinkedList<Developer> developers) throws TypeException {
        Connection connection = DriverManager.getConnection(host, login, password);

        Statement statement = connection.createStatement();

        for (Developer developer : developers) {

            String[] languages = developer.getLanguages();

            for (String language : languages) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM LANGUAGES WHERE language LIKE '%" + language + "%';");
                if (resultSet.next()) {
                    String id = resultSet.getString("id");
                    statement.executeUpdate("INSERT INTO USERSLANGUAGES(id_user, id_language) VALUE (" + developer.getId() + "," +id +");");
                }
            }
        }

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
    private static LinkedList<Developer> ReadDevelopers() throws TypeException {

        LinkedList<Developer> developers = new LinkedList<>();
        @Cleanup FileReader fr = new FileReader("developers.csv");
        @Cleanup Scanner inFile = new Scanner(fr);

        System.out.println("developers: \n");

        Connection connection = DriverManager.getConnection(host, login, password);
        Statement statement = connection.createStatement();

        while (inFile.hasNextLine()){
            Developer developer = new Developer();
            developer.fromCSV(inFile.nextLine());

            developers.add(developer);

            System.out.print(developer.getFio() + " " + developer.getEmail() + " " + developer.getPhone()
                    + " " + developer.languagesToString() + "\n\n");

            statement.executeUpdate("INSERT INTO DEVELOPERS(fio, phone, email) VALUE ('"+ developer.getFio() + "', '"
                    + developer.getPhone() + "', '" + developer.getEmail() + "');");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM DEVELOPERS;");

            while (resultSet.next()) {
                String fio = resultSet.getString("fio");
                System.out.println(fio);
            }
        }
        connection.close();
        fillLanguages(developers);
        fillUsersLanguages(developers);
        return developers;
    }

    @SneakyThrows({IOException.class, SQLException.class})
    public static LinkedList<Manager> ReadManagers() throws TypeException {
        LinkedList<Manager> managers = new LinkedList<>();
        @Cleanup FileReader fr = new FileReader("managers.csv");
        @Cleanup Scanner inFile = new Scanner(fr);
        System.out.println("managers: \n");

        Connection connection = DriverManager.getConnection(host, login, password); //соединение с БД
        Statement statement = connection.createStatement();

        while (inFile.hasNextLine()) {
            Manager manager = new Manager();
            manager.fromCSV(inFile.nextLine());
            managers.add(manager);
            System.out.print(manager.getFio() + " " + manager.getEmail() + " " + manager.getPhone()
                    + " " + manager.salesToString() + "\n");

            statement.executeUpdate("INSERT INTO MANAGERS(fio, phone, email) VALUE ('"+ manager.getFio() + "', '"
                    + manager.getPhone() + "', '" + manager.getEmail() + "');");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MANAGERS;");

            while (resultSet.next()) {
                String fio = resultSet.getString("fio");
                System.out.println(fio);
            }
        }

        connection.close();
        fillSales(managers);
        fillSaleItems(managers);
        fillUsersSales(managers);
        return managers;
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
