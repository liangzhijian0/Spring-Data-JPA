package com.db.example.db.n.to.n.dto;


import com.db.example.db.n.to.n.entities.Users;


import java.util.List;
import java.util.stream.Collectors;

public class UsersDTO {
    private final Long id;
    private final String name;
    private final List<Long> groupsId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Long> getGroupsId() {
        return groupsId;
    }

    public UsersDTO(Users users) {
        this.id = users.getId();
        this.name = users.getName();
        this.groupsId = users.getGroups().stream().map(item->item.getId()).collect(Collectors.toList());
    }
}
