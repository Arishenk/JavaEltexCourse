package main.java.com;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class OrganizationReference {

    public static void main(String[] args) {
        LinkedList<Developer> developers = new LinkedList<Developer>();
        LinkedList<Manager> managers = new LinkedList<Manager>();

        for (int i = 0; i < 3; i++) {
            developers.add(new Developer("Arina" + i, "999" + i, i + "aaa@gmail.com", new String[]{"C#", "Java"}));
        }

        for (int i = 0; i < 3; i++) {
            managers.add(new Manager("Masha" + i, "999" + i, "aaa@gmail.com", new Sale[]{
                    new Sale(new String[] {"Name1", "Name2"}, 123.5)}));
        }

        printDevelopers(developers);
        printManagers(managers);
        writeDevelopers(developers);
        readDevelopers();
        writeManagers(managers);
        readManagers();

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

        public static void readDevelopers() {

            try {
                FileReader fr = new FileReader("developers.csv");

                Scanner inFile = new Scanner(fr);

                System.out.println("developers: \n");
                while (inFile.hasNextLine()){
                    Developer developer = new Developer();
                    developer.fromCSV(inFile.nextLine());

                    System.out.print(developer.getFio() + " " + developer.getEmail() + " " + developer.getPhone()
                            + " " + developer.getLanguages() + "\n\n");
                }

                fr.close();
            } catch (IOException error) {
                System.err.println(error.getMessage());
            }
        }

    public static void readManagers() {

        try {
            FileReader fr = new FileReader("managers.csv");

            Scanner inFile = new Scanner(fr);

            System.out.println("managers: \n");
            while (inFile.hasNextLine()){
                Manager manager = new Manager();
                manager.fromCSV(inFile.nextLine());

                System.out.print(manager.getFio() + " " + manager.getEmail() + " " + manager.getPhone()
                        + " " + manager.getSales() + "\n");
            }

            fr.close();
        } catch (IOException error) {
            System.err.println(error.getMessage());
        }
    }

        public static void printDevelopers(LinkedList<Developer> developers) {
            System.out.print("developers:\n");
            for (Developer element : developers) {
                System.out.print(element.getFio() + " " + element.getEmail() + " " + element.getPhone()
                        + " " + element.getLanguages() + "\n");
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
