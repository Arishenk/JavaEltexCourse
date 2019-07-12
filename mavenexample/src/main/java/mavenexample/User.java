package mavenexample;

public class User {
    private String fio;
    private String phone;
    private String email;
    private Integer id;

    public User(Integer id, String fio, String phone, String email) {
        this.id = id;
        this.fio = fio;
        this.email = email;
        this.phone = phone;
    }

    public User() {
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

    public Integer getId() { return this.id; }

    public void setId(Integer id) { this.id = id;}
}
