package com.db.example.db.one.to.one.repositories;

import com.db.example.db.one.to.n.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KlassRepository extends JpaRepository<Company,Long> {

}
