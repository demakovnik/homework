package ru.demakovnik.homework.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends AbstractEntity {


    @Column(name = "seller", length = 9)
    private String seller;

    @Column(name = "customer", length = 9)
    private String customer;

    @OneToMany(mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Product> products;

    public Client() {
    }

    public Client(String seller, String customer, List<Product> products) {
        this.seller = seller;
        this.customer = customer;
        this.products = products;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
