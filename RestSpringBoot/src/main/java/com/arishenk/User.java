package com.arishenk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс представления пользователя
 * @author Arishenk
 * @version v1.0
 */
@Table(name="user")
public class User {
    public User(Integer id, String name, String phone, String[] lang) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.lang = lang;
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

    /** Поле языков */
    @Getter
    @Setter
    private String[] lang;
}