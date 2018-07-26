package com.db.example.db.one.to.one.controllers;

import com.db.example.db.one.to.one.dto.KlassDTO;
import com.db.example.db.one.to.one.entities.Klass;
import com.db.example.db.one.to.one.entities.Leader;
import com.db.example.db.one.to.one.repositories.KlassRepository;
import com.db.example.db.one.to.one.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/klasses")
public class KlassController {
    @Autowired
    private KlassRepository klassRepository;

    @Autowired
    public LeaderRepository leaderRepository;

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public KlassDTO createKlass(@RequestBody Klass klass) {
        Leader leader = klass.getLeader();
        if(leader != null){
            leader.setKlass(klass);
        }
        return new KlassDTO(klassRepository.save(klass));
    }
}
