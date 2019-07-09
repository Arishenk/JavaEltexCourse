package com.arishenk;

public class User implements MyBean {
    private String fio;

    public User(String fio) {
        this.fio = fio;
    }

    @Override
    public void SetFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String getFio() {
        return this.fio;
    }
}
