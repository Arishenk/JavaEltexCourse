package com.arishenk;

import com.arishenk.jook.Database.tables.Developers;
import com.arishenk.jook.Database.tables.records.DevelopersRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Jooq {
    public static void main(String[] args) throws SQLException, IOException {
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/main/resources/config.properties");
        property.load(fis);
        Connection connection = DriverManager.getConnection(property.getProperty("db.host"),
                property.getProperty("db.login"),
                property.getProperty("db.password"));
        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);

        Result<DevelopersRecord> developers = context.selectFrom(Developers.DEVELOPERS).fetch();
        //Result<DeveloperRecord> developers = context.selectFrom(Developer.DEVELOPER);
       //.where(Developer.DEVELOPER.ID.gt(5)
       //.and(Developer.DEVELOPER.FIO.like(«%Ivan%»))).limit(5).fetch();

        for (DevelopersRecord dev : developers) {
            System.out.println(dev.getFio());
        }

        context.insertInto(Developers.DEVELOPERS).set(Developers.DEVELOPERS.FIO, "Ivan")
                .set(Developers.DEVELOPERS.PHONE, "900").set(Developers.DEVELOPERS.EMAIL, "email@mail.ru")
                .execute();
        connection.close();
    }
}