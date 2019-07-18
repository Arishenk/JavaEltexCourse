package com.arishenk;

public class Task<T extends User & CSV> {
    private T owner;
    private String description;

    public Task(T owner, String description) {
        this.owner = owner;
        this.description = description;
    }

    public Task() {
    }

    public T getOwner() {return this.owner;}

    public void setOwner(T owner) { this.owner = owner;}

    public String getDescription() {return this.description;}

    public void setDescription(String description) {this.description = description;}

    public String toCSV() {
        String result;

        Class firstClass = owner.getClass();
        String firstClassName = firstClass.getName();
        if (firstClassName.equals("com.arishenk.Developer")) {
            Developer developer = (Developer)owner;
            result = "dev;" + this.description + ";";
            result += developer.toCSV();
        }
        else {
            Manager manager = (Manager)owner;
            result = "man;" + this.description + ";";
            result +=  manager.toCSV();
        }

        System.out.println(result);
        return result;
    }

    public String[] fromCSV(String str) throws TypeException {
        String[] result = new String[2];
        String[] lineFromCSV = str.split(";");
        String description = lineFromCSV[1];
        if (lineFromCSV[0].equals("dev")) {
            Developer developer = new Developer();
            developer.fromCSV(str.replace("dev;" + description + ";", ""));
            this.owner = (T)developer;
            result[0] = "dev";
            result[1] = description;
            return result;
        }
        else {
            Manager manager = new Manager();
            manager.fromCSV(str.replace("man;" + description + ";", ""));
            this.owner = (T)manager;
            result[0] = "man";
            result[1] = description;
            return result;        }
    }
}
