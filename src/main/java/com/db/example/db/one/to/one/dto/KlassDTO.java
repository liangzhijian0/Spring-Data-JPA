package com.db.example.db.one.to.one.dto;

import com.db.example.db.one.to.n.dto.EmployeeDTO;
import com.db.example.db.one.to.n.entities.Company;
import com.db.example.db.one.to.one.entities.Klass;
import com.db.example.db.one.to.one.entities.Leader;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class KlassDTO {
    private final Long id;
    private final String name;
    private final ZonedDateTime createDate;
    private final LeaderDTO leader;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public LeaderDTO getLeader() {
        return leader;
    }

    public KlassDTO(Klass klass) {
        this.id = klass.getId();
        this.name = klass.getName();
        this.createDate = klass.getCreatedDate();
        this.leader = new LeaderDTO(klass.getLeader());
    }
}
