package main.java.com;

import java.util.LinkedList;

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

        System.out.print("developers:\n");
        for (Developer element : developers) {
            System.out.print(element.getFio() + " " + element.getEmail() + " " + element.getPhone()
                    + " " + element.getLanguages() + "\n\n");
        }

    }
}
