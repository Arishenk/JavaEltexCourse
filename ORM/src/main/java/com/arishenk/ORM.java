package com.arishenk;

import com.arishenk.entity.Address;
import com.arishenk.entity.Passport;
import com.arishenk.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.LinkedList;
import java.util.List;

public class ORM {
    public static void main(String[] args) {
        User user1 = new User("Arisha", "8705", "arishenk@mail.ru");
        User user2 = new User("Masha", "8799", "mari@mail.ru");
        Passport passport = new Passport("Novatorov 6");
        Passport passport2 = new Passport("Kirova 6");
        Address address = new Address("Borisa Bogatkova 63/1");

        user2.setPassport(passport2);
        user1.setAddress(address);
        user2.setAddress(address);
        user1.setPassport(passport);
        passport.setUser(user1);

        List<User> userss = new LinkedList<>();
        userss.add(user1);
        userss.add(user2);
        address.setTenants(userss);


        // создание сервиса взаимодействия
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory;
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }

        // создание сессии (запись в БД)
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.save(passport);
        session.save(passport2);
        session.save(address);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        users.forEach(u -> System.out.println(String.format("%s, %s!",
                u.getFio(),
                u.getPhone())));
        session.getTransaction().commit();
        session.close();

    }
}
