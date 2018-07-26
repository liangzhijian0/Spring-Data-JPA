package com.db.example.db.one.to.one.dto;

import com.db.example.db.one.to.one.entities.Klass;
import com.db.example.db.one.to.one.entities.Leader;

import java.time.ZonedDateTime;

public class LeaderDTO {
    private final Long id;
    private final String name;
    private final ZonedDateTime createDate;
    private final Long klassId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public Long getKlassId() {
        return klassId;
    }

    public LeaderDTO(Leader leader) {
        this.id = leader.getId();
        this.name = leader.getName();
        this.createDate = leader.getCreatedDate();
        this.klassId = leader.getKlass().getId();
    }
}
