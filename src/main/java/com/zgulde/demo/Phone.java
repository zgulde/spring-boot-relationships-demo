package com.zgulde.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private double price;

    // Note that the type here is Company. This is another model we have created.
    @ManyToOne
    private Company manufacturer;

    @Column(nullable = false)
    private String model;

    @ManyToMany(mappedBy = "phones")
    private List<Carrier> carriers = new ArrayList<>();

    public Phone() { }

    public Phone(double price, Company manufacturer, String model) {
        this.price = price;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Company getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Company manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Carrier> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<Carrier> carriers) {
        this.carriers = carriers;
    }

}
