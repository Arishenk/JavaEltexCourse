package com.arishenk;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;

@NoArgsConstructor
public class User implements CSV, Comparable<User>, JSON {

    @Getter
    @Setter
    private String fio;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Integer id;

    public User(String fio, String phone, String email) {
        this.fio = fio;
        this.email = email;
        this.phone = phone;
    }

    public String toCSV() {
       return this.id + ";" + this.fio + ";" + this.phone + ";" + this.email + ";";
    }

    public void fromCSV(String str) throws TypeException {
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

    @Override
    public String toJSON(String str) throws IOException {
        return null;
    }

    @Override
    public void fromJSON(String str) throws IOException {

    }

    @Override
    public String toString() {
        return "User{" +
                "fio='" + fio + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
