package com.db.example.db.n.to.n.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "groups",targetEntity = Users.class,fetch = FetchType.LAZY)
    private List<Users> users = new ArrayList<>();

    public Groups() {
    }

    public Groups(String name, List<Users> users) {
        this.name = name;
        this.users = users;
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

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
