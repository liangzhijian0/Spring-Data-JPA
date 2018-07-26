package com.db.example.db.one.to.one.controllers;

import com.db.example.db.one.to.one.dto.KlassDTO;
import com.db.example.db.one.to.one.entities.Klass;
import com.db.example.db.one.to.one.entities.Leader;
import com.db.example.db.one.to.one.repositories.KlassRepository;
import com.db.example.db.one.to.one.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

//    @Transactional
//    @GetMapping (path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public CompanyDTO getCompanyById(@PathVariable Long id){
//        return new CompanyDTO(companyRepository.findById(id).get());
//    }
}
