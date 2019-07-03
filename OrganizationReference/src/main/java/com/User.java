package main.java.com;

public abstract class User {

    private String fio;
    private String phone;
    private String email;

    public User(String fio, String phone, String email) {
        this.fio = fio;
        this.email = email;
        this.phone = phone;
    }

    public void setFio(String tmpFio) {
        this.fio = tmpFio;
    }

    public String getFio() {
        return this.fio;
    }

    public void setPhone(String tmpPhone) {
        this.phone = tmpPhone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setEmail(String tmpEmail) {
        this.email = tmpEmail;
    }

    public String getEmail() {
        return this.email;
    }
}
