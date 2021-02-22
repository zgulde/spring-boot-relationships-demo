package com.zgulde.demo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    // Note that the value of the mappedBy parameter is the name of the property on the
    // corresponding model.
    // Note that the type of this property is a List of Phones. This is because, while a phone is
    // manufactured by a single company, a company can manufacture multiple phones.
    @OneToMany(mappedBy = "manufacturer")
    private List<Phone> phones;

    public Company() { }

    public Company(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
