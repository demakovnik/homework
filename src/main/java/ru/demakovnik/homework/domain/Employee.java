package ru.demakovnik.homework.domain;

import javax.persistence.*;

@Entity
@Table(name = "empoyees")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String fullName;

    public Employee() {
    }

    public Employee(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
