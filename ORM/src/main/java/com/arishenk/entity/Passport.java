package com.arishenk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "passports")
public class Passport {

    public Passport(String nameStreet) {
        this.registration = nameStreet;
    }

    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    @OneToOne(mappedBy = "passport")
    private User user;

    @Getter
    @Setter
    @Column(name = "registration")
    private String registration;
}