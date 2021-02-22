package com.zgulde.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carriers")
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "carriers_phones",
        joinColumns = {@JoinColumn(name = "carrier_id")},
        inverseJoinColumns = {@JoinColumn(name = "phone_id")}
    )
    private List<Phone> phones = new ArrayList<>();

    public Carrier(String name) {
        this.name = name;
    }

    public Carrier() {

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
