package com.arishenk;

public class Task<T extends User & CSV> {
    private T owner;

    public Task(T owner) {
        this.owner = owner;
    }

    public Task() {
    }

    public T getOwner() {return this.owner;}

    public void setOwner(T owner) { this.owner = owner;}

    public String toCSV() {
        String result;

        Class firstClass = owner.getClass();
        String firstClassName = firstClass.getName();
        if (firstClassName.equals("com.arishenk.Developer")) {
            Developer developer = (Developer)owner;
            result = "dev;";
            result += developer.toCSV();
        }
        else {
            Manager manager = (Manager)owner;
            result = "man;";
            result +=  manager.toCSV();
        }

        System.out.println(result);
        return result;
    }

    public String fromCSV(String str) {
        String[] lineFromCSV = str.split(";");
        if (lineFromCSV[0].equals("dev")) {
            Developer developer = new Developer();
            developer.fromCSV(str.replace("dev;", ""));
            this.owner = (T)developer;
            return "dev";
        }
        else {
            Manager manager = new Manager();
            manager.fromCSV(str.replace("man;", ""));
            this.owner = (T)manager;
            return "man";
        }
    }
}
