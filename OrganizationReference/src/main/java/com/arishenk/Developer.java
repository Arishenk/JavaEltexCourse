package com.arishenk;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

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

    public String languagesToString() {
        return String.join(",", this.languages);
    }

    public String[] getLanguages() {
        return this.languages;
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

    @Override
    public String toJSON(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), this);
        return mapper.writeValueAsString(this);
    }

    @Override
    public void fromJSON(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Developer u2 = mapper.readValue(new File(fileName), Developer.class);
        this.setId(u2.getId());
        this.setLanguages(u2.languages);
        this.setPhone(u2.getPhone());
        this.setEmail(u2.getEmail());
        this.setFio(u2.getFio());
    }
}
