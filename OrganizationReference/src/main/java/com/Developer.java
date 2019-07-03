package main.java.com;

public class Developer extends User {

    private String[] languages;

    public Developer(String fio, String phone, String email, String[] languages) {
        super(fio, phone, email);
        this.languages = languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getLanguages() {
        return String.join(",", this.languages);
    }
}
