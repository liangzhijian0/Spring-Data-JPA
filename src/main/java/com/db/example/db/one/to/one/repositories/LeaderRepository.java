package com.db.example.db.one.to.one.repositories;

import com.db.example.db.one.to.n.entities.Company;
import com.db.example.db.one.to.one.entities.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderRepository extends JpaRepository<Leader,Long> {

}
