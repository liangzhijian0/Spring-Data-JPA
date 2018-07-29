package com.db.example.db.n.to.n.controllers;

import com.db.example.db.n.to.n.dto.GroupsDTO;
import com.db.example.db.n.to.n.entities.Groups;
import com.db.example.db.n.to.n.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GroupController {
    @Autowired
    GroupRepository groupRepository;


    @PostMapping("/Groups")
    @Transactional
    public ResponseEntity save(@RequestBody Groups groups) {
        // System.out.println(groups.getUsers());
        groups.getUsers().forEach(users -> users.getGroups().add(groups));
        //System.out.println(groups.getUsers());
        groupRepository.save(groups);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/Groups")
    public List<GroupsDTO> getAllGroups(){
        return groupRepository.findAll().stream().map(item->new GroupsDTO(item)).collect(Collectors.toList());
    }

}
