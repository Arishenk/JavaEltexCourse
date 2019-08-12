package com.arishenk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

public class User {
    public User(Integer id, String name, String phone) {
        this.id = id;
        this.phone = phone;
        this.name = name;
    }

    /** Поле идентификатора */
    @Id
    @Getter
    @Setter
    private Integer id;

    /** Поле ФИО */
    @Getter
    @Setter
    private String name;

    /** Поле телефона */
    @Getter
    @Setter
    private String phone;
}
