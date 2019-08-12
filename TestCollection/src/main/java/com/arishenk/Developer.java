package com.arishenk;

import java.util.Arrays;

public class Developer implements Comparable<Developer>{
    private String[] languages;
    private Integer index = 0;
    private static int countIndex = 0;
    private Integer id;
    private String fio;
    private String email;
    private String phone;

    public Developer(String fio, String phone, String email, String[] languages) {
        this.fio = fio;
        this.email = email;
        this.phone = phone;
        this.languages = languages;
        this.index = this.index + countIndex;
        this.id = this.index;
        ++countIndex;
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + "languages=" + Arrays.toString(this.languages) + "}";
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

    @Override
    public int compareTo(Developer developer) {
        return this.id.compareTo(developer.id);
    }
}
