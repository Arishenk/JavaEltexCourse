package com.arishenk;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Table;

@Document
@Table(name="user")
public class User {
    public User(Integer id, String name, String phone, String[] lang) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.lang = lang;
    }

    @Id
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String[] lang;

}
