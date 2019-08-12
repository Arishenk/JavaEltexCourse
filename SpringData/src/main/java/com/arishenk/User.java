package com.arishenk;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String fio;

    @Getter
    @Setter
    private String phone;

    public User(String fio, String phone) {
        this.fio = fio;
        this.phone = phone;
    }
}