package ru.demakovnik.homework.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects", uniqueConstraints = {@UniqueConstraint(columnNames = "title", name = "projects_unique_title_idx")})
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_like",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees;

    public Project() {
    }

    public Project(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
