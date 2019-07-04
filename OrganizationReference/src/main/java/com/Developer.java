package main.java.com;

public class Developer extends User {

    private String[] languages;

    public Developer(String fio, String phone, String email, String[] languages) {
        super(fio, phone, email);
        this.languages = languages;
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
