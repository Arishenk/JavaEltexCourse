package com.arishenk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
@NoArgsConstructor
public class User {
    public User(String fio, String phone, String email) {
        this.fio = fio;
        this.email = email;
        this.phone = phone;
    }

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String fio;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String email;

    @Setter
    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="passport_id")
    private Passport passport;

    @Getter
    @Setter
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinTable (name="users_address")
    private Address address;
}
