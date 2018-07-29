package com.db.example.db.n.to.n.dto;

import com.db.example.db.n.to.n.entities.Groups;

import java.util.List;
import java.util.stream.Collectors;

public class GroupsDTO {
    private final Long id;
    private final String name;
    private List<UsersDTO> usersDTOS;

    public GroupsDTO(Groups groups) {
        this.id = groups.getId();
        this.name = groups.getName();
        this.usersDTOS = groups.getUsers().stream().map(users -> new UsersDTO(users)).collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<UsersDTO> getUsersDTOS() {
        return usersDTOS;
    }

}
