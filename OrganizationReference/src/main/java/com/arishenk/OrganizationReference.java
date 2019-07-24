package com.arishenk;

import lombok.Cleanup;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class OrganizationReference {
    public static void main(String[] args) throws IOException, TypeException {
        DUMP _dump = new DUMP();
        LinkedList<Developer> developers = new LinkedList<Developer>();
        LinkedList<Manager> managers = new LinkedList<Manager>();
        LinkedList<Task<Developer>> users = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            developers.add(new Developer("Arina" + i, "999" + i, i + "aaa@gmail.com", new String[]{"C#", "Java"}));
        }

        for (int i = 0; i < 3; i++) {
            managers.add(new Manager("Masha" + i, "888" + i, i +"@gmail.com", new Sale[]{
                    new Sale(new String[]{"Name" + i, "Name" + i + 1}, 123.5 + i)}));
        }

        users.add(new Task(developers.get(0), "Task1"));
        printDevelopers(developers);
        printManagers(managers);
        writeDevelopers(developers);
        readDevelopers();
        writeManagers(managers);
        readManagers();
        writeTasks(users);
        readTasks();

        Developer dev = new Developer();
        dev.setFio("arishenk");
        dev.setEmail("email@email");
        dev.setPhone("9999");
        dev.setLanguages(new String[]{"c#", "java"});
        dev.setId(0);
        dev.toJSON("developer.json");
        Developer devFromFile = new Developer();
        devFromFile.fromJSON("developer.json");
        System.out.println(devFromFile.getId() + " " + devFromFile.getFio() + " " + devFromFile.getEmail());

        Manager man = new Manager();
        man.setFio("arr");
        man.setEmail("email@em");
        man.setPhone("777777");
        man.setId(2);
        man.setSales(new Sale[]{ new Sale(new String[]{"item"}, (double) 5)});
        man.toJSON("manager.json");

        Class cl = man.getClass();
        People pl = (People)cl.getAnnotation(People.class);
        System.out.println(pl.sex() + " " + pl.age() + " " + pl.mass());

        DUMP.toDB("managers.csv");
        DUMP.toDB("developers.csv");
        DUMP.writeUnion();
    }

    @SneakyThrows(IOException.class)
    public static void writeDevelopers(LinkedList<Developer> developers) {
        @Cleanup FileWriter fw = new FileWriter("developers.csv", true);
        for (Developer developer : developers)
            fw.write(developer.toCSV());

        fw.flush();
    }

    @SneakyThrows(IOException.class)
    public static <T extends User & CSV> void writeTasks(LinkedList<Task<T>> users) {
        @Cleanup FileWriter fw = new FileWriter("tasks.csv", true);
        for (Task<T> user : users)
            fw.write(user.toCSV());

        fw.flush();
    }

    @SneakyThrows(IOException.class)
    public static void readTasks() throws TypeException {
        @Cleanup FileReader fr = new FileReader("tasks.csv");
        @Cleanup Scanner inFile = new Scanner(fr);

        System.out.println("users: \n");
        while (inFile.hasNextLine()){
            Task<User> developer = new Task<>();
            String[] objType = developer.fromCSV(inFile.nextLine());

            if (objType[0] == "dev") {
                Developer dev = (Developer)developer.getOwner();
                System.out.print(objType[1] + " " + dev.toString() + "\n");
            }
            else if (objType[0] == "man") {
                Manager man = (Manager)developer.getOwner();
                System.out.print(objType[1] + man.toString() + "\n");
            }
            else
                throw new TypeException("Uncorrected type");
        }
    }

    @SneakyThrows(IOException.class)
    public static void writeManagers(LinkedList<Manager> managers) {
        @Cleanup FileWriter fw = new FileWriter("managers.csv", true);
        for (Manager manager : managers)
            fw.write(manager.toCSV());

        fw.flush();
    }

    @SneakyThrows(IOException.class)
    public static void readDevelopers() throws TypeException {
        @Cleanup FileReader fr = new FileReader("developers.csv");
        @Cleanup Scanner inFile = new Scanner(fr);
        System.out.println("developers: \n");

        while (inFile.hasNextLine()) {
            Developer developer = new Developer();
            developer.fromCSV(inFile.nextLine());
            System.out.print(developer.toString()+ "\n\n");
        }
    }

    @SneakyThrows(IOException.class)
    public static void readManagers() throws TypeException {
            @Cleanup FileReader fr = new FileReader("managers.csv");
            @Cleanup Scanner inFile = new Scanner(fr);
            System.out.println("managers: \n");

            while (inFile.hasNextLine()) {
                Manager manager = new Manager();
                manager.fromCSV(inFile.nextLine());
                System.out.print(manager.toString() + "\n");
            }
    }

    public static void printDevelopers(LinkedList<Developer> developers) {
        System.out.print("developers:\n");
        for (Developer element : developers) {
            System.out.print(element.toString() + "\n");
        }
    }

    public static void printManagers(LinkedList<Manager> managers) {
        System.out.print("managers:\n");
        for (Manager element : managers) {
            System.out.print(element.toString() + "\n");
        }
    }
}