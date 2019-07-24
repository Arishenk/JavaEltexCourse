package com.arishenk;

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
            managers.add(new Manager("Masha" + i, "999" + i, "aaa@gmail.com", new Sale[]{
                    new Sale(new String[]{"Name1", "Name2"}, 123.5)}));
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

        DUMP.toDB("managers.csv");
        DUMP.toDB("developers.csv");
        DUMP.writeUnion();
    }

        public static void writeDevelopers(LinkedList<Developer> developers) {
            try {
                FileWriter fw = new FileWriter("developers.csv", true);

                for (Developer developer : developers)
                    fw.write(developer.toCSV());

                fw.flush();
                fw.close();
            } catch (IOException error) {
                System.err.println(error.getMessage());
            }
        }

    public static <T extends User & CSV> void writeTasks(LinkedList<Task<T>> users) {
        try {
            FileWriter fw = new FileWriter("tasks.csv", true);

            for (Task<T> user : users)
                fw.write(user.toCSV());

            fw.flush();
            fw.close();
        } catch (IOException error) {
            System.err.println(error.getMessage());
        }
    }

    public static void readTasks() throws TypeException {
        try {
            FileReader fr = new FileReader("tasks.csv");

            Scanner inFile = new Scanner(fr);

            System.out.println("users: \n");
            while (inFile.hasNextLine()){
                Task<User> developer = new Task<>();
                String[] objType = developer.fromCSV(inFile.nextLine());

                if (objType[0] == "dev") {
                    Developer dev = (Developer)developer.getOwner();
                    System.out.print(objType[1] + " " + dev.getFio() + " " + dev.getEmail() + " " + dev.getPhone()
                            + " " + dev.languagesToString() + "\n");
                }
                else if (objType[0] == "man") {
                    Manager man = (Manager)developer.getOwner();
                    System.out.print(objType[1] + man.getFio() + " " + man.getEmail() + " " + man.getPhone()
                            + " " + man.getSales() + "\n");
                }
                else
                    throw new TypeException("Uncorrected type");
            }

            fr.close();
        } catch (IOException error) {
            System.err.println(error.getMessage());
        }
    }

        public static void writeManagers(LinkedList<Manager> managers) {
        try {
            FileWriter fw = new FileWriter("managers.csv", true);

            for (Manager manager : managers)
                fw.write(manager.toCSV());

            fw.flush();
            fw.close();
        } catch (IOException error) {
            System.err.println(error.getMessage());
        }
    }

        public static void readDevelopers() throws TypeException {
            DUMP.ReadDevelopers();
        }

    public static void readManagers() throws TypeException {
        DUMP.ReadManagers();
    }

        public static void printDevelopers(LinkedList<Developer> developers) {
            System.out.print("developers:\n");
            for (Developer element : developers) {
                System.out.print(element.getFio() + " " + element.getEmail() + " " + element.getPhone()
                        + " " + element.languagesToString() + "\n");
            }
        }

        public static void printManagers(LinkedList<Manager> managers) {
            System.out.print("managers:\n");
            for (Manager element : managers) {
                System.out.print(element.getFio() + " " + element.getEmail() + " " + element.getPhone()
                        + " " + element.getSales() + "\n");
            }
        }
}
