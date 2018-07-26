package com.db.example.db.one.to.one.controllers;

import com.db.example.db.one.to.one.repositories.KlassRepository;
import com.db.example.db.one.to.one.repositories.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Klasses")
public class KlassController {
    @Autowired
    private KlassRepository klassRepository;

    @Autowired
    public LeaderRepository leaderRepository;


}
