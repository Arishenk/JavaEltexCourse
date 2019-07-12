package com.arishenk;

public abstract class User implements CSV, Comparable<User>, JSON {

    private String fio;
    private String phone;
    private String email;
    private Integer id;

    public User(String fio, String phone, String email) {
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

    public String toCSV() {
       return this.id + ";" + this.fio + ";" + this.phone + ";" + this.email + ";";
    }

    public void fromCSV(String str) {
        String[] lineFromCSV = str.split(";");
        this.id = Integer.parseInt(String.valueOf(lineFromCSV[0]));
        this.fio = String.valueOf(lineFromCSV[1]);
        this.phone = String.valueOf(lineFromCSV[2]);
        this.email = String.valueOf(lineFromCSV[3]);
    }

    @Override
    public int compareTo(User user) {
        return this.id.compareTo(user.id);
    }

    public boolean equals(User user) {
        return this.fio.equals(user.fio);
    }
}
