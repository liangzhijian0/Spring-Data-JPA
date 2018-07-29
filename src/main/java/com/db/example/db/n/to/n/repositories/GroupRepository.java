package com.db.example.db.n.to.n.repositories;

import com.db.example.db.n.to.n.entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Groups,Long> {
}
