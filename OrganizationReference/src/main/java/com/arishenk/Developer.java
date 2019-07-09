package com.arishenk;

public class Developer extends User {

    private String[] languages;
    public Integer index = 0;
    public static int countIndex = 0;

    public Developer(String fio, String phone, String email, String[] languages) {
        super(fio, phone, email);
        this.languages = languages;
        index += countIndex;
        this.setId(index);
        countIndex++;
    }

    public Developer() {
        super();
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getLanguages() {
        return String.join(",", this.languages);
    }

    public String toCSV() {
        return super.toCSV() + String.join(",", languages) + "\n";
    }

    public void fromCSV(String str) {
        super.fromCSV(str);
        String[] lineFromCSV = str.split(";");
        String[] lan = lineFromCSV[lineFromCSV.length - 1].split(",");
        this.languages = lan;
    }
}