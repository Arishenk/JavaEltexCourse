package com.arishenk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Address {

    public Address(String name) {
        this.streetName = name;
    }

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    @Column(name = "street_name")
    private String streetName;

    @Getter
    @Setter
    @ElementCollection
    @NotFound(action= NotFoundAction.IGNORE)
    @OneToMany(mappedBy="address", fetch=FetchType.EAGER)
    private List<User> tenants;
}
