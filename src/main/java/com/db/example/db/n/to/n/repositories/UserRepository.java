package com.db.example.db.n.to.n.repositories;

import com.db.example.db.n.to.n.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
