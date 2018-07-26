package com.db.example.db.one.to.one.controllers;

import com.db.example.db.one.to.n.entities.Company;
import com.db.example.db.one.to.one.dto.KlassDTO;
import com.db.example.db.one.to.one.entities.Klass;
import com.db.example.db.one.to.one.entities.Leader;
import com.db.example.db.one.to.one.repositories.KlassRepository;
import com.db.example.db.one.to.one.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KlassDTO> getAllKlass(){
        return klassRepository.findAll().stream()
                .map(klass -> new KlassDTO(klass))
                .collect(Collectors.toList());
    }

    @Transactional
    @GetMapping (path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public KlassDTO getKlassById(@PathVariable Long id){
        Klass one = klassRepository.findById(id).get();
        if(one == null) return null;
        return new KlassDTO(one);
    }

    @Transactional
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable Long id,@RequestBody Leader leader) {
        long a = id;
        Klass klass = klassRepository.findById(id).get();
        klass.getLeader().setKlass(null);
        klass.setLeader(leader);
        leader.setKlass(klass);
        leaderRepository.save(leader);
        klassRepository.save(klass);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
