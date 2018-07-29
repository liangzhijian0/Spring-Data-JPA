package com.db.example.db.n.to.n.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JoinTable(
            name = "users_groups",
            joinColumns =
                @JoinColumn(name="users_id", referencedColumnName="id"),
            inverseJoinColumns =
                @JoinColumn(name="groups_id",referencedColumnName="id"))
    @ManyToMany(cascade = CascadeType.ALL,targetEntity =Groups.class)
    private List<Groups> groups = new ArrayList<>();

    public Users(String name, List<Groups> groups) {
        this.name = name;
        this.groups = groups;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}
